/**对话框**/
jQuery.fn.openDialog = function (options) {
    var __that = $(this);
    options = jQuery.extend({}, {
        title: options.title || "对话框",
        width: options.width || 800,
        height: options.height || 350,
        url: options.url || "",
        handler: options.handler || ''
    });
    var _that = $(__that);
    if (options.handler == '') {
        $(_that).dialog({
            title: options.title,
            width: options.width,
            height: options.height,
            minimizable: false,
            maximizable: false,
            collapsible: false,
            resizable: false,
            closed: false,
            cache: false,
            href: options.url,
            modal: true,
            shadow: false,
            buttons: [{
                text: "关闭",
                iconCls: 'icon-cancel',
                handler: function () {
                    $(_that).dialog('close');
                }
            }]
        });
    } else {
        $(_that).dialog({
            title: options.title,
            width: options.width,
            height: options.height,
            minimizable: false,
            maximizable: false,
            collapsible: false,
            resizable: false,
            closed: false,
            cache: false,
            href: options.url,
            modal: true,
            shadow: false,
            buttons: [{
                text: "确认",
                iconCls: 'icon-ok',
                handler: function () {
                    eval(options.handler);
                }
            }, {
                text: "取消",
                iconCls: 'icon-cancel',
                handler: function () {
                    $(_that).dialog('close');
                }
            }]
        });
    }

    $(_that).panel("move", {
        top:$(document).scrollTop() + ($(window).height() - options.height) * 0.5,
        left:$(document).scrollLeft() + ($(window).width() - options.width)*0.5
    });
}

jQuery.fn.editObj = function (options) {
    var _that = $(this);
    $.messager.defaults.ok = "确认";
    $.messager.defaults.cancel = "取消";
    options = $.extend({}, {
        url: options.url,
        dialog: options.dialog,
        grid: options.grid
    });

    if ($(_that).form("validate")) {
        $(_that).ajaxSubmit({
            url: options.url,
            dataType: "json",
            success: function (result) {
                if (result.code == 2000) {
                    $('#' + options.dialog).dialog('close');
                    $.messager.alert("提示", result.message, "info", function () {
                        if (options.grid && options.grid.indexOf("treegrid")>0) {
                            $('#' + options.grid).treegrid('reload');
                        } else {
                            $('#' + options.grid).datagrid('reload');
                        }
                    });
                } else {
                    $.messager.alert("提示", result.message, 'error');
                }
            },
            error: function (result) {
                $.messager.alert("提示", "失败，请重试！", 'error');
                $('#' + options.dialog).dialog('close');
            }
        });
    }
};

jQuery.fn.toEditObj = function (options) {
    var _that = this;
    options = $.extend({}, {
        title: options.title,
        url: options.url,
        grid: options.grid,
        width: options.width,
        height: options.height,
        readonly: options.readonlys,
        handler: options.handler
    });
    var rows = $('#' + options.grid).datagrid('getSelections');
    if (rows.length == 0) {
        $.messager.alert("提示", "请选择一行！", 'error');
    } else if (rows.length > 1) {
        $.messager.alert("提示", "请只选择一行！", 'error');
    } else {
        $(_that).openDialog({
            title: options.title,
            url: options.url + "?id=" + rows[0].id,
            width: options.width,
            height: options.height,
            handler: options.handler
        });
    }
};

jQuery.fn.toDetailObj = function (options) {
    var _that = $(this);
    options = $.extend({}, {
        title: options.title,
        url: options.url,
        grid: options.grid,
        width: options.width,
        height: options.height
    });
    var rows = $('#' + options.grid).datagrid('getSelections');
    if (rows.length == 0) {
        $.messager.alert("提示", "请选择一行！", 'error');
    } else if (rows.length > 1) {
        $.messager.alert("提示", "请只选择一行！", 'error');
    } else {
        $(_that).openDialog({
            title: options.title,
            url: options.url + "?id=" + rows[0].id,
            width: options.width,
            height: options.height
        });
    }
}

jQuery.fn.deleteObj = function (options) {
    $(this).confirmObj(options);
};

jQuery.fn.confirmObj = function (options) {
    var _that = $(this);
    $.messager.defaults.ok = "确定";
    $.messager.defaults.cancel = "取消";
    var _delete_that = _that;
    var tip = options.tip || '确定执行？';
    var url = options.url || '';
    var title = options.title || "操作";
    var rows = $(_that).datagrid('getSelections');
    if (rows.length == 0) {
        $.messager.alert("提示", "请选择一行", 'error');
        return;
    }else if (rows.length > 1) {
        $.messager.alert("提示", "请只选择一行！", 'error');
    }

    $.messager.confirm(title, tip, function (result) {
        if (result) {
            $.messager.progress({
                title: title,
                msg: '执行中……',
                text: ''
            });
            jQuery.ajax({
                "type": "post",
                "url": url,
                "dataType": "json",
                "data": {
                    id: rows[0].id
                },
                "success": function (result) {
                    if (result.code == 2000) {
                        $.messager.alert("执行成功", result.message, 'info', function () {
                            $(_delete_that).datagrid('reload');
                        });
                    } else {
                        $.messager.alert("执行失败", result.message, 'error');
                    }
                    $.messager.progress('close');
                },
                "error": function (value) {
                    $.messager.progress('close');
                    $.messager.alert("执行失败", "ERROR", 'error');
                }
            });
        }
    });
};

$.fn.datebox.defaults.formatter = function (date) {
    var y = date.getFullYear();
    var m = date.getMonth() + 1;
    var d = date.getDate();
    return y + '-' + m + '-' + d;
}

$.fn.datebox.defaults.parser = function (s) {
    var t = Date.parse(s);
    if (!isNaN(t)) {
        return new Date(t);
    } else {
        return new Date();
    }
}


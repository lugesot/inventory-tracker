(function () {

    $('#template_grid').datagrid({
        title: "模板列表",
        url: "getTemplates",
        method: 'post',
        nowrap: true,
        striped: true,
        fitColumns: true,
        pageSize: 15,
        collapsible: false,
        checkOnSelect: true,
        singleSelect: true,
        pagination: true,
        rownumbers: true,
        loadMsg: "正在载入，请稍后...",
        pageList: [15, 30, 50],
        columns: [
            [{
                field: 'id',
                width: '15%',
                title: "模板编号",
                align: 'center'
            }, {
                field: 'sysid',
                width: '15%',
                title: "系统",
                align: 'center'
            }, {
                field: 'templatename',
                width: '15%',
                title: "模板名",
                align: 'center'
            }, {
                field: 'template',
                width: '15%',
                title: "模板",
                align: 'center',
            }, {
                field: 'op',
                width: '23%',
                title: "操作",
                align: 'center',
                sortable: false,
                formatter: function (value, rowData, rowIndex) {
                    var html = "<a class='format_link_button' style='color: #e68900' href='javascript:to_edit_template()'>编辑</a>";
                    return html;
                }
            }
            ]
        ],
        toolbar: [
            {
                text: '添加模板',
                iconCls: 'icon-add',
                handler: 'to_add_template'
            }
        ],
        onLoadSuccess: function (data) {
            $(".format_link_button").linkbutton({
                plain: true
            });
            $('#template_grid').datagrid('fixRowHeight');
        }
    });

    $("#template_query_button").on('click', function () {
        $('#template_grid').datagrid('load', {
            sysid: $("#sysid").val()
        });
    });
})
();

function to_add_template() {
    $('#template_dialog').openDialog({
        title: "添加模板",
        url: "toAddTemplate",
        handler: "edit_template()",
        height: 210,
        width:360
    });
}

function to_edit_template() {
    $('#template_dialog').toEditObj({
        title: "修改模板",
        url: "toEditTemplate",
        grid: "template_grid",
        handler: "edit_template()",
        height: 210,
        width:360
    });
}

function edit_template() {
    $('#template_form').editObj({
        url: "doEditTemplate",
        dialog: "template_dialog",
        grid: "template_grid"
    });
}
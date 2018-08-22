$(function () {
    var Accordion = function (el, multiple) {
        this.el = el || {};
        this.multiple = multiple || false;
        var links = this.el.find('.link');
        links.on('click', {el: this.el, multiple: this.multiple}, this.dropdown)
    };

    Accordion.prototype.dropdown = function (e) {
        var $el = e.data.el;
        $this = $(this);
        $next = $this.next();

        $next.slideToggle();
        $this.parent().toggleClass('open');

        if (!e.data.multiple) {
            $el.find('.submenu').not($next).slideUp().parent().removeClass('open');
        }
    };

    var accordion = new Accordion($('#accordion'), false);

    $('.submenu li').click(function () {
        $(this).addClass('current').siblings('li').removeClass('current');
    });

    setLayoutHeight();
});

function addTab(subtitle, url) {
    $("#tabs").css({"height": document.documentElement.clientHeight - 100});
    if (!$('#tabs').tabs('exists', subtitle)) {
        $('#tabs').tabs('add', {
            title: subtitle,
            content: initFrame(url),
            closable: true,
            cache: true,
            fit: true
        });
    } else {
        var currTab = $('#tabs').tabs('getTab', subtitle);
        var href = currTab.panel('options').href;
        $('#tabs').tabs('update', {tab: currTab, options: {href: href, selected: true}});
        $('#tabs').tabs('select', subtitle);
    }
}

function initFrame(url) {
    if (url.indexOf("?") != -1) {
        var frame = "<iframe src =" + url + "&t=" + new Date().getTime() + " frameborder='0'  width='100%' height='100%'></iframe>";
        return frame;
    } else {
        var frame = "<iframe src =" + url + "?t=" + new Date().getTime() + " frameborder='0'  width='100%' height='100%'></iframe>";
        return frame;
    }
}

function setLayoutHeight() {
    var height = $(window).height();
    $("#main_layout").attr("style", "width:100%;height:" + height + "px");
    $("#main_layout").layout("resize", {
        width: "100%",
        height: height + "px"
    });
}
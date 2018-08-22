<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>CMS</title>
    <link id="easyuiTheme" rel="stylesheet" type="text/css"
          href="/static/css/easyui/themes/bootstrap/easyui.css">
    <link rel="stylesheet" type="text/css" href="/static/css/easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="/static/css/ystep/ystep.css">
    <script type="text/javascript" src="/static/js/jquery.min.js"></script>
    <script type="text/javascript" src="/static/js/jquery.form.js"></script>
    <script type="text/javascript" src="/static/js/easyui/jquery.easyui.min.js"></script>

</head>
<body>
<div>
    <div class="easyui-panel" title="查询" data-options="iconCls:'icon-search',collapsible:true"
         style="width: 100%;padding: 12px">
        <form id="tracker_query_form">
            <div class="row">
				<span>
					<lable>系统A：</lable>
	                <input type="text" id="sysid" class="easyui-textbox input" style="height:25px;"/>
				</span>

                <span>
					<lable>系统B：</lable>
	                <input type="text" id="sysid2" class="easyui-textbox input" style="height:25px;"/>
				</span>

                <span>
					<lable>sku：</lable>
	                <input type="text" id="sku" class="easyui-textbox input" style="height:25px;"/>
				</span>

                <span><a id="tracker_query_button" href="javascript:void(0)" class="easyui-linkbutton btn"
                         iconCls="icon-search">对比</a></span>
            </div>
        </form>
    </div>
    <div style="margin-top:10px;">
        <table id="tracker_grid" style="width: 100%">
        </table>
    </div>
</div>
<div id="tracker_dialog" class="dialog"></div>
<script type="text/javascript" src="/static/js/easyui/easyui-lang-zh_CN.js"></script>
<script src="/static/js/ystep.js"></script>
<script src="/static/script/jquery.fn.extend.js"></script>
<script src="/static/script/trackerList.js"></script>
<script src="/static/script/Date.extend.js"></script>
</body>
</html>

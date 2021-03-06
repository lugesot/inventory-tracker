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
    <script type="text/javascript" src="/static/js/jquery.min.js"></script>
    <script type="text/javascript" src="/static/js/jquery.form.js"></script>
    <script type="text/javascript" src="/static/js/easyui/jquery.easyui.min.js"></script>
</head>
<body>
<div>
    <div class="easyui-panel" title="查询" data-options="iconCls:'icon-search',collapsible:true"
         style="width: 100%;padding: 12px">
        <form id="template_query_form">
            <div class="row">
				<span>
					<lable>系统：</lable>
	                <input type="text" id="sysid" class="easyui-textbox input" style="height:25px;"/>
				</span>
                <span><a id="template_query_button" href="javascript:void(0)" class="easyui-linkbutton btn"
                         iconCls="icon-search">查询</a></span>
            </div>
        </form>
    </div>
    <div style="margin-top:10px;">
        <table id="template_grid" style="width: 100%">
        </table>
    </div>
</div>
<div id="template_dialog" class="dialog"></div>
<script type="text/javascript" src="/static/js/easyui/easyui-lang-zh_CN.js"></script>
<script src="/static/script/jquery.fn.extend.js"></script>
<script src="/static/script/templateList.js"></script>
<script src="/static/script/Date.extend.js"></script>
</body>
</html>

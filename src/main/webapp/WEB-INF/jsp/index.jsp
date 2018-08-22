<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>inventory-tracker</title>
    <link id="easyuiTheme" rel="stylesheet" type="text/css"
          href="/static/css/easyui/themes/bootstrap/easyui.css">
    <link rel="stylesheet" type="text/css" href="/static/css/easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="/static/css/index.css">
    <link rel="stylesheet" type="text/css" href="/static/css/default.css">
    <link rel="stylesheet" type="text/css" href="/static/css/leftnav.css">
    <link rel="stylesheet" type="text/css" href="/static/css/font-awesome.min.css">
    <script type="text/javascript" src="/static/js/jquery.min.js"></script>
    <script type="text/javascript" src="/static/js/jquery.form.js"></script>
    <script type="text/javascript" src="/static/js/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="/static/js/easyui/easyui-lang-zh_CN.js"></script>

    <style type="text/css">
        #tabs .tabs-panels > .panel > .panel-body {
            overflow: hidden;
        }
    </style>
</head>

<body>
<div id="main_layout" class="easyui-layout" style="width:100%;height:760px">
    <div data-options="region:'north',border:false" style="height:70px;background-color: #1f1f1f;" border="false">
        <div class="head-left">
            <img src="/static/images/logo.png" title="" alt="">
            <span>inventory-tracker</span>
        </div>
    </div>
    <div data-options="region:'west',split:true,border:false,title:'导航栏'" collapsed="false" style="width:150px;">
        <ul id="accordion" class="accordion">
            <li>
                <div class="link"><i class="fa fa-leaf"></i>系统菜单<i class="fa fa-chevron-down"></i></div>
                <ul class="submenu">
                    <li><a href="javascript:void(0)"
                           onclick="addTab('系统管理','/system/toSystemList')">系统管理</a>
                    </li>
                    <li><a href="javascript:void(0)"
                           onclick="addTab('模板管理','/template/toTemplateList')">模板管理</a>
                    </li>
                    <li><a href="javascript:void(0)"
                           onclick="addTab('库存对比','/tracker/toTrackerList')">库存对比</a>
                    </li>
                </ul>
            </li>
        </ul>
    </div>
    <div data-options="region:'center',border:false" style="height:100%">
        <div id="tabs" class="easyui-tabs" fit="true" border="false">
        </div>
    </div>
</div>
<script type="text/javascript" src="/static/script/index.js"></script>
</body>
</html>

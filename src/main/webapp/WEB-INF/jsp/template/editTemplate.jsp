<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<link rel="stylesheet" type="text/css" href="/static/css/default.css">
<div class="body-dialog">
    <form id="template_form" method="post">
        <input name="id" id="templateid" type="hidden" value="${template.id}">
        <div class="row">
            <label class="label">系统:</label>
            <input name="sysid" class="easyui-textbox" style="height:25px;" data-options="required:true"
                   value="${template.sysid}">
        </div>
        <div class="row">
            <label class="label">模板名:</label>
            <input name="templatename" class="easyui-textbox" style="height:25px;" data-options="required:true"
                   value="${template.templatename}">
        </div>
        <div class="row">
            <label class="label">模板:</label>
            <input name="template" class="easyui-textbox" style="height:25px;" data-options="required:true"
                   value="${template.template}">
        </div>
    </form>
</div>
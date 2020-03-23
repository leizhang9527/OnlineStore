<%--
  Created by IntelliJ IDEA.
  User: Decadence
  Date: 2020/3/22
  Time: 19:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
    String path = request.getContextPath();
%>
<html>
<head>
    <title>Title</title>
</head>
<head>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=no"/>
</head>

<body>
<div class="body-box">
    <table cellSpacing=1 cellPadding=4 width="100%" border=0>
        <tr bgcolor="#E7E7E7">
            <td height="15" colspan="15">&nbsp;行为记录管理&nbsp;</td>
        </tr>
        <tr align="center" bgcolor="#FAFAF1" height="16" style="font-size:14px" >
            <td ><font color=#000000>&nbsp;ID</font></td>
            <td ><font color=#000000>&nbsp;操作模块</font></td>
            <td ><font color=#000000>&nbsp;业务类型</font></td>
            <td ><font color=#000000>&nbsp;请求方法</font></td>
            <td ><font color=#000000>&nbsp;请求方式</font></td>
            <td ><font color=#000000>&nbsp;操作人员</font></td>
            <td ><font color=#000000>&nbsp;请求url</font></td>
            <td ><font color=#000000>&nbsp;操作地址</font></td>
            <td ><font color=#000000>&nbsp;请求参数</font></td>
            <td ><font color=#000000>&nbsp;操作状态</font></td>
            <td ><font color=#000000>&nbsp;返回参数</font></td>
            <td ><font color=#000000>&nbsp;错误消息</font></td>
            <td ><font color=#000000>&nbsp;操作时间</font></td>
            <td ><font color=#000000>&nbsp;开始时间</font></td>
            <td ><font color=#000000>&nbsp;结束时间</font></td>
        </tr>
        <s:iterator value="#request.logList" id="log">
            <tr align='center'  bgColor=#cccccc style="font-size:12px" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#cccccc';">
                <td ><font color=#000000>&nbsp;<s:property value="#log.operId"/></font></td>
                <td ><font color=#000000>&nbsp;<s:property value="#log.title"/></font></td>
                <td ><font color=#000000>&nbsp;<s:property value="#log.businessType"/></font></td>
                <td ><font color=#000000>&nbsp;<s:property value="#log.method"/></font></td>
                <td ><font color=#000000>&nbsp;<s:property value="#log.requestMethod"/></font></td>
                <td ><font color=#000000>&nbsp;<s:property value="#log.operName"/></font></td>
                <td ><font color=#000000>&nbsp;<s:property value="#log.operUrl"/></font></td>
                <td ><font color=#000000>&nbsp;<s:property value="#log.operIp"/></font></td>
                <td ><font color=#000000>&nbsp;<s:property value="#log.operParam"/></font></td>
                <td ><font color=#000000>&nbsp;<s:property value="#log.jsonResult"/></font></td>
                <td ><font color=#000000>&nbsp;<s:property value="#log.status"/></font></td>
                <td ><font color=#000000>&nbsp;<s:property value="#log.errorMsg"/></font></td>
                <td ><font color=#000000>&nbsp;<s:property value="#log.operTime"/></font></td>
                <td ><font color=#000000>&nbsp;<s:property value="#log.startTime"/></font></td>
                <td ><font color=#000000>&nbsp;<s:property value="#log.endTime"/></font></td>
            </tr>
        </s:iterator>
    </table>
</div>
</body>
</html>

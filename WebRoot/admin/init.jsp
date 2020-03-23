<%--
  Created by IntelliJ IDEA.
  User: Decadence
  Date: 2020/3/22
  Time: 21:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="org.apache.commons.lang3.StringUtils"%>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<%String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();%>
<%String contextPath = request.getContextPath();%>
<%String version = "20160401";%>


<script type="text/javascript">
    var hx = hx || {};
    hx.contextPath = '<%=contextPath%>';
    hx.basePath = '<%=basePath%>';
    hx.version = '<%=version%>';
    hx.pixel_0 = '<%=contextPath%>/style/images/pixel_0.gif';//0像素的背景，一般用于占位
</script>

<%-- 引入jQuery --%>
<%
    String User_Agent = request.getHeader("User-Agent");
    if (StringUtils.indexOfIgnoreCase(User_Agent, "MSIE") > -1 && (StringUtils.indexOfIgnoreCase(User_Agent, "MSIE 6") > -1 || StringUtils.indexOfIgnoreCase(User_Agent, "MSIE 7") > -1 || StringUtils.indexOfIgnoreCase(User_Agent, "MSIE 8") > -1)) {
        out.println("<script src='" + contextPath + "/admin/js/jquery-1.9.1.js' type='text/javascript' charset='utf-8'></script>");
    } else {
        out.println("<script src='" + contextPath + "/admin/js/jquery-2.0.3.js' type='text/javascript' charset='utf-8'></script>");
    }
%>
<%-- 引入EasyUI --%>
<link id="easyuiTheme" rel="stylesheet" href="<%=contextPath%>/admin/js/jquery-easyui-1.3.4/themes/default/easyui.css" type="text/css">
<link rel="stylesheet" href="<%=contextPath%>/admin/js/jquery-easyui-1.3.4/themes/icon.css" type="text/css">
<script type="text/javascript" src="<%=contextPath%>/admin/js/jquery-easyui-1.3.4/jquery.easyui.min.js" charset="utf-8"></script>
<script type="text/javascript" src="<%=contextPath%>/admin/js/jquery-easyui-1.3.4/locale/easyui-lang-zh_CN.js" charset="utf-8"></script>
<%-- 引入EasyUI Portal插件 --%>
<link rel="stylesheet" href="<%=contextPath%>/admin/js/jquery-easyui-portal/portal.css" type="text/css">
<script type="text/javascript" src="<%=contextPath%>/admin/js/jquery-easyui-portal/jquery.portal.js" charset="utf-8"></script>
<%-- 引入easyui扩展 --%>
<script src="<%=contextPath%>/admin/js/hxExtEasyUI.js?version=<%=version%>" type="text/javascript" charset="utf-8"></script>
<%-- 引入扩展图标 --%>
<link rel="stylesheet" href="<%=contextPath%>/admin/style/hxExtIcon.css?version=<%=version%>" type="text/css">
<%-- 引入自定义样式 --%>
<link rel="stylesheet" href="<%=contextPath%>/admin/style/hxExtCss.css?version=<%=version%>" type="text/css">
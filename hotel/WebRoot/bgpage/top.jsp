<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'top.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body style="background-image:url(images/bgtop.jpg)">
		<h1 style="margin-top:22px;margin-left:70px"><font color="#000000" size="7">酒店结算系统</font></h1>
	<div style="width:250px;height:30px;margin-top:-6px;margin-left:1050px">
		  <%--<c:if test="${username == null }">
  	      <a href="front/login.jsp" style="text-decoration:none"><font color=#ff0000 size="5">亲，请登录</font></a>
          </c:if>
          <c:if test="${username != null }">
  	       ${username }
          </c:if>
          --%><a href="" style="text-decoration:none"><font color=#000000 size="5">个人信息</font></a>
		</div>
     </body>
</html>

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
    
    <title>My JSP 'updateUser.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   <center>
      <table border="1" style="width:900px">
    	<tr>
    		<td>编号</td>
    		<td>用户姓名</td>
    		<td>用户权限</td>
    		<td>操作</td>
    		
    		
    	</tr>
    	
    	<c:forEach items="${uList}" var="User" >
    		
    		<tr>
    			<td>${User.id}</td>
    			<td>${User.name}</td>
    			<td>${User.permissions}</td>
    			<td><a href="queryUserById.do?id=${User.id}">修改信息</a>
    			</td>
    		
    		</tr>
    		
    	</c:forEach>
    
      </table>
      
      
    </center>
  </body>
</html>

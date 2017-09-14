<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'menu.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body bgcolor="#eeeeee">
       <div style="width:100%;height:400px">
            <div style="width:100%;height:50px;margin-top:5px;background:#00ff00;text-align:center;line-height:48px;">
              <a href="showUser.do" target="bottom_right"><font color="#0000FF" size="5">用户管理</font></a>
            </div>
            <div style="width:100%;height:50px;margin-top:5px;background:#00ff00;text-align:center;line-height:48px;">
              <a href="showUserUpdate.do" target="bottom_right"><font color="#0000FF" size="5">权限管理</font></a>
            </div>
            <div style="width:100%;height:50px;margin-top:5px;background:#00ff00;text-align:center;line-height:48px;">
              <a href="bgpage/date.jsp" target="bottom_right"><font color="#0000FF" size="5">数据备份</font></a>
            </div>
            <div style="width:100%;height:50px;margin-top:5px;background:#00ff00;text-align:center;line-height:48px;">
              <a href="" target="bottom_right"><font color="#0000FF" size="5">系统设置</font></a>
            </div>
            
       
       
       </div>
       
		
		
	  
  </body>
</html>

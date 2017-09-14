<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'date.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript"> 

function browseFolder() {
	
	//var path= document.getElementById("path").value;
	//var path=application.getRealPath(request.getRequestURI("paht"));alert(path);
	alert("开始备份数据库")
	window.location.href = "dateBeifen.do?";
	//window.location.href = "formdateBeifen.do?";
	alert("数据库备份完成");
}
function back() {
	alert("开始恢复数据库");
	window.location.href = "backBeifen.do"
	alert("数据库已恢复");
}

</script>
  </head>
  
  <body>
 
<%--<div style="margin-left: 100px;margin-top:50px">
<form action="formdateBeifen.do" method="post" enctype="multipart/form-data">
   选择要备份到的文件<input type="file" name="rpath"/><br/>
              
              <input type="submit" value="确认备份"/>
 </form>
</div>

<div style="margin-left: 100px;margin-top:150px">
<form action="formdateBeifen.do" method="post" enctype="multipart/form-data">
   选择恢复到的数据库名称<input type="text" name="name"/><br/>
              
              <input type="submit" value="确认恢复"/>
 </form>
</div>
--%><%--备份到后台指定文件夹 --%>
   
    <div style="margin-left: 100px;margin-top:50px">
                      备分数据库
        <input type="button" onclick="browseFolder()"value="备份"/>
    </div>
    <div style="margin-left: 100px;margin-top:150px">
       恢复数据库<input type="button" onclick="back()"value="还原"/>
    </div>
    
 </body>
</html>

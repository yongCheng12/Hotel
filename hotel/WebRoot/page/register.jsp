<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'querytotal.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="css/p_main.css" />
	<link rel="stylesheet" type="text/css" href="css/login.css">
		<script type="text/javascript">
function changeColor(num) {

	document.getElementById("middlediv" + num).style.background = "#FC4C03";
}
function changeColorBefore(num) {

	document.getElementById("middlediv" + num).style.background = "#eeeeee";
}
</script>

  </head>
  
  <body style="background-image: url(images/managerbody.jpg">
		<div class="topdiv">
		   <div class="welcomediv"><font size="6" color=#FC4C03>中小型酒店结算系统！</font></div>
		</div>
		<div class="middlediv">
			<div class="middle-login" id="middlediv1"
				onmouseover="changeColor(1)" onmouseout="changeColorBefore(1)">
				<a href="page/login.jsp"><font size="4">请登录</font> </a>
			</div>
			<div class="middle-register" id="middlediv2"
				onmouseover="changeColor(2)" onmouseout="changeColorBefore(2)">
				<a href="page/register.jsp"><font size="4">注册</font> </a>
			</div>
        </div>
		<div class="bottomdiv">
			 <div style="width:100%;height:500px;background:url(images/register.jpg)">
            <div style="width:350px;height:350px;margin-left:850px;padding-top:150px;position:absolut">
               <form action="rigister.do" method="post" enctype="application/x-www-form-urlencoded">
                  <div class="denglu" id="denglu">
                            <img src="images/zhanghao.png">
                           <input type="text" name="name"  placeholder="用户名"  style="width:190px;height:41px;float:left;position:absolute"/>
                        </div>
                        <div class="mima" id="mima" >
                             <img src="images/mima.png" >
                            <input type="password" name="password" placeholder="密码" style="width:190px;height:41px;float:left;position:absolute"/>
                        </div>
                        <div style="margin-left:90px;margin-top:15px">
                             <c:if test="${tishi != null }">
  	                         ${tishi }
                             </c:if>
                        </div>    
                        <div class="butten">
                            <input type="submit" value="注册" style="width:230px;height:41px;background-color:#FC4C03; border-radius: 7px"/>
                        </div>
               
                
               </form>
            </div>
       </div>
		</div>
	
	</body>
</html>

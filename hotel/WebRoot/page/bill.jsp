<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'consumer.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="css/settement.css" />
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
		<div class="topdiv"></div>
		<div class="middlediv">
			<div class="middle-login" id="middlediv1"
				onmouseover="changeColor(1)" onmouseout="changeColorBefore(1)">
				<c:if test="${username == null }">

					<a href="page/login.jsp"><font size="4">请登录</font> </a>
				</c:if>

				<c:if test="${username != null }">
  	             ${username }
                </c:if>
			  </div >
			<div class="middle-register" id="middlediv2"
				onmouseover="changeColor(2)" onmouseout="changeColorBefore(2)">
				<a href="mainPage.do?name=${username }"><font size="4">首页</font> </a>
			</div >
			
			

			<div class="middle-personal" id="middlediv3"
				onmouseover="changeColor(3)" onmouseout="changeColorBefore(3)">
				<a href=""><font size="4">个人信息</font> </a>
			</div>
		</div>
		<div class="bottomdiv">
			<div class="bottom-div">
			  <div class="bottom-left" style="width: 1010px">
			       <div class="bottom-left-top">
						<div style="margin-left:400px;margin-top: 30px;position:absolute">
							<font size="5">消费信息如下</font>
						</div>
				   </div>
				   <div style="margin-left:160px">
					
						  <table style="font-size:20px;border-spacing:35px 22px;">
						      <tr>
						          <td>房间号：</td>
						          <td>${bill.roomcode}</td>
						       </tr>
						       <tr>
						          <td>姓名：</td>
						          <td>${bill.customer}</td>
						          <td>身份证：</td>
						          <td>${bill.idcard}</td>
						       </tr>
						       <tr>
						          <td>房费：</td>
						          <td>${bill.r_money}</td>
						          <td>餐饮消费：</td>
						          <td>${bill.foodbeverage}</td>
						      </tr>
						      <tr>
						          <td>其他：</td>
						          <td>${bill.other}</td>
						      </tr>
						      <tr>
						          <td>总计：</td>
						          <td>${bill.totle}</td>
						      </tr>
						       <tr>
						          <td>时间：</td>
						          <td>${bill.time}</td>
						      </tr>
						      <tr>
						          <td>状态：</td>
						          <td>${bill.state}</td>
						          <td>收银员：</td>
						          <td>${bill.uname}</td>
						          
						      </tr>
						  </table>	
						
				   </div>
				</div>
				
				
			</div>
		</div>
		<div class="footdiv"></div>
	</body>
</html>

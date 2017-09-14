<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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
			</div>
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
				<div
					style="width: 990px; height: 500px; margin-left: 20px; background: #EEEEEE">
					<div
						style="width: 800px; height: 400px; margin-left: 70px; padding-top: 30px">
						<center>
							<form action="updatePersonal.do" method="post">
							 <div style="width: 500px; height: 400px">
							   <table style="font-size:20px;border-spacing:50px 25px;">
							      <tr>
							         <td> 账号名：</td>
							         <td><input type="text" name="uname" value="${personal.uname}" readonly/></td>
							      </tr>
							      <tr>
							         <td>姓名：</td>
							         <td><input type="text" name="name" value="${personal.name}"/></td>
							      </tr>
							      <tr>
							         <td>年龄：</td>
							         <td><input type="text" name="age" value="${personal.age}"/></td>
							      </tr>
							      <tr>
							         <td>性别：</td>
							         <td><input type="text" name="sex" value="${personal.sex}"/></td>
							      </tr>
							      <tr>
							         <td>身份证：</td>
							         <td><input type="text" name="idcard" value="${personal.idcard}"/></td>
							      </tr>
							      <tr>
							         <td>地址：</td>
							         <td><input type="text" name="address" value="${personal.address}"/></td>
							      </tr>
							      <tr>
							         <td>电话：</td>
							         <td><input type="text" name="tel" value="${personal.tel}"/></td>
							      </tr>
							   </table>
							</div><%--
							 <div style="height:170px;width:135px;margin-left:560px;margin-top:50px;background:#ffffff;float:left">
							         
							            选择照片<input type="file" name="photo" >  
							  </div>
								--%><input type="submit" value="修改信息"
									style="width: 75px; height: 35px; margin-left: 250px" />
							</form>
						</center>
					</div>
				</div>
			</div>
		</div>
		<div class="footdiv"></div>
	</body>
</html>

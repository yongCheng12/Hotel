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

		<title>My JSP 'main.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<link rel="stylesheet" type="text/css" href="css/p_main.css" />
		<script type="text/javascript">
function changeColor(num) {

	document.getElementById("middlediv" + num).style.background = "#FC4C03";
}
function changeColorBefore(num) {

	document.getElementById("middlediv" + num).style.background = "#00eeee";
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
			<div class="middle-personal" id="middlediv3"
				onmouseover="changeColor(3)" onmouseout="changeColorBefore(3)">
				<a href="queryPersonal.do?uname= ${username }"><font size="4">个人信息</font> </a>
			</div>
		</div>
		<div class="bottomdiv">
			<div class="bottom-div">
				<div class="bottom-left">
					<div class="bottom-left-top">
						<div class="manager">
							<font size="5">管理模块业务</font>
						</div>
					</div>
					<div class="bottom-left-bottom">
						<div class="consumer" id="middlediv4" onmouseover="changeColor(4)"
							onmouseout="changeColorBefore(4)">
							<a href="page/consumer.jsp"><font size="4">消费统计</font> </a>
						</div>
						<div class="settement" id="middlediv5"
							onmouseover="changeColor(5)" onmouseout="changeColorBefore(5)">
							<a href="page/settement.jsp"><font size="4">客户结算</font> </a>
						</div>
						<div class="showinfo" id="middlediv6" onmouseover="changeColor(6)"
							onmouseout="changeColorBefore(6)">
							<a href="page/showinfo.jsp"><font size="4">打印单据</font> </a>
						</div>
						<div class="dayaccount" id="middlediv7"
							onmouseover="changeColor(7)" onmouseout="changeColorBefore(7)">
							<a href="dayBill.do?uname= ${username }"><font size="4">每日记账</font> </a>
						</div>
						<div class="querytotal" id="middlediv8"
							onmouseover="changeColor(8)" onmouseout="changeColorBefore(8)">
							<a href="queryDayByPage.do"><font size="4">查询汇总</font> </a>
						</div>
						<div class="printlist" id="middlediv9"
							onmouseover="changeColor(9)" onmouseout="changeColorBefore(9)">
							<a href="printlist.do"><font size="4">报表打印</font> </a>
						</div>
					</div>
				</div>
				
			</div>
		</div>
		<div class="footdiv"></div>
	</body>
</html>

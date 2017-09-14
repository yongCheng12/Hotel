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
    
    <title>My JSP 'printlist.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="css/settement.css" />
	<style>
td {
	border: 1px solid;
	width:140px;
}
tr{
 height:43px;
 }
</style>
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
				<div class="printlist">
				   <div style="margin-left:370;margin-top:30px">
	                  <font size="5">营业收入报表</font>			   
				   </div>
				   <div style="margin-top:40px">
				   <center>
				       <table style="font-size: 15px; border: 1px solid; border-collapse: collapse">
				           <tr>
				              <td>项目</td>
				              <td>今日收入</td>
				              <td>本月收入</td>
				              <td>上月收入</td>
				              <td>本年收入</td>
				           </tr>
				            <tr>
				              <td>客房收入</td>
				              <td>${dbill.d_r_money}</td>
				              <td>${monthBill.m_r_money}</td>
				              <td>${monthBill.l_r_money}</td>
				              <td>${yearBill.y_r_money}</td>
				           </tr>
				            <tr>
				              <td>餐饮收入</td>
				              <td>${dbill.d_foodbeverage}</td>
				              <td>${monthBill.m_foodbeverage}</td>
				              <td>${monthBill.l_foodbeverage}</td>
				              <td>${yearBill.y_foodbeverage}</td>
				           </tr>
				            <tr>
				              <td>其他收入</td>
				              <td>${dbill.d_other}</td>
				              <td>${monthBill.m_other}</td>
				              <td>${monthBill.l_other}</td>
				              <td>${yearBill.y_other}</td>
				           </tr>
				            <tr>
				              <td>共计收入</td>
				              <td>${dbill.d_totle}</td>
				              <td>${monthBill.m_totle}</td>
				              <td>${monthBill.l_totle}</td>
				              <td>${yearBill.y_totle}</td>
				           </tr>
				            <tr>
				              <td>实际收入</td>
				              <td>${dbill.realtotle}</td>
				              <td>${monthBill.m_realtotle}</td>
				              <td>${monthBill.l_realtotle}</td>
				              <td>${yearBill.y_realtotle}</td>
				           </tr>
				            <tr>
				              <td>支出</td>
				              <td>${dbill.spending}</td>
				              <td>${monthBill.m_spending}</td>
				              <td>${monthBill.l_spending}</td>
				              <td>${yearBill.y_spending}</td>
				           </tr>
				       </table>
				       </center>
				   </div>
				   <div style="margin-left:650px;margin-top:20px">
				   打印日期：${Time}
				   </div>
				</div>
			</div>
		</div>
		<div class="footdiv"></div>
	</body>
</html>

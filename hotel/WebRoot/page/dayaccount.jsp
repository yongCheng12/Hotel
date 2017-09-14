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
    
    <title>My JSP 'dayaccount.jsp' starting page</title>
    
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
 td{
 width:150px;
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
				<div class="bottom-left" style="width: 1010px">
					<div class="bottom-left-top">
						<div style="margin-left:410px;margin-top: 30px;position:absolute">
							<font size="5">今日账单</font>
						</div>
				   </div>
				   <div style="margin-left:170px">
					     <form action="updateDaybill.do" method="post">
						  <table style="font-size:20px;border-spacing:.0px 35px;">
						      <tr>
						          <td>住房消费总额：</td>
						          <td>${dlist.d_r_money}</td>
						          <td>餐饮消费总额：</td>
						          <td>${dlist.d_foodbeverage}</td>
						       </tr>
						       <tr>
						          <td>其他消费总额：</td>
						          <td>${dlist.d_other}</td>
						          <td><input type="hidden" name="time" value="${dlist.time}"/></td>
						       </tr>
						       <tr>
						          <td>总计收入金额：</td>
						          <td>${dlist.d_totle}</td>
						          <td>实际收入金额：</td>
						          <td><input type="text" name="realtotle"/></td>
						      </tr>
						      <tr>
						          <td>总支出金额：</td>
						          <td><input type="text" name="spending"/></td>
						      </tr>
						      <tr>
						          <td>备注：</td>
						          <td><input type="text" name="remark"/></td>
						      </tr>
						  </table>	
						  <center>
						    <input type="submit" value="添加" style="width: 75px; height: 35px"/>
						  </center>
						 </form>
				   </div>
						
					
				</div>
			</div>
		</div>
		<div class="footdiv"></div>
	</body>
</html>

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
	<style>
td{
border: 1px solid ;
width:85px;
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
				  <div class="bottom-left-top" >
					 <div class="queryCustomer">
					   <div style="margin-left:280px;margin-top: 30px;position:absolute">
						<form action="showinfo.do" method="post">
						                        姓名<input type="text" name="customer" />
						                        身份证<input type="text" name="idcard" />
						       <input type="submit" value="确认"/>
						       <c:if test="${tishi!= null }">
  	                                     ${tishi }
                               </c:if>
						   </form>
						   </div>
					</div>
				  </div>
				  <div class="showinfo">
				    <center>
				     <table style="font-size: 20px;border:1px solid ;border-collapse:collapse">
				       <tr >
				          <td>房号</td>
				          <td>姓名</td>
				          <td>身份证</td>
				          <td>房费</td>
				          <td>餐饮消费</td>
				          <td>其他消费</td>
				          <td>共计消费</td>
				          <td style="width:130px">时间</td>
				          <td>收银员</td>
				       </tr>
				       
				       <c:forEach items="${bList}" var="Bill" >
    		           <tr>
    			         <td>${Bill.roomcode}</td>
    			         <td>${Bill.customer}</td>
    			         <td>${Bill.idcard}</td>
    			         <td>${Bill.r_money}</td>
    			         <td>${Bill.foodbeverage}</td>
    			         <td>${Bill.other}</td>
    			         <td>${Bill.totle}</td>
    			         <td style="width:130px">${Bill.time}</td>
    			         <td>${Bill.uname}</td>
    		          </tr>
    	              </c:forEach>
				     </table>
				     </center>
				  </div>
			</div>
		</div>
		<div class="footdiv"></div>
	</body>
</html>

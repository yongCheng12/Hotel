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
		<%--<link rel="stylesheet" type="text/css" href="css/p_main.css" />
			--%><link rel="stylesheet" type="text/css" href="css/settement.css" />
		<script type="text/javascript">
function changeColor(num) {

	document.getElementById("middlediv" + num).style.background = "#FC4C03";
}
function changeColorBefore(num) {

	document.getElementById("middlediv" + num).style.background = "#eeeeee";
}

function test(){
var str=document.all.state.value;
document.all.bill.submit();
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
					
						<center>
							<form action="addsettlement.do?uname=${username}" method="post" name="bill">
								<table style="font-size:20px;border-spacing:45px 24px;margin-top:50px">
								  <tr>
								     <td>房号：</td>
								     <td><input type="text" name="roomcode" /></td>
								     <td>
								        <c:if test="${tishi != null }">
  	                                    ${tishi }
                                        </c:if>
								     </td>
								  </tr>
								  <tr>
								     <td>姓名：</td>
								     <td><input type="text" name="customer" /></td>
								     <td>身份证：</td>
								     <td><input type="text" name="idcard" /></td>
								  </tr>
								   <tr>
								     <td>房费：</td>
								     <td><input type="text" name="r_money" /></td>
								      <td>餐饮消费：</td>
								     <td><input type="text" name="foodbeverage" /></td>
								  </tr>
								  <tr>
								     <td>其他消费：</td>
								     <td><input type="text" name="other" /></td>
								  </tr>
								  <tr>
								     <td>备注：</td>
								     <td><input type="text" name="remark" /></td>
								  </tr>
								  <tr>
								     <td>账单状态：</td>
								     <td>
								      <select name="state" style="margin-left:80px;width:92px;height:25px">
									  <option value="未结算" >
										未结算
									  </option>
									  <option value="已结算">
										已结算
									  </option>
									
								      </select>
								    </td>
								  </tr>
								</table>
								<input type="submit" value="添加消费"
									style="width: 75px; height: 35px; margin-left: 370px" />
					
							</form>
						</center>
					
				</div>
			</div>
		</div>
		<div class="footdiv"></div>
	</body>
</html>

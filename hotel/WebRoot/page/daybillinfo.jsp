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

		<title>My JSP 'querytotal.jsp' starting page</title>

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
	width: 85px;
}
tr{
 height:37px;
 }
</style>
		<script type="text/javascript">
		var dTime=$G("dTime"); 
function changeColor(num) {

	document.getElementById("middlediv" + num).style.background = "#FC4C03";
}
function changeColorBefore(num) {

	document.getElementById("middlediv" + num).style.background = "#eeeeee";
}
function pageUp() {
	//alert("bill上一页");
	var time=document.getElementById("time").value;
	var nowPage = document.getElementById("nowPage").value;
	if (nowPage == 1) {
		alert("已经是第一页了!");
	}
	//跳转到controller中.href="pageUp.do?nowPage="+nowPage;
	//var url="pageUp.do";
	//url+="?nowPage="+nowPage;
	//window.self.location=url;
	window.location.href = "billPageUp.do?nowPage=" + nowPage+"&&dTime="+time;

}

function pageDown() {
	//alert("下一页");
	//alert("上一页");
    var time=document.getElementById("time").value;
	var nowPage = document.getElementById("nowPage").value;
	//跳转到controller中href="pageDown.do?nowPage="+nowPage;
	//alert(nowPage);
	//var url = "pageDown.do";
	//url += "?nowPage=" + nowPage;
	//window.self.location = url;
	//alert(time);
	window.location.href="billPageDown.do?nowPage="+nowPage+"&&dTime="+time;
	//alert("bill下一页");
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
				<a href="mainPage.do?name=${username }"><font size="4">首页</font>
				</a>
			</div>

			<div class="middle-personal" id="middlediv3"
				onmouseover="changeColor(3)" onmouseout="changeColorBefore(3)">
				<a href=""><font size="4">个人信息</font> </a>
			</div>
		</div>
		<div class="bottomdiv">
			<div class="bottom-div">
				
				<div class="showdaybillinfo">
				   <div style="margin-top: 25px">
					<center>
						<table
							style="font-size: 15px; border: 1px solid; border-collapse: collapse">
							<tr>
								<td>
									房号
								</td>
								<td>
									顾客姓名
								</td>
								<td>
									身份证
								</td>
								<td>
									住房消费
								</td>
								<td>
									餐饮消费
								</td>
								<td>
									其他消费
								</td>
								<td>
									共计金额
								</td>
								<td>
									结账日期
								</td>
								<td>
									收银员
								</td>
								<td>
									备注
								</td>
							</tr>

							<c:forEach items="${bList}" var="Bill">
								<tr>
									<td>
										${Bill.roomcode}
									</td>
									<td>
										${Bill.customer}
									</td>
									<td>
										${Bill.idcard}
									</td>
									<td>
										${Bill.r_money}
									</td>
									<td>
										${Bill.foodbeverage}
									</td>
									<td>
										${Bill.other}
									</td>
									<td>
										${Bill.totle}
									</td>
									<td>
										${Bill.time}
									</td>
									<td>
										${Bill.uname}
									</td>
									<td>
										${Bill.remark}
									</td>
									
								</tr>
							</c:forEach>
						</table>
					</center>
				 </div>
				</div>
				<div class="page" style="margin-top: 440px; margin-left: 430;position:absolute">
					<input type="button" value="上一页" onclick="pageUp()" />
					<input type="text" value="${page.nowPage}" id="nowPage"
						style="width: 20px" />/
					<input type="button" value="下一页" onclick="pageDown()" />
					<input type="hidden" value="${page.dTime}" id="time"/>
				</div>


			   </div>
		</div>
		<div class="footdiv"></div>
	</body>
</html>

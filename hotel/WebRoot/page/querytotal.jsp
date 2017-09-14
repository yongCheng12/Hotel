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
	    <script type="text/javascript" src="js/date.js" charset="UTF-8"></script>
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
function changeColor(num) {

	document.getElementById("middlediv" + num).style.background = "#FC4C03";
}
function changeColorBefore(num) {

	document.getElementById("middlediv" + num).style.background = "#eeeeee";
}
function pageUp() {
	//alert("上一页");
	//var startdate=document.getElementById("time1").value;
	//var enddate=document.getElementById("time2").value;
	var nowPage = document.getElementById("nowPage").value;
	if (nowPage == 1) {
		alert("已经是第一页了!");
	}
	//跳转到controller中.href="pageUp.do?nowPage="+nowPage;
	//var url="pageUp.do";
	//url+="?nowPage="+nowPage;
	//window.self.location=url;
	window.location.href = "pageUp.do?nowPage=" + nowPage;

}

function pageDown() {
	//alert("下一页");
    //var startdate=document.getElementById("time1").value;
	//var enddate=document.getElementById("time2").value;
	var nowPage = document.getElementById("nowPage").value;
	//跳转到controller中href="pageDown.do?nowPage="+nowPage;
	//alert(nowPage);
	//var url = "pageDown.do";
	//url += "?nowPage=" + nowPage;
	//window.self.location = url;
	window.location.href="pageDown.do?nowPage="+nowPage;
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
				<div class="bottom-left-top">
					<div class="queryCustomer">
						<div
							style="margin-left: 370px; margin-top: 25px; position: absolute">
							<center>
							选择你要查询的日期
                            <input type="text" style="width:70px" onfocus="HS_setDate(this)" id="time1"/>
                            <input type="button" style="width:70px" onclick="getDate()" value="确定">

                           </center>
						</div>
						<div style="margin-left:180px;margin-top:60px; position: absolute">
						   <div style="float:left;margin-left:10px"><font size="4">总住房收入：${alld_r_money}</font> </div>
						    <div style="float:left;margin-left:10px"><font size="4">总餐饮收入：${alld_foodbeverage}</font> </div>
						    <div style="float:left;margin-left:10px"><font size="4">总其他收入：${alld_other}</font> </div>
						    <div style="float:left;margin-left:10px"><font size="4"> 总收入：${alld_totle}</font> </div> 
						</div>
					  </div>
				</div>
				<div class="showtotal">
					<center>
						<table
							style="font-size: 15px; border: 1px solid; border-collapse: collapse">
							<tr>
								<td>
									序号
								</td>
								<td>
									住房收入
								</td>
								<td>
									餐饮收入
								</td>
								<td>
									其他收入
								</td>
								<td>
									应收入
								</td>
								<td>
									实际收入
								</td>
								<td>
									共计支出
								</td>
								<td>
									记账日期
								</td>
								<td>
									记账人
								</td>
								<td>
									备注
								</td>
								<td>
									更多详细
								</td>
							</tr>

							<c:forEach items="${dList}" var="Daybill">
								<tr>
									<td>
										${Daybill.id}
									</td>
									<td>
										${Daybill.d_r_money}
									</td>
									<td>
										${Daybill.d_foodbeverage}
									</td>
									<td>
										${Daybill.d_other}
									</td>
									<td>
										${Daybill.d_totle}
									</td>
									<td>
										${Daybill.realtotle}
									</td>
									<td>
										${Daybill.spending}
									</td>
									<td>
										${Daybill.time}
									</td>
									<td>
										${Daybill.uname}
									</td>
									<td>
										${Daybill.remark}
									</td>
									<td>
										<a href="queryBillByPage.do?dTime=${Daybill.time}">详细信息</a>
									</td>
								</tr>
							</c:forEach>
						</table>
					</center>
				</div>
				<div class="page" style="margin-top: -25px; margin-left: 430;position:absolute">
					<input type="button" value="上一页" onclick="pageUp()" />
					<input type="text" value="${page.nowPage}" id="nowPage"
						style="width: 20px" />/
					<input type="button" value="下一页" onclick="pageDown()" />
				</div>


			</div>
		</div>
		<div class="footdiv"></div>
	</body>
</html>

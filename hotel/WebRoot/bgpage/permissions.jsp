<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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

		<title>My JSP 'permissions.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	</head>

	<body>
		<div
			style="width: 500px; height: 600px; margin-left: 80px; margin-top: 50px">
			<form action="updateUser.do" method="post">
				<table style="font-size:20px;border-spacing:45px 30px;">
					<tr>
						<td>
							编号:
						</td>
						<td>
							<input type="text" name="id" value="${user.id}" readonly />
						</td>
					</tr>
					<tr>
						<td>
							账号名:
						</td>
						<td>
							<input type="text" name="name" value="${user.name}" />
						</td>
					</tr>
					<tr>
						<td>
							权限:
						</td>
						<td>
							<select  name="permissions"
								style="margin-left: 60px; width: 92px; height: 25px">
								<option value="收银员">
									收银员
								</option>
								<option value="财务主管">
									财务主管
								</option>
								<option value="管理员">
									管理员
								</option>
							</select>
						</td>
					</tr>
				</table>


				<input type="submit" value="确认修改" style="margin-left: 150px" />




			</form>

		</div>
	</body>
</html>

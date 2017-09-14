<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <link rel="stylesheet" type="text/css" href="css/login.css">
    <script type="text/javascript">
    
    </script>
  </head>
  
 <body>
     <div class="topdiv">
        
        <div class="welcomediv"><font size="6" color=#FC4C03>中小型酒店结算系统！</font></div>
     </div>
     <div class="bottomdiv">
           <div style="width:100%;height:597px;background-image:url(images/login.jpg)">
                <div class="login">
                   <div style="width:150px;height:15px;margin-left:50px;margin-top:15px">
                        <font size="5" color=#FC4C03>欢迎登录！</font>
                   </div>
                   <div style="width:50px;height:15px;margin-left:230px;margin-top:-10px">
                   <a href="page/register.jsp" style="TEXT-DECORATION:none"><font size="4">注册</font> </a>
                   </div>
                   <div style="width:250px;height:200px;margin-left:30px;margin-top:30px">
                      <form action="queryPassByName.do" method="post" >
                        <div class="denglu" id="denglu">
                            <img src="images/zhanghao.png">
                           <input type="text" name="name"  placeholder="会员名/邮箱/手机号" value="${user.name}" style="width:190px;height:41px;float:left;position:absolute">
                        </div>
                        <div class="mima" id="mima" >
                             <img src="images/mima.png" >
                            <input type="password" name="password"  value="${user.password}" style="width:190px;height:41px;float:left;position:absolute"/>
                        </div>
                        <div style="margin-left:90px;margin-top:15px">
                             <c:if test="${tishi != null }">
  	                         ${tishi }
                             </c:if>
                        </div> 
                        <div class="butten">
                            <input type="submit" value="登录" style="width:230px;height:41px;background-color:#FC4C03; border-radius: 7px"/>
                        </div>
                      </form>
                   </div>
                </div>
           </div>
          
          
     </div>
      
  </body>
</html>

<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>注册</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css"
			href="css/style.css" />
	</head>

	<body>
		<div id="wrap">
			<div id="top_content">
					<%@ include file="Header.jsp" %>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						欢迎注册
					</h1>
					<form action=" toRegister.do" method="post">
						<table cellpadding="0" cellspacing="0" border="0"
							class="form_table">
							<tr>
								<td valign="middle" align="right">
									用户名:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="uname" />
									<%-- <%String message=(String)request.getAttribute("mes_name"); %> --%>
								    <span style="color:red">
								    <%--  <%=message==null?"":message %> --%>
								    <c:if test="${mes_name}==null"></c:if>
								    <c:if test="${mes_name}!=null">${mes_name}</c:if>
								    </span>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									密码:
								</td>
								<td valign="middle" align="left">
									<input type="password" class="inputgri" name="pwd" />
									<%-- <%String messa1=(String)request.getAttribute("mes_pwd");  --%>  
								    <span style="color:red">
								    
								    <%--  <%=messa1==null?"":messa1 %> --%>
								      <c:if test=" ${mes_pwd}==null"></c:if>
								    <c:if test=" ${mes_pwd}!=null"> ${mes_pwd}</c:if>
								    </span>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									电话:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="phone" />
									
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									邮箱:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="email" />
									
								</td>
							</tr>
						</table>
						<p>
							<input type="submit" class="button" value="注册" />
							<%-- <%String mesge4=(String)request.getAttribute("message"); %> --%>
								    <span style="color:red">
								    <%--  <%=mesge4==null?"":mesge4 %> --%> 
								    <c:if test="${message}==null "></c:if>
								    <c:if test="${message}!=null "> ${mes_pwd}</c:if>
								      </span>
						</p>
					</form>
				</div>
			</div>
			<%@ include file="footer.jsp" %>
			</div>
		</div>
	</body>
</html>

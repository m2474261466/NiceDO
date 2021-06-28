<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>用户登录</title>
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
					    欢迎使用
					</h1>
					<form action="toLogin" method="post">
					<%String message=(String)request.getAttribute("message"); %>
					<span style="color:red">
					
					<!-- 错误提示信息 -->
					  <%=message==null?"":message %>
					  
					 </span>
						<table cellpadding="0" cellspacing="0" border="0"
							class="form_table">
							<tr>
								<td valign="middle" align="right">
									用户名:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="uname" />
									<%String mes=(String)request.getAttribute("mes_name"); %>
									<span style="color:red">
					
										<!-- 错误提示信息 -->
										  <%=mes==null?"":mes %>
										  
										 </span>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									密码:
								</td>
								<td valign="middle" align="left">
									<input type="password" class="inputgri" name="pwd" />
									<%String mess=(String)request.getAttribute("mes_pwd"); %>
									<span style="color:red">
					
										<!-- 错误提示信息 -->
										  <%=mess==null?"":mess%>
										  
										 </span>
								</td>
							</tr>
							
						</table>
						<p>
							<input type="submit" class="button" value="登录" />
						</p>
					</form>
				</div>
			</div>
			<%@ include file="footer.jsp" %>
			</div>
		</div>
	</body>
</html>

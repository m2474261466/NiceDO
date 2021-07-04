<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@page import="entity.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>用户修改</title>
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
						个人信息修改
					</h1>
					<%User user=(User)request.getAttribute("user"); %>
					<form action="toUpdate.do" method="post">
						<table cellpadding="0" cellspacing="0" border="0"
							class="form_table">
							
									<input type="hidden" value=<%=user.getId() %> name="id" />
								
							<tr>
								<td valign="middle" align="right">
									用户名:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" value="<%=user.getUserName()%>" name="uname" />
								    <%String message=(String)request.getAttribute("message"); %>
								    <span>
								          <%=message==null?"":message %>
								    </span>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									用户密码:
								</td>
								<td valign="middle" align="left">
									<input type="password" class="inputgri" placeholder="请输入修改后的密码" name="updatePwd" />
								     <%String message2=(String)request.getAttribute("message"); %>
								    <span>
								          <%=message2==null?"":message2 %>
								    </span>
								</td>
							</tr>
							
							<tr>
								<td valign="middle" align="right">
									密码确认:
								</td>
								<td valign="middle" align="left">
									<input type="password" class="inputgri" placeholder="请输入确认密码" name="confrimPwd" />
								     <%String message3=(String)request.getAttribute("message"); %>
								    <span>
								          <%=message3==null?"":message3 %>
								    </span>
								</td>
							</tr>
							
							<tr>
								<td valign="middle" align="right">
									电话:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" value=<%=user.getUserPhone() %> name="phone" />
									
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									邮箱:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" value=<%=user.getUserEmail() %> name="email" />
									
								</td>
							</tr>
						</table>
						<p>
							<input type="submit" class="button" value="修改" />
						</p>
						<div>
						           <%String mes=(String)request.getAttribute("message"); %>
								          <%=mes==null?"":mes %>
								    
						</div>
					</form>
				</div>
			</div>
			<%@ include file="footer.jsp" %>
			</div>
	</body>
</html>

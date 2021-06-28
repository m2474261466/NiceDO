<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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
					<form action=" /toRegister" method="post">
						<table cellpadding="0" cellspacing="0" border="0"
							class="form_table">
							<tr>
								<td valign="middle" align="right">
									用户名:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="uname" />
									<%String message=(String)request.getAttribute("mes_name"); %>
								    <span style="color:red">
								     <%=message==null?"":message %>
								    </span>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									密码:
								</td>
								<td valign="middle" align="left">
									<input type="password" class="inputgri" name="pwd" />
									<%String messa1=(String)request.getAttribute("mes_pwd"); %>
								    <span style="color:red">
								     <%=messa1==null?"":messa1 %>
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
							<%String mesge4=(String)request.getAttribute("message"); %>
								    <span style="color:red">
								     <%=mesge4==null?"":mesge4 %>
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

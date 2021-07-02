<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
            这是a2.jsp页面
            <a href="a.jsp">点我到a.jsp(使用相对路径)</a>
            <a href="<%=request.getContextPath() %>/a.jsp">点我到a.jsp(使用绝对路径)</a>
</body>
</html>
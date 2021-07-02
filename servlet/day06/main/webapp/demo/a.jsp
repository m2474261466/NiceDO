<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
       <!-- 
            路径问题：
            链接地址,表单提交,重定向,转发都需要写一个路径
            相对路径:不是以"/"开头的路径
            绝对路径:是以"/"开头的路径
            任何写绝对路径？
            链接，表单，提交，重定向应该从应用名开始写，转发从应用名后开始写
            使用以下方法获得实际开发部署的路径
 
        -->
                         这是a.jsp页面
        <a href="a2.jsp">点我到a2.jsp</a>
        <a href="<%=request.getContextPath() %>/a2.jsp">点我到a2.jsp</a>
</body>
</html>
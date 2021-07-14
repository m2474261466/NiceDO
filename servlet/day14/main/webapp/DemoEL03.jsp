<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
         <!-- el表达式可以做一些简单的运算。运算结果可以用来给jsp标签的属性赋值也可以直接输出 
          1.运算符  + - * / % 例:  ${"1"+"1"} 值为2 "+"号是运算符不是拼接符
          2.关系运算  > < >= <= == !=
          3.逻辑运算 && || !
          4.empty运算
         -->
          <!--  1.运算符  + - * / % -->
          ${"1"+"1"}<br>
          <%
            request.setAttribute("k1", "200");
            request.setAttribute("k2", "400");
           String k1=(String)request.getAttribute("k1");
           String k2=(String)request.getAttribute("k2");
          %>
          ${k1+k2}<br>
          <%=k1+k2 %><br>
          
          <!--   2.关系运算  > < >= <= == != -->
          ${k1<k2}<br>
          
          <!-- 3.逻辑运算 && || ! -->
          ${k1<k2 && k1<10}<br>
          
        <!--   4.empty运算(值为空字符串或者null时返回true 否则返回false) -->
          <%request.setAttribute("ename", ""); %>
          ${empty ename}
          ${empty null}
</body>
</html>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>jstl</title>
</head>
<body>
         <%
        	request.setAttribute("message", "女");
         %>
         <!-- jstl表达式if语句 当test为true则执行标签体内容-->
         <!-- 相当于if语句 -->
         <c:if test="${message=='女'}">对</c:if>
          <!-- 相当于if语句 -->
         <c:if test="${message=='男'}">错</c:if>
         
         <% 
           request.setAttribute("age", "20");
          
         %>
         <!-- choose标签 when可以出现1次或者多次表示一个分支
          otherwise可以出现1次或0次，当test为true执行标签体的内容可以使用el表达式给该属性赋值，在这期间不能使用
                          与choose标签无关的代码，该标签相当于java中的if(){}else if(){}....else{}
          -->
         <!-- 相当于if-else语句 -->
         <c:choose>
           <c:when test="${age<20}">少年</c:when>
           <c:when test="${age==20}">青年</c:when>
           <c:when test="${age>20}">成年</c:when>
           <c:otherwise>其他人</c:otherwise>
         </c:choose>
         
         
         
</body>
</html>
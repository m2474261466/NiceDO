<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ page import="java.util.Date" %>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
      <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<style type="text/css">
        .row1{
        
          background:red;
        }
        
        .row2{
          background:gray;
          
        }
        .row3{
         background:pink;
        }
        


</style>
</head>

<body>
       <!-- 
          items属性:用来执行要遍历的集合或数组，可以使用el表达式来赋值
          var属性:用来执行绑定名(每遍历出来的一条数据赋给var)
          varStatu属性:每个对象的状态
          index属性:varStatus中的index是数据遍历的下标
          count属性:varStatus中的index是数据遍历的次数
          begin属性:从begin属性值开始遍历
          end属性:到end属性值结束
        -->
      <%--   <c:forEach items="${list}" var="s" begin="1" end="6" varStatus="t">
                 <!-- 获取对象中的名字 -->
                 ${s.name};<br>
                 下标:${t.index}
                  次数:${t.count}<br>         
        </c:forEach> --%>
        
        <table width="90%" border="2" cellspacing="0">
          <tr>
              <th>序列号</th>
              <th>用户名</th>
              <th>用户年龄</th> 
          </tr>
          <c:forEach items="${list}" var="s" varStatus="t">
           <tr class="row${t.count%3+1}">
              <td>${t.count}</td>
              <td>${s.name}</td>
              <td>${s.age}</td>
           </tr>
          
          </c:forEach>
        
        </table>
      <%
        Date date=new Date();
      request.setAttribute("date",date);
      %>
      <!-- 
      日期转换格式:
        value:获取的值可以用el表达式赋值
        type值为time:时分秒
        type值为date:年月日
        type值为both:年月日时分秒
        pattern:日期转换格式
      
       -->
    西安的时间<fmt:formatDate type="date" value="${date}" pattern="yyyy-MM-dd HH:mm:ss" />
        
            
</body>
</html>
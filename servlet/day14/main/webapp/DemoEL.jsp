<%@page import="entity.User,java.util.*"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>el表达式</title>
</head>
<body>
       <!-- el表达式语法${绑定名} -->
       <%
         request.setAttribute("userName", "admin");
         session.setAttribute("userName", "admin1");
         pageContext.setAttribute("userName", "admin2");
         application.setAttribute("userName", "admin3");
       %>
      <%--  <%=request.getAttribute("userName") %> --%>
       <!-- 用el表达式来获取绑定数据 --> 
       ${userName}
       <!-- ${userName}
      a.执行过程中容器依次从pageContext-》request->session->application中查找
      绑定名称为userName的数据,也就是调用了getAttribute("userName"),然后输出结果 
      b.会将null转换成空字符串""
      c.如果一句绑定名找不到的数据，不会报错，仍然输出空字符串""
      d.可以使用域对象pageScope,sessionScope,requestScope,applicationScope来指定
                     查找的范围;
             -->
      
             
        <br>
          ${sessionScope.userName}   <!--  查找到的是session绑定的对应的admin1 -->
        <br>     
             
         <!-- 
                                 用el表达式来获取对象中的属性的值
                                 要满足bean的规则：
                                      什么是bean？
                                      一个java类满足以下条件，就可称之为bean
             1.public class
             2.public 构造方法
             3.implements Serializable
             4.属性的set,get方法
                                     访问bean属性
         
          -->    
             <%User user=new User();
               user.setAge(20);
               user.setName("成都四十九中事件");
             request.setAttribute("user", user);
             %>
             
             <%-- <%  User u=(User)request.getAttribute("user");%>
             <%=u.getName() %>
             <%=u.getAge() %> --%>
             <!-- 用el表达式获取User对象中属性的值 -->
             获取user对象中的名字:${user.name}<br>
             获取user对象中的年龄:${user.age }<br>
             获取user对象:${user}<!-- 没有写toString方法，出来的是乱的字节码 --><br>
             
             <%Map<String,Object> map=new HashMap<String,Object>();
               map.put("page",1);
               map.put("user",user);
               application.setAttribute("map", map);
             %>
             <!-- 获取map中所绑定的页数的数据 -->
                                   页数:${map.page}<br>
                                   用户对象:${map.user}<br>
                                   用户对象的名字:${map.user.name}<br>
                                   用户对象的年龄:${map.user.age}<br>
                                   
                
        
                                   
                                   
                                   
             

             
</body>
</html>
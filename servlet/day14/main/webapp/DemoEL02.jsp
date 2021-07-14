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
                     员工类 Employe中的属性ename,eage,salay,empon,Address(city area)
                     用el表达式获取员工的名字，工资，部门，编号，地址 
               -->          
              员工名字${emp.ename}<br>
              员工年龄${emp.age}<br>
              员工薪水${emp.salay}<br>
              员工部门号${emp.empon}<br>
             员工地址 ${emp.address.city}<br>
      员工地址 ${emp.address.area}<br>     
</body>
</html>
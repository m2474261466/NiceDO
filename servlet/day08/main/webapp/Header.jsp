<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@page import="java.util.*,java.text.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div id="header">
					<div id="rightheader">
						<p>  
						     <%
						     Date date=new Date();
						     SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
						      out.print(sdf.format(date));
						     %>
						      
							<br />
						</p>
					</div>
					<div id="topheader">
						<h1 id="title">
							<a href="#">嘻嘻嘻嘻嘻</a>
						</h1>
					</div>
					<div id="navigation">
					</div>
</div>
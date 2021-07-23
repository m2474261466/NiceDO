<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="basepath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<header id="top" class="fixed_nav">
    <div id="logo" class="lf">
        <img class="animated jello" style="height:45px" src="../images/header/logo.png" alt="logo"/>
    </div>
    <div id="top_input" class="lf">
        <input id="input" type="text" placeholder="请输入您要搜索的内容"/>
        <a href="search.html" class="rt"><img id="search" src="../images/header/search.png" alt="搜索"/></a>
    </div>
    <div class="rt">
        <ul class="lf">
        	<c:if test="${user.userName!=null}">
        		<li><a href="#" title="用户名">${user.userName}</a><b>|</b></li>
        	</c:if>
            <li><a href="${basepath}/cart/careHTML.do" title="我的收藏"><img class="care" src="../images/header/care.png" alt=""/></a><b>|</b></li>
            <li><a href="${basepath}/cart/orderHTML.do" title="我的订单"><img class="order" src="../images/header/order.png" alt="" /></a><b>|</b></li>
            <li><a href="${basepath}/cart/toCartHTML.do" title="我的购物车"><img class="shopcar" src="../images/header/shop_car.png" alt="" /></a><b>|</b></li>
            <li><a href="${basepath}/good/toHelpPage.do" >帮助</a><b>|</b></li>
            <c:if test="${user.userName!=null}">
            	<li><a href="${basepath}/user/toLoginHTML.do">退出</a></li>
            </c:if>
            <c:if test="${user.userName == null}">
            	<li><a href="${basepath}/user/toLoginHTML.do">登录</a></li>
            </c:if>
            
        </ul>
    </div>
</header>



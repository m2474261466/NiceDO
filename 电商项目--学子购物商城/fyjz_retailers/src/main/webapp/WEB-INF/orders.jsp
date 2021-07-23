<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="basepath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>我的订单 - 学子商城</title>
    <link href="../css/orders.css" rel="stylesheet"/>
    <link href="../css/header.css" rel="stylesheet"/>
    <link href="../css/footer.css" rel="stylesheet"/>
    <link href="../css/footTxt.css" rel="Stylesheet"/>
</head>
<body>
<!-- 页面顶部-->
<%@include file="header.jsp" %>
<!-- nav主导航-->
<nav id="nav">
    <ul>
        <li><a href="index.html" class="acti">首页</a></li>
        <li><a href="index.html#computer" >电脑办公</a></li>
        <li><a href="index.html#stationery" >办公文具</a></li>
    </ul>
</nav>
<!-- 我的订单导航栏-->
<div id="nav_order">
    <ul>
        <li><a href="">首页<span>&gt;</span>订单管理</a></li>
    </ul>
</div>
    <!--我的订单内容区域 #container-->
    <div id="container" class="clearfix">
        <!-- 左边栏-->
        <div id="leftsidebar_box" class="lf">
            <div class="line"></div>
            <dl class="my_order">
                <dt >我的订单
                    <img src="../images/myOrder/myOrder2.png">
                </dt>
                <dd class="first_dd"><a href="#">全部订单</a></dd>
                <dd>
                    <a href="#">
                        待付款
                        <span><!--待付款数量--></span>
                    </a>
                </dd>
                <dd>
                    <a href="#">
                        待收货
                        <span><!--待收货数量-->1</span>
                    </a>
                </dd>
                <dd>
                    <a href="#">
                        待评价<span><!--待评价数量--></span>
                    </a>
                </dd>
                <dd>
                    <a href="#">退货退款</a>
                </dd>
            </dl>
            <dl class="footMark">
                <dt >我的优惠卷<img src="../images/myOrder/myOrder1.png"></dt>
            </dl>
            <dl class="address">
                <dt>收货地址<img src="../images/myOrder/myOrder1.png"></dt>
				<dd><a href="addressAdmin.html">地址管理</a></dd>
            </dl>
            <dl class="count_managment">
                <dt >帐号管理<img src="../images/myOrder/myOrder1.png"></dt>
                <dd class="first_dd"><a href="${basepath}/user/toPersonage.do">我的信息</a></dd>
                <dd><a href="${basepath}/user/toPersonal_password.do">安全管理</a></dd>
            </dl>
         </div>-->
         <!-- 右边栏-->
        <div class="rightsidebar_box rt">
            <!-- 商品信息标题-->
            <table id="order_list_title"  cellpadding="0" cellspacing="0" >
                <tr>
                    <th width="345">商品</th>
                    <th width="82">单价（元）</th>
                    <th width="50">数量</th>
                    <th width="82">售后</th>
                    <th width="100">实付款（元）</th>
                    <th width="90">交易状态</th>
                    <th width="92">操作</th>
                </tr>
            </table>
            <!-- 订单列表项 -->
           
            
            <c:forEach items="${list}"  var="t">
            		 <div id="orderItem">
			              <p class="orderItem_title">
			                 <span id="order_id">
			                     &nbsp;&nbsp;订单编号:<a href="#">12345678910</a>
			                 </span>
			                  &nbsp;&nbsp;成交时间：2016-01-04 18:00&nbsp;&nbsp;
			                 <span>
			                     <a href="#" class="servie">
			                        联系客服<img src="../images/myOrder/kefuf.gif"/>
			                      </a>
			                 </span>
			              </p>
			        </div>
            		<div id="orderItem_detail">
		                  <ul>
		                      <li class="product">
		                          <b><a href="#"><img src="${basepath}${t.goodsImage}"   style="width:80px;height:80px"/></a></b>
		                          <b class="product_name lf" >
		                              <a href="">${t.goodsTitle}</a>
		                              <br/>
		                          </b>
		                          <b class="product_color ">
		                              颜色：深空灰
		                          </b>
		                      </li>
		                      <li class="unit_price">
		                          专属价
		                          <br/>
		                          ￥${t.goodsPrice}
		                      </li>
		                      <li class="count">
		                          ${t.num}件
		                      </li>
		                      <li class="sale_support">
		                          退款/退货
		                          <br/>
		                          我要维权
		                      </li>
		                      <li class=" payments_received">
		                          ￥${t.goodsPrice*t.num}
		                      </li>
		                      <li class="trading_status">
		                          <img src="../images/myOrder/car.png" alt=""/>已发货
		                          <br/>
		                          <a href="orderInfo.html">订单详情</a>
		                          <br/>
		                          <a href="#" class="view_logistics">查看物流</a>
		                      </li>
		                      <li class="operate">
		                          <a href="#">确认收货</a>
		                      </li>
		                  </ul>
		              </div>
            </c:forEach>
              
              
              

            


<!--分页器-->
            <div class="tcdPageCode"></div>

        </div>
    </div>

        <!--<iframe src="order_status.html" width="1000" height=500""></iframe>-->
<!-- 品质保障，私人定制等-->
<div id="foot_box">
    <div class="icon1 lf">
        <img src="../images/footer/icon1.png" alt=""/>

        <h3>品质保障</h3>
    </div>
    <div class="icon2 lf">
        <img src="../images/footer/icon2.png" alt=""/>

        <h3>私人定制</h3>
    </div>
    <div class="icon3 lf">
        <img src="../images/footer/icon3.png" alt=""/>

        <h3>学员特供</h3>
    </div>
    <div class="icon4 lf">
        <img src="../images/footer/icon4.png" alt=""/>

        <h3>专属特权</h3>
    </div>
</div>
<!-- 页面底部-->
<div class="foot_bj">
    <div id="foot">
        <div class="lf" id="if">
             <p class="footer1"><img src="../images/footer/logo.png" alt="" class=" footLogo"/></p>
             <p class="footer2  footTxt">高端品牌,值得信赖</p>
              
        </div>
        <div class="foot_left lf">
            <ul>
                <li><a href="#"><h3>买家帮助</h3></a></li>
                <li><a href="#">新手指南</a></li>
                <li><a href="#">服务保障</a></li>
                <li><a href="#">常见问题</a></li>
            </ul>
            <ul>
                <li><a href="#"><h3>商家帮助</h3></a></li>
                <li><a href="#">商家入驻</a></li>
                <li><a href="#">商家后台</a></li>
            </ul>
            <ul>
                <li><a href="#"><h3>关于我们</h3></a></li>
                <li><a href="#">关于乾坤科技</a></li>
                <li><a href="#">联系我们</a></li>
                <li>
                    <img src="../images/footer/wechat.png" alt=""/>
                    <img src="../images/footer/sinablog.png" alt=""/>
                </li>
            </ul>
        </div>
        <div class="service">
            <p>学子商城客户端</p>
            <img src="../images/footer/ios.png" class="lf">
            <img src="../images/footer/android.png" alt="" class="lf"/>
        </div>
        <div class="download">
             
        </div>
		<!-- 页面底部-备案号 #footer -->
        <div class="record">
            &copy;2020 乾坤科技 版权所有 西安ICP证xxxxxxxxxxx
        </div>
    </div>
</div>
</body>
<script src="../js/header.js"></script>
<script type="text/javascript" src="../js/jquery-3.1.1.min.js"></script>
<script src="../js/index.js"></script>
<script src="../js/jquery.page.js"></script>
<script type="text/javascript" src="../js/orders.js"></script>
<script src="../js/footTxt.js"></script>
</html>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="basepath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
<meta charset="UTF-8">
<title>商品搜索页面</title>
<link rel="stylesheet" href="../css/header.css" />
<link rel="stylesheet" href="../css/search.css" />
<link rel="stylesheet" href="../css/footer.css" />
<link href="../css/footTxt.css" rel="Stylesheet"/>
</head>
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

<body>
	<div class="big">
		<form name="" action="" method="post">
			<section id="section">
				<p class="header">全部结果>${map.cateName}</p>
				<div id="wrap">
					<c:forEach items="${map.goods}" var="g">
						<div class="lf box" id="d1" style="width:230px;height:248px">
							<div class="info">
							<div class="img pic">
								<img style="curson:pointer" src="${basepath}${g.image}" alt="图片无法显示" title="${g.title}" onclick="toItemInfo(${g.id})" />
							</div>			
							<div class="describe">
								<p style="curson:pointer" onclick="toItemInfo(${g.id})" style="height:40px;overflow:hidden;">${g.title}</p>
								<span class="price"><b>￥</b><span class="priceContent">${g.price}.00</span></span>
								<span class="addCart"><img id="collect" src="../images/search/care.png" alt="" /><a href="javascript:void(0);" class="add_cart">加入购物车</a></span>
								<!--<span class="succee" style="display: none"> 
									<img src="/images/search/product_true.png" alt="" /> 
									<span>已移入购物车</span>
								</span>-->
							</div>
							</div>
						</div>
					</c:forEach>		
				</div>
			</section>
		</form>
	</div>
	
	<!-- 分页 -->
	<div style="text-align:center;width:80%;height:30px;margin:auto">
		<a href="${basepath}/good/toppage.do?pageCurrent=${map.pageCurrent}">上一页</a>
		<!-- 页数 
			begin=“1”：表示页数从1开始
		-->
		<c:forEach begin="1" end="${map.pageCount}" var="p">
			<c:if test="${p!=map.pageCurrent}">
				<a href="${basepath}/good/getpage.do?pageCurrent=${p}" style="color:black">${p}</a>
			</c:if>
			<!-- 当前遍历的页数等于当前页数的时候，字体变为红色 -->
			<c:if test="${p==map.pageCurrent}">
				<a href="${basepath}/good/getpage.do?pageCurrent=${p}" style="color:red">${p}</a>
			</c:if>
		</c:forEach>
		<a href="${basepath}/good/nextpage.do?pageCurrent=${map.pageCurrent}">下一页</a>
		<span>总页数：${map.pageCount}</span>
	</div>
	
	<!-- 尾部-->
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
<div class="modal" style="display:none">
    <div class="modal_dialog">
        <div class="modal_header">
            操作提醒
        </div>
        <div class="modal_information">
            <img src="../images/model/model_img2.png" alt=""/>
            <span>将您的宝贝加入购物车？</span>

        </div>
        <div class="yes"><span>确定</span></div>
        <div class="no"><span>取消</span></div>
    </div>
</div>
	<script src="../js/jquery-3.1.1.min.js"></script>
	<script src="../js/index.js"></script>
	<script src="../js/jquery.page.js"></script>
	<script>
	$(".add_cart").click(function(){
		$(".modal").show();
		$(".modal .modal_information span").html("将您的宝贝加入购物车?");
	})
	$(".yes").click(function(){
	    $(".modal").hide();
	})
	$('.no').click(function(){
    	$('.modal').hide();
    	
    })
</script>
<script type="text/javascript">
    /* 商品详情页  */
	function toItemInfo(id) {
		if (id) {
			window.location.href="${basepath}/good/detailsHTML.do?id=" + id;
		}else {
			alert("商品id不存在");
		}
	} 
</script>
<script type="text/javascript">
	/**添加到收藏**/
    $("#collect").click(function(e){
    	$(".modal").show();
		$(".modal .modal_information span").html("将您的宝贝加入收藏夹");
    })
    $(".yes").click(function(){
	    $(".modal").hide();
	    $('#collect').attr("src","../images/search/care1.png");
    })
</script>
<script src="../js/header.js"></script>
<script src="../js/footTxt.js"></script>
</body>
</html>
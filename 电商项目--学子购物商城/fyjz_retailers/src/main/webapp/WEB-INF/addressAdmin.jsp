<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="basepath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>我的订单 - 乾坤科技学子商城</title>
    <link href="../css/orders.css" rel="stylesheet"/>
    <link href="../css/header.css" rel="stylesheet"/>
    <link href="../css/footer.css" rel="stylesheet"/>
    <link href="../css/personage.css" rel="stylesheet" />
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
        <li><a href="">首页<span>&gt;</span>个人中心</a></li>
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
            <dd class="first_dd"><a href="orders.html">全部订单</a></dd>
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
            <dd class="first_dd"><a href="personage.html">我的信息</a></dd>
            <dd><a href="personal_icon.html">个人头像</a></dd>
            <dd><a href="personal_password.html">安全管理</a></dd>
        </dl>
    </div>
   <!-- 右边栏-->
    <div class="rightsidebar_box rt">	
        <!--标题栏-->
        <div class="rs_header">
            <span class="address_title">收获地址管理</span>
        </div>
        <!--收货人信息填写栏-->
        <div class="rs_content">
        	<form id="addressForm" method="post" action="">
	            <!--收货人姓名-->
	            <div class="recipients">
	                <span class="red">*</span><span class="kuan">收货人：</span><input type="text" name="recvUsername" id="receiverName" class="recv"/>
	            </div>
	            <!--收货人所在城市等信息  原本代码：data-toggle="distpicker"   data-city="---- 选择市 ----" -->
	            <div data-toggle="distpicker-s" class="address_content">
					 <span class="red">*</span><span class="kuan">省&nbsp;&nbsp;份：</span><select  name="recvProvincecode"  id="recvProvinceCode"   onchange="getCities(this.value,'-1','-1')"></select>
					  城市：<select name="recvCitycode"  id="receiverCity"   onchange="getAreas(this.value,'-1')"></select>
					  区/县：<select name="recvAreacode"  id="receiverDistrict"  ></select>
				</div> 
	            
	            <input type="hidden" name="id" id="addressId"/>
	            <!--收货人详细地址-->
	            <div class="address_particular">
	                <span class="red">*</span><span class="kuan">详细地址：</span><textarea style="resize:none;height:60px" name="recvAddress" id="recvAddress" cols="60" rows="3" placeholder="建议您如实填写详细收货地址" class="recv"></textarea>
	            </div>
	            <!--收货人地址-->
	            <div class="address_tel">
	                <span class="red">*</span><span class="kuan">手机号码：</span><input type="tel" id="recvPhone" name="recvPhone" class="recv"/>固定电话：<input type="text" name="recvTel" id="recvTel" class="recv"/>
	            </div>
	            <!--邮政编码-->
	            <div class="address_postcode">
	                <span class="red">&nbsp;</span class="kuan"><span>邮政编码：</span>&nbsp;<input type="text" name="recvZip"  id="recvZip" class="recv"/>
	            </div>
	            <!--地址名称-->
	            <div class="address_name">
	                <span class="red">&nbsp;</span class="kuan"><span>地址名称：</span>&nbsp;<input type="text" id="addressName" name="recvTag" class="recv"/>如：<span class="sp">家</span><span class="sp">公司</span><span class="sp">宿舍</span>
	            </div>
	            <!--保存收货人信息-->
	            <div class="save_recipient">
	                保存收货人信息
	            </div>
	
    		</form>
            <!--已有地址栏-->
            <div class="address_information_manage">
                <div class="aim_title">
                    <span class="dzmc dzmc_title">地址名称</span><span class="dzxm dzxm_title">姓名</span><span class="dzxq dzxq_title">地址详情</span><span class="lxdh lxdh_title">联系电话</span><span class="operation operation_title">操作</span>
                </div>
               <!--  <div class="aim_content_one aim_active">
                    <span class="dzmc dzmc_active">办公室</span>
                    <span class="dzxm dzxm_normal">杨洋</span>
                    <span class="dzxq dzxq_normal">西安市曲江旺座H座307</span>
                    <span class="lxdh lxdh_normal">18435110514</span>
                    <span class="operation operation_normal">
                    	<span class="aco_change">修改</span>|<span class="aco_delete">删除</span>
                    </span>
                    <span class="swmr swmr_normal"></span>
                </div>
                <div class="aim_content_two">
                    <span class="dzmc dzmc_normal">家里</span>
                    <span class="dzxm dzxm_normal">杨洋</span>
                    <span class="dzxq dzxq_normal">曲江旺座</span>
                    <span class="lxdh lxdh_normal">13788882346</span>
                    <span class="operation operation_normal">
                    	<span class="aco_change">修改</span>|<span class="aco_delete">删除</span>
                    </span>
                    <span class="swmr swmr_normal">设为默认</span>
                </div> -->
               
            </div>
        </div>
    </div>
</div>

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
<script src="../js/jquery.page.js"></script>
<script type="text/javascript" src="../js/orders.js"></script>
<script type="text/javascript" src="../js/distpicker.data.js"></script>
<script type="text/javascript" src="../js/distpicker.js"></script>
<script type="text/javascript" src="../js/personal.js"></script>
<script src="../js/footTxt.js"></script>
<script type="text/javascript">
	$(".lxdh_normal").each(function(i,e) {
		var phone = $(e).html();
		$(e).html(changePhone(phone));
	});
</script>

<script type="text/javascript">
     //声明userAddressId
     var userAddressId;
	/* 当页面加载后执行 */
	$(function(){
		// 获取所有省份
		getProvinceList("-1","-1","-1");
		//显示用户所有地址信息
		getAllAddress();
	});
	
	// 获取所有省份
	function getProvinceList(provinceCode,cityCode,areaCode){
		var url = "${basepath}/address/getProvinceList.do";
		$("#recvProvinceCode").html("<option> ---- 请选择 ---- </option>");
		$.get(url,function(result){
			if(result.state == 1){
				// 回显所有省份
				var provinces = result.data;
				for(var i  in  provinces){
					var name = provinces[i].provinceName;
					var code = provinces[i].provinceCode;
					/* 创建option对象 */
					var option = new Option(name,code);
					/* 将每一个省份添加option标签中 */
					$("#recvProvinceCode").append(option);
				}	
				if(provinceCode != -1){
					$("#recvProvinceCode").val(provinceCode);
				}
				getCities(provinceCode,cityCode,areaCode);
			}else{
				alert("数据加载失败！");
			}
		});
	}
	
	// 根据省份code获取所有市
	function getCities(provinceCode,cityCode,areaCode){
		var url = "${basepath}/address/getCityList.do";
		var params = {"provinceCode":provinceCode};
		$("#receiverCity").html("<option> ---- 请选择 ---- </option>");
		$.post(url,params,function(result){
			if(result.state == 1){
				// 回显市
				var cities = result.data;
				for(var i in cities){
					var name = cities[i].cityName;
					var code = cities[i].cityCode;
					var option = new Option(name,code);
					$("#receiverCity").append(option);
				}	
				if(cityCode != -1){
					$("#receiverCity").val(cityCode);
				}
				getAreas(cityCode,areaCode);
			}else{
				alert("数据加载失败！");
			}
		});
	}
	
	// 根据市获取所有区/县
	function getAreas(cityCode,areaCode){
		var url = "${basepath}/address/getAreaList.do";
		var params = {"cityCode":cityCode};
		$("#receiverDistrict").html("<option> ---- 请选择 ---- </option>");
		$.post(url,params,function(result){
			if(result.state == 1){
				// 回显区
				var areas = result.data;
				for(var i in areas){
					var name = areas[i].areaName;
					var code = areas[i].areaCode;
					var option = new Option(name,code);
					$("#receiverDistrict").append(option);
				}
				if(areaCode != -1){
					$("#receiverDistrict").val(areaCode);
				}
			}else{
				alert("数据加载失败！");
			}
		});
	}
	
	/**保存用户收货信息*/
	$(".save_recipient").click(function(){
		var receiverName = $("#receiverName").val();// 收件人
		var receiverState = $("#recvProvinceCode").val(); // 省
		var receiverCity = $("#receiverCity").val();// 市
		var receiverDistrict = $("#receiverDistrict").val();// 区/县
		var receiverAddress = $("#recvAddress").val();// 详细地址
		var receiverMobile = $("#recvPhone").val();// 电话
		if(receiverName && receiverState && receiverCity && receiverDistrict && receiverAddress && receiverMobile){
			var address = $("#addressForm").serialize();
			if(userAddressId){//修改
				var url="${basepath}/address/toUpdateAddress.do"
			}else{//添加
				var url="${basepath}/address/toAddGainAddress.do";
			}
			$.post(url,address,function(result){
				if(result.state==1){
					/* alert("添加成功");
					$("#receiverName").val("");
					$("#recvProvinceCode").val("");
					$("#receiverCity").val("");
					$("#receiverDistrict").val("");
					$("#recvAddress").val("");
					$("#recvPhone").val("");
					$("#recvTel").val("");// 固定电话
					$("#recvZip").val("");// 邮政编码
					$("#addressName").val("");// 地址名称 */
					//显示用户所有地址信息
					getAllAddress();
					$(".recv").val("");
					getProvinceList("-1","-1","-1");
					
				}else{
					alert(result.message);
				}
			});
		}else{
			alert("请将必填信息填写完整");
		}
	})
	
	
	
	//address模板(已设置默认)
	var addressTemp1=" <div class='aim_content_one aim_active'>"
					    +"<span class='dzmc dzmc_active'>[recvTag]</span>"
					    +"<span class='dzxm dzxm_normal'>[recName]</span>"
					    +"<span class='dzxq dzxq_normal'>[recvDistrict]</span>"
					    +" <span class='lxdh lxdh_normal'>[recvPhone]</span>"
					    +" <span class='operation operation_normal'>"
					        +"<span class='aco_change' onclick='[goUpdate()]'>修改</span>|<span class='aco_delete' onclick='[goDelete()]'>删除</span>"	
					    +"</span>"
					       +"<span class='swmr swmr_normal' >已设为默认</span>"
					 +"</div>";
    
	//address模板(未设置默认)
	var addressTemp2="<div class='aim_content_two'>"
					    +"<span class='dzmc dzmc_normal'>[recvTag]</span>"
					    +"<span class='dzxm dzxm_normal'>[recName]</span>"
					    +"<span class='dzxq dzxq_normal'>[recvDistrict]</span>"
					    +"<span class='lxdh lxdh_normal'>[recvPhone]</span>"
					    +"<span class='operation operation_normal'>"
					    	+"<span class='aco_change' onclick='[goUpdate()]'>修改</span>|<span class='aco_delete' onclick='[goDelete()]'>删除</span>"
					    +"</span>"
					    +"<span class='swmr swmr_normal' onclick='[goIsDefault()]'>设为默认</span>"
					+"</div>";
	
					
					
	//显示地址名称
	function getAllAddress(){
		$(".address_information_manage").empty();
		var url="${basepath}/address/toGetAllAddress.do";
		$.get(url,function(result){
			if(result.state==1){
				//渲染地址信息
				var address=result.data;
				for(var i in address){
					 if(address[i].isDefault==1){//已设置默认地址
						 $(".address_information_manage").append(
								 addressTemp1.replace("[recvTag]",address[i].recvTag)
								 			 .replace("[recName]",address[i].recvUsername)
								 			 .replace("[recvDistrict]",address[i].recvDistrict)
								 			 .replace("[recvPhone]",address[i].recvPhone)
								 			 .replace("[goUpdate()]","goUpdate("+address[i].id+")")
								 			 .replace("[goDelete()]","goDelete("+address[i].id+")")
								 			 .replace("[goIsDefault()]","goIsDefault("+address[i].id+")")
						 );
					 }else{//未设置默认地址
						 $(".address_information_manage").append(
								 addressTemp2.replace("[recvTag]",address[i].recvTag)
								 			 .replace("[recName]",address[i].recvUsername)
								 			 .replace("[recvDistrict]",address[i].recvDistrict)
								 			 .replace("[recvPhone]",address[i].recvPhone)
								 			 .replace("[goUpdate()]","goUpdate("+address[i].id+")")
								 			 .replace("[goDelete()]","goDelete("+address[i].id+")")
								 			 .replace("[goIsDefault()]","goIsDefault("+address[i].id+")")
						 );
					 }
					 
				}
			}else{
				alert("数据异常!");
			}
		});
	}
	//根据用户地址id查询数据(目的渲染表单数据)
	function goUpdate(id){
		userAddressId=id;
		$(".save_recipient").html("修改用户数据");
		var url = "${basepath}/address/toFindAddressById.do";
		var params = {"id":id};
		$.post(url,params,function(result){
			if(result.state == 1){
				var address = result.data;
				// 渲染地址表单
				$("#receiverName").val(address.recvUsername);// 收货人
				// 获取省编号
				var provinceCode = address.recvProvincecode;
				// 获取市编号
				var cityCode = address.recvCitycode;
				// 获取区/县编号
				var areaCode = address.recvAreacode;
				getProvinceList(provinceCode,cityCode,areaCode);
				$("#addressId").val(address.id);
				$("#recvAddress").val(address.recvAddress);// 详细地址
				$("#recvPhone").val(address.recvPhone);// 手机号码
				$("#recvTel").val(address.recvTel);// 固定电话
				$("#recvZip").val(address.recvZip);// 邮政编码
				$("#addressName").val(address.recvTag);// 地址名称
			}else{
				alert("数据加载失败！");
			}
		});
	}
	
	function goDelete(id){
		userAddressId=id;
		var url = "${basepath}/address/toDeleteAddressById.do";
		var params = {"id":id};
		$.post(url,params,function(result){
			if(result.state==1){
				getAllAddress();
				alert("删除成功");
			}else{
				alert("删除失败");
			}
		});
	}
	
	function goIsDefault(id){
		userAddressId=id;
		var url="${basepath}/address/toChangeIsDefaultAddress.do";
		var param={"id":id};
		$.post(url,param,function(result){
			if(result.state==1){
				alert("修改成功");
				getAllAddress();
			}else{
				alert("业务异常");
			}
		});
	}
	
	
</script>


</html>
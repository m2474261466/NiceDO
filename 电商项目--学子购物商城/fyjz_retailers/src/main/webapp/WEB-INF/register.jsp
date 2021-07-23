<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="basepath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
  <meta charset="UTF-8">
  <title>学子商城注册页面</title>
  <link href="../css/header.css" rel="stylesheet"/>
  <link href="../css/footer.css" rel="stylesheet"/>
  <link href="../css/animate.css" rel="stylesheet"/>
  <link href="../css/login.css" rel="stylesheet" />
  <link href="../css/footTxt.css" rel="Stylesheet"/>
</head>
<body>
<!-- 页面顶部-->
<header id="top">
  <div class="top">
    <img src="../images/header/logo.png" alt=""/>
    <span>欢迎注册</span>
  </div>
</header>
<div class="parent">
  <!--<video src="audio/snow.mp4" width="100%" autoplay loop muted></video>-->
  <div class="container">
    <div class="panel rt">
      <form id="form-register" method="post" action="">
        <div class="txt">
          <p>新用户注册
            <span>
              <a href="login.html">直接登录</a>
            </span>
          </p>
        </div>
        <div class="form-group">
          <label for="uname">用户名：</label>
          <input autocomplete required minlength="6" maxlength="9" type="text" placeholder="请输入用户名" autofocus name="userName" id="uname" onblur="checkName()"/>
          <span class="msg-default" id="spanName"></span>
        </div>
        <div class="form-group">
          <label for="upwd">登录密码：</label>
          <input required type="password" minlength="6" maxlength="12" placeholder="请输入密码" name="password" autofocus id="upwd" onblur="checkPwd()"/>
          <span class="msg-default" id="spanPwd"></span>
        </div>
		 <div class="form-group">
          <label for="upwdconfirm">确认密码：</label>
          <input required type="password" minlength="6" maxlength="12" placeholder="请确认密码" autofocus id="upwdconfirm" onblur="checkConfirm()"/>
          <span class="msg-default" id="spanConfirm"></span>
        </div>
        <div class="form-group">
          <label for="email">邮箱：</label>
          <input autocomplete required type="email" placeholder="请输入邮箱地址" name="email" id="email" onblur="checkEmail()"/>
          <span class="msg-default" id="spanEmail"></span>
        </div>
        <div class="form-group">
          <label for="phone">手机号：</label>
          <input id="phone" name="phone" placeholder="请输入您的手机号" pattern="(\d{11})|^((\d{7,8})|(\d{4}|\d{3})-(\d{7,8})|(\d{4}|\d{3})-(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1})|(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1}))$" required type="text" onblur="checkPhone()"/>
          <span class="msg-default" id="spanPhone"></span>
        </div>
        <div class="form-group">
          <label></label>
          <input type="button" value="提交注册信息" id="bt-register" onclick="register()"/>
        </div>
      </form>
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
    <div class="foot_left lf" >
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
        <li><a href="#">关于乾坤科技</li>
        <li><a href="#">联系我们</a></li>
        <li>
          <img src="../images/footer/wechat.png" alt=""/>
          <img src="../images/footer/sinablog.png" alt=""/>
        </li>
      </ul>
    </div>
    <div class="service">
      <p>商城客户端</p>
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
<!--弹出的小广告-->
<script src="../js/jquery-3.1.1.min.js"></script>
<script>
  // 校验用户名字 
  function checkName(){	  
	  // 获取用户数据（注意:id="uname",在写$("#uname")一定要记得写符号"#"）
	  var name = $("#uname").val();
	  // 正则
	  var regName = /^\w{5,9}$/;
	  // 用户数据校验
	  if(!regName.test(name)){
		  // attr：表示给属性赋值
		  $("#spanName").html("用户名长度在5到9位之间").attr("style","color:red");
		  // 返回false的目的：最后在点击注册按钮的时候，如果填入的内容全部都为true，才可提交成功
		  return false;
	  }
	  // ajax异步请求
	  var url = "${basepath}/user/tocheckName.do";
	  var params = {"name":name};
	  $.post(url,params,function(result){
		  if(result.state == 1){// 正确
			  $("#spanName").html(result.message).attr("style","color:green");
		  }else{// 错误返回错误提示语句
			  $("#spanName").html(result.message).attr("style","color:red");
		  }
	  });
	  return true;	  	 
  }
  // 校验用户密码
  function checkPwd(){
	  // 获取用户密码
	  var pwd = $("#upwd").val();	
	  // 密码的正则表达式
	  var regPwd = /^\w{6,9}$/;
	  // test方法：用于检测一个字符串是否匹配某个模式
	  if(!regPwd.test(pwd)){
		  $("#spanPwd").html("密码长度在6到9位之间").attr("style","color:red");
		  return false;
	  }
	  $("#spanPwd").html("OK").attr("style","color:green");
	  return true;
  }
  // 校验密码确认
  function checkConfirm(){
	  // 获取用户密码
	  var password = $("#upwd").val();
	  // 获取用户确认密码
	  var confirm = $("#upwdconfirm").val();
	  if(password != confirm){
		  $("#spanConfirm").html("密码不一致").attr("style","color:red");
		  return false;
	  }
	  $("#spanConfirm").html("OK").attr("style","color:green");
	  return true;
  }
  // 校验邮箱
  function checkEmail(){
	  // 获取用户邮箱
	  var email = $("#email").val();
	  var regEmail = /^\w{5,12}@[a-z]{2,5}\.[a-z]{2,4}$/;
	  if(!regEmail.test(email)){
		  $("#spanEmail").html("请输入正确的邮箱格式").attr("style","color:red");
		  return false;
	  }
	  $("#spanEmail").html("OK").attr("style","color:green");
	  return true;
  }
  // 校验电话
  function checkPhone(){
	  var phone = $("#phone").val();
	  var regPhone = /^1\d{10}$/;
	  if(!regPhone.test(phone)){
		  $("#spanPhone").html("请输入合法的手机号").attr("style","color:red");
		  return false;
	  }
	  $("#spanPhone").html("OK").attr("style","color:green");
	  return true;
  }
  
  // 注册
  function register(){
	  // 注意：一定要在这里判断n的大小，否则就算是内容不符合也会被注册
	  var n = checkName() + checkPwd() + checkConfirm() + checkEmail() + checkPhone();
	  if(n == 5){
		  // 表单序列化
		  var data = $("#form-register").serialize();
		  // console.log(data);
		  var url = "${basepath}/user/toRegister.do";
		  $.post(url,data,function(result){
			  if(result.state == 1){// 注册成功
				  // 跳转登录页面
				  location.href = "${basepath}/user/toLoginHTML.do";
			  }else{// 注册失败
				  // 显示错误信息
				  alert(result.message);
			  }		  
		  });
	  }else{
		  alert("请仔细查看填写内容！");
	  }	 
  }
</script>
<script src="../js/header.js"></script>
<script src="../js/footTxt.js"></script>
</body>
</html>
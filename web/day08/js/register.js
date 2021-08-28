$(function(){
	  //光标离开名字文本框事件
	$("#form-register").on("blur","#uname",checkName);
	 //光标离开密码文本框事件
	$("#form-register #upwd").blur(checkPwd);
	 //光标离开确认密码文本框事件
	$("#form-register #upwdconfirm").blur(checkuPwd);
	 //光标离开邮箱文本框事件
	$("#form-register #email").blur(checkEmail);
	 //光标离开电话文本框事件
	$("#form-register #phone").blur(checkPhone);
	 //点击注册事件
	$("#form-register #bt-register").(register);
	
});
 //光标离开名字文本框事件
 function checkName(){

	 var reg=/^\w{6,9}$/;
	 //获取用户输入的数据
	 var userName=$("#uname").val();
	 //校验名字是否匹配正则
	 if(reg.test(userName)){
	
		 $("#uname").next().html("ok").css("display","inline").css("color","green");
		 return true;
	 }else{
		 $("#uname").next().html("用户名长度在6到9位之间").css("display","inline").css("color","red");
		 return false;
	 }
		
 }
 function checkPwd(){
	 var reg=/^\w{6,12}$/;
	 var userPwd=$("#upwd").val();
	 if(reg.test(userPwd)){
		 $("#upwd").next().html("ok").css("display","inline").css("color","green");
		 return true;
	 }else{
		 $("#upw").next().html("密码长度在6到12位之间").css("display","inline").css("color","red");
		 return false;
	 }
 }
 function checkuPwd(){
	 var userpwd=$("#upwd").val();
	 var userupwd=$("#upwdconfirm").val();
	 if(userpwd==userupwd){
		  $("#upwdconfirm").next().html("ok").css("display","inline").css("color","green");
		  return true;
	 }else{
		 $("#upwdconfirm").next().html("密码不一致").css("display","inline").css("color","red");
		 return false;
	 }
 }
 function checkEmail(){
	 var reg=/^\w{6,12}@[a-z0-9A-Z]{2,5}\.[a-z]{2,3}$/;
	 var useremail=$("#email").val();
	 if(reg.test(useremail)){
		 $("#email").next().html("ok").css("display","inline").css("color","green");
		 return true;
	 }else{
		 $("#email").next().html("请输入合法的邮箱地址").css("display","inline").css("color","red");
		 return false;
	 }
 }
 function checkPhone(){
	 var reg=/^\d{11}$/;
	 var userphone=$("#phone").val();
	 if(reg.test(userphone)){
		 $("#phone").next().html("ok").css("display","inline").css("color","green");
		 return true;
	 }else{
		 $("#phone").next().html("请输入合法的手机号").css("display","inline").css("color","red");
		 return false;
	 }
 }
 function register(){
	  var sum=checkName()+checkPwd()+checkuPwd()+checkEmail()+checkPhone();
	  if(sum!=5){
		  alert("注册失败");
	  }else{
		  open("https://www.baidu.com");
	  }
 }
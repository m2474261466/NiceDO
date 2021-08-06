//光标离开账号文本事件
       function checkName(){
            	   var un=document.getElementById("user_name").value;
            	   var sun=document.getElementById("namespan");
            	   var regName=/^\w{5,11}$/;
            	   if(regName.test(un)){
            		   sun.style.color="green";
            		   sun.innerHTML="√";
            		   return true;
            	   }else{
            		   sun.style.color="red";
            		   sun.innerHTML="请按合法格式输入";
            		   return false;
            	   }
               }
//光标离开密码文本事件
       function checkPwd(){
    	   var  up=document.getElementById("user_pwd").value;
    	   var  sup=document.getElementById("pwdspan");
    	   var regPWD=/\w{5,15}/;
    	   if(regPWD.test(up)){
    		   sup.style.color="green";
    		   sup.innerHTML="√";
    		   return true;
    	   }else{
    		   sup.style.color="red";
    		   sup.innerHTML="请按合法格式输入";
    		   return false;
    	   }
       }
//光标离开确认密码文本事件
       function checkConfirm(){
    	   var   up=document.getElementById("user_pwd").value;
    	   var   cup=document.getElementById("user_con").value;
    	   var  scp=document.getElementById("conspan");
    	  
    	   if(cup==up){
    		   scp.style.color="green";
    		   scp.innerHTML="√";
    		   return true;
    	   }else{
    		   scp.style.color="red";
    		   scp.innerHTML="密码不一致";
    		   return false;
    	   }
       }
//光标离开邮箱文本事件
       function checkEmail(){
    	   var ce=document.getElementById("user_email").value;
    	   var sce=document.getElementById("emailspan");
    	   var regEmail=/^\w{6,13}@[a-zA-Z0-9]{2,5}\.[a-z]{2,3}$/;
    	   if(regEmail.test(ce)){
    		   sce.style.color="green";
    		   sce.innerHTML="√";
    		   return true;
    	   }else{
    		   sce.style.color="red";
    		   sce.innerHTML="请按合法格式输入";
    		   return false;
    	   }
       }
//光标离开电话文本事件
       function checkphone(){
    	   var ct=document.getElementById("user_phone").value;
    	   var sct=document.getElementById("phonespan");
    	   var regPhone=/^1\d{10}$/;
    	   if(regPhone.test(ct)){
    		   sct.style.color="green";
    		   sct.innerHTML="√";
    		   return true;
    		   
    	   }else{
    		   sct.style.color="red";
    		   sct.innerHTML="请按合法格式输入";
    		   return false;
    	   }
       }
//光标离开按钮事件
       function register(){
    	   var n=checkName()+checkPwd()+checkConfirm()+checkphone()+checkEmail();
    	   if(n!=5){
    		   alert("请输入正确");
    	   }else{
    		   alert("注册完成");
    	   }
    	   
    	   
       }
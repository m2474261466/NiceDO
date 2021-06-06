function tj(){
	var checkid="283965";
	var checkpwd="m20000509";
	var id=document.getElementById("t1").value;
	var pwd=document.getElementById("t2").value;
	if(checkid==id&&checkpwd==(pwd)){
		window.location.href="file:///F:/ykt/yktt/workspace/peopleTest/ProgramDemo/HomePage.html";
	}else{
		alert("输入的账号或者密码有误");
	}
}

$(function(){
	var imgs=$("#if #img")
	var n=0;
	imgs[0].style.display="block";
	for(var i=1;i<imgs.length;i++){
		imgs[i].style.display="none";
	}
	
	
	setInterval(function(){
			n++;
		var index=n%imgs.length;
		
		for(var i=0;i<imgs.length;i++){
			imgs[i].style.display="none";
		}
		imgs[index].style.display="block";
		
	},1500);
	
})
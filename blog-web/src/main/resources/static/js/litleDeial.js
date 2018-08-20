

$(document).ready(function(){  

$.ajax({
			url: "http://www.ijavo.cn:8002/web/blog/deial/"+request.QueryString("id"),
			dataType:'json', 
			data: {}, //请求的附加参数，用json对象
			method:'GET',
			
			success: function(data){
			
			$("#deialbog").html("");
			var tile="<h1 align='center'>"+data.title+"</h1><p ><h3 align='right'>"+data.author+"</h3></p><p ><h3 align='right'>"+data.attribute+"</h3></p>";
			var con="<ul class='nlist'><p style='width:600px; '>"+data.content+"</p>";
			var divblog=tile+con;
			
			$("#deialbog").append(divblog);
			},
			
		});
		 $.ajax({
			url: "http://www.ijavo.cn:8002/web/blog/dateDesc",
			dataType:'json', 
			data: {}, //请求的附加参数，用json对象
			method:'GET',
			success: function(data){
			
			$("#timedesc").html("");
			for(var i=0;i<data.length;i++){
					var divtime="<li><a href='litleDeial.html?id="+data[i].id+"' title='"+data[i].title+"' target='_blank'>"+data[i].title+"</a></li>";
					$("#timedesc").append(divtime);
				}
			},
		});
		$.ajax({
			url: "http://www.ijavo.cn:8002/web/blog/rate",
			dataType:'json', 
			data: {}, //请求的附加参数，用json对象
			method:'GET',
			success: function(data){
			
			$("#ratedesc").html("");
			for(var i=0;i<data.length;i++){
				
					var rate="<li><a href='litleDeial.html?id="+data[i].id+"' title='"+data[i].title+"' target='_blank'>"+data[i].title+"</a>点击数："+data[i].frequency+"</li>";;
					$("#ratedesc").append(rate);
				}
			},
		});
		
    }); 
		
   
function advice(){
	window.location.href="caselist.html";
	
}
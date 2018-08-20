$(document).ready(function(){  
       $.ajax({
			url: "http://www.ijavo.cn:8002/web/blog/search",
			dataType:'json', 
			data: {}, //请求的附加参数，用json对象
			method:'GET',
			success: function(data){
			
			$("#blog").html("");
			for(var i=0;i<data.length;i++){
				var time=getMyDate(data[i].createTime);
					var div="<h3>"+data[i].title+"</h3><ul><p style='width:200px; white-space:nowrap; text-overflow:ellipsis; overflow:hidden;'>"
							+data[i].content+"</p><span><a title='/' href='litleDeial.html?id="+data[i].id+"' target='_blank' class='readmore'>阅读全文>></a></span></ul><p class='dateview'><span>"
							+time+"</span><span>作者："+data[i].author+"</span><span>博客："+data[i].attribute+"</span>";
					$("#blog").append(div);
				}
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

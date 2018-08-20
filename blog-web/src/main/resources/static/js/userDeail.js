$(document).ready(function(){  
       var author=localStorage.getItem("author");
		 $.ajax({
			url: "http://www.ijavo.cn:8002/web/blog/userDeial/"+author,
			dataType:'json', 
			data: {}, //请求的附加参数，用json对象
			method:'GET',
			success: function(data){
			$("#forumlist").html("");
				alert(data.length);
				for(var i=0;i<data.length;i++){
					
						var blog="<h2>"+data[i].title+"</h2><p class='dateview'><span>作者：";
					var aut=data[i].author+"</span><span>分类:[";
					var attr=data[i].attribute+"]</span></p><ul class='nlist'><p style='width:400px; white-space:nowrap; text-overflow:ellipsis; overflow:hidden;'>";
					var con=data[i].content+"</p><a title='/' href='litleDeial.html?id="+data[i].id+"'  target='_blank' class='readmore'>阅读全文>></a>"
					var divblog=blog+aut+attr+con;
					$("#forumlist").append(divblog);
				}
			},
		});
		 
    }); 


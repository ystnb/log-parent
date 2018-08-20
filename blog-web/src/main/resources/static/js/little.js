$(document).ready(function(){  
     
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
		 $.ajax({
			url: "http://www.ijavo.cn:8002/web/search/blog",
			dataType:'json', 
			data: {"q":"傻缺"}, //请求的附加参数，用json对象
			method:'GET',
			success: function(data){
			var bloglist=data.itemList;
			$("#blogteams").html("");
			for(var i=0;i<bloglist.length;i++){
				
				var blog="<h2>"+bloglist[i].title+"</h2><p class='dateview'><span>作者：";
	  			var aut=bloglist[i].author+"</span><span>分类:[";
				var attr=bloglist[i].attribute+"]</span></p><ul class='nlist'><p style='width:400px; white-space:nowrap; text-overflow:ellipsis; overflow:hidden;'>";
				var con=bloglist[i].content+"</p><a title='/' href='litleDeial.html?id="+bloglist[i].id+"'  target='_blank' class='readmore'>阅读全文>></a>"
				var divblog=blog+aut+attr+con;
				$("#blogteams").append(divblog);
  
					
				}
			},
		});
    }); 
		
   
function advice(){
	//localStorage.setItem("TT_TOKEN","isaac");
	var token=localStorage.getItem("TT_TOKEN");
	if(token==null||token==""){
		localStorage.setItem("url","caselist.html");
		window.location.href="login.html";
	}else{
		$.ajax({
			type: 'get',
			url: 'http://www.ijavo.cn:8002/web/user/token/'+token,
			data: {},
			dataType: 'text',
			success: function(result) {
					var jsonstr=$.parseJSON( result );
				localStorage.setItem("author",jsonstr.nickname);
					window.location.href="caselist.html";
			}
				
		});
	
		
	}

}

function search(){
	var quertStr=$("#q").val();
	if(quertStr==null||quertStr==""){
		quertStr="傻缺"
	}
 $.ajax({
			url: "http://www.ijavo.cn:8002/web/search/blog",
			dataType:'json', 
			data: {"q":quertStr}, //请求的附加参数，用json对象
			method:'GET',
			success: function(data){
			var bloglist=data.itemList;
			$("#blogteams").html("");
			for(var i=0;i<bloglist.length;i++){
					
				var blog="<h2>"+bloglist[i].title+"</h2><p class='dateview'><span>作者：";
	  			var aut=bloglist[i].author+"</span><span>分类:[";
				var attr=bloglist[i].attribute+"]</span></p><ul class='nlist'><p style='width:400px; white-space:nowrap; text-overflow:ellipsis; overflow:hidden;'>";
				var con=bloglist[i].content+"</p><a title='/' href='litleDeial.html?id="+bloglist[i].id+"' target='_blank' class='readmore'>阅读全文>></a>"
				var divblog=blog+aut+attr+con;
				$("#blogteams").append(divblog);
					
				}
			},
		});
	}
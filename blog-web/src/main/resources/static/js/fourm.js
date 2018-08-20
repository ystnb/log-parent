$(document).ready(function(){  
     
		 $.ajax({
			url: "http://www.ijavo.cn:8002/web/search/fourm",
			dataType:'json', 
			data: {"q":"论坛"}, //请求的附加参数，用json对象
			method:'GET',
			success: function(data){
			$("#forumlist").html("");
				
				var list=data.list;
		
				for(var i=0;i<list.length;i++){
					var divtop="<h2>"+list[i].ftitle+"</h2><p class='dateview'><span>"+list[i].fauthor+"</span><span>论坛分类：["+list[i].ftype+"]</span></p>";
					var divdow="<p>"+list[i].fcontent+"</p> <a title='/' href='forumDeail.html?id="+list[i].id+"' target='_blank' class='readmore'>详细信息>></a>";
					var fourm=divtop+divdow;
					$("#forumlist").append(fourm);
				}
			},
		});
		 
    }); 
function addforum(){
	
		var token=localStorage.getItem("TT_TOKEN");
	if(token==null||token==""){
		localStorage.setItem("url","addForum.html");
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
				window.location.href="addForum.html";
			}
				
		});
	}

}
function fourmsearch(){
	var q=$("#q").val();
	if(q==null||q==""){
		q="论坛";
	}
	$.ajax({
			url: "http://www.ijavo.cn:8002/web/search/fourm",
			dataType:'json', 
			data: {"q":q}, //请求的附加参数，用json对象
			method:'GET',
			success: function(data){
			$("#forumlist").html("");
				
				var list=data.list;
		
				for(var i=0;i<list.length;i++){
					var divtop="<h2>"+list[i].ftitle+"</h2><p class='dateview'><span>"+list[i].fauthor+"</span><span>论坛分类：["+list[i].ftype+"]</span></p>";
					var divdow="<p>"+list[i].fcontent+"</p> <a title='/' href='forumDeail.html?id="+list[i].id+"' target='_blank' class='readmore'>详细信息>></a>";
					var fourm=divtop+divdow;
					$("#forumlist").append(fourm);
				}
			},
		});
}
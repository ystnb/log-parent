
var fid=request.QueryString("id");
$(document).ready(function(){  

$.ajax({
			url: "http://www.ijavo.cn:8002/web/forum/deail/"+request.QueryString("id"),
			dataType:'json', 
			data: {}, //请求的附加参数，用json对象
			method:'GET',
			
			success: function(data){
			var forum=data.forum;
			var replies=data.replies;
			$("#forumdeail").html("");
			var tile="<h1 align='center'>"+forum.fTitle+"</h1><p ><h3 align='center'>"+forum.fAuthor+"</h3></p><p ><h3 align='left'>"+forum.type+"</h3></p>";
			var con="<ul class='nlist'><p style='width:600px; '>"+forum.fContent+"</p>";
			var divblog=tile+con;
			$("#forumdeail").append(divblog);
			$("#replies").html("");
			for(var i=0;i<replies.length;i++){
				var time=getMyDate(replies[i].createTime);
				var repliestle="<h1 align='center'>"+replies[i].author+"</h1><p ><h3 align='left'>"+time+"</h3></p>";
				var repliescon="<ul class='nlist'><p style='width:600px; '>"+replies[i].rContent+"</p>";
				var repliesdivblog=repliestle+repliescon;
				$("#replies").append(repliesdivblog);
			}
			},
			
		});
		
	
    }); 
		
function addReplies(){
		var rContent=$("#rContent").val();
		alert(rContent);
	$.ajax({
			type: 'post',
			url: 'http://www.ijavo.cn:8002/web/replies/addReplies',
			data: {"rContent":rContent,"fid":fid,"author":localStorage.getItem("nickname")},
			dataType: 'JSON',
			success: function(result) {
				if(result.status==200){
					alert("提交成功！");
					$("#rContent").val("");
				}
				  
			},error: function (result) {
				if(result.status==200){
					alert("提交成功！");
					$("#rContent").val("");
				}
                     
             }
		});
			
	}
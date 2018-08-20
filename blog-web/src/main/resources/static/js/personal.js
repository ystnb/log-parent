
$(document).ready(function(){  
     var token=localStorage.getItem("TT_TOKEN");
	 console.log(token);
	 if(token!=null){
		 $("#sigoon").hide();
	$.ajax({
			type: 'get',
			url: 'http://www.ijavo.cn:8002/web/user/token/'+token,
			data: {},
			dataType: 'text',
			success: function(result) {
				var jsonstr=$.parseJSON( result );
		
				$("#usercenter").html("");
				
				var jsonstr=$.parseJSON( result );
				localStorage.setItem("author",jsonstr.nickname);
				var hh="<h2>姓名："+jsonstr.name+"</h2>";
				var pp="<p>昵称："+jsonstr.nickname+"</p><p>邮箱："+jsonstr.email+"</p>";
				var  div=hh+pp;
				$("#usercenter").html(div);
			},error:function(result){	
				 localStorage.setItem("url","personal.html");
				window.location.href="login.html";
			}
				
		});

	 }else{
		 localStorage.setItem("url","personal.html");
		 window.location.href="login.html";
	 }
    }); 
	function userDeail(){
		window.location.href="userDeail.html";
	}
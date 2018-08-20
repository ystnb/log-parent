
function addUser(){
	
	 var datajson=  $("form").serializeObject();
		
		$.ajax({
			type: 'post',
			url: 'http://www.ijavo.cn:8002/web/user/addUser',
			data: JSON.stringify(datajson),
			dataType: 'text',
		    contentType:'application/json;charset=utf-8',
			success: function(result) {
				if(result=="success"){
					alert("提交成功,请登录！");
					$("form")[0].reset();
					window.location.href="login.html";
				}else{
					alert("请求失败，请重试！");
				}
				  
			}
		});
}

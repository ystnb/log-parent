
function signIn(){
	var nickname=$("#nickname").val();
	var password=$("#userpwd").val();
	$.ajax({
			type: 'post',
			url: 'http://www.ijavo.cn:8002/web/user/login',
			data: {"nickname":nickname,"password":password},
			dataType: 'JSON',
			success: function(result) {
				if(result.status==500){
					alert("用户名或密码错误！");
				}else if(result.status==400){
					alert("请求失败，请重试！");
				}else if(result.status==200){
					var url=localStorage.getItem("url");
					localStorage.setItem("TT_TOKEN",result.data);
					localStorage.setItem("nickname",nickname);
					if(url!=null){
						localStorage.removeItem("url");
						window.location.href=url;	
					}else{
						window.location.href="index.html";
					}
				}
			}
				
		});
}

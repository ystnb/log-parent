
function login(){
	window.location.href="login.html";
}
function register(){
	window.location.href="register.html";
}

$(document).ready(function(){  
     var token=localStorage.getItem("TT_TOKEN");
	 if(token!=null){
		 $("#sigoon").hide();
	 }
    }); 
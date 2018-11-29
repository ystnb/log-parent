
function addforum(){
	window.location.href="/replies/addforum";

}

function fourmsearch(){
	alert(111);
	var quertStr=$("#q").val();
	window.location.href="/forum/forum?q="+quertStr;
 
	}

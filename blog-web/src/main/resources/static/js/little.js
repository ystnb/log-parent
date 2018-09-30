function advice(){
	window.location.href="/replies/addBlog";
}

function search(){
	alert(222);
	var quertStr=$("#q").val();
	window.location.href="/blog/blog?q="+quertStr;
 
	}
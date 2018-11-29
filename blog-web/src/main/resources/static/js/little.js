function advice(){
	window.location.href="/replies/addBlog";
}

function search(){
	var quertStr=$("#q").val();
	window.location.href="/blog/blog?q="+quertStr;
 
	}
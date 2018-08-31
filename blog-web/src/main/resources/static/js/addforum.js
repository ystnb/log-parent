
function subject(){
        var datajson=  $("form").serializeObject();
		
		$.ajax({
			type: 'post',
			url: 'http://www.ijavo.cn:8002/web/replies/addForum',
			data: JSON.stringify(datajson),
			dataType: 'text',
		    contentType:'application/json;charset=utf-8',
			success: function(result) {
				if(result=="ok"){
					alert("提交成功！");
					$("form")[0].reset();
				}else{
					alert("请求失败，请重试！");
				}

			}
		});
		 
      }
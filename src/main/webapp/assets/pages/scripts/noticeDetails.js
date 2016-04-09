var FormValidation = function () {
	
	
	 
    // basic validation
    var handleValidation1 = function() {
         var form1 = $('#form_sample_1');
         form1.on("click",".btn-outline",function(){
        	  $("#ajax").modal("hide");
         });
    }
    return { 
        init: function () { 
            handleValidation1(); 
        }

    };
}();

jQuery(document).ready(function() {
	$.ajax({  
		url:'/sysManager/getAnnouncement',// 跳转到 action  
		data:{"noticeId":$('.modal').attr("dataAjax")},  
		type:'post',  
		cache:false,  
		dataType:'json',  
		success:function(data) {
			$(".noticeTitle").html($(".noticeTitle").html()+data.title);
			$(".noticeContent").html($(".noticeContent").html()+data.content); 
		},  
		error:function() {
			alert("123123123123123");
		}  
	});
    FormValidation.init();
});
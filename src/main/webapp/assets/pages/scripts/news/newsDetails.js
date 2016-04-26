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
		url:'/sysManager/getNews',// 跳转到 action  
		data:{"newId":$('.modal').attr("dataAjax")},  
		type:'post',  
		cache:false,  
		dataType:'json',  
		success:function(data) {
			$(".newsTitle").html($(".newsTitle").html()+data.title);
			$(".newsContent").html($(".newsContent").html()+data.content); 
		},
		error:function() {
			
		}  
	});
    FormValidation.init();
});
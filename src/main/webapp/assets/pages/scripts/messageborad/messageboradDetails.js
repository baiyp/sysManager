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
		url:'/sysManager/getAdvertisement',// 跳转到 action  
		data:{"adverId":$('.modal').attr("dataAjax")},  
		type:'post',  
		cache:false,  
		dataType:'json',  
		success:function(data) {
			$(".advertisementTitle").html($(".advertisementImage").html()+data.title);
			$(".advertisementContent").html($(".advertisementImage").html()+data.url);
			$(".advertisementImage").html($(".advertisementImage").html()+"<img src=\""+data.imagePath+"\" width=\"240\" height=\"100\"/>"); 
		},
		error:function() {
			
		}  
	});
    FormValidation.init();
});
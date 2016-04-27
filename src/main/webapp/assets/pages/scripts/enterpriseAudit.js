var FormValidation = function () {
	
	var auditEnterprise = function(status){//审核企业信息
		$.ajax( {  
			url:WebUtil.getMainRoot()+'/auditAccount',//跳转到action  
			data:{"accountId":$(".accountId").attr("value"),"auditStatus":status},  
			type:'post',  
			cache:false,  
			dataType:'json',  
			success:function(data) {
				if(data.success = true){
					WebUtil.alertMessage("企业用户审核成功","success");

				}else{
					WebUtil.alertMessage("企业用户审核失败","danger");
				}
				$('#sample_3').DataTable().ajax.reload(null,false);
			},  
			error : function() {
				WebUtil.alertMessage("企业用户审核失败","danger");
			}  
	 });
    	$('#ajax').modal('hide');

	}
 
    var handleValidation1 = function() {
            var form1 = $('#form_sample_1'); 
            form1.on("click",".btn-green",function(){
            	auditEnterprise(2);
            }); 
            form1.on("click",".btn-outline",function(){
            	auditEnterprise(1);
            });
    } 
    return { 
        init: function () {
            handleValidation1();
        }
    };

}();

jQuery(document).ready(function() {
	$.ajax( {  
			url:WebUtil.getMainRoot()+'/getEnterprise',// 跳转到 action  
			data:{"accountId" :$('.modal').attr("dataAjax")},  
			type:'post',  
			cache:false,  
			dataType:'json',  
			success:function(data) {
        		$(".accountId").attr("value",data.id);
				$(".enterprise_name").html($(".enterprise_name").html()+data.enterprise_name);
				$(".en_bus_license_no").html($(".en_bus_license_no").html()+data.en_bus_license_no);
				$(".business_entity").html($(".business_entity").html()+data.business_entity);
				$(".enterprise_tel").html($(".enterprise_tel").html()+data.enterprise_tel);
				$(".registered_capital").html($(".registered_capital").html()+data.registered_capital);
				$(".business_volume").html($(".business_volume").html()+data.business_volume);
				$(".output_value").html($(".output_value").html()+data.output_value);
				$(".deposit_bank").html($(".deposit_bank").html()+data.deposit_bank);
				$(".bank_account").html($(".bank_account").html()+data.bank_account);
				
				$(".enterprise_size").html($(".enterprise_size").html()+data.enterprise_size); 
				$(".enterprise_nature").html($(".enterprise_nature").html()+data.enterprise_nature); 
				$(".business_type").html($(".business_type").html()+data.business_type); 
				$(".en_bus_license_image").html($(".en_bus_license_image").html()+"<img src=\""+data.imagePath+"\" width=\"250\" height=\"200\"/>");
				$(".safety").html($(".safety").html()+"<img src=\""+data.imagePath+"\" width=\"250\" height=\"200\"/>"); 
				$(".iso9001").html($(".iso9001").html()+"<img src=\""+data.imagePath+"\" width=\"250\" height=\"200\"/>"); 
				$(".iso14001").html($(".iso14001").html()+"<img src=\""+data.imagePath+"\" width=\"250\" height=\"200\"/>"); 
			},  
			error : function() {
			}  
	 }); 
    FormValidation.init();
});
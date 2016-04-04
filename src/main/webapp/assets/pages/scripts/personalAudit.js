var FormValidation = function () {
 
	var  auditPersonal  = function(status){
		
		$.ajax( {  
			url:WebUtil.getMainRoot()+'/auditAccount',// 跳转到 action  
			data:{"accountId" :$(".accountId").attr("value"),"auditStatus":status},  
			type:'post',  
			cache:false,  
			dataType:'json',  
			success:function(data) {
				if(data.success = true){
					WebUtil.alertMessage("个人用户审核成功","success");
					
				}else{
					WebUtil.alertMessage("个人用户审核失败","danger");
				}
				$('#sample_3').DataTable().ajax.reload(null,false);
			},
			error : function() {
				WebUtil.alertMessage("账号"+username+"禁用失败","danger");
			}  
	 });
		$('#ajax').modal('hide');
 
	}
	 
    var handleValidation1 = function() {
       var form1 = $('#form_sample_1');
      
       form1.on("click",".btn-green",function(){
    	   auditPersonal(2);
       }); 
       form1.on("click",".btn-outline",function(){
    	   auditPersonal(1);
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
			url:WebUtil.getMainRoot()+'/getPersonal',// 跳转到 action  
			data:{"accountId" :$('.modal').attr("dataAjax")},  
			type:'post',  
			cache:false,  
			dataType:'json',  
			success:function(data) { 
				  var d = new Date(data.date_birth*1000);
        		  var sex = data.sex;
        		  var html = "男";
        		  if(sex == 1){
        			  html = "女";
        		  }
        		$(".accountId").attr("value",data.id);
				$(".userName").html($(".userName").html()+data.full_name);
				$(".sex").html($(".sex").html()+html);
				$(".id_number").html($(".id_number").html()+data.id_number);
				$(".date_birth").html($(".date_birth").html()+d.getFullYear()+"-"+(d.getMonth()+1) + "-" + d.getDate() + " " + d.getHours() +":" +d.getMinutes() +":" + d.getSeconds());
				$(".graduate_institutions").html($(".graduate_institutions").html()+data.graduate_institutions);
				$(".profession").html($(".profession").html()+data.profession);
				$(".diploma").html($(".diploma").html()+data.diploma);
				$(".work_unit").html($(".work_unit").html()+data.work_unit);
				$(".positional_titles").html($(".positional_titles").html()+data.positional_titles);
			},  
			error : function() {
			}  
	 }); 
	
	
    FormValidation.init();
});
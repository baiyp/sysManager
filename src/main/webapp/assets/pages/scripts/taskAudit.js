var FormValidation = function () {
	
	var auditTask = function(status){//审核人任务信息
		$.ajax( {  
			url:WebUtil.getMainRoot()+'/auditTaskManage',//跳转到 action  
			data:{"taskId" :$(".taskId").attr("value"),"status":status},  
			type:'post',  
			cache:false,  
			dataType:'json',  
			success:function(data) {
				if(data.success = true){
					WebUtil.alertMessage(data.message,"success");

				}else{
					WebUtil.alertMessage(data.message,"danger");
				}
				$('#sample_3').DataTable().ajax.reload(null,false);
			},  
			error : function() {
				WebUtil.alertMessage("任务审核失败","danger");
			}  
	 });
    	$('#ajax').modal('hide');
		
	}
	 
    var handleValidation1 = function() {
        var form1 = $('#form_sample_1'); 
        form1.on("click",".btn-green",function(){
        	auditTask(2);
        }); 
        form1.on("click",".btn-outline",function(){
        	auditTask(1);
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
			url:WebUtil.getMainRoot()+'/getTaskManage',//跳转到action  
			data:{"taskId" :$('.modal').attr("dataAjax")},  
			type:'post',  
			cache:false,  
			dataType:'json',  
			success:function(data) {
				var d = new Date(data.endtime*1000);
        		$(".taskId").attr("value",data.id);
				$(".taskTitle").html($(".taskTitle").html()+data.title);
				$(".taskTypeName").html($(".taskTypeName").html()+data.taskTypeName);
				$(".endtime").html($(".endtime").html()+d.getFullYear()+"-"+(d.getMonth()+1) + "-" + d.getDate() + " " + d.getHours() +":" +d.getMinutes() +":" + d.getSeconds());
				$(".content").html($(".content").html()+data.content);
			},
			error : function() {
			}  
	 }); 
    FormValidation.init();
});
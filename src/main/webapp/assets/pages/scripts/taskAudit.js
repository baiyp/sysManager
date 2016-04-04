var FormValidation = function () {
 
    var handleValidation1 = function() {
            var form1 = $('#form_sample_1');
            form1.validate({
                errorElement: 'span', //default input error message container
                errorClass: 'help-block help-block-error', // default input error message class
                focusInvalid: false, // do not focus the last invalid input
                ignore: "",  // validate all fields including form hidden input
                invalidHandler: function (event, validator) { //display error alert on form submit              
                    success1.hide();
                    error1.show();
                    App.scrollTo(error1, -200);
                },

                highlight: function (element) { // hightlight error inputs
                    $(element).closest('.form-group').addClass('has-error'); // set error class to the control group
                },

                unhighlight: function (element) { // revert the change done by hightlight
                    $(element).closest('.form-group').removeClass('has-error'); // set error class to the control group
                },

                success: function (label) {
                    label.closest('.form-group').removeClass('has-error'); // set success class to the control group
                }, 
                submitHandler: function (form) {
                	$.ajax( {  
            			url:WebUtil.getMainRoot()+'/auditAccount',//跳转到 action  
            			data:{"accountId" :$(".accountId").attr("value"),"auditStatus":2},  
            			type:'post',  
            			cache:false,  
            			dataType:'json',  
            			success:function(data) {
            				if(data.success = true){
            					WebUtil.alertMessage("任务审核成功","success");

            				}else{
            					WebUtil.alertMessage("任务审核失败","danger");
            				}
            			},  
            			error : function() {
            				WebUtil.alertMessage("任务审核失败","danger");
            			}  
            	 });
                	$('#ajax').modal('hide');
                }
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
			url:WebUtil.getMainRoot()+'/getTaskManage',// 跳转到 action  
			data:{"taskId" :$('.modal').attr("dataAjax")},  
			type:'post',  
			cache:false,  
			dataType:'json',  
			success:function(data) {
				var d = new Date(data.endtime*1000);
        		$(".accountId").attr("value",data.id);
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
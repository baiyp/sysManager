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
			url:'/sysManager/getPersonal',// 跳转到 action  
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
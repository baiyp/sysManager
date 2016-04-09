var ComponentsEditors = function () {
	
	// basic validation
    var handleValidation1 = function() { 

            var form1 = $('#form_sample_1');
            var error1 = $('.alert-danger', form1);
            var success1 = $('.alert-success', form1);

            form1.validate({
                errorElement: 'span', //default input error message container
                errorClass: 'help-block help-block-error', // default input error message class
                focusInvalid: false, // do not focus the last invalid input
                ignore: "",  // validate all fields including form hidden input
                messages: {
                    select_multi: {
                        maxlength: jQuery.validator.format("Max {0} items allowed for selection"),
                        minlength: jQuery.validator.format("At least {0} items must be selected")
                    }
                },
                rules: {
                	title: {
                        minlength: 2,
                        required: true
                    }
                },

                invalidHandler: function (event, validator) { //display error alert on form submit              
                    success1.hide();
                    error1.show();
                    App.scrollTo(error1, -200);
                },

                highlight: function (element) { // hightlight error inputs
                    $(element)
                        .closest('.form-group').addClass('has-error'); // set error class to the control group
                },

                unhighlight: function (element) { // revert the change done by hightlight
                    $(element)
                        .closest('.form-group').removeClass('has-error'); // set error class to the control group
                },

                success: function (label) {
                    label
                        .closest('.form-group').removeClass('has-error'); // set success class to the control group
                },

                submitHandler: function (form) {
                    success1.show();
                    error1.hide();
                    $.post(WebUtil.getMainRoot()+'/addAnnouncement',{title:$("#title").val(),content:$("#editor1").val()},function(data){
                    	if(data.success == true){
                    		WebUtil.alertMessage(data.message,"success");
                    		
   	    			 	}else{
   	    			 		WebUtil.alertMessage(data.message,"danger");
   	    			 	}
                    	//$('#taskassign').DataTable().ajax.reload(null,false);//刷新
                    	
               	 	},"json");
                }
            });
    }
  
    var ckeditorJquery = function () { 
    	$('textarea#editor1').ckeditor();
    }
  
    return { 
        init: function () {
        	ckeditorJquery();
        	handleValidation1();
        }
    };

}();

jQuery(document).ready(function() {
   ComponentsEditors.init(); 
});
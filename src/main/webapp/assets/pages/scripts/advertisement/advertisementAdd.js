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
                    $.post(WebUtil.getMainRoot()+'/addAdvertisement',form1.serialize(),function(data){
                    	if(data.success == true){
                    		WebUtil.alertMessage(data.message,"success");
                    		
   	    			 	}else{
   	    			 		WebUtil.alertMessage(data.message,"danger");
   	    			 	}	
               	 	},"json");
                }
            });
    }
  
    var ckeditorJquery = function () {
    	$("#imageUpload").on("change",function(){
    		$.ajaxFileUpload({  
                url:WebUtil.getMainRoot()+'/multipartFileUpload',
                async:true,
                fileElementId:'imageUpload',//file标签的id  
                dataType:'text',//返回数据的类型  
                success:function (data,status) {
                	alert("data: " + data);
                },
                error:function (data,status,e) {  
                    alert(e);
                }  
            });
    	});
    }
  
    return { 
        init: function () {
        	ckeditorJquery();
        	handleValidation1();
        }
    };

}();

jQuery(document).ready(function() {
	
    $('#fileupload').fileupload({
        url: WebUtil.getMainRoot()+'/multipartFileUpload',
        dataType: 'json',
        done: function (e, data) {
            
        },
        progressall: function (e, data) {
            var progress = parseInt(data.loaded / data.total * 100, 10);
            $('#progress .progress-bar').css(
                'width',
                progress + '%'
            );
        }
    }).prop('disabled', !$.support.fileInput)
        .parent().addClass($.support.fileInput ? undefined : 'disabled');

	
    /*$("#imagePath").fileinput({
    	uploadUrl:'/multipartFileUpload',
        showUpload: false,
        maxFileCount: 10,
        mainClass: "input-group-lg"
    });*/
	
	/*$("#imagePath").fileinput({
	    uploadUrl:WebUtil.getMainRoot()+'/multipartFileUpload',
	    autoReplace: true,
	    maxFileCount: 1,
	    allowedFileExtensions: ["jpg", "png", "gif"]
	}).on("fileuploaded", function (e,data) {
        var res = data.response;
        if (res.state > 0) {
            alert(res.path);
        }
        else {
            alert('上传失败');
        }
    });*/
   ComponentsEditors.init(); 
});

//全局工具类
var WebUtil = function(){
 
	return{ 
		init: function(){ 
 
		},
		getMainRoot : function(){ 
			return "/sysManager"; 
		},
		//弹出提示框
		alertMessage : function(mssage,type){
				App.alert({
		            container:"#bootstrap_alerts_demo",// $('#alert_container').val(), // alerts parent container(by default placed after the page breadcrumbs)
		            place: "append",//$('#alert_place').val(), // append or prepent in container 
		            type: type,//$('#alert_type').val(),  // alert's type
		            message: mssage,////$('#alert_message').val(),  // alert's message
		            close: "1",//$('#alert_close').is(":checked"), // make alert closable
		            reset: "1",//$('#alert_reset').is(":checked"), // close all previouse alerts first
		            focus: "1",//$('#alert_focus').is(":checked"), // auto scroll to the alert after shown
		            closeInSeconds: "3",//$('#alert_close_in_seconds').val(), // auto close after defined seconds
		            icon: ""//$('#alert_icon').val() // put icon before the message
		        }); 
		}
	}
 
}();
 

jQuery(document).ready(function(){
	WebUtil.init();
});



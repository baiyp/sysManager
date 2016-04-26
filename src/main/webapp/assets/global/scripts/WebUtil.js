
//全局工具类
var WebUtil = function(){
	
	var updateParam = new Array();//点击编辑按钮需要用到的参数信息
 
	return{ 
		init: function(){//信息初始化请求
 
		},
		getMainRoot : function(){//
			return "/sysManager"; 
		},
		alertMessage : function(mssage,type){//弹出提示框
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
		},
		getUpdateParam:function(){
			return this.updateParam;
		},
		setUpdateParam:function(param){
			this.updateParam = param;
		},
		ajaxRequest:function(url,data,callback){//请求发送给后台服务
			$.ajax({  
   				url:url,// 跳转到 action  
   				data:data,  
   				type:'post',  
   				cache:false,  
   				dataType:'json',  
   				success:function(data) {
   					if(data.success == true){
   						WebUtil.alertMessage(data.message,"success");
   					}else{
   						WebUtil.alertMessage(data.message,"danger");
   					}
   					callback();
   				},  
   				error : function() {
   					WebUtil.alertMessage("请求失败","danger");
   				}  
   		 	});
		},
		getDateFormat:function(data){//将utc转换成yyyy-mm-dd hh:mm:ss
			if(data == undefined || data == null || data == "" || data == 0){
				return "";
			}
			var d = new Date(data*1000);
			return d.getFullYear()+"-"+(d.getMonth()+1) + "-" + d.getDate() + " " + d.getHours() +":" +d.getMinutes() +":" + d.getSeconds();
		}
	}
 
}();
 

jQuery(document).ready(function(){
	WebUtil.init();
});



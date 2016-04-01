var FormValidation = function () {

	var alertMessage = function(mssage,type){
		
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
	
	var sample_33 = function (taskId) {

        var table = $('#sample_33');

        //
        table.dataTable({
 
        	"language": {
                "processing": "处理中...",
                "lengthMenu": "显示 _MENU_ 项结果",
                "zeroRecords": "没有匹配结果",
                "info": "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
                "infoEmpty": "显示第 0 至 0 项结果，共 0 项",
                "infoFiltered": "(由 _MAX_ 项结果过滤)",
                "search": "搜索:",
                "emptyTable": "表中数据为空",
                "sLoadingRecords": "载入中...",
                "paginate": {
                    "first": "首页",
                    "previous": "上页",
                    "next": "下页",
                    "last": "末页"
                },
                "aria": {
                    "sortAscending": ": 以升序排列此列",
                    "sortDescending": ": 以降序排列此列"
                }
            },
            
            // Uncomment below line("dom" parameter) to fix the dropdown overflow issue in the datatable cells. The default datatable layout
            // setup uses scrollable div(table-scrollable) with overflow:auto to enable vertical scroll(see: assets/global/plugins/datatables/plugins/bootstrap/dataTables.bootstrap.js). 
            // So when dropdowns used the scrollable div should be removed. 
            //"dom": "<'row'<'col-md-6 col-sm-12'l><'col-md-6 col-sm-12'f>r>t<'row'<'col-md-5 col-sm-12'i><'col-md-7 col-sm-12'p>>",

            "bStateSave": true, // save datatable state(pagination, sort, etc) in cookie.
            "pagingType": "bootstrap_full_number",
            "processing": true,
            "serverSide": true,
            "ajax": "/sysManager/queryTaskClaimEn?taskId=" + taskId,
            "displayStart": 0,
            "pageLength": 15,
            "lengthMenu": [
                [6, 15, 20, -1],
                [6, 15, 20, "All"] // change per page values here
            ],
            "columns": [{"data":"id"},
                      {"data": "enterprise_name"}, 
                      {"data": "id"}
            ],
            "columnDefs": [
                        
                         {"targets":[0],
                             "orderable":false,
                             "searchable":false,
                             "render":function(data,full,meta){
                           	  	return "<input type=\"checkbox\" class=\"checkboxes\" value="+data+" /> </td>";
                              }
                           	 
                          },
                          
                          {
                             "targets": [2],
                             "width" :'150',
                             'orderable': false,
                             "searchable": false,
                             render: function (data,full, meta) { 
                            	 return "<button class=\"btn btn-sm green btn-outline audit-submit margin-bottom\" dataUrl="+meta.id+"|"+meta.accountid+"><i class=\"fa fa-times\"></i>确认</button>";
                             }
                         }
          
            ],
            "order": [
                [1, "asc"]
            ] // set first column as a default sort by asc
        });
        
        /*table.on("click",".audit-submit",function(){ 
        	//$('.modal').attr("dataAjax",$(this).attr("dataUrl"));
        });*/
     
        table.on("click",".audit-submit",function(){
        	var dataUrl = $(this).attr("dataUrl");
        	var arr=new Array();
        	if(dataUrl != undefined){
        		arr=dataUrl.split('|');
            	var id = arr[0];
            	var accountid = arr[1];
            	bootbox.setLocale("zh_CN");
            	bootbox.confirm("你确定将任务分派给该公司吗?", function(result) {
                   	if(result == true){
                   		$.ajax( {  
                   				url:'/sysManager/assignEnterprise',// 跳转到 action  
                   				data:{"taskId" :id,"accountId":accountid},  
                   				type:'post',  
                   				cache:false,  
                   				dataType:'json',  
                   				success:function(data) {
                   					if(data.success == true){
                   						alertMessage(data.message,"success");
                   					}else{
                   						alertMessage(data.message,"danger");
                   					} 
                   				},  
                   				error : function() {
                   					alertMessage(data.message,"danger");
                   				}  
                   		 }); 
                   	}
                });
            	$('#ajax').modal('hide');
        	}
        });
        

        var tableWrapper = jQuery('#sample_33_wrapper');

        table.find('.group-checkable').change(function () {
            var set = jQuery(this).attr("data-set");
            var checked = jQuery(this).is(":checked");
            jQuery(set).each(function () {
                if (checked) {
                    $(this).prop("checked", true);
                } else {
                    $(this).prop("checked", false);
                }
            });
            jQuery.uniform.update(set);
        });
    }
	 
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
                	/*$.ajax( {  
            			url:'/sysManager/auditAccount',//跳转到 action  
            			data:{"accountId" :$(".accountId").attr("value"),"auditStatus":2},  
            			type:'post',  
            			cache:false,  
            			dataType:'json',  
            			success:function(data) {
            				if(data.success = true){
            					alertMessage("选派公司成功","danger");

            				}else{
            					alertMessage("选派公司失败","danger");
            				}
            			},  
            			error : function() {
            				alertMessage("选派公司失败","danger");
            			}  
            	 });*/
                	$('#ajax').modal('hide');
                }
            });
    } 
    return { 
        init: function () {
        	sample_33($('.modal').attr("dataAjax"));
            handleValidation1();
        }
    };

}();

jQuery(document).ready(function() {
 
	/*$.ajax( {  
			url:'/sysManager/getTaskManage',// 跳转到 action  
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
	 });*/
    FormValidation.init();
});
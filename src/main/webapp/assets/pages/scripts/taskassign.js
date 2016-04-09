var TableDatatablesManaged = function () {
	
    var initPickers = function () {
        $('.date-picker').datepicker({
            rtl: App.isRTL(),
            autoclose: true
        });
    }
     
    var handleValidation1 = function() { 

            var form1 = $('#form_sample_1');
            var error1 = $('.alert-danger',form1);
            var success1 = $('.alert-success',form1);

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
                	contract_no: {//合同编号
                        minlength: 2,
                        maxlength:20,
                        required: true
                    },
                    work_days: {//工期天数
                    	maxlength:5,
                        required: true
                    },
                    datepicker: {//工期天数
                        required: true
                    },
                    contract_sum: {//交易金额
                        required: true,
                        number: true
                    },
                    work_qualification: {//加工资质
                        required: true
                    }
                },

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
                    label
                        .closest('.form-group').removeClass('has-error'); // set success class to the control group
                }, 
                submitHandler: function (form) { 
                    $.post('/sysManager/assignEnterprise',{contract_no:$("#contract_no").val(),work_qualification:$("#work_qualification").val(),remark:$("#remark").val(),taskId:$("#taskId").val(),accountId:$("#accountId").val(),work_days:$("#work_days").val(),datepicker:$("#datepicker").val(),contract_sum:$("#contract_sum").val()},function(data){
                    	if(data.success == true){ 
                    		$('#stack1').modal('hide');
                    		$('#ajax').modal('hide');
                    		WebUtil.alertMessage(data.message,"success");
                    		$('#taskassign').DataTable().ajax.reload(null,false);//刷新
   	    			 	}else{
   	    			 		WebUtil.alertMessage(data.message,"danger");
   	    			 	}
                    	
               	 	},"json");
                }
            });
            
            form1.on("click",".taskAssignUpClose",function(){
            	$('#stack1').modal('hide');
            });
    }
 
    
    
 
	var initTable3 = function () {

        var table = $('#taskassign');
  
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
            "ajax": WebUtil.getMainRoot()+"/taskAssign",
            "displayStart": 0,
            "pageLength": 10,
            "lengthMenu": [
                [6, 15, 20, -1],
                [6, 15, 20, "All"] // change per page values here
            ],
            "columns": [
                       {"data": "id"},
                      {"data": "title"},
                      {"data": "taskTypeName"},
                      {"data": "enterprise_name"},
                      {"data": "time"},
                      {"data": "edit_time"},
                      {"data": "view_count"},
                      {"data": "bid_count"},
                      {"data": "flag"},
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
                        	  "targets":[1],
                        	  "width" :'250',
                        	  "render":function(data,full,meta){ 
                        		  return data;
                        	  }
                          },
                          {
                        	  "targets":[4],
                        	  "orderable":false,
                        	  "searchable":false,
                        	  "render":function(data,full,meta){
                        		  if(data == 0){
                        			  return "";
                        		  }
                        		  var d = new Date(data*1000);
                        		  return d.getFullYear()+"-"+(d.getMonth()+1) + "-" + d.getDate() + " " + d.getHours() +":" +d.getMinutes() +":" + d.getSeconds();
                        	  }
                          },
                          {
                        	  "targets":[5],
                        	  "orderable":false,
                        	  "searchable":false,
                        	  "render":function(data,full,meta){
                        		  if(data == 0){
                        			  return "";
                        		  }
                        		  var d = new Date(data*1000);
                        		  return d.getFullYear()+"-"+(d.getMonth()+1) + "-" + d.getDate() + " " + d.getHours() +":" +d.getMinutes() +":" + d.getSeconds();
                        	  }
                          },
                          {   "targets":[8],
                              "orderable":false,
                              "searchable":false,
                              "render":function(data,full,meta){//任务状态：0进行中；1 已完成；2 无人认领
                            	 var html  = "" ;
                            	 if(data == 2){
                            		  html = "无人认领";
                            	  }else if(data == 1){
                            		  html = "已完成";
                            	  }else{
                            		  html="进行中";
                            	  }
                            	  return html;
                               }
                          },
                          {
                             "targets": [9],
                             "width" :'150',
                             'orderable': false,
                             "searchable": false,
                             render: function (data,full, meta) {
                            	 return "<button data-target=\"#ajax\" data-toggle=\"modal\" href=\"taskxuanpai.html\" class=\"btn btn-sm green btn-outline audit-submit margin-bottom\" dataUrl="+meta.id+" ><i class=\"fa fa-hand-pointer-o\"></i>选派</button> <button class=\"btn btn-sm red btn-outline forbidden-submit\" dataUrl="+meta.id+"|"+meta.username+"><i class=\"fa fa-times\"></i>终止</button>";
                             }
                         }
          
            ],
            "order": [
                [1, "asc"]
            ]
        });
        
        table.on("click",".audit-submit",function(){
        	$('.modal').attr("dataAjax",$(this).attr("dataUrl"));
        });
 
     
        table.on("click",".forbidden-submit",function(){
        	var dataUrl = $(this).attr("dataUrl");
        	var arr=new Array();
        	if(dataUrl != undefined){
        		arr=dataUrl.split('|');
            	var id = arr[0];
            	var username = arr[1];
            	bootbox.setLocale("zh_CN");
            	bootbox.confirm("你确定要终止选派吗?", function(result) {
                   	if(result == true){
                   		$.ajax( {  
                   				url:WebUtil.getMainRoot()+'/suspendTask',// 跳转到 action  
                   				data:{"taskId":id},  
                   				type:'post',  
                   				cache:false,  
                   				dataType:'json',  
                   				success:function(data) {
                   					if(data.success == true){
                   						WebUtil.alertMessage(data.message,"success");  
                   					}else{
                   						WebUtil.alertMessage(data.message,"danger");
                   					}
                   					$('#taskassign').DataTable().ajax.reload(null,false);
                   				},  
                   				error : function() {
                   					WebUtil.alertMessage(data.message,"danger");
                   				}  
                   		 }); 
                   	}
                });
        		
        	}
        });
        
        var tableWrapper = jQuery('#taskassign_wrapper');

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

    return {
        init: function () {
            if (!jQuery().dataTable) {
                return;
            }
            initPickers();
            handleValidation1();
            initTable3();
        }

    };

}();

if (App.isAngularJsApp() === false) { 
    jQuery(document).ready(function() {
        TableDatatablesManaged.init();
    });
}
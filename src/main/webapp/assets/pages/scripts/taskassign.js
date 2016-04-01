var TableDatatablesManaged = function () {
	
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
	var initTable3 = function () {

        var table = $('#sample_3');

        // begin: third table
        table.dataTable({

            // Internationalisation. For more info refer to http://datatables.net/manual/i18n
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
            "ajax": "/sysManager/taskAssign",
            "displayStart": 0,
            "pageLength": 15,
            "lengthMenu": [
                [6, 15, 20, -1],
                [6, 15, 20, "All"] // change per page values here
            ],
            "columns": [{"data":"id"},
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
                             render: function (data,full, meta ) { 
                            	 return "<button data-target=\"#ajax\" data-toggle=\"modal\" href=\"taskxuanpai.html\" class=\"btn btn-sm green btn-outline audit-submit margin-bottom\" dataUrl="+meta.id+" ><i class=\"fa fa-hand-pointer-o\"></i>选派</button> <button class=\"btn btn-sm red btn-outline forbidden-submit\" dataUrl="+meta.id+"|"+meta.username+"><i class=\"fa fa-times\"></i>终止</button>";
                             }
                         }
          
            ],
            "order": [
                [1, "asc"]
            ] // set first column as a default sort by asc
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
                   				url:'/sysManager/deleteTaskManage',// 跳转到 action  
                   				data:{"taskId" :id},  
                   				type:'post',  
                   				cache:false,  
                   				dataType:'json',  
                   				success:function(data) {
                   					if(data.success == true){
                   						alertMessage(data.message,"success"); 
                   						//table.ajax.reload();
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
        		
        	}
        });
        

        var tableWrapper = jQuery('#sample_3_wrapper');

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

        //main function to initiate the module
        init: function () {
            if (!jQuery().dataTable) {
                return;
            }
 
            initTable3();
        }

    };

}();

if (App.isAngularJsApp() === false) { 
    jQuery(document).ready(function() {
        TableDatatablesManaged.init();
    });
}
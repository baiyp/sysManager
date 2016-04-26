var TableDatatablesManaged = function () {
 
	
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
            "ajax":WebUtil.getMainRoot()+"/queryEnterprise?userinfo=0",//userinfo 0 表示普通企业用户  1企业VIP用户
            "displayStart":0,
            "pageLength":10,
            "lengthMenu":[
                [6, 15, 20, -1],
                [6, 15, 20, "All"] // change per page values here
            ],
            "columns": [{"data":"id"},
                      {"data": "username"},//登录账号
                      {"data": "enterprise_name"},//企业名称
                      {"data": "en_bus_license_no"},//执照编号 
                      {"data": "business_entity"},//企业法人
                      {"data": "enterprise_tel"},//企业电话 
                      {"data": "registered_capital"},//注册资本
                      {"data": "business_volume"},//年营业额
                      {"data": "register_date"},//注册时间 
                      {"data": "user_mode"},//账号状态
                      {"data": "audit_status"},//用户状态
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
                        	  "targets":[8],
                        	  "orderable":false,
                        	  "searchable":false,
                        	  "width" :'120',
                        	  "render":function(data,full,meta){
                        		  if(data == 0){
                        			  return "";
                        		  }
                        		  return WebUtil.getDateFormat(data);
                        	  }
                          },
                          {   "targets":[9],
                              "orderable":false,
                              "searchable":false,
                              "render":function(data,full,meta){
                            	 var html  = "" ;
                            	 if(data == 0){
                            		  html = "启用";
                            	  }else{
                            		  html="禁用";
                            	  }
                            	  return html;
                               }
                          },
                          {   "targets":[10],
                              "orderable":false,
                              "searchable":false,
                              "render":function(data,full,meta){
                            	 var html  = "" ;
                            	 if(data == 2){
                            		  html = "审核通过";
                            	  }else if(data == 1){
                            		  html = "审核未通过";
                            	  }else{
                            		  html="未审核";
                            	  }
                            	  return html;
                               }
                          },
                          {
                             "targets": [11],
                             "width" :'150',
                             'orderable': false,
                             "searchable": false,
                             render: function (data,full, meta ) { 
                            	 return "<button data-target=\"#ajax\" data-toggle=\"modal\" href=\"enterpriseAudit.html?accountId="+meta.id+"\" class=\"btn btn-sm green btn-outline audit-submit margin-bottom\" dataUrl="+meta.id+" ><i class=\"fa fa-hand-pointer-o\"></i> 审核</button> <button class=\"btn btn-sm red btn-outline forbidden-submit\" dataUrl="+meta.id+"|"+meta.username+"><i class=\"fa fa-times\"></i> 禁用</button>";
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
            	bootbox.confirm("你你确定要禁用"+username+"账号吗?", function(result) {
                   	if(result == true){
                   		$.ajax( {  
                   				url:'/sysManager/forbiddenAccount',// 跳转到 action  
                   				data:{"accountId":id},  
                   				type:'post',  
                   				cache:false,  
                   				dataType:'json',  
                   				success:function(data) {
                   					if(data.success == true){
                   						WebUtil.alertMessage("账号"+username+"禁用成功","success");
                   					}else{
                   						WebUtil.alertMessage("账号"+username+"禁用失败","danger");
                   					}
                   					$('#sample_3').DataTable().ajax.reload(null,false);
                   				},  
                   				error : function() {
                   					WebUtil.alertMessage("账号"+username+"禁用失败","danger");
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
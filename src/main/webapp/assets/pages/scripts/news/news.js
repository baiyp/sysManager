var TableDatatablesManaged = function () {
	
	
	var loadDataTables = function(){
		$('#sample_3').DataTable().ajax.reload(null,false);	
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
            "ajax": WebUtil.getMainRoot()+"/queryNews",
            "displayStart": 0,
            "pageLength": 15,
            "lengthMenu": [
                [6, 15, 20, -1],
                [6, 15, 20, "All"] // change per page values here
            ],
            "columns": [{"data":"id"},
                      {"data": "title"},
                      {"data": "userName"},
                      {"data": "create_Date"}, 
                      {"data": "id"}
            ],
            "columnDefs": [
                         {"targets":[0],
                          "orderable":false,
                          "searchable":false,
                          "render":function(data,full,meta){
                           	  			return "<input type=\"checkbox\" class=\"checkboxes\" name=\"checkboxes\" value="+data+" /> </td>";
                          			}
                           	 
                          },
                          {
                        	  "targets":[3],
                        	  "orderable":false,
                        	  "searchable":false,
                        	  "render":function(data,full,meta){
                        		  if(data == 0){
                        			  return "";
                        		  }
                        		  return WebUtil.getDateFormat(data);
                        	  }
                          },
                          {
                             "targets": [4],
                             "width" :'15%',
                             'orderable': false,
                             "searchable": false,
                             render: function (data,full,meta) {
                            	 //<button class=\"btn btn-sm green btn-outline audit-submit margin-bottom ajaxify\" href=\"form_fileupload.html\" ajaxScript=\"../assets/pages/scripts/form-fileupload.js\"><i class=\"fa fa-hand-pointer-o\"></i> 查看</button> <button class=\"btn btn-sm red btn-outline forbidden-submit\"><i class=\"fa fa-times\"></i>删除</button>
                                 return "<button  data-target=\"#ajax\" dataUrl="+meta.id+" data-toggle=\"modal\" class=\"btn btn-sm green btn-outline  audit-submit margin-bottom\" href=\"news/newsDetails.html\"><i class=\"fa fa-hand-pointer-o\"></i> 查看</button> <button dataUrl="+meta.id+" class=\"btn btn-sm red btn-outline forbidden-submit\"><i class=\"fa fa-times\"></i>删除</button>";
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
        	if(dataUrl != undefined){ 
            	bootbox.setLocale("zh_CN");
            	bootbox.confirm("你确定要删除该新闻信息吗?", function(result) {
                   	if(result == true){
                   		WebUtil.ajaxRequest(WebUtil.getMainRoot()+'/deleteNews',{"newsId" :dataUrl},loadDataTables);
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
    };
    
	var batchDelete = function(){
		var batch = new Array();
		$("#batch-delete").on("click",function(){
			 $("input[name='checkboxes']:checked").each(function(){
				 batch.push($(this).val());
			 });
			 if(batch.length > 0){
				 bootbox.setLocale("zh_CN");
	            	bootbox.confirm("你确定要删除所选的新闻吗?", function(result) {
	                   	if(result == true){
	                   		WebUtil.ajaxRequest(WebUtil.getMainRoot()+'/deleteNews',{"newsId":batch.join()},loadDataTables);
	                   	}
	                });
				 
			 }else{
				 alert("请选择一条记录进行删除");
			 }
		});
	}
    
    var updateNotes = function(){
		$("#update").on("click",function(){
			var updateId = new Array();
			$("input[name='checkboxes']:checked").each(function(){
				updateId.push($(this).val());
			});
			WebUtil.setUpdateParam(updateId);
		});
	}

    return {

        init: function () {
            if (!jQuery().dataTable) {
                return;
            }
 
            initTable3();
            updateNotes();
            batchDelete();
        }

    };

}();

if (App.isAngularJsApp() === false) { 
    jQuery(document).ready(function() {
        TableDatatablesManaged.init();
    });
}
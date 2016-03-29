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
            "ajax": "/sysManager/queryAccount?userType=0",
            "displayStart": 0,
            "pageLength": 15,
            "lengthMenu": [
                [6, 15, 20, -1],
                [6, 15, 20, "All"] // change per page values here
            ],
            "columns": [{"data":"id"},
                      {"data": "username"},
                      {"data": "full_name"},
                      {"data": "sex"},
                      {"data": "diploma"},
                      {"data": "graduate_institutions"},
                      {"data": "profession"},
                      {"data": "work_unit"},
                      {"data": "register_date"},
                      {"data": "audit_status"},
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
                          {   "targets":[3],
                              "orderable":false,
                              "searchable":false,
                              "render":function(data,full,meta){
                            	 var html  = "" ;
                            	 if(data == 0){
                            		  html = "男";
                            	  }else{
                            		  html = "女";
                            	  }
                            	  return html;
                               }
                            	 
                          },
                          {
                        	  "targets":[8],
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
                          {   "targets":[9],
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
                             "targets": [10],
                             "width" :'10%',
                             'orderable': false,
                             "searchable": false,
                             render: function (data,full,meta) { 
                                 return "<button class=\"btn btn-sm green btn-outline audit-submit margin-bottom ajaxify\" href=\"form_fileupload.html\" ajaxScript=\"../assets/pages/scripts/form-fileupload.js\"><i class=\"fa fa-hand-pointer-o\"></i> 审核</button> <button class=\"btn btn-sm red btn-outline forbidden-submit\"><i class=\"fa fa-times\"></i> 禁用</button>";
                             }
                         }
          
            ],
            "order": [
                [1, "asc"]
            ] // set first column as a default sort by asc
        });
        
        /*table.on("click",".audit-submit",function(){
        	
        	alert("udit-submit");
        	
        });*/
        
        table.on("click",".forbidden-submit",function(){
        	alert("forbidden-submit");
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
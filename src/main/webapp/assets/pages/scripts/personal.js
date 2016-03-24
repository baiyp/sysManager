var TableDatatablesManaged = function () {
 

       
    var initTable3 = function () {

        var table = $('#sample_3');

        // begin: third table
        table.dataTable({
            // Internationalisation. For more info refer to http://datatables.net/manual/i18n
        	//"pagingType": "bootstrap_full_number",
        	"bPaginate": false,
            "pagingType": "full_numbers",
            "scrollX":true,
        	"language" : {
  				  "sProcessing" : "正在获取数据，请稍后...",  
  		         "sLengthMenu": "_MENU_ 记录/页",
  		         "sZeroRecords": "抱歉， 没有找到",
  		         "sInfo": "从 _START_ 到 _END_ /共 _TOTAL_ 条数据",
  		         "sInfoEmpty": "显示第 0 至 0 项记录，共 0 项",
  		         "sInfoFiltered": "(从 _MAX_ 条数据中检索)",
  		         "sZeroRecords": "没有检索到数据",
  		         "sSearch": "搜索:",
  		         "oPaginate": {
  		             "sFirst": "首页",
  		             "sPrevious": "前一页",
  		             "sNext": "后一页",
  		             "sLast": "尾页"     
  		         }, 
        	},
        	
            // Uncomment below line("dom" parameter) to fix the dropdown overflow issue in the datatable cells. The default datatable layout
            // setup uses scrollable div(table-scrollable) with overflow:auto to enable vertical scroll(see: assets/global/scripts/datatable.js). 
            // So when dropdowns used the scrollable div should be removed. 
            //"dom": "<'row'<'col-md-8 col-sm-12'pli><'col-md-4 col-sm-12'<'table-group-actions pull-right'>>r>t<'row'<'col-md-8 col-sm-12'pli><'col-md-4 col-sm-12'>>",
            
            //"bStateSave": true, // save datatable state(pagination, sort, etc) in cookie.
        	"processing": true,
            "serverSide": true,
            "ajax": "/sysManager/queryAccount",
            "displayStart": 1,
            "pageLength": 15,
            "lengthMenu": [
                           [5, 15, 20, -1],
                           [5, 15, 20, "All"] // change per page values here
            ],
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
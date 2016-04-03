var TableDatatablesManaged = function () {

	var handleRecords = function () {

        var grid = new Datatable(); 
        grid.init({
            src: $("#sample_3"), 
            onSuccess: function (grid, response) {
                // grid:        grid object
                // response:    json object of server side ajax response
                // execute some code after table records loaded
            	//alert("onSuccess");
            },
            onError: function (grid) {
             	//alert("onError" + grid);
                // execute some code on network or other general error  
            },
            onDataLoad: function(grid) {
            	//alert("onDataLoad" + grid);
            },
            loadingMessage: '正在加载数据,请稍等...',
            dataTable: { // here you can define a typical datatable settings from http://datatables.net/usage/options
            	//"dom": '<lf<t>ip>',  
            	//"renderer": "bootstrap",       	
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
                // setup uses scrollable div(table-scrollable) with overflow:auto to enable vertical scroll(see: assets/global/scripts/datatable.js). 
                // So when dropdowns used the scrollable div should be removed. 
                //"dom": "<'row'<'col-md-8 col-sm-12'pli><'col-md-4 col-sm-12'<'table-group-actions pull-right'>>r>",
            	//'dom': '<"float_left"f>r<"float_right"l>tip',
                //"bStateSave": true, // save datatable state(pagination, sort, etc) in cookie.
            	"processing": true,
                "serverSide": true,
                "ajax": "/sysManager/queryAccount",
                "displayStart": 1,
                "pageLength": 15,
                "pagingType": "bootstrap_full_number",
                "dom": "<'row'<'col-md-6 col-sm-12'l><'col-md-6 col-sm-12'f>r>t<'row'<'col-md-5 col-sm-5'i><'col-md-7 col-sm-7'p>>",
                //"scrollX": true,
                "lengthMenu": [
                               [5, 15, 20, -1],
                               [5, 15, 20, "All"] // change per page values here
                ], 
                "columnDefs": [{  // set default column settings
                    'orderable': false,
                    'targets': [0]
                }, {
                    "searchable": false,
                    "targets": [0]
                }],
                "order": [
                    [1, "asc"]
                ]
            }
        });

      
        grid.getDataTable().ajax.reload();
         
        //grid.clearAjaxParams();
    }

    return {
 
        init: function () {
            handleRecords();
        }

    };

}();
jQuery(document).ready(function() {
	
    TableDatatablesManaged.init();
});
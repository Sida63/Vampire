$(document).ready(function(){
	
	setupOrderPeek();
	setupstatuslines();
});


//=========== Order Peek ===========================================================
function setupOrderPeek() {
	// hide template line
	$(".orderpeektempline").hide();

	// add handler
	$("#order-peek-reload").click(function(){
		loadorders();
		return false;
	});

	// reflesh at intervals
	setInterval(function(){
		loadorders();
	},15000);

    // do it now~
    loadorders();
}

function loadorders() {
	var block = $(".orderpeek").parents('[class^=block]');
	add_loader(block);

	$.ajax({
		type: "get",
		dataType: "json",
        url: "AetfTestJSONServlet",//要访问的后台地址, 注意！！！改这里
        //data: "pageIndex=" + pageIndex,//要发送的数据, 注意！！！改这里

        complete :function(){remove_loader(block);},
        
        /*
		 * msg 是JSON对象
		 * 表示一个order实体的数组
		 */
		 success: function(msg) {
        	// clear the table, but leave the template line.
        	$(".orderpeek tbody").find("tr:not(.orderpeektempline)").remove();
        	var orders = msg.orders;
        	$.each(orders, function(idx, item){
        		var row = $(".orderpeektempline").clone();
        		$(row).removeClass("orderpeektempline");
        		$(row).show();

        		row.find(".orderstatus").text(item.Status.OrderStatus);
        		row.find(".ordernum").text(item.OrderNumber);
        		row.find(".orderdate").text(item.Time);
        		row.find(".ordercontent").text(item.Content);
        		row.find(".orderuser").text(item.User.UserName);

        		row.appendTo(".orderpeek tbody");
        	});
        }
    });
}

//=========== Status Lines ===========================================================
function setupstatuslines() {
	if($("#main_chart").length > 0){

        /* CHART - 1*/       
                        
        var visits = [[1, 1235], [2, 1245], [3, 1590], [4, 1420], [5,1713], [6,1921], [7,1869], [8, 1790], [9,2314], [10,2490], [11,2175], [12,1989]];
        var orders = [[1, 140], [2, 246], [3, 530], [4, 788], [5,832], [6,962], [7,1280], [8, 1299], [9,1410], [10,1569], [11,1492], [12,1350]];
        var sales = [[1, 50], [2, 100], [3, 140], [4, 190], [5,250], [6,360], [7,440], [8, 650], [9,750], [10,810], [11,980], [12,1102]];
        
        $.plot($("#main_chart"),
        	[ { data: visits, label: "访问量"}, { data: orders, label: "订单量"}, {data: sales, label: "销售额"} ],
        	{
                series: {lines: { show: true }, points: { show: true }},
                grid: { hoverable: true, clickable: true },
                yaxis: { min: 1, max: 3000, tickLength: 0 },
                xaxis: { labelWidth: 30, tickLength: 0 }
            });

        /* eof CHART - 1*/
    
    }
}
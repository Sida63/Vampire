$(document).ready(function() {
	$(".new").hide();
	loadorders();
});

function loadorders() {
	$(".latest_hot").find(".s_item:not(.new)").remove();

	$.ajax({
		type : "get",
		dataType : "json",
		url : "/Vampire/silver/goods/hot/json",// 要访问的后台地址,

		success : function(msg) {
			$.each(msg, function(idx, item) {
				var row = $(".new").clone();
				$(row).removeClass("new");
				
				row.find(".s_model").text(item.goodsName);
				var price = item.goodsDetail.price.toFixed(2);
				row.find(".price").text(price);
				
				$(row).show();
				row.appendTo(".latest_hot");
			});
		}
	});
}
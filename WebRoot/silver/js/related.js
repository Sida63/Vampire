$(document).ready(function() {
	$(".related_goods").hide();
	loadorders();
});

function loadorders() {
	$(".related").find(".s_item:not(.related_goods)").remove();

	$.ajax({
		type : "get",
		dataType : "json",
		url : "/Vampire/silver/goods/related",// 要访问的后台地址,

		success : function(msg) {
			$.each(msg, function(idx, item) {
				var row = $(".related_goods").clone();
				$(row).removeClass("related_goods");
				$(row).show();
				row.find(".name").text(item.goodsName);
				var price = item.goodsDetail.price.toFixed(2);
				row.find(".price").text(price);
				row.find(".image").attr("src",item.goodsDetail.imgPath);
				
				row.appendTo(".related");
			});
		}
	});
}
$(document).ready(function() {
	loadorders1();
	loadorders2();
});
function loadorders1() {
	$(".qianhaofirst").hide();
	$(".preview_hotgoods").hide();
	$.ajax({
		type : "get",
		dataType : "json",
				url : "/Vampire/silver/goods/hot/json",// 要访问的后台地址,

				success : function(msg) {
					$.each(msg, function(idx, item) {
						var row = $(".qianhaofirst").clone();
						$(row).removeClass("qianhaofirst");
						var row2 = $(".preview_hotgoods").clone();
						$(row2).removeClass("preview_hotgoods");
						
						row.find(".hotname").text(item.goodsName);
						row.find(".s_desc").text(item.goodsDetail.goodsDesc);
						var qprice = item.goodsDetail.price.toFixed(2);
						row.find(".q_price").text("￥" + qprice);
						
						row2.find(".hot_img").attr(
							'src',
							"/Vampire/" + item.goodsDetail.imgPath
							+ "/0.png");
						row2.appendTo(".slides_container");
						row.appendTo(".hotqh");

						if (idx == 4) {
							$(row).show();
							$(row2).show();
						}
					});
					$('.qianhaofirst').remove();
					$('.preview_hotgoods').remove();
				},
				complete : function() {
					jQuery(function($) {

						var site_options = {
							'main_color' : '#71b013',
							'secondary_color' : '#ff9900'
						}

						// Slider options
						$("#product_intro_preview")
						.slides(
						{
							slideSpeed : 500,
							next : 's_button_next',
							prev : 's_button_prev',
							play : 5000,
							generatePagination : false,
							animationStart : function() {
								$(
									"#product_intro_info > div:visible")
								.fadeOut('slow');



							},
							animationComplete : function(
								current) {
								number = $(
									"#product_intro_preview div.slideItem")
								.index(
									$("#product_intro_preview div.slideItem:visible"));
								$("#product_intro_info > div")
								.eq(number).fadeIn();
							}
						});

						// Next/Prev buttons hover effect
						$("#intro .s_button_prev, #intro .s_button_next")
						.hover(
							function() {
								$(this)
								.stop()
								.animate(
								{
									backgroundColor : site_options.secondary_color
								}, 300);
							},
							function() {
								$(this)
								.stop()
								.animate(
								{
									backgroundColor : site_options.main_color
								}, 300);
							});

					});
}
});
}

function loadorders2() {
	$(".new").hide();

	$.ajax({
		type : "get",
		dataType : "json",
		url : "/Vampire/silver/goods/latest/json",// 要访问的后台地址,

		success : function(msg) {
			$.each(msg, function(idx, item) {
				var row = $(".new").clone();
				$(row).removeClass("new");

				row.find(".s_model").text(item.goodsName);
				var price = item.goodsDetail.price.toFixed(2);
				row.find(".price").text(price);
				row.find('.yaes_cart_add_btn').attr('yaes-item-id', item.id);
				row.find('.images_path').attr('src',
					"/Vampire/" + item.goodsDetail.imgPath + "/0.png");
				$(row).show();
				row.appendTo(".latest_hot");
			});
		}
	});
}
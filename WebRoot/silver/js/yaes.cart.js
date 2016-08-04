jQuery(function($){

	// cart options
	$('.yaes_cart').cart({
		cartUrl : "cart.jsp",
		cartText : "购物车",
		cartNoGoodsHTML : '<span class="yaes_nogoods_icon"></span><span>购物车中还没有商品，赶快选购吧~</span>',
		dollarSign : '￥',

		// !!! Must be set to work properly.
		// item = { id: 1234, cnt: 2, img: "images/acs.png", data:{}}
		// $listItem : the jquery object represents the list item in cart.
		// return = {title: 'spring goods', price: '2.34'}
		onItemDirty: function(item, $listItem) {
			var t = ' ', p = ' ';
			$.ajax({
				async: false,
				type: "get",
		        dataType: "json",
		        url: "goods/"+item.id+"/detail",
		        success: function(msg) {
		        	$listItem.find('a').attr('title', msg.goodsName);
					$listItem.find('.yaes_cart_item_text p:first').text(msg.goodsName);
					$listItem.find('.yaes_cart_item_price em').text(msg.goodsDetail.price.toFixed(2));
		        }
			});
		},

		// item = { id: 1234, cnt: 2, img: "images/acs.png", data:{}}
		// return = a url points to a detailed page of the item.
		urlFor: function(item) {
			return 'product.jsp?id='+item.id;
		}
	});
});
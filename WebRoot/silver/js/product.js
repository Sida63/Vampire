$(document).ready(function(){
	
	$.ajax({
		type: "get",
		dataType: "json",
        url: "/Vampire/silver/goods/detail",//要访问的后台地址, 注意！！！改这里
        //data: "pageIndex=" + pageIndex,//要发送的数据, 注意！！！改这里
		/*
		 * msg 是JSON对象 表示一个order实体的数组
		 */
		success : function(good) {
			
			$("#storage").text(good.goodsDetail.storage);
    		$("#type").text(good.type.typeName);
    		$("#provider").text(good.goodsDetail.provider);
    		$("#sales").text(good.goodsDetail.sales);
    		$("#price").text(good.goodsDetail.price);
    		$("#description").text(good.goodsDetail.description);
    		$("#image").attr("src",good.goodsDetail.imgPath);
		}
	});
	
	
});

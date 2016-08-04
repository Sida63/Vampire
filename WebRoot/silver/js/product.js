$(document).ready(function(){
	
	$.ajax({
		type: "get",
		dataType: "json",
        url: "/Vampire/silver/goods/detail",//Ҫ���ʵĺ�̨��ַ, ע�⣡����������
        //data: "pageIndex=" + pageIndex,//Ҫ���͵�����, ע�⣡����������
		/*
		 * msg ��JSON���� ��ʾһ��orderʵ�������
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

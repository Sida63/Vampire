$(document).ready(function() {

	setupOrderPeek();
	
});

// =========== Order Peek
// ===========================================================
function setupOrderPeek() {
	// hide template table
	$(".ordertemplateline1").hide();
	$(".ordertemplateline2").hide();
//	$(".detailtemplate").hide();
	loadorders();
}

function loadorders() {
	$.ajax({
		type : "post",
		dataType : "json",
		url : "/Vampire/garlic/user/orderman/load",// 要访问的后台地址, 注意！！！改这里
		// data: "pageIndex=" + pageIndex,//要发送的数据, 注意！！！改这里
		complete : function() {
			tableElementsInit();},
		/*
		 * msg 是JSON对象 表示一个order实体的数组
		 */
		success : function(msg) {
			// clear the table, but leave the template line.
//			$(".dtable1").find("table1:not(.ordertemplate)").remove();
//			$(".ordertemplate").find("tr:not(.ordertemplateline1)").remove();
			$(".orderTable tbody").empty();
//			$(".tbody2").find("tr:not(.orderpeektempline1)").remove();
//			$(".tbody2").find("tr:not(.orderpeektempline,.orderpeektempline1)").remove();
			$.each(msg, function(idx, item) {
				var table = $(".ordertemplateline1").clone();
				$(table).removeClass("ordertemplateline1");
				
				table.find(".id").text(item.id)
				table.find(".orderstatus").text(item.status.orderStatus);
				table.find(".ordernum").text(item.orderNumber);
				table.find(".orderdate").text(item.time);
				table.find(".ordercontent").text(item.remark);
				table.find(".orderuser").text(item.user.userName);
				table.find(".amount").text(item.totalAmount);
//				$.each(item.orderDetails, function(iidx, iitem) {
//					var row1 = $(".detailtemplate").clone();
//					$(row1).removeClass("detailtemplate");
//					row1.find(".goodsName").text(iitem.goods.goodsName);
//					row1.find(".goodsNumber").text(iitem.goods.goodsNumber);
//					row1.find(".tags").text(iitem.goods.tags);
//					row1.find(".typeName").text(iitem.goods.type.typeName);
//					row1.find(".price").text(iitem.price);
//					row1.appendTo(table.find(".tbody2"));
//					$(row1).show();
//				});
				
				$(table).show();
				$(table).appendTo(".orderTable tbody");
			});
		}
	});
}

function tableElementsInit() {
	// modify coupon property
	$(".looklook").click(function() {
		var chosen = $(this).parents("tr");
		var id = chosen.find(".id").text();
		
		
		$.ajax({
			type : "post",
			dataType : "json",
			url : "/Vampire/garlic/user/orderman/table",
			data : {
				id : id
			},
			success : function(msg) {
				
				$(".orderdetail tbody").find("tr:not(.ordertemplateline2)").remove();
//				$(".tbody2").find("tr:not(.orderpeektempline1)").remove();
//				$(".tbody2").find("tr:not(.orderpeektempline,.orderpeektempline1)").remove();
				$.each(msg, function(idx, item) {
					var row1 = $(".ordertemplateline2").clone();
					$(row1).removeClass("ordertemplateline2");


						$(row1).removeClass("ordertemplateline2");
						row1.find('.imgsrc').attr('src',
								"/Vampire/" + item.goods.goodsDetail.imgPath + "/0.png");
						row1.find(".goodsName").text(item.goods.goodsName);
						row1.find(".goodsNumber").text(item.goods.goodsNumber);
						row1.find(".tags").text(item.goods.tags);
						row1.find(".typeName").text(item.goods.type.typeName);
						row1.find(".price").text(item.price);
						$(row1).show();
						$(row1).appendTo(".orderdetail tbody");

				})
			}
		});
	})

	
	
	
	};
// =========== Status Lines
// ===========================================================

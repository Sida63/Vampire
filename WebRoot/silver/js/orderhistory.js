$(document).ready(function() {

	setupOrderPeek();
	
});

// =========== Order Peek
// ===========================================================
function setupOrderPeek() {
	// hide template table
	$(".ordertemplate").hide();
	$(".detailtemplate").hide();
	loadorders();
}

function loadorders() {
	$.ajax({
		type : "get",
		dataType : "json",
		url : "/Vampire/silver/user/orderhistory",// Ҫ���ʵĺ�̨��ַ, ע�⣡����������
		// data: "pageIndex=" + pageIndex,//Ҫ���͵�����, ע�⣡����������

		// complete :function(){remove_loader(block);},
		complete: function() {
			$(".tbody2").click(function(){
				$(this).slideUp();
			});
			$(".tbody1").click(function(){
				$(this).parents("table").find(".tbody2").slideDown();
			});
		},

		/*
		 * msg ��JSON���� ��ʾһ��orderʵ�������
		 */
		success : function(msg) {
			// clear the table, but leave the template line.
			$(".dtable1").find("table:not(.ordertemplate)").remove();
//			$(".tbody2").find("tr:not(.orderpeektempline1)").remove();
//			$(".tbody2").find("tr:not(.orderpeektempline,.orderpeektempline1)").remove();
			$.each(msg, function(idx, item) {
				var table = $(".ordertemplate").clone();
				$(table).removeClass("ordertemplate");
				
				table.find(".orderstatus").text(item.status.orderStatus);
				if(item.status.id==3){
					table.find(".orderstatus").addClass("green-label");
				} else if(item.status.id==1) {
					table.find(".orderstatus").addClass("red-label");
				}
				table.find(".ordernum").text(item.orderNumber);
				table.find(".orderdate").text(item.time);
				table.find(".ordercontent").text(item.remark);
				table.find(".orderuser").text(item.user.userName);
				table.find(".amount").text(item.totalAmount);
				$.each(item.orderDetails, function(iidx, iitem) {
					var row1 = $(".detailtemplate").clone();
					$(row1).removeClass("detailtemplate");
					row1.find(".goodsName").text(iitem.goods.goodsName);
					row1.find(".goodsNumber").text(iitem.goods.goodsNumber);
					row1.find(".tags").text(iitem.goods.tags);
					row1.find(".typeName").text(iitem.goods.type.typeName);
					row1.find(".price").text(iitem.price);
					row1.appendTo(table.find(".tbody2"));
					$(row1).show();
				});
				
				$(table).show();
				$(table).appendTo(".dtable1");
			});
		}
	});
}

// =========== Status Lines
// ===========================================================

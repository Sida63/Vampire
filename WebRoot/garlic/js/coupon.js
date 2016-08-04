$(document).ready(function() {
	initialization();
});

function initialization() {
	// hide template table and line
	$(".ex_prop_line").hide();

	// add new coupon property
	$("#ok_addCP").click(function() {
		addCouponProp();
		$("#fModal_addCP").find("input").val("");
	});

	// cancel add action
	$("#cancel_add").click(function() {
		$("#fModal_addCP").find("input").val("");
	});

	// modify a chosen coupon property
	$("#ok_modifyCP").click(function() {
		updateCouponProp();
		$("#fModal_modifyCP").find("input").val("");
	});

	// cancel modify action
	$("#cancel_modifyCP").click(function() {
		$("#fModal_modifyCP").find("input").val("");
	});

	// refresh table
	$("#prop_refresh").click(function() {
		showCouponProp();
	});

	// show data
	showCouponProp();
}

function addCouponProp() {
	var limits = $("#fModal_addCP").find("input[name='limits']").val();
	var discount = $("#fModal_addCP").find("input[name='discount']").val();
	var least = $("#fModal_addCP").find("input[name='least']").val();
	var guarantee = $("#fModal_addCP").find("input[name='guarantee']").val();
	var description = $("#fModal_addCP").find("input[name='description']")
			.val();
	$.ajax({
		type : "post",
		dataType : "json",
		url : "/Vampire/management/coupon_prop/add",
		data : {
			limits : limits,
			discount : discount,
			least : least,
			guarantee : guarantee,
			description : description
		},
		success : function(flag) {
			if (new Boolean(flag)) {
				alert("添加成功！");
			} else {
				alert("添加失败！");
			}
		},
		complete : function() {
			showCouponProp();
		}
	});
}

// 显示优惠券品种信息
function showCouponProp() {
	var block = $(".coupon_props").parents('[class^=block]');
	add_loader(block);

	$.ajax({
		type : "post",
		dataType : "json",
		url : "/Vampire/management/coupon_prop/man",// 要访问的后台地址,

		complete : function() {
			tableElementsInit();
			if ($(".fpTable").length > 0) {
				$(".fpTable").dataTable({
					bSort : false,
					bAutoWidth : true,
					"bPaginate" : true,
					"bStateSave" : true,
					// 重建表格，配合刷新使用
					"bDestroy" : true,
					"iDisplayLength" : 5,
					// 从第几行开始显示，设置模板行不显示，从第二行开始显示
					// 显示行与模板行不在统一表格时可设置为0
					"iDisplayStart" : 0,
					"aLengthMenu" : [ 5, 10, 25, 50, 100 ], // can be removed
					// for basic
					// 10 items per page
					"sPaginationType" : "full_numbers",
					"aoColumnDefs" : [ {
						"bSortable" : false,
						"aTargets" : [ -1, 0 ]
					} ]
				});
			}
			remove_loader(block);
		},

		success : function(msg) {
			$(".coupon_props tbody").empty();
			$(".fpTable").dataTable().fnClearTable();
			$.each(msg, function(idx, item) {
				var row = $(".ex_prop_line").clone();
				$(row).removeClass("ex_prop_line");

				row.find(".prop_id").text(item.id);
				row.find(".prop_description").text(item.description);
				row.find(".prop_limits").text(item.limits);
				row.find(".prop_discount").text(item.discount);
				row.find(".prop_least").text(item.least);
				row.find(".prop_guarantee").text(item.guarantee);

				row.appendTo(".coupon_props tbody");
				$(row).show();
			});
		}
	});
}

// table elements initialization
// 修改和删除方法
function tableElementsInit() {
	// modify coupon property
	$(".modifyCP").click(function() {
		var chosen = $(this).parents("tr");
		var id = chosen.find(".prop_id").text();
		var limits = chosen.find(".prop_limits").text();
		var discount = chosen.find(".prop_discount").text();
		var least = chosen.find(".prop_least").text();
		var guarantee = chosen.find(".prop_guarantee").text();
		var description = chosen.find(".prop_description").text();
		var dialog = $("#fModal_modifyCP");
		dialog.find("#modifyCP_id").text(id);
		dialog.find("input[name='limits']").val(limits);
		dialog.find("input[name='discount']").val(discount);
		dialog.find("input[name='least']").val(least);
		dialog.find("input[name='guarantee']").val(guarantee);
		dialog.find("input[name='description']").val(description);
	});

	// delete coupon property
	$(".deleteCP").click(function() {
		var isSure = confirm("是否确认删除？\n注意：删除该优惠券属性后，所有相关优惠券都会被删除！");
		if (isSure) {
			var id = $(this).parents("tr").find(".prop_id").text();
			$.ajax({
				type : "post",
				dataType : "json",
				url : "/Vampire/management/coupon_prop/del",
				data : {
					id : id
				},
				success : function(flag) {
					if (new Boolean(flag)) {
						alert("删除成功！");
					} else {
						alert("删除失败！");
					}
				},
				complete : function() {
					showCouponProp();
				}
			});
		}
	});
}

// modify the chosen coupon property
// 修改优惠券属性的实现
function updateCouponProp() {
	var id = $("#fModal_modifyCP").find("#modifyCP_id").text();
	var limits = $("#fModal_modifyCP").find("input[name='limits']").val();
	var discount = $("#fModal_modifyCP").find("input[name='discount']").val();
	var least = $("#fModal_modifyCP").find("input[name='least']").val();
	var guarantee = $("#fModal_modifyCP").find("input[name='guarantee']").val();
	var description = $("#fModal_modifyCP").find("input[name='description']")
			.val();
	$.ajax({
		type : "post",
		dataType : "json",
		url : "/Vampire/management/coupon_prop/update",
		data : {
			id : id,
			limits : limits,
			discount : discount,
			least : least,
			guarantee : guarantee,
			description : description
		},
		success : function(flag) {
			if (new Boolean(flag)) {
				alert("修改成功！");
			} else {
				alert("修改失败！");
			}
		},
		complete : function() {
			showCouponProp();
		}
	});
}
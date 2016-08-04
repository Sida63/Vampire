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
				alert("��ӳɹ���");
			} else {
				alert("���ʧ�ܣ�");
			}
		},
		complete : function() {
			showCouponProp();
		}
	});
}

// ��ʾ�Ż�ȯƷ����Ϣ
function showCouponProp() {
	var block = $(".coupon_props").parents('[class^=block]');
	add_loader(block);

	$.ajax({
		type : "post",
		dataType : "json",
		url : "/Vampire/management/coupon_prop/man",// Ҫ���ʵĺ�̨��ַ,

		complete : function() {
			tableElementsInit();
			if ($(".fpTable").length > 0) {
				$(".fpTable").dataTable({
					bSort : false,
					bAutoWidth : true,
					"bPaginate" : true,
					"bStateSave" : true,
					// �ؽ�������ˢ��ʹ��
					"bDestroy" : true,
					"iDisplayLength" : 5,
					// �ӵڼ��п�ʼ��ʾ������ģ���в���ʾ���ӵڶ��п�ʼ��ʾ
					// ��ʾ����ģ���в���ͳһ���ʱ������Ϊ0
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
// �޸ĺ�ɾ������
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
		var isSure = confirm("�Ƿ�ȷ��ɾ����\nע�⣺ɾ�����Ż�ȯ���Ժ���������Ż�ȯ���ᱻɾ����");
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
						alert("ɾ���ɹ���");
					} else {
						alert("ɾ��ʧ�ܣ�");
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
// �޸��Ż�ȯ���Ե�ʵ��
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
				alert("�޸ĳɹ���");
			} else {
				alert("�޸�ʧ�ܣ�");
			}
		},
		complete : function() {
			showCouponProp();
		}
	});
}
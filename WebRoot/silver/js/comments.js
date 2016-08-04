$(document).ready(function(){

	showcomments();
	
});


//=========== Order Peek ===========================================================
function showcomments() {
	// hide template line
	//$(".comments").hide();
	
	loadorders();
	
	
}

function loadorders() {

	

	$.ajax({
		type : "get",
		dataType : "json",
		url : "/Vampire/silver/goods/comments",// Ҫ���ʵĺ�̨��ַ,
																		// ע�⣡����������
		// data: "pageIndex=" + pageIndex,//Ҫ���͵�����, ע�⣡����������

		

		/*
		 * msg ��JSON���� ��ʾһ��orderʵ�������
		 */
		success : function(msg) {
			// clear the table, but leave the template line.
			$(".comm tbody").find("tr:not(.comments)").remove();
			$.each(msg, function(idx, item) {
				var row = $(".comments").clone();
				$(row).removeClass("comments");
				$(row).show();

				row.find(".author").text(item.user.userName);
				row.find(".text").text(item.text);

				row.appendTo(".comm tbody");
			});
		}
	});
	
}



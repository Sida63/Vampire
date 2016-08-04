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
		url : "/Vampire/silver/goods/comments",// 要访问的后台地址,
																		// 注意！！！改这里
		// data: "pageIndex=" + pageIndex,//要发送的数据, 注意！！！改这里

		

		/*
		 * msg 是JSON对象 表示一个order实体的数组
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



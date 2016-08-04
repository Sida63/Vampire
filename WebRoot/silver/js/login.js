$(document).ready(function(){
	
	setupLoginRegForm();

});

function setupLoginRegForm() {
	$(".passwordhide").hide();

	$(".loginregbtn").click(function(){
		var password = $(".passwordinput").val();
		password = md5(password);
		$(".passwordhide").val(password);
	})
}
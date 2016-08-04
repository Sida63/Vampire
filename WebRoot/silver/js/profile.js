$(document).ready(
		function() {
			$(".ex_p_coupon_line").hide();
			$(".ex_p_favor_line").hide();
			$(".ex_p_history_line").hide();

			$.ajax({
				type : "post",
				dataType : "json",
				url : "/Vampire/user/profile",// 要访问的后台地址,
				success : function(msg) {
					// 用户基本信息
					var user = msg.user;
					$("#p_user").text(user.userName);
					$("#p_reg_time").text(
							new Date(user.userDetail.registeTime)
									.toLocaleString());
					$("#p_score").text(user.userDetail.score);
					$("#p_reputation").text(user.userDetail.reputation);
					$("#p_status").text(user.userDetail.status.userStatus);
					$("#p_mail").text(user.mailBox);
					$("#p_phone").text(user.userDetail.phone);

					// 优惠券
					$(".p_coupons tbody").find("tr:not(.ex_p_coupon_line)")
							.remove();
					$.each(msg.coupons,
							function(index, item) {
								var row = $(".ex_p_coupon_line").clone();
								$(row).removeClass("ex_p_coupon_line");
								$(row).show();

								row.find(".p_coupon_num").text(
										item.couponNumber);
								row.find(".p_coupon_limits").text(
										item.property.limits);
								row.find(".p_coupon_discount").text(
										"￥" + item.property.discount);
								row.find(".p_coupon_least").text(
										"￥" + item.property.least);
								row.find(".p_coupon_issued").text(
										new Date(item.issuedTime)
												.toLocaleString());
								row.find(".p_coupon_guarantee").text(
										item.property.guarantee);

								row.appendTo(".p_coupons tbody");
							});

					// 我的收藏
					$(".p_favorites tbody").find("tr:not(.ex_p_favor_line)")
							.remove();
					$.each(msg.favorites, function(index, item) {
						var row = $(".ex_p_favor_line").clone();
						$(row).removeClass("ex_p_favor_line");
						$(row).show();

						row.find(".p_favor_img").attr(
								"href",
								"/Vampire/silver/product.jsp?id="
										+ item.goods.id);
						var img = row.find(".p_favor_img").find("img");
						img.attr("src", "/Vampire/"
								+ item.goods.goodsDetail.imgPath + "/0.png");
						img.css("height", "24px");
						img.css("width", "24px");
						row.find(".p_favor_name").text(item.goods.goodsName);
						row.find(".p_favor_name").attr(
								"href",
								"/Vampire/silver/product.jsp?id="
										+ item.goods.id);
						row.find(".p_favor_price").text(
								"￥" + item.goods.goodsDetail.price);

						row.appendTo(".p_favorites tbody");
					});

					// 我的浏览历史
					$(".p_histories tbody").find("tr:not(.ex_p_history_line)")
							.remove();
					$.each(msg.histories, function(index, item) {
						var row = $(".ex_p_history_line").clone();
						$(row).removeClass("ex_p_history_line");
						$(row).show();

						row.find(".p_history_img").attr(
								"href",
								"/Vampire/silver/product.jsp?id="
										+ item.goods.id);
						var img = row.find(".p_history_img").find("img");
						img.attr("src", "/Vampire/"
								+ item.goods.goodsDetail.imgPath + "/0.png");
						img.css("height", "24px");
						img.css("width", "24px");
						row.find(".p_history_name").text(item.goods.goodsName);
						row.find(".p_history_name").attr(
								"href",
								"/Vampire/silver/product.jsp?id="
										+ item.goods.id);
						row.find(".p_history_price").text(
								"￥" + item.goods.goodsDetail.price);
						row.find(".p_history_time").text(
								new Date(item.browseTime).toLocaleString());
						row.appendTo(".p_histories tbody");
					});
				}
			});
		});
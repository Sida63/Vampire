<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb18030" />
<title>Yet Another E-Shop</title>
<meta name="description" content="Yet Another E-Shop" />
<link rel="stylesheet" type="text/css" href="stylesheet/960.css"
	media="all" />
<link rel="stylesheet" type="text/css" href="stylesheet/screen.css"
	media="screen" />
<link rel="stylesheet" type="text/css" href="stylesheet/color.css"
	media="screen" />
<link rel="stylesheet" type="text/css" href="stylesheet/jquery.cart.css" />
<!--[if lt IE 9]>
<link rel="stylesheet" type="text/css" href="stylesheet/ie.css" media="screen" />
<![endif]-->
<script type='text/javascript' src='js/plugins/jquery/jquery-1.9.1.min.js'></script>
<script type='text/javascript' src='js/plugins/jquery/jquery-ui-1.10.1.custom.min.js'></script>
<script type='text/javascript' src='js/jquery/cart/jquery.cookie.js'></script>
<script type='text/javascript' src='js/jquery/cart/jquery.cart.js' charset='utf-8'></script>
<script type="text/javascript" src="js/index.cart.js"></script>
<script type="text/javascript" src="js/shoppica.js"></script>

<script type="text/javascript" src="js/hotgoods.js"></script>


</head>

<body class="s_layout_fixed">

	<div id="wrapper">

		<!-- ********************** -->
		<!--      H E A D E R       -->
		<!-- ********************** -->
		<%@include file="include/header.jsp"%>
		<!-- end of header -->


		<!-- ********************** -->
		<!--     I N T R O          -->
		<!-- ********************** -->


		<div id="intro">
			<div id="intro_wrap">
				<div id="product_intro" class="container_12">
					<div id="product_intro_info" class="grid_5 hotqh">
						<!-- 商品1 -->
						<div style="position: relative; display: none;"
							class="hot qianhaofirst">
							<h2>
								<span class="hotname"></span> <a href="product.jsp"></a>
							</h2>

							<div class="s_rating_holder">
								<p class="s_rating s_rating_big s_rating_5">
									<span style="width: 60%;" class="s_percent"></span>
								</p>
								<span class="s_average">3</span>
							</div>

							<p class="s_desc"></p>
							<div class="s_price_holder">
								<p class="s_price">
									<span class="q_price"></span>
								</p>
							</div>
						</div>
					</div>

					<!-- 与上面的intro_info一一对应 -->
					<div id="product_intro_preview">
						<div class="slides_container">
							<div class="slideItem preview_hotgoods">
								<a href="product.jsp"><img class="hot_img" src="/Vampire/images/goods/000000064/0.png" alt="" /></a>
							</div>
						</div>
						<a class="s_button_prev" href="javascript:;"></a> <a
							class="s_button_next" href="javascript:;"></a>
					</div>
				</div>
			</div>
		</div>
		<script type="text/javascript" src="js/jquery/jquery.slides.js"></script>

		<!-- end of intro -->


		<!-- ********************** -->
		<!--      C O N T E N T     -->
		<!-- ********************** -->
		<div id="content" class="container_12">


			<!-- 独家首发 -->
			<div id="special_home" class="grid_12">
				<h2 class="s_title_1">
					<span class="s_main_color">独家</span>首发
				</h2>
				<div class="clear"></div>

				<div class="s_listing s_grid_view clearfix latest_hot">

					<div class="s_item grid_2 new latest_goods">
						<a class="s_thumb" href="product.jsp"><img class="images_path"
							src="images/product_140x140.jpg" title="Armani Acqua di Gioia"
							alt="Armani Acqua di Gioia" /> </a>
						<h3>
							<a href="product.jsp">查看详细</a>
						</h3>
						<span class="s_model"></span>
						<p class="s_price s_promo_price">
							<span>￥</span> <span class="price"></span>
						</p>
						<a class="s_button_add_to_cart yaes_cart_add_btn" yaes-item-id='4' href="product.jsp"><span
							class="s_icon_16"><span class="s_icon"></span>加入购物车</span></a>
					</div>
					<div class="clear"></div>
				</div>
			</div>
		</div>
		<!-- end of content -->

		<!-- ********************** -->
		<!--   S H O P   I N F O    -->
		<!-- ********************** -->
		<%@include file="include/shopinfo.jsp"%>
		<!-- end of shop info -->

		<!-- ********************** -->
		<!--      F O O T E R       -->
		<!-- ********************** -->
		<%@include file="include/footer.jsp"%>
		<!-- end of FOOTER -->

	</div>

</body>
</html>


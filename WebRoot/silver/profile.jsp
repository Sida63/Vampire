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

<!--[if gt IE 8]>
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />        
    <![endif]-->
<link href="css/stylesheets.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="stylesheet/profile.css" />


<!--[if lte IE 7]>
        <link href="css/ie.css" rel="stylesheet" type="text/css" />
        <script type='text/javascript' src='js/plugins/other/lte-ie7.js'></script>
    <![endif]-->
<script type='text/javascript'
	src='js/plugins/jquery/jquery-1.9.1.min.js'></script>
<script type='text/javascript'
	src='js/plugins/jquery/jquery-ui-1.10.1.custom.min.js'></script>
<script type='text/javascript'
	src='js/plugins/bootstrap/bootstrap.min.js'></script>
<script type='text/javascript'
	src='js/plugins/datatables/jquery.dataTables.min.js'></script>
<script type='text/javascript' src='js/jquery/cart/jquery.cookie.js'></script>
<script type='text/javascript' src='js/jquery/cart/jquery.cart.js' charset='utf-8'></script>
<script type="text/javascript" src="js/shoppica.js"></script>
<script type="text/javascript" src="js/yaes.cart.js"></script>
<script type="text/javascript" src="js/profile.js"></script>
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
				<div class="container_12">
					<div id="breadcrumbs" class="grid_12">
						<a href="index.jsp">首页</a>
					</div>
					<h1>我的账户</h1>
				</div>
			</div>
		</div>

		<!-- end of intro -->


		<!-- ********************** -->
		<!--      C O N T E N T     -->
		<!-- ********************** -->
		<div class="body">
			<div class="content">
				<h2 class="s_title_1">
					<span class="s_secondary_color">我的中心</span>
				</h2>
				<div class="row-fluid">
					<div class="span12">
						<div class="block">
							<div class="data-fluid tabbable tabs-left">
								<ul class="nav nav-tabs">
									<li class="active"><a href="#tab1" data-toggle="tab">我的信息</a></li>
									<li><a href="#tab2" data-toggle="tab">我的优惠券</a></li>
									<li><a href="#tab3" data-toggle="tab">我的收藏</a></li>
									<li><a href="#tab4" data-toggle="tab">我的浏览历史</a></li>
								</ul>
								<div class="tab-content">
									<div class="tab-pane active" id="tab1">
										<div class="span11">
											<div class="block">
												<div class="grid_16">
													<div class="clear"></div>
													<div class="s_row_2">
														<span id="p_welcome"><span id="p_user"></span>，欢迎您！</span>
													</div>
													<div class="s_row_2"></div>
													<div class="s_row_2">
														<span>加入时间：</span><span id="p_reg_time"></span>
													</div>
													<div class="s_row_2">
														<span>我的积分：</span><span id="p_score"></span>
													</div>
													<div class="s_row_2">
														<span>我的信誉度：</span><span id="p_reputation"></span>
													</div>
													<div class="s_row_2">
														<span>我的状态：</span><span id="p_status"></span>
													</div>
													<div class="s_row_2">
														<span>邮箱：</span><span id="p_mail"></span>
													</div>
													<div class="s_row_2">
														<span>手机：</span><span id="p_phone"></span>
													</div>
													<div class="s_row_2">
														<div id="p_cpassword">
															<a>修改密码</a>
														</div>
													</div>
													<br />
												</div>
											</div>
										</div>
									</div>
									<div class="tab-pane" id="tab2">
										<div class="span11">
											<div class="block">
												<div class="data-fluid">
													<table cellpadding="0" cellspacing="0" width="100%"
														class="table images lcnp p_coupons">
														<thead>
															<tr>
																<th width="40px">优惠券编号</th>
																<th width="60px">限用张数</th>
																<th width="60px">减免金额</th>
																<th width="60px">起用金额</th>
																<th width="60px">发放时间</th>
																<th width="60px">有效期</th>
																<!-- 
																<th width="30px">删除</th>
																 -->
															</tr>
														</thead>
														<tbody>
															<tr class="ex_p_coupon_line">
																<td><span class="p_coupon_num"></span></td>
																<td><span class="p_coupon_limits"></span></td>
																<td><span class="p_coupon_discount"></span></td>
																<td><span class="p_coupon_least"></span></td>
																<td><span class="p_coupon_issued"></span></td>
																<td><span class="p_coupon_guarantee"></span></td>
																<!-- 
																<td><a href="#" class="button green">
																		<div class="icon">
																			<span class="ico-remove"></span>
																		</div>
																</a></td>
																 -->
															</tr>
														</tbody>
													</table>
												</div>
											</div>
										</div>
									</div>
									<div class="tab-pane" id="tab3">
										<div class="span11">
											<div class="block">
												<div class="data-fluid">
													<table cellpadding="0" cellspacing="0" width="100%"
														class="table images lcnp p_favorites">
														<thead>
															<tr>
																<th width="80">商品</th>
																<th width="80">名称</th>
																<th width="100">价格</th>
																<!-- 
																<th width="60">删除收藏</th>
																 -->
															</tr>
														</thead>
														<tbody>
															<tr class="ex_p_favor_line">
																<td><a class="p_favor_img"><img
																		class="img-polaroid" /></a></td>
																<td><a class="p_favor_name"></a></td>
																<td><span class="p_favor_price"></span></td>
																<!-- 
																<td><a href="#" class="button red">
																		<div class="icon">
																			<span class="ico-remove"></span>
																		</div>
																</a></td>
																 -->
															</tr>
														</tbody>
													</table>
												</div>
											</div>
										</div>
									</div>
									<div class="tab-pane" id="tab4">
										<div class="span11">
											<div class="block">
												<div class="data-fluid">
													<table cellpadding="0" cellspacing="0" width="100%"
														class="table images lcnp p_histories">
														<thead>
															<tr>
																<th width="80">商品</th>
																<th width="80">名称</th>
																<th width="100">价格</th>
																<th width="100">浏览日期</th>
																<!-- 
																<th width="60">删除历史</th>
																 -->
															</tr>
														</thead>
														<tbody>
															<tr class="ex_p_history_line">
																<td><a class="p_history_img"><img
																		class="img-polaroid" /></a></td>
																<td><a class="p_history_name"></a></td>
																<td><span class="p_history_price"></span></td>
																<td><span class="p_history_time"></span></td>
																<!-- 
																<td><a href="#" class="button red">
																		<div class="icon">
																			<span class="ico-remove"></span>
																		</div>
																</a></td>
																 -->
															</tr>
														</tbody>
													</table>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>


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


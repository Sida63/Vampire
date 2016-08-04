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
						<a href="index.jsp">��ҳ</a>
					</div>
					<h1>�ҵ��˻�</h1>
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
					<span class="s_secondary_color">�ҵ�����</span>
				</h2>
				<div class="row-fluid">
					<div class="span12">
						<div class="block">
							<div class="data-fluid tabbable tabs-left">
								<ul class="nav nav-tabs">
									<li class="active"><a href="#tab1" data-toggle="tab">�ҵ���Ϣ</a></li>
									<li><a href="#tab2" data-toggle="tab">�ҵ��Ż�ȯ</a></li>
									<li><a href="#tab3" data-toggle="tab">�ҵ��ղ�</a></li>
									<li><a href="#tab4" data-toggle="tab">�ҵ������ʷ</a></li>
								</ul>
								<div class="tab-content">
									<div class="tab-pane active" id="tab1">
										<div class="span11">
											<div class="block">
												<div class="grid_16">
													<div class="clear"></div>
													<div class="s_row_2">
														<span id="p_welcome"><span id="p_user"></span>����ӭ����</span>
													</div>
													<div class="s_row_2"></div>
													<div class="s_row_2">
														<span>����ʱ�䣺</span><span id="p_reg_time"></span>
													</div>
													<div class="s_row_2">
														<span>�ҵĻ��֣�</span><span id="p_score"></span>
													</div>
													<div class="s_row_2">
														<span>�ҵ������ȣ�</span><span id="p_reputation"></span>
													</div>
													<div class="s_row_2">
														<span>�ҵ�״̬��</span><span id="p_status"></span>
													</div>
													<div class="s_row_2">
														<span>���䣺</span><span id="p_mail"></span>
													</div>
													<div class="s_row_2">
														<span>�ֻ���</span><span id="p_phone"></span>
													</div>
													<div class="s_row_2">
														<div id="p_cpassword">
															<a>�޸�����</a>
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
																<th width="40px">�Ż�ȯ���</th>
																<th width="60px">��������</th>
																<th width="60px">������</th>
																<th width="60px">���ý��</th>
																<th width="60px">����ʱ��</th>
																<th width="60px">��Ч��</th>
																<!-- 
																<th width="30px">ɾ��</th>
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
																<th width="80">��Ʒ</th>
																<th width="80">����</th>
																<th width="100">�۸�</th>
																<!-- 
																<th width="60">ɾ���ղ�</th>
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
																<th width="80">��Ʒ</th>
																<th width="80">����</th>
																<th width="100">�۸�</th>
																<th width="100">�������</th>
																<!-- 
																<th width="60">ɾ����ʷ</th>
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


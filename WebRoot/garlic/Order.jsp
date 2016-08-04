<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb18030" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
<!--[if gt IE 8]>
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />        
    <![endif]-->
<title>Coupon Management</title>
<link rel="icon" type="image/ico" href="favicon.ico" />

<link href="css/stylesheets.css" rel="stylesheet" type="text/css" />
<!--[if lte IE 7]>
        <link href="css/ie.css" rel="stylesheet" type="text/css" />
        <script type='text/javascript' src='js/plugins/other/lte-ie7.js'></script>
        <![endif]-->
<script type='text/javascript'
	src='js/plugins/jquery/jquery-1.9.1.min.js'></script>
<script type='text/javascript'
	src='js/plugins/jquery/jquery-ui-1.10.1.custom.min.js'></script>
<script type='text/javascript'
	src='js/plugins/jquery/jquery-migrate-1.1.1.min.js'></script>
<script type='text/javascript' src='js/plugins/jquery/globalize.js'></script>
<script type='text/javascript' src='js/plugins/other/excanvas.js'></script>

<script type='text/javascript'
	src='js/plugins/other/jquery.mousewheel.min.js'></script>

<script type='text/javascript'
	src='js/plugins/bootstrap/bootstrap.min.js'></script>

<script type='text/javascript'
	src='js/plugins/cookies/jquery.cookies.2.2.0.min.js'></script>

<script type='text/javascript'
	src="js/plugins/uniform/jquery.uniform.min.js"></script>

<script type='text/javascript'
	src='js/plugins/datatables/jquery.dataTables.min.js'></script>

<script type='text/javascript' src='js/plugins/shbrush/XRegExp.js'></script>
<script type='text/javascript' src='js/plugins/shbrush/shCore.js'></script>
<script type='text/javascript' src='js/plugins/shbrush/shBrushXml.js'></script>
<script type='text/javascript'
	src='js/plugins/shbrush/shBrushJScript.js'></script>
<script type='text/javascript' src='js/plugins/shbrush/shBrushCss.js'></script>
<script type='text/javascript' src='js/charts.js'></script>
<script type='text/javascript' src='js/actions.js'></script>
<script type="text/javascript" src="js/orderman.js" charset='gb18030'></script>
</head>
<body>
	<div id="loader">
		<img src="img/loader.gif" />
	</div>
	<div class="wrapper">
		<%@include file="include/sidebar.jsp"%>
		<div class="body">
			<div class="content">
				<%@include file="include/pageheader.jsp"%>
				<div class="row-fluid">
					<div class="span12">
						<div class="block">
							<div class="head blue">
								<div class="icon">
									<i class="ico-layout-9"></i>
								</div>
								<h2>订单</h2>

							</div>
							<div class="data-fluid">
								<table class="table orderTable" cellpadding="0" cellspacing="0"
									width="100%">
									<thead>
										<tr>
											<th width="10%" align="left">状态</th>
											<th width="30%" align="left">订单号</th>
											<th width="30%" align="left">下单时间</th>
											<th width="10%" align="left">姓名</th>
											<th width="10%" align="left">总价</th>
											<th width="10%" class="TAC">Actions</th>
										</tr>
									</thead>
									<tbody>
									</tbody>
								</table>
								<table width="100%">

									<tr class="ordertemplateline1">
										<td style="display:none"><span class="id"></span></td>
										<td width="10%"><span class="orderstatus"></span></td>
										<td width="30"><span class="orderdate"></span></td>
										<td width="30%"><span class="orderdate"></span></td>
										<td width=10%><span class="orderuser"></span></td>
										<td width="10%"><span class="amount"></span></td>
										<td width="10%"><a href="#fModal_modifyCP"
											class="button green looklook" data-toggle="modal">
												<div class="icon">
													<span class="ico-pencil"></span>
												</div>
										</a> <a href="#" class="button red">
												<div class="icon">
													<span class="ico-remove"></span>
												</div>
										</a></td>
									</tr>


								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div id="fModal_modifyCP" class="modal hide fade" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">

		<div class="row-fluid">
			<div class="block-fluid">
				<div class="row-form">
					<div class="span12" style="overflow-x:hidden;overflow-y:scroll">
						<table class="table orderdetail">
							<tbody>
								<tr class="ordertemplateline2">
								<td width=30%><img class="imgsrc" height=20% width=50%></img></td>
									<td><span class="goodsName" style="color: #000000;font-size:15px"></span></td>
									<td><span class="goodsNumber" style="color: #000000;font-size:15px"></span></td>
									<td><span class="tags" style="color: #000000;font-size:15px"></span></td>
									<td><span class="typeName" style="color: #000000;font-size:15px"></span></td>
									<td><span class="price" style="color: #000000;font-size:15px"></span></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>

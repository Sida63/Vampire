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
<script type="text/javascript" src="js/coupon.js"></script>
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
								<h2>优惠券品种</h2>
								<ul class="buttons">
									<li><div class="icon">
											<a href="#fModal_addCP" data-toggle="modal"> <span
												class="ico-plus"></span>
											</a>
										</div></li>
									<li><a id="prop_refresh" href="#" class="ublock"><div
												class="icon">
												<span class="ico-undo"></span>
											</div></a></li>
									<li><a href="#" class="cblock"><div class="icon">
												<span class="ico-sort"></span>
											</div></a></li>
								</ul>
							</div>
							<div class="data-fluid">
								<table class="table fpTable coupon_props" cellpadding="0"
									cellspacing="0" width="100%">
									<thead>
										<tr>
											<th width="30px"><input type="checkbox" class="checkall" /></th>
											<th width="30px">ID</th>
											<th>Description</th>
											<th width="10%">Limits</th>
											<th width="15%">Discount</th>
											<th width="15%">Least</th>
											<th width="10%">Guarantee</th>
											<th width="80px" class="TAC">Actions</th>
										</tr>
									</thead>
									<tbody>
									</tbody>
								</table>
								<table>
									<tr class="ex_prop_line">
										<td><input type="checkbox" name="order[]" /></td>
										<td><span class="prop_id"></span></td>
										<td><span class="prop_description"></span></td>
										<td><span class="prop_limits"></span></td>
										<td><span class="prop_discount"></span></td>
										<td><span class="prop_least"></span></td>
										<td><span class="prop_guarantee"></span></td>
										<td><a href="#fModal_modifyCP"
											class="button green modifyCP" data-toggle="modal">
												<div class="icon">
													<span class="ico-pencil"></span>
												</div>
										</a> <a href="#" class="button red deleteCP">
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
	<!-- add new coupon property -->
	<div id="fModal_addCP" class="modal hide fade" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"
				aria-hidden="true">×</button>
			<h3>添加新的优惠券品种</h3>
		</div>
		<div class="row-fluid">
			<div class="block-fluid">
				<div class="row-form">
					<div class="span12">
						<span class="top title">使用限张：</span> <input type="text"
							name="limits" />
					</div>
				</div>
				<div class="row-form">
					<div class="span12">
						<span class="top title">减免金额：</span> <input type="text"
							name="discount" />
					</div>
				</div>
				<div class="row-form">
					<div class="span12">
						<span class="top title">起用金额：</span> <input type="text"
							name="least" />
					</div>
				</div>
				<div class="row-form">
					<div class="span12">
						<span class="top title">有效期：</span> <input type="text"
							name="guarantee" />
					</div>
				</div>
				<div class="row-form">
					<div class="span12">
						<span class="top title">描述/名称：</span> <input type="text"
							name="description" />
					</div>
				</div>
			</div>
		</div>
		<div class="modal-footer">
			<button id="ok_addCP" class="btn btn-primary" data-dismiss="modal"
				aria-hidden="true">添加</button>
			<button id="cancel_addCP" class="btn btn-warning" data-dismiss="modal"
				aria-hidden="true">取消</button>
		</div>
	</div>
	<!-- modify a chosen coupon property -->
	<div id="fModal_modifyCP" class="modal hide fade" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"
				aria-hidden="true">×</button>
			<h3>修改优惠券品种属性&nbsp;ID=<span id="modifyCP_id"></span></h3>
		</div>
		<div class="row-fluid">
			<div class="block-fluid">
				<div class="row-form">
					<div class="span12">
						<span class="top title">使用限张：</span> <input type="text"
							name="limits" />
					</div>
				</div>
				<div class="row-form">
					<div class="span12">
						<span class="top title">减免金额：</span> <input type="text"
							name="discount" />
					</div>
				</div>
				<div class="row-form">
					<div class="span12">
						<span class="top title">起用金额：</span> <input type="text"
							name="least" />
					</div>
				</div>
				<div class="row-form">
					<div class="span12">
						<span class="top title">有效期：</span> <input type="text"
							name="guarantee" />
					</div>
				</div>
				<div class="row-form">
					<div class="span12">
						<span class="top title">描述/名称：</span> <input type="text"
							name="description" />
					</div>
				</div>
			</div>
		</div>
		<div class="modal-footer">
			<button id="ok_modifyCP" class="btn btn-primary"
				data-dismiss="modal" aria-hidden="true">修改</button>
			<button id="cancel_modifyCP" class="btn btn-warning"
				data-dismiss="modal" aria-hidden="true">取消</button>
		</div>
	</div>
</body>
</html>

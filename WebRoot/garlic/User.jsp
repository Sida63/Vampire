<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=gb18030" />
	<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
		<!--[if gt IE 8]>
		<meta http-equiv="X-UA-Compatible" content="IE=edge" />
		<![endif]-->
		<title>YAEShop 后台管理系统</title>
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
		<script type='text/javascript' src='js/plugins/jflot/jquery.flot.js'></script>
		<script type='text/javascript'
		src='js/plugins/jflot/jquery.flot.stack.js'></script>
		<script type='text/javascript' src='js/plugins/jflot/jquery.flot.pie.js'></script>
		<script type='text/javascript'
		src='js/plugins/jflot/jquery.flot.resize.js'></script>
		<script type='text/javascript'
		src='js/plugins/sparklines/jquery.sparkline.min.js'></script>
		<script type='text/javascript'
		src='js/plugins/mcustomscrollbar/jquery.mCustomScrollbar.min.js'></script>
		<script type='text/javascript'
		src="js/plugins/uniform/jquery.uniform.min.js"></script>
		<script type='text/javascript' src='js/plugins/shbrush/XRegExp.js'></script>
		<script type='text/javascript' src='js/plugins/shbrush/shCore.js'></script>
		<script type='text/javascript' src='js/plugins/shbrush/shBrushXml.js'></script>
		<script type='text/javascript'
		src='js/plugins/shbrush/shBrushJScript.js'></script>
		<script type='text/javascript' src='js/plugins/shbrush/shBrushCss.js'></script>
		<script type='text/javascript' src='js/plugins/datatables/jquery.dataTables.min.js'></script>
		<script type='text/javascript' src='js/plugins.js'></script>
		<script type='text/javascript' src='js/charts.js'></script>
		<script type='text/javascript' src='js/actions.js'></script>
	</head>
	<body>
		<div id="loader">
			<img src="img/loader.gif" />
		</div>
		<div class="wrapper">
			<%@include file="include/sidebar.jsp" %>
			<div class="body">
				<div class="content">
					<%@include file="include/pageheader.jsp" %>
					<div class="row-fluid">
						<div class="span4">
							<input type="text" name="search">
							&nbsp;&nbsp;&nbsp;&nbsp;
						</div>
						<div>
							&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="button" value="搜索">
						</div>
					</div>
					<div class="row-fluid">
						<div class="span12">
							<div class="block">
							</br>
						</br>
						<div class="head blue">
							<div class="icon"><i class="ico-layout-9"></i></div>
							<h2>Default table sorting</h2>
							<ul class="buttons">
								<li><a href="#" onClick="source('table_sort'); return false;"><div class="icon"><span class="ico-info"></span></div></a></li>
							</ul>
						</div>
						<div class="data-fluid">
							<table class="table dtable lcnp" cellpadding="0" cellspacing="0" width="100%">
								<thead>
									<tr>
										<th><input type="checkbox" class="checkall"/></th>
										<th width="20%">Name</th>
										<th>Product</th>
										<th width="20%">Status</th>
										<th width="20%">Date</th>
										<th width="80" class="TAC">Actions</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td><input type="checkbox" name="order[]" value="528"/></td>
										<td><a href="#">Dmitry Ivaniuk</a></td>
										<td>Product #212</td>
										<td><span class="label label-important">New</span></td>
										<td>24/11/2012</td>
										<td>
											<a href="#" class="button green">
												<div class="icon"><span class="ico-pencil"></span></div>
											</a>
											<a href="#" class="button red">
												<div class="icon"><span class="ico-remove"></span></div>
											</a>
										</td>
									</tr>
									<tr>
										<td><input type="checkbox" name="order[]" value="527"/></td>
										<td><a href="#">John Doe</a></td>
										<td>Product #132</td>
										<td><span class="label label-important">New</span></td>
										<td>24/11/2012</td>
										<td>
											<a href="#" class="button green">
												<div class="icon"><span class="ico-pencil"></span></div>
											</a>
											<a href="#" class="button red">
												<div class="icon"><span class="ico-remove"></span></div>
											</a>
										</td>
									</tr>
									<tr>
										<td><input type="checkbox" name="order[]" value="526"/></td>
										<td><a href="#">Alex Fruz</a></td>
										<td>Product #53</td>
										<td><span class="label label-important">New</span></td>
										<td>23/11/2012</td>
										<td>
											<a href="#" class="button green">
												<div class="icon"><span class="ico-pencil"></span></div>
											</a>
											<a href="#" class="button red">
												<div class="icon"><span class="ico-remove"></span></div>
											</a>
										</td>
									</tr>
									<tr>
										<td><input type="checkbox" name="order[]" value="525"/></td>
										<td><a href="#">Olga Yukhimchuk</a></td>
										<td>Product #874</td>
										<td><span class="label label-info">Pending</span></td>
										<td>23/11/2012</td>
										<td>
											<a href="#" class="button green">
												<div class="icon"><span class="ico-pencil"></span></div>
											</a>
											<a href="#" class="button red">
												<div class="icon"><span class="ico-remove"></span></div>
											</a>
										</td>
									</tr>
									<tr>
										<td><input type="checkbox" name="order[]" value="524"/></td>
										<td><a href="#">Angelina Rose</a></td>
										<td>Product #533</td>
										<td><span class="label label-info">Pending</span></td>
										<td>23/11/2012</td>
										<td>
											<a href="#" class="button green">
												<div class="icon"><span class="ico-pencil"></span></div>
											</a>
											<a href="#" class="button red">
												<div class="icon"><span class="ico-remove"></span></div>
											</a>
										</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="dialog" id="source" style="display: none;" title="Source"></div>
		<div class=span11>
			<input type="button" value="添加">
		</div>
	</div>
</div>
</div>
</body>
</html>
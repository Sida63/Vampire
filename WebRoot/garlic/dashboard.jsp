<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=gb18030" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
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
	<script type='text/javascript' src='js/plugins/jquery/jquery-1.9.1.min.js'></script>
	<script type='text/javascript' src='js/plugins/jquery/jquery-ui-1.10.1.custom.min.js'></script>
	<script type='text/javascript' src='js/plugins/jquery/jquery-migrate-1.1.1.min.js'></script>
	<script type='text/javascript' src='js/plugins/jquery/globalize.js'></script>
	<script type='text/javascript' src='js/plugins/other/excanvas.js'></script>
	<script type='text/javascript' src='js/plugins/other/jquery.mousewheel.min.js' ></script>
	<script type='text/javascript' src='js/plugins/bootstrap/bootstrap.min.js' ></script>
	<script type='text/javascript' src='js/plugins/cookies/jquery.cookies.2.2.0.min.js' ></script>
	<script type='text/javascript' src='js/plugins/jflot/jquery.flot.js'></script>
	<script type='text/javascript' src='js/plugins/jflot/jquery.flot.stack.js' ></script>
	<script type='text/javascript' src='js/plugins/jflot/jquery.flot.pie.js'></script>
	<script type='text/javascript' src='js/plugins/jflot/jquery.flot.resize.js' ></script>
	<script type='text/javascript' src='js/plugins/sparklines/jquery.sparkline.min.js' ></script>
	<script type='text/javascript' src='js/plugins/mcustomscrollbar/jquery.mCustomScrollbar.min.js' ></script>
	<script type='text/javascript' src="js/plugins/uniform/jquery.uniform.min.js" ></script>
	<script type='text/javascript' src='js/plugins/shbrush/XRegExp.js'></script>
	<script type='text/javascript' src='js/plugins/shbrush/shCore.js'></script>
	<script type='text/javascript' src='js/plugins/shbrush/shBrushXml.js'></script>
	<script type='text/javascript' src='js/plugins/shbrush/shBrushJScript.js' ></script>
	<script type='text/javascript' src='js/plugins/shbrush/shBrushCss.js'></script>

	<script type='text/javascript' src='js/plugins.js'></script>
	<script type='text/javascript' src='js/charts.js'></script>
	<script type='text/javascript' src='js/actions.js'></script>
	<script type='text/javascript' src='js/dashboard.js'></script>
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
					<div class="span7">
						<div class="block">
							<div class="head">
								<div class="icon"><span class="ico-chart-4"></span></div>
								<h2>实时统计</h2>
								<ul class="buttons">
									<li><a href="#" class="ublock"><div class="icon"><span class="ico-undo"></span></div></a></li>
									<li><a href="#" class="cblock"><div class="icon"><span class="ico-sort"></span></div></a></li>
								</ul>
							</div>
							<div class="data">
								<div id="main_chart" style="height: 300px;"></div>                                
							</div>
							<div class="row-fluid">
								<div class="span4">
									<div class="stat">
										<span class="cdblue pageviews">2,350</span> PAGE<br/> VIEWS
									</div>
								</div>
								<div class="span4">
									<div class="stat">
										<span class="cblue totalorders">1,120</span> TOTAL<br/> ORDERS
									</div>
								</div>
								<div class="span4">
									<div class="stat">
										<span class="corange totalsales">720</span> TOTAL<br/> SALES
									</div>
								</div>               
							</div>
						</div>
					</div>
					<div class="span5">
						<div class="block">
							<div class="head">
								<div class="icon"><span class="ico-tag"></span></div>
								<h2>最新订单动态</h2>
								<ul class="buttons">             
									<li><a href="#" onClick=""><div class="icon"><span class="ico-info"></span></div></a></li>
									<li><a id="order-peek-reload" href="#" class="ublock"><div class="icon"><span class="ico-undo"></span></div></a></li>
									<li><a href="#" class="cblock"><div class="icon"><span class="ico-sort"></span></div></a></li>
								</ul>
							</div>
							<div class="data-fluid">
								<table width="100%" class="table orderpeek">
									<tbody>
										<tr class="orderpeektempline">
											<!-- span 中放标签(状态) -->
											<td width="55" class="bl_blue"><span class="label label-info orderstatus"></span></td>
											<!-- span前放编号，里面放日期 -->
											<td width="50"><span class="ordernum"></span><span class="mark orderdate"></span></td>
											<!-- a中放订单内容(部分), span中放用户 -->
											<td><a href="#" class="cblue ordercontent"></a><span class="mark orderuser"></span></td>
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
</body>
</html>
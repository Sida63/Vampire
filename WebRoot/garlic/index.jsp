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
<title>YAEShop ��̨����ϵͳ</title>
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

<script type='text/javascript' src='js/plugins.js'></script>
<script type='text/javascript' src='js/charts.js'></script>

<script type='text/javascript' src='js/actions.js'></script>
</head>
<body>
	<div id="loader">
		<img src="img/loader.gif" />
	</div>
	<div class="wrapper">

		<div class="sidebar">

			<div class="top">
				<a href="#" class="logo"></a>
			</div>
			<div class="nContainer">
				<ul class="navigation">
					<li><a href="#" class="blblue">ͳ�Ʊ���</a>
						<div class="open"></div>
						<ul>
							<li><a href="#">����һ</a></li>
							<li><a href="#">�����</a></li>
							<li><a href="#">������</a></li>
						</ul></li>
					<li><a href="#" class="blyellow">�û�����</a>
						<div class="open"></div>
						<ul>
							<li><a href="#">����һ</a></li>
							<li><a href="#">�����</a></li>
							<li><a href="#">������</a></li>
						</ul></li>
					<li><a href="#" class="blgreen">��Ʒ����</a>
						<div class="open"></div>
						<ul>
							<li><a href="#">��Ʒ</a></li>
							<li><a href="#">��Ʒ���</a></li>
							<li><a href="#">�Ż�ȯ����</a></li>
						</ul></li>
					<li><a href="#" class="blred">��������</a>
						<div class="open"></div>
						<ul>
							<li><a href="#">����һ</a></li>
							<li><a href="#">�����</a></li>
							<li><a href="#">������</a></li>
						</ul></li>
					<li><a href="#" class="blpurple">����Ա����</a>
						<div class="open"></div>
						<ul>
							<li><a href="#">����һ</a></li>
							<li><a href="#">�����</a></li>
							<li><a href="#">������</a></li>
						</ul></li>
				</ul>
				<a class="close"> <span class="ico-remove"></span>
				</a>
			</div>
			<div class="widget">
				<div class="datepicker"></div>
			</div>
			<!-- ʲô�����һ��Ҫ������������ -->
			<div class="widget">
				<div style="height:90px;"></div>
			</div>
		</div>

		<div class="body">

			<div class="content">

				<div class="page-header">
					<div class="icon">
						<span class="ico-cabinet"></span>
					</div>
					<h1>
						��̨����ϵͳ <small>����֮��λ��޴�</small>
					</h1>
					<div class="user" style="float:right;">
						<img src="http://tp2.sinaimg.cn/2485086237/50/40019627367/0"
							align="left" /> <a href="#" class="name"> <span>Youer</span>
							<span class="sm">Administrator</span>
						</a>
					</div>
				</div>
				<div class="row-fluid">
					<iframe src="statistics_1.jsp" name="main"
						style="height:800px;width:1000px;border:none;">
				</div>
			</div>
		</div>
	</div>
</body>
</html>

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
		<script type='text/javascript' src='js/plugins/fancybox/jquery.fancybox.pack.js'></script>
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

    				<div class="span12">
						<div class="block">
                            <div class="head purple">
                                <div class="icon"><span class="ico-layout-9"></span></div>
                                <h2>AJAX Data load</h2>
                                <ul class="buttons">
                                    <li><a href="#" onClick="source('table_sort_ajax'); return false;"><div class="icon"><span class="ico-info"></span></div></a></li>
                                </ul>                                                        
                            </div>                
                                <div class="data-fluid">
                                    <table class="table aTable" cellpadding="0" cellspacing="0" width="100%">
                                        <thead>
                                            <tr>
                                                <th width="20%">Rendering engine</th>
                                                <th width="25%">Browser</th>
                                                <th width="25%">Platform(s)</th>
                                                <th width="15%">Engine version</th>
                                                <th width="15%">CSS grade</th>
                                            </tr>
                                        </thead>
                                        <tbody>

                                        </tbody>
                                    </table>                    
                                </div> 
                        </div>        
					
						<div class="block">
						
                            <div class="head green">
                                <div class="icon"><span class="ico-picture"></span></div>
                                <h2>Images in table</h2>
                            </div>
                            <div class="data-fluid">
                                <table class="table images lcnp" cellpadding="0" cellspacing="0" width="100%">
                                    <thead>
                                        <tr>
                                            <th width="30"><div class="checker"><span><input style="opacity: 0;" class="checkall" type="checkbox"></span></div></th>
                                            <th width="60">Image</th>
                                            <th>Name</th>
                                            <th width="100">Date</th>
                                            <th width="60">Size</th>
                                            <th width="80">Actions</th>                                
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td><div class="checker"><span><input style="opacity: 0;" name="checkbox" type="checkbox"></span></div></td>
                                            <td><a class="fb" rel="group" href="img/examples/photo/example_1.jpg"><img src="img/examples/photo/example_1s.jpg" class="img-polaroid"></a></td>
                                            <td class="info"><a class="fb" rel="group" href="img/examples/photo/example_1.jpg">Lorem ipsum dolor sit amet</a> <span>fk-hseosqassr.jpg</span></td>
                                            <td><span>10.11.2012 10:42</span></td>
                                            <td>260 Kb</td>
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
                                            <td><div class="checker"><span><input style="opacity: 0;" name="checkbox" type="checkbox"></span></div></td>
                                            <td><a class="fb" rel="group" href="img/examples/photo/example_2.jpg"><img src="img/examples/photo/example_2s.jpg" class="img-polaroid"></a></td>
                                            <td class="info"><a class="fb" rel="group" href="img/examples/photo/example_2.jpg">Lorem ipsum dolor sit amet</a> <span>fk-hseosqassr.jpg</span></td>
                                            <td><span>10.11.2012 10:42</span></td>
                                            <td>260 Kb</td>
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
                                            <td><div class="checker"><span><input style="opacity: 0;" name="checkbox" type="checkbox"></span></div></td>
                                            <td><a class="fb" rel="group" href="img/examples/photo/example_7.jpg"><img src="img/examples/photo/example_7s.jpg" class="img-polaroid"></a></td>
                                            <td class="info"><a class="fb" rel="group" href="img/examples/photo/example_7.jpg">Lorem ipsum dolor sit amet</a> <span>fk-hseosqassr.jpg</span></td>
                                            <td><span>10.11.2012 10:42</span></td>
                                            <td>260 Kb</td>
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
                                            <td><div class="checker"><span><input style="opacity: 0;" name="checkbox" type="checkbox"></span></div></td>
                                            <td><a class="fb" rel="group" href="img/examples/photo/example_4.jpg"><img src="img/examples/photo/example_4s.jpg" class="img-polaroid"></a></td>
                                            <td class="info"><a class="fb" rel="group" href="img/examples/photo/example_4.jpg">Lorem ipsum dolor sit amet</a> <span>fk-hseosqassr.jpg</span></td>
                                            <td><span>10.11.2012 10:42</span></td>
                                            <td>260 Kb</td>
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
                                            <td><div class="checker"><span><input style="opacity: 0;" name="checkbox" type="checkbox"></span></div></td>
                                            <td><a class="fb" rel="group" href="img/examples/photo/example_5.jpg"><img src="img/examples/photo/example_5s.jpg" class="img-polaroid"></a></td>
                                            <td class="info"><a class="fb" rel="group" href="img/examples/photo/example_5.jpg">Lorem ipsum dolor sit amet</a> <span>fk-hseosqassr.jpg</span></td>
                                            <td><span>10.11.2012 10:42</span></td>
                                            <td>260 Kb</td>
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
		</div>
	</div>
</body>
</html>
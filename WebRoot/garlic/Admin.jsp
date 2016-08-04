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
                                <div class="search">
                                    <div class="input-prepend" style="background-color: White; ">
                                        <input type="text" placeholder="search..." size=20 style="vertical-align:middle; color: Blue"/>
                                        <span class="add-on orange">查找</span>
                                        <span class="icon-search icon-white"></span>
                                    </div>
                                </div>
                            </div>

                            <div class="block">
                                <div class="head orange">
                                    <h2>Latest Orders</h2>
                                    <ul class="buttons">
                                        <li><a href="#" onClick="source('table_main'); return false;"><div class="icon"><span class="ico-info"></span></div></a></li>
                                        <li><a href="#" class="ublock"><div class="icon"><span class="ico-undo"></span></div></a></li>
                                        <li><a href="#" class="cblock"><div class="icon"><span class="ico-sort"></span></div></a></li>
                                    </ul>
                                </div>
                                <div class="data-fluid">
                                    <table cellpadding="0" cellspacing="0" width="100%" class="table lcnp">
                                        <thead>
                                            <tr>
                                                <th width="16"><input type="checkbox" class="checkall"/></th>
                                                <th>Name</th>
                                                <th>E-mail</th>
                                                <th>Phone</th>
                                                <th width="78">Actions</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td><input type="checkbox" name="checkbox"/></td>
                                                <td>Dmitry</td>
                                                <td>dmitry@domain.com</td>
                                                <td>+98(765) 432-10-98</td>
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
                                                <td><input type="checkbox" name="checkbox"/></td>
                                                <td>Alex</td>
                                                <td>alex@domain.com</td>
                                                <td>+98(765) 432-10-99</td>
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
                                                <td><input type="checkbox" name="checkbox"/></td>
                                                <td>John</td>
                                                <td>john@domain.com</td>
                                                <td>+98(765) 432-10-97</td>
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
                                                <td><input type="checkbox" name="checkbox"/></td>
                                                <td>Angelina</td>
                                                <td>angelina@domain.com</td>
                                                <td>+98(765) 432-10-90</td>
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
                                                <td><input type="checkbox" name="checkbox"/></td>
                                                <td>Tom</td>
                                                <td>tom@domain.com</td>
                                                <td>+98(765) 432-10-92</td>
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
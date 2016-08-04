<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=gb18030" />
  <title>Yet Another E-Shop</title>
  <meta name="description" content="Yet Another E-Shop" />
  <link rel="stylesheet" type="text/css" href="stylesheet/960.css" media="all"/>
  <link rel="stylesheet" type="text/css" href="stylesheet/screen.css" media="screen" />
  <link rel="stylesheet" type="text/css" href="stylesheet/color.css" media="screen"/>
  <link rel="stylesheet" type="text/css" href="stylesheet/jquery.cart.css" />
<!--[if lt IE 9]>
<link rel="stylesheet" type="text/css" href="stylesheet/ie.css" media="screen" />
<![endif]-->
<script type='text/javascript' src='js/plugins/jquery/jquery-1.9.1.min.js'></script>
<script type='text/javascript' src='js/plugins/jquery/jquery-ui-1.10.1.custom.min.js'></script>
<script type="text/javascript" src="js/shoppica.js"></script>
<script type='text/javascript' src='js/jquery/cart/jquery.cookie.js'></script>
<script type='text/javascript' src='js/jquery/cart/jquery.cart.js' charset='utf-8'></script>
<script type="text/javascript" src="js/yaes.cart.js"></script>
</head>

<body class="s_layout_fixed">

  <div id="wrapper">

    <!-- ********************** -->
    <!--      H E A D E R       -->
    <!-- ********************** -->
    <%@include file="include/header.jsp" %>
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
    <div id="content" class="container_16">
      <div class="grid_16">

        <form id="create" class="clearfix" action="#">
          <h2 class="s_title_1"><span class="s_secondary_color">表格</span> 标题</h2>
          <div class="clear"></div>

          <div class="s_row_2 clearfix">
            <label class="required"><strong>标题</strong></label>
            <input type="text" size="30" />
          </div>

          <div class="s_row_2 clearfix">
            <label><strong>长标题</strong></label>
            <input type="text" size="90" />
          </div>

          <div class="s_row_2 clearfix">
            <label><strong>文字区域</strong></label>
            <textarea rows="10" cols="87"></textarea>
          </div>

          <div class="s_row_2 clearfix">
            <label><strong>选择区域</strong></label>
            <select style="width: 212px;">
             <option>选择 1</option>
             <option>选择 2</option>
             <option>选择 3</option>
           </select>
         </div>

         <div class="s_row_2 clearfix">
          <label><strong>连续选择区域</strong></label>
          <select class="inline" style="width: 100px;"> <option>选择  1</option> <option>选择  2</option> <option>选择  3</option></select>
          /
          <select class="inline" style="width: 100px;"> <option>选择  1</option> <option>选择  2</option> <option>选择  3</option>
          </select>
          /
          <select class="inline" style="width: 100px;"> <option>选择  1</option>  <option>选择  2</option> <option>选择  3</option>
          </select>
        </div>

        <div class="s_row_2 clearfix">
          <label><strong>多重选择区域</strong></label>
          <select multiple="multiple" size="5" style="width: 212px;">
           <option>选择  1</option>
           <option>选择  2</option>
           <option>选择  3</option>
           <option>选择  4</option>
           <option>选择  5</option>
           <option>选择  6</option>
           <option>选择  7</option>
           <option>选择  8</option>
           <option>选择  9</option>
         </select>
       </div>

       <div class="s_row_2 clearfix">
        <label><strong>选项按钮组</strong></label>
        <div class="s_full">
          <label class="s_radio"><input type="radio" /> 选择 1</label>
          <label class="s_radio"><input type="radio" /> 选择 2</label>
          <label class="s_radio"><input type="radio" /> 选择 3</label>
          <label class="s_radio"><input type="radio" /> 选择 4</label>
          <label class="s_radio"><input type="radio" /> 选择 5</label>
          <label class="s_radio"><input type="radio" /> 选择 6</label>
          <label class="s_radio"><input type="radio" /> 选择 7</label>
          <label class="s_radio"><input type="radio" /> 选择 8</label>
        </div>
      </div>

      <div class="s_row_2 clearfix">
        <label><strong> 扩展复选框组</strong></label>
        <div class="s_full">
          <label class="s_radio"><input type="checkbox" /> 选择 1</label>
          <label class="s_radio"><input type="checkbox" /> 选择 2</label>
          <label class="s_radio"><input type="checkbox" /> 选择 3</label>
          <label class="s_radio"><input type="checkbox" /> 选择 4</label>
          <label class="s_radio"><input type="checkbox" /> 选择 5</label>
          <label class="s_radio"><input type="checkbox" /> 选择 6</label>
          <label class="s_radio"><input type="checkbox" /> 选择 7</label>
          <label class="s_radio"><input type="checkbox" /> 选择 8</label>
        </div>
      </div>

      <a class="s_button_1 s_main_color_bgr left" onclick="$('#create').submit();"><span class="s_text">提交</span></a>
      <a class="s_button_1 s_ddd_bgr left" onclick="$('#create').submit();"><span class="s_text">重置</span></a>

    </form>

    <br />
    <br />

  </div>

</div>
<!-- end of content --> 

<!-- ********************** --> 
<!--   S H O P   I N F O    --> 
<!-- ********************** --> 
<%@include file="include/shopinfo.jsp" %>
<!-- end of shop info -->



<!-- ********************** -->
<!--      F O O T E R       -->
<!-- ********************** -->
<%@include file="include/footer.jsp" %>
<!-- end of FOOTER -->

</div>

</body>
</html>


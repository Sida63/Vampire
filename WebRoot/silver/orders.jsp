<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb18030" />
<title>Yet Another E-Shop</title>
<meta name="description" content="Yet Another E-Shop" />
<link rel="stylesheet" type="text/css" href="stylesheet/960.css" media="all" />
<link rel="stylesheet" type="text/css" href="stylesheet/screen.css" media="screen" />
<link rel="stylesheet" type="text/css" href="stylesheet/color.css" media="screen" />
<link rel="stylesheet" type="text/css" href="stylesheet/jquery.cart.css" />
<!--[if lt IE 9]>
<link rel="stylesheet" type="text/css" href="stylesheet/ie.css" media="screen" />
<![endif]-->

<script type='text/javascript' src='js/plugins/jquery/jquery-1.9.1.min.js'></script>
<script type='text/javascript' src='js/jquery/cart/jquery.cookie.js'></script>
<script type='text/javascript' src='js/jquery/cart/jquery.cart.js' charset='utf-8'></script>
<script type="text/javascript" src="js/yaes.cart.js"></script>
<script type="text/javascript" src="js/shoppica.js"></script>
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
          <a href="index.jsp">Home</a>
           &gt; <a href="cart.jsp">Basket</a>
        </div>
        <h1>订单</h1>
      </div>
    </div>
  </div>
  <!-- end of intro -->
  
  
  <!-- ********************** --> 
  <!--      C O N T E N T     --> 
  <!-- ********************** --> 
  <div id="content" class="container_12">
  
    <div id="order_history" class="grid_12">
      
      <div class="s_listing s_grid_view clearfix">
        <div class="grid_4">
          <div class="s_order clearfix">
            <p class="s_id"><span class="s_999">订单号:</span> <span class="s_main_color">#6</span></p>

            <p class="s_status s_secondary_color">交易完成</p>
            <span class="clear"></span>
            <dl class="clearfix">
                <dt>添加日期::</dt>
              <dd>07/04/2011</dd>
              <dt>用户::</dt>
              <dd>唐便便</dd>
              <dt>商品数量::</dt>

              <dd>2</dd>
            </dl>
            <span class="clear border_eee"></span>
            <br />
            <p class="s_total left">2,289.69<span class="s_currency s_after"></span></p>

            <a href="invoice.jsp" class="s_main_color right"><strong>预览</strong></a>
          </div>
        </div>
                <div class="grid_4">
          <div class="s_order clearfix">
            <p class="s_id"><span class="s_999">订单号:</span> <span class="s_main_color">#5</span></p>
            <p class="s_status s_secondary_color">已发货</p>

            <span class="clear"></span>
            <dl class="clearfix">
              <dt>添加日期::</dt>
              <dd>07/04/2011</dd>
              <dt>用户::</dt>
              <dd>唐便便</dd>
              <dt>商品数量::</dt>

              <dd>2</dd>
            </dl>
            <span class="clear border_eee"></span>
            <br />
            <p class="s_total left">2,861.54<span class="s_currency s_after"> </span></p>
            <a href="invoice.jsp" class="s_main_color right"><strong>预览</strong></a>

          </div>
        </div>
        <div class="grid_4">
          <div class="s_order clearfix">
            <p class="s_id"><span class="s_999">订单号:</span> <span class="s_main_color">#4</span></p>
            <p class="s_status s_secondary_color">退款</p>
            <span class="clear"></span>

            <dl class="clearfix">
             <dt>添加日期::</dt>
              <dd>07/04/2011</dd>
              <dt>用户::</dt>
              <dd>唐便便</dd>
              <dt>商品数量::</dt>

              <dd>3</dd>
            </dl>
            <span class="clear border_eee"></span>
            <br />
            <p class="s_total left"><span class="s_currency s_before"></span>5,247.92</p>
            <a href="invoice.jsp" class="s_main_color right"><strong>预览</strong></a>
          </div>

        </div>
        <div class="grid_4">
          <div class="s_order clearfix">
            <p class="s_id"><span class="s_999">订单号:</span> <span class="s_main_color">#3</span></p>
            <p class="s_status s_secondary_color">已取消</p>
            <span class="clear"></span>
            <dl class="clearfix">

              <dt>添加日期::</dt>
              <dd>07/04/2011</dd>
              <dt>用户::</dt>
              <dd>唐便便</dd>
              <dt>商品数量::</dt>

              <dd>2</dd>
            </dl>
            <span class="clear border_eee"></span>
            <br />
            <p class="s_total left"><span class="s_currency s_before"></span>133.93</p>
            <a href="invoice.jsp" class="s_main_color right"><strong>预览</strong></a>
          </div>
        </div>

                <div class="grid_4">
          <div class="s_order clearfix">
            <p class="s_id"><span class="s_999">订单号:</span> <span class="s_main_color">#2</span></p>
            <p class="s_status s_secondary_color">已取消</p>
            <span class="clear"></span>
            <dl class="clearfix">
            <dt>添加日期::</dt>
              <dd>07/04/2011</dd>
              <dt>用户::</dt>
              <dd>唐便便</dd>
              <dt>商品数量::</dt>

              <dd>2</dd>
            </dl>

            <span class="clear border_eee"></span>
            <br />
            <p class="s_total left"><span class="s_currency s_before"></span>460.57</p>
            <a href="invoice.jsp" class="s_main_color right"><strong>预览</strong></a>
          </div>
        </div>
                <div class="grid_4">

          <div class="s_order clearfix">
            <p class="s_id"><span class="s_999">订单号:</span> <span class="s_main_color">#1</span></p>
            <p class="s_status s_secondary_color">未付款</p>
            <span class="clear"></span>
            <dl class="clearfix">
              

             <dt>添加日期::</dt>
              <dd>07/04/2011</dd>
              <dt>用户::</dt>
              <dd>唐便便</dd>
              <dt>商品数量::</dt>

              <dd>2</dd>
            </dl>

            <span class="clear border_eee"></span>
            <br />
            <p class="s_total left"><span class="s_currency s_before"></span>1,633.46</p>
            <a href="invoice.jsp" class="s_main_color right"><strong>预览</strong></a>
          </div>
        </div>
      </div>

      <a href="invoice.jsp" class="s_button_1 s_main_color_bgr"><span class="s_text">下一步</span></a>

      <div class="clear"></div>
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

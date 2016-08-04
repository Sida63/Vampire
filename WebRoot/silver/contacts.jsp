<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" dir="ltr" >
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=GB18030" />
  <title>Your Store</title>
  <meta name="description" content="My Store" />
  <link rel="stylesheet" type="text/css" href="stylesheet/960.css" media="all" />
  <link rel="stylesheet" type="text/css" href="stylesheet/screen.css" media="screen" />
  <link rel="stylesheet" type="text/css" href="stylesheet/color.css" media="screen" />
  <link rel="stylesheet" type="text/css" href="stylesheet/jquery.cart.css" />
<!--[if lt IE 9]>
<link rel="stylesheet" type="text/css" href="stylesheet/ie.css" media="screen" />
<![endif]-->

<script type='text/javascript' src='js/plugins/jquery/jquery-1.9.1.min.js'></script>
<script type='text/javascript' src='js/plugins/jquery/jquery-ui-1.10.1.custom.min.js'></script>
<script type="text/javascript" src="js/jquery/jquery.validate.min.js"></script>
<script type="text/javascript" src="js/shoppica.js"></script>
<script type='text/javascript' src='js/jquery/cart/jquery.cookie.js'></script>
<script type='text/javascript' src='js/jquery/cart/jquery.cart.js' charset='utf-8'></script>
<script type="text/javascript" src="js/yaes.cart.js"></script>
<script type="text/javascript">
  $(document).ready(function () {

   jQuery.validator.setDefaults({
     errorElement: "p",
     errorClass: "s_error_msg",
     errorPlacement: function(error, element) {
       error.insertAfter(element);
     },
     highlight: function(element, errorClass, validClass) {
       $(element).addClass("error_element").removeClass(validClass);
       $(element).parent("div").addClass("s_error_row");
     },
     unhighlight: function(element, errorClass, validClass) {
       $(element).removeClass("error_element").addClass(validClass);
       $(element).parent("div").removeClass("s_error_row");
     }
   });
   $("#contact_form").validate({
    rules: {
     enquiry: {
       required: true,
       minlength: 10
     }
   }
 });

 });
</script>
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
            <a href="">主页</a>
            &gt;
            <a href="">联系我们</a>
          </div>
          <h1>联系我们</h1>
        </div>
      </div>
    </div>
    <!-- end of intro -->


    <!-- ********************** --> 
    <!--      C O N T E N T     -->
    <!-- ********************** --> 
    <div id="content" class="container_16">

      <div id="contacts" class="s_info_page grid_12">

        <h2><span class="s_secondary_color">商店</span> 地址</h2>

        <p class="alpha grid_4"><strong>Yet Another E-Shop</strong><br /> 5 家分店<br /> 昆山<br /> 1000</p>
        <p class="grid_4"><strong>联系电话:</strong><br /> +1 (0) 7007001</p>
        <p class="omega grid_4"><strong>传真:</strong><br /> +1 (0) 7007002</p>

        <br />
        <span class="clear border_ddd"></span>
        <br />


        <h2><span class="s_secondary_color">发送</span> 一个信息</h2>

        <form id="contact_form" action="#" method="post" enctype="multipart/form-data">
         <div id="contact_form_icon"></div>

         <div class="s_row_3 clearfix">
          <label><strong>名:</strong> *</label>
          <input type="text" size="40" class="required" title="Name must be between 3 and 32 characters!" />
        </div>
        <div class="s_row_3 clearfix">
          <label><strong>E-Mail 地址:</strong> *</label>
          <input type="text" size="40" class="required email" title="E-Mail Address does not appear to be valid!" />
        </div>
        <div class="s_row_3 clearfix">
          <label><strong>查询:</strong> *</label>
          <div class="s_full">
            <textarea id="enquiry" style="width: 98%;" rows="10" class="required" title="Enquiry must be between 10 and 3000 characters!" cols="50"></textarea>
          </div>
        </div>
        <a class="s_button_1 s_main_color_bgr" onclick="$('#contact_form').submit();"><span class="s_text">发送信息</span></a>
      </form>

    </div>
    
    <div id="right_col" class="grid_3">

      <div id="information_module" class="s_box">
        <h2>信息</h2>
        <ul class="s_list_1">
          <li><a href="static.jsp">关于 Yet Another E-Shop</a></li>
          <li><a href="static.jsp">隐私政策</a></li>
          <li><a href="static.jsp">条款 &amp; 条件</a></li>
          <li><a href="contacts.jsp">联系我们</a></li>
          <li><a href="sitemap.jsp">网站地图</a></li>
        </ul>
      </div>

      <div id="featured_side" class="s_box clearfix">
        <h2>专题</h2>
        <div class="s_item s_size_1 clearfix">
          <a class="s_thumb" href="product.jsp"><img src="images/product_38x38.jpg" width="38" height="38" alt="White football trainers" /></a>
          <h3><a href="product.jsp">白色足球教练员</a></h3>
          <p><a href="product.jsp"><span class="s_main_color"><span class="s_currency s_before">£</span>117.50</span></a></p>
        </div>
        <div class="s_item s_size_1 clearfix">
          <a class="s_thumb" href="product.jsp"><img src="images/product_38x38.jpg" width="38" height="38" alt="Hubo Boss Emotion" /></a>
          <h3><a href="product.jsp">Hubo Boss Emotion</a></h3>
          <p><a href="product.jsp"><span class="s_main_color"><span class="s_currency s_before">£</span>2,350.00</span></a></p>
        </div>
        <div class="s_item s_size_1 clearfix">
          <a class="s_thumb" href="product.jsp"><img src="images/product_38x38.jpg" width="38" height="38" alt="Christian Dior J'adore" /></a>
          <h3><a href="product.jsp">Christian Dior J'adore</a></h3>
          <p><a href="product.jsp"><span class="s_main_color"><span class="s_currency s_before">£</span>328.99</span></a></p>
        </div>
      </div>

    </div>
    
    <div class="clear"></div>

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
  <%@include file="include/shopinfo.jsp" %>
  <!-- end of FOOTER --> 
  
</div>

</body>
</html>

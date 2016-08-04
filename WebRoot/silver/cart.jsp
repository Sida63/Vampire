<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html >
<html dir="ltr"  >
<head>
  <meta http-equiv="Content-Type" content="text/html;" charset="GB18030"/>
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
            <a href="index.jsp">主页</a>
            &gt; <a href="cart.jsp">购物车</a>
          </div>
          <h1>购物车 (0.00kg)</h1>
        </div>
      </div>
    </div>
    <!-- end of intro -->

    <!-- ********************** --> 
    <!--      C O N T E N T     --> 
    <!-- ********************** --> 
    <div id="content" class="container_12">

      <div id="shopping_cart" class="grid_12">

        <form id="cart" class="clearfix" action="checkout.jsp">
          <table class="s_table_1" width="100%" cellpadding="0" cellspacing="0" border="0">
            <tr>
              <th width="65">移除</th>
              <th width="60">图片</th>
              <th width="320">商品名称</th>
              <th>模型</th>
              <th>质量</th>
              <th>单价</th>
              <th>总价</th>
            </tr>
            <tr class="even">
              <td valign="middle"><input type="checkbox" /></td>
              <td valign="middle"><a href="product.jsp"><img src="images/product_140x140.jpg" width="60" height="60" alt="Panasonic Lumix" /></a></td>
              <td valign="middle"><a href="product.jsp"><strong>松下索尼 Lumix</strong></a></td>
              <td valign="middle">产品 4</td>
              <td valign="middle"><input type="text" size="3" /></td>
              <td valign="middle">94.00<span class="s_currency s_after"> 元</span></td>
              <td valign="middle">94.00<span class="s_currency s_after"> 元</span></td>
            </tr>
            <tr class="odd">
              <td valign="middle"><input type="checkbox" /></td>
              <td valign="middle"><a href="product.jsp"><img src="images/product_140x140.jpg" width="60" height="60" alt="Armani Acqua di Gioia" /></a></td>
              <td valign="middle"><a href="product.jsp"><strong>中兴手机</strong></a></td>
              <td valign="middle">产品4</td>
              <td valign="middle"><input type="text" size="3" /></td>
              <td valign="middle">822.50<span class="s_currency s_after"> 元</span></td>
              <td valign="middle">822.50<span class="s_currency s_after"> 元</span></td>
            </tr>
            <tr class="even">
              <td valign="middle"><input type="checkbox" /></td>
              <td valign="middle"><a href="product.jsp"><img src="images/product_140x140.jpg" width="60" height="60" alt="Jameson Whiskey Special Reserve 12 yers" /></a></td>
              <td valign="middle"><a href="product.jsp"><strong>蓝牙耳机</strong></a></td>
              <td valign="middle">产品8</td>
              <td valign="middle"><input type="text" size="3" /></td>
              <td valign="middle">117.50<span class="s_currency s_after"> 元</span></td>
              <td valign="middle">117.50<span class="s_currency s_after"> 元</span></td>
            </tr>
          </table>
          <br />
          <p class="s_total"><strong>提交总价:</strong> 880.00<span class="s_currency s_after"> 元</span></p>
          <p class="s_total"><strong>运费 17.5%:</strong> 154.00<span class="s_currency s_after"> eur</span></p>
          <p class="s_total s_secondary_color last"><strong>总价:</strong> 1,034.00<span class="s_currency s_after"> 元</span></p>

          <div class="clear"></div>
          <br />

          <a class="s_button_1 s_ddd_bgr left"><span class="s_text">继续购物</span></a>
          <button class="s_button_1 s_main_color_bgr" type="submit"><span class="s_text">买单</span></button>
          <a class="s_button_1 s_main_color_bgr"><span class="s_text">更新</span></a>
        </form>

      </div>

      <div class="clear"></div>
      <br />
      <br />

    </div>
    <!-- end of content --> 

    <!-- ********************** --> 
    <!--   S H O P   I N F O    --> 
    <!-- ********************** --> 
    <%@include file="include/shopinfo.jsp" %>

    <!-- ********************** --> 
    <!--      F O O T E R       --> 
    <!-- ********************** --> 
    <%@include file="include/footer.jsp" %>
    <!-- end of FOOTER --> 

  </div>
</body>
</html>

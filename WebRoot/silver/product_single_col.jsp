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
<link rel="stylesheet" type="text/css" href="stylesheet/prettyPhoto.css" media="all" />
<link rel="stylesheet" type="text/css" href="stylesheet/jquery.cart.css" />
<!--[if lt IE 9]>
<link rel="stylesheet" type="text/css" href="stylesheet/ie.css" media="screen" />
<![endif]-->

<script type='text/javascript' src='js/plugins/jquery/jquery-1.9.1.min.js'></script>
<script type='text/javascript' src='js/plugins/jquery/jquery-ui-1.10.1.custom.min.js'></script>
<script type="text/javascript" src="js/jquery/jquery.prettyPhoto.js"></script>
<script type="text/javascript" src="js/shoppica.js"></script>
<script type='text/javascript' src='js/jquery/cart/jquery.cookie.js'></script>
<script type='text/javascript' src='js/jquery/cart/jquery.cart.js' charset='utf-8'></script>
<script type="text/javascript" src="js/yaes.cart.js"></script>
<script type="text/javascript">

$(document).ready(function() {

  $(".s_tabs").tabs({ fx: { opacity: 'toggle', duration: 300 } });

  $("#product_images a[rel^='prettyPhoto'], #product_gallery a[rel^='prettyPhoto']").prettyPhoto({
    theme: 'light_square',
    opacity: 0.5
  });

});

</script>
<script type='text/javascript' src='js/plugins/jquery/jquery-1.9.1.min.js'></script>
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
          <a href="">Home</a>
          &gt;
          <a href="">Clothing</a>
        </div>
        <h1>Clothing</h1>
      </div>
    </div>
  </div>
  <!-- end of intro -->

  
  <!-- ********************** --> 
  <!--      C O N T E N T     -->
  <!-- ********************** --> 
  <div id="content" class="product_view container_12">

    <div id="product" class="grid_12">
      <div id="product_images" class="grid_4 alpha">
      	<a id="product_image_preview" rel="prettyPhoto[gallery]" href="images/product_300x300.jpg"><img id="image" src="images/product_300x300.jpg" title="Leica M7" alt="Leica M7" /></a>
      </div>
      <div id="product_info" class="grid_4">
        <p class="s_price s_promo_price"><span class="s_old_price">940.00<span class="s_currency s_after"> eur</span></span> 822.50<span class="s_currency s_after"> eur</span></p>
        <dl class="clearfix">
          <dt>库存</dt>
          <dd>有</dd>
          <dt>型号</dt>
          <dd>产品 4</dd>
          <dt>生产商</dt>
          <dd><a href="#">Canon</a></dd>
          <dt>评价指数</dt>
          <dd>
            <p class="s_rating s_rating_5"><span style="width: 100%;" class="s_percent"></span></p>
          </dd>
        </dl>
      	<p class="s_short_desc">嘛玩意</p>
        <div id="product_share" class="clearfix">
          <!-- AddThis Button BEGIN -->
          <div class="addthis_toolbox addthis_default_style ">
          <a class="addthis_button_facebook_like" fb:like:layout="button_count"></a>
          <a class="addthis_button_tweet"></a>
          <a class="addthis_counter addthis_pill_style"></a>
          </div>
          <script type="text/javascript" src="http://s7.addthis.com/js/250/addthis_widget.js#pubid=xa-4de0eff004042e7a"></script>
          <!-- AddThis Button END -->
        </div>
      </div>
      <div class="grid_4 omega">
      	<div class="suffix_2 left s_999">
        	<p>包含 12% 附加税</p>
          <p class="s_f_11"><strong>免邮条件：</strong> 200以上，全国</p>
        </div>
        <div id="product_options">
          <h3>可选项</h3>
          <label for="option_Memory">内存</label>
          <select id="option_Memory">
            <option value="676">1 GB +29.38 eur</option>
            <option value="677">2 GB +47.00 eur</option>
          </select>
          <span class="clear"></span>
        </div>
        <div id="product_buy" class="clearfix">
          <label for="product_buy_quantity">数量:</label>
          <input id="product_buy_quantity" type="text" size="2" />
          <a id="add_to_cart" class="s_main_color_bgr"><span class="s_text"><span class="s_icon"></span> 加入购物车</span></a>
        </div>
      </div>
      <div class="clear"></div>
      <div class="s_tabs grid_12 alpha omega">
        <ul class="s_tabs_nav clearfix">
          <li><a href="#product_description">商品描述</a></li>
          <li><a href="#product_reviews">评论 (0)</a></li>
          <li><a href="#product_gallery"> 图片(2)</a></li>
        </ul>
        <div class="s_tab_box">
        
          <div id="product_description">
            <div class="cpt_product_description ">
              你
              
      
      
      
              
              索
              
           
              
              
              
              嘛
              
              
              
              
              
              
              
              
            </div>
            <!-- cpt_container_end -->
          </div>

          <div id="product_reviews" class="s_listing">
            <div class="s_review last">
              <p class="s_author"><strong>Shoppica</strong><small>(29/03/2011)</small></p>
              <div class="right">
                <div class="s_rating_holder">
                  <p class="s_rating s_rating_5"><span class="s_percent" style="width: 100%;"></span></p>
                  <span class="s_average">5星</span>
                </div>
              </div>
              <div class="clear"></div>
              <p>哇哈哈哈哈哈哈哈</p>
            </div>
            <div class="pagination"><div class="results">Showing 1 to 1 of 1 (1 Pages)</div></div>
            <h2 class="s_title_1"><span class="s_main_color">评</span> 论</h2>
            <div id="review_title" class="clear"></div>
            <div class="s_row_3 clearfix">
              <label><strong>你的名字:</strong></label>
              <input type="text" />
            </div>
            <div class="s_row_3 clearfix">
              <label><strong>你的评论:</strong></label>
              <textarea style="width: 98%;" rows="8" cols="50"></textarea>
              <p class="s_legend"><span style="color: #FF0000;">Note:</span> HTML未翻译!</p>
            </div>
            <div class="s_row_3 clearfix">
              <label><strong>评分</strong></label>
              <span class="clear"></span> <span>差</span>&nbsp;
              <input type="radio" />
              &nbsp;
              <input type="radio" />
              &nbsp;
              <input type="radio" />
              &nbsp;
              <input type="radio" />
              &nbsp;
              <input type="radio" />
              &nbsp; <span>好</span>
            </div>
            <span class="clear border_ddd"></span>
            <a class="s_button_1 s_main_color_bgr"><span class="s_text">下一步</span></a> <span class="clear"></span> </div>
          <div id="product_gallery">
            <ul class="s_thumbs clearfix">
              <li><a class="s_thumb" href="images/product_300x300.jpg" title="Leica M7" rel="prettyPhoto[gallery]"><img src="images/product_140x140.jpg" width="120" title="Leica M7" alt="Leica M7" /></a></li>
              <li><a class="s_thumb" href="images/product_300x300.jpg" title="Leica M7" rel="prettyPhoto[gallery]"><img src="images/product_140x140.jpg" width="120" title="Leica M7" alt="Leica M7" /></a></li>
            </ul>
          </div>
        </div>
      </div>
      
      <div id="related_products_1" class="grid_12 alpha omega">
        <h2 class="s_title_1"><span class="s_main_color">相关</span> 产品</h2>
        <div class="clear"></div>
        <div class="s_grid_view s_listing clearfix">
          <div class="s_item grid_3">
          	<a class="s_thumb" href="product.jsp"><img src="images/product_140x140.jpg" title="Panasonic Lumix" alt="Panasonic Lumix" /></a>
            <h3><a href="product.jsp">Panasonic Lumix</a></h3>
            <p class="s_model">Product 4</p>
            <p class="s_price">94.00<span class="s_currency s_after"> eur</span></p>
            <a class="s_button_add_to_cart" href="cart.jsp"><span class="s_icon_16"><span class="s_icon"></span>Add to Cart</span></a>
          </div>
          <div class="s_item grid_3">
          	<a class="s_thumb" href="product.jsp"><img src="images/product_140x140.jpg" title="Panasonic Lumix" alt="Panasonic Lumix" /></a>
            <h3><a href="product.jsp">Panasonic Lumix</a></h3>
            <p class="s_model">Product 4</p>
            <p class="s_price">94.00<span class="s_currency s_after"> eur</span></p>
            <a class="s_button_add_to_cart" href="cart.jsp"><span class="s_icon_16"><span class="s_icon"></span>Add to Cart</span></a>
          </div>
          <div class="s_item grid_3">
          	<a class="s_thumb" href="product.jsp"><img src="images/product_140x140.jpg" title="Panasonic Lumix" alt="Panasonic Lumix" /></a>
            <h3><a href="product.jsp">Panasonic Lumix</a></h3>
            <p class="s_model">Product 4</p>
            <p class="s_price">94.00<span class="s_currency s_after"> eur</span></p>
            <a class="s_button_add_to_cart" href="cart.jsp"><span class="s_icon_16"><span class="s_icon"></span>Add to Cart</span></a>
          </div>
          <div class="s_item grid_3">
          	<a class="s_thumb" href="product.jsp"><img src="images/product_140x140.jpg" title="Panasonic Lumix" alt="Panasonic Lumix" /></a>
            <h3><a href="product.jsp">Panasonic Lumix</a></h3>
            <p class="s_model">Product 4</p>
            <p class="s_price">94.00<span class="s_currency s_after"> eur</span></p>
            <a class="s_button_add_to_cart" href="cart.jsp"><span class="s_icon_16"><span class="s_icon"></span>Add to Cart</span></a>
          </div>
          <div class="clear"></div>
        </div>
      </div>
      
      <div id="related_products_2" class="grid_12 alpha omega">
        <h2 class="s_title_1"><span class="s_main_color">Related</span> Products (smaller)</h2>
        <div class="clear"></div>
        <div class="s_grid_view s_listing clearfix">
          <div class="s_item grid_2">
          	<a class="s_thumb" href="product.jsp"><img src="images/product_180x180.jpg" title="Panasonic Lumix" alt="Panasonic Lumix" /></a>
            <h3><a href="product.jsp">Panasonic Lumix</a></h3>
            <p class="s_model">Product 4</p>
            <p class="s_price">94.00<span class="s_currency s_after"> eur</span></p>
            <a class="s_button_add_to_cart" href="cart.jsp"><span class="s_icon_16"><span class="s_icon"></span>Add to Cart</span></a>
          </div>
          <div class="s_item grid_2">
          	<a class="s_thumb" href="product.jsp"><img src="images/product_140x140.jpg" title="Panasonic Lumix" alt="Panasonic Lumix" /></a>
            <h3><a href="product.jsp">Panasonic Lumix</a></h3>
            <p class="s_model">Product 4</p>
            <p class="s_price">94.00<span class="s_currency s_after"> eur</span></p>
            <a class="s_button_add_to_cart" href="cart.jsp"><span class="s_icon_16"><span class="s_icon"></span>Add to Cart</span></a>
          </div>
          <div class="s_item grid_2">
          	<a class="s_thumb" href="product.jsp"><img src="images/product_180x180.jpg" title="Panasonic Lumix" alt="Panasonic Lumix" /></a>
            <h3><a href="product.jsp">Panasonic Lumix</a></h3>
            <p class="s_model">Product 4</p>
            <p class="s_price">94.00<span class="s_currency s_after"> eur</span></p>
            <a class="s_button_add_to_cart" href="cart.jsp"><span class="s_icon_16"><span class="s_icon"></span>Add to Cart</span></a>
          </div>
          <div class="s_item grid_2">
          	<a class="s_thumb" href="product.jsp"><img src="images/product_180x180.jpg" title="Panasonic Lumix" alt="Panasonic Lumix" /></a>
            <h3><a href="product.jsp">Panasonic Lumix</a></h3>
            <p class="s_model">Product 4</p>
            <p class="s_price">94.00<span class="s_currency s_after"> eur</span></p>
            <a class="s_button_add_to_cart" href="cart.jsp"><span class="s_icon_16"><span class="s_icon"></span>Add to Cart</span></a>
          </div>
          <div class="s_item grid_2">
          	<a class="s_thumb" href="product.jsp"><img src="images/product_180x180.jpg" title="Panasonic Lumix" alt="Panasonic Lumix" /></a>
            <h3><a href="product.jsp">Panasonic Lumix</a></h3>
            <p class="s_model">Product 4</p>
            <p class="s_price">94.00<span class="s_currency s_after"> eur</span></p>
            <a class="s_button_add_to_cart" href="cart.jsp"><span class="s_icon_16"><span class="s_icon"></span>Add to Cart</span></a>
          </div>
          <div class="s_item grid_2">
          	<a class="s_thumb" href="product.jsp"><img src="images/product_180x180.jpg" title="Panasonic Lumix" alt="Panasonic Lumix" /></a>
            <h3><a href="product.jsp">Panasonic Lumix</a></h3>
            <p class="s_model">Product 4</p>
            <p class="s_price">94.00<span class="s_currency s_after"> eur</span></p>
            <a class="s_button_add_to_cart" href="cart.jsp"><span class="s_icon_16"><span class="s_icon"></span>Add to Cart</span></a>
          </div>
          <div class="clear"></div>
        </div>
      </div>
      
      <div id="product_tags" class="grid_12 alpha omega">
        <h2 class="s_title_1"><span class="s_main_color">商品</span> 标签</h2>
        <div class="clear"></div>
        <ul class="clearfix">
          <li><a href="#">Centrino</a></li>
          <li><a href="#">Intel</a></li>
          <li><a href="#">VAIO</a></li>
          <li><a href="#">laptop</a></li>
          <li><a href="#">notebook</a></li>
        </ul>
      </div>
      
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

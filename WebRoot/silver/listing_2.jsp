<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>

<!DOCTYPE HTML>
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
<script type='text/javascript' src='js/plugins/jquery/jquery-ui-1.10.1.custom.min.js'></script>
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
  <div id="content" class="container_12">

    
    <div id="category" class="grid_9">

      <div class="s_subcategories s_grid_view s_listing clearfix">
        <div class="s_subcategory"> <a href=""><img src="images/category_100x100.jpg" title="Digital Cameras" alt="Digital Cameras" style="margin-bottom: 3px;" /></a> <a href="">数码相机</a> </div>
        <div class="s_subcategory"> <a href=""><img src="images/category_100x100.jpg" title="Home Audio" alt="Home Audio" style="margin-bottom: 3px;" /></a> <a href="">家用音响</a> </div>
        <div class="s_subcategory"> <a href=""><img src="images/category_100x100.jpg" title="Home Cinema" alt="Home Cinema" style="margin-bottom: 3px;" /></a> <a href="">家庭影院</a> </div>
        <div class="s_subcategory"> <a href=""><img src="images/category_100x100.jpg" title="Cell Phones" alt="Cell Phones" style="margin-bottom: 3px;" /></a> <a href="">手机</a> </div>
        <div class="s_subcategory"> <a href=""><img src="images/category_100x100.jpg" title="MP3 Players" alt="MP3 Players" style="margin-bottom: 3px;" /></a> <a href="">MP3播放器</a> </div>
        <div class="s_subcategory"> <a href=""><img src="images/category_100x100.jpg" title="Car-Audio" alt="Car-Audio" style="margin-bottom: 3px;" /></a> <a href="">汽车音响</a> </div>
        <div class="clear"></div>
      </div>
      
      <div id="listing_options">
        <div id="listing_sort" class="s_switcher">
          <span class="s_selected">Default</span>
          <ul class="s_options" style="display: none;">
            <li><a href="">Name A - Z</a></li>
            <li><a href="">Name Z - A</a></li>
            <li><a href="">Price Low &gt; High</a></li>
            <li><a href="">Price High &gt; Low</a></li>
            <li><a href="">Rating Highest</a></li>
            <li><a href="">Rating Lowest</a></li>
            <li><a href="">Model A - Z</a></li>
            <li><a href="">Model Z - A</a></li>
          </ul>
        </div>
        <div id="view_mode" class="s_nav">
          <ul class="clearfix">
            <li id="view_grid" class="s_selected"><a href="listing_2.jsp"><span class="s_icon"></span>Grid</a></li>
            <li id="view_list"><a href="listing_1.jsp"><span class="s_icon"></span>List</a></li>
          </ul>
        </div>
      </div>

      <div class="clear"></div>
      
      <div class="s_listing s_grid_view clearfix">
      
        <div class="s_item grid_3"> <a class="s_thumb" href="product.jsp"><img src="images/product_180x180.jpg" title="Samsung SyncMaster 941BW" alt="Samsung SyncMaster 941BW" /></a>
          <h3><a href="product.jsp">Samsung SyncMaster 941BW</a></h3>
          <p class="s_model">Product 6</p>
          <p class="s_price"><span class="s_currency s_before">$</span>387.42</p>
          <p class="s_rating s_rating_5"><span style="width: 60%;" class="s_percent"></span></p>
          <a class="s_button_add_to_cart" href="product.jsp"><span class="s_icon_16"><span class="s_icon"></span>Add to Cart</span></a>
        </div>

        <div class="s_item grid_3"> <a class="s_thumb" href="product.jsp"><img src="images/product_180x180.jpg" title="Casual brownies" alt="Casual brownies" /></a>
          <h3><a href="product.jsp">Casual brownies</a></h3>
          <p class="s_model">Product 7</p>
          <p class="s_price"><span class="s_currency s_before">$</span>193.71</p>
          <a class="s_button_add_to_cart" href="product.jsp"><span class="s_icon_16"><span class="s_icon"></span>Add to Cart</span></a>
        </div>

        <div class="s_item grid_3"> <a class="s_thumb" href="product.jsp"><img src="images/product_180x180.jpg" title="White football trainers" alt="White football trainers" /></a>
          <h3><a href="product.jsp">White football trainers</a></h3>
          <p class="s_model">Product 8</p>
          <p class="s_price"><span class="s_currency s_before">$</span>193.71</p>
          <a class="s_button_add_to_cart" href="product.jsp"><span class="s_icon_16"><span class="s_icon"></span>Add to Cart</span></a>
        </div>

        <div class="clear"></div>

        <div class="s_item grid_3"> <a class="s_thumb" href="product.jsp"><img src="images/product_180x180.jpg" title="Brown moccasins" alt="Brown moccasins" /></a>
          <h3><a href="product.jsp">Brown moccasins</a></h3>
          <p class="s_model">Product 9</p>
          <p class="s_price"><span class="s_currency s_before">$</span>193.71</p>
          <a class="s_button_add_to_cart" href="product.jsp"><span class="s_icon_16"><span class="s_icon"></span>Add to Cart</span></a>
        </div>
        
        <div class="s_item grid_3"> <a class="s_thumb" href="product.jsp"><img src="images/product_180x180.jpg" title="Stylish high heels " alt="Stylish high heels " /></a>
          <h3><a href="product.jsp">Stylish high heels </a></h3>
          <p class="s_model">product 11</p>
          <p class="s_price"><span class="s_currency s_before">$</span>195.65</p>
          <a class="s_button_add_to_cart" href="product.jsp"><span class="s_icon_16"><span class="s_icon"></span>Add to Cart</span></a>
        </div>

        <div class="s_item grid_3"> <a class="s_thumb" href="product.jsp"><img src="images/product_180x180.jpg" title="Summer Pink" alt="Summer Pink" /></a>
          <h3><a href="product.jsp">Summer Pink</a></h3>
          <p class="s_model">Product 14</p>
          <p class="s_price"><span class="s_currency s_before">$</span>968.55</p>
          <a class="s_button_add_to_cart" href="product.jsp"><span class="s_icon_16"><span class="s_icon"></span>Add to Cart</span></a>
        </div>

        <div class="clear"></div>

        <div class="s_item grid_3"> <a class="s_thumb" href="product.jsp"><img src="images/product_180x180.jpg" title="Sony VAIO" alt="Sony VAIO" /></a>
          <h3><a href="product.jsp">Sony VAIO</a></h3>
          <p class="s_model">Product 19</p>
          <p class="s_price s_promo_price"><span class="s_old_price"><span class="s_currency s_before">$</span>1,937.10</span> <span class="s_currency s_before">$</span>1,743.39</p>
          <p class="s_rating s_rating_5"><span style="width: 100%;" class="s_percent"></span></p>
          <a class="s_button_add_to_cart" href="product.jsp"><span class="s_icon_16"><span class="s_icon"></span>Add to Cart</span></a>
        </div>
        
        <div class="s_item grid_3"> <a class="s_thumb" href="product.jsp"><img src="images/product_180x180.jpg" title="iPod Classic" alt="iPod Classic" /></a>
          <h3><a href="product.jsp">iPod Classic</a></h3>
          <p class="s_model">product 20</p>
          <p class="s_price"><span class="s_currency s_before">$</span>193.71</p>
          <a class="s_button_add_to_cart" href="product.jsp"><span class="s_icon_16"><span class="s_icon"></span>Add to Cart</span></a>
        </div>
        
        <div class="s_item grid_3"> <a class="s_thumb" href="product.jsp"><img src="images/product_180x180.jpg" title="Black&amp;White - classy sneakers" alt="Black&amp;White - classy sneakers" /></a>
          <h3><a href="product.jsp">Black&amp;White - classy sneakers</a></h3>
          <p class="s_model">Product 8</p>
          <p class="s_price"><span class="s_currency s_before">$</span>193.71</p>
          <a class="s_button_add_to_cart" href="product.jsp"><span class="s_icon_16"><span class="s_icon"></span>Add to Cart</span></a>
        </div>

        <div class="clear"></div>

        <div class="s_item grid_3"> <a class="s_thumb" href="product.jsp"><img src="images/product_180x180.jpg" title="Adidas Gazella" alt="Adidas Gazella" /></a>
          <h3><a href="product.jsp">Adidas Gazella</a></h3>
          <p class="s_model">Product 6</p>
          <p class="s_price"><span class="s_currency s_before">$</span>387.42</p>
          <a class="s_button_add_to_cart" href="product.jsp"><span class="s_icon_16"><span class="s_icon"></span>Add to Cart</span></a>
        </div>
        
        <div class="s_item grid_3"> <a class="s_thumb" href="product.jsp"><img src="images/product_180x180.jpg" title="Classy shoes" alt="Classy shoes" /></a>
          <h3><a href="product.jsp">Classy shoes</a></h3>
          <p class="s_model">Product 19</p>
          <p class="s_price"><span class="s_currency s_before">$</span>1,937.10</p>
          <a class="s_button_add_to_cart" href="product.jsp"><span class="s_icon_16"><span class="s_icon"></span>Add to Cart</span></a>
        </div>

        <div class="s_item grid_3"> <a class="s_thumb" href="product.jsp"><img src="images/product_180x180.jpg" title="Red classic" alt="Red classic" /></a>
          <h3><a href="product.jsp">Red classic</a></h3>
          <p class="s_model">Product 14</p>
          <p class="s_price"><span class="s_currency s_before">$</span>968.55</p>
          <a class="s_button_add_to_cart" href="product.jsp"><span class="s_icon_16"><span class="s_icon"></span>Add to Cart</span></a>
        </div>
        
        <div class="clear"></div>

      </div>

      <div class="pagination">
        <div class="links"> <b>1</b> <a href="">2</a> <a href="">&gt;</a> <a href="">&gt;|</a> </div>
        <div class="results">Showing 1 to 12 of 20 (2 Pages)</div>
      </div>
      
		</div>
    
    <div id="right_col" class="grid_3">
      <div id="cart_side" class="s_box_1 s_cart_holder">
        <h2 class="s_secondary_color">购物车</h2>
        <div id="cart_side_contents">
          <p class="s_mb_0">0 items</p>
        </div>
      </div>
      
      <div id="categories_module" class="s_box">
        <h2>Categories</h2>
        <div class="s_list_1">
          <ul>
          	<li>
            	<a href="listing_1.jsp"><b>电子产品</b></a>
            	<ul>
              	<li><a href="listing_1.jsp">数码相机</a></li>
                <li><a href="listing_1.jsp">家用音响</a></li>
                <li><a href="listing_1.jsp">家庭影院</a></li>
                <li><a href="listing_1.jsp">手机</a></li>
                <li><a href="listing_1.jsp">MP3播放器</a></li>
                <li><a href="listing_1.jsp">汽车音响</a></li>
              </ul>
            </li>
            <li><a href="listing_1.jsp">电脑</a></li>
            <li><a href="listing_1.jsp">服装</a></li>
            <li><a href="listing_1.jsp">鞋类</a></li>
            <li><a href="listing_1.jsp">礼物</a></li>
            <li><a href="listing_1.jsp">家具</a></li>
            <li><a href="listing_1.jsp">健康</a></li>
            <li><a href="listing_1.jsp">珠宝</a></li>
            <li><a href="listing_1.jsp">书籍</a></li>
          </ul>
      	</div>
			</div>
      
    	<div id="brands_module" class="s_box">
        <h2>Brands</h2>
        <select onchange="location = this.value">
          <option> --- Please Select --- </option>
          <option>Adidas</option>
          <option>Apple</option>
          <option>Armani</option>
          <option>Balenciaga</option>
          <option>Bvlgari</option>
          <option>Canon</option>
          <option>Christian Dior</option>
          <option>Elisabeth Arden</option>
          <option>Hewlett-Packard</option>
          <option>HTC</option>
          <option>Hugo Boss</option>
          <option>Nike</option>
          <option>Nikon</option>
          <option>Palm</option>
          <option>Panasonic</option>
          <option>Reebok</option>
          <option>Samsung</option>
          <option>Sony</option>
          <option>Swarovski</option>
        </select>
      </div>
      
      <div id="bestseller_side" class="s_box clearfix">
        <h2>畅销</h2>
        <div class="s_item s_size_1 clearfix">
          <a class="s_thumb" href="product.jsp"><img src="images/product_38x38.jpg" width="38" height="38" alt="iPhone 3GS 8GB" /></a>
          <h3><a href="product.jsp">iPhone 3GS 8GB</a></h3>
          <p><a href="product.jsp"><span class="s_main_color"><span class="s_currency s_before">£</span>587.50</span></a></p>
        </div>
        
        <div class="s_item s_size_1 clearfix">
          <a class="s_thumb" href="product.jsp"><img src="images/product_38x38.jpg" width="38" height="38" alt="Hubo Boss Emotion" /></a>
          <h3><a href="product.jsp">Hubo Boss Emotion</a></h3>
          <p><a href="product.jsp"><span class="s_main_color"><span class="s_currency s_before">£</span>2,350.00</span></a></p>
        </div>
        
        <div class="s_item s_size_1 clearfix">
          <a class="s_thumb" href="product.jsp"><img src="images/product_38x38.jpg" width="38" height="38" alt="Panasonic Lumix" /></a>
          <h3><a href="product.jsp">Panasonic Lumix</a></h3>
          <p><a href="product.jsp"><span class="s_main_color"><span class="s_currency s_before">£</span>94.00</span></a></p>
        </div>
        
        <div class="s_item s_size_1 clearfix">
          <a class="s_thumb" href="product.jsp"><img src="images/product_38x38.jpg" width="38" height="38" alt="Casio Exilim Zoom" /></a>
          <h3><a href="product.jsp">Casio Exilim Zoom</a></h3>
          <p><a href="product.jsp"><span class="s_main_color"><span class="s_currency s_before">£</span>117.50</span></a></p>
        </div>
  
        <div class="s_item s_size_1 clearfix">
          <a class="s_thumb" href="product.jsp"><img src="images/product_38x38.jpg" width="38" height="38" alt="Christian Dior Amber Woman" /></a>
          <h3><a href="product.jsp">Christian Dior Amber Woman</a></h3>
          <p><a href="product.jsp"><span class="s_main_color"><span class="s_currency s_before">£</span>328.99</span></a></p>
        </div>
  
        <div class="s_item s_size_1 clearfix">
          <a class="s_thumb" href="product.jsp"><img src="images/product_38x38.jpg" width="38" height="38" alt="iPod Classic" /></a>
          <h3><a href="product.jsp">iPod Classic</a></h3>
          <p><a href="product.jsp"><span class="s_main_color"><span class="s_currency s_before">£</span>117.50</span></a></p>
        </div>
        
        <div class="s_item s_size_1 clearfix">
          <a class="s_thumb" href="product.jsp"><img src="images/product_38x38.jpg" width="38" height="38" alt="Sony VAIO" /></a>
          <h3><a href="product.jsp">Sony VAIO</a></h3>
          <p><a href="product.jsp"><span class="s_old"><span class="s_currency s_before">£</span>1,175.00</span> <span class="s_secondary_color"><span class="s_currency s_before">£</span>1,057.50</span></a></p>
          <div class="s_rating_holder clearfix"><p class="s_rating s_rating_small s_rating_5 left"><span style="width: 100%;" class="s_percent"></span></p><span class="left">&nbsp;5/5</span></div>
        </div>
  
        <div class="s_item s_size_1 clearfix">
          <a class="s_thumb" href="product.jsp"><img src="images/product_38x38.jpg" width="38" height="38" alt="Canon Digital Ixus 200 IS" /></a>
          <h3><a href="product.jsp">Canon Digital Ixus 200 IS</a></h3>
          <p><a href="product.jsp"><span class="s_main_color"><span class="s_currency s_before">£</span>117.50</span></a></p>
        </div>
    
        <div class="s_item s_size_1 clearfix">
          <a class="s_thumb" href="product.jsp"><img src="images/product_38x38.jpg" width="38" height="38" alt="Hugo Boss Chrome" /></a>
          <h3><a href="product.jsp">Hugo Boss Chrome</a></h3>
          <p><a href="product.jsp"><span class="s_main_color"><span class="s_currency s_before">£</span>94.00</span></a></p>
        </div>
    
        <div class="s_item s_size_1 clearfix">
          <a class="s_thumb" href="product.jsp"><img src="images/product_38x38.jpg" width="38" height="38" alt="Hennesy Paradis Extra" /></a>
          <h3><a href="product.jsp">Hennesy Paradis Extra</a></h3>
          <p><a href="product.jsp"><span class="s_old"><span class="s_currency s_before">£</span>1,175.00</span> <span class="s_secondary_color"><span class="s_currency s_before">£</span>1,057.50</span></a></p>
        </div>
    
        <div class="s_item s_size_1 clearfix">
          <a class="s_thumb" href="product.jsp"><img src="images/product_38x38.jpg" width="38" height="38" alt="Elizabeth Arden Pretty" /></a>
          <h3><a href="product.jsp">Elizabeth Arden Pretty</a></h3>
          <p><a href="product.jsp"><span class="s_main_color"><span class="s_currency s_before">£</span>94.00</span></a></p>
        </div>
    
        <div class="s_item s_size_1 clearfix">
          <a class="s_thumb" href="product.jsp"><img src="images/product_38x38.jpg" width="38" height="38" alt="Sony Cyber Shot S1000" /></a>
          <h3><a href="product.jsp">Sony Cyber Shot S1000</a></h3>
          <p><a href="product.jsp"><span class="s_main_color"><span class="s_currency s_before">£</span>117.50</span></a></p>
        </div>
      </div>
    
      <div id="information_module" class="s_box">
       <h2>信息</h2>
        <ul class="s_list_1">
          <li><a href="static.jsp">关于我们</a></li>
          <li><a href="static.jsp">隐私策略</a></li>
          <li><a href="static.jsp">使用条款</a></li>
          <li><a href="contacts.jsp">联系我们</a></li>
          <li><a href="sitemap.jsp">站点地图</a></li>
        </ul>
      </div>
  
      <div id="featured_side" class="s_box clearfix">
        <h2>特色</h2>
        <div class="s_item s_size_1 clearfix">
          <a class="s_thumb" href="product.jsp"><img src="images/product_38x38.jpg" width="38" height="38" alt="White football trainers" /></a>
          <h3><a href="product.jsp">White football trainers</a></h3>
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

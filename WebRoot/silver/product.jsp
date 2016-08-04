<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
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
<script type='text/javascript' src='js/jquery/cart/jquery.cookie.js'></script>
<script type='text/javascript' src='js/jquery/cart/jquery.cart.js' charset='utf-8'></script>
<script type="text/javascript" src="js/yaes.cart.js"></script>
<script type="text/javascript" src="js/shoppica.js"></script>
<script type="text/javascript" src="js/product.js"></script>
<script type="text/javascript" src="js/comments.js"></script>
<script type="text/javascript" src="js/related.js"></script>

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
          <a href="">Goods</a>
        </div>
        <h1>Goods</h1>
      </div>
    </div>
  </div>
  <!-- end of intro -->

  
  <!-- ********************** --> 
  <!--      C O N T E N T     -->
  <!-- ********************** --> 
  <div id="content" class="product_view container_16">

    <div id="product" class="grid_12">
      <div id="product_images" class="grid_6 alpha">
      	<a id="product_image_preview" rel="prettyPhoto[gallery]" href="images/product_300x300.jpg"><img id="image" src="images/product_300x300.jpg" title="Leica M7" alt="Leica M7" /></a>
      </div>
      <div id="product_info" class="grid_6 omega">
      <p class="s_price s_promo_price" ><span class="s_old_price">940.00<span class="s_currency s_after"> eur</span></span> <span id="price"></span><span class="s_currency s_after" > Yuan</span></p>
        
        <dl class="clearfix">
          <dt>���</dt>
          <dd ><span id="storage"></span></dd>
          <dt>�ͺ�</dt>
          <dd><span id="type"></span></dd>
          <dt>������</dt>
          <dd><span id="provide"></span></dd>
          <dt>����</dt>
          <dd ><span id="sales"></span></dd>
        </dl>
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
        <div id="product_options">
          <h3>��ѡ��</h3>
          <label for="option_Memory">�ڴ�</label>
          <select id="option_Memory">
            <option value="676">1 GB +29.38 RMB</option>
            <option value="677">2 GB +47.00 RMB</option>
          </select>
          <span class="clear"></span>
        </div>
        <div id="product_buy" class="clearfix">
          <label for="product_buy_quantity">����:</label>
          <input id="product_buy_quantity" type="text" size="2" />
          <a id="add_to_cart" class="s_main_color_bgr"><span class="s_text"><span class="s_icon"></span> ���빺�ﳵ </span></a>
        </div>
      </div>
      <div class="clear"></div>
      <div class="s_tabs grid_12 alpha omega">
        <ul class="s_tabs_nav clearfix">
          <li><a href="#product_description">��Ʒ����</a></li>
          <li><a href="#product_reviews">����</a></li>
          <li><a href="#product_gallery">��Ƭ</a></li>
        </ul>
        <div class="s_tab_box">
        
          <div id="product_description">
            <div class="cpt_product_description ">
            <span id="description"></span>
            </div>
            <!-- cpt_container_end -->
          </div>
          
          <div id="product_reviews" class="s_listing">
          
            <div class="s_review last">
            <table class="comm" width="100%">
            <tbody>
            <tr class="comments">
            <td width="20%"><span class="author"></span></td>
            <td width="80%"><span class="text"></span></td>
            </tr>
            </tbody>
            
            </table>
            
           
            </div>
            
            <div class="pagination"><div class="results">Showing 1 to 1 of 1 (1 Pages)</div></div>
            <h2 class="s_title_1"><span class="s_main_color">��</span> ��</h2>
            <div id="review_title" class="clear"></div>
            <div class="s_row_3 clearfix">
              <label><strong>�������:</strong></label>
              <input type="text" id="username" />
            </div>
            <div class="s_row_3 clearfix">
              <label><strong>�������:</strong></label>
              <textarea style="width: 98%;" rows="8" cols="50" id="text"></textarea>
              <p class="s_legend"><span style="color: #FF0000;">��¼:</span> </p>
            </div>
            <div class="s_row_3 clearfix">
              <label><strong>����</strong></label>
              <span class="clear"></span> <span>��</span>&nbsp;
              <input type="radio" />
              &nbsp;
              <input type="radio" />
              &nbsp;
              <input type="radio" />
              &nbsp;
              <input type="radio" />
              &nbsp;
              <input type="radio" />
              &nbsp; <span>��</span>
            </div>
            <span class="clear border_ddd"></span>
            <a class="s_button_1 s_main_color_bgr"><span class="s_text">��һ��</span></a> <span class="clear"></span>
          </div>
            
          <div id="product_gallery">
            <ul class="s_thumbs clearfix">
              <li><a class="s_thumb" href="images/product_300x300.jpg" title="Leica M7" rel="prettyPhoto[gallery]"><img src="images/product_140x140.jpg" width="120" title="Leica M7" alt="Leica M7" /></a></li>
              <li><a class="s_thumb" href="images/product_300x300.jpg" title="Leica M7" rel="prettyPhoto[gallery]"><img src="images/product_140x140.jpg" width="120" title="Leica M7" alt="Leica M7" /></a></li>
            </ul>
          </div>
        </div>
      </div>
      
      <div id="related_products" class="grid_12 alpha omega">
        <h2 class="s_title_1"><span class="s_main_color">���</span> ��Ʒ</h2>
        <div class="clear"></div>
        
        <div class="s_grid_view s_listing clearfix related">
          
          <div class="s_item grid_3 related_goods">
          	<a class="s_thumb" href="product.jsp"><img  class="image"/></a>
            <h3><a href="product.jsp"><span class="name">Panasonic Lumix</span></a></h3>
            <p class="s_model"><span class="type"></span></p>
            <p class="s_price"><span class="price"></span><span class="s_currency s_after"> RMB</span></p>
            <a class="s_button_add_to_cart" href="cart.jsp"><span class="s_icon_16"><span class="s_icon"></span>Add to Cart</span></a>
          </div>
          
          
          <div class="clear"></div>
        </div>
      </div>
      
      <div id="product_tags" class="grid_12 alpha omega">
        <h2 class="s_title_1"><span class="s_main_color">��Ʒ</span> ��ǩ</h2>
        <div class="clear"></div>
        <ul class="clearfix">
          <li><a href="#">Ѹ��</a></li>
          <li><a href="#">Ӣ�ض�</a></li>
          <li><a href="#">VAIO</a></li>
          <li><a href="#">�ʼǱ�����</a></li>
        
        </ul>
      </div>
      
    </div>

    
    <div id="right_col" class="grid_3">
      <div id="cart_side" class="s_box_1 s_cart_holder">
        <h2 class="s_secondary_color">���ﳵ</h2>
        <div id="cart_side_contents">

          <div class="s_cart_item">
            <a id="hremove_95" class="s_button_remove" href="product.jsp">&nbsp;</a>
            <span class="block">1x <a href="product.jsp">Panasonic Lumix</a></span>
          </div>
          <div class="s_cart_item">
            <a id="hremove_31" class="s_button_remove" href="product.jsp">&nbsp;</a>
            <span class="block">1x <a href="product.jsp">����</a></span>
          </div>
          <div class="s_cart_item">
            <a id="hremove_87" class="s_button_remove" href="product.jsp">&nbsp;</a>
            <span class="block">1x <a href="product.jsp">����</a></span>
          </div>
          <span class="clear s_mb_15 border_eee"></span>
          <div class="s_total clearfix"><strong class="cart_module_total left">С��:</strong><span class="cart_module_total">880.00<span class="s_currency s_after"> RMB</span></span></div>
          <div class="s_total clearfix"><strong class="cart_module_total left">����˰ 17.5%:</strong><span class="cart_module_total">154.00<span class="s_currency s_after"> RMB</span></span></div>
          <div class="s_total clearfix"><strong class="cart_module_total left">�ܼ�:</strong><span class="cart_module_total">1,034.00<span class="s_currency s_after"> RMB</span></span></div>
          <span class="clear s_mb_15"></span>
          <div class="align_center clearfix">
            <a class="s_button_1 s_secondary_color_bgr s_ml_0" href="cart.jsp"><span class="s_text">Ԥ�����ﳵ</span></a>
            <a class="s_button_1 s_secondary_color_bgr" href="checkout.jsp"><span class="s_text">����</span></a>
          </div>

        </div>
      </div>
      
      <div id="categories_module" class="s_box">
        <h2>����</h2>
        <div class="s_list_1">
          <ul>
          	<li>
            	<a href="listing_1.jsp"><b>���Ӳ�Ʒ</b></a>
            	<ul>
              	<li><a href="listing_1.jsp">�������</a></li>
                <li><a href="listing_1.jsp">��������</a></li>
                <li><a href="listing_1.jsp">��ͥӰԺ</a></li>
                <li><a href="listing_1.jsp">�ֻ�</a></li>
                <li><a href="listing_1.jsp">MP3</a></li>
                <li><a href="listing_1.jsp">��������</a></li>
              </ul>
            </li>
            <li><a href="listing_1.jsp">����</a></li>
            <li><a href="listing_1.jsp">��ñ</a></li>
            <li><a href="listing_1.jsp">Ь</a></li>
            <li><a href="listing_1.jsp">����</a></li>
            <li><a href="listing_1.jsp">�Ҿ���Ʒ</a></li>
            <li><a href="listing_1.jsp">����</a></li>
            <li><a href="listing_1.jsp">�鱦</a></li>
            <li><a href="listing_1.jsp">��</a></li>
          </ul>
      	</div>
			</div>
      
    	<div id="brands_module" class="s_box">
        <h2>Ʒ��</h2>
        <select onchange="location = this.value">
          <option> --- ��ѡ�� --- </option>
          <option>���ϴ�˹</option>
          <option>ƻ��</option>
          <option>������</option>
          <option>��������</option>
          <option>������</option>
          <option>����</option>
          <option>�ϰ�</option>
          <option>����ɯ���Ŷ�</option>
          <option>����</option>
          <option>HTC</option>
          <option>Hugo Boss</option>
          <option>�Ϳ�</option>
          <option>�῵</option>
          <option>Palm</option>
          <option>����</option>
          <option>��</option>
          <option>����</option>
          <option>����</option>
          <option>ʩ��������</option>
        </select>
      </div>
      
      <div id="bestseller_side" class="s_box clearfix">
        <h2>������Ʒ</h2>
        <div class="s_item s_size_1 clearfix">
          <a class="s_thumb" href="product.jsp"><img src="images/product_38x38.jpg" width="38" height="38" alt="iPhone 3GS 8GB" /></a>
          <h3><a href="product.jsp">iPhone 3GS 8GB</a></h3>
          <p><a href="product.jsp"><span class="s_main_color"><span class="s_currency s_before">�0�5</span>587.50</span></a></p>
        </div>
        
        <div class="s_item s_size_1 clearfix">
          <a class="s_thumb" href="product.jsp"><img src="images/product_38x38.jpg" width="38" height="38" alt="Hubo Boss Emotion" /></a>
          <h3><a href="product.jsp">Hubo Boss Emotion</a></h3>
          <p><a href="product.jsp"><span class="s_main_color"><span class="s_currency s_before">�0�5</span>2,350.00</span></a></p>
        </div>
        
        <div class="s_item s_size_1 clearfix">
          <a class="s_thumb" href="product.jsp"><img src="images/product_38x38.jpg" width="38" height="38" alt="Panasonic Lumix" /></a>
          <h3><a href="product.jsp">Panasonic Lumix</a></h3>
          <p><a href="product.jsp"><span class="s_main_color"><span class="s_currency s_before">�0�5</span>94.00</span></a></p>
        </div>
        
        <div class="s_item s_size_1 clearfix">
          <a class="s_thumb" href="product.jsp"><img src="images/product_38x38.jpg" width="38" height="38" alt="Casio Exilim Zoom" /></a>
          <h3><a href="product.jsp">Casio Exilim Zoom</a></h3>
          <p><a href="product.jsp"><span class="s_main_color"><span class="s_currency s_before">�0�5</span>117.50</span></a></p>
        </div>
  
        <div class="s_item s_size_1 clearfix">
          <a class="s_thumb" href="product.jsp"><img src="images/product_38x38.jpg" width="38" height="38" alt="Christian Dior Amber Woman" /></a>
          <h3><a href="product.jsp">Christian Dior Amber Woman</a></h3>
          <p><a href="product.jsp"><span class="s_main_color"><span class="s_currency s_before">�0�5</span>328.99</span></a></p>
        </div>
  
        <div class="s_item s_size_1 clearfix">
          <a class="s_thumb" href="product.jsp"><img src="images/product_38x38.jpg" width="38" height="38" alt="iPod Classic" /></a>
          <h3><a href="product.jsp">iPod Classic</a></h3>
          <p><a href="product.jsp"><span class="s_main_color"><span class="s_currency s_before">�0�5</span>117.50</span></a></p>
        </div>
        
        <div class="s_item s_size_1 clearfix">
          <a class="s_thumb" href="product.jsp"><img src="images/product_38x38.jpg" width="38" height="38" alt="Sony VAIO" /></a>
          <h3><a href="product.jsp">Sony VAIO</a></h3>
          <p><a href="product.jsp"><span class="s_old"><span class="s_currency s_before">�0�5</span>1,175.00</span> <span class="s_secondary_color"><span class="s_currency s_before">�0�5</span>1,057.50</span></a></p>
          <div class="s_rating_holder clearfix"><p class="s_rating s_rating_small s_rating_5 left"><span style="width: 100%;" class="s_percent"></span></p><span class="left">&nbsp;5/5</span></div>
        </div>
  
        <div class="s_item s_size_1 clearfix">
          <a class="s_thumb" href="product.jsp"><img src="images/product_38x38.jpg" width="38" height="38" alt="Canon Digital Ixus 200 IS" /></a>
          <h3><a href="product.jsp">Canon Digital Ixus 200 IS</a></h3>
          <p><a href="product.jsp"><span class="s_main_color"><span class="s_currency s_before">�0�5</span>117.50</span></a></p>
        </div>
    
        <div class="s_item s_size_1 clearfix">
          <a class="s_thumb" href="product.jsp"><img src="images/product_38x38.jpg" width="38" height="38" alt="Hugo Boss Chrome" /></a>
          <h3><a href="product.jsp">Hugo Boss Chrome</a></h3>
          <p><a href="product.jsp"><span class="s_main_color"><span class="s_currency s_before">�0�5</span>94.00</span></a></p>
        </div>
    
        <div class="s_item s_size_1 clearfix">
          <a class="s_thumb" href="product.jsp"><img src="images/product_38x38.jpg" width="38" height="38" alt="Hennesy Paradis Extra" /></a>
          <h3><a href="product.jsp">Hennesy Paradis Extra</a></h3>
          <p><a href="product.jsp"><span class="s_old"><span class="s_currency s_before">�0�5</span>1,175.00</span> <span class="s_secondary_color"><span class="s_currency s_before">�0�5</span>1,057.50</span></a></p>
        </div>
    
        <div class="s_item s_size_1 clearfix">
          <a class="s_thumb" href="product.jsp"><img src="images/product_38x38.jpg" width="38" height="38" alt="Elizabeth Arden Pretty" /></a>
          <h3><a href="product.jsp">Elizabeth Arden Pretty</a></h3>
          <p><a href="product.jsp"><span class="s_main_color"><span class="s_currency s_before">�0�5</span>94.00</span></a></p>
        </div>
    
        <div class="s_item s_size_1 clearfix">
          <a class="s_thumb" href="product.jsp"><img src="images/product_38x38.jpg" width="38" height="38" alt="Sony Cyber Shot S1000" /></a>
          <h3><a href="product.jsp">Sony Cyber Shot S1000</a></h3>
          <p><a href="product.jsp"><span class="s_main_color"><span class="s_currency s_before">�0�5</span>117.50</span></a></p>
        </div>
      </div>
    
      <div id="information_module" class="s_box">
        <h2>��Ϣ</h2>
        <ul class="s_list_1">
          <li><a href="static.jsp">��������</a></li>
          <li><a href="static.jsp">��˽����</a></li>
          <li><a href="static.jsp">ʹ������ </a></li>
          <li><a href="contacts.jsp">��ϵ����</a></li>
          <li><a href="sitemap.jsp">վ���ͼ</a></li>
        </ul>
      </div>
  
      <div id="featured_side" class="s_box clearfix">
        <h2>�Ƽ�</h2>
        <div class="s_item s_size_1 clearfix">
          <a class="s_thumb" href="product.jsp"><img src="images/product_38x38.jpg" width="38" height="38" alt="White football trainers" /></a>
          <h3><a href="product.jsp">White football trainers</a></h3>
          <p><a href="product.jsp"><span class="s_main_color"><span class="s_currency s_before">�0�5</span>117.50</span></a></p>
        </div>
        <div class="s_item s_size_1 clearfix">
          <a class="s_thumb" href="product.jsp"><img src="images/product_38x38.jpg" width="38" height="38" alt="Hubo Boss Emotion" /></a>
          <h3><a href="product.jsp">Hubo Boss Emotion</a></h3>
          <p><a href="product.jsp"><span class="s_main_color"><span class="s_currency s_before">�0�5</span>2,350.00</span></a></p>
        </div>
        <div class="s_item s_size_1 clearfix">
          <a class="s_thumb" href="product.jsp"><img src="images/product_38x38.jpg" width="38" height="38" alt="Christian Dior J'adore" /></a>
          <h3><a href="product.jsp">Christian Dior J'adore</a></h3>
          <p><a href="product.jsp"><span class="s_main_color"><span class="s_currency s_before">�0�5</span>328.99</span></a></p>
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

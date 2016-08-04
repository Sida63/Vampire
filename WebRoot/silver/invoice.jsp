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
<link rel="stylesheet" type="text/css" href="stylesheet/960.css"
  media="all"
/>
<link rel="stylesheet" type="text/css" href="stylesheet/screen.css"
  media="screen"
/>
<link rel="stylesheet" type="text/css" href="stylesheet/color.css"
  media="screen"
/>
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
          <a href="">中心</a>
          &gt;
          <a href="">静态</a>
        </div>
        <h1>静态页面</h1>
      </div>
    </div>
  </div>
  <!-- end of intro -->

  
  <!-- ********************** --> 
  <!--      C O N T E N T     -->
  <!-- ********************** --> 
  <div id="content" class="container_16">

    <div id="order_details" class="grid_16">

      <div class="s_order clearfix">

        <p class="s_status"><span class="s_999">发票序列号:</span> <span class="s_secondary_color">INV1</span></p>
        <p class="s_id"><span class="s_999">订单序列号</span> <span class="s_main_color">#4</span></p>

        <span class="clear border_eee"></span>
        
        <dl class="grid_5 alpha clearfix">
          <dt>电子邮件</dt>
          <dd>svetoslavatanasov@gmail.com</dd>
          <dt>电话</dt>
          <dd>123123</dd>
          <dt>运送方式</dt>
          <dd>平邮</dd>
          <dt>付款方式</dt>
          <dd>货到付款</dd>
        </dl>
        
        <span class="clear border_eee"></span>

        <div class="grid_7 alpha">
          <h2>付款地址</h2>
          <p>Pinko Pinkov<br />Pinkotown<br />Pinkotown 000000<br />Varna<br />Bulgaria</p>
        </div>
        <div class="grid_7 omega">
          <h2>送货地址</h2>
          <p>Pinko Pinkov<br />Pinkotown<br />Pinkotown 000000<br />Varna<br />Bulgaria</p>
        </div>

        <span class="clear border_eee"></span>

        <h2>货物</h2>
        <table class="s_table" width="100%" cellpadding="0" cellspacing="0" border="0">
          <tr>
            <th>货物</th>
            <th>类型</th>
            <th>数量</th>
            <th>单件价格</th>
            <th width="130">货物总计</th>
          </tr>
          <tr>
            <td class="align_left"><strong>iPhone 3GS 8GB</strong><br /> <small> - Capacity 8GB</small></td>
            <td>Model description</td>
            <td>2</td>
            <td><span class="s_currency s_before">$</span>816.65</td>
            <td><span class="s_currency s_before">$</span>1,633.30</td>
          </tr>
          <tr>
            <td class="align_left"><strong>Nikon D300*</strong></td>
            <td>Product 4</td>
            <td>1</td>
            <td><span class="s_currency s_before">$</span>130.66</td>
            <td><span class="s_currency s_before">$</span>130.66</td>
          </tr>
          <tr>
            <td class="align_left"><strong>Samsung SyncMaster 941BW</strong></td>
            <td>Product 6</td>
            <td>1</td>
            <td><span class="s_currency s_before">$</span>326.66</td>
            <td><span class="s_currency s_before">$</span>326.66</td>
          </tr>
          <tr>
            <td class="align_right" colspan="4"><strong>各类货物总计</strong></td>
            <td><span class="s_currency s_before">$</span>2,090.62</td>
          </tr>
          <tr>
            <td class="align_right" colspan="4"><strong>平邮费用</strong></td>
            <td><span class="s_currency s_before">$</span>3.27</td>
          </tr>
          <tr>
            <td class="align_right" colspan="4"><strong>:</strong></td>
            <td><span class="s_currency s_before">$</span>0.00</td>
          </tr>
          <tr class="last">
            <td class="align_right" colspan="4"><strong>总计支付费用:</strong></td>
            <td class="s_secondary_color"><span class="s_currency s_before">$</span>3,213.08</td>
          </tr>
        </table>


        <h2>订单历史</h2>
        <table class="s_table" width="100%" cellpadding="0" cellspacing="0" border="0">
          <tr>
            <th>下单日期</th>
            <th>订单状态</th>
            <th>评价</th>
          </tr>
          <tr>
            <td>07/04/2011</td>
            <td>取消</td>
            <td></td>
          </tr>
          <tr>
            <td>07/04/2011</td>
            <td>撤销</td>
            <td>Pellentesque et diam at orci convallis ultrices in nec eros! Duis sit amet felis vitae diam vehicula pretium. Morbi pulvinar elit et quam feugiat quis aliquet neque venenatis? Suspendisse nisi arcu; semper eget convallis id, hendrerit eu odio. Nunc leo metus, malesuada nec congue in, rutrum vel risus. Mauris cras amet.</td>
          </tr>
        </table>
        
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
    <%@include file="include/footer.jsp" %>
    <!-- end of FOOTER -->

  </div>

</body>
</html>


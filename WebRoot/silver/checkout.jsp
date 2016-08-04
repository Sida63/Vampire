<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html dir="ltr" >
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=GB18030" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
  <title>Your Store</title>
  <meta name="description" content="My Store" />
  <link rel="stylesheet" type="text/css" href="stylesheet/960.css" media="all" />
  <link rel="stylesheet" type="text/css" href="stylesheet/screen.css" media="screen" />
  <link rel="stylesheet" type="text/css" href="stylesheet/color.css" media="screen" />
  <link rel="stylesheet" type="text/css" href="css/stylesheets.css" />

  <link rel="stylesheet" type="text/css" href="stylesheet/checkout.css" />
  <link rel="stylesheet" type="text/css" href="stylesheet/jquery.cart.css" />
<!--[if lt IE 9]>
<link rel="stylesheet" type="text/css" href="stylesheet/ie.css" media="screen" />
<![endif]-->

<script type="text/javascript" src="js/jquery/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery/jquery-ui.min.js"></script>


<script type='text/javascript' src='js/plugins/jquery/jquery-1.9.1.min.js'></script>
<script type='text/javascript' src='js/plugins/jquery/jquery-ui-1.10.1.custom.min.js'></script>
<script type='text/javascript' src='js/plugins/bootstrap/bootstrap.min.js' ></script>
<script type="text/javascript" src="js/shoppica.js"></script>
<script type='text/javascript' src='js/jquery/cart/jquery.cookie.js'></script>
<script type='text/javascript' src='js/jquery/cart/jquery.cart.js' charset='utf-8'></script>
<script type="text/javascript" src="js/checkout.js"></script>
<script type="text/javascript" src="js/yaes.cart.js"></script>
<script type="text/javascript">
  $(document).ready(function()  {
    if (window.PIE) {
      $('.rounded').each(function() {
        PIE.attach(this);
      });
    }
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
            <a href="">��ҳ</a>
            &gt;
            <a href="">����</a>
          </div>
          <h1>����</h1>
        </div>
      </div>
    </div>
    <!-- end of intro -->

    
    <!-- ********************** --> 
    <!--      C O N T E N T     -->
    <!-- ********************** --> 
    <div id="content" class="container_12">

      <div id="checkout" class="grid_12">
       <div id="checkout_form" class="checkout_form s_accordion">
        <h3 id="step1">��������</h3>       
        <div class="content">
          <div class="row-fluid">
            <div class="span12">
              <div class="block">
                <table class="s_table" width="100%" cellpadding="0" cellspacing="0" border="0">
                  <tr>
                    <th width="60">ͼƬ</th>
                    <th>��Ʒ����</th>
                    <th>����</th>
                    <th>����</th>
                    <th>�ܼ�</th>
                  </tr>
                  <tr class="even">
                    <td valign="middle">
                      <a href="product.jsp">
                        <img src="images/product_140x140.jpg" width="60" height="60" alt="Panasonic Lumix" />
                      </a>
                    </td>
                    <td valign="middle">
                      <a href="product.jsp">
                        <strong>�������� Lumix</strong>
                      </a>
                    </td>
                    <td valign="middle">
                      <span class="pricedisp">94.00</span>
                      <span class="s_currency s_after"> Ԫ</span>
                    </td>
                    <td valign="middle">
                      <span class="countdisp">1</span>
                    </td>
                    <td valign="middle">
                      <span class="pricedisp">94.00</span>
                      <span class="s_currency s_after"> Ԫ</span>
                    </td>
                  </tr>
                </table>
              </div>
            </div>
            <div class="span3">
              <div class="block">
                <strong>�ύ�ܼ�:</strong> 880.00<span class="s_currency s_after"> Ԫ</span>
              </div>
            </div>
            <div class="span3">
              <div class="block">
                <strong>�˷� 17.5%:</strong> 154.00<span class="s_currency s_after"> eur</span>
              </div>
            </div>
            <div class="span3">
              <div class="block">
                <strong>�ܼ�:</strong> 1,034.00<span class="s_currency s_after"> Ԫ</span>
              </div>
            </div>
          </div>
          <div class="clear"></div>
          <a class="s_button_1 s_main_color_bgr tostep2"><span class="s_text">Step 2 &rsaquo;</span></a>
          <span class="clear"></span>
        </div>
        <h3 id="step2">������Ϣ</h3>
        <div class="content">
          <div class="row-fluid ">
            <div class="span12 delivery-lines">
              <div class="block delivery-line template-line">
                <div>
                  <label>
                    <input type="radio" name="delivery_radio" class="delivery_radio"/>
                    <b class="who">�����</b>
                    <span class="where">����ʡ������XXX</span>
                    <span class="tel">18037109005</span>
                  </label>
                  <span class="action"></span>
                </div>
              </div>

              <div class="block new-delivery">                  
                <label >
                  <input type="radio" name="delivery_radio" value="new-delivery-radio" class="delivery_radio new-delivery-radio"/> ʹ���µ�ַ
                </label>
              </div>
              <div class="block">
                <form class="whereform form-horizontal new-delivery-form">
                  <fieldset>
                    <div class="control-group">
                      <label class="control-label">�ջ��ˣ�</label>
                      <div class="controls"><input type="text" name="delivery.name"/></div>
                    </div>
                    <div class="control-group">
                      <label class="control-label">��ϵ�绰��</label>
                      <div class="controls"><input type="text" name="delivery.tel"/></div>
                    </div>
                    <div class="control-group">
                      <label class="control-label">���ڵ�����</label>
                      <div class="controls">
                        <span>
                          <select class="province_switcher">
                            <option>��ѡ��ʡ</option>
                          </select>
                        </span>
                        <span>
                          <select class="city_switcher">
                            <option>��ѡ�����</option>
                          </select>
                        </span>
                        <span>
                          <select class="town_switcher" name="delivery.code">
                            <option>��ѡ����/��</option>
                          </select>
                        </span>
                      </div>
                    </div>
                    <div class="control-group">
                      <label class="control-label">��ϸ��ַ��</label>
                      <div class="controls"><input type="text" name="delivery.addr" class="input-long"/></div>
                    </div>
                  </fieldset>
                  <a class="submitbtn btn">ʹ���µ�ַ</a>
                </form>
              </div>
              <div class="block">
                <h4><span class="s_secondary_color">����</span> ��ע</h4>
                <div class="s_row_3 clearfix">
                  <textarea rows="8" style="width: 99%;" cols="50"></textarea>
                </div>
              </div>
            </div>
          </div>

          <div class="clear"></div>
          <a class="s_button_1 s_ddd_bgr left tostep1"><span class="s_text">&lsaquo; Step 1</span></a>
          <a class="s_button_1 s_main_color_bgr tostep3"><span class="s_text">Step 3 &rsaquo;</span></a>
          <span class="clear"></span>
        </div>
        <h3 id="step3">֧����ʽ</h3>
        <div>
          <p>��ѡ������Ҫ���˵���ʽ.</p>
          <div class="s_row_3 clearfix">
            <label class="s_radio s_shipping_method clearfix" for="item.item">
              <input type="radio" id="item.item" />
              <span class="s_desc"><strong>ÿ����Ʒ</strong><br />ÿ����Ʒ���˷� - 0.00<span class="s_currency s_after"> Ԫ</span></span>
            </label>
            <label class="s_radio s_shipping_method clearfix" for="pickup.pickup">
              <input type="radio" id="pickup.pickup" />
              <span class="s_desc"><strong>����ȡ��</strong><br />���̵�ȡ�� - 0.00<span class="s_currency s_after"> Ԫ</span></span>
            </label>
            <label class="s_radio s_shipping_method clearfix" for="royal_mail.airmail">
              <input type="radio" id="royal_mail.airmail" />
              <span class="s_desc"><strong>˳����</strong><br />˳���� (����: 0.00kg) (Ԥ���ʹ�ʱ��:) - 1.31<span class="s_currency s_after"> Ԫ</span></span>
            </label>
            <label class="s_radio s_shipping_method clearfix" for="royal_mail.international_signed">
              <input type="radio" id="royal_mail.international_signed" />
              <span class="s_desc"><strong>Բͨ���</strong><br />���ʶ��� (����: 0.00kg) (Ԥ���ʹ�ʱ��:) - 4.91<span class="s_currency s_after"> Ԫ</span></span>
            </label>
            <label class="s_radio s_shipping_method clearfix" for="royal_mail.surface">
              <input type="radio" id="royal_mail.surface" />
              <span class="s_desc"><strong>ȫ��ͨ���</strong><br />���� (����: 0.00kg) (Ԥ���ʹ�ʱ��:) - 0.91<span class="s_currency s_after"> Ԫ</span></span>
            </label>
          </div>
          <div class="clear"></div>
          <div class="s_row_3 clearfix">
            <label class="s_checkbox"><input type="checkbox" /> ���Ѿ��Ķ�����ͬ������Щ���� &amp; ����</label>
          </div>
          <div class="clear"></div>
          <a class="s_button_1 s_ddd_bgr left tostep2"><span class="s_text">&lsaquo; Step 2</span></a>
          <a class="s_button_1 s_main_color_bgr tostep4"><span class="s_text">Step 4 &rsaquo;</span></a>
          <span class="clear"></span>
          <br />
        </div>
        <h3 class="s_last" id="step4">ȷ�ϸ���</h3>
        <div class="s_last">
          <p>��ѡ����ʹ�õ�֧����ʽ.</p>
          <div class="s_row_3 clearfix grid_7 alpha">
            <label class="s_radio s_shipping_method clearfix">
              <input type="radio" id="alertpay" checked="checked" />
              <strong>���ÿ� / ��ǿ� (AlertPay)</strong>
            </label>
            <label class="s_radio s_shipping_method clearfix">
              <input type="radio" id="authorizenet_aim" />
              <strong>���ÿ�/ ��ǿ� (Authorize.Net)</strong>
            </label>
            <label class="s_radio s_shipping_method clearfix">
              <input type="radio" id="cod" />
              <strong>��������</strong>
            </label>
          </div>
          <div class="clear"></div>
          <div class="s_row_3 clearfix">
            <label class="s_checkbox"><input type="checkbox" /> ���Ѿ��Ķ���ͬ������������ &amp; ����</label>
          </div>
          <div class="clear"></div>
          <a class="s_button_1 s_ddd_bgr left tostep3"><span class="s_text">&lsaquo; Step 3</span></a>
          <a class="s_button_1 s_main_color_bgr tostepfinish"><span class="s_text">���</span></a>
          <span class="clear"></span>
          <br />
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

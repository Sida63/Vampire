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
  <script type="text/javascript" src="js/md5.js"></script>
  <script type="text/javascript" src="js/login.js"></script>
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
            <a href="index.jsp">��ҳ</a>
          </div>
          <h1>�ҵ��˻�</h1>
        </div>
      </div>
    </div>
    <!-- end of intro -->

    <!-- ********************** --> 
    <!--      C O N T E N T     --> 
    <!-- ********************** --> 
    <div id="content" class="container_16">
      <div class="grid_16">
        <form id="create" class="clearfix" action="RegisterServlet" method="post">
          <h2 class="s_title_1">��ӭ <span class="s_secondary_color">��</span></h2>
          <div class="clear"></div>

          <div class="s_row_2 clearfix">
            <label class="required"><strong>�û���</strong></label>
            <input type="text" size="30" class="usernameinput" name="username" 
            pattern="^[a-zA-Z][a-zA-Z0-9-_\.]{2,20}$"
            title="�û�����������ĸ���ּ��»��ߣ���һλ����Ϊ���֣�3~20λ"
            placeholder="�����û���"/>
          </div>

          <div class="s_row_2 clearfix">
            <label class="required"><strong>����</strong></label>
            <input type="email" size="30" class="emailinput" name="email" required/>
          </div>

          <div class="s_row_2 clearfix">
            <label class="required"><strong>����</strong></label>
            <input type="password" size="30" class="passwordinput" required
            pattern="^\w{6,45}$" title="����6~45λ"/>
            <input type="password" class="passwordhide" name="password" />
          </div>

          <button class="s_button_1 s_main_color_bgr left loginregbtn" type="submit"><span class="s_text">�ύ</span></button>
        </form>
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


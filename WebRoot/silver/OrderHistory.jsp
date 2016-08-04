<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>

<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=gb18030" />
  <title>My Order History</title>
  <meta name="description" content="Yet Another E-Shop" />
  <link rel="stylesheet" type="text/css" href="stylesheet/960.css" media="all" />
  <link rel="stylesheet" type="text/css" href="stylesheet/screen.css" media="screen" />
  <link rel="stylesheet" type="text/css" href="stylesheet/color.css" media="screen" />
  <link rel="stylesheet" type="text/css" href="stylesheet/orderhistory.css" />
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
  <script type="text/javascript" src="js/orderhistory.js"></script>
</head>

<body class="s_layout_fixed">

  <div id="wrapper">
    <!-- ********************** -->String id=request.getParameter("id").toString();
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
    
    <div class="data-fluid">
    
			<table class="table orderpeek" width="100%">
			<thead>
               <tr bgcolor="#def5d0">
                 <th ALIGN=left>
                 <h3>
                 <span class="s_secondary_color">
                 状态</span></h3>
                 </th>
                 <th ALIGN=left>
                 <h3>
                 <span class="s_secondary_color">
                 姓名</span></h3>
                 </th>
                 <th ALIGN=left>
                 <h3>
                 <span class="s_secondary_color">
                 订单号</span></h3>
                 </th>
                 
                 <th ALIGN=left>
                <h3>
                 <span class="s_secondary_color">
                 总价
                 </span></h3>
                 </th>
                 <th ALIGN=left>
                 <h3>
                 <span class="s_secondary_color">
    下单时间            
    </span></h3> 
                 </th>


                 </tr>
         </thead>
         </table>

         <div class="dtable1">
         	<table class="table1 ordertemplate" width="100%">
				<tbody class="tbody1">
					<tr >
						<!-- span 中放标签(状态) -->
						<td width="150px"><span class="orderstatus"></span></td>
						<!-- span前放编号，里面放日期 -->
						<!-- a中放订单内容(部分), span中放用户 -->
						<td width="150px"><span class="orderuser" style="color: #000000;font-size:20px"></span></td>

						<td width="230px"><span class="ordernum" style="color: #000000;font-size:20px"></span>
						</td>
						
						<td width="150px"><span class="amount" style="color: #000000;font-size:20px"></span>
						</td>
						<td ALIGN=left><span class="orderdate" style="color: #000000;font-size:20px"></span></td>
					</tr>
				</tbody>
				<tbody class="tbody2">
						<tr class="detailtemplate">
							<!-- span 中放标签(状态) -->
							<td ALIGN=left><span class="goodsName"></span></td>
							<!-- span前放编号，里面放日期 -->
							<td ALIGN=left><span class="goodsNumber"></span></td>
							<!-- a中放订单内容(部分), span中放用户 -->
							<td ALIGN=left><span class="tags"></span></td>
							<td ALIGN=left><span class="typeName"></span></td>
							<td ALIGN=left><span class="price"></span></td>
						</tr>
					</tbody>
			</table>
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


<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
    <div id="header" class="container_12">
      <div class="grid_12">
        <a id="site_logo" href="index.jsp">Yet Another E-Shop</a>
        <div id="system_navigation" class="s_nav">
          <ul class="s_list_1 clearfix">
            <li><a href="index.jsp">首页</a></li>
            <li><a href="login.jsp">登陆</a></li>
            <li><a href="cart.jsp">购物车</a></li>
            <li><a href="static.jsp">关于我们</a></li>
            <li><a href="contacts.jsp">联系客服</a></li>
          </ul>
        </div>
        
        
        <div id="site_search">
          <a id="show_search" href="javascript:;" title="Search:"></a>
          <div id="search_bar" class="clearfix">
          	<form>
            <input type="text" id="filter_keyword" />
            <select id="filter_category_id">
              <option value="0">全部分类</option>
              <option value="1">分类 1</option>
              <option value="2">分类 2</option>
            </select>
            <input class="s_button_1 s_secondary_color_bgr" type=submit value =Go>      
            <a class="s_advanced s_main_color" href="">Advanced Search</a>
          	</form>
          </div>
        </div>
        
        
        
        <div id="currency_switcher" class="s_switcher">
          <span class="s_selected">人民币</span>
          <ul class="s_options">
            <li><a href="">欧元</a></li>
            <li><a href="">英镑</a></li>
            <li><a href="">美元</a></li>
          </ul>
        </div>
        <div id="language_switcher" class="s_switcher">
          <span class="s_selected"><img src="images/flags/cn.png" alt="Chinese"/> 简体中文</span>
          <ul class="s_options">
            <li><a href=""><img src="images/flags/gb.png" alt="English"/> English</a></li>
            <li><a href=""><img src="images/flags/de.png" alt="Deutsch"/> Deutsch</a></li>
            <li><a href=""><img src="images/flags/cn.png" alt="Chinese" /> 简体中文</a></li>
          </ul>
        </div>
        <div id="categories" class="s_nav">
          <ul>
            <li id="menu_home"><a href="index.jsp">首页</a></li>
            <li><a href="listing_1.jsp">电子产品</a>
              <div class="s_submenu">
                <h3>Inside Electronics</h3>
                <ul class="s_list_1 clearfix">
                  <li><a href="listing_1.jsp">数码相机</a>
                    <ul class="s_list_1 clearfix">
                      <li><a href="listing_1.jsp">卡片机</a></li>
                      <li><a href="listing_1.jsp">单反相机</a></li>
                    </ul>
                  </li>
                  <li><a href="listing_1.jsp">家用音响</a></li>
                  <li><a href="listing_1.jsp">家庭影院</a></li>
                  <li><a href="listing_1.jsp">手机</a></li>
                  <li><a href="listing_1.jsp">MP3/MP4</a></li>
                  <li><a href="listing_1.jsp">汽车音响</a></li>
                </ul>
                <span class="clear border_eee"></span>
                <h3>推荐品牌</h3>
                <ul class="s_list_1 clearfix">
                  <li><a href="listing_1.jsp">Canon</a></li>
                  <li><a href="listing_1.jsp">Hugo Boss</a></li>
                  <li><a href="listing_1.jsp">Panasonic</a></li>
                  <li><a href="listing_1.jsp">Samsung</a></li>
                  <li><a href="listing_1.jsp">Sony</a></li>
                </ul>
              </div>
            </li>
            <li><a href="listing_1.jsp">电脑</a>
              <div class="s_submenu">
                <h3>Inside Computers</h3>
                <ul class="s_list_1 clearfix">
                  <li><a href="listing_1.jsp">台式机</a></li>
                  <li><a href="listing_1.jsp">笔记本电脑</a></li>
                  <li><a href="listing_1.jsp">显示器</a></li>
                  <li><a href="listing_1.jsp">DIY配件</a></li>
                  <li><a href="listing_1.jsp">软件</a></li>
                </ul>
                <span class="clear border_eee"></span>
                <h3>推荐品牌</h3>
                <ul class="s_list_1 clearfix">
                  <li><a href="listing_1.jsp">Hugo Boss</a></li>
                  <li><a href="listing_1.jsp">Sony</a></li>
                </ul>
              </div>
            </li>
            <li><a href="listing_1.jsp">服装</a>
              <div class="s_submenu">
                <h3>Inside Clothing</h3>
                <ul class="s_list_1 clearfix">
                  <li><a href="listing_1.jsp">女装</a></li>
                  <li><a href="listing_1.jsp">男装</a></li>
                  <li><a href="listing_1.jsp">男童</a></li>
                  <li><a href="listing_1.jsp">女童</a></li>
                  <li><a href="listing_1.jsp">婴儿装</a></li>
                </ul>
                <span class="clear border_eee"></span>
                <h3>推荐品牌</h3>
                <ul class="s_list_1 clearfix">
                  <li><a href="listing_1.jsp">Bvlgari</a></li>
                  <li><a href="listing_1.jsp">Elisabeth Arden</a></li>
                </ul>
              </div>
            </li>
            <li><a href="listing_1.jsp">鞋类</a>
              <div class="s_submenu">
                <h3>Inside Shoes</h3>
                <ul class="s_list_1 clearfix">
                  <li><a href="listing_1.jsp">女鞋</a></li>
                  <li><a href="listing_1.jsp">男鞋</a></li>
                  <li><a href="listing_1.jsp">童鞋</a></li>
                  <li><a href="listing_1.jsp">运动系列</a></li>
                </ul>
                <span class="clear border_eee"></span>
                <h3>推荐品牌</h3>
                <ul class="s_list_1 clearfix">
                  <li><a href="listing_1.jsp">Adidas</a></li>
                  <li><a href="listing_1.jsp">Apple</a></li>
                  <li><a href="listing_1.jsp">Armani</a></li>
                  <li><a href="listing_1.jsp">Balenciaga</a></li>
                  <li><a href="listing_1.jsp">Christian Dior</a></li>
                  <li><a href="listing_1.jsp">Nike</a></li>
                  <li><a href="listing_1.jsp">Samsung</a></li>
                  <li><a href="listing_1.jsp">Sony</a></li>
                </ul>
              </div>
            </li>
            <li><a href="listing_1.jsp">礼物</a>
              <div class="s_submenu">
                <h3>Inside Gifts</h3>
                <ul class="s_list_1 clearfix">
                  <li><a href="listing_1.jsp">香水</a></li>
                  <li><a href="listing_1.jsp">啤酒</a></li>
                  <li><a href="listing_1.jsp">红酒</a></li>
                  <li><a href="listing_1.jsp">鲜花</a></li>
                  <li><a href="listing_1.jsp">巧克力甜点</a></li>
                  <li><a href="listing_1.jsp">玩具</a></li>
                  <li><a href="listing_1.jsp">宠物</a></li>
                </ul>
                <span class="clear border_eee"></span>
                <h3>推荐品牌</h3>
                <ul class="s_list_1 clearfix">
                  <li><a href="listing_1.jsp">Adidas</a></li>
                  <li><a href="listing_1.jsp">Armani</a></li>
                  <li><a href="listing_1.jsp">Balenciaga</a></li>
                  <li><a href="listing_1.jsp">Bvlgari</a></li>
                  <li><a href="listing_1.jsp">Canon</a></li>
                  <li><a href="listing_1.jsp">Christian Dior</a></li>
                  <li><a href="listing_1.jsp">Elisabeth Arden</a></li>
                  <li><a href="listing_1.jsp">Hugo Boss</a></li>
                  <li><a href="listing_1.jsp">Sony</a></li>
                </ul>
              </div>
            </li>
            <li><a href="listing_1.jsp">家居</a>
              <div class="s_submenu">
                <h3>Inside At home</h3>
                <ul class="s_list_1 clearfix">
                  <li><a href="listing_1.jsp">家具</a></li>
                  <li><a href="listing_1.jsp">园艺</a></li>
                  <li><a href="listing_1.jsp">家电</a></li>
                  <li><a href="listing_1.jsp">宠物用品</a></li>
                  <li><a href="listing_1.jsp">工具</a></li>
                  <li><a href="listing_1.jsp">灯具</a></li>
                  <li><a href="listing_1.jsp">餐具水具</a></li>
                </ul>
              </div>
            </li>
            <li><a href="listing_1.jsp">健康</a>
              <div class="s_submenu">
                <h3>Inside Health</h3>
                <ul class="s_list_1 clearfix">
                  <li><a href="listing_1.jsp">保健品</a></li>
                  <li><a href="listing_1.jsp">化妆品</a></li>
                  <li><a href="listing_1.jsp">个人护理</a></li>
                </ul>
              </div>
            </li>
            <li><a href="listing_1.jsp">珠宝</a>
              <div class="s_submenu">
                <h3>Inside Jewellery</h3>
                <ul class="s_list_1 clearfix">
                  <li><a href="listing_1.jsp">项链</a></li>
                  <li><a href="listing_1.jsp">戒指</a></li>
                  <li><a href="listing_1.jsp">手链</a></li>
                  <li><a href="listing_1.jsp">耳环</a></li>
                  <li><a href="listing_1.jsp">吊坠</a></li>
                </ul>
              </div>
            </li>
            <li><a href="listing_1.jsp">书籍</a>
              <div class="s_submenu">
                <h3>Inside Books</h3>
                <ul class="s_list_1 clearfix">
                  <li><a href="listing_1.jsp">童话</a></li>
                  <li><a href="listing_1.jsp">言情</a></li>
                  <li><a href="listing_1.jsp">科幻</a></li>
                  <li><a href="listing_1.jsp">教育</a></li>
                </ul>
              </div>
            </li>
          </ul>
        </div>
        <div class="yaes_cart">
        </div>
      </div>
    </div>
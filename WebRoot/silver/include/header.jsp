<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
    <div id="header" class="container_12">
      <div class="grid_12">
        <a id="site_logo" href="index.jsp">Yet Another E-Shop</a>
        <div id="system_navigation" class="s_nav">
          <ul class="s_list_1 clearfix">
            <li><a href="index.jsp">��ҳ</a></li>
            <li><a href="login.jsp">��½</a></li>
            <li><a href="cart.jsp">���ﳵ</a></li>
            <li><a href="static.jsp">��������</a></li>
            <li><a href="contacts.jsp">��ϵ�ͷ�</a></li>
          </ul>
        </div>
        
        
        <div id="site_search">
          <a id="show_search" href="javascript:;" title="Search:"></a>
          <div id="search_bar" class="clearfix">
          	<form>
            <input type="text" id="filter_keyword" />
            <select id="filter_category_id">
              <option value="0">ȫ������</option>
              <option value="1">���� 1</option>
              <option value="2">���� 2</option>
            </select>
            <input class="s_button_1 s_secondary_color_bgr" type=submit value =Go>      
            <a class="s_advanced s_main_color" href="">Advanced Search</a>
          	</form>
          </div>
        </div>
        
        
        
        <div id="currency_switcher" class="s_switcher">
          <span class="s_selected">�����</span>
          <ul class="s_options">
            <li><a href="">ŷԪ</a></li>
            <li><a href="">Ӣ��</a></li>
            <li><a href="">��Ԫ</a></li>
          </ul>
        </div>
        <div id="language_switcher" class="s_switcher">
          <span class="s_selected"><img src="images/flags/cn.png" alt="Chinese"/> ��������</span>
          <ul class="s_options">
            <li><a href=""><img src="images/flags/gb.png" alt="English"/> English</a></li>
            <li><a href=""><img src="images/flags/de.png" alt="Deutsch"/> Deutsch</a></li>
            <li><a href=""><img src="images/flags/cn.png" alt="Chinese" /> ��������</a></li>
          </ul>
        </div>
        <div id="categories" class="s_nav">
          <ul>
            <li id="menu_home"><a href="index.jsp">��ҳ</a></li>
            <li><a href="listing_1.jsp">���Ӳ�Ʒ</a>
              <div class="s_submenu">
                <h3>Inside Electronics</h3>
                <ul class="s_list_1 clearfix">
                  <li><a href="listing_1.jsp">�������</a>
                    <ul class="s_list_1 clearfix">
                      <li><a href="listing_1.jsp">��Ƭ��</a></li>
                      <li><a href="listing_1.jsp">�������</a></li>
                    </ul>
                  </li>
                  <li><a href="listing_1.jsp">��������</a></li>
                  <li><a href="listing_1.jsp">��ͥӰԺ</a></li>
                  <li><a href="listing_1.jsp">�ֻ�</a></li>
                  <li><a href="listing_1.jsp">MP3/MP4</a></li>
                  <li><a href="listing_1.jsp">��������</a></li>
                </ul>
                <span class="clear border_eee"></span>
                <h3>�Ƽ�Ʒ��</h3>
                <ul class="s_list_1 clearfix">
                  <li><a href="listing_1.jsp">Canon</a></li>
                  <li><a href="listing_1.jsp">Hugo Boss</a></li>
                  <li><a href="listing_1.jsp">Panasonic</a></li>
                  <li><a href="listing_1.jsp">Samsung</a></li>
                  <li><a href="listing_1.jsp">Sony</a></li>
                </ul>
              </div>
            </li>
            <li><a href="listing_1.jsp">����</a>
              <div class="s_submenu">
                <h3>Inside Computers</h3>
                <ul class="s_list_1 clearfix">
                  <li><a href="listing_1.jsp">̨ʽ��</a></li>
                  <li><a href="listing_1.jsp">�ʼǱ�����</a></li>
                  <li><a href="listing_1.jsp">��ʾ��</a></li>
                  <li><a href="listing_1.jsp">DIY���</a></li>
                  <li><a href="listing_1.jsp">���</a></li>
                </ul>
                <span class="clear border_eee"></span>
                <h3>�Ƽ�Ʒ��</h3>
                <ul class="s_list_1 clearfix">
                  <li><a href="listing_1.jsp">Hugo Boss</a></li>
                  <li><a href="listing_1.jsp">Sony</a></li>
                </ul>
              </div>
            </li>
            <li><a href="listing_1.jsp">��װ</a>
              <div class="s_submenu">
                <h3>Inside Clothing</h3>
                <ul class="s_list_1 clearfix">
                  <li><a href="listing_1.jsp">Ůװ</a></li>
                  <li><a href="listing_1.jsp">��װ</a></li>
                  <li><a href="listing_1.jsp">��ͯ</a></li>
                  <li><a href="listing_1.jsp">Ůͯ</a></li>
                  <li><a href="listing_1.jsp">Ӥ��װ</a></li>
                </ul>
                <span class="clear border_eee"></span>
                <h3>�Ƽ�Ʒ��</h3>
                <ul class="s_list_1 clearfix">
                  <li><a href="listing_1.jsp">Bvlgari</a></li>
                  <li><a href="listing_1.jsp">Elisabeth Arden</a></li>
                </ul>
              </div>
            </li>
            <li><a href="listing_1.jsp">Ь��</a>
              <div class="s_submenu">
                <h3>Inside Shoes</h3>
                <ul class="s_list_1 clearfix">
                  <li><a href="listing_1.jsp">ŮЬ</a></li>
                  <li><a href="listing_1.jsp">��Ь</a></li>
                  <li><a href="listing_1.jsp">ͯЬ</a></li>
                  <li><a href="listing_1.jsp">�˶�ϵ��</a></li>
                </ul>
                <span class="clear border_eee"></span>
                <h3>�Ƽ�Ʒ��</h3>
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
            <li><a href="listing_1.jsp">����</a>
              <div class="s_submenu">
                <h3>Inside Gifts</h3>
                <ul class="s_list_1 clearfix">
                  <li><a href="listing_1.jsp">��ˮ</a></li>
                  <li><a href="listing_1.jsp">ơ��</a></li>
                  <li><a href="listing_1.jsp">���</a></li>
                  <li><a href="listing_1.jsp">�ʻ�</a></li>
                  <li><a href="listing_1.jsp">�ɿ������</a></li>
                  <li><a href="listing_1.jsp">���</a></li>
                  <li><a href="listing_1.jsp">����</a></li>
                </ul>
                <span class="clear border_eee"></span>
                <h3>�Ƽ�Ʒ��</h3>
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
            <li><a href="listing_1.jsp">�Ҿ�</a>
              <div class="s_submenu">
                <h3>Inside At home</h3>
                <ul class="s_list_1 clearfix">
                  <li><a href="listing_1.jsp">�Ҿ�</a></li>
                  <li><a href="listing_1.jsp">԰��</a></li>
                  <li><a href="listing_1.jsp">�ҵ�</a></li>
                  <li><a href="listing_1.jsp">������Ʒ</a></li>
                  <li><a href="listing_1.jsp">����</a></li>
                  <li><a href="listing_1.jsp">�ƾ�</a></li>
                  <li><a href="listing_1.jsp">�;�ˮ��</a></li>
                </ul>
              </div>
            </li>
            <li><a href="listing_1.jsp">����</a>
              <div class="s_submenu">
                <h3>Inside Health</h3>
                <ul class="s_list_1 clearfix">
                  <li><a href="listing_1.jsp">����Ʒ</a></li>
                  <li><a href="listing_1.jsp">��ױƷ</a></li>
                  <li><a href="listing_1.jsp">���˻���</a></li>
                </ul>
              </div>
            </li>
            <li><a href="listing_1.jsp">�鱦</a>
              <div class="s_submenu">
                <h3>Inside Jewellery</h3>
                <ul class="s_list_1 clearfix">
                  <li><a href="listing_1.jsp">����</a></li>
                  <li><a href="listing_1.jsp">��ָ</a></li>
                  <li><a href="listing_1.jsp">����</a></li>
                  <li><a href="listing_1.jsp">����</a></li>
                  <li><a href="listing_1.jsp">��׹</a></li>
                </ul>
              </div>
            </li>
            <li><a href="listing_1.jsp">�鼮</a>
              <div class="s_submenu">
                <h3>Inside Books</h3>
                <ul class="s_list_1 clearfix">
                  <li><a href="listing_1.jsp">ͯ��</a></li>
                  <li><a href="listing_1.jsp">����</a></li>
                  <li><a href="listing_1.jsp">�ƻ�</a></li>
                  <li><a href="listing_1.jsp">����</a></li>
                </ul>
              </div>
            </li>
          </ul>
        </div>
        <div class="yaes_cart">
        </div>
      </div>
    </div>
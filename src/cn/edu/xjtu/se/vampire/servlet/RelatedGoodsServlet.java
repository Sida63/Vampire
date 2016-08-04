
package cn.edu.xjtu.se.vampire.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.xjtu.se.vampire.hibernate.dao.GoodsDAO;
import cn.edu.xjtu.se.vampire.hibernate.entity.Goods;
import cn.edu.xjtu.se.vampire.util.Utilities;

public class RelatedGoodsServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -80831353109271010L;

	/**
	 * Constructor of the object.
	 */
	public RelatedGoodsServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("application/json");
		response.setCharacterEncoding("GB18030");
		
		// if this is a valid url
//		String url = request.getRequestURI();
//		
//		System.out.println(url);
//		
//		Pattern ptn = Pattern.compile(".*/goods(/(\\d*)((?<=\\d)/)?)?$/brief");
//		Matcher matcher = ptn.matcher(url);
//		if(!matcher.matches()) {
//			response.sendError(400);
//			return;
//		}
//		
//		int goodsid = Utilities.parseId(matcher.group(2));
		int goodsid=21;

		StringBuilder sb = new StringBuilder();
		GoodsDAO goodsdao = new GoodsDAO();
		if(goodsid != -1) { // for detail delivery info			
			Goods good=goodsdao.findById(goodsid);
			if(good == null) {
				response.sendError(404);
				return;
			}
			Goods example=new Goods();
			example.setType(good.getType());
			List<Goods> goods=goodsdao.findByExample(example);
			List<Goods> goodss=new ArrayList<>();
			
			Iterator<Goods> it=goods.iterator();
			Goods goods1=null;
			int i=0;
			while(it.hasNext()&&i<4){
				
				goods1=(Goods) it.next();
				goodss.add((Goods)goods1.clone());	
				i++;
			}
			
		
			sb.append(Utilities.toJSONStringFiltered(goodss));
		}
			PrintWriter out = response.getWriter();
		
			out.print(sb.toString());
			out.flush();
			out.close();
		

	
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}

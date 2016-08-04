package cn.edu.xjtu.se.vampire.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import cn.edu.xjtu.se.vampire.hibernate.dao.GoodsDAO;
import cn.edu.xjtu.se.vampire.hibernate.entity.Goods;
import cn.edu.xjtu.se.vampire.hibernate.entity.GoodsDetail;

public class HotGoodsServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("����init()�������������г�ʼ������");
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("application/json");
		response.setCharacterEncoding("GB18030");
		String url = request.getRequestURI();		
		System.out.println(url);
		GoodsDAO tgd=new GoodsDAO();
		List<GoodsDetail> goods=tgd.selectHotest("order by sales desc ");
		List<Goods> goodss=new ArrayList<>();
		
		Iterator it=goods.iterator();
		GoodsDetail goodsdetail=null;
		Goods goodstemp=null;
		while(it.hasNext()){
			goodsdetail=(GoodsDetail) it.next();
			goodstemp=(Goods) goodsdetail.getGoods().clone();
			goodss.add(goodstemp);			
		}
		String JSONString=JSON.toJSONString(goodss, true);
		PrintWriter out = response.getWriter();
		out.print(JSONString);
		out.flush();
		out.close();
		

		
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		System.out.println("����destroy()������������������ʵ���Ĺ���");
	}



}

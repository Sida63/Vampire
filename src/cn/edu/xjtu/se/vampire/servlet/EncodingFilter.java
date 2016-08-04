package cn.edu.xjtu.se.vampire.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class EncodingFilter implements Filter {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		if (req.getHeader("X-Requested-With") != null
				&& req.getHeader("X-Requested-With").equalsIgnoreCase("XMLHttpRequest")) {
			request.setCharacterEncoding("utf-8");
		} else {
			request.setCharacterEncoding("gb18030");
		}
		response.setCharacterEncoding("gb18030");
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

	public EncodingFilter() {
		super();
	}
}

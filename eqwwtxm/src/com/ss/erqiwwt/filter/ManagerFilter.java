package com.ss.erqiwwt.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ManagerFilter implements Filter {
	private String errorPage="back/login.html";
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest) request;
		HttpServletResponse resp=(HttpServletResponse) response;
		
		HttpSession session=req.getSession();
		
		if(session.getAttribute("currentLoginAdmin")==null){  //说明没有登录
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out=resp.getWriter();
			String basePath=req.getScheme()+"://"+req.getServerName()+":"+req.getServerPort()+req.getContextPath()+"/";
			out.println("<script>alert('请先登录...');location.href='"+basePath+errorPage+"'</script>");
			out.flush();
			out.close();
		}else{  //如果已经登录，则将请求交给下一个过滤器
			chain.doFilter(request, response);
		}		
	}
	
	public void init(FilterConfig fConfig) throws ServletException {
		String temp=fConfig.getInitParameter("errorPage");
		if(temp!=null){
			errorPage=temp;
		}
	}
	public void destroy() {
	}

}

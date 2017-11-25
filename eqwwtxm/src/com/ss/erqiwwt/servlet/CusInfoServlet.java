package com.ss.erqiwwt.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ss.erqiwwt.biz.ICusInfoBiz;
import com.ss.erqiwwt.biz.IStoreBiz;
import com.ss.erqiwwt.biz.impl.CusInfoBizImpl;
import com.ss.erqiwwt.biz.impl.StoreBizImpl;
import com.ss.erqiwwt.util.StringUtil;

@WebServlet("/cusInfoServlet")
public class CusInfoServlet extends BasicServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op=request.getParameter("op");
		
		/*if("checkusername".equals(op)){
			checkusername(request,response);
		} else if("checkemail".equals(op)){
			checkemail(request,response);
		}*/
		if("findByPage".equals(op)){
			findByPage(request,response);
		}else if("findBy".equals(op)){
			findBy(request,response);
		}else if("changeStatus".equals(op)){
			changeStatus(request,response);
		}
	}

	/**
	 * 修改状态
	 * @param request
	 * @param response
	 */
	private void changeStatus(HttpServletRequest request, HttpServletResponse response) {
		ICusInfoBiz cusInfoBiz=new CusInfoBizImpl();
		String pwd=request.getParameter("usid");
		String status=request.getParameter("status");
		this.out(response,cusInfoBiz.update(pwd, status));
	}
	
	private void findBy(HttpServletRequest request, HttpServletResponse response) {
		Integer pageNo=Integer.parseInt(request.getParameter("page"));
		Integer pageSize=Integer.parseInt(request.getParameter("rows"));
		String usid=request.getParameter("usid");
		String uname=request.getParameter("uname");
		String email=request.getParameter("email");
		String prov=request.getParameter("prov");
		String city=request.getParameter("city");
		String area=request.getParameter("area");
		Map<String,String> map=new HashMap<String,String>();

		
		if(!StringUtil.isNull(uname)){
			map.put("uname like","%"+uname+"%");
		}
		
		if(!StringUtil.isNull(prov)){
			map.put(" pro = ",prov);
		}
		
		if(!StringUtil.isNull(city)){
			map.put(" city = ",city);
		}
		
		if(!StringUtil.isNull(area)){
			map.put(" area = ",area);
		}
		
		ICusInfoBiz cusInfoBiz=new CusInfoBizImpl();
		//System.out.println(":"+cusInfoBiz.find(map, pageNo, pageSize));
		this.out(response,cusInfoBiz.find(map, pageNo, pageSize));
	}

	private void findByPage(HttpServletRequest request, HttpServletResponse response) {
		Integer pageNo=Integer.parseInt(request.getParameter("page"));
		Integer pageSize=Integer.parseInt(request.getParameter("rows"));
		ICusInfoBiz cusInfoBiz=new CusInfoBizImpl();
		this.out(response,cusInfoBiz.findCus(pageNo, pageSize));
		
	}

	/**
	 * 检验邮箱是否存在
	 * @param request
	 * @param response
	 *//*
	private void checkemail(HttpServletRequest request, HttpServletResponse response) {
		String email=request.getParameter("myEmail");
		ICusInfoBiz cusInfoBiz=new CusInfoBizImpl();
		int x=cusInfoBiz.findEmail(email);
		int result;
		if(x<=0){
			result=0;
		}else{
			result=1;
		}	
		this.out(response, result);
	}

	*//**
	 * 检验用户名是否存在
	 * @param request
	 * @param response
	 *//*
	private void checkusername(HttpServletRequest request, HttpServletResponse response) {
		String uname=request.getParameter("username");
		ICusInfoBiz cusInfoBiz=new CusInfoBizImpl();
		int x=cusInfoBiz.findUsername(uname);
		int result;
		if(x<=0){
			result=0;
		}else{
			result=1;
		}	
		this.out(response, result);
	}*/
}

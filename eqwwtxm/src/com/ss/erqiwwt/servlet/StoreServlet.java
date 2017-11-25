package com.ss.erqiwwt.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspFactory;
import javax.servlet.jsp.PageContext;

import com.ss.erqiwwt.bean.Store;
import com.ss.erqiwwt.biz.IStoreBiz;
import com.ss.erqiwwt.biz.impl.StoreBizImpl;
import com.ss.erqiwwt.util.FileUpload;
import com.ss.erqiwwt.util.StringUtil;

@WebServlet("/storeServlet")
public class StoreServlet extends BasicServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op=request.getParameter("op");
		
		if("addStore".equals(op)){
			addStore(request,response);
		}else if("findByPage".equals(op)){
			findByPage(request,response);
		}else if("changeStatus".equals(op)){
			changeStatus(request,response);
		}else if("findBy".equals(op)){
			findBy(request,response);
		}else if("login".equals(op)){
			login(request,response);
		}
	}

	private void login(HttpServletRequest request, HttpServletResponse response) {
		String sid=request.getParameter("sid");
		String pwd=request.getParameter("pwd");
		
		int result=-1;
		IStoreBiz storeBiz=new StoreBizImpl();
		Store store=storeBiz.login(sid, pwd);
		if(store==null){
			result=2;
		}else{
			//将当前登录用户存到session，以便于其他页面获取
			request.getSession().setAttribute("currentLoginStore", store);
			result=3;  //说明成功
		}
		
		this.out(response,result);
	}

	private void findBy(HttpServletRequest request, HttpServletResponse response) {
		Integer pageNo=Integer.parseInt(request.getParameter("page"));
		Integer pageSize=Integer.parseInt(request.getParameter("rows"));
		String stid=request.getParameter("stid");
		String sname=request.getParameter("sname");
		String prov=request.getParameter("prov");
		String city=request.getParameter("city");
		String area=request.getParameter("area");
		Map<String,String> map=new HashMap<String,String>();
		if(!StringUtil.isNull(stid)){
			map.put("stid=",stid);
		}
		
		if(!StringUtil.isNull(sname)){
			map.put("sname like","%"+sname+"%");
		}
		
		if(!StringUtil.isNull(prov)){
			map.put("pro=",prov);
		}
		
		if(!StringUtil.isNull(city)){
			map.put("city=",city);
		}
		
		if(!StringUtil.isNull(area)){
			map.put("area=",area);
		}
		
		IStoreBiz storeBiz=new StoreBizImpl();
		this.out(response,storeBiz.find(map, pageNo, pageSize));
	}

	private void changeStatus(HttpServletRequest request, HttpServletResponse response) {
		IStoreBiz storeBiz=new StoreBizImpl();
		String sid=request.getParameter("sid");
		String status=request.getParameter("status");
		String reason=request.getParameter("reason");
		this.out(response,storeBiz.update(sid, status, reason));
	}

	private void findByPage(HttpServletRequest request, HttpServletResponse response) {
		Integer pageNo=Integer.parseInt(request.getParameter("page"));
		Integer pageSize=Integer.parseInt(request.getParameter("rows"));
		IStoreBiz storeBiz=new StoreBizImpl();
		this.out(response,storeBiz.findByPage(pageNo, pageSize));
	}

	private void addStore(HttpServletRequest request, HttpServletResponse response) {
		FileUpload fileUpload=new FileUpload();
		PageContext pageContext=JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true, 1024, true);
		Store store=fileUpload.upload(pageContext,Store.class);
		IStoreBiz storeBiz=new StoreBizImpl();
		this.out(response,storeBiz.add(store));
	}

}

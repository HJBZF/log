package com.ss.erqiwwt.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ss.erqiwwt.biz.IStoreTypeBiz;
import com.ss.erqiwwt.biz.impl.StoreTypeBizImpl;

@WebServlet("/storeTypeServlet")
public class StoreTypeServlet extends BasicServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op=request.getParameter("op");
		
		if("findByPage".equals(op)){
			findByPage(request,response);
		} else if("addStoreType".equals(op)){
			addStoreType(request,response);
		} else if("deleteStoreType".equals(op)){
			deleteStoreType(request,response);
		} else if("editStoreType".equals(op)){
			editStoreType(request,response);
		} else if("find".equals(op)){
			find(request,response);
		}
	}

	private void find(HttpServletRequest request, HttpServletResponse response) {
		IStoreTypeBiz storeTypeBiz=new StoreTypeBizImpl();
		this.out(response, storeTypeBiz.find());
	}

	/**
	 * 修改店铺类型信息
	 * @param request
	 * @param response
	 */
	private void editStoreType(HttpServletRequest request, HttpServletResponse response) {
		IStoreTypeBiz storeTypeBiz=new StoreTypeBizImpl();
		String stid=request.getParameter("stid");
		String stname=request.getParameter("stname");
		String discr=request.getParameter("discr");
		
		this.out(response, storeTypeBiz.updateStoreType(stid, stname, discr));
	}

	/**
	 * 删除店铺类型信息
	 * @param request
	 * @param response
	 */
	private void deleteStoreType(HttpServletRequest request, HttpServletResponse response) {
		IStoreTypeBiz storeTypeBiz=new StoreTypeBizImpl();
		String stids=request.getParameter("stids");
		this.out(response, storeTypeBiz.deleteStoreType(stids));
	}

	/**
	 * 添加店铺类型信息
	 * @param request
	 * @param response
	 */
	private void addStoreType(HttpServletRequest request, HttpServletResponse response) {
		IStoreTypeBiz storeTypeBiz=new StoreTypeBizImpl();
		String stname=request.getParameter("stname");
		String discr=request.getParameter("discr");
		
		this.out(response, storeTypeBiz.addStoreType(stname, discr));
	}

	/**
	 * 分页查询
	 * @param request
	 * @param response
	 */
	private void findByPage(HttpServletRequest request, HttpServletResponse response) {
		IStoreTypeBiz storeTypeBiz=new StoreTypeBizImpl();
		Integer pageNo=Integer.parseInt(request.getParameter("page"));
		Integer pageSize=Integer.parseInt(request.getParameter("rows"));
		
		this.out(response, storeTypeBiz.findStoreType(pageNo, pageSize));
	}

}

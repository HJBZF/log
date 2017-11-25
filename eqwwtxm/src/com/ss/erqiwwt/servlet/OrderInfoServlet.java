package com.ss.erqiwwt.servlet;



import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ss.erqiwwt.bean.CusInfo;
import com.ss.erqiwwt.bean.Store;
import com.ss.erqiwwt.bean.StoreGoods;
import com.ss.erqiwwt.biz.IAdminBiz;
import com.ss.erqiwwt.biz.ICusInfoBiz;
import com.ss.erqiwwt.biz.IOrderInfoBiz;
import com.ss.erqiwwt.biz.impl.AdminBizImpl;
import com.ss.erqiwwt.biz.impl.CusInfoBizImpl;
import com.ss.erqiwwt.biz.impl.OrderInfoBizImpl;

@WebServlet("/orderInfoServlet")
public class OrderInfoServlet extends BasicServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op=request.getParameter("op");
		
		if("findByPage".equals(op)){
			findByPage(request,response);
		}else if("changeStatus".equals(op)){
			changeStatus(request,response);
		} else if("deleteOrder".equals(op)){
			deleteOrder(request,response);
		}
	}

	private void deleteOrder(HttpServletRequest request, HttpServletResponse response) {
		IOrderInfoBiz goodsBiz=new OrderInfoBizImpl();
		String oid=request.getParameter("oid");
		this.out(response, goodsBiz.deleteOrder(oid));
	}

	private void changeStatus(HttpServletRequest request, HttpServletResponse response) {
		IOrderInfoBiz goodsBiz=new OrderInfoBizImpl();
		String oid=request.getParameter("oid");
		String status=request.getParameter("status");
		this.out(response,goodsBiz.update(oid, status));
	}

	private void findByPage(HttpServletRequest request, HttpServletResponse response) {
		Integer pageNo=Integer.parseInt(request.getParameter("page"));
		Integer pageSize=Integer.parseInt(request.getParameter("rows"));
		
		
		IOrderInfoBiz goodsBiz=new OrderInfoBizImpl();
		this.out(response,goodsBiz.findPage(pageNo, pageSize));
		
		
	}

}

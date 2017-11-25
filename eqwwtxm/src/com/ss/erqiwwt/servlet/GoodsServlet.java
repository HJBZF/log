package com.ss.erqiwwt.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspFactory;
import javax.servlet.jsp.PageContext;

import com.ss.erqiwwt.bean.Store;
import com.ss.erqiwwt.bean.StoreGoods;
import com.ss.erqiwwt.biz.IAdminBiz;
import com.ss.erqiwwt.biz.ICusInfoBiz;
import com.ss.erqiwwt.biz.IGoodsBiz;
import com.ss.erqiwwt.biz.impl.AdminBizImpl;
import com.ss.erqiwwt.biz.impl.CusInfoBizImpl;
import com.ss.erqiwwt.biz.impl.GoodsBizImpl;
import com.ss.erqiwwt.util.FileUpload;

@WebServlet("/goodsServlet")
public class GoodsServlet extends BasicServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op=request.getParameter("op");
		
		if("findByPage".equals(op)){
			findByPage(request,response);
		}else if("addGoods".equals(op)){
			addGoods(request,response);
		}else if("deleteGoods".equals(op)){
			deleteGoods(request,response);
		}else if("changeStatus".equals(op)){
			changeStatus(request,response);
		}else if("findGood".equals(op)){
			findGood(request,response);
		}else if("findGod".equals(op)){
			findGod(request,response);
		}
	}

	private void findGod(HttpServletRequest request, HttpServletResponse response) {
		IGoodsBiz goodsBiz = new GoodsBizImpl();
		this.out(response, goodsBiz.findGod());
	}

	private void findGood(HttpServletRequest request, HttpServletResponse response) {
		String gid = request.getParameter("gid");
		
		IGoodsBiz goodsBiz = new GoodsBizImpl();
		this.out(response, goodsBiz.findGood(gid));
	}

	/**
	 * 修改状态
	 * @param request
	 * @param response
	 */
	private void changeStatus(HttpServletRequest request, HttpServletResponse response) {
		IGoodsBiz goodsBiz=new GoodsBizImpl();
		String gid=request.getParameter("gid");
		String status=request.getParameter("status");
		this.out(response,goodsBiz.update(gid, status));
	}

	private void deleteGoods(HttpServletRequest request, HttpServletResponse response) {
		IGoodsBiz goodsBiz=new GoodsBizImpl();
		String gid=request.getParameter("gid");
		this.out(response, goodsBiz.deleteGoods(gid));
	}

	private void addGoods(HttpServletRequest request, HttpServletResponse response) {
		FileUpload fileUpload=new FileUpload();
		PageContext pageContext=JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true, 1024, true);
		StoreGoods goods=fileUpload.upload(pageContext,StoreGoods.class);
		Object obj=request.getSession().getAttribute("currentLoginStore");
		
		/////////////////////////////////////////////////////////////
		Store store=(Store)obj;
		Integer sid=store.getSid();
		
		//System.out.println(goods);
		IGoodsBiz goodsBiz=new GoodsBizImpl();
		this.out(response,goodsBiz.add(goods,sid));
	}

	private void findByPage(HttpServletRequest request, HttpServletResponse response) {
		Integer pageNo=Integer.parseInt(request.getParameter("page"));
		Integer pageSize=Integer.parseInt(request.getParameter("rows"));
		IGoodsBiz goodsBiz=new GoodsBizImpl();
		this.out(response,goodsBiz.findByPage(pageNo, pageSize));
	}
}

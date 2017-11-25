package com.ss.erqiwwt.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ss.erqiwwt.bean.Admin;
import com.ss.erqiwwt.bean.CusInfo;
import com.ss.erqiwwt.biz.IAdminBiz;
import com.ss.erqiwwt.biz.IStoreTypeBiz;
import com.ss.erqiwwt.biz.IUserInfoBiz;
import com.ss.erqiwwt.biz.impl.AdminBizImpl;
import com.ss.erqiwwt.biz.impl.StoreTypeBizImpl;
import com.ss.erqiwwt.biz.impl.UserInfoBizImpl;
import com.ss.erqiwwt.util.SessionAttributeInfo;

@WebServlet("/adminServlet")
public class AdminServlet extends BasicServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op=request.getParameter("op");
		
		if("findByPage".equals(op)){
			findByPage(request,response);
		} else if("addAdmin".equals(op)){
			addAdmin(request,response);
		} else if("deleteAdmin".equals(op)){
			deleteAdmin(request,response);
		}else if("login".equals(op)){
			login(request,response);
		}else if("editStoreType".equals(op)){
			editStoreType(request,response);
		}
	}


	/**
	 * 修改
	 * @param request
	 * @param response
	 */
	private void editStoreType(HttpServletRequest request, HttpServletResponse response) {
		IAdminBiz adminBiz=new AdminBizImpl();
		String aid=request.getParameter("aid");
		String aname=request.getParameter("aname");
		String pwd=request.getParameter("pwd");
		
		this.out(response, adminBiz.updateAdmin(aid, aname, pwd));
		
	}


	//管理员登录
	private void login(HttpServletRequest request, HttpServletResponse response) {
		String aname=request.getParameter("aname");
		String pwd=request.getParameter("pwd");
		
		int result=-1;
		IAdminBiz adminBiz=new AdminBizImpl();
		Admin admin=adminBiz.login(aname, pwd);
		/*if(admin!=null){
			//将当前登录用户存到session，以便于其他页面获取
			request.getSession().setAttribute(SessionAttributeInfo.CURRENTLOGININFO, admin);
			result=3;  //说明成功
		}else{
			result=2;
		}*/
		if(admin==null){
			result=2;
		}else{
			//将当前登录用户存到session，以便于其他页面获取
			request.getSession().setAttribute("currentLoginAdmin", admin);
			result=3;  //说明成功
		}
		
		this.out(response,result);
	}
	/**
	 * 删除管理员信息
	 * @param request
	 * @param response
	 */
	private void deleteAdmin(HttpServletRequest request, HttpServletResponse response) {
		IAdminBiz adminBiz=new AdminBizImpl();
		String aids=request.getParameter("aids");
		this.out(response, adminBiz.deleteAdmin(aids));
	}

	/**
	 * 添加管理员信息
	 * @param request
	 * @param response
	 */
	private void addAdmin(HttpServletRequest request, HttpServletResponse response) {
		IAdminBiz adminBiz=new AdminBizImpl();
		String aname=request.getParameter("aname");
		String pwd=request.getParameter("pwd");
		
		this.out(response, adminBiz.addAdmin(aname, pwd));
	}

	/**
	 * 分页查询
	 * @param request
	 * @param response
	 */
	private void findByPage(HttpServletRequest request, HttpServletResponse response) {
		IAdminBiz adminBiz=new AdminBizImpl();
		Integer pageNo=Integer.parseInt(request.getParameter("page"));
		Integer pageSize=Integer.parseInt(request.getParameter("rows"));
		
		this.out(response, adminBiz.findAdmin(pageNo, pageSize));
	}

}

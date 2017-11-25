<%@page import="com.google.gson.GsonBuilder"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="com.yc.ajax.bean.Dept"%>
<%@page import="java.util.List"%>
<%@page import="com.yc.ajax.dao.DeptDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String op=request.getParameter("op");
	if("checkDname".equals(op)){   //检查部门是否存在
		String dname=request.getParameter("dname");
		DeptDao deptDao=new DeptDao();
		int result=deptDao.findDname(dname);
		out.print(result);
		
	}else if("addDept".equals(op)){
		String deptno=request.getParameter("deptno");
		String dname=request.getParameter("dname");
		String loc=request.getParameter("loc");
		System.out.println(deptno);
		DeptDao deptDao=new DeptDao();
		int result=deptDao.add(deptno,dname,loc);
		out.print(result);
		
	}else if("find".equals(op)){
		DeptDao deptDao=new DeptDao();
		List<Dept> list=deptDao.find(null, null);
		StringBuffer sbf=new StringBuffer("[");   //[{},{},{}]
		/* Dept dept=list.get(0);
		sbf.append("<tr><td>");
		sbf.append(dept.getDeptno());
		sbf.append("</td><td>");
		sbf.append(dept.getDname());
		sbf.append("</td><td>");
		sbf.append(dept.getLoc());
		sbf.append("</td><tr>");
		out.print(sbf.toString()); */
		//Dept dept=list.get(0);
		//out.print(dept.toString());
		for(Dept dept:list){
			sbf.append(dept.toString()).append(",");
		}
		String str=sbf.toString();
		str=str.substring(0,str.lastIndexOf(","))+"]";
		out.print(str);
	}else if("finds".equals(op)){
		DeptDao deptDao=new DeptDao();
		List<Dept> list=deptDao.find(null,null);
		Gson gson=new GsonBuilder().create();
		out.print(gson.toJson(list));   //使用gson组件Java对象转成json对象
	}
%>
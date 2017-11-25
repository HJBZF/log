<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	String uname=request.getParameter("uname");
	String pwd=request.getParameter("pwd");
	
	System.out.println(uname+"\t"+pwd);
	
	if("yc".equals(uname) && "123".equals(pwd)){
		out.print("1");
	}else{
		out.print("0");
	}
%>
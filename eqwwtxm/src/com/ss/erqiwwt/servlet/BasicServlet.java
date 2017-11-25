package com.ss.erqiwwt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class BasicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}
	
	public void out(HttpServletResponse resp,int result){
		PrintWriter out=null;
		try {
			out=resp.getWriter();
			out.print(result);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			if(out!=null){
				out.close();
			}
		}
	}
	
	public void out(HttpServletResponse resp,String str){
		PrintWriter out=null;
		try {
			out=resp.getWriter();
			out.print(str);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			if(out!=null){
				out.close();
			}
		}
	}
	
	public void out(HttpServletResponse resp,Object obj){
		PrintWriter out=null;
		try {
			out=resp.getWriter();
			Gson gson=new GsonBuilder().create();
			out.print(gson.toJson(obj));
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			if(out!=null){
				out.close();
			}
		}
	}
}

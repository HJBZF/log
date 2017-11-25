package com.ss.erqiwwt.servlet;

import java.io.File;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.ss.erqiwwt.util.FileUpload;

public class InitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String path="pics";
 
	@Override
	public void init(ServletConfig config) throws ServletException {
		String temp=config.getInitParameter("path");
		if(temp!=null){
			path=temp;
		}
		String realPath=config.getServletContext().getRealPath("/");
		
		File file=new File(realPath);

		if(file.exists()){
			
			File fl=new File(file.getParent(),path);
			FileUpload.PATH="../"+path;
			if(!fl.exists()){
				fl.mkdirs();
			}
		}		
	}
}

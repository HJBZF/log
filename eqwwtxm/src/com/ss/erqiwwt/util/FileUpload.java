package com.ss.erqiwwt.util;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.jsp.PageContext;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

public class FileUpload {
	public static String PATH="pics";  //文件上传后存储在服务器端的哪个路径下
	private static final String ALLOWED="jpg,png,jpeg,ico,gif,doc,docx,xml,pdf,txt";  //允许上传的文件列表
	private static final String DENIED="exe,jsp,html,bat";  //拒绝上传的文件列表
	private static final int SINGLEFILESIZE=1024*1024*10;  //每个文件最大大小
	private static final int TOTALMAXSIZE=1024*1024*1024;  //每次最大上传文件大小

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map<String,String> upload(PageContext pageContext){
		Map<String,String> map=new HashMap<String,String>();
		SmartUpload su=new SmartUpload();

		try {
			//初始化上传工具
			su.initialize(pageContext);

			//设置参数
			su.setCharset("utf-8");
			su.setAllowedFilesList(ALLOWED);
			su.setDeniedFilesList(DENIED);
			su.setMaxFileSize(SINGLEFILESIZE);
			su.setTotalMaxFileSize(TOTALMAXSIZE);

			//开始上传
			su.upload();

			//从smartupload请求中获取普通文本参数 text、number、password 即非 file
			Request request=su.getRequest();

			//从请求中获取所有普通文本框name属性的属性值
			Enumeration enums=request.getParameterNames();
			String filedName=null;
			while(enums.hasMoreElements()){
				filedName=(String.valueOf(enums.nextElement()));
				map.put(filedName, request.getParameter(filedName));
			}
			if(su.getFiles()!=null && su.getFiles().getCount()>0){  //说明有文件要上传
				Files fl=su.getFiles();
				Collection<File> files=fl.getCollection();  //转成一个集合
				String fName="";
				String path="";
				String filePath="";
				String temp=null;

				for(File f:files){  //循环所有文件
					if(!f.isMissing()){
						fName=f.getFieldName();

						if(temp==null){
							temp=fName;
						}else{
							if(!temp.equals(fName)){
								map.put(temp, filePath);
								filePath="";
								temp=fName;
							}
						}
						path=PATH+"/"+new Date().getTime()+"_"+f.getFileName();

						//上传文件
						f.saveAs(pageContext.getServletContext().getRealPath("/")+path);

						if(filePath!=""){
							filePath+=",";
						}
						filePath+=path;						
					}
				}
				map.put(fName, filePath);				
			}			
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (SmartUploadException e) {
			e.printStackTrace();
		}		
		return map;
	}

	@SuppressWarnings({"unchecked" })
	public <T> T upload(PageContext pageContext,Class<T> c){
		SmartUpload su=new SmartUpload();
		T t=null;
		try {
			t=c.newInstance();

			//初始化上传工具
			su.initialize(pageContext);

			//设置参数
			su.setCharset("utf-8");
			su.setAllowedFilesList(ALLOWED);
			su.setDeniedFilesList(DENIED);
			su.setMaxFileSize(SINGLEFILESIZE);
			su.setTotalMaxFileSize(TOTALMAXSIZE);

			//开始上传
			su.upload();

			//从smartupload请求中获取普通文本参数 text、number、password 即非 file
			Request request=su.getRequest();

			//从请求中获取所有普通文本框name属性的属性值
			Enumeration<String> enums=request.getParameterNames();

			List<Method> list=this.getSetter(c);

			String filedName=null;
			String typeName;

			while(enums.hasMoreElements()){
				filedName=enums.nextElement();
				for(Method method:list){
					if(("set"+filedName).equalsIgnoreCase(method.getName())){
						typeName=method.getParameterTypes()[0].getSimpleName();
						if("int".equals(typeName) || "Integer".equals(typeName)){
							method.invoke(t,Integer.parseInt(request.getParameter(filedName)));
						}else if("double".equals(typeName) || "Double".equals(typeName)){
							method.invoke(t,Double.parseDouble(request.getParameter(filedName)));
						}else{
							method.invoke(t, request.getParameter(filedName));
						}
					}
				}
			}

			if(su.getFiles()!=null && su.getFiles().getCount()>0){  //说明有文件要上传
				Files fl=su.getFiles();
				Collection<File> files=fl.getCollection();  //转成一个集合
				String fName="";
				String path="";
				String filePath="";
				String temp=null;

				for(File f:files){  //循环所有文件
					if(!f.isMissing()){
						fName=f.getFieldName();

						if(temp==null){
							temp=fName;
						}else{
							if(!temp.equals(fName)){
								for(Method method:list){
									if(("set"+temp).equalsIgnoreCase(method.getName())){
										method.invoke(t,filePath);
									}
								}
								filePath="";
								temp=fName;
							}
						}
						path=PATH+"/"+new Date().getTime()+"_"+f.getFileName();

						//上传文件
						f.saveAs(pageContext.getServletContext().getRealPath("/")+path);

						if(filePath!=""){
							filePath+=",";
						}
						filePath+=path;						
					}
				}

				for(Method method:list){
					if(("set"+fName).equalsIgnoreCase(method.getName())){
						method.invoke(t,filePath);
					}
				}
				filePath="";
				temp=null;
			}
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (SmartUploadException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}		
		return t;
	}

	public List<Method> getSetter(Class<?> c){
		Method[] methods=c.getMethods();
		List<Method> list=new ArrayList<Method>();
		for(Method method:methods){
			if(method.getName().startsWith("set")){
				list.add(method);
			}
		}
		return list;
	}
} 

package com.ss.erqiwwt.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

public class RequestToObject {
	public <T> T setHelp(HttpServletRequest req,Class<T> c){
		Map<String,String[]> parameterMap=req.getParameterMap();
		Map<String,String> maps=new HashMap<String,String>();
		for(String key:parameterMap.keySet()){
			maps.put(key,parameterMap.get(key)[0]);
		}

		T t=null;
		try {
			t = c.newInstance();
		} catch (InstantiationException | IllegalAccessException e1) {
			e1.printStackTrace();
		}
		String colName;
		String mname=null;
		List<Method> methods=this.getSetter(c); //获取对象里面所有的set方法
		String typeName;

		Set<String> keys=maps.keySet();
		for(String key:keys){  //setuname pwd
			colName="set"+key;
			for(Method m:methods){    //循环取出所有的set方法
				mname=m.getName();
				if(colName.equalsIgnoreCase(mname)){ //当属性名和set方法中的属性相同时
					typeName=m.getParameterTypes()[0].getSimpleName();
					try {
						if("int".equals(typeName) || "Integer".equals(typeName)){
							m.invoke(t,Integer.parseInt(maps.get(key)));
						}else if("double".equals(typeName) || "Double".equals(typeName)){
							m.invoke(t,Double.parseDouble(maps.get(key)));
						}else{
							m.invoke(t,maps.get(key));
						}
					} catch (NumberFormatException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					}
				}
			}
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

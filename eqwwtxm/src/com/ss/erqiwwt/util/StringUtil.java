package com.ss.erqiwwt.util;

/**
 * 判断字段是否为空
 * @author
 *
 */
public class StringUtil {
	public static boolean isNull(String str){
		if(str==null || "".equals(str)){
			return true;
		}
		return false;
	}
	
	public static boolean isNull(String ...params){
		if(params!=null && params.length>0){
			for(String str:params){
				if(str==null || "".equals(str)){
					return true;
				}				
			}
			return false;
		}else{
			return true;
		}
	}
}

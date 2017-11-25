package com.ss.erqiwwt.biz;

import com.ss.erqiwwt.bean.CusInfo;

public interface IUserInfoBiz {
	public int user(CusInfo cusInfo);
	
	public CusInfo login(String name,String pwd);
	
	public CusInfo getByUsid(String usid);
	
	public int active(String usid,int status);
}

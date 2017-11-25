package com.ss.erqiwwt.dao;

import com.ss.erqiwwt.bean.CusInfo;

public interface UserInfoDao {
	public int user(CusInfo cusInfo);
	
	public CusInfo login(String name,String pwd);
	
	public CusInfo getByUsid(String usid);
	
	public int active(String usid,int status);
}

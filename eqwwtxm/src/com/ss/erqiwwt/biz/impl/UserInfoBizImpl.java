package com.ss.erqiwwt.biz.impl;

import com.ss.erqiwwt.bean.CusInfo;
import com.ss.erqiwwt.biz.IUserInfoBiz;
import com.ss.erqiwwt.dao.UserInfoDao;
import com.ss.erqiwwt.dao.impl.UserInfoDaoImpl;

public class UserInfoBizImpl implements IUserInfoBiz{

	@Override
	public int user(CusInfo cusInfo) {
		UserInfoDao userInfoDao=new UserInfoDaoImpl();
		
		return userInfoDao.user(cusInfo);
	}
	
	public CusInfo login(String name,String pwd){
		UserInfoDao userInfoDao=new UserInfoDaoImpl();

		return userInfoDao.login(name, pwd);
	}
	
	public CusInfo getByUsid(String usid){
		UserInfoDao userInfoDao=new UserInfoDaoImpl();
		return userInfoDao.getByUsid(usid);
	}
	
	public int active(String usid,int status){
		UserInfoDao userInfoDao=new UserInfoDaoImpl();
		return userInfoDao.active(usid, status);
	}
	
	
}

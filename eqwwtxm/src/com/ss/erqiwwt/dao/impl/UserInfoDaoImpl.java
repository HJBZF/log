package com.ss.erqiwwt.dao.impl;

import java.util.List;

import com.ss.erqiwwt.bean.CusInfo;
import com.ss.erqiwwt.dao.DBHelper;
import com.ss.erqiwwt.dao.UserInfoDao;

public class UserInfoDaoImpl implements UserInfoDao{

	@Override
	public int user(CusInfo cf) {
		DBHelper db=new DBHelper();
		String sql="insert into cusInfo values(?,?,?,?,'',?,?,?,?,3,?)";
		return db.update(sql,cf.getUsid(),cf.getUname(),cf.getPwd(),cf.getEmail(),cf.getTel(),cf.getPro(),cf.getCity(),cf.getArea(),cf.getFlag());
		
	}
	
	public CusInfo login(String name,String pwd){
		DBHelper db=new DBHelper();
		String sql="select * from cusInfo where (uname=? or email=?) and pwd=?";
		List<CusInfo> cfs=db.find(sql,CusInfo.class,name,name,pwd);
		if(cfs!=null && cfs.size()>0){
			return cfs.get(0);
		}else{
			return null;
		}
	}
	
	public CusInfo getByUsid(String usid){
		DBHelper db=new DBHelper();
		String sql="select * from cusInfo where usid=?";
		List<CusInfo> cfs=db.find(sql,CusInfo.class,usid);
		if(cfs!=null && cfs.size()>0){
			return cfs.get(0);
		}else{
			return null;
		}
	}
	
	public int active(String usid,int status){
		DBHelper db=new DBHelper();
		String sql="update cusInfo set status=? where usid=?";
		return db.update(sql,status,usid);
	}
}

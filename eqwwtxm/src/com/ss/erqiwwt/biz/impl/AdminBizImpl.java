package com.ss.erqiwwt.biz.impl;

import java.util.HashMap;
import java.util.Map;

import com.ss.erqiwwt.bean.Admin;
import com.ss.erqiwwt.biz.IAdminBiz;
import com.ss.erqiwwt.dao.IAdminDao;
import com.ss.erqiwwt.dao.IStoreDao;
import com.ss.erqiwwt.dao.IStoreTypeDao;
import com.ss.erqiwwt.dao.impl.AdminDaoImpl;
import com.ss.erqiwwt.dao.impl.StoreDaoImpl;
import com.ss.erqiwwt.dao.impl.StoreTypeDaoImpl;
import com.ss.erqiwwt.util.MD5Encryption;
import com.ss.erqiwwt.util.StringUtil;

public class AdminBizImpl implements IAdminBiz{

	@Override
	public Admin login(String aname, String pwd) {
		if(StringUtil.isNull(aname,pwd)){
			return null;
		}else{
			IAdminDao adminDao=new AdminDaoImpl();
			pwd=MD5Encryption.createPassword(pwd);
			return adminDao.login(aname, pwd);
		}
	}

	@Override
	public int addAdmin(String aname, String pwd) {
		if(StringUtil.isNull(aname,pwd)){
			return 0;
		}else{
			IAdminDao adminDao=new AdminDaoImpl();
			pwd=MD5Encryption.createPassword(pwd);
			return adminDao.addAdmin(aname, pwd);
		}
	}

	@Override
	public Map<String, Object> findAdmin(Integer pageNo, Integer pageSize) {
		Map<String,Object> map=new HashMap<String,Object>();
		IAdminDao adminDao=new AdminDaoImpl();
		
		map.put("total", adminDao.total());
		map.put("rows", adminDao.findAdmin(pageNo, pageSize));
		return map;
	}

	@Override
	public int deleteAdmin(String aids) {
		IAdminDao adminDao=new AdminDaoImpl();
		return adminDao.deleteAdmin(aids);
	}

	@Override
	public int updateAdmin(String aid,String aname,String pwd) {
		IAdminDao adminDao=new AdminDaoImpl();
		return adminDao.updateAdmin(aid,aname, pwd);
	}

}

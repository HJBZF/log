package com.ss.erqiwwt.biz.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ss.erqiwwt.bean.Store;
import com.ss.erqiwwt.biz.IStoreBiz;
import com.ss.erqiwwt.dao.IAdminDao;
import com.ss.erqiwwt.dao.IStoreDao;
import com.ss.erqiwwt.dao.impl.AdminDaoImpl;
import com.ss.erqiwwt.dao.impl.StoreDaoImpl;
import com.ss.erqiwwt.util.MD5Encryption;
import com.ss.erqiwwt.util.StringUtil;

public class StoreBizImpl implements IStoreBiz{

	@Override
	public int add(Store store) {
		if(StringUtil.isNull(store.getSname(),store.getLicense(),store.getPwd())){
			return 0;
		}else{
			IStoreDao storeDao=new StoreDaoImpl();
			return storeDao.add(store);
		}
	}

	@Override
	public Map<String, Object> findByPage(Integer pageNo, Integer pageSize) {
		IStoreDao storeDao=new StoreDaoImpl();
		
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("total", storeDao.total());
		map.put("rows", storeDao.findByPage(pageNo, pageSize));
		
		return map;
	}

	@Override
	public int update(String sid, String status, String reason) {
		IStoreDao storeDao=new StoreDaoImpl();
		if(StringUtil.isNull(sid,status)){
			return 0;
		}
		return storeDao.update(sid, status, reason);
	}

	@Override
	public List<Store> find(Map<String, String> map, Integer pageNo, Integer pageSize) {
		IStoreDao storeDao=new StoreDaoImpl();
		return storeDao.find(map, pageNo, pageSize);
	}

	@Override
	public Store login(String sid, String pwd) {
		if(StringUtil.isNull(sid,pwd)){
			return null;
		}else{
			IStoreDao storeDao=new StoreDaoImpl();
			return storeDao.login(sid, pwd);
		}
	}
}
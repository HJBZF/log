package com.ss.erqiwwt.biz.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ss.erqiwwt.bean.StoreType;
import com.ss.erqiwwt.biz.IStoreTypeBiz;
import com.ss.erqiwwt.dao.IStoreTypeDao;
import com.ss.erqiwwt.dao.impl.StoreTypeDaoImpl;
import com.ss.erqiwwt.util.StringUtil;

public class StoreTypeBizImpl implements IStoreTypeBiz{

	@Override
	public int addStoreType(String stname, String discr) {
		if(StringUtil.isNull(stname)){
			return 0;
		}else{
			IStoreTypeDao storeTypeDao=new StoreTypeDaoImpl();
			return storeTypeDao.addStoreType(stname, discr);
		}
	}

	@Override
	public Map<String, Object> findStoreType(Integer pageNo, Integer pageSize) {
		Map<String,Object> map=new HashMap<String,Object>();
		IStoreTypeDao storeTypeDao=new StoreTypeDaoImpl();
		
		map.put("total", storeTypeDao.total());
		map.put("rows", storeTypeDao.findStoreType(pageNo, pageSize));
		return map;
	}

	@Override
	public int deleteStoreType(String stids) {
		IStoreTypeDao storeTypeDao=new StoreTypeDaoImpl();
		return storeTypeDao.deleteStoreType(stids);
	}

	@Override
	public int updateStoreType(String stid, String stname, String discr) {
		IStoreTypeDao storeTypeDao=new StoreTypeDaoImpl();
		return storeTypeDao.updateStoreType(stid, stname, discr);
	}

	@Override
	public List<StoreType> find() {
		IStoreTypeDao storeTypeDao=new StoreTypeDaoImpl();
		return storeTypeDao.find();
	}

}

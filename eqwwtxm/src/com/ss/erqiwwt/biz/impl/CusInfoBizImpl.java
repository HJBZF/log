package com.ss.erqiwwt.biz.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ss.erqiwwt.bean.CusInfo;
import com.ss.erqiwwt.bean.Store;
import com.ss.erqiwwt.biz.ICusInfoBiz;
import com.ss.erqiwwt.dao.IAdminDao;
import com.ss.erqiwwt.dao.ICusInfoDao;
import com.ss.erqiwwt.dao.IStoreDao;
import com.ss.erqiwwt.dao.impl.CusInfoDaoImpl;
import com.ss.erqiwwt.dao.impl.StoreDaoImpl;
import com.ss.erqiwwt.util.StringUtil;

public class CusInfoBizImpl implements ICusInfoBiz{

	@Override
	public Map<String, Object> findCus(Integer pageNo, Integer pageSize) {
		Map<String,Object> map=new HashMap<String,Object>();
		ICusInfoDao cusInfoDao=new CusInfoDaoImpl();
		
		map.put("total", cusInfoDao.total());
		map.put("rows", cusInfoDao.findCus(pageNo, pageSize));
		return map;
	}
	
	@Override
	public List<CusInfo> find(Map<String, String> map, Integer pageNo, Integer pageSize) {
		ICusInfoDao cusInfoDao=new CusInfoDaoImpl();
		return cusInfoDao.find(map, pageNo, pageSize);
	}

	@Override
	public int update(String pwd, String status) {
		ICusInfoDao cusInfoDao=new CusInfoDaoImpl();
		if(StringUtil.isNull(pwd,status)){
			return 0;
		}
		return cusInfoDao.update(pwd, status);
	}

}

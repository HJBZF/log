package com.ss.erqiwwt.biz.impl;

import java.util.HashMap;
import java.util.Map;

import com.ss.erqiwwt.biz.IOrderInfoBiz;
import com.ss.erqiwwt.dao.IAdminDao;
import com.ss.erqiwwt.dao.ICusInfoDao;
import com.ss.erqiwwt.dao.IOrderInfoDao;
import com.ss.erqiwwt.dao.impl.AdminDaoImpl;
import com.ss.erqiwwt.dao.impl.CusInfoDaoImpl;
import com.ss.erqiwwt.dao.impl.IOrderInfoDaoImpl;
import com.ss.erqiwwt.util.StringUtil;

public class OrderInfoBizImpl implements IOrderInfoBiz{

	@Override
	public Map<String, Object> findPage(Integer pageNo, Integer pageSize) {
		Map<String,Object> map=new HashMap<String,Object>();
		IOrderInfoDao orderDao=new IOrderInfoDaoImpl();
		
		map.put("total", orderDao.total());
		map.put("rows", orderDao.findPage(pageNo, pageSize));
		return map;
	}

	@Override
	public int update(String oid, String status) {
		IOrderInfoDao orderDao=new IOrderInfoDaoImpl();
		if(StringUtil.isNull(oid,status)){
			return 0;
		}
		return orderDao.update(oid, status);
	}

	@Override
	public int deleteOrder(String oid) {
		IOrderInfoDao orderDao=new IOrderInfoDaoImpl();
		return orderDao.deleteOrder(oid);
	}

}

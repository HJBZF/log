package com.ss.erqiwwt.biz.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ss.erqiwwt.bean.StoreGoods;
import com.ss.erqiwwt.biz.IGoodsBiz;
import com.ss.erqiwwt.dao.IAdminDao;
import com.ss.erqiwwt.dao.ICusInfoDao;
import com.ss.erqiwwt.dao.IGoodsDao;
import com.ss.erqiwwt.dao.IStoreDao;
import com.ss.erqiwwt.dao.impl.AdminDaoImpl;
import com.ss.erqiwwt.dao.impl.CusInfoDaoImpl;
import com.ss.erqiwwt.dao.impl.GoodsDaoImpl;
import com.ss.erqiwwt.dao.impl.StoreDaoImpl;
import com.ss.erqiwwt.util.StringUtil;

public class GoodsBizImpl implements IGoodsBiz{

	@Override
	public Map<String, Object> findByPage(Integer pageNo, Integer pageSize) {
		
		IGoodsDao goodsDao=new GoodsDaoImpl();
		
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("total", goodsDao.total());
		map.put("rows", goodsDao.findByPage(pageNo, pageSize));
		//System.out.println(map);
		return map;
	}

	@Override
	public int add(StoreGoods store, Integer sid) {
		if(StringUtil.isNull(store.getGname(),store.getPic())){
			return 0;
		}else{
			IGoodsDao goodsDao=new GoodsDaoImpl();
			return goodsDao.add(store,sid);
		}
	}

	@Override
	public int deleteGoods(String gid) {
		IGoodsDao goodsDao=new GoodsDaoImpl();
		return goodsDao.deleteGoods(gid);
	}

	@Override
	public int update(String gid, String status) {
		IGoodsDao goodsDao=new GoodsDaoImpl();
		if(StringUtil.isNull(gid,status)){
			return 0;
		}
		return goodsDao.update(gid, status);
	}

	@Override
	public StoreGoods findGood(String gid) {
		IGoodsDao goodsDao = new GoodsDaoImpl();
		StoreGoods good = goodsDao.findGood(gid);
		
		return good;
	}

	@Override
	public List<StoreGoods> findGod() {
		IGoodsDao goodsDao = new GoodsDaoImpl();
		List<StoreGoods> list = goodsDao.findGod();
		return list;
	}
	
}

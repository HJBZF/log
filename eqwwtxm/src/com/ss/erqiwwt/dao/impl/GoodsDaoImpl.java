package com.ss.erqiwwt.dao.impl;

import java.util.List;

import com.ss.erqiwwt.bean.StoreGoods;
import com.ss.erqiwwt.dao.DBHelper;
import com.ss.erqiwwt.dao.IGoodsDao;

public class GoodsDaoImpl implements IGoodsDao{
	@Override
	public List<StoreGoods> findByPage(Integer pageNo, Integer pageSize) {
		DBHelper db=new DBHelper();
		String sql="select * from (select a.*,rownum rn from (select "
				+ "gid,gname,sid,price,pic,aprice,startDate,endDate,mark,descr,status"
				+ " from goods where status!=0 order by gid)a where rownum<=?) where rn>?";
		return db.find(sql, StoreGoods.class,pageNo*pageSize,(pageNo-1)*pageSize);
	}

	@Override
	public int total() {
		DBHelper db=new DBHelper();
		String sql="select count(gid) as total from goods where status!=0";
		return db.getTotal(sql);
	}

	@Override
	public int add(StoreGoods store,Integer sid) {
		DBHelper db=new DBHelper();
		String sql="insert into goods values(seq_goods_gid.nextval,?,?,?,?,?,to_date(?,'yyyy-mm-dd HH24:mi'),to_date(?,'yyyy-mm-dd HH24:mi'),?,?,1)";
		return db.update(sql,store.getGname(),sid,store.getPrice(),store.getPic(),store.getAprice(),store.getStartDate(),store.getEndDate(),store.getMark(),store.getDescr());
	}

	@Override
	public int deleteGoods(String gid) {
		DBHelper db=new DBHelper();
		if(gid.contains(",") && !gid.contains(" or ")){
			String sql="update goods set status=0 where gid in ("+gid+")";
			return db.update(sql);
		}else{
			String sql="update goods set status=0 where gid=?";
			return db.update(sql,gid);
		}
	}

	@Override
	public int update(String gid, String status) {
		DBHelper db=new DBHelper();
		String sql="update goods set status=? where gid=?";
		return db.update(sql, status,gid);
	}

	@Override
	public StoreGoods findGood(String gid) {
		DBHelper db = new DBHelper();
		String sql = "select goods.*,sname from goods,store where gid=? and goods.sid=store.sid";
		List<StoreGoods> goods = db.find(sql, StoreGoods.class, gid);
		if(goods!=null){
			return goods.get(0);
		}else{
			return null;
		}
		
	}

	@Override
	public List<StoreGoods> findGod() {
		DBHelper db = new DBHelper();
		String sql = "select * from goods";
		return db.find(sql, StoreGoods.class);
	}

}

package com.ss.erqiwwt.dao.impl;

import java.util.List;

import com.ss.erqiwwt.bean.OrderTable;
import com.ss.erqiwwt.dao.DBHelper;
import com.ss.erqiwwt.dao.IOrderInfoDao;

public class IOrderInfoDaoImpl implements IOrderInfoDao{

	@Override
	public List<OrderTable> findPage(Integer pageNo, Integer pageSize) {
		DBHelper db=new DBHelper();
		String sql="select * from (select a.*,rownum rn from (select "
				+ "oid,usid,gid,odate,total,udate,num,status"
				+ " from orderInfo where status!=0 order by oid)a where rownum<=?) where rn>?";
		return db.find(sql, OrderTable.class, pageNo*pageSize,(pageNo-1)*pageSize);
	}

	@Override
	public int total() {
		DBHelper db=new DBHelper();
		String sql="select count(oid) as total from orderInfo where status!=0";
		return db.getTotal(sql);
	}

	@Override
	public int update(String oid, String status) {
		DBHelper db=new DBHelper();
		String sql="update orderInfo set status=? where oid=?";
		return db.update(sql, status,oid);
	}

	@Override
	public int deleteOrder(String oid) {
		DBHelper db=new DBHelper();
		if(oid.contains(",") && !oid.contains(" or ")){
			String sql="update orderInfo set status=0 where oid in ("+oid+")";
			return db.update(sql);
		}else{
			String sql="update orderInfo set status=0 where oid=?";
			return db.update(sql,oid);
		}
	}

}

package com.ss.erqiwwt.dao.impl;

import java.util.List;
import com.ss.erqiwwt.bean.StoreType;
import com.ss.erqiwwt.dao.DBHelper;
import com.ss.erqiwwt.dao.IStoreTypeDao;

public class StoreTypeDaoImpl implements IStoreTypeDao{

	@Override
	public int addStoreType(String stname, String discr) {
		DBHelper db=new DBHelper();
		String sql="insert into storeType values(seq_storeType_stid.nextval,?,?,1)";
		return db.update(sql,stname,discr);
	}

	@Override
	public List<StoreType> findStoreType(Integer pageNo, Integer pageSize) {
		DBHelper db=new DBHelper();
		String sql="select * from (select a.*,rownum rn from (select stid,stname,discr from storeType where status!=0 order by stid)a where rownum<=?) where rn>?";
		return db.find(sql, StoreType.class, pageNo*pageSize,(pageNo-1)*pageSize);
	}

	@Override
	public int total() {
		DBHelper db=new DBHelper();
		String sql="select count(stid) as total from storeType where status!=0";
		return db.getTotal(sql);
	}

	@Override
	public int deleteStoreType(String stids) {
		DBHelper db=new DBHelper();
		if(stids.contains(",") && !stids.contains(" or ")){
			String sql="update storeType set status=0 where stid in ("+stids+")";
			return db.update(sql);
		}else{
			String sql="update storeType set status=0 where stid=?";
			return db.update(sql,stids);
		}
	}

	@Override
	public int updateStoreType(String stid, String stname, String discr) {
		DBHelper db=new DBHelper();
		String sql="update storeType set stname=?,discr=? where stid=?";
		return db.update(sql,stname,discr,stid);
	}

	@Override
	public List<StoreType> find() {
		DBHelper db=new DBHelper();
		String sql="select stid,stname from storeType where status!=0";
		return db.find(sql, StoreType.class);
	}

}

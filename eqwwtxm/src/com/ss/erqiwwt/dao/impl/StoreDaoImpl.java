package com.ss.erqiwwt.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.ss.erqiwwt.bean.Admin;
import com.ss.erqiwwt.bean.Store;
import com.ss.erqiwwt.dao.DBHelper;
import com.ss.erqiwwt.dao.IStoreDao;

public class StoreDaoImpl implements IStoreDao{

	@Override
	public int add(Store store) {
		DBHelper db=new DBHelper();
		String sql="insert into store values(seq_store_sid.nextval,?,?,?,?,?,?,?,?,?,?,?,sysdate,2,'')";
		return db.update(sql,store.getStid(),store.getSname(),store.getPwd(),store.getPro(),store.getCity(),
				store.getArea(),store.getAddr(),store.getLicense(),store.getRuntime(),store.getPic(),store.getTel());
	}

	@Override
	public List<Store> findByPage(Integer pageNo, Integer pageSize) {
		DBHelper db=new DBHelper();
		String sql="select * from (select a.*,rownum rn from (select "
				+ "sid,stid,sname,pro||' '||city||' '||area||' '||addr addr,license,runtime,tel,"
				+ "to_char(sdate,'yyyy-mm-dd') sdate,status from store order by sid)a where rownum<=?) where rn>?";
		return db.find(sql, Store.class,pageNo*pageSize,(pageNo-1)*pageSize);
	}

	@Override
	public int total() {
		DBHelper db=new DBHelper();
		String sql="select count(sid) total from store";
		return db.getTotal(sql);
	}

	@Override
	public int update(String sid, String status, String reason) {
		DBHelper db=new DBHelper();
		String sql="update store set status=?,reason=? where sid=?";
		return db.update(sql, status,reason,sid);
	}

	@Override
	public List<Store> find(Map<String, String> map, Integer pageNo, Integer pageSize) {
		DBHelper db=new DBHelper();
		List<Object> params=new ArrayList<Object>();
		
		String sql="select * from (select a.*,rownum rn from (select "
				+ "sid,stid,sname,pro||' '||city||' '||area||' '||addr addr,license,runtime,tel,"
				+ "to_char(sdate,'yyyy-mm-dd') sdate,status from store where 1=1";
		//sql+=" and stid=?";
		//sql+=" and sname like ?";
		if(map!=null && map.size()>0){
			Set<String> keys=map.keySet();
			for(String key:keys){
				sql+="and "+key+"?";
				params.add( map.get(key) );  //map.put("stid=",1001);  map.put("sname like","自助")
			}
		}
		
		sql+=" order by sid)a where rownum<=?) where rn>?";
		
		params.add( pageNo*pageSize );
		params.add( (pageNo-1)*pageSize );
		return db.find(sql, Store.class,params);
	}

	@Override
	public Store login(String sid, String pwd) {
		DBHelper db=new DBHelper();
		String sql="select sid,sname,pwd from store where status!=0 and sid=? and pwd=?";
		List<Store> stores=db.find(sql, Store.class, sid,pwd);
		if(stores!=null && stores.size()>0){
			
			return stores.get(0);
			
		}else{
			return null;
		}
	}

}

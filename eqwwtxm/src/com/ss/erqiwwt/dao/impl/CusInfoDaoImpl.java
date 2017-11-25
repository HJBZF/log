package com.ss.erqiwwt.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.ss.erqiwwt.bean.Admin;
import com.ss.erqiwwt.bean.CusInfo;
import com.ss.erqiwwt.bean.Store;
import com.ss.erqiwwt.dao.DBHelper;
import com.ss.erqiwwt.dao.ICusInfoDao;

public class CusInfoDaoImpl implements ICusInfoDao{


	@Override
	public List<CusInfo> findCus(Integer pageNo, Integer pageSize) {
		DBHelper db=new DBHelper();
		String sql="select * from (select a.*,rownum rn from (select "
				+ "usid,uname,pwd,pro,city,area,email,status,tel"
				+ " from cusInfo order by usid)a where rownum<=?) where rn>?";
		return db.find(sql, CusInfo.class,pageNo*pageSize,(pageNo-1)*pageSize);
	}

	@Override
	public int total() {
		DBHelper db=new DBHelper();
		String sql="select count(usid) total from cusInfo";
		return db.getTotal(sql);
	}
	
	@Override
	public List<CusInfo> find(Map<String, String> map, Integer pageNo, Integer pageSize) {
		DBHelper db=new DBHelper();
		List<Object> params=new ArrayList<Object>();
		
		String sql="select * from (select a.*,rownum rn from (select "
				+ "usid,uname,pwd,pro,city,area,email,status,tel"
				+ " from cusInfo where 1=1";
		//sql+=" and stid=?";
		//sql+=" and sname like ?";
		if(map!=null && map.size()>0){
			Set<String> keys=map.keySet();
			for(String key:keys){
				sql+="and "+key+"?";
				params.add( map.get(key) );  //map.put("stid=",1001);  map.put("sname like","自助")
			}
		}
		
		sql+=" order by usid)a where rownum<=?) where rn>?";
		
		params.add( pageNo*pageSize );
		params.add( (pageNo-1)*pageSize );
		return db.find(sql, CusInfo.class,params);
	}


	@Override
	public int update(String pwd, String status) {
		DBHelper db=new DBHelper();
		String sql="update cusInfo set status=? where usid=?";
		return db.update(sql, status,pwd);
	}
	/**
	 * 检查用户名是否存在
	 *//*
	@Override
	public int findUsername(String uname) {
		String sql="select count(uname) as total from cusInfo where uname=?";
		DBHelper db=new DBHelper();
		return db.getTotal(sql, uname);
	}

	*//**
	 * 检查邮箱是否存在
	 *//*
	@Override
	public int findEmail(String email) {
		String sql="select count(email) as total from cusInfo where email=?";
		DBHelper db=new DBHelper();
		return db.getTotal(sql, email);
	}*/
}

package com.ss.erqiwwt.dao.impl;

import java.util.List;

import com.ss.erqiwwt.bean.Admin;
import com.ss.erqiwwt.dao.DBHelper;
import com.ss.erqiwwt.dao.IAdminDao;

public class AdminDaoImpl implements IAdminDao{

	@Override
	public Admin login(String aname, String pwd) {
		DBHelper db=new DBHelper();
		String sql="select aid,aname,pwd from admin where status!=0 and aname=? and pwd=?";
		List<Admin> admins=db.find(sql, Admin.class, aname,pwd);
		//System.out.println(admins);
		if(admins!=null && admins.size()>0){
			
			return admins.get(0);
			
		}else{
			return null;
		}
	}

	@Override
	public int addAdmin(String aname, String pwd) {
		DBHelper db=new DBHelper();
		String sql="insert into admin values(seq_admin_aid.nextval,?,?,1)";
		return db.update(sql, aname,pwd);
	}

	@Override
	public List<Admin> findAdmin(Integer pageNo, Integer pageSize) {
		DBHelper db=new DBHelper();
		String sql="select * from (select a.*,rownum rn from (select aid,aname,pwd from admin where status!=0 order by aid)a where rownum<=?) where rn>?";
		return db.find(sql, Admin.class, pageNo*pageSize,(pageNo-1)*pageSize);
	}

	@Override
	public int total() {
		DBHelper db=new DBHelper();
		String sql="select count(aid) as total from admin where status!=0";
		return db.getTotal(sql);
	}

	@Override
	public int deleteAdmin(String aids) {
		DBHelper db=new DBHelper();
		if(aids.contains(",") && !aids.contains(" or ")){
			String sql="update admin set status=0 where aid in ("+aids+")";
			return db.update(sql);
		}else{
			String sql="update admin set status=0 where aid=?";
			return db.update(sql,aids);
		}
	}

	@Override
	public int updateAdmin(String aid,String aname,String pwd) {
		DBHelper db=new DBHelper();
		String sql=" update admin set aname=? where aid=? or pwd=? ";
		return db.update(sql,aid,aname,pwd);
	}
}

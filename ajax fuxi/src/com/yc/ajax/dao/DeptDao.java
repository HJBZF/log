package com.yc.ajax.dao;

import java.util.List;
import java.util.Map;

import com.yc.ajax.bean.Dept;

public class DeptDao {
	public int add(String deptno,String dname,String loc){
		String sql="insert into dept values(?,?,?)";
		DBHelper db=new DBHelper();
		return db.update(sql, deptno,dname,loc);
	}
	
	/**
	 * 查找dname是否存在
	 * @param dname
	 * @return
	 */
	public int findDname(String dname){
		String sql="select dname from dept where dname=?";
		DBHelper db=new DBHelper();
		Map<String,String> map=db.findSingleByStr(sql, dname);
		if(map!=null && map.size()>0){
			return 1;
		}else{
			return 0;
		}
	}
	
	/**
	 * 分页查询
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public List<Dept> find(Integer pageNo,Integer pageSize){
		DBHelper db=new DBHelper();
		if(pageNo==null){
			String sql="select * from dept order by deptno";
			return db.find(sql, Dept.class);
		}else{
			String sql="select * from(select a.*,rownum as rn from (select * from dept order by deptno) a where rownum<=?)where rn>?";
			return db.find(sql, Dept.class,pageNo*pageSize,(pageNo-1)*pageSize);
		}
	}
}

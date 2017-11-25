package com.ss.erqiwwt.dao;

import java.util.List;

import com.ss.erqiwwt.bean.Admin;

public interface IAdminDao {
	/**
	 * 后台管理员登录
	 * @param aname
	 * @param pwd
	 * @return
	 */
	public Admin login(String aname,String pwd);
	
	/**
	 * 添加管理员
	 * @param aname
	 * @param pwd
	 * @return
	 */
	public int addAdmin(String aname,String pwd);
	
	/**
	 * 分页查询
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public List<Admin> findAdmin(Integer pageNo,Integer pageSize);
	
	/**
	 * 总记录数
	 * @return
	 */
	public int total();
	
	/**
	 * 删除管理员信息
	 * @param aids
	 * @return
	 */
	public int deleteAdmin(String aids);
	
	/**
	 * 修改密码
	 * @param aid
	 * @param pwd
	 * @return
	 */
	public int updateAdmin(String aid,String aname,String pwd);
}

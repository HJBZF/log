package com.ss.erqiwwt.biz;

import java.util.Map;
import com.ss.erqiwwt.bean.Admin;

public interface IAdminBiz {
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
	public Map<String,Object> findAdmin(Integer pageNo,Integer pageSize);
	
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

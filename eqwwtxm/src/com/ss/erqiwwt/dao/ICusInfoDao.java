package com.ss.erqiwwt.dao;

import java.util.List;
import java.util.Map;

import com.ss.erqiwwt.bean.Admin;
import com.ss.erqiwwt.bean.CusInfo;
import com.ss.erqiwwt.bean.Store;

public interface ICusInfoDao {	
	
	/*public int findUsername(String uname);
	public int findEmail(String email);*/
	
	/**
	 * 分页查询
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public List<CusInfo> findCus(Integer pageNo,Integer pageSize);
	
	/**
	 * 总记录数
	 * @return
	 */
	public int total();
	
	public List<CusInfo> find(Map<String,String> map,Integer pageNo,Integer pageSize);
	
	/**
	 * 修改状态
	 * @param sid
	 * @param status
	 * @param reason
	 * @return
	 */
	public int update(String pwd,String status);


}

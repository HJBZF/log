package com.ss.erqiwwt.dao;

import java.util.List;
import java.util.Map;

import com.ss.erqiwwt.bean.Store;

public interface IStoreDao {
	/**
	 * 后台管理员登录
	 * @param sid
	 * @param pwd
	 * @return
	 */
	public Store login(String sid,String pwd);
	
	/**
	 * 添加店铺
	 * @param store
	 * @return
	 */
	public int add(Store store);
	
	/**
	 * 分页查询
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public List<Store> findByPage(Integer pageNo,Integer pageSize);
	
	/**
	 * 获取总记录数
	 * @return
	 */
	public int total();
	
	/**
	 * 修改状态
	 * @param sid
	 * @param status
	 * @param reason
	 * @return
	 */
	public int update(String sid,String status,String reason);
	
	public List<Store> find(Map<String,String> map,Integer pageNo,Integer pageSize);
}

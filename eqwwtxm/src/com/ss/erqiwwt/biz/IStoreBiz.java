package com.ss.erqiwwt.biz;

import java.util.List;
import java.util.Map;

import com.ss.erqiwwt.bean.Store;

public interface IStoreBiz {
	/**
	 * 后台管理员登录
	 * @param aname
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
	public Map<String,Object> findByPage(Integer pageNo,Integer pageSize);
	
	/**
	 * 修改状态
	 * @param sid
	 * @param status
	 * @param reason
	 * @return
	 */
	public int update(String sid,String status,String reason);
	
	/**
	 * 查找
	 * @param map
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public List<Store> find(Map<String,String> map,Integer pageNo,Integer pageSize);
}

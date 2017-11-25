package com.ss.erqiwwt.dao;

import java.util.List;

import com.ss.erqiwwt.bean.StoreGoods;

public interface IGoodsDao {
	/**
	 * 分页查询
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public  List<StoreGoods> findByPage(Integer pageNo,Integer pageSize);
	
	/**
	 * 总记录数
	 * @return
	 */
	public int total();
	
	/**
	 * 添加
	 * @param store
	 * @return
	 */
	public int add(StoreGoods store,Integer sid);
	
	/**
	 * 删除
	 * @param gid
	 * @return
	 */
	public int deleteGoods(String gid);
	
	/**
	 * 修改状态
	 * @param gid
	 * @param status
	 * @return
	 */
	public int update(String gid,String status);
	
	public StoreGoods findGood(String gid);
	
	public List<StoreGoods> findGod();
}

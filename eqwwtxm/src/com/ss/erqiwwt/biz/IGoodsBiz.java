package com.ss.erqiwwt.biz;

import java.util.List;
import java.util.Map;

import com.ss.erqiwwt.bean.StoreGoods;

public interface IGoodsBiz {
	/**
	 * 分页查询
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Map<String,Object> findByPage(Integer pageNo,Integer pageSize);
	
	/**
	 * 添加商品
	 * @param store
	 * @param sid 
	 * @return
	 */
	public int add(StoreGoods store, Integer sid);
	
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
	
	public StoreGoods findGood(String gid) ;
	
	public List<StoreGoods> findGod();

}

package com.ss.erqiwwt.dao;

import java.util.List;

import com.ss.erqiwwt.bean.OrderTable;

public interface IOrderInfoDao {
	/**
	 * 分页查询
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public List<OrderTable> findPage(Integer pageNo,Integer pageSize);
	
	/**
	 * 总记录数
	 * @return
	 */
	public int total();
	
	/**
	 * 修改状态
	 * @param oid
	 * @param status
	 * @return
	 */
	public int update(String oid,String status);
	
	public int deleteOrder(String oid);
}

package com.ss.erqiwwt.biz;

import java.util.Map;

public interface IOrderInfoBiz {
	/**
	 * 分页查询
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Map<String,Object> findPage(Integer pageNo,Integer pageSize);
	
	/**
	 * 修改状态
	 * @param oid
	 * @param status
	 * @return
	 */
	public int update(String oid,String status);
	
	public int deleteOrder(String oid);

}

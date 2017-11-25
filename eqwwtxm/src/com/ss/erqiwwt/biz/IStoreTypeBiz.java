package com.ss.erqiwwt.biz;

import java.util.List;
import java.util.Map;

import com.ss.erqiwwt.bean.StoreType;

public interface IStoreTypeBiz {
	/**
	 * 添加店铺类型
	 * @param stname
	 * @param discr
	 * @return
	 */
	public int addStoreType(String stname,String discr);
	
	/**
	 * 分页查询
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Map<String,Object> findStoreType(Integer pageNo,Integer pageSize);
	
	/**
	 * 删除店铺类型信息
	 * @param stids
	 * @return
	 */
	public int deleteStoreType(String stids);
	
	/**
	 * 修改店铺类型信息
	 * @param aid
	 * @param pwd
	 * @return
	 */
	public int updateStoreType(String stid,String stname,String discr);
	public List<StoreType> find(); 
}

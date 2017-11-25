package com.ss.erqiwwt.dao;

import java.util.List;
import com.ss.erqiwwt.bean.StoreType;

public interface IStoreTypeDao {
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
	public List<StoreType> findStoreType(Integer pageNo,Integer pageSize);
	
	/**
	 * 总记录数
	 * @return
	 */
	public int total();
	
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

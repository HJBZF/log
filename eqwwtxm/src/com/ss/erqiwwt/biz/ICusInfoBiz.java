package com.ss.erqiwwt.biz;

import java.util.List;
import java.util.Map;

import com.ss.erqiwwt.bean.CusInfo;
import com.ss.erqiwwt.bean.Store;


public interface ICusInfoBiz {
	
	/**
	 * 分页查询
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Map<String,Object> findCus(Integer pageNo,Integer pageSize);
	
	/*public int findUsername(String uname);
	
	public int findEmail(String email);*/
	/**
	 * 查找
	 * @param map
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public List<CusInfo> find(Map<String,String> map,Integer pageNo,Integer pageSize);
	
	/**
	 * 修改状态
	 * @param sid
	 * @param status
	 * @param reason
	 * @return
	 */
	public int update(String pwd,String status);           //形参，不用改为usid
}

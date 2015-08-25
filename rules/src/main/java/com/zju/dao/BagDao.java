package com.zju.dao;

import java.util.List;

import com.zju.model.Bag;

public interface BagDao extends GenericDao<Bag, Long> {

	/**
	 *   获取所有包节点
	 * @return
	 */
	List<Bag> getAllBags();
	
	/**
	 *   添加新节点
	 * @param bag
	 * @return
	 */
	boolean addBag(Bag bag);
	
	/**
	 *   更新包节点
	 * @param bag
	 * @return
	 */
	boolean updateBag(Bag bag);
	
	/**
	 *   删除某个包
	 * @param id
	 * @return
	 */
	boolean deleteBagByID(long id);
}

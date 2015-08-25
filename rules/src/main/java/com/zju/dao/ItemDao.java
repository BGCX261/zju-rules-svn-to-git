package com.zju.dao;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import com.zju.model.Item;

public interface ItemDao extends GenericDao<Item, Long> {

	/**
	 *   搜索某一指标的所有知识点
	 * @param indexID
	 * @return
	 */
	@Transactional
	List<Item> getItemByIndexID(long indexID);
	
	/**
	 *   根据知识点的ID索引搜索
	 * @param id
	 * @return
	 */
	@Transactional
	Item getItemByID(long id);
	
	/**
	 *   新建一条知识点
	 * @param item
	 * @return
	 */
	boolean addItem(Item item);
}

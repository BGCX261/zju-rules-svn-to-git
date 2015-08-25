package com.zju.service;

import com.zju.model.Item;

public interface ItemManager {

	/**
	 *  添加知识点并获取id
	 * @param item
	 * @return 新增知识点的id
	 */
	Long addItem(Item item);
	
	/**
	 *  该知识点是否冲突，包括已存在的情况
	 * @param item
	 * @return
	 */
	boolean isItemConflict(Item item);
}

package com.zju.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.zju.dao.BagDao;
import com.zju.model.Bag;
import com.zju.service.BagManager;

public class BagManagerImpl extends GenericManagerImpl<Bag, Long> implements BagManager {
	
	private BagDao bagDao;

	@Autowired
	public void setBagDao(BagDao bagDao) {
		this.bagDao = bagDao;
	}

	public List<Bag> getBags() {
		return bagDao.getAllBags();
	}
	
	public boolean isNull() {
		if (bagDao == null) {
			return true;
		} else {
			return false;
		}
	}
}

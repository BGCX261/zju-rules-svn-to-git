package com.zju.service;

import java.util.List;

import com.zju.model.Bag;

/**
 * Business Service Interface to handle communication between web and
 * persistence layer.
 * 
 * @author 王建平
 */
public interface BagManager extends GenericManager<Bag, Long> {

	boolean isNull();
	
	List<Bag> getBags();
}

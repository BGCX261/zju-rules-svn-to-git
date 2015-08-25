package com.zju.dao.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zju.dao.BagDao;
import com.zju.model.Bag;

@Repository
public class BagDaoHibernate extends GenericDaoHibernate<Bag, Long> implements BagDao {

	/**
     * Constructor to create a Generics-based version using bag as the entity
     */
	public BagDaoHibernate() {
		super(Bag.class);
	}

	public List<Bag> getAllBags() {
		return this.getAll();
	}

	public boolean addBag(Bag bag) {
		
		this.save(bag);
		return false;
	}

	public boolean updateBag(Bag bag) {
		
		 this.save(bag);
		 return false;
	}

	public boolean deleteBagByID(long id) {
		
		try {
			this.remove(id);
		} catch(Exception e) {
			return false;
		}
		
		return true;
	}

}

package com.zju.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.compass.annotations.SearchableId;

@Entity
@Table(name = "intlab_item")
public class Item extends BaseObject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//Primary Key
	private Long id;
	
	private Index index;	//指标
	private String value;		//数值为表达式，字符和枚举使用字符串
	private Long createUserID;
	private Date createTime;
	
	/**
     * Default constructor - creates a new instance with no values set.
     */
	public Item() {}
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @SearchableId
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH},fetch = FetchType.LAZY)
	@JoinColumn(name="index_id")
	public Index getIndex() {
		return index;
	}
	public void setIndex(Index index) {
		this.index = index;
	}

	@Column
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}

	@Column(name = "create_user_id")
	public Long getCreateUserID() {
		return createUserID;
	}
	public void setCreateUserID(Long createUserID) {
		this.createUserID = createUserID;
	}

	@Column(name = "create_time")
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return null;
	}

	@Override
	public boolean equals(Object o) {
		return false;
	}

	@Override
	public int hashCode() {
		return 0;
	}

	
}

package com.zju.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import org.compass.annotations.SearchableId;

@Entity
@Table(name = "intlab_index")
public class Index extends BaseObject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//Primary Key
	private Long id;
		
	private String name;
	private String sampleFrom;
	private String unit;
	private String type;
	private String description;
	private String dataInfo;	//历史数据统计信息
	private String enumData;
	private Long createUserID;
	private Date createTime;
	private Long modifyUserID;
	private Date modifyTime;
	private Set<Item> item = new HashSet<Item>();	//该指标的知识点列表
	private Set<IDMap> idMap = new HashSet<IDMap>();	//医院ID映射
	
	/**
     * Default constructor - creates a new instance with no values set.
     */
	public Index() {}
	
	@Id
    @SearchableId
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	@Column
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "sample_from")
	public String getSampleFrom() {
		return sampleFrom;
	}
	public void setSampleFrom(String sampleFrom) {
		this.sampleFrom = sampleFrom;
	}

	@Column
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}

	@Column
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	@Column
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "data_info")
	public String getDataInfo() {
		return dataInfo;
	}
	public void setDataInfo(String dataInfo) {
		this.dataInfo = dataInfo;
	}
	
	@Column(name = "enum_data")
	public String getEnumData() {
		return enumData;
	}
	public void setEnumData(String enumData) {
		this.enumData = enumData;
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

	@Column(name = "modify_user_id")
	public Long getModifyUserID() {
		return modifyUserID;
	}
	public void setModifyUserID(Long modifyUserID) {
		this.modifyUserID = modifyUserID;
	}

	@Column(name = "modify_time")
	public Date getModifyTime() {
		return modifyTime;
	}
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	@OneToMany(mappedBy="index")
	public Set<Item> getItem() {
		return item;
	}
	public void setItem(Set<Item> item) {
		this.item = item;
	}

	@OneToMany(mappedBy="index")
	public Set<IDMap> getIdMap() {
		return idMap;
	}
	public void setIdMap(Set<IDMap> idMap) {
		this.idMap = idMap;
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

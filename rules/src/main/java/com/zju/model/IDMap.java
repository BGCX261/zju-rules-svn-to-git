package com.zju.model;

import java.io.Serializable;

import javax.persistence.*;

import org.compass.annotations.SearchableId;

@Entity
@Table(name = "intlab_id_map")
public class IDMap extends BaseObject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//Primary Key
	private Long id;
	
	private Index index;
	private Bag bag;
	private Long HospitalID;
	private Long Hospital;
	
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

	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH},fetch = FetchType.LAZY)
	@JoinColumn(name="bag_id")
	public Bag getBag() {
		return bag;
	}
	public void setBag(Bag bag) {
		this.bag = bag;
	}
	
	@Column
	public Long getHospital() {
		return Hospital;
	}
	public void setHospital(Long hospital) {
		Hospital = hospital;
	}

	@Column(name = "hospital_id")
	public Long getHospitalID() {
		return HospitalID;
	}
	public void setHospitalID(Long hospitalID) {
		HospitalID = hospitalID;
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

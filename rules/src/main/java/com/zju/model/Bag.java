package com.zju.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.compass.annotations.SearchableId;

@Entity
@Table(name = "intlab_bag")
public class Bag extends BaseObject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//Primary Key
	private Long id;
	
	private String name;
	private Long parentID;
	private boolean isCore;
	private Set<Rule> rules = new HashSet<Rule>();
	private Set<IDMap> idMap = new HashSet<IDMap>();
	
	/**
     * Default constructor - creates a new instance with no values set.
     */
	public Bag() {}
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
	
	@Column(name = "parent_id")
	public Long getParenetID() {
		return parentID;
	}
	public void setParenetID(Long parenetID) {
		this.parentID = parenetID;
	}
	
	@Column(name = "is_core")
	public boolean isCore() {
		return isCore;
	}
	public void setCore(boolean isCore) {
		this.isCore = isCore;
	}
	
	@ManyToMany(targetEntity=Rule.class, fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinTable(
            name = "intlab_bag_rule",
            joinColumns = { @JoinColumn(name = "bag_id", referencedColumnName="id") },
            inverseJoinColumns = @JoinColumn(name = "rule_id", referencedColumnName="id")
    )
	public Set<Rule> getRules() {
		return rules;
	}
	public void setRules(Set<Rule> rules) {
		this.rules = rules;
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

	@OneToMany(mappedBy="bag",fetch=FetchType.EAGER)
	public Set<IDMap> getIdMap() {
		return idMap;
	}
	public void setIdMap(Set<IDMap> idMap) {
		this.idMap = idMap;
	}
}

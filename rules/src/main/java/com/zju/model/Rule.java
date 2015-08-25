package com.zju.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import org.compass.annotations.SearchableId;

@Entity
@Table(name = "intlab_rule")
public class Rule extends BaseObject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//Primary Key
	private Long id;
	
	private String name;
	//private String belongToID;	//多个隶属包ID用","分割
	private Set<Bag> bags = new HashSet<Bag>();
	private Set<Result> results = new HashSet<Result>();
	private Set<Item> items = new HashSet<Item>();
	private String relation;	//逻辑关系式，使用知识点ID，关系用and、or
	private double credibility;	//规则可信度，0~1
	private String description;
	private Long createUserID;
	private Date createTime;
	private Long modifyUserID;
	private Date modifyTime;
		
	/**
     * Default constructor - creates a new instance with no values set.
     */
	public Rule() {}
	
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

	@Column
	public String getRelation() {
		return relation;
	}
	public void setRelation(String relation) {
		this.relation = relation;
	}
	
	@Column
	public double getCredibility() {
		return credibility;
	}
	public void setCredibility(double credibility) {
		this.credibility = credibility;
	}
	
	@Column
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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

	@ManyToMany(targetEntity=Bag.class, fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinTable(
            name = "intlab_bag_rule",
            joinColumns = { @JoinColumn(name = "rule_id", referencedColumnName="id") },
            inverseJoinColumns = @JoinColumn(name = "bag_id", referencedColumnName="id")
    )
	public Set<Bag> getBags() {
		return bags;
	}
	public void setBags(Set<Bag> bags) {
		this.bags = bags;
	}
	
	@ManyToMany(targetEntity=Result.class, fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinTable(
            name = "intlab_rule_result",
            joinColumns = { @JoinColumn(name = "rule_id", referencedColumnName="id") },
            inverseJoinColumns = @JoinColumn(name = "result_id", referencedColumnName="id")
    )
	public Set<Result> getResults() {
		return results;
	}
	public void setResults(Set<Result> results) {
		this.results = results;
	}
	
	@ManyToMany(targetEntity=Item.class, fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinTable(
            name = "intlab_rule_item",
            joinColumns = { @JoinColumn(name = "rule_id", referencedColumnName="id") },
            inverseJoinColumns = @JoinColumn(name = "item_id", referencedColumnName="id")
    )
	public Set<Item> getItem() {
		return items;
	}
	public void setItem(Set<Item> item) {
		this.items = item;
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

package com.zju.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import org.compass.annotations.SearchableId;

@Entity
@Table(name = "intlab_result")
public class Result extends BaseObject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//Primary Key
	private Long id;
	
	private String content;
	private String level;
	private String category;
	private Long createUserID;
	private Date createTime;
	private Long modifyUserID;
	private Date modifyTime;
	private Set<Rule> rules = new HashSet<Rule>();		//使用该结果的规则
	
	/**
	 * Default constructor - creates a new instance with no values set.
	 */
	public Result() {}
	
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	@Column
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	
	@Column
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
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
	
	@ManyToMany(targetEntity=Rule.class, fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinTable(
            name = "intlab_rule_result",
            joinColumns = { @JoinColumn(name = "result_id", referencedColumnName="id") },
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
}

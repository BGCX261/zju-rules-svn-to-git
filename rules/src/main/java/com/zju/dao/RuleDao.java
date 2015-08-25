package com.zju.dao;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import com.zju.model.Rule;

public interface RuleDao extends GenericDao<Rule, Long> {

	/**
	 *  搜索一页的规则
	 * @param pageNum  	页号
	 * @param pageSize	每页显示条数 
	 * @return
	 */
	@Transactional
	List<Rule> getRules(int pageNum, int pageSize);
	
	/**
	 *  根据类别，搜索一页规则
	 * @param category  类别
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@Transactional
	List<Rule> getRulesByCategory(String category, int pageNum, int pageSize);
	
	/**
	 *  通过ID索引搜索规则
	 * @param id
	 * @return
	 */
	@Transactional
	Rule getRuleByID(long id);
	
	/**
	 *   根据规则的部分名称，模糊搜索匹配的规则
	 * @param ruleName
	 * @return
	 */
	@Transactional
	List<Rule> getRulesByName(String ruleName);
	
	/**
	 *   更新编辑的规则
	 * @param rule  更新后的规则对象
	 * @return  更新成功的结果
	 */
	boolean updateRule(Rule rule);
	
	/**
	 *   添加新规则
	 * @param rule
	 * @return
	 */
	boolean addRule(Rule rule);
	
	/**
	 *   删除规则
	 * @param id  规则ID
	 * @return
	 */
	boolean deleteRuleByID(long id);
}

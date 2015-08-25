package com.zju.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.zju.model.Result;

public interface ResultDao extends GenericDao<Result, Long> {

	/**
	 *  搜索一页的结果
	 * @param pageNum  	页号
	 * @param pageSize	每页显示条数 
	 * @return
	 */
	@Transactional
	List<Result> getResults(int pageNum, int pageSize);
	
	/**
	 *  根据类别，搜索一页结果
	 * @param category
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@Transactional
	List<Result> getResultsByCategory(String category, int pageNum, int pageSize);
	
	/**
	 *   通过ID索引搜索结果
	 * @param id
	 * @return
	 */
	@Transactional
	Result getResultByID(long id);
	
	/**
	 *   根据结果的部分内容，模糊搜索匹配的结果
	 * @param result
	 * @return
	 */
	@Transactional
	List<Result> getResultsByName(String result);
	
	/**
	 *   更新编辑的结果
	 * @param reuslt  更新后的结果对象
	 * @return  更新成功的结果
	 */
	boolean updateResult(Result result);
	
	/**
	 *   添加一条新的结果
	 * @param result
	 * @return
	 */
	boolean addResult(Result result);
	
	/**
	 *   删除一条结果
	 * @param id
	 * @return
	 */
	boolean deleteResultByID(long id);
}

package com.zju.dao;

import java.util.List;
import java.util.Map;
import org.springframework.transaction.annotation.Transactional;
import com.zju.model.Index;

public interface IndexDao extends GenericDao<Index, Long> {

	/**
	 *  搜索一页的指标
	 * @param pageNum  	页号
	 * @param pageSize	每页显示条数 
	 * @return
	 */
	@Transactional
	List<Index> getIndexs(int pageNum, int pageSize);
	
	/**
	 *   根据多个参数(样本来源、疾病种类和检验专业)
	 * @param parm
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@Transactional
	List<Index> getIndexsByCategory(Map<String, String> parm, int pageNum, int pageSize);
	
	/**
	 *   根据ID索引搜索指标
	 * @param id
	 * @return
	 */
	@Transactional
	Index getIndexByID(long id);
	
	/**
	 *   根据指标的部分名称，模糊搜索匹配的指标
	 * @param index
	 * @return
	 */
	@Transactional
	List<Index> getIndexsByName(String index);
	
	/**
	 *   更新编辑的指标
	 * @param reuslt  更新后的指标对象
	 * @return  更新成功的指标
	 */
	boolean updateIndex(Index index);
	
	/**
	 *   添加一条新的指标
	 * @param index
	 * @return
	 */
	boolean addIndex(Index index);
	
	/**
	 *   删除一条指标
	 * @param id
	 * @return
	 */
	boolean deleteIndexByID(long id);
}

package com.zju.dao;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import com.zju.model.IDMap;

public interface IDMapDao extends GenericDao<IDMap, Long> {

	/**
	 *   获取某个医院的指标ID映射
	 * @param hosp
	 * @return
	 */
	@Transactional
	List<IDMap> getIDsByHos(String hosp);
	
	/**
	 *   获取某个指标的指标ID映射
	 * @param indexID
	 * @return
	 */
	@Transactional
	List<IDMap> getIDsByIndex(String indexID);
	
	/**
	 *   更新映射项
	 * @param map
	 * @return
	 */
	boolean updateIDMap(IDMap map);
}

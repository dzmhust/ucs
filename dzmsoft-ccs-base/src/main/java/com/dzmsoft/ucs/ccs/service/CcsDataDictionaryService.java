package com.dzmsoft.ucs.ccs.service;

import java.util.List;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.dzmsoft.ucs.ccs.pojo.CcsDataDictionary;
import com.dzmsoft.ucs.ccs.pojo.CcsDataDictionaryExample;
																				
/**
 * Copyright (C), dzmsoft Co., Ltd
 * @author 
 * @date 
 *
 * @version 
 */
public interface CcsDataDictionaryService {
    /**
     * 根据类型获取数据
     * @param type
     * @return
     */
    List<CcsDataDictionary> selectByType(String type);
		
	/**
     * 根据主键判断记录是否存在
     * @dzmsoftgenerated 
     */
	boolean isExist(String id);

	/**
     * 查询符合条件的记录数量
     * @dzmsoftgenerated 
     */
	int countByExample(CcsDataDictionaryExample example);
	
	/**
     * 根据条件插入记录
     * @dzmsoftgenerated 
     */
	boolean insertSelective(CcsDataDictionary record);
	
	/**
     * 根据主键查询记录
     * @dzmsoftgenerated 
     */
	CcsDataDictionary selectByPrimaryKey(String id);
	
	/**
     * 分页查询记录
     * @dzmsoftgenerated 
     */
	PageList<CcsDataDictionary> selectByExample(CcsDataDictionaryExample example,PageBounds pageBounds);
	
	/**
     * 根据条件查询记录
     * @dzmsoftgenerated 
     */
	List<CcsDataDictionary> selectByExample(CcsDataDictionaryExample example);
	
	/**
     * 根据主键更新记录
     * @dzmsoftgenerated 
     */
	boolean updateByPrimaryKeySelective(CcsDataDictionary record);
	
	/**
     * 根据查询条件更新记录
     * @dzmsoftgenerated 
     */
	boolean updateByExampleSelective(CcsDataDictionary record,
			CcsDataDictionaryExample example);
	
	/**
     * 根据主键生成记录
     * @dzmsoftgenerated 
     */
	boolean deleteByPrimaryKey(String id);
	
	/**
	 * 根据条件删除字段信息
	 * @dzmsoftgenerated 
	 * @param example
	 * @return
	 */
	boolean deleteByExample(CcsDataDictionaryExample example);
	
		
	/**
	 * 批量删除
	 * @dzmsoftgenerated 
	 * @param idList id清单
	 * @return
	 */
	boolean deleteBatchByPrimaryKeys(List<String> idList);
	
	
}
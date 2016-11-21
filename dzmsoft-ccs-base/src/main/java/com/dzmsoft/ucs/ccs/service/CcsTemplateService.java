package com.dzmsoft.ucs.ccs.service;

import java.util.List;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.dzmsoft.ucs.ccs.pojo.CcsTemplate;
import com.dzmsoft.ucs.ccs.pojo.CcsTemplateExample;
														
/**
 * Copyright (C), dzmsoft Co., Ltd
 * @author 
 * @date 
 *
 * @version 
 */
public interface CcsTemplateService {
		
	/**
     * 根据主键判断记录是否存在
     * @dzmsoftgenerated 
     */
	boolean isExist(String id);

	/**
     * 查询符合条件的记录数量
     * @dzmsoftgenerated 
     */
	int countByExample(CcsTemplateExample example);
	
	/**
     * 根据条件插入记录
     * @dzmsoftgenerated 
     */
	boolean insertSelective(CcsTemplate record);
	
	/**
     * 根据主键查询记录
     * @dzmsoftgenerated 
     */
	CcsTemplate selectByPrimaryKey(String id);
	
	/**
     * 分页查询记录
     * @dzmsoftgenerated 
     */
	PageList<CcsTemplate> selectByExample(CcsTemplateExample example,PageBounds pageBounds);
	
	/**
     * 根据条件查询记录
     * @dzmsoftgenerated 
     */
	List<CcsTemplate> selectByExample(CcsTemplateExample example);
	
	/**
     * 根据主键更新记录
     * @dzmsoftgenerated 
     */
	boolean updateByPrimaryKeySelective(CcsTemplate record);
	
	/**
     * 根据查询条件更新记录
     * @dzmsoftgenerated 
     */
	boolean updateByExampleSelective(CcsTemplate record,
			CcsTemplateExample example);
	
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
	boolean deleteByExample(CcsTemplateExample example);
	
		
	/**
	 * 批量删除
	 * @dzmsoftgenerated 
	 * @param idList id清单
	 * @return
	 */
	boolean deleteBatchByPrimaryKeys(List<String> idList);
	
	
}
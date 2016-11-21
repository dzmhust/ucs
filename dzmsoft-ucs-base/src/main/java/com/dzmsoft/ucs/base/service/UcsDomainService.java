package com.dzmsoft.ucs.base.service;

import java.util.List;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.dzmsoft.ucs.base.pojo.UcsDomain;
import com.dzmsoft.ucs.base.pojo.UcsDomainExample;
														
/**
 * Copyright (C), dzmsoft Co., Ltd
 * @author 
 * @date 
 *
 * @version 
 */
public interface UcsDomainService {
		
	/**
     * 根据主键判断记录是否存在
     * @dzmsoftgenerated 
     */
	boolean isExist(String id);

	/**
     * 查询符合条件的记录数量
     * @dzmsoftgenerated 
     */
	int countByExample(UcsDomainExample example);
	
	/**
     * 根据条件插入记录
     * @dzmsoftgenerated 
     */
	boolean insertSelective(UcsDomain record);
	
	/**
     * 根据主键查询记录
     * @dzmsoftgenerated 
     */
	UcsDomain selectByPrimaryKey(String id);
	
	/**
     * 分页查询记录
     * @dzmsoftgenerated 
     */
	PageList<UcsDomain> selectByExample(UcsDomainExample example,PageBounds pageBounds);
	
	/**
     * 根据条件查询记录
     * @dzmsoftgenerated 
     */
	List<UcsDomain> selectByExample(UcsDomainExample example);
	
	/**
     * 根据主键更新记录
     * @dzmsoftgenerated 
     */
	boolean updateByPrimaryKeySelective(UcsDomain record);
	
	/**
     * 根据查询条件更新记录
     * @dzmsoftgenerated 
     */
	boolean updateByExampleSelective(UcsDomain record,
			UcsDomainExample example);
	
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
	boolean deleteByExample(UcsDomainExample example);
	
		
	/**
	 * 批量删除
	 * @dzmsoftgenerated 
	 * @param idList id清单
	 * @return
	 */
	boolean deleteBatchByPrimaryKeys(List<String> idList);
	
	
}
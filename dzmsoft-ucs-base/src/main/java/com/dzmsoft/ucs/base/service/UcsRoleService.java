package com.dzmsoft.ucs.base.service;

import java.util.List;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.dzmsoft.ucs.base.pojo.UcsRole;
import com.dzmsoft.ucs.base.pojo.UcsRoleExample;

/**
 * Copyright (C), dzmsoft Co., Ltd
 * @author 
 * @date 
 *
 * @version 
 */
public interface UcsRoleService {
	
	/**
     * 查询符合条件的记录数量
     * @dzmsoftgenerated 
     */
	int countByExample(UcsRoleExample example);
	
	/**
     * 根据条件插入记录
     * @dzmsoftgenerated 
     */
	int insertSelective(UcsRole record);
	
	/**
     * 根据主键查询记录
     * @dzmsoftgenerated 
     */
	UcsRole selectByPrimaryKey(String id);
	
	/**
     * 分页查询记录
     * @dzmsoftgenerated 
     */
	PageList<UcsRole> selectByExample(UcsRoleExample example,PageBounds pageBounds);
	
	/**
     * 根据条件查询记录
     * @dzmsoftgenerated 
     */
	List<UcsRole> selectByExample(UcsRoleExample example);
	
	/**
     * 根据主键更新记录
     * @dzmsoftgenerated 
     */
	int updateByPrimaryKeySelective(UcsRole record);
	
	/**
     * 根据查询条件更新记录
     * @dzmsoftgenerated 
     */
	int updateByExampleSelective(UcsRole record,
			UcsRoleExample example);
	
	/**
     * 根据主键生成记录
     * @dzmsoftgenerated 
     */
	int deleteByPrimaryKey(String id);
	
	/**
	 * 根据条件删除字段信息
	 * @dzmsoftgenerated 
	 * @param example
	 * @return
	 */
	int deleteByExample(UcsRoleExample example);
	
		
	
}
package com.dzmsoft.ucs.base.service;

import java.util.List;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.dzmsoft.ucs.base.pojo.UcsUser;
import com.dzmsoft.ucs.base.pojo.UcsUserExample;

/**
 * Copyright (C), dzmsoft Co., Ltd
 * @author 
 * @date 
 *
 * @version 
 */
public interface UcsUserService {
    
    /**
     * 修改密码
     * @param id
     * @param password
     * @return
     */
    int updatePassword(String id, String password);
    /**
     * 根据用户名获取用户信息
     * @param username
     * @return
     */
    UcsUser selectByUsername(String username);
	
	/**
     * 查询符合条件的记录数量
     * @dzmsoftgenerated 
     */
	int countByExample(UcsUserExample example);
	
	/**
     * 根据条件插入记录
     * @dzmsoftgenerated 
     */
	int insertSelective(UcsUser record);
	
	/**
     * 根据主键查询记录
     * @dzmsoftgenerated 
     */
	UcsUser selectByPrimaryKey(String id);
	
	/**
     * 分页查询记录
     * @dzmsoftgenerated 
     */
	PageList<UcsUser> selectByExample(UcsUserExample example,PageBounds pageBounds);
	
	/**
     * 根据条件查询记录
     * @dzmsoftgenerated 
     */
	List<UcsUser> selectByExample(UcsUserExample example);
	
	/**
     * 根据主键更新记录
     * @dzmsoftgenerated 
     */
	int updateByPrimaryKeySelective(UcsUser record);
	
	/**
     * 根据查询条件更新记录
     * @dzmsoftgenerated 
     */
	int updateByExampleSelective(UcsUser record,
			UcsUserExample example);
	
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
	int deleteByExample(UcsUserExample example);
	
		
	
}
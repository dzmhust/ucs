package com.dzmsoft.ucs.base.service;

import java.util.List;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.dzmsoft.ucs.base.pojo.UcsPermission;
import com.dzmsoft.ucs.base.pojo.UcsPermissionExample;

/**
 * Copyright (C), dzmsoft Co., Ltd
 * @author 
 * @date 
 *
 * @version 
 */
public interface UcsPermissionService {
    /**
     * 获取菜单清单
     * @param userId
     * @param domain
     * @return
     */
    List<UcsPermission> selectMenusByUser(String userId, String domain);
    /**
     * 获取权限清单
     * @param userId
     * @param domain
     * @return
     */
    List<String> selectPermissions(String userId);
    /**
     * 获取权限清单
     * @param userId 用户id
     * @param domain 所属系统
     * @return
     */
    List<String> selectPermissions(String userId, String domain);
    
    /**
     * 根据用户获取权限
     * @param userId 用户id
     * @return
     */
    List<UcsPermission> selectPermissionsByUser(String userId);
    
    /**
     * 根据用户获取权限
     * @param userId 用户id
     * @param domain 所属系统
     * @return
     */
    List<UcsPermission> selectPermissionsByUser(String userId, String domain);
	
	/**
     * 查询符合条件的记录数量
     * @dzmsoftgenerated 
     */
	int countByExample(UcsPermissionExample example);
	
	/**
     * 根据条件插入记录
     * @dzmsoftgenerated 
     */
	int insertSelective(UcsPermission record);
	
	/**
     * 根据主键查询记录
     * @dzmsoftgenerated 
     */
	UcsPermission selectByPrimaryKey(String id);
	
	/**
     * 分页查询记录
     * @dzmsoftgenerated 
     */
	PageList<UcsPermission> selectByExample(UcsPermissionExample example,PageBounds pageBounds);
	
	/**
     * 根据条件查询记录
     * @dzmsoftgenerated 
     */
	List<UcsPermission> selectByExample(UcsPermissionExample example);
	
	/**
     * 根据主键更新记录
     * @dzmsoftgenerated 
     */
	int updateByPrimaryKeySelective(UcsPermission record);
	
	/**
     * 根据查询条件更新记录
     * @dzmsoftgenerated 
     */
	int updateByExampleSelective(UcsPermission record,
			UcsPermissionExample example);
	
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
	int deleteByExample(UcsPermissionExample example);
	
		
	
}
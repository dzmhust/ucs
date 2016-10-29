package com.dzmsoft.ucs.base.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dzmsoft.framework.base.common.BaseConstant;
import com.dzmsoft.framework.base.util.CheckEmptyUtil;
import com.dzmsoft.framework.base.util.StringUtil;
import com.dzmsoft.ucs.base.common.UcsBaseConstant;
import com.dzmsoft.ucs.base.dao.UcsPermissionMapper;
import com.dzmsoft.ucs.base.pojo.UcsPermission;
import com.dzmsoft.ucs.base.pojo.UcsPermissionExample;
import com.dzmsoft.ucs.base.pojo.UcsUserExample;
import com.dzmsoft.ucs.base.pojo.udf.UcsUserPermissionExample;
import com.dzmsoft.ucs.base.service.UcsPermissionService;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
/**
 * Copyright (C), dzmsoft Co., Ltd
 * @author 
 * @date 
 *
 * @version 
 */
@Service
@Transactional(readOnly = true)
public class UcsPermissionServiceImpl implements UcsPermissionService{

	@Autowired
	private UcsPermissionMapper ucsPermissionMapper;
	
	@Override
	public List<UcsPermission> selectMenusByUser(String userId, String domain) {
	    UcsUserPermissionExample example = new UcsUserPermissionExample();
        //
        UcsUserExample.Criteria ucsUserCriteria = example.getUcsUserExample().createCriteria();
        ucsUserCriteria.andIdEqualTo(userId);
        //
        com.dzmsoft.ucs.base.pojo.UcsRolePermissionExample.Criteria ucsRolePermissionCriteria = example.getUcsRolePermissionExample().createCriteria();
        ucsRolePermissionCriteria.andDomainEqualTo(domain);
        //
        UcsPermissionExample.Criteria ucsPermissionCriteria = example.getUcsPermissionExample().createCriteria();
        ucsPermissionCriteria.andStatusEqualTo(BaseConstant.Status.ENABLE);
        ucsPermissionCriteria.andDomainEqualTo(domain);
        List<String> typeList= new ArrayList<String>();
        typeList.add(UcsBaseConstant.PermissionType.MAIN);
        typeList.add(UcsBaseConstant.PermissionType.SUB);
        ucsPermissionCriteria.andTypeIn(typeList);
        return ucsPermissionMapper.selectPermissionsByUser(example);
	}
	
	@Override
	public List<String> selectPermissions(String userId) {
	    return selectPermissions(userId, null);
	}
	
	@Override
	public List<String> selectPermissions(String userId, String domain) {
	    List<UcsPermission> ucsPermissions = selectPermissionsByUser(userId, domain);
        List<String> permissions = null;
        if (!CheckEmptyUtil.isEmpty(ucsPermissions)){
            permissions = new ArrayList<String>();
            for(UcsPermission permission:ucsPermissions){
                if(UcsBaseConstant.PermissionType.BUTTON.equals(permission.getType())){
                    permissions.add(permission.getUrl());
                }
            }
        }
        return permissions;
	}
	
	@Override
	public List<UcsPermission> selectPermissionsByUser(String userId) {
	    return selectPermissionsByUser(userId, null);
	}
	
	@Override
	public List<UcsPermission> selectPermissionsByUser(String userId, String domain) {
	    UcsUserPermissionExample example = new UcsUserPermissionExample();
        UcsUserExample.Criteria criteria = example.getUcsUserExample().createCriteria();
        criteria.andIdEqualTo(userId);
        if (!CheckEmptyUtil.isEmpty(domain)){
            criteria.andDomainEqualTo(domain) ;
        }
        criteria.andStatusEqualTo(BaseConstant.Status.ENABLE);
        UcsPermissionExample.Criteria pCriteria = example.getUcsPermissionExample().createCriteria();
        pCriteria.andTypeEqualTo(UcsBaseConstant.PermissionType.BUTTON);
        return ucsPermissionMapper.selectPermissionsByUser(example);
	}
		
	/**
     * 查询符合条件的记录数量
     * @dzmsoftgenerated 
     */
    @Override
	public int countByExample(UcsPermissionExample example){
		return ucsPermissionMapper.countByExample(example);
	}

	/**
     * 根据条件插入记录
     * @dzmsoftgenerated 
     */
    @Transactional(readOnly = false)
    @Override
	public int insertSelective(UcsPermission record){
				record.setId(StringUtil.getUuidString());
				return ucsPermissionMapper.insertSelective(record);
	}
	
	/**
     * 根据主键查询记录
     * @dzmsoftgenerated 
     */
    @Override
	public UcsPermission selectByPrimaryKey(String id){
		return ucsPermissionMapper.selectByPrimaryKey(id);
	}
	
	/**
     * 分页查询记录
     * @dzmsoftgenerated 
     */
    @Override
	public PageList<UcsPermission> selectByExample(UcsPermissionExample example,PageBounds pageBounds){
		return ucsPermissionMapper.selectByExample(example, pageBounds);
	}
	
	/**
     * 根据条件查询记录
     * @dzmsoftgenerated 
     */
    @Override
	public List<UcsPermission> selectByExample(UcsPermissionExample example){
		return ucsPermissionMapper.selectByExample(example);
	}
	
	/**
     * 根据主键更新记录
     * @dzmsoftgenerated 
     */
    @Transactional(readOnly = false)
    @Override
	public int updateByPrimaryKeySelective(UcsPermission record){
		return ucsPermissionMapper.updateByPrimaryKeySelective(record);
	}
	
	/**
     * 根据查询条件更新记录
     * @dzmsoftgenerated 
     */
    @Transactional(readOnly = false)
    @Override
	public int updateByExampleSelective(UcsPermission record,
			UcsPermissionExample example){
		return ucsPermissionMapper.updateByExampleSelective(record, example);
	}
	
	/**
     * 根据主键生成记录
     * @dzmsoftgenerated 
     */
    @Transactional(readOnly = false)
    @Override
	public int deleteByPrimaryKey(String id){
		return ucsPermissionMapper.deleteByPrimaryKey(id);
	}
	
	/**
	 * 根据条件删除字段信息
	 * @dzmsoftgenerated 
	 * @param example
	 * @return
	 */
	@Transactional(readOnly = false)
	@Override
	public int deleteByExample(UcsPermissionExample example){
		return ucsPermissionMapper.deleteByExample(example);
	}
	
	}
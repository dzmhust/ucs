package com.dzmsoft.ucs.base.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.dzmsoft.ucs.base.pojo.UcsUserRole;
import com.dzmsoft.ucs.base.pojo.UcsUserRoleExample;
import com.dzmsoft.ucs.base.dao.UcsUserRoleMapper;
import com.dzmsoft.ucs.base.service.UcsUserRoleService;
import com.dzmsoft.framework.base.util.StringUtil;
/**
 * Copyright (C), dzmsoft Co., Ltd
 * @author 
 * @date 
 *
 * @version 
 */
@Service
@Transactional(readOnly = true)
public class UcsUserRoleServiceImpl implements UcsUserRoleService{

	@Autowired
	private UcsUserRoleMapper ucsUserRoleMapper;
	
		
	/**
     * 查询符合条件的记录数量
     * @dzmsoftgenerated 
     */
    @Override
	public int countByExample(UcsUserRoleExample example){
		return ucsUserRoleMapper.countByExample(example);
	}

	/**
     * 根据条件插入记录
     * @dzmsoftgenerated 
     */
    @Transactional(readOnly = false)
    @Override
	public int insertSelective(UcsUserRole record){
				record.setId(StringUtil.getUuidString());
				return ucsUserRoleMapper.insertSelective(record);
	}
	
	/**
     * 根据主键查询记录
     * @dzmsoftgenerated 
     */
    @Override
	public UcsUserRole selectByPrimaryKey(String id){
		return ucsUserRoleMapper.selectByPrimaryKey(id);
	}
	
	/**
     * 分页查询记录
     * @dzmsoftgenerated 
     */
    @Override
	public PageList<UcsUserRole> selectByExample(UcsUserRoleExample example,PageBounds pageBounds){
		return ucsUserRoleMapper.selectByExample(example, pageBounds);
	}
	
	/**
     * 根据条件查询记录
     * @dzmsoftgenerated 
     */
    @Override
	public List<UcsUserRole> selectByExample(UcsUserRoleExample example){
		return ucsUserRoleMapper.selectByExample(example);
	}
	
	/**
     * 根据主键更新记录
     * @dzmsoftgenerated 
     */
    @Transactional(readOnly = false)
    @Override
	public int updateByPrimaryKeySelective(UcsUserRole record){
		return ucsUserRoleMapper.updateByPrimaryKeySelective(record);
	}
	
	/**
     * 根据查询条件更新记录
     * @dzmsoftgenerated 
     */
    @Transactional(readOnly = false)
    @Override
	public int updateByExampleSelective(UcsUserRole record,
			UcsUserRoleExample example){
		return ucsUserRoleMapper.updateByExampleSelective(record, example);
	}
	
	/**
     * 根据主键生成记录
     * @dzmsoftgenerated 
     */
    @Transactional(readOnly = false)
    @Override
	public int deleteByPrimaryKey(String id){
		return ucsUserRoleMapper.deleteByPrimaryKey(id);
	}
	
	/**
	 * 根据条件删除字段信息
	 * @dzmsoftgenerated 
	 * @param example
	 * @return
	 */
	@Transactional(readOnly = false)
	@Override
	public int deleteByExample(UcsUserRoleExample example){
		return ucsUserRoleMapper.deleteByExample(example);
	}
	
	}
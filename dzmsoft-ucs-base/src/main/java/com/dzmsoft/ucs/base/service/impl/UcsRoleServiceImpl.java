package com.dzmsoft.ucs.base.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.dzmsoft.ucs.base.pojo.UcsRole;
import com.dzmsoft.ucs.base.pojo.UcsRoleExample;
import com.dzmsoft.ucs.base.dao.UcsRoleMapper;
import com.dzmsoft.ucs.base.service.UcsRoleService;
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
public class UcsRoleServiceImpl implements UcsRoleService{

	@Autowired
	private UcsRoleMapper ucsRoleMapper;
	
		
	/**
     * 查询符合条件的记录数量
     * @dzmsoftgenerated 
     */
    @Override
	public int countByExample(UcsRoleExample example){
		return ucsRoleMapper.countByExample(example);
	}

	/**
     * 根据条件插入记录
     * @dzmsoftgenerated 
     */
    @Transactional(readOnly = false)
    @Override
	public int insertSelective(UcsRole record){
				record.setId(StringUtil.getUuidString());
				return ucsRoleMapper.insertSelective(record);
	}
	
	/**
     * 根据主键查询记录
     * @dzmsoftgenerated 
     */
    @Override
	public UcsRole selectByPrimaryKey(String id){
		return ucsRoleMapper.selectByPrimaryKey(id);
	}
	
	/**
     * 分页查询记录
     * @dzmsoftgenerated 
     */
    @Override
	public PageList<UcsRole> selectByExample(UcsRoleExample example,PageBounds pageBounds){
		return ucsRoleMapper.selectByExample(example, pageBounds);
	}
	
	/**
     * 根据条件查询记录
     * @dzmsoftgenerated 
     */
    @Override
	public List<UcsRole> selectByExample(UcsRoleExample example){
		return ucsRoleMapper.selectByExample(example);
	}
	
	/**
     * 根据主键更新记录
     * @dzmsoftgenerated 
     */
    @Transactional(readOnly = false)
    @Override
	public int updateByPrimaryKeySelective(UcsRole record){
		return ucsRoleMapper.updateByPrimaryKeySelective(record);
	}
	
	/**
     * 根据查询条件更新记录
     * @dzmsoftgenerated 
     */
    @Transactional(readOnly = false)
    @Override
	public int updateByExampleSelective(UcsRole record,
			UcsRoleExample example){
		return ucsRoleMapper.updateByExampleSelective(record, example);
	}
	
	/**
     * 根据主键生成记录
     * @dzmsoftgenerated 
     */
    @Transactional(readOnly = false)
    @Override
	public int deleteByPrimaryKey(String id){
		return ucsRoleMapper.deleteByPrimaryKey(id);
	}
	
	/**
	 * 根据条件删除字段信息
	 * @dzmsoftgenerated 
	 * @param example
	 * @return
	 */
	@Transactional(readOnly = false)
	@Override
	public int deleteByExample(UcsRoleExample example){
		return ucsRoleMapper.deleteByExample(example);
	}
	
	}
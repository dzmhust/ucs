package com.dzmsoft.ucs.base.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.dzmsoft.ucs.base.pojo.UcsDomain;
import com.dzmsoft.ucs.base.pojo.UcsDomainExample;
import com.dzmsoft.ucs.base.dao.UcsDomainMapper;
import com.dzmsoft.ucs.base.service.UcsDomainService;
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
public class UcsDomainServiceImpl implements UcsDomainService{

	@Autowired
	private UcsDomainMapper ucsDomainMapper;
	
		
	/**
     * 根据主键判断记录是否存在
     * @dzmsoftgenerated 
     */
	@Override
	public boolean isExist(String id) {
	    UcsDomainExample example = new UcsDomainExample();
	    UcsDomainExample.Criteria criteria = example.createCriteria();
	    criteria.andIdEqualTo(id);
	    int count = countByExample(example);
	    return count>0?true:false;
	}
	
	/**
     * 查询符合条件的记录数量
     * @dzmsoftgenerated 
     */
    @Override
	public int countByExample(UcsDomainExample example){
		return ucsDomainMapper.countByExample(example);
	}

	/**
     * 根据条件插入记录
     * @dzmsoftgenerated 
     */
    @Transactional(readOnly = false)
    @Override
	public int insertSelective(UcsDomain record){
				record.setId(StringUtil.getUuidString());
				return ucsDomainMapper.insertSelective(record);
	}
	
	/**
     * 根据主键查询记录
     * @dzmsoftgenerated 
     */
    @Override
	public UcsDomain selectByPrimaryKey(String id){
		return ucsDomainMapper.selectByPrimaryKey(id);
	}
	
	/**
     * 分页查询记录
     * @dzmsoftgenerated 
     */
    @Override
	public PageList<UcsDomain> selectByExample(UcsDomainExample example,PageBounds pageBounds){
		return ucsDomainMapper.selectByExample(example, pageBounds);
	}
	
	/**
     * 根据条件查询记录
     * @dzmsoftgenerated 
     */
    @Override
	public List<UcsDomain> selectByExample(UcsDomainExample example){
		return ucsDomainMapper.selectByExample(example);
	}
	
	/**
     * 根据主键更新记录
     * @dzmsoftgenerated 
     */
    @Transactional(readOnly = false)
    @Override
	public int updateByPrimaryKeySelective(UcsDomain record){
		return ucsDomainMapper.updateByPrimaryKeySelective(record);
	}
	
	/**
     * 根据查询条件更新记录
     * @dzmsoftgenerated 
     */
    @Transactional(readOnly = false)
    @Override
	public int updateByExampleSelective(UcsDomain record,
			UcsDomainExample example){
		return ucsDomainMapper.updateByExampleSelective(record, example);
	}
	
	/**
     * 根据主键生成记录
     * @dzmsoftgenerated 
     */
    @Transactional(readOnly = false)
    @Override
	public int deleteByPrimaryKey(String id){
		return ucsDomainMapper.deleteByPrimaryKey(id);
	}
	
	/**
	 * 根据条件删除字段信息
	 * @dzmsoftgenerated 
	 * @param example
	 * @return
	 */
	@Transactional(readOnly = false)
	@Override
	public int deleteByExample(UcsDomainExample example){
		return ucsDomainMapper.deleteByExample(example);
	}
	
	}
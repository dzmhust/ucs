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
import com.dzmsoft.framework.base.util.CheckEmptyUtil;
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
	public boolean insertSelective(UcsDomain record){
				record.setId(StringUtil.getUuidString());
				int flag = ucsDomainMapper.insertSelective(record);
		return flag>0?true:false;
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
	public boolean updateByPrimaryKeySelective(UcsDomain record){
		int flag = ucsDomainMapper.updateByPrimaryKeySelective(record);
		return flag>0?true:false;
	}
	
	/**
     * 根据查询条件更新记录
     * @dzmsoftgenerated 
     */
    @Transactional(readOnly = false)
    @Override
	public boolean updateByExampleSelective(UcsDomain record,UcsDomainExample example){
		int flag = ucsDomainMapper.updateByExampleSelective(record, example);
		return flag>0?true:false;
	}
	
	/**
     * 根据主键生成记录
     * @dzmsoftgenerated 
     */
    @Transactional(readOnly = false)
    @Override
	public boolean deleteByPrimaryKey(String id){
		int flag = ucsDomainMapper.deleteByPrimaryKey(id);
		return flag>0?true:false;
	}
	
	/**
	 * 根据条件删除字段信息
	 * @dzmsoftgenerated 
	 * @param example
	 * @return
	 */
	@Transactional(readOnly = false)
	@Override
	public boolean deleteByExample(UcsDomainExample example){
		int flag = ucsDomainMapper.deleteByExample(example);
		return flag>0?true:false;
	}
	
		
	/**
	 * 批量删除
	 * @dzmsoftgenerated 
	 * @param id
	 * @return
	 */
	@Transactional(readOnly = false)
    @Override
    public boolean deleteBatchByPrimaryKeys(List<String> idList) {
        if (CheckEmptyUtil.isEmpty(idList)){
            return true;
        }
        UcsDomainExample example = new UcsDomainExample();
        UcsDomainExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(idList);
        return deleteByExample(example);
    }
}
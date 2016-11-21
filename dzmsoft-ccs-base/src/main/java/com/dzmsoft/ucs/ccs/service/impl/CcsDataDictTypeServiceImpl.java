package com.dzmsoft.ucs.ccs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.dzmsoft.ucs.ccs.pojo.CcsDataDictType;
import com.dzmsoft.ucs.ccs.pojo.CcsDataDictTypeExample;
import com.dzmsoft.ucs.ccs.dao.CcsDataDictTypeMapper;
import com.dzmsoft.ucs.ccs.service.CcsDataDictTypeService;
import com.dzmsoft.framework.base.util.CheckEmptyUtil;
												/**
 * Copyright (C), dzmsoft Co., Ltd
 * @author 
 * @date 
 *
 * @version 
 */
@Service
@Transactional(readOnly = true)
public class CcsDataDictTypeServiceImpl implements CcsDataDictTypeService{

	@Autowired
	private CcsDataDictTypeMapper ccsDataDictTypeMapper;
	
		
	/**
     * 根据主键判断记录是否存在
     * @dzmsoftgenerated 
     */
	@Override
	public boolean isExist(String id) {
	    CcsDataDictTypeExample example = new CcsDataDictTypeExample();
	    CcsDataDictTypeExample.Criteria criteria = example.createCriteria();
	    criteria.andIdEqualTo(id);
	    int count = countByExample(example);
	    return count>0?true:false;
	}
	
	/**
     * 查询符合条件的记录数量
     * @dzmsoftgenerated 
     */
    @Override
	public int countByExample(CcsDataDictTypeExample example){
		return ccsDataDictTypeMapper.countByExample(example);
	}

	/**
     * 根据条件插入记录
     * @dzmsoftgenerated 
     */
    @Transactional(readOnly = false)
    @Override
	public boolean insertSelective(CcsDataDictType record){
				int flag = ccsDataDictTypeMapper.insertSelective(record);
		return flag>0?true:false;
	}
	
	/**
     * 根据主键查询记录
     * @dzmsoftgenerated 
     */
    @Override
	public CcsDataDictType selectByPrimaryKey(String id){
		return ccsDataDictTypeMapper.selectByPrimaryKey(id);
	}
	
	/**
     * 分页查询记录
     * @dzmsoftgenerated 
     */
    @Override
	public PageList<CcsDataDictType> selectByExample(CcsDataDictTypeExample example,PageBounds pageBounds){
		return ccsDataDictTypeMapper.selectByExample(example, pageBounds);
	}
	
	/**
     * 根据条件查询记录
     * @dzmsoftgenerated 
     */
    @Override
	public List<CcsDataDictType> selectByExample(CcsDataDictTypeExample example){
		return ccsDataDictTypeMapper.selectByExample(example);
	}
	
	/**
     * 根据主键更新记录
     * @dzmsoftgenerated 
     */
    @Transactional(readOnly = false)
    @Override
	public boolean updateByPrimaryKeySelective(CcsDataDictType record){
		int flag = ccsDataDictTypeMapper.updateByPrimaryKeySelective(record);
		return flag>0?true:false;
	}
	
	/**
     * 根据查询条件更新记录
     * @dzmsoftgenerated 
     */
    @Transactional(readOnly = false)
    @Override
	public boolean updateByExampleSelective(CcsDataDictType record,CcsDataDictTypeExample example){
		int flag = ccsDataDictTypeMapper.updateByExampleSelective(record, example);
		return flag>0?true:false;
	}
	
	/**
     * 根据主键生成记录
     * @dzmsoftgenerated 
     */
    @Transactional(readOnly = false)
    @Override
	public boolean deleteByPrimaryKey(String id){
		int flag = ccsDataDictTypeMapper.deleteByPrimaryKey(id);
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
	public boolean deleteByExample(CcsDataDictTypeExample example){
		int flag = ccsDataDictTypeMapper.deleteByExample(example);
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
        CcsDataDictTypeExample example = new CcsDataDictTypeExample();
        CcsDataDictTypeExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(idList);
        return deleteByExample(example);
    }
}
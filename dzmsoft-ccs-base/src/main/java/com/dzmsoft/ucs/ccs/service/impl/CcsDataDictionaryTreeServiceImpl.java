package com.dzmsoft.ucs.ccs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.dzmsoft.ucs.ccs.pojo.CcsDataDictionaryTree;
import com.dzmsoft.ucs.ccs.pojo.CcsDataDictionaryTreeExample;
import com.dzmsoft.ucs.ccs.dao.CcsDataDictionaryTreeMapper;
import com.dzmsoft.ucs.ccs.service.CcsDataDictionaryTreeService;
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
public class CcsDataDictionaryTreeServiceImpl implements CcsDataDictionaryTreeService{

	@Autowired
	private CcsDataDictionaryTreeMapper ccsDataDictionaryTreeMapper;
	
		
	/**
     * 根据主键判断记录是否存在
     * @dzmsoftgenerated 
     */
	@Override
	public boolean isExist(String id) {
	    CcsDataDictionaryTreeExample example = new CcsDataDictionaryTreeExample();
	    CcsDataDictionaryTreeExample.Criteria criteria = example.createCriteria();
	    criteria.andIdEqualTo(id);
	    int count = countByExample(example);
	    return count>0?true:false;
	}
	
	/**
     * 查询符合条件的记录数量
     * @dzmsoftgenerated 
     */
    @Override
	public int countByExample(CcsDataDictionaryTreeExample example){
		return ccsDataDictionaryTreeMapper.countByExample(example);
	}

	/**
     * 根据条件插入记录
     * @dzmsoftgenerated 
     */
    @Transactional(readOnly = false)
    @Override
	public boolean insertSelective(CcsDataDictionaryTree record){
				int flag = ccsDataDictionaryTreeMapper.insertSelective(record);
		return flag>0?true:false;
	}
	
	/**
     * 根据主键查询记录
     * @dzmsoftgenerated 
     */
    @Override
	public CcsDataDictionaryTree selectByPrimaryKey(String id){
		return ccsDataDictionaryTreeMapper.selectByPrimaryKey(id);
	}
	
	/**
     * 分页查询记录
     * @dzmsoftgenerated 
     */
    @Override
	public PageList<CcsDataDictionaryTree> selectByExample(CcsDataDictionaryTreeExample example,PageBounds pageBounds){
		return ccsDataDictionaryTreeMapper.selectByExample(example, pageBounds);
	}
	
	/**
     * 根据条件查询记录
     * @dzmsoftgenerated 
     */
    @Override
	public List<CcsDataDictionaryTree> selectByExample(CcsDataDictionaryTreeExample example){
		return ccsDataDictionaryTreeMapper.selectByExample(example);
	}
	
	/**
     * 根据主键更新记录
     * @dzmsoftgenerated 
     */
    @Transactional(readOnly = false)
    @Override
	public boolean updateByPrimaryKeySelective(CcsDataDictionaryTree record){
		int flag = ccsDataDictionaryTreeMapper.updateByPrimaryKeySelective(record);
		return flag>0?true:false;
	}
	
	/**
     * 根据查询条件更新记录
     * @dzmsoftgenerated 
     */
    @Transactional(readOnly = false)
    @Override
	public boolean updateByExampleSelective(CcsDataDictionaryTree record,CcsDataDictionaryTreeExample example){
		int flag = ccsDataDictionaryTreeMapper.updateByExampleSelective(record, example);
		return flag>0?true:false;
	}
	
	/**
     * 根据主键生成记录
     * @dzmsoftgenerated 
     */
    @Transactional(readOnly = false)
    @Override
	public boolean deleteByPrimaryKey(String id){
		int flag = ccsDataDictionaryTreeMapper.deleteByPrimaryKey(id);
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
	public boolean deleteByExample(CcsDataDictionaryTreeExample example){
		int flag = ccsDataDictionaryTreeMapper.deleteByExample(example);
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
        CcsDataDictionaryTreeExample example = new CcsDataDictionaryTreeExample();
        CcsDataDictionaryTreeExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(idList);
        return deleteByExample(example);
    }
}
package com.dzmsoft.ucs.base.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dzmsoft.framework.base.common.BaseConstant;
import com.dzmsoft.framework.base.util.CheckEmptyUtil;
import com.dzmsoft.framework.base.util.StringUtil;
import com.dzmsoft.framework.base.util.security.DigestsUtil;
import com.dzmsoft.framework.base.util.security.EncodesUtil;
import com.dzmsoft.ucs.base.dao.UcsUserMapper;
import com.dzmsoft.ucs.base.pojo.UcsUser;
import com.dzmsoft.ucs.base.pojo.UcsUserExample;
import com.dzmsoft.ucs.base.service.UcsUserService;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

/**
 * Copyright (C), dzmsoft Co., Ltd
 * 
 * @author
 * @date
 * @version
 */
@Service
@Transactional(readOnly = true)
public class UcsUserServiceImpl implements UcsUserService {

    @Value("${hashAlgorithmName}")
    private String hashAlgorithmName;

    @Value("${hashIterations}")
    private Integer hashIterations;

    @Value("${saltSize}")
    private Integer saltSize;

    @Autowired
    private UcsUserMapper ucsUserMapper;
    
    @Transactional(readOnly = false)
    @Override
    public int updatePwd(String id, String password) {
        //
        UcsUser record = new UcsUser();
        record.setId(id);
        record.setPassword(password);
        entryptPassword(record);
        //
        return updateByPrimaryKeySelective(record);
    }

    @Transactional(readOnly = false)
    @Override
    public int updatePassword(String id, String password) {
        //
        UcsUser record = new UcsUser();
        record.setId(id);
        record.setPassword(password);
        entryptPassword(record);
        //
        return updateByPrimaryKeySelective(record);
    }

    /**
     * 对用户的密码进行加密
     * 
     * @param record
     *            用户记录
     */
    private void entryptPassword(UcsUser record) {
        byte[] salt = DigestsUtil.generateSalt(saltSize);
        record.setSalt(EncodesUtil.encodeHex(salt));
        String newPassword = new SimpleHash(hashAlgorithmName, record.getPassword(),
                ByteSource.Util.bytes(record.getSalt()), hashIterations).toHex();
        record.setPassword(newPassword);
    }

    @Override
    public UcsUser selectByUsername(String username) {
        UcsUserExample example = new UcsUserExample();
        UcsUserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        criteria.andStatusEqualTo(BaseConstant.Status.ENABLE);
        List<UcsUser> ucsUsers = selectByExample(example);
        return CheckEmptyUtil.isEmpty(ucsUsers) ? null : ucsUsers.get(0);
    }

    /**
     * 查询符合条件的记录数量
     * 
     * @dzmsoftgenerated
     */
    @Override
    public int countByExample(UcsUserExample example) {
        return ucsUserMapper.countByExample(example);
    }

    /**
     * 根据条件插入记录
     * 
     * @dzmsoftgenerated
     */
    @Transactional(readOnly = false)
    @Override
    public int insertSelective(UcsUser record) {
        // 对密码进行加密处理
        entryptPassword(record);
        record.setId(StringUtil.getUuidString());
        record.setStatus(BaseConstant.Status.ENABLE);
        record.setCreateTime(new Date());
        return ucsUserMapper.insertSelective(record);
    }

    /**
     * 根据主键查询记录
     * 
     * @dzmsoftgenerated
     */
    @Override
    public UcsUser selectByPrimaryKey(String id) {
        return ucsUserMapper.selectByPrimaryKey(id);
    }

    /**
     * 分页查询记录
     * 
     * @dzmsoftgenerated
     */
    @Override
    public PageList<UcsUser> selectByExample(UcsUserExample example, PageBounds pageBounds) {
        return ucsUserMapper.selectByExample(example, pageBounds);
    }

    /**
     * 根据条件查询记录
     * 
     * @dzmsoftgenerated
     */
    @Override
    public List<UcsUser> selectByExample(UcsUserExample example) {
        return ucsUserMapper.selectByExample(example);
    }

    /**
     * 根据主键更新记录
     * 
     * @dzmsoftgenerated
     */
    @Transactional(readOnly = false)
    @Override
    public int updateByPrimaryKeySelective(UcsUser record) {
        return ucsUserMapper.updateByPrimaryKeySelective(record);
    }

    /**
     * 根据查询条件更新记录
     * 
     * @dzmsoftgenerated
     */
    @Transactional(readOnly = false)
    @Override
    public int updateByExampleSelective(UcsUser record, UcsUserExample example) {
        return ucsUserMapper.updateByExampleSelective(record, example);
    }

    /**
     * 根据主键生成记录
     * 
     * @dzmsoftgenerated
     */
    @Transactional(readOnly = false)
    @Override
    public int deleteByPrimaryKey(String id) {
        return ucsUserMapper.deleteByPrimaryKey(id);
    }

    /**
     * 根据条件删除字段信息
     * 
     * @dzmsoftgenerated
     * @param example
     * @return
     */
    @Transactional(readOnly = false)
    @Override
    public int deleteByExample(UcsUserExample example) {
        return ucsUserMapper.deleteByExample(example);
    }

}
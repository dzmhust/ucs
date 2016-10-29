package com.dzmsoft.ucs.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dzmsoft.ucs.api.service.UcsUserApiService;
import com.dzmsoft.ucs.base.pojo.UcsUser;
import com.dzmsoft.ucs.base.service.UcsUserService;
import com.google.gson.Gson;

@Service
@Transactional(readOnly = true)
public class UcsUserApiServiceImpl implements UcsUserApiService{
    @Autowired
    private UcsUserService ucsUserService;
    @Autowired
    private Gson gson;

    @Override
    public String selectByUsername(String username) {
        UcsUser ucsUser = ucsUserService.selectByUsername(username);
        return gson.toJson(ucsUser);
    }
    
    @Transactional(readOnly = false)
    @Override
    public Integer updatePwd(String id, String password) {
        return ucsUserService.updatePwd(id, password);
    }

}

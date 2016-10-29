package com.dzmsoft.ucs.base.test.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dzmsoft.framework.base.util.security.DigestsUtil;
import com.dzmsoft.ucs.base.pojo.UcsUser;
import com.dzmsoft.ucs.base.service.UcsUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:/spring.xml"})
public class UcsUserServiceTest {
    
    @Autowired
    private UcsUserService ucsUserService;
    
    @Test
    @Rollback(true)
    public void genAdminUser(){
        UcsUser ucsUser = new UcsUser();
        ucsUser.setId("00000000000000000000000000000000");
        ucsUser.setUsername("admin");
        ucsUser.setPassword(DigestsUtil.md5Hex(DigestsUtil.md5Hex("123456")));
        ucsUser.setName("超级管理员");
        ucsUser.setStatus("01");
//      ucsUser.setIsAdmin("1");
        ucsUser.setEmail("393056990@qq.com");
        //
        ucsUserService.insertSelective(ucsUser);
    }
}

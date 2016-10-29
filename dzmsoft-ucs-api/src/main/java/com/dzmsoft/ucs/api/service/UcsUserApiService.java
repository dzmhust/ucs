package com.dzmsoft.ucs.api.service;


/**
 * 用户api接口
 * @author dzm
 */
public interface UcsUserApiService {
    /**
     * 根据用户名、密码获取账号信息
     * @param username
     * @return
     */
    String selectByUsername(String username) ;
    /**
     * 修改密码
     * @param id
     * @param password
     * @return
     */
    Integer updatePwd(String id, String password);
}

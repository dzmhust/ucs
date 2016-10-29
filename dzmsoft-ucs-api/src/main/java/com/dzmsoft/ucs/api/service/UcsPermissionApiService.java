package com.dzmsoft.ucs.api.service;

import java.util.List;

import com.dzmsoft.framework.base.web.mvc.pojo.Menu;

/**
 * 权限api接口
 * @author dzm
 */
public interface UcsPermissionApiService {
    /**
     * 根据用户获取权限
     * @param userId 用户id
     * @param domain 所属系统
     * @return
     */
    List<String> selectPermissions(String userId, String domain);
    /**
     * 获取菜单信息
     * @param userId 用户id
     * @param domain 所属系统
     * @return
     */
    List<Menu> getMenus(String userId, String domain);
}

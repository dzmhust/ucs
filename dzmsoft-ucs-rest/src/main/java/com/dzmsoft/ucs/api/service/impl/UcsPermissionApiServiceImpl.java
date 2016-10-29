package com.dzmsoft.ucs.api.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dzmsoft.framework.base.util.CheckEmptyUtil;
import com.dzmsoft.framework.base.web.mvc.pojo.Menu;
import com.dzmsoft.ucs.api.service.UcsPermissionApiService;
import com.dzmsoft.ucs.base.pojo.UcsPermission;
import com.dzmsoft.ucs.base.service.UcsPermissionService;

@Service
@Transactional(readOnly = true)
public class UcsPermissionApiServiceImpl implements UcsPermissionApiService {
    @Autowired
    private UcsPermissionService ucsPermissionService;

    @Override
    public List<String> selectPermissions(String userId, String domain) {
        return ucsPermissionService.selectPermissions(userId, domain);
    }

    @Override
    public List<Menu> getMenus(String userId, String domain) {
        List<UcsPermission> ucsPermissions = ucsPermissionService.selectMenusByUser(userId,domain);
        List<Menu> menus = null;
        if (!CheckEmptyUtil.isEmpty(ucsPermissions)){
            menus = new ArrayList<Menu>();
            Menu menu = null;
            for (UcsPermission ucsPermission:ucsPermissions){
                menu = new Menu(ucsPermission.getId(), ucsPermission.getPid(), ucsPermission.getName(), null,ucsPermission.getUrl());
                menus.add(menu);
            }
        }
        return menus;
    }

}

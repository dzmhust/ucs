package com.dzmsoft.ucs.base.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dzmsoft.framework.base.common.BaseConstant;
import com.dzmsoft.framework.base.web.mvc.controller.BaseController;
import com.dzmsoft.framework.base.web.mvc.controller.validate.ValidateField;
import com.dzmsoft.framework.base.web.mvc.controller.validate.ValidateGroup;
import com.dzmsoft.framework.base.web.mvc.dao.MybatisExample;
import com.dzmsoft.framework.base.web.mvc.pojo.EasyUIPage;
import com.dzmsoft.framework.base.web.mvc.shiro.UserUtil;
import com.dzmsoft.framework.base.web.mvc.view.BaseResponse;
import com.dzmsoft.framework.base.web.mvc.view.Condition;
import com.dzmsoft.ucs.base.pojo.UcsUser;
import com.dzmsoft.ucs.base.pojo.UcsUserExample;
import com.dzmsoft.ucs.base.service.UcsUserService;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

/**
 * Copyright (C), dzmsoft Co., Ltd
 * 
 * @author
 * @dzmsoftgenerated
 * @version
 */
@Controller
@RequestMapping("ucsUser")
public class UcsUserController extends BaseController {
    @Autowired
    private UcsUserService ucsUserService;

    /**
     * 打开修改密码页面
     * 
     * @param model
     * @return
     */
    @RequestMapping(value = "updatePwd", method = RequestMethod.GET)
    public String updatePwdForm(Model model) {
        model.addAttribute("ucsUser", UserUtil.getCurrentShiroUser());
        return "system/updatePwdForm";
    }

    @RequestMapping(value = "updatePwd", method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse updatePwd(String password) {
        String id = UserUtil.getCurrentShiroUser().getId();
        int flag = ucsUserService.updatePassword(id, password);
        BaseResponse baseResponse = flag > 0 ? new BaseResponse(true, "密码更新成功") : new BaseResponse(
                false, "密码更新失败");
        return baseResponse;
    }

    /**
     * 显示主列表页面
     * 
     * @dzmsoftgenerated
     * @return
     */
    @RequiresPermissions("ucsUser:find")
    @RequestMapping(value = "show", method = RequestMethod.GET)
    public String show() {
        return "modules/base/ucsUserList";
    }

    /**
     * 主列表中查询
     * 
     * @dzmsoftgenerated
     * @return
     */
    @RequiresPermissions("ucsUser:find")
    @RequestMapping(value = "find", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> find(HttpServletRequest request) {
        List<Condition> conditions = Condition.buildFromHttpRequest(request);
        EasyUIPage easyUIPage = new EasyUIPage(request);
        MybatisExample mybatisExample = MybatisExample.getInstance();
        UcsUserExample example = (UcsUserExample) mybatisExample.buildExampleByCondition(
                conditions,
                easyUIPage,
                UcsUserExample.class.getName());
        PageList<UcsUser> ucsUsers = ucsUserService.selectByExample(example, new PageBounds(
                easyUIPage.getPage(), easyUIPage.getRows()));
        return getEasyUIGrid(ucsUsers);
    }

    /**
     * 跳转到新增页面
     * 
     * @dzmsoftgenerated
     * @return
     */
    @RequiresPermissions("ucsUser:add")
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String addForm(Model model) {
        UcsUser ucsUser = new UcsUser();
        model.addAttribute("ucsUser", ucsUser);
        model.addAttribute("action", "add");
        return "modules/base/ucsUserForm";
    }

    /**
     * 新增记录
     * 
     * @dzmsoftgenerated
     * @return
     */
    @RequiresPermissions("ucsUser:add")
    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse add(UcsUser ucsUser) {
        int flag = ucsUserService.insertSelective(ucsUser);
        BaseResponse baseResponse = flag > 0 ? new BaseResponse(true, "新增成功") : new BaseResponse(
                false, "新增失败");
        return baseResponse;
    }

    /**
     * 跳转到编辑页面
     * 
     * @dzmsoftgenerated
     * @return
     */
    @RequiresPermissions("ucsUser:edit")
    @RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
    public String editForm(@PathVariable("id") String id, Model model) {
        UcsUser ucsUser = ucsUserService.selectByPrimaryKey(id);
        model.addAttribute("ucsUser", ucsUser);
        model.addAttribute("action", "edit");
        return "modules/base/ucsUserForm";
    }

    /**
     * 跳转到查看页面
     * 
     * @dzmsoftgenerated
     * @return
     */
    @RequiresPermissions("ucsUser:view")
    @RequestMapping(value = "view/{id}", method = RequestMethod.GET)
    public String viewForm(@PathVariable("id") String id, Model model) {
        UcsUser ucsUser = ucsUserService.selectByPrimaryKey(id);
        model.addAttribute("ucsUser", ucsUser);
        model.addAttribute("action", "view");
        return "modules/base/ucsUserForm";
    }

    /**
     * 编辑记录
     * 
     * @dzmsoftgenerated
     * @return
     */
    @RequiresPermissions("ucsUser:edit")
    @RequestMapping(value = "edit", method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse edit(UcsUser ucsUser) {
        int flag = ucsUserService.updateByPrimaryKeySelective(ucsUser);
        BaseResponse baseResponse = flag > 0 ? new BaseResponse(true, "编辑成功") : new BaseResponse(
                false, "编辑失败");
        return baseResponse;
    }

    /**
     * 删除记录
     * 
     * @dzmsoftgenerated
     * @return
     */
    @RequiresPermissions("ucsUser:remove")
    @RequestMapping(value = "remove/{id}", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse remove(@PathVariable("id") String id) {
        int flag = ucsUserService.deleteByPrimaryKey(id);
        BaseResponse baseResponse = flag >= 0 ? new BaseResponse(true, "删除成功") : new BaseResponse(
                false, "删除失败");
        return baseResponse;
    }

    @RequiresPermissions("ucsUser:remove")
    @RequestMapping(value = "removeBatch", method = RequestMethod.POST)
    @ResponseBody
    @ValidateGroup(
            fileds ={
                    @ValidateField(index=0 ,notNull=true )
            }
    )
    public BaseResponse removeBatch(String ids){
        List<String > idList = Arrays.asList(StringUtils.split(ids, BaseConstant.Separate.COMMA));
        boolean flag = ucsUserService.deleteBatchByPrimaryKeys(idList);
        BaseResponse baseResponse = flag  ? new BaseResponse(true, "删除成功") : new BaseResponse(
                false, "删除失败");
        return baseResponse;
    }
    
    
}

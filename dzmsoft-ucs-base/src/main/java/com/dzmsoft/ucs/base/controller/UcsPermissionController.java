package com.dzmsoft.ucs.base.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dzmsoft.framework.base.web.mvc.controller.BaseController;
import com.dzmsoft.framework.base.web.mvc.dao.MybatisExample;
import com.dzmsoft.framework.base.web.mvc.pojo.EasyUIPage;
import com.dzmsoft.framework.base.web.mvc.pojo.ShiroUser;
import com.dzmsoft.framework.base.web.mvc.shiro.UserUtil;
import com.dzmsoft.framework.base.web.mvc.view.BaseResponse;
import com.dzmsoft.framework.base.web.mvc.view.Condition;
import com.dzmsoft.ucs.base.pojo.UcsPermission;
import com.dzmsoft.ucs.base.pojo.UcsPermissionExample;
import com.dzmsoft.ucs.base.service.UcsPermissionService;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

/**
 * Copyright (C), dzmsoft Co., Ltd
 * @author 
 * @dzmsoftgenerated 
 *
 * @version 
 */
@Controller
@RequestMapping("ucsPermission")
public class UcsPermissionController extends BaseController{
    @Value("${domain}")
    private String domain;
	@Autowired
	private UcsPermissionService ucsPermissionService;

	@RequestMapping(value="getMenus", method = RequestMethod.GET)
    @ResponseBody
    public List<UcsPermission> getMenus(){
        List<UcsPermission> ucsPermissions = ucsPermissionService.selectMenusByUser(((ShiroUser)UserUtil.getCurrentShiroUser()).getId(), domain);
        return ucsPermissions;
    }
	/**
	 * 显示主列表页面
	 * @dzmsoftgenerated 
	 * @return
	 */
	@RequiresPermissions("ucsPermission:find")
	@RequestMapping(value = "show", method = RequestMethod.GET)
	public String show(){
		return "modules/base/ucsPermissionList";
	}
	
	/**
	 * 主列表中查询
	 * @dzmsoftgenerated 
	 * @return
	 */
	@RequiresPermissions("ucsPermission:find")
	@RequestMapping(value = "find", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> find(HttpServletRequest request){
		List<Condition> conditions = Condition.buildFromHttpRequest(request);
		EasyUIPage easyUIPage = new EasyUIPage(request);
		MybatisExample mybatisExample = MybatisExample.getInstance();
		UcsPermissionExample example = (UcsPermissionExample)mybatisExample.buildExampleByCondition(conditions, easyUIPage, UcsPermissionExample.class.getName());
		PageList<UcsPermission> ucsPermissions = ucsPermissionService.selectByExample(example, new PageBounds(easyUIPage.getPage(),
                easyUIPage.getRows()));
		return getEasyUIGrid(ucsPermissions);
	}
	
	/**
	 * 跳转到新增页面
	 * @dzmsoftgenerated 
	 * @return
	 */
	@RequiresPermissions("ucsPermission:add")
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String addForm(Model model){
		UcsPermission ucsPermission = new UcsPermission();
				model.addAttribute("ucsPermission", ucsPermission);
		model.addAttribute("action", "add");
		return "modules/base/ucsPermissionForm";
	}
	
		/**
	 * 新增记录
	 * @dzmsoftgenerated 
	 * @return
	 */
	@RequiresPermissions("ucsPermission:add")
	@RequestMapping(value = "add", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponse add(UcsPermission ucsPermission){
		int flag = ucsPermissionService.insertSelective(ucsPermission);
		BaseResponse baseResponse = flag>0?new BaseResponse(true,"新增成功"):new BaseResponse(false, "新增失败");
		return baseResponse;
	}
		
	/**
	 * 跳转到编辑页面
	 * @dzmsoftgenerated 
	 * @return
	 */
	@RequiresPermissions("ucsPermission:edit")
	@RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
	public String editForm(@PathVariable("id") String id,Model model){
		UcsPermission ucsPermission = ucsPermissionService.selectByPrimaryKey(id);
		model.addAttribute("ucsPermission", ucsPermission);
		model.addAttribute("action", "edit");
		return "modules/base/ucsPermissionForm";
	}
	
	/**
	 * 跳转到查看页面
	 * @dzmsoftgenerated 
	 * @return
	 */
	@RequiresPermissions("ucsPermission:view")
	@RequestMapping(value = "view/{id}", method = RequestMethod.GET)
	public String viewForm(@PathVariable("id") String id,Model model){
		UcsPermission ucsPermission = ucsPermissionService.selectByPrimaryKey(id);
		model.addAttribute("ucsPermission", ucsPermission);
		model.addAttribute("action", "view");
		return "modules/base/ucsPermissionForm";
	}
	
		/**
	 * 编辑记录
	 * @dzmsoftgenerated 
	 * @return
	 */
	@RequiresPermissions("ucsPermission:edit")
	@RequestMapping(value = "edit", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponse edit(UcsPermission ucsPermission){
		int flag = ucsPermissionService.updateByPrimaryKeySelective(ucsPermission);
		BaseResponse baseResponse = flag>0?new BaseResponse(true,"编辑成功"):new BaseResponse(false, "编辑失败");
		return baseResponse;
	}
		
	/**
	 * 删除记录
	 * @dzmsoftgenerated 
	 * @return
	 */
	@RequiresPermissions("ucsPermission:remove")
	@RequestMapping(value = "remove/{id}", method = RequestMethod.GET)
	@ResponseBody
	public BaseResponse remove(@PathVariable("id") String id){
		int flag = ucsPermissionService.deleteByPrimaryKey(id);
		BaseResponse baseResponse = flag>=0?new BaseResponse(true,"删除成功"):new BaseResponse(false, "删除失败");
		return baseResponse;
	}
	
	}

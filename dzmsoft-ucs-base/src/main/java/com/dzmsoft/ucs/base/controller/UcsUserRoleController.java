package com.dzmsoft.ucs.base.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dzmsoft.framework.base.web.mvc.controller.BaseController;
import com.dzmsoft.framework.base.web.mvc.dao.MybatisExample;
import com.dzmsoft.framework.base.web.mvc.view.BaseResponse;
import com.dzmsoft.framework.base.web.mvc.view.Condition;
import com.dzmsoft.framework.base.web.mvc.pojo.EasyUIPage;
import com.dzmsoft.ucs.base.pojo.UcsUserRole;
import com.dzmsoft.ucs.base.pojo.UcsUserRoleExample;
import com.dzmsoft.ucs.base.service.UcsUserRoleService;
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
@RequestMapping("ucsUserRole")
public class UcsUserRoleController extends BaseController{
	@Autowired
	private UcsUserRoleService ucsUserRoleService;

	/**
	 * 显示主列表页面
	 * @dzmsoftgenerated 
	 * @return
	 */
	@RequiresPermissions("ucsUserRole:find")
	@RequestMapping(value = "show", method = RequestMethod.GET)
	public String show(){
		return "modules/base/ucsUserRoleList";
	}
	
	/**
	 * 主列表中查询
	 * @dzmsoftgenerated 
	 * @return
	 */
	@RequiresPermissions("ucsUserRole:find")
	@RequestMapping(value = "find", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> find(HttpServletRequest request){
		List<Condition> conditions = Condition.buildFromHttpRequest(request);
		EasyUIPage easyUIPage = new EasyUIPage(request);
		MybatisExample mybatisExample = MybatisExample.getInstance();
		UcsUserRoleExample example = (UcsUserRoleExample)mybatisExample.buildExampleByCondition(conditions, easyUIPage, UcsUserRoleExample.class.getName());
		PageList<UcsUserRole> ucsUserRoles = ucsUserRoleService.selectByExample(example, new PageBounds(easyUIPage.getPage(),
                easyUIPage.getRows()));
		return getEasyUIGrid(ucsUserRoles);
	}
	
	/**
	 * 跳转到新增页面
	 * @dzmsoftgenerated 
	 * @return
	 */
	@RequiresPermissions("ucsUserRole:add")
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String addForm(Model model){
		UcsUserRole ucsUserRole = new UcsUserRole();
				model.addAttribute("ucsUserRole", ucsUserRole);
		model.addAttribute("action", "add");
		return "modules/base/ucsUserRoleForm";
	}
	
		/**
	 * 新增记录
	 * @dzmsoftgenerated 
	 * @return
	 */
	@RequiresPermissions("ucsUserRole:add")
	@RequestMapping(value = "add", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponse add(UcsUserRole ucsUserRole){
		int flag = ucsUserRoleService.insertSelective(ucsUserRole);
		BaseResponse baseResponse = flag>0?new BaseResponse(true,"新增成功"):new BaseResponse(false, "新增失败");
		return baseResponse;
	}
		
	/**
	 * 跳转到编辑页面
	 * @dzmsoftgenerated 
	 * @return
	 */
	@RequiresPermissions("ucsUserRole:edit")
	@RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
	public String editForm(@PathVariable("id") String id,Model model){
		UcsUserRole ucsUserRole = ucsUserRoleService.selectByPrimaryKey(id);
		model.addAttribute("ucsUserRole", ucsUserRole);
		model.addAttribute("action", "edit");
		return "modules/base/ucsUserRoleForm";
	}
	
	/**
	 * 跳转到查看页面
	 * @dzmsoftgenerated 
	 * @return
	 */
	@RequiresPermissions("ucsUserRole:view")
	@RequestMapping(value = "view/{id}", method = RequestMethod.GET)
	public String viewForm(@PathVariable("id") String id,Model model){
		UcsUserRole ucsUserRole = ucsUserRoleService.selectByPrimaryKey(id);
		model.addAttribute("ucsUserRole", ucsUserRole);
		model.addAttribute("action", "view");
		return "modules/base/ucsUserRoleForm";
	}
	
		/**
	 * 编辑记录
	 * @dzmsoftgenerated 
	 * @return
	 */
	@RequiresPermissions("ucsUserRole:edit")
	@RequestMapping(value = "edit", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponse edit(UcsUserRole ucsUserRole){
		int flag = ucsUserRoleService.updateByPrimaryKeySelective(ucsUserRole);
		BaseResponse baseResponse = flag>0?new BaseResponse(true,"编辑成功"):new BaseResponse(false, "编辑失败");
		return baseResponse;
	}
		
	/**
	 * 删除记录
	 * @dzmsoftgenerated 
	 * @return
	 */
	@RequiresPermissions("ucsUserRole:remove")
	@RequestMapping(value = "remove/{id}", method = RequestMethod.GET)
	@ResponseBody
	public BaseResponse remove(@PathVariable("id") String id){
		int flag = ucsUserRoleService.deleteByPrimaryKey(id);
		BaseResponse baseResponse = flag>=0?new BaseResponse(true,"删除成功"):new BaseResponse(false, "删除失败");
		return baseResponse;
	}
	
	}

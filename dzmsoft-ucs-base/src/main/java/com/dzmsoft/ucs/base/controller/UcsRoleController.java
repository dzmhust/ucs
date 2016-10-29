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
import com.dzmsoft.ucs.base.pojo.UcsRole;
import com.dzmsoft.ucs.base.pojo.UcsRoleExample;
import com.dzmsoft.ucs.base.service.UcsRoleService;
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
@RequestMapping("ucsRole")
public class UcsRoleController extends BaseController{
	@Autowired
	private UcsRoleService ucsRoleService;

	/**
	 * 显示主列表页面
	 * @dzmsoftgenerated 
	 * @return
	 */
	@RequiresPermissions("ucsRole:find")
	@RequestMapping(value = "show", method = RequestMethod.GET)
	public String show(){
		return "modules/base/ucsRoleList";
	}
	
	/**
	 * 主列表中查询
	 * @dzmsoftgenerated 
	 * @return
	 */
	@RequiresPermissions("ucsRole:find")
	@RequestMapping(value = "find", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> find(HttpServletRequest request){
		List<Condition> conditions = Condition.buildFromHttpRequest(request);
		EasyUIPage easyUIPage = new EasyUIPage(request);
		MybatisExample mybatisExample = MybatisExample.getInstance();
		UcsRoleExample example = (UcsRoleExample)mybatisExample.buildExampleByCondition(conditions, easyUIPage, UcsRoleExample.class.getName());
		PageList<UcsRole> ucsRoles = ucsRoleService.selectByExample(example, new PageBounds(easyUIPage.getPage(),
                easyUIPage.getRows()));
		return getEasyUIGrid(ucsRoles);
	}
	
	/**
	 * 跳转到新增页面
	 * @dzmsoftgenerated 
	 * @return
	 */
	@RequiresPermissions("ucsRole:add")
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String addForm(Model model){
		UcsRole ucsRole = new UcsRole();
				model.addAttribute("ucsRole", ucsRole);
		model.addAttribute("action", "add");
		return "modules/base/ucsRoleForm";
	}
	
		/**
	 * 新增记录
	 * @dzmsoftgenerated 
	 * @return
	 */
	@RequiresPermissions("ucsRole:add")
	@RequestMapping(value = "add", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponse add(UcsRole ucsRole){
		int flag = ucsRoleService.insertSelective(ucsRole);
		BaseResponse baseResponse = flag>0?new BaseResponse(true,"新增成功"):new BaseResponse(false, "新增失败");
		return baseResponse;
	}
		
	/**
	 * 跳转到编辑页面
	 * @dzmsoftgenerated 
	 * @return
	 */
	@RequiresPermissions("ucsRole:edit")
	@RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
	public String editForm(@PathVariable("id") String id,Model model){
		UcsRole ucsRole = ucsRoleService.selectByPrimaryKey(id);
		model.addAttribute("ucsRole", ucsRole);
		model.addAttribute("action", "edit");
		return "modules/base/ucsRoleForm";
	}
	
	/**
	 * 跳转到查看页面
	 * @dzmsoftgenerated 
	 * @return
	 */
	@RequiresPermissions("ucsRole:view")
	@RequestMapping(value = "view/{id}", method = RequestMethod.GET)
	public String viewForm(@PathVariable("id") String id,Model model){
		UcsRole ucsRole = ucsRoleService.selectByPrimaryKey(id);
		model.addAttribute("ucsRole", ucsRole);
		model.addAttribute("action", "view");
		return "modules/base/ucsRoleForm";
	}
	
		/**
	 * 编辑记录
	 * @dzmsoftgenerated 
	 * @return
	 */
	@RequiresPermissions("ucsRole:edit")
	@RequestMapping(value = "edit", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponse edit(UcsRole ucsRole){
		int flag = ucsRoleService.updateByPrimaryKeySelective(ucsRole);
		BaseResponse baseResponse = flag>0?new BaseResponse(true,"编辑成功"):new BaseResponse(false, "编辑失败");
		return baseResponse;
	}
		
	/**
	 * 删除记录
	 * @dzmsoftgenerated 
	 * @return
	 */
	@RequiresPermissions("ucsRole:remove")
	@RequestMapping(value = "remove/{id}", method = RequestMethod.GET)
	@ResponseBody
	public BaseResponse remove(@PathVariable("id") String id){
		int flag = ucsRoleService.deleteByPrimaryKey(id);
		BaseResponse baseResponse = flag>=0?new BaseResponse(true,"删除成功"):new BaseResponse(false, "删除失败");
		return baseResponse;
	}
	
	}

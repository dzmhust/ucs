package com.dzmsoft.ucs.ccs.controller;

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

import com.dzmsoft.framework.base.web.mvc.controller.BaseController;
import com.dzmsoft.framework.base.web.mvc.controller.validate.ValidateField;
import com.dzmsoft.framework.base.web.mvc.controller.validate.ValidateGroup;
import com.dzmsoft.framework.base.web.mvc.dao.MybatisExample;
import com.dzmsoft.framework.base.web.mvc.view.BaseResponse;
import com.dzmsoft.framework.base.web.mvc.view.Condition;
import com.dzmsoft.framework.base.web.mvc.pojo.EasyUIPage;
import com.dzmsoft.framework.base.common.BaseConstant;
import com.dzmsoft.ucs.ccs.pojo.CcsTemplate;
import com.dzmsoft.ucs.ccs.pojo.CcsTemplateExample;
import com.dzmsoft.ucs.ccs.service.CcsTemplateService;
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
@RequestMapping("ccsTemplate")
public class CcsTemplateController extends BaseController{
	@Autowired
	private CcsTemplateService ccsTemplateService;

	/**
	 * 显示主列表页面
	 * @dzmsoftgenerated 
	 * @return
	 */
	@RequiresPermissions("ccsTemplate:find")
	@RequestMapping(value = "show", method = RequestMethod.GET)
	public String show(){
		return "modules/ccs/ccsTemplateList";
	}
	
	/**
	 * 主列表中查询
	 * @dzmsoftgenerated 
	 * @return
	 */
	@RequiresPermissions("ccsTemplate:find")
	@RequestMapping(value = "find", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> find(HttpServletRequest request){
		List<Condition> conditions = Condition.buildFromHttpRequest(request);
		EasyUIPage easyUIPage = new EasyUIPage(request);
		MybatisExample mybatisExample = MybatisExample.getInstance();
		CcsTemplateExample example = (CcsTemplateExample)mybatisExample.buildExampleByCondition(conditions, easyUIPage, CcsTemplateExample.class.getName());
		PageList<CcsTemplate> ccsTemplates = ccsTemplateService.selectByExample(example, new PageBounds(easyUIPage.getPage(),easyUIPage.getRows()));
		return getEasyUIGrid(ccsTemplates);
	}
	
	/**
	 * 跳转到新增页面
	 * @dzmsoftgenerated 
	 * @return
	 */
	@RequiresPermissions("ccsTemplate:add")
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String addForm(Model model){
		CcsTemplate ccsTemplate = new CcsTemplate();
				model.addAttribute("ccsTemplate", ccsTemplate);
		model.addAttribute("action", "add");
		return "modules/ccs/ccsTemplateForm";
	}
	
		/**
	 * 新增记录
	 * @dzmsoftgenerated 
	 * @return
	 */
	@RequiresPermissions("ccsTemplate:add")
	@RequestMapping(value = "add", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponse add(CcsTemplate ccsTemplate){
		boolean flag = ccsTemplateService.insertSelective(ccsTemplate);
		BaseResponse baseResponse = flag?new BaseResponse(true,"新增成功"):new BaseResponse(false, "新增失败");
		return baseResponse;
	}
		
	/**
	 * 跳转到编辑页面
	 * @dzmsoftgenerated 
	 * @return
	 */
	@RequiresPermissions("ccsTemplate:edit")
	@RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
	public String editForm(@PathVariable("id") String id,Model model){
		CcsTemplate ccsTemplate = ccsTemplateService.selectByPrimaryKey(id);
		model.addAttribute("ccsTemplate", ccsTemplate);
		model.addAttribute("action", "edit");
		return "modules/ccs/ccsTemplateForm";
	}
	
	/**
	 * 跳转到查看页面
	 * @dzmsoftgenerated 
	 * @return
	 */
	@RequiresPermissions("ccsTemplate:view")
	@RequestMapping(value = "view/{id}", method = RequestMethod.GET)
	public String viewForm(@PathVariable("id") String id,Model model){
		CcsTemplate ccsTemplate = ccsTemplateService.selectByPrimaryKey(id);
		model.addAttribute("ccsTemplate", ccsTemplate);
		model.addAttribute("action", "view");
		return "modules/ccs/ccsTemplateForm";
	}
	
		/**
	 * 编辑记录
	 * @dzmsoftgenerated 
	 * @return
	 */
	@RequiresPermissions("ccsTemplate:edit")
	@RequestMapping(value = "edit", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponse edit(CcsTemplate ccsTemplate){
		boolean flag = ccsTemplateService.updateByPrimaryKeySelective(ccsTemplate);
		BaseResponse baseResponse = flag?new BaseResponse(true,"编辑成功"):new BaseResponse(false, "编辑失败");
		return baseResponse;
	}
		
	/**
	 * 删除记录
	 * @dzmsoftgenerated 
	 * @return
	 */
	@RequiresPermissions("ccsTemplate:remove")
	@RequestMapping(value = "remove/{id}", method = RequestMethod.GET)
	@ResponseBody
	public BaseResponse remove(@PathVariable("id") String id){
		boolean flag = ccsTemplateService.deleteByPrimaryKey(id);
		BaseResponse baseResponse = flag?new BaseResponse(true,"删除成功"):new BaseResponse(false, "删除失败");
		return baseResponse;
	}
	
		
	/**
	 * 批量记录
	 * @dzmsoftgenerated 
	 * @return
	 */
	@RequiresPermissions("ccsTemplate:remove")
    @RequestMapping(value = "removeBatch", method = RequestMethod.POST)
    @ResponseBody
    @ValidateGroup(
            fileds ={
                    @ValidateField(index=0 ,notNull=true )
            }
    )
    public BaseResponse removeBatch(String ids){
        List<String > idList = Arrays.asList(StringUtils.split(ids, BaseConstant.Separate.COMMA));
        boolean flag = ccsTemplateService.deleteBatchByPrimaryKeys(idList);
        BaseResponse baseResponse = flag  ? new BaseResponse(true, "删除成功") : new BaseResponse(false, "删除失败");
        return baseResponse;
    }
}

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
import com.dzmsoft.ucs.ccs.pojo.CcsDataDictionaryTree;
import com.dzmsoft.ucs.ccs.pojo.CcsDataDictionaryTreeExample;
import com.dzmsoft.ucs.ccs.service.CcsDataDictionaryTreeService;
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
@RequestMapping("ccsDataDictionaryTree")
public class CcsDataDictionaryTreeController extends BaseController{
	@Autowired
	private CcsDataDictionaryTreeService ccsDataDictionaryTreeService;

	/**
	 * 显示主列表页面
	 * @dzmsoftgenerated 
	 * @return
	 */
	@RequiresPermissions("ccsDataDictionaryTree:find")
	@RequestMapping(value = "show", method = RequestMethod.GET)
	public String show(){
		return "modules/ccs/ccsDataDictionaryTreeList";
	}
	
	/**
	 * 主列表中查询
	 * @dzmsoftgenerated 
	 * @return
	 */
	@RequiresPermissions("ccsDataDictionaryTree:find")
	@RequestMapping(value = "find", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> find(HttpServletRequest request){
		List<Condition> conditions = Condition.buildFromHttpRequest(request);
		EasyUIPage easyUIPage = new EasyUIPage(request);
		MybatisExample mybatisExample = MybatisExample.getInstance();
		CcsDataDictionaryTreeExample example = (CcsDataDictionaryTreeExample)mybatisExample.buildExampleByCondition(conditions, easyUIPage, CcsDataDictionaryTreeExample.class.getName());
		PageList<CcsDataDictionaryTree> ccsDataDictionaryTrees = ccsDataDictionaryTreeService.selectByExample(example, new PageBounds(easyUIPage.getPage(),easyUIPage.getRows()));
		return getEasyUIGrid(ccsDataDictionaryTrees);
	}
	
	/**
	 * 跳转到新增页面
	 * @dzmsoftgenerated 
	 * @return
	 */
	@RequiresPermissions("ccsDataDictionaryTree:add")
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String addForm(Model model){
		CcsDataDictionaryTree ccsDataDictionaryTree = new CcsDataDictionaryTree();
				model.addAttribute("ccsDataDictionaryTree", ccsDataDictionaryTree);
		model.addAttribute("action", "add");
		return "modules/ccs/ccsDataDictionaryTreeForm";
	}
	
		/**
	 * 新增记录
	 * @dzmsoftgenerated 
	 * @return
	 */
	@RequiresPermissions("ccsDataDictionaryTree:add")
	@RequestMapping(value = "add", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponse add(CcsDataDictionaryTree ccsDataDictionaryTree){
		boolean flag = ccsDataDictionaryTreeService.insertSelective(ccsDataDictionaryTree);
		BaseResponse baseResponse = flag?new BaseResponse(true,"新增成功"):new BaseResponse(false, "新增失败");
		return baseResponse;
	}
		
	/**
	 * 跳转到编辑页面
	 * @dzmsoftgenerated 
	 * @return
	 */
	@RequiresPermissions("ccsDataDictionaryTree:edit")
	@RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
	public String editForm(@PathVariable("id") String id,Model model){
		CcsDataDictionaryTree ccsDataDictionaryTree = ccsDataDictionaryTreeService.selectByPrimaryKey(id);
		model.addAttribute("ccsDataDictionaryTree", ccsDataDictionaryTree);
		model.addAttribute("action", "edit");
		return "modules/ccs/ccsDataDictionaryTreeForm";
	}
	
	/**
	 * 跳转到查看页面
	 * @dzmsoftgenerated 
	 * @return
	 */
	@RequiresPermissions("ccsDataDictionaryTree:view")
	@RequestMapping(value = "view/{id}", method = RequestMethod.GET)
	public String viewForm(@PathVariable("id") String id,Model model){
		CcsDataDictionaryTree ccsDataDictionaryTree = ccsDataDictionaryTreeService.selectByPrimaryKey(id);
		model.addAttribute("ccsDataDictionaryTree", ccsDataDictionaryTree);
		model.addAttribute("action", "view");
		return "modules/ccs/ccsDataDictionaryTreeForm";
	}
	
		/**
	 * 编辑记录
	 * @dzmsoftgenerated 
	 * @return
	 */
	@RequiresPermissions("ccsDataDictionaryTree:edit")
	@RequestMapping(value = "edit", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponse edit(CcsDataDictionaryTree ccsDataDictionaryTree){
		boolean flag = ccsDataDictionaryTreeService.updateByPrimaryKeySelective(ccsDataDictionaryTree);
		BaseResponse baseResponse = flag?new BaseResponse(true,"编辑成功"):new BaseResponse(false, "编辑失败");
		return baseResponse;
	}
		
	/**
	 * 删除记录
	 * @dzmsoftgenerated 
	 * @return
	 */
	@RequiresPermissions("ccsDataDictionaryTree:remove")
	@RequestMapping(value = "remove/{id}", method = RequestMethod.GET)
	@ResponseBody
	public BaseResponse remove(@PathVariable("id") String id){
		boolean flag = ccsDataDictionaryTreeService.deleteByPrimaryKey(id);
		BaseResponse baseResponse = flag?new BaseResponse(true,"删除成功"):new BaseResponse(false, "删除失败");
		return baseResponse;
	}
	
		
	/**
	 * 批量记录
	 * @dzmsoftgenerated 
	 * @return
	 */
	@RequiresPermissions("ccsDataDictionaryTree:remove")
    @RequestMapping(value = "removeBatch", method = RequestMethod.POST)
    @ResponseBody
    @ValidateGroup(
            fileds ={
                    @ValidateField(index=0 ,notNull=true )
            }
    )
    public BaseResponse removeBatch(String ids){
        List<String > idList = Arrays.asList(StringUtils.split(ids, BaseConstant.Separate.COMMA));
        boolean flag = ccsDataDictionaryTreeService.deleteBatchByPrimaryKeys(idList);
        BaseResponse baseResponse = flag  ? new BaseResponse(true, "删除成功") : new BaseResponse(false, "删除失败");
        return baseResponse;
    }
}

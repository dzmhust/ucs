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
import com.dzmsoft.framework.base.web.mvc.view.GenericResponse;
import com.dzmsoft.framework.base.web.mvc.pojo.EasyUIPage;
import com.dzmsoft.framework.base.common.BaseConstant;
import com.dzmsoft.ucs.ccs.pojo.CcsDataDictionary;
import com.dzmsoft.ucs.ccs.pojo.CcsDataDictionaryExample;
import com.dzmsoft.ucs.ccs.service.CcsDataDictionaryService;
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
@RequestMapping("ccsDataDictionary")
public class CcsDataDictionaryController extends BaseController{
	@Autowired
	private CcsDataDictionaryService ccsDataDictionaryService;

	/**
	 * 显示主列表页面
	 * @dzmsoftgenerated 
	 * @return
	 */
	@RequiresPermissions("ccsDataDictionary:find")
	@RequestMapping(value = "show", method = RequestMethod.GET)
	public String show(){
		return "modules/ccs/ccsDataDictionaryList";
	}
	
	/**
	 * 主列表中查询
	 * @dzmsoftgenerated 
	 * @return
	 */
	@RequiresPermissions("ccsDataDictionary:find")
	@RequestMapping(value = "find", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> find(HttpServletRequest request){
		List<Condition> conditions = Condition.buildFromHttpRequest(request);
		EasyUIPage easyUIPage = new EasyUIPage(request);
		MybatisExample mybatisExample = MybatisExample.getInstance();
		CcsDataDictionaryExample example = (CcsDataDictionaryExample)mybatisExample.buildExampleByCondition(conditions, easyUIPage, CcsDataDictionaryExample.class.getName());
		PageList<CcsDataDictionary> ccsDataDictionarys = ccsDataDictionaryService.selectByExample(example, new PageBounds(easyUIPage.getPage(),easyUIPage.getRows()));
		return getEasyUIGrid(ccsDataDictionarys);
	}
	
	/**
	 * 跳转到新增页面
	 * @dzmsoftgenerated 
	 * @return
	 */
	@RequiresPermissions("ccsDataDictionary:add")
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String addForm(Model model){
		CcsDataDictionary ccsDataDictionary = new CcsDataDictionary();
				model.addAttribute("ccsDataDictionary", ccsDataDictionary);
		model.addAttribute("action", "add");
		return "modules/ccs/ccsDataDictionaryForm";
	}
	
		/**
	 * 新增记录
	 * @dzmsoftgenerated 
	 * @return
	 */
	@RequiresPermissions("ccsDataDictionary:add")
	@RequestMapping(value = "add", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponse add(CcsDataDictionary ccsDataDictionary){
		boolean flag = ccsDataDictionaryService.insertSelective(ccsDataDictionary);
		BaseResponse baseResponse = flag?new BaseResponse(true,"新增成功"):new BaseResponse(false, "新增失败");
		return baseResponse;
	}
		
	/**
	 * 跳转到编辑页面
	 * @dzmsoftgenerated 
	 * @return
	 */
	@RequiresPermissions("ccsDataDictionary:edit")
	@RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
	public String editForm(@PathVariable("id") String id,Model model){
		CcsDataDictionary ccsDataDictionary = ccsDataDictionaryService.selectByPrimaryKey(id);
		model.addAttribute("ccsDataDictionary", ccsDataDictionary);
		model.addAttribute("action", "edit");
		return "modules/ccs/ccsDataDictionaryForm";
	}
	
	/**
	 * 跳转到查看页面
	 * @dzmsoftgenerated 
	 * @return
	 */
	@RequiresPermissions("ccsDataDictionary:view")
	@RequestMapping(value = "view/{id}", method = RequestMethod.GET)
	public String viewForm(@PathVariable("id") String id,Model model){
		CcsDataDictionary ccsDataDictionary = ccsDataDictionaryService.selectByPrimaryKey(id);
		model.addAttribute("ccsDataDictionary", ccsDataDictionary);
		model.addAttribute("action", "view");
		return "modules/ccs/ccsDataDictionaryForm";
	}
	
		/**
	 * 编辑记录
	 * @dzmsoftgenerated 
	 * @return
	 */
	@RequiresPermissions("ccsDataDictionary:edit")
	@RequestMapping(value = "edit", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponse edit(CcsDataDictionary ccsDataDictionary){
		boolean flag = ccsDataDictionaryService.updateByPrimaryKeySelective(ccsDataDictionary);
		BaseResponse baseResponse = flag?new BaseResponse(true,"编辑成功"):new BaseResponse(false, "编辑失败");
		return baseResponse;
	}
		
	/**
	 * 删除记录
	 * @dzmsoftgenerated 
	 * @return
	 */
	@RequiresPermissions("ccsDataDictionary:remove")
	@RequestMapping(value = "remove/{id}", method = RequestMethod.GET)
	@ResponseBody
	public BaseResponse remove(@PathVariable("id") String id){
		boolean flag = ccsDataDictionaryService.deleteByPrimaryKey(id);
		BaseResponse baseResponse = flag?new BaseResponse(true,"删除成功"):new BaseResponse(false, "删除失败");
		return baseResponse;
	}
	
		
	/**
	 * 批量记录
	 * @dzmsoftgenerated 
	 * @return
	 */
	@RequiresPermissions("ccsDataDictionary:remove")
    @RequestMapping(value = "removeBatch", method = RequestMethod.POST)
    @ResponseBody
    @ValidateGroup(
            fileds ={
                    @ValidateField(index=0 ,notNull=true )
            }
    )
    public BaseResponse removeBatch(String ids){
        List<String > idList = Arrays.asList(StringUtils.split(ids, BaseConstant.Separate.COMMA));
        boolean flag = ccsDataDictionaryService.deleteBatchByPrimaryKeys(idList);
        BaseResponse baseResponse = flag  ? new BaseResponse(true, "删除成功") : new BaseResponse(false, "删除失败");
        return baseResponse;
    }
	
	/**
	 * 根据类型获取配置数据
	 * @param type
	 * @return
	 */
	@RequestMapping(value = "selectByType/{type}", method = RequestMethod.GET)
	@ResponseBody
	public GenericResponse<List<CcsDataDictionary>>  selectByType(@PathVariable String type){
	    GenericResponse<List<CcsDataDictionary>> genericResponse = new GenericResponse<List<CcsDataDictionary>>(true);
	    List<CcsDataDictionary> ccsDataDictionaries = ccsDataDictionaryService.selectByType(type);
	    genericResponse.setData(ccsDataDictionaries);
	    return genericResponse;
	}
}

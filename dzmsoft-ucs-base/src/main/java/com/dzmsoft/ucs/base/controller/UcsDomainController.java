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

import com.dzmsoft.framework.base.web.mvc.controller.BaseController;
import com.dzmsoft.framework.base.web.mvc.controller.validate.ValidateField;
import com.dzmsoft.framework.base.web.mvc.controller.validate.ValidateGroup;
import com.dzmsoft.framework.base.web.mvc.dao.MybatisExample;
import com.dzmsoft.framework.base.web.mvc.view.BaseResponse;
import com.dzmsoft.framework.base.web.mvc.view.Condition;
import com.dzmsoft.framework.base.web.mvc.pojo.EasyUIPage;
import com.dzmsoft.framework.base.common.BaseConstant;
import com.dzmsoft.ucs.base.pojo.UcsDomain;
import com.dzmsoft.ucs.base.pojo.UcsDomainExample;
import com.dzmsoft.ucs.base.service.UcsDomainService;
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
@RequestMapping("ucsDomain")
public class UcsDomainController extends BaseController{
	@Autowired
	private UcsDomainService ucsDomainService;

	/**
	 * 显示主列表页面
	 * @dzmsoftgenerated 
	 * @return
	 */
	@RequiresPermissions("ucsDomain:find")
	@RequestMapping(value = "show", method = RequestMethod.GET)
	public String show(){
		return "modules/base/ucsDomainList";
	}
	
	/**
	 * 主列表中查询
	 * @dzmsoftgenerated 
	 * @return
	 */
	@RequiresPermissions("ucsDomain:find")
	@RequestMapping(value = "find", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> find(HttpServletRequest request){
		List<Condition> conditions = Condition.buildFromHttpRequest(request);
		EasyUIPage easyUIPage = new EasyUIPage(request);
		MybatisExample mybatisExample = MybatisExample.getInstance();
		UcsDomainExample example = (UcsDomainExample)mybatisExample.buildExampleByCondition(conditions, easyUIPage, UcsDomainExample.class.getName());
		PageList<UcsDomain> ucsDomains = ucsDomainService.selectByExample(example, new PageBounds(easyUIPage.getPage(),easyUIPage.getRows()));
		return getEasyUIGrid(ucsDomains);
	}
	
	/**
	 * 跳转到新增页面
	 * @dzmsoftgenerated 
	 * @return
	 */
	@RequiresPermissions("ucsDomain:add")
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String addForm(Model model){
		UcsDomain ucsDomain = new UcsDomain();
		ucsDomain.setStatus("02");
				model.addAttribute("ucsDomain", ucsDomain);
		model.addAttribute("action", "add");
		return "modules/base/ucsDomainForm";
	}
	
		/**
	 * 新增记录
	 * @dzmsoftgenerated 
	 * @return
	 */
	@RequiresPermissions("ucsDomain:add")
	@RequestMapping(value = "add", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponse add(UcsDomain ucsDomain){
		boolean flag = ucsDomainService.insertSelective(ucsDomain);
		BaseResponse baseResponse = flag?new BaseResponse(true,"新增成功"):new BaseResponse(false, "新增失败");
		return baseResponse;
	}
		
	/**
	 * 跳转到编辑页面
	 * @dzmsoftgenerated 
	 * @return
	 */
	@RequiresPermissions("ucsDomain:edit")
	@RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
	public String editForm(@PathVariable("id") String id,Model model){
		UcsDomain ucsDomain = ucsDomainService.selectByPrimaryKey(id);
		model.addAttribute("ucsDomain", ucsDomain);
		model.addAttribute("action", "edit");
		return "modules/base/ucsDomainForm";
	}
	
	/**
	 * 跳转到查看页面
	 * @dzmsoftgenerated 
	 * @return
	 */
	@RequiresPermissions("ucsDomain:view")
	@RequestMapping(value = "view/{id}", method = RequestMethod.GET)
	public String viewForm(@PathVariable("id") String id,Model model){
		UcsDomain ucsDomain = ucsDomainService.selectByPrimaryKey(id);
		model.addAttribute("ucsDomain", ucsDomain);
		model.addAttribute("action", "view");
		return "modules/base/ucsDomainForm";
	}
	
		/**
	 * 编辑记录
	 * @dzmsoftgenerated 
	 * @return
	 */
	@RequiresPermissions("ucsDomain:edit")
	@RequestMapping(value = "edit", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponse edit(UcsDomain ucsDomain){
		boolean flag = ucsDomainService.updateByPrimaryKeySelective(ucsDomain);
		BaseResponse baseResponse = flag?new BaseResponse(true,"编辑成功"):new BaseResponse(false, "编辑失败");
		return baseResponse;
	}
		
	/**
	 * 删除记录
	 * @dzmsoftgenerated 
	 * @return
	 */
	@RequiresPermissions("ucsDomain:remove")
	@RequestMapping(value = "remove/{id}", method = RequestMethod.GET)
	@ResponseBody
	public BaseResponse remove(@PathVariable("id") String id){
		boolean flag = ucsDomainService.deleteByPrimaryKey(id);
		BaseResponse baseResponse = flag?new BaseResponse(true,"删除成功"):new BaseResponse(false, "删除失败");
		return baseResponse;
	}
	
		
	/**
	 * 批量记录
	 * @dzmsoftgenerated 
	 * @return
	 */
	@RequiresPermissions("ucsDomain:remove")
    @RequestMapping(value = "removeBatch", method = RequestMethod.POST)
    @ResponseBody
    @ValidateGroup(
            fileds ={
                    @ValidateField(index=0 ,notNull=true )
            }
    )
    public BaseResponse removeBatch(String ids){
        List<String > idList = Arrays.asList(StringUtils.split(ids, BaseConstant.Separate.COMMA));
        boolean flag = ucsDomainService.deleteBatchByPrimaryKeys(idList);
        BaseResponse baseResponse = flag  ? new BaseResponse(true, "删除成功") : new BaseResponse(false, "删除失败");
        return baseResponse;
    }
}

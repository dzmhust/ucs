package com.dzmsoft.ucs.base.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dzmsoft.framework.base.web.exception.CaptchaException;
import com.dzmsoft.framework.base.web.mvc.shiro.UserUtil;

@Controller
public class LoginController {

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login() {
		Subject subject = SecurityUtils.getSubject();
		if(subject.isAuthenticated()||subject.isRemembered()){
			return "system/index";
		} 
		return "login";
	}
	
	@RequestMapping(value = "/index")
    public String index(){
        return "system/index";
    }
	
	@RequestMapping(value = "/ueditor")
	public String ueditor(){
	    return "system/ueditor";
	}
	
	/**
	 * 登录失败
	 * @param userName
	 * @param model
	 * @return
	 */
	@RequestMapping(value="login",method = RequestMethod.POST)
	public String fail(@RequestParam(FormAuthenticationFilter.DEFAULT_USERNAME_PARAM) String userName, Model model,HttpServletRequest request) {
		model.addAttribute(FormAuthenticationFilter.DEFAULT_USERNAME_PARAM, userName);
		String error = (String) request.getAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);
		String errorMsg = "";
		if (CaptchaException.class.getName().equals(error)){
			errorMsg = "验证码错误";
		} else if (UnknownAccountException.class.getName().equals(error)){
			errorMsg = "帐号或密码错误，请重试";
		} else if (IncorrectCredentialsException.class.getName().equals(error)){
			errorMsg = "用户名不存在，请重试";
		} else if (ExcessiveAttemptsException.class.getName().equals(error)){
		    errorMsg = "密码错误次数过多，请15分钟后再试";
		} else if (AuthenticationException.class.getName().equals(error)){
		    errorMsg = "帐号或密码错误，请重试";
		}
		model.addAttribute("errorMsg", errorMsg);
		return "login";
	}
	
	/**
     * 打开修改密码页面
     * @param model
     * @return
     */
    @RequestMapping(value = "updatePwd", method = RequestMethod.GET)
    public String updatePwdForm(Model model) {
        model.addAttribute("ucsUser", UserUtil.getCurrentShiroUser());
        return "system/updatePwdForm";
    }
	
}

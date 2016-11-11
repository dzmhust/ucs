package com.dzmsoft.ucs.base.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dzmsoft.framework.base.web.mvc.shiro.UserUtil;
import com.dzmsoft.framework.base.web.mvc.view.BaseResponse;
import com.dzmsoft.framework.base.web.shiro.UsernamePasswordCaptchaToken;

@Controller
public class LoginController {

    private static final Logger Logger = LoggerFactory.getLogger(LoginController.class);

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
    @ResponseBody
    public BaseResponse doLogin(@RequestParam("username") String username,@RequestParam("password")  String password, @RequestParam("captcha")  String captcha, HttpServletRequest request) {
        Subject subject = SecurityUtils.getSubject();
        BaseResponse response = null;
        try{
            if (!subject.isAuthenticated()){
                UsernamePasswordCaptchaToken token = new UsernamePasswordCaptchaToken(username,password.toCharArray(), false, request.getRemoteHost(), captcha);
                subject.login(token);
            }
            response = new BaseResponse(true);
        } catch(Exception e){
            Logger.error("doLogin exception is {}",e.getMessage());
            response = new BaseResponse(false, e.getMessage());
        }
        return response;
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

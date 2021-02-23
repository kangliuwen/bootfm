package com.kangliuwen.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * 总部接口:
 * <p>
 * 总部接口规范文档:
 * <p>
 * 省公司接口:
 * <p>
 * 省公司接口规范文档:
 *
 * @author klw
 * @Description(复杂调用逻辑时的描述):
 * @date 2021-01-25 14:57
 */
@Controller
public class LoginController {

    @PostMapping("/user/login")
    public String login(@RequestParam("account") String account,
                        @RequestParam("password") String password,
                        HttpSession session,
                        Model model) {
        if(!StringUtils.isEmpty(account)&&!StringUtils.isEmpty(password)){
            session.setAttribute("loginUser",account);
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(account, password);
            try{
                subject.login(token);
            }catch (UnknownAccountException unknownAccountException){
                model.addAttribute("msg","用户名错误");
                return "login";
            }catch (IncorrectCredentialsException incorrectCredentialsException){
                model.addAttribute("msg","密码错误");
                return "login";
            }
            return "redirect:/main.html";
        }else{
            model.addAttribute("msg","用户名或密码错误");
            return "login";
        }
    }
    @RequestMapping("/tologin")
    public String tologin() {

        return "login";
    }
    @GetMapping("/tologout")
    public String tologout(HttpSession session){
        session.invalidate();
        return "login";
    }

    @ResponseBody
    @RequestMapping("/unauthorized")
    public String unauthorized(){
        return "未经授权，无权访问！";
    }
}

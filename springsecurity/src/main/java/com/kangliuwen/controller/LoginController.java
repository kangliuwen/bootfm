package com.kangliuwen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
}

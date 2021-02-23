package com.kangliuwen.controller;

import com.kangliuwen.service.UserSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
 * @date 2021-02-22 16:59
 */
@Controller
public class TestController {
    @Autowired
    UserSerivce userSerivce;

    @RequestMapping("/test/getTickets")
    @ResponseBody
    public String getTickets(){

        return userSerivce.buyTicket();
    }
}

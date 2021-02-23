package com.kangliuwen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
 * @date 2021-01-22 17:51
 */
@Controller
public class IndexController {
    @RequestMapping("/index")
    public String index(){
        return "index";
    }
}

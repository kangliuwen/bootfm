package com.kangliuwen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
 * @date 2021-01-28 15:16
 */
@Controller
@RequestMapping("/level")
public class SecurityController {

    @GetMapping("/level1/{pageIndex}")
    public String getPage1(@PathVariable("pageIndex") String pageIndex){

        return "/level1/level1_"+pageIndex;
    }
    @GetMapping("/level2/{pageIndex}")
    public String getPage2(@PathVariable("pageIndex") String pageIndex){

        return "/level2/level2_"+pageIndex;
    }
    @GetMapping("/level3/{pageIndex}")
    public String getPage3(@PathVariable("pageIndex") String pageIndex){

        return "/level3/level3_"+pageIndex;
    }

}

package com.kangliuwen.service;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

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
 * @date 2021-02-22 16:07
 */
//zookeeper：服务注册与发现
@Component//使用dubbo后尽量不要用Spring的Service注解，容易产生歧义
@Service //在项目启动即可注册到zookeeper
public class TicketServiceImpl implements TicketService{
    public String getTickets() {
        return "请给康来张免费的票！";
    }
}

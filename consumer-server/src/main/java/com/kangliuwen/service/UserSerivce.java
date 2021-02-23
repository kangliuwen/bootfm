package com.kangliuwen.service;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

/**
 * @author klw
 * @Description(复杂调用逻辑时的描述):
 * @date 2021-02-22 16:11
 */
@Service
public class UserSerivce {
    //拿到provide-server提供的票
    @Reference//远程引用，Pom坐标或者可以定义路径相同的接口名
    TicketService ticketService;

    public String buyTicket(){
        String tickets = ticketService.getTickets();
        return ("在注册中心拿到Ticket："+tickets);
    }

}

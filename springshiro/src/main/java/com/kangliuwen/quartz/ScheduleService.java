package com.kangliuwen.quartz;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

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
 * @date 2021-02-19 16:27
 */
@Service
public class ScheduleService {

    @Scheduled(cron = "0/2 * * * * ?")
    public void doSomethings(){
        System.out.println("执行的这个doSomethings方法！");
    }
}

package com.kangliuwen;

import com.kangliuwen.service.UserSerivce;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ConsumerServerApplicationTests {

    @Autowired
    UserSerivce userSerivce;

    @Test
    void contextLoads() {
        userSerivce.buyTicket();
    }


}

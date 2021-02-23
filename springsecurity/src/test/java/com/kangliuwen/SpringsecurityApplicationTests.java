package com.kangliuwen;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringsecurityApplicationTests {

    @Test
    void contextLoads() {


    }

    public static void main(String[] args) {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 1000; j++) {
                    Thread.sleep(50);
                }
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            System.out.println("代码块一耗时"+(currentTimeMillis2-currentTimeMillis));

            long currentTimeMillis3 = System.currentTimeMillis();
            for (int i = 0; i < 1000; i++) {
                for (int j = 0; j <10 ; j++) {
                    Thread.sleep(50);
                }
            }
            long currentTimeMillis4 = System.currentTimeMillis();
            System.out.println("代码块二耗时"+(currentTimeMillis4-currentTimeMillis3));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

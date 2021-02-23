package com.kangliuwen;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest
class SpringshiroApplicationTests {

    @Autowired
    JavaMailSenderImpl javaMailSender;
    @Test
    void contextLoads() {

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo("1094127610@qq.com");
        simpleMailMessage.setFrom("1094127610@qq.com");
        simpleMailMessage.setSubject("好好学习啊");
        simpleMailMessage.setText("一定要发财啊！");
        javaMailSender.send(simpleMailMessage);
    }
    @Test
    void contextLoads2() throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);
        mimeMessageHelper.setTo("1094127610@qq.com");
        mimeMessageHelper.setFrom("1094127610@qq.com");
        mimeMessageHelper.setSubject("好好学习啊");
        mimeMessageHelper.setText("<p style='color:red'>一定要发财啊</p>",true);
        mimeMessageHelper.addAttachment("a-b-c.jpg",new File("C:\\Users\\Administrator\\Pictures\\a-b-c.jpg"));
        javaMailSender.send(mimeMessage);
    }
}

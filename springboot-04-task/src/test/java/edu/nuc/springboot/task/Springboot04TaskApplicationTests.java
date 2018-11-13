package edu.nuc.springboot.task;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot04TaskApplicationTests {

    @Autowired
    JavaMailSenderImpl javaMailSender;

    @Test
    public void contextLoads() {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("中北大学皮皮虾");
        message.setText("七道门的皮皮虾");
        message.setTo("694458593@qq.com");
        message.setFrom("18935026570@163.com");
        javaMailSender.send(message);
    }

    @Test
    public void contextLoads2() {

        MimeMessage message = javaMailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
            helper.setSubject("中北大学皮皮虾");
            helper.setText("<b>七道门的皮皮虾</b>",true);
            helper.setTo("694458593@qq.com");
            helper.setFrom("18935026570@163.com");
            helper.addAttachment("1.jpg", new File("C:\\Users\\孔先生\\Desktop\\1.png"));

        } catch (MessagingException e) {
            e.printStackTrace();
        }


        javaMailSender.send(message);
    }

}

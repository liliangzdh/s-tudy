package com.yue.api.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.internet.MimeMessage;

@RestController
@RequestMapping("email")
@Api(tags = "邮件", description = "邮件", value = "邮件")
public class EmailController {


    @Autowired
    JavaMailSenderImpl javaMailSender;

    @Value("${spring.mail.username}")
    private String from;

    @RequestMapping("send")
    @ApiImplicitParam(value = "发送邮件")
    public String sendEmail() {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(from);
            message.setTo("1582880360@qq.com"); // 接收地址
            message.setSubject("一封简单的邮件"); // 标题
            message.setText("使用Spring Boot发送简单邮件。"); // 内容
            javaMailSender.send(message);
            return "发送完成";
        } catch (Exception e) {
            e.printStackTrace();
            return "发送失败";
        }
    }


    @RequestMapping("sendHtml")
    @ApiImplicitParam(value = "发送邮件")
    public String sendHtmlEmail() {
        try {

            MimeMessage mimeMessage = javaMailSender.createMimeMessage();


            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
            helper.setFrom(from);
            helper.setTo("1582880360@qq.com");
            helper.setSubject("一封带 HTML 格式的  邮件");
            helper.setText("<p style='color:#f00'> 阿萨斯大多</p>",true);

            javaMailSender.send(mimeMessage);

            return "发送完成";
        } catch (Exception e) {
            e.printStackTrace();
            return "发送失败";
        }
    }

}

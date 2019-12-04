package com.xub.mail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;


/*
* 邮件发送服务
* */
@Service
public class MailService {

    /*
    * 收件人
    * */
    @Value("xubliqingxu@163.com")
    private String from;


    /*
    * 封装的Java_Mail对象
    * */
    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private TemplateEngine templateEngine;


    /*
    * 发送纯文本邮件
    * */
    public void senSimpleEmail(String toPerson,String subject,String content){
        SimpleMailMessage message=new SimpleMailMessage();
        message.setTo(toPerson);//收件人
        message.setSubject(subject);//主题
        message.setText(content);//内容
        message.setFrom(from);//发件人
        mailSender.send(message);
    }


    /*
    * 发送Html页面邮件
    * */
    public void senHtmlEmail(String toPerson,String subject,String content){
        MimeMessage message=mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper=new MimeMessageHelper(message,true);
            helper.setTo(toPerson);//收件人
            helper.setSubject(subject);//主题
            helper.setText(content,true);//内容
            helper.setFrom(from);//发件人
            mailSender.send(message);
        }catch (MessagingException e) {
            e.printStackTrace();
        }catch (MailException e){
            e.printStackTrace();
        }
    }


    /*
    * 发送附件邮件
    * */
    public void senAttachmentEmail(String toPerson,String subject,String content,String filePath){
        MimeMessage message=mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper=new MimeMessageHelper(message,true);
            helper.setTo(toPerson);//收件人
            helper.setSubject(subject);//主题
            helper.setText(content,true);//内容
            helper.setFrom(from);//发件人
            FileSystemResource file=new FileSystemResource(new File(filePath)); //从文件路径获取文件
            String fileName=file.getFilename();//获取文件名
            helper.addAttachment(fileName,file);//添加附件（文件名及文件内容）
            mailSender.send(message);
        }catch (MessagingException e) {
            e.printStackTrace();
        }catch (MailException e){
            e.printStackTrace();
        }
    }


    /*
    * 发送图片邮件
    * */
    public void senInlineResourceEmail(String toPerson,String subject,String content,String rscPath,String rid){
        MimeMessage message=mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper=new MimeMessageHelper(message,true);
            helper.setTo(toPerson);//收件人
            helper.setSubject(subject);//主题
            helper.setText(content,true);//内容
            helper.setFrom(from);//发件人
            FileSystemResource file=new FileSystemResource(new File(rscPath)); //从文件路径获取文件
            helper.addInline(rid,file);//添加图片（资源id及文件内容）
            mailSender.send(message);
        }catch (MessagingException e) {
            e.printStackTrace();
        }catch (MailException e){
            e.printStackTrace();
        }
    }

    /*
    * 发送模板邮件
    * */
    public void sendTemplateEmail(String toPerson,String subject,String content) {
        MimeMessage message=mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper=new MimeMessageHelper(message,true);
            helper.setTo(toPerson);//收件人
            helper.setSubject(subject);//主题
            // 处理邮件模板
            Context context = new Context();
            context.setVariable("id", content);
            String template = templateEngine.process("emailTemplate", context);
            helper.setText(template, true);
            helper.setFrom(from);//发件人
            mailSender.send(message);
        }catch (MessagingException e) {
            e.printStackTrace();
        }catch (MailException e){
            e.printStackTrace();
        }
    }

}

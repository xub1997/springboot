package com.xub.mail;

import com.xub.mail.service.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Resource
    MailService mailService;

    @Resource
    TemplateEngine templateEngine;


    /*
    * 测试发送纯文本邮件
    * */
    @Test
    public void testSendSimpleMail(){
        mailService.senSimpleEmail("emailaddress@qq.com","这是第一封纯文本邮件","纯文本邮件");
    }


    /*
     * 测试发送Html页面邮件
     * */
    @Test
    public void testSendHtmlMail(){
        String content="<html>\n<head>\n<title>hello</title>\n</head><body>\n<h1>Hello world!</h1>\n</body>\n</html>";
        mailService.senHtmlEmail("emailaddress@qq.com","这是一封Html邮件",content);
    }


    /*
     * 测试发送附件邮件
     * */
    @Test
    public void testSendAttachmentMail(){
        String filePath="C:\\Users\\fff\\Desktop\\pycharm快捷键.txt";
        mailService.senAttachmentEmail("emailaddress@qq.com","这是一封附件邮件",
                "附件邮件",filePath);
    }


    /*
    * 测试发送图片邮件
    * */
    @Test
    public void testInLineResourceMail(){
        String imagePath="C:\\Users\\fff\\Desktop\\test.jpg";
        String rscId="1";
        String content="<html>\n<head>\n<title>hello</title>\n</head><body>\n<h1>这个是有图片的邮件：</h1>\n" +
                "<img src=\'cid:"+rscId
                +"\'></img></body>\n</html>";
        mailService.senInlineResourceEmail("emailaddress@qq.com","这是一封附件邮件",
                content,imagePath,rscId);
    }


    /*
     * 测试发送模板邮件（Html页面邮件）
     * */
    @Test
    public void testTemplateMail(){
        Context context=new Context();
        context.setVariable("id","001");
        String emailContent=templateEngine.process("emailTemplate",context);
        mailService.senHtmlEmail("emailaddress@qq.com","这是一个模板邮件",emailContent);
    }



}

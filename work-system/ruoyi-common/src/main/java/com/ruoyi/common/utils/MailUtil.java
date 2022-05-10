package com.ruoyi.common.utils;

import com.sun.mail.util.MailSSLSocketFactory;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.security.GeneralSecurityException;
import java.sql.Date;
import java.util.Properties;

/**
 * @program: ruoyi
 * @description:
 * @author:
 * @create: 2022-05-06 15:18
 */
public class MailUtil {
    private static Session session;
    private static MailUtil mailUtil;

    public static MailUtil getMailUtil() {
        //第一次创建mailUtil时进行配置
        if (mailUtil == null) {
            Properties props = new Properties();
            // 发送邮件的服务器的IP和端口
            //设置发件人的SMTP的服务器地址
            props.put("mail.smtp.host", "smtp.qq.com");
            props.put("mail.smtp.port", 465);
            props.put("mail.smtp.ssl.enable", "true");
            //设置传输协议
            props.setProperty("mail.transport.protocol", "smtp");
            //设置用户的认证方式auth
            props.setProperty("mail.smtp.auth", "true");
            MailSSLSocketFactory sf = null;
            try {
                sf = new MailSSLSocketFactory();
                sf.setTrustAllHosts(true);
            } catch (GeneralSecurityException e1) {
                e1.printStackTrace();
            }
            props.put("mail.smtp.ssl.socketFactory", sf);
            props.put("mail.smtp.socketFactory.port", 465);
            session = Session.getDefaultInstance(props, new Authenticator() {
                @Override
                public PasswordAuthentication getPasswordAuthentication() {
                    //发件人邮件用户名、密码,xxxx自己设置
                    return new PasswordAuthentication("2474261466@qq.com", "qfeyisancpdodjee");
                }
            });
            session.setDebug(true);
            mailUtil = new MailUtil();
        }
        return mailUtil;
    }

    //发送邮件
    public void sendEmail(String email) {
        try {
            // 设置session,和邮件服务器进行通讯。
            MimeMessage message = new MimeMessage(session);
            // 设置邮件主题
            message.setSubject("您有一条新的邮件待确认");
            // 发送 HTML 消息, 可以插入html标签
            message.setContent("【工单管理系统】待确认邮件(请不要回复此邮件)"+
                    "<p>尊敬的用户：</p>\n" +
                            "<p>你有一个待确认的工单,请及时确认！</p>\n"
, "text/html;charset=UTF-8");
            // 设置邮件发送日期
            message.setSentDate(new Date(System.currentTimeMillis()));
            //设置发送邮件使用的邮箱地址
            Address address = new InternetAddress("2474261466@qq.com");
            message.setFrom(address);
            // 设置邮件接收方的地址
            Address toAddress = new InternetAddress(email);
            message.addRecipient(Message.RecipientType.TO, toAddress);
            // 发送邮件
            Transport.send(message);
            System.out.println("send ok!");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }


}

package com.demo.email;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

/**
 * 描述：
 * 作者：zc741
 * 时间：2018/8/1 12:45.
 */
public class EmailManager {

    private static EmailConfig config = new EmailConfig();

    private static Logger logger = LoggerFactory.getLogger(EmailManager.class);

    static {
        try (InputStream stream = ConfigUtils.getInputStream("email.properties")) {
            Properties properties = new Properties();
            properties.load(stream);
            readConfig(properties);
        } catch (Exception e) {
            logger.error("email.properties not found:" + e.getMessage());
        }
    }

    private static void readConfig(Properties properties) {
        config.setMailServerHost(properties.getProperty("serverHost"));
        config.setMailServerPort(properties.getProperty("serverPort"));
        config.setUserName(properties.getProperty("userName"));
        config.setPassword(properties.getProperty("password"));
        config.setNickname(properties.getProperty("nickname"));
        config.setFromAddress(properties.getProperty("fromAddress"));

        if (config.getMailServerHost() == null) {
            logger.error("serverHost is null");
        }
        if (config.getMailServerPort() == null) {
            logger.error("serverPort is null");
        }
        if (config.getUserName() == null) {
            logger.error("userName is null");
        }
        if (config.getPassword() == null) {
            logger.error("password is null");
        }
        if (config.getNickname() == null) {
            logger.error("nickname is null");
        }
        if (config.getFromAddress() == null) {
            logger.error("fromAddress <= 0");
        }
    }

    public static boolean sendEmail(String toAddress, String subject, String content) {
        return send(toAddress, subject, content);
    }

    public static boolean send(String toAddressList, String subject, String content) {
        return sendCC(toAddressList, null, subject, content);
    }

    public static boolean sendCC(String toAddressList, String ccAdressList, String subject, String content) {
        Properties properties = new Properties();
        properties.put("mail.smtp.host", config.getMailServerHost());
        properties.put("mail.smtp.port", config.getMailServerPort());
        properties.put("mail.smtp.auth", true);

        Authentication authenticator = new Authentication(config.getUserName(), config.getPassword());
        Session sendMailSession = Session.getDefaultInstance(properties, authenticator);
        try {

            Message mailMessage = new MimeMessage(sendMailSession);
            String nickname = "";
            try {
                nickname = MimeUtility.encodeText(config.getNickname());
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            Address from = new InternetAddress(nickname + "<" + config.getFromAddress() + ">");
            mailMessage.setFrom(from);
            mailMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toAddressList));
            if (null != ccAdressList) {
                mailMessage.setRecipients(Message.RecipientType.CC, InternetAddress.parse(ccAdressList));
            }
            mailMessage.setSubject(subject);
            mailMessage.setSentDate(new Date());
            mailMessage.setContent(content, "text/html;charset=utf-8");
            Transport.send(mailMessage);
            return true;
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return false;
    }

}

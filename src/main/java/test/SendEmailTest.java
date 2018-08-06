package test;


import com.demo.email.EmailManager;
import org.junit.jupiter.api.Test;

public class SendEmailTest {

    @Test
    public void sendMail() {
        String toAddress = "yuann@langzichu.com";
        String subject = "你好邮件";
        String content = "content";
        EmailManager.send(toAddress, subject, content);
    }
}

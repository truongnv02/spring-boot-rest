package com.poly.truongnvph29176.util;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailUtil {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendOtpEmail(String email, String otp) throws MessagingException {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(email);
        simpleMailMessage.setSubject("Verify OTP");
        simpleMailMessage.setText("Hello, your OTP is " + otp);

//        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
//        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
//        mimeMessageHelper.setTo(email);
//        mimeMessageHelper.setSubject("Verify OTP");
//        mimeMessageHelper.setText("""
//                    <div>
//                        <a href="http://localhost:8080/verify-account?email=%s&otp=%s" target="_blank">
//                            Click link to verify
//                        </a>
//                    </div>
//                """.formatted(email, otp), true);
        javaMailSender.send(simpleMailMessage);
    }
}

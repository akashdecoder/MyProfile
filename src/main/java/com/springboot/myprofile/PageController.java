package com.springboot.myprofile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class PageController {

    @Autowired
    private JavaMailSender mailSender;

    @GetMapping("/akash")
    public String showHomePage() {
        return "profilepage.html";
    }

    @PostMapping("/akash/sentMail")
    public String sendMail(HttpServletRequest request) {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String phone = request.getParameter("contact").toString();
        String subject = request.getParameter("subject");
        String message = request.getParameter("message") + "\nName: " + username + "\nEmail: " + email + "\n" +
                "Contact: " + phone;

        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setFrom(email);
        mailMessage.setTo("akashranjan.1si18cs008@gmail.com");

        mailMessage.setSubject(subject);
        mailMessage.setText(message);

        mailSender.send(mailMessage);

        return "message.html";

    }
}

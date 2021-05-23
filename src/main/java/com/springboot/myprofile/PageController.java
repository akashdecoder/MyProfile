package com.springboot.myprofile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class PageController {

    @Autowired
    private JavaMailSender mailSender;

    Logger logger = LoggerFactory.getLogger(PageController.class);

    @GetMapping("/")
    public String showHomePage() {
        return "profilepage";
    }

    @RequestMapping(value = "sentMail", method = RequestMethod.POST)
    public String sendMail(HttpServletRequest request) {
        logger.info(request.getParameter("username"));
        System.out.println(request.getParameter("username"));
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
        return "message";

    }
}

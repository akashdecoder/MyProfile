package com.springboot.myprofile;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller
public class PageController {

    @Autowired
    private JavaMailSender mailSender;

    Logger logger = LoggerFactory.getLogger(PageController.class);

    @GetMapping("/")
    public String showHomePage(Model model) throws IOException {
        List<Tags> linkslists = new ArrayList<Tags>();
        String arr[] = new String[3];
        FileInputStream fin = new FileInputStream(new File("src/main/links.xlsx"));
        XSSFWorkbook wb = new XSSFWorkbook(fin);
        XSSFSheet sheet = wb.getSheetAt(0);
        Iterator<Row> ritr = sheet.iterator();
        ritr.next();
        int index=0;
        while(ritr.hasNext()) {
            index = 0;
            Row row = ritr.next();
            Iterator<Cell> citr = row.cellIterator();
            while(citr.hasNext()) {
                Cell cell = citr.next();
                arr[index++] = cell.getStringCellValue();
            }
            linkslists.add(new Tags(arr[0], arr[1], arr[2]));
        }
        model.addAttribute("linkslists", linkslists);

        return "profilepage";
    }
    
    @GetMapping("/message")
    public String showMailPage() {
        return "message";
    }

    @RequestMapping(value = "/sentMail", method = RequestMethod.POST)
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
        return "message.html";

    }
}

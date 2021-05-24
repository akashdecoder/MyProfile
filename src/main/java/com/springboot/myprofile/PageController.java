package com.springboot.myprofile;

import com.springboot.myprofile.firebase.UserService;
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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Controller
public class PageController {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private UserService userService;

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


    @PostMapping("/sentMail")
    public String sendMail(HttpServletRequest request) throws ExecutionException,
            InterruptedException {


        String username = request.getParameter("username");
        long phone = Long.parseLong(request.getParameter("contact"));
        String email = request.getParameter("email");
        String subject = request.getParameter("subject");
        String message = request.getParameter("message");
        User user = new User(username, phone, email, subject, message);
        logger.info(String.valueOf(user));
        System.out.println(user.getMessage());
        userService.saveUser(user);

        return "message.html";

    }
}

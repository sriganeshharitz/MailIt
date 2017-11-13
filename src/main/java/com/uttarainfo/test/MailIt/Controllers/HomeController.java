package com.uttarainfo.test.MailIt.Controllers;

import com.sun.mail.smtp.SMTPAddressFailedException;
import com.uttarainfo.test.MailIt.Model.Constants;
import com.uttarainfo.test.MailIt.Model.EmailBean;
import com.uttarainfo.test.MailIt.Model.Student;
import com.uttarainfo.test.MailIt.Services.EmailService;
import com.uttarainfo.test.MailIt.Services.ExcelService;
import org.hibernate.validator.constraints.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.Address;
import javax.mail.SendFailedException;
import javax.validation.Valid;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private EmailService emailService;

    @Autowired
    private ExcelService excelService;

    @RequestMapping({"/",""})
    public String showHome(){
        System.out.println("In showHome() of Home Controller");
        return "Home";
    }

    @RequestMapping("/showForm")
    public String showForm(Model model){
        System.out.println("In showForm() if Home Controller");
        EmailBean emailBean = new EmailBean();
        model.addAttribute("emailBean",emailBean);
        return "Form";
    }

    @RequestMapping("/sendMail")
    public String sendMail(@ModelAttribute("emailBean") @Valid EmailBean emailBean, BindingResult result, Model model,@RequestParam("file") MultipartFile file){
        if(result.hasErrors()){
            return "Form";
        }
        System.out.println(emailBean);
        System.out.println(emailBean.getRecipients().size());
        String status = "";
        if(emailBean.getRecipients().size()!=0) {
            status = emailService.sendEmail(emailBean);
            if (status.equals(Constants.SUCCESS))
                return "Success";
            else {
                model.addAttribute("error", status);
                return "Failure";
            }
        }
        else {
            System.out.println("There are no recipients");
            if(file==null||file.isEmpty()){
                model.addAttribute("error","Please choose a file");
                return "Form";
            }
            List<Student> students = excelService.readExcel(file);
            if(students==null){
                model.addAttribute("error","Oops something happened while reading file");
                return "Failure";
            }
            status = emailService.sendEmail(students,emailBean);
            if(status.equals(Constants.SUCCESS))
                return "Success";
            else {
                model.addAttribute("error","Oops something happened while sending mails");
                return "Failure";
            }

        }
    }
}

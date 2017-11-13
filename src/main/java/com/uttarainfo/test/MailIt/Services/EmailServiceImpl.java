package com.uttarainfo.test.MailIt.Services;

import com.sun.mail.smtp.SMTPAddressFailedException;
import com.uttarainfo.test.MailIt.Model.Constants;
import com.uttarainfo.test.MailIt.Model.EmailBean;
import com.uttarainfo.test.MailIt.Model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.lang.invoke.ConstantCallSite;
import java.util.List;

@Service
public class EmailServiceImpl implements EmailService {
    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public String sendEmail(EmailBean emailBean){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        List<String> recipients = emailBean.getRecipients();
        simpleMailMessage.setBcc(recipients.toArray(new String[recipients.size()]));
        simpleMailMessage.setSubject(emailBean.getSubject());
        simpleMailMessage.setText(emailBean.getBody());
        javaMailSender.send(simpleMailMessage);
        return Constants.SUCCESS;


//        catch (SMTPAddressFailedException e){
//            e.printStackTrace();
//            String[] messages = e.getLocalizedMessage().split("<");
//            String[] message = messages[1].split(">");
//            //return message[0]+" is not a valid email address";
//            return "zzz";
//        }
    }

    @Override
    public String sendEmail(List<Student> students,EmailBean emailBean) {
        if(students==null||students.size()==0){
            return "List is empty";
        }
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        for(Student student:students){
            simpleMailMessage.setSubject(emailBean.getSubject());
            simpleMailMessage.setTo(student.getEmail());
            StringBuilder sb = new StringBuilder("Hello ");
            sb.append(student.getFirstName());
            sb.append(" ");
            sb.append(student.getLastName());
            sb.append(",\n\n");
            sb.append("Your UIT scores are as follows:\n");
            sb.append("Java : ");
            sb.append(student.getJavaScore());
            sb.append("\nAptitude : ");
            sb.append(student.getAptitudeScore());
            sb.append("\n\nRegards,\nSriganesh.");
            simpleMailMessage.setText(sb.toString());
            javaMailSender.send(simpleMailMessage);
        }
        return Constants.SUCCESS;
    }

}

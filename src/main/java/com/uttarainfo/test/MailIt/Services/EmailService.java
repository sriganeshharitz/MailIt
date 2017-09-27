package com.uttarainfo.test.MailIt.Services;

import com.sun.mail.smtp.SMTPAddressFailedException;
import com.uttarainfo.test.MailIt.Model.EmailBean;
import com.uttarainfo.test.MailIt.Model.Student;

import java.util.List;

public interface EmailService {
    public String sendEmail(EmailBean emailBean);
    public String sendEmail(List<Student> students,EmailBean emailBean);
}

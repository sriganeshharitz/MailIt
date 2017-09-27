package com.uttarainfo.test.MailIt.Model;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.List;

public class EmailBean {

    private List<String> recipients;
    @NotNull
    @NotBlank
    private String subject;
    private String body;

    public EmailBean() {
    }

    public EmailBean(List<String> recipients, String subject, String body) {
        this.recipients = recipients;
        this.subject = subject;
        this.body = body;
    }

    public List<String> getRecipients() {
        return recipients;
    }

    public void setRecipients(List<String> recipients) {
        this.recipients = recipients;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "EmailBean{" +
                "recipients=" + recipients +
                ", subject='" + subject + '\'' +
                ", body='" + body + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmailBean)) return false;

        EmailBean emailBean = (EmailBean) o;

        if (!recipients.equals(emailBean.recipients)) return false;
        if (!subject.equals(emailBean.subject)) return false;
        return body.equals(emailBean.body);
    }

    @Override
    public int hashCode() {
        int result = recipients.hashCode();
        result = 31 * result + subject.hashCode();
        result = 31 * result + body.hashCode();
        return result;
    }
}

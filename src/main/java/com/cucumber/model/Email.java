package com.cucumber.model;

import java.io.File;

import static com.cucumber.service.TestDataReader.getTestData;
import static com.cucumber.util.Constants.Properties.*;

public class Email {

    private String emailRecipient;
    private String emailSubject = null;
    private String emailMessage = null;
    private File emailAttachment = null;

    public Email() {
        this("default_Testemail@gmail.com");
    }

    public Email(String emailRecipient) {
        this.emailRecipient = emailRecipient;
    }

    public String getEmailSubject() {
        return emailSubject;
    }

    public void setEmailSubject(String subject) {
        this.emailSubject = subject;
    }

    public String getEmailRecipient() {
        return emailRecipient;
    }

    public void setEmailRecipient(String recipient) {
        this.emailRecipient = recipient;
    }

    public String getEmailMessage() {
        return emailMessage;
    }

    public void setEmailMessage(String message) {
        this.emailMessage = message;
    }

    public File getEmailAttachment() {
        return emailAttachment;
    }

    public void setEmailAttachment(File attachment) {
        this.emailAttachment = attachment;
    }

    public Email composeSimpleEmail() {
        Email email = new Email();
        email.setEmailSubject(getTestData(EMAIL_SUBJECT));
        email.setEmailRecipient(getTestData(EMAIL_RECIPIENT));
        return email;
    }

}

package com.cucumber.factory;

import com.cucumber.model.Email;

import java.io.File;

import static com.cucumber.service.TestDataReader.getTestData;
import static com.cucumber.util.Constants.Properties.EMAIL_RECIPIENT;
import static com.cucumber.util.Constants.Properties.EMAIL_SUBJECT;

public class EmailFactory {

    public static Email composeSimpleEmail() {
        Email email = new Email(getTestData(EMAIL_RECIPIENT));
        email.setEmailSubject(getTestData(EMAIL_SUBJECT));
        return email;
    }

    public static Email composeEmailWithMessage(String message) {
        Email email = composeSimpleEmail();
        email.setEmailMessage(message);
        return email;
    }

    public static Email composeEmailWithAttachment(File attachment) {
        Email email = composeSimpleEmail();
        email.setEmailAttachment(attachment);
        return email;
    }
}

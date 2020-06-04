package com.cucumber.steps;

import com.cucumber.driver.DriverSingletonFactory;
import com.cucumber.factory.EmailFactory;
import com.cucumber.model.Email;
import com.cucumber.model.User;
import com.cucumber.pages.*;
import com.cucumber.service.UserBuilder;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static com.cucumber.service.TestDataReader.getTestData;
import static com.cucumber.util.Constants.Properties.*;

public class DraftEamilSteps {
    WebDriver driver = DriverSingletonFactory.getDriver();
    InboxPage inboxPageObject = PageFactory.getInboxPage();
    ComposeEmailPage composeEmailPage = new ComposeEmailPage(driver);
    Email email = EmailFactory.composeEmailWithMessage(getTestData(EMAIL_MESSAGE));

    @Given("user is signed in and inbox is open")
    public void login(){
        User testUser = UserBuilder.withCredentialsFromProperty();
        inboxPageObject = new SignInlPage(driver)
                .openSignInPage().login(testUser);
        inboxPageObject.waitForThePageToLoad();
        Assert.assertTrue(driver.getCurrentUrl().contains("inbox"));
    }

    @When("user compose an email, save and close it")
    public void composeEmailSaveAndCloseIt(){

        composeEmailPage.composeAnEmail(email);
        composeEmailPage.saveAndCloseMessageForm();
    }

    @When("user open {string} folder")
    public void openFolder(String folderName){
        inboxPageObject.openFolder(folderName);
    }

    @When("clicks on the first draft email")
    public void clickFirstDraft(){
        inboxPageObject.clickOnFirstDaft();
    }

    @When("see recipient, subject and message")
    public void assertEmail(){
        Assert.assertEquals(email.getEmailRecipient(), getTestData(EMAIL_RECIPIENT));
        Assert.assertEquals(email.getEmailSubject(), getTestData(EMAIL_SUBJECT));
        Assert.assertEquals(email.getEmailMessage(), getTestData(EMAIL_MESSAGE));
    }

    @When("see recipient, subject and message in email details")
    public void assertEmailInDetails(){
        EmailDetailsPage emailDetailsPage = new EmailDetailsPage(driver);
        Assert.assertEquals(emailDetailsPage.getRecipientFromEmailDetailsPage(), getTestData(EMAIL_RECIPIENT));
        Assert.assertEquals(emailDetailsPage.getSubjectFromEmailDetailsPage(), getTestData(EMAIL_SUBJECT));
        Assert.assertEquals(emailDetailsPage.getMessageTextFromEmailDetailsPage(), getTestData(EMAIL_MESSAGE));
    }

    @When("user send email from draft")
    public void sendEmail() {
        composeEmailPage.sendEmail();
    }

    @Then("see draft folder is empty")
    public void seeDraftFolderIsEmpty() {
        Assert.assertTrue(inboxPageObject.isDraftsFolderEmpty());
    }

    @When("click on the first send email")
    public void clickOnTheFirstSendEmail() {
        inboxPageObject.clickOnFirstSent();
    }

    @When("user log out")
    public void userLogOut() {
        inboxPageObject.clickOnTheAccount();
        inboxPageObject.clickSignOut(getTestData(USERNAME) + "@gmail.com");
    }


}

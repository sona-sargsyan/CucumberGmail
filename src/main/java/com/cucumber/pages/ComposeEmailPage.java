package com.cucumber.pages;

import com.cucumber.model.Email;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ComposeEmailPage extends BasePage {

    @FindBy(xpath = "//div[text()=\"Compose\"]")
    private WebElement composeEmail;
    @FindBy(xpath = "//textarea[@name=\"to\"]")
    private WebElement recipientAddress;
    @FindBy(xpath = "//input[@name=\"subjectbox\"]")
    private WebElement emailSubject;
    @FindBy(xpath = "//div[@aria-label=\"Message Body\"]")
    private WebElement emailMessage;
    @FindBy(xpath = "//div[text()=\"Send\"]")
    private WebElement sendEmailButton;
    @FindBy(xpath = "//img[@aria-label=\"Save & close\"]")
    private WebElement messageSaveAndCloseButton;
    @FindBy(xpath = "//div[@aria-label=\"More send options\"]")
    private WebElement moreSendOptions;

    public ComposeEmailPage(WebDriver driver) {
        super(driver);
    }

    public void composeAnEmail(Email email) {
        waitForThePageToLoad();
        openNewMessageForm();
        new WebDriverWait(driver, GLOBAL_TIMEOUT).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//textarea[@name=\"to\"]")));
        fillAddress(email.getEmailRecipient());
        fillEmailSubject(email.getEmailSubject());
        fillTextMessage(email.getEmailMessage());
    }

    public void waitForThePageToLoad() {
        new WebDriverWait(driver, GLOBAL_TIMEOUT).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()=\"Compose\"]")));
        new WebDriverWait(driver, GLOBAL_TIMEOUT).until(ExpectedConditions.urlContains("inbox"));
    }

    public void openNewMessageForm() {
        new WebDriverWait(driver, GLOBAL_TIMEOUT).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()=\"Compose\"]")));
        composeEmail.click();
    }

    public void fillAddress(String address) {
        recipientAddress.sendKeys(address);
    }

    public void fillTextMessage(String message) {
        emailMessage.sendKeys(message);
    }

    public void fillEmailSubject(String emailSubject) {
        this.emailSubject.sendKeys(emailSubject);
    }

    public void saveAndCloseMessageForm() {
        new WebDriverWait(driver, GLOBAL_TIMEOUT).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class=\"aYF\" and text()=\"Draft saved\"]")));
        messageSaveAndCloseButton.click();
    }

    public void sendEmail() {
        sendEmailButton.click();
        new WebDriverWait(driver, GLOBAL_TIMEOUT).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()=\"Message sent.\"]")));
    }

    public void openMoreSendOptions() {
        moreSendOptions.click();
    }

    public String getAddress() {
        WebElement filledRecipientAddress = new WebDriverWait(driver, GLOBAL_TIMEOUT).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"aoD hl\"]//span")));
        return filledRecipientAddress.getText();
    }

    public String getEmailSubject() {
        return this.emailSubject.getAttribute("value");
    }

    public String getTextMessage() {
        new WebDriverWait(driver, GLOBAL_TIMEOUT).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@aria-label=\"Message Body\"]")));
        return emailMessage.getText();
    }
}

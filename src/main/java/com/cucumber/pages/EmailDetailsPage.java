package com.cucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmailDetailsPage extends BasePage {

    @FindBy(xpath = "//div[@class=\"a3s aXjCH \"]/div[1]")
    private WebElement messageTextFromSchedulePage;
    @FindBy(xpath = "//span[@class=\"hb\"]/span")
    private WebElement recipientFromEmailDetailsPage;

    public EmailDetailsPage(WebDriver driver) {
        super(driver);
    }

    public String getSubjectFromEmailDetailsPage() {
        WebElement subjectFromSchedulePage = new WebDriverWait(driver, GLOBAL_TIMEOUT).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[@class=\"hP\"]")));
        return subjectFromSchedulePage.getText();
    }

    public String getMessageTextFromEmailDetailsPage() {
        return messageTextFromSchedulePage.getText();
    }

    public String getRecipientFromEmailDetailsPage() {
        return recipientFromEmailDetailsPage.getAttribute("data-hovercard-id");
    }

    public String getScheduledTimeFromEmailDetailsPage() {
        WebElement scheduledTimeFromEmailDetails = new WebDriverWait(driver, GLOBAL_TIMEOUT).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),\"Send scheduled for\")]")));
        return scheduledTimeFromEmailDetails.getText().substring(19, 26);
    }
}

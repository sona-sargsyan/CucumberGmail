package com.cucumber.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDateTime;
import java.util.List;

public class InboxPage extends BasePage {

    public LocalDateTime scheduledTime;

    @FindBy(xpath = "//tbody//tr[1]//td//div[@class=\"yW\"]//span[text()=\"Draft\"]")
    private WebElement firstRowOfTheDrifts;
    @FindBy(xpath = "//tbody//tr[1]//div[text()=\"To: \"]")
    private WebElement firstRowOfTheSent;
    @FindBy(xpath = "//tbody//td[text()=\"You don't have any saved drafts.\"]")
    private WebElement draftFolderEmptyText;
    @FindBy(xpath = "//div[@selector=\"scheduledSend\"]")
    private WebElement scheduledSend;
    @FindBy(xpath = "//div[@id=\"sbddm\"]")
    private WebElement scheduleSendButton;
    @FindBy(xpath = "//div[text()=\"Pick date & time\"]")
    private WebElement pickDateAndTime;
    @FindBy(name = "datetimepicker_dialog_confirm")
    private WebElement scheduledEmailSendButton;
    @FindBy(xpath = "//a[contains(@aria-label,\"Google Account\")]")
    private WebElement account;
    @FindBy(xpath = "//a[text()=\"Sign out\"]")
    private WebElement signout;

    public InboxPage(WebDriver driver) {
        super(driver);
    }

    public void deleteEmailFromEmailDetails() {
        Actions hover = new Actions(driver);
        WebElement deleteEmailFromEmailDetails = new WebDriverWait(driver, GLOBAL_TIMEOUT)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@title=\"Delete\"])[last()]")));
        hover.moveToElement(deleteEmailFromEmailDetails).build().perform();
        WebElement deleteEmailFromEmailDetails1 = new WebDriverWait(driver, GLOBAL_TIMEOUT)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@aria-label=\"Delete\"]")));
        deleteEmailFromEmailDetails1.click();
    }

    public void deleteEmailFromEmailDetailsByJS() {

        WebElement deleteEmailFromEmailDetails = new WebDriverWait(driver, GLOBAL_TIMEOUT)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@title=\"Delete\"])[last()]")));
        Actions hover = new Actions(driver);
        hover.moveToElement(deleteEmailFromEmailDetails).build().perform();
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        WebElement deleteEmailFromEmailDetails1 = new WebDriverWait(driver, GLOBAL_TIMEOUT)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@aria-label=\"Delete\"]")));
        javascriptExecutor.executeScript("arguments[0].click();", deleteEmailFromEmailDetails1);

    }

    public void hoverAndClickAdvancedSearchButton() {
        Actions hover = new Actions(driver);
        WebElement searchDropDownButton = new WebDriverWait(driver, GLOBAL_TIMEOUT)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@aria-label=\"Advanced search options\"]")));
        hover.moveToElement(searchDropDownButton).click().build().perform();
    }

    public void checkHasAttachmentCheckBox() {
        WebElement hasAttachmentCheckBox = new WebDriverWait(driver, GLOBAL_TIMEOUT)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()=\"Has attachment\"]")));
        hasAttachmentCheckBox.click();
    }

    public void clickAdvancedSearch() {
        WebElement advancedSearch = new WebDriverWait(driver, GLOBAL_TIMEOUT)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"SK ZF-zT\"]//div[text()=\"Search\"]")));
        advancedSearch.click();
    }

    public void clickOnTheAccount() {
        account.click();
        new WebDriverWait(driver, GLOBAL_TIMEOUT).until(ExpectedConditions.visibilityOf(signout));
    }

    public void clickSignOut(String email) {
        signout.click();
        try {
            Alert alert = new WebDriverWait(driver, 20).until(ExpectedConditions.alertIsPresent());
            alert.accept();
        } catch (TimeoutException e) {
        } finally {
            new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@data-identifier=\"mentor.mentroevich@gmail.com\"]")));
        }

    }

    public void pickDateAndTime() {
        new WebDriverWait(driver, GLOBAL_TIMEOUT).until(ExpectedConditions.visibilityOf(pickDateAndTime));
        pickDateAndTime.click();
    }

    public void scheduledEmailSend() {
        new WebDriverWait(driver, GLOBAL_TIMEOUT).until(ExpectedConditions.presenceOfElementLocated(By.name("datetimepicker_dialog_confirm")));
        scheduledTime = LocalDateTime.now().plusHours(1);
        scheduledEmailSendButton.click();
    }

    public void openScheduledSendFrame() {
        new WebDriverWait(driver, GLOBAL_TIMEOUT).until(ExpectedConditions.visibilityOf(scheduleSendButton));
        scheduledSend.click();
    }

    public void waitForThePageToLoad() {
        new WebDriverWait(driver, GLOBAL_TIMEOUT).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()=\"Compose\"]")));
        new WebDriverWait(driver, GLOBAL_TIMEOUT).until(ExpectedConditions.urlContains("inbox"));
    }

    public void clickTabAndEnterButtons() {
        Actions tabAndEnter = new Actions(driver);
        tabAndEnter.sendKeys(Keys.TAB).build().perform();
        tabAndEnter.sendKeys(Keys.ENTER).build().perform();
    }

    public void openFolder(String folderName) {
        WebElement folder = new WebDriverWait(driver, GLOBAL_TIMEOUT).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()=\"" + folderName + "\"]")));
        folder.click();
        new WebDriverWait(driver, GLOBAL_TIMEOUT).until(ExpectedConditions.urlContains(folderName.toLowerCase()));
    }

    public boolean isDraftsFolderEmpty() {
        return draftFolderEmptyText.isDisplayed();
    }

    public void clickOnFirstDaft() {
        new WebDriverWait(driver, GLOBAL_TIMEOUT).until(ExpectedConditions.urlContains("drafts"));
        new WebDriverWait(driver, GLOBAL_TIMEOUT).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tbody//tr[1]//td//span[text()=\"Draft\"]")));
        firstRowOfTheDrifts.click();
        new WebDriverWait(driver, GLOBAL_TIMEOUT).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class=\"M9\"]")));
    }

    public void clickOnFirstSent() {
        new WebDriverWait(driver, GLOBAL_TIMEOUT).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tbody//tr[1]//div[text()=\"To: \"]")));
        firstRowOfTheSent.click();
    }

    public void clickOnFirstScheduled() {
        new WebDriverWait(driver, GLOBAL_TIMEOUT).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tbody//tr[1]//div[text()=\"To: \"]")));
        firstRowOfTheSent.click();
    }

    public void clickOnFirstEmail() {
        WebElement firstRowOfInbox = new WebDriverWait(driver, GLOBAL_TIMEOUT).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tbody//tr[1]//div[@title=\"Inbox\"]")));
        firstRowOfInbox.click();
    }

    public void clickOnEmailBySubject(String subject) {
        List<WebElement> firstRowOfTheEmailList = new WebDriverWait(driver, GLOBAL_TIMEOUT)
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//span[text()=\"" + subject + "\"]")));
        for (WebElement firstEmail : firstRowOfTheEmailList) {
            if (firstEmail.isDisplayed())
                firstEmail.click();
        }

    }

    public boolean attachmentIsPresent() {

        if (new WebDriverWait(driver, GLOBAL_TIMEOUT).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class=\"ii gt\"]//img"))) != null)
            return true;
        else
            return false;
    }

    public boolean isEmailPresentsInList(String subject) {
        List<WebElement> firstRowOfTheEmailList = new WebDriverWait(driver, GLOBAL_TIMEOUT)
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//span[text()=\"" + subject + "\"]")));
        return (firstRowOfTheEmailList.size() > 0);
    }

    public void undoEmailDeletion() {
        WebElement undoButton = new WebDriverWait(driver, GLOBAL_TIMEOUT)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()=\"Undo\"]")));
        undoButton.click();
        new WebDriverWait(driver, GLOBAL_TIMEOUT).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()=\"Action undone.\"]")));
    }

    public boolean isEmailSend() {
        if (new WebDriverWait(driver, GLOBAL_TIMEOUT)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()=\"Message sent.\"]"))) != null) {
            return true;
        } else return false;
    }


}

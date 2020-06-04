package com.cucumber.pages;

import com.cucumber.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignInlPage extends BasePage {

    private static final String SIGNINEMAILPAGE_URL = "https://gmail.com";
    private static final Logger logger = LogManager.getRootLogger();

    @FindBy(id = "next")
    private WebElement nextButton;
    @FindBy(id = "Email")
    private WebElement email;
    @FindBy(name = "password")
    private WebElement passwordIdentifier;

    public SignInlPage(WebDriver driver) {
        super(driver);
    }

    public SignInlPage openSignInPage() {
        driver.get(SIGNINEMAILPAGE_URL);
        return this;
    }

    public void fillEmailIdentifier(String email) {
        try {
            WebElement emailIdentifierId = new WebDriverWait(driver, GLOBAL_TIMEOUT)
                    .until(ExpectedConditions.presenceOfElementLocated(By.id("identifierId")));
            emailIdentifierId.sendKeys(email);
        } catch (NoSuchElementException e) {
            this.email.sendKeys(email);
            e.printStackTrace();
        }
    }

    public void clickNextButtonOnEmailLogin() {
        try {
            WebElement emailNextButton = new WebDriverWait(driver, GLOBAL_TIMEOUT)
                    .until(ExpectedConditions.presenceOfElementLocated(By.id("identifierNext")));
            emailNextButton.click();
        } catch (NoSuchElementException e) {
            nextButton.click();
            e.printStackTrace();
        }
    }

    public void fillPasswordIdentifier(String password) {
        new WebDriverWait(driver, GLOBAL_TIMEOUT)
                .until(ExpectedConditions.visibilityOf(passwordIdentifier));
        passwordIdentifier.sendKeys(password);
    }

    public void clickNextButtonOnPasswordIdentifier() {
        WebElement passwordNextButton = new WebDriverWait(driver, GLOBAL_TIMEOUT)
                .until(ExpectedConditions.presenceOfElementLocated(By.id("passwordNext")));
        passwordNextButton.click();
    }

    public InboxPage login(User user) {
        fillEmailIdentifier(user.getUsername());
        clickNextButtonOnEmailLogin();
        fillPasswordIdentifier(user.getPassword());
        clickNextButtonOnPasswordIdentifier();
        logger.info("Successful signed in");
        return new InboxPage(driver);
    }
}


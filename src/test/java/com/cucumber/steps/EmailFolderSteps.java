package com.cucumber.steps;

import com.cucumber.driver.DriverSingletonFactory;
import com.cucumber.pages.InboxPage;
import com.cucumber.pages.PageFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class EmailFolderSteps {

    WebDriver driver = DriverSingletonFactory.getDriver();
    InboxPage inboxPageObject = PageFactory.getInboxPage();

    @Then("^see (.*) folder name in URL$")
    public void seeFolderNameInURL(String folderName) {
        Assert.assertTrue(driver.getCurrentUrl().contains(folderName.toLowerCase()));
    }

    @When("^user open (.*) folder$")
    public void openFolder(String folderName){
        inboxPageObject.openFolder(folderName);
    }

}

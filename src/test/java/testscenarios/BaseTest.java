package testscenarios;

import com.cucumber.driver.DriverSingletonFactory;
import com.cucumber.model.User;
import com.cucumber.util.TestListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.cucumber.pages.InboxPage;
import com.cucumber.pages.SignInlPage;
import com.cucumber.service.UserBuilder;
import org.testng.annotations.Listeners;

import static com.cucumber.service.TestDataReader.getTestData;
import static com.cucumber.util.Constants.Properties.USERNAME;

@Listeners({TestListener.class})
public class BaseTest {

    protected WebDriver driver;
    protected InboxPage inboxPageObject;

    @BeforeMethod(alwaysRun = true)
    public void browserSetupAndLogin() {
        driver = DriverSingletonFactory.getDriver();
        User testUser = UserBuilder.withCredentialsFromProperty();
        inboxPageObject = new SignInlPage(driver)
                .openSignInPage().login(testUser);
    }

    @AfterMethod(alwaysRun = true)
    public void SignOutAndTearDownBrowser() {
        inboxPageObject.clickOnTheAccount();
        inboxPageObject.clickSignOut(getTestData(USERNAME) + "@gmail.com");
        DriverSingletonFactory.closeDriver();
    }
}

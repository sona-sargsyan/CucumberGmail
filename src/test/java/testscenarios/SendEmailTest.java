package testscenarios;

import com.cucumber.factory.EmailFactory;
import com.cucumber.model.Email;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.cucumber.pages.ComposeEmailPage;
import com.cucumber.pages.EmailDetailsPage;
import com.cucumber.util.ElementHighlighter;

import static com.cucumber.service.TestDataReader.getTestData;
import static com.cucumber.util.Constants.Properties.*;

public class SendEmailTest extends BaseTest {
    @Test
    public void sendEmailByEnterButtonTest() {
        Email email = EmailFactory.composeEmailWithMessage(getTestData(EMAIL_MESSAGE));

        inboxPageObject.waitForThePageToLoad();
        Assert.assertTrue(driver.getCurrentUrl().contains("inbox"));
        ComposeEmailPage composeEmailPage = new ComposeEmailPage(driver);
        composeEmailPage.composeAnEmail(email);
        inboxPageObject.clickTabAndEnterButtons();
        Assert.assertTrue(inboxPageObject.isEmailSend());
        inboxPageObject.openFolder("Sent");
        inboxPageObject.clickOnFirstSent();
        EmailDetailsPage emailDetailsPage = new EmailDetailsPage(driver);
        Assert.assertEquals(emailDetailsPage.getRecipientFromEmailDetailsPage(), getTestData(EMAIL_RECIPIENT));
        Assert.assertEquals(emailDetailsPage.getSubjectFromEmailDetailsPage(), getTestData(EMAIL_SUBJECT));
        Assert.assertEquals(emailDetailsPage.getMessageTextFromEmailDetailsPage(), getTestData(EMAIL_MESSAGE));

    }

    @Test
    public void highlightComposeEmail() {
        ElementHighlighter.highlightWebElement(driver, new WebDriverWait(driver, 60)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()=\"Compose\"]"))));
    }

}

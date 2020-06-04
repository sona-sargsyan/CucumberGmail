package testscenarios;

import com.cucumber.factory.EmailFactory;
import com.cucumber.model.Email;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.cucumber.pages.ComposeEmailPage;
import com.cucumber.pages.EmailDetailsPage;
import com.cucumber.pages.InboxPage;
import com.cucumber.util.DateUtil;

import static com.cucumber.service.TestDataReader.getTestData;
import static com.cucumber.util.Constants.Properties.*;

public class ScheduleSentEmailTest extends BaseTest {

    @Test
    public void scheduleSentEmailTest() {
        Email email = EmailFactory.composeEmailWithMessage(getTestData(EMAIL_MESSAGE));

        inboxPageObject = new InboxPage(driver);
        inboxPageObject.waitForThePageToLoad();
        ComposeEmailPage composeEmailPage = new ComposeEmailPage(driver);
        composeEmailPage.composeAnEmail(email);
        composeEmailPage.openMoreSendOptions();
        inboxPageObject.openScheduledSendFrame();
        inboxPageObject.pickDateAndTime();
        inboxPageObject.scheduledEmailSend();
        String formattedTime = DateUtil.formatTime(inboxPageObject.scheduledTime);
        inboxPageObject.openFolder("Scheduled");
        inboxPageObject.clickOnFirstScheduled();
        EmailDetailsPage emailDetailsPage = new EmailDetailsPage(driver);
        Assert.assertEquals(emailDetailsPage.getSubjectFromEmailDetailsPage(), getTestData(EMAIL_SUBJECT));
        Assert.assertEquals(emailDetailsPage.getRecipientFromEmailDetailsPage(), getTestData(EMAIL_RECIPIENT));
        Assert.assertEquals(emailDetailsPage.getMessageTextFromEmailDetailsPage(), getTestData(EMAIL_MESSAGE));
        Assert.assertEquals(emailDetailsPage.getScheduledTimeFromEmailDetailsPage(), formattedTime);

    }
}

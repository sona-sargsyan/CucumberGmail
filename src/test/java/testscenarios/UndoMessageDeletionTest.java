package testscenarios;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.cucumber.pages.InboxPage;

public class UndoMessageDeletionTest extends BaseTest {

    @Test
    public void undoMessageDeletionTest() {
        inboxPageObject = new InboxPage(driver);
        inboxPageObject.waitForThePageToLoad();
        inboxPageObject.clickOnEmailBySubject("module 6-7");
        inboxPageObject.deleteEmailFromEmailDetails();
        inboxPageObject.undoEmailDeletion();
        inboxPageObject.openFolder("Inbox");
        Assert.assertTrue(inboxPageObject.isEmailPresentsInList("module 6-7"));
    }

    @Test
    public void clickByJavaScript() {

        inboxPageObject = new InboxPage(driver);
        inboxPageObject.waitForThePageToLoad();
        inboxPageObject.clickOnEmailBySubject("module 6-7");
        inboxPageObject.deleteEmailFromEmailDetailsByJS();
        inboxPageObject.undoEmailDeletion();
        inboxPageObject.openFolder("Inbox");
        Assert.assertTrue(inboxPageObject.isEmailPresentsInList("module 6-7"));

    }
}

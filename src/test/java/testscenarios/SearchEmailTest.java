package testscenarios;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.cucumber.pages.InboxPage;

public class SearchEmailTest extends BaseTest {

    @Test
    public void searchEmailTest() {

        inboxPageObject = new InboxPage(driver);
        inboxPageObject.waitForThePageToLoad();
        inboxPageObject.hoverAndClickAdvancedSearchButton();
        inboxPageObject.checkHasAttachmentCheckBox();
        inboxPageObject.clickAdvancedSearch();
        inboxPageObject.clickOnFirstEmail();
        Assert.assertTrue(inboxPageObject.attachmentIsPresent());

    }
}

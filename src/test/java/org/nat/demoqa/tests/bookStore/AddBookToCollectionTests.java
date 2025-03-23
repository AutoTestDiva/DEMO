package org.nat.demoqa.tests.bookStore;

import org.nat.demoqa.data.UserData;
import org.nat.demoqa.pages.HomePage;
import org.nat.demoqa.pages.SidePanel;
import org.nat.demoqa.pages.bookStore.BookStorePage;
import org.nat.demoqa.pages.bookStore.LoginPage;
import org.nat.demoqa.pages.bookStore.ProfilePage;
import org.nat.demoqa.tests.TestBase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddBookToCollectionTests extends TestBase {
    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getBookStore();
        new BookStorePage(driver).clickOnLoginButton();
        new LoginPage(driver).login(UserData.USER_NAME, UserData.USER_PASSWORD);
    }

    // Site doesn't work now
    @Test
    public void addBookToCollectionTest() {
        new BookStorePage(driver).enterBookName(UserData.BOOK_NAME)
                .clickOnBookName()
                .addToCollection();
        new SidePanel(driver).selectProfile();
        new BookStorePage(driver).verifyBookName(UserData.BOOK_NAME);

    }

    @AfterMethod
    public void deleteBookFromCollection(){
        new ProfilePage(driver).deleteBook();
    }
}

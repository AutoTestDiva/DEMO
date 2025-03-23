package org.nat.demoqa.tests.bookStore;

import org.nat.demoqa.pages.bookStore.BookStorePage;
import org.nat.demoqa.pages.HomePage;
import org.nat.demoqa.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchBookTests extends TestBase {
    @BeforeMethod
    public void precondition(){
        new HomePage(driver).getBookStore();
    }
    @Test
    void searchBookTest(){
        new BookStorePage(driver).enterBookName("Git")
                .verifyBookName("Git");
    }
}

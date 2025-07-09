package org.nat.demoqa.tests.form;

import org.nat.demoqa.data.StudentData;
import org.nat.demoqa.pages.HomePage;
import org.nat.demoqa.pages.SidePanel;
import org.nat.demoqa.pages.form.PracticeFormPage;
import org.nat.demoqa.tests.TestBase;
import org.nat.demoqa.utils.DataProviders;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PracticeFormTests extends TestBase {
    @BeforeMethod
    public void precondition(){
        new HomePage(driver).getForms();
        new SidePanel(driver).selectPracticeForm().hideIframes(); //.hideIframes - убирает рекламу и footer
    }
    @Test
    public void fillStudentFormTest(){
        new PracticeFormPage(driver).enterPersonalData(StudentData.FIRST_NAME, StudentData.LAST_NAME,
                StudentData.EMAIL, StudentData.PHONE_NUMBER)
                .selectGender(StudentData.GENDER)
               // .enterDate(StudentData.DATE)
                .selectDate("May", "2001", "15")
                .selectSubjects(StudentData.SUBJECTS)
                .selectHobby(StudentData.HOBBIES)
                .uploadFile(StudentData.PHOTO_PATH)
                .enterAddress(StudentData.ADDRESS)
                .selectState(StudentData.STATE)
                .selectCity(StudentData.CITY)
                .submit()
                .assertSubmit("Thanks for submitting the form");
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "studentDataFromCSVFile")
    public void fillStudentFormUsingDataProviderTest(String name, String lastName,
                                                     String email, String phone,
                                                     String dateOfBirth, String path,
                                                     String address){
        new PracticeFormPage(driver).enterPersonalData(name, lastName, email, phone)
                .selectGender(StudentData.GENDER)
                .enterDate(dateOfBirth)
                .selectSubjects(StudentData.SUBJECTS)
                .selectHobby(StudentData.HOBBIES)
                .uploadFile(path)
                .enterAddress(address)
                .selectState(StudentData.STATE)
                .selectCity(StudentData.CITY)
                .submit()
                .assertSubmit("Thanks for submitting the form");
    }
}

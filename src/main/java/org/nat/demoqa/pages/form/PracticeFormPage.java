package org.nat.demoqa.pages.form;

import org.nat.demoqa.pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class PracticeFormPage extends HomePage {

    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "firstName")
    WebElement firstName;

    @FindBy(id = "lastName")
    WebElement lastName;

    @FindBy(id = "userEmail")
    WebElement userEmail;

    @FindBy(id = "userNumber")
    WebElement userNumber;
    public PracticeFormPage enterPersonalData(String name, String lName, String email, String number) {
        type(firstName, name);
        type(lastName, lName);
        type(userEmail, email);
        type(userNumber, number);
        return this;
    }

    @FindBy(css = "[for='gender-radio-1']")
    WebElement male;

    @FindBy(css = "[for='gender-radio-2']")
    WebElement female;

    @FindBy(css = "[for='gender-radio-3']")
    WebElement other;

    public PracticeFormPage selectGender(String gender) {
        if (gender.equals("Male")){
            click(male);
        } else if (gender.equals("Female")){
            click(female);
        } else {
            click(other);
        }
        return this;
    }

    @FindBy(id = "dateOfBirthInput")
    WebElement dateOfBirthInput;
    public PracticeFormPage enterDate(String date) {
        click(dateOfBirthInput);

        String os = System.getProperty("os.name");
        System.out.println("My OS is " + os);

        if (os.startsWith("Mac")){
            dateOfBirthInput.sendKeys(Keys.COMMAND, "a");
        } else {
            dateOfBirthInput.sendKeys(Keys.CONTROL, "a");
        }
        dateOfBirthInput.sendKeys(date);
        dateOfBirthInput.sendKeys(Keys.ENTER);
        return this;
    }

    @FindBy(id = "subjectsInput")
    WebElement subjectsInput;

    public PracticeFormPage selectSubjects(String[] subjects) {
             for (int i =0; i<subjects.length; i++){
                if (subjects[i] !=null){
                    typeWithJSExecutor(subjectsInput,subjects[i], 0,500);
                    subjectsInput.sendKeys(Keys.ENTER);
                }
            }
        return this;
    }

    @FindBy(css = "[for='hobbies-checkbox-1']")
    WebElement sports;

    @FindBy(css = "[for='hobbies-checkbox-2']")
    WebElement reading;

    @FindBy(css = "[for='hobbies-checkbox-3']")
    WebElement music;
    public PracticeFormPage selectHobby(String[] hobbies) {
        for (int i = 0; i < hobbies.length; i++) {
            if (hobbies[i].equals("Sports")) {
                click(sports);
            }
            if (hobbies[i].equals("Reading")) {
                click(reading);
            }
            if (hobbies[i].equals("Music")) {
                click(music);
            }
        }
            return this;
    }

    @FindBy(id = "uploadPicture")
    WebElement uploadPicture;
    public PracticeFormPage uploadFile(String photoPath) {
        uploadPicture.sendKeys(photoPath);
        return this;
    }

    @FindBy(id = "currentAddress")
    WebElement currentAddress;
    public PracticeFormPage enterAddress(String address) {
        type(currentAddress, address);
        return this;
    }

    @FindBy(id = "state")
    WebElement state;

    @FindBy(id = "react-select-3-input")
    WebElement stateInput;
    public PracticeFormPage selectState(String st) {
        clickWithJSExecutor(state,0,700);
        stateInput.sendKeys(st);
        stateInput.sendKeys(Keys.ENTER);
        return this;
    }

    @FindBy(id = "city")
    WebElement city;

    @FindBy(id = "react-select-4-input")
    WebElement cityInput;
    public PracticeFormPage selectCity(String ci) {
        clickWithJSExecutor(city,0,600);
        cityInput.sendKeys(ci);
        cityInput.sendKeys(Keys.ENTER);
        return this;
    }


    @FindBy(id = "submit")
    WebElement submit;

   public PracticeFormPage submit() {
        click(submit);
        return this;
    }


    @FindBy(id = "example-modal-sizes-title-lg")
    WebElement modalTitle;

    public PracticeFormPage assertSubmit(String title) {
        Assert.assertTrue(isTextPresent(modalTitle, title));
        return this;
    }

    @FindBy(css = ".react-datepicker__month-select")
    WebElement selectMonth;

    @FindBy(css = ".react-datepicker__year-select")
    WebElement selectYear;

   //day = xpath = "//div[@class='react-datepicker__week']//div[.='15']") - instead //div[.='15'] write //div[.='"+day+"']

    public PracticeFormPage selectDate(String month, String year, String day) {
        clickWithJSExecutor(dateOfBirthInput, 0, 300);

        new Select(selectMonth).selectByVisibleText(month);
        new Select(selectYear).selectByVisibleText(year);
        driver.findElement(By.xpath("//div[@class='react-datepicker__week']//div[.='"+day+"']")).click();
        return this;
    }
}

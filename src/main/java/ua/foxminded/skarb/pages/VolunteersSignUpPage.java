package ua.foxminded.skarb.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import static ua.foxminded.skarb.utils.DataGenerator.*;

public class VolunteersSignUpPage extends BasePageObject {
    private WebDriver driver;

    @FindBy(id = "email")
    private WebElement emailElement;
    @FindBy(id = "firstName")
    private WebElement firstNameElement;
    @FindBy(id = "lastName")
    private WebElement lastNameElement;
    @FindBy(id = "password")
    private WebElement passwordElement;
    @FindBy(id = "confirmPassword")
    private WebElement confirmPasswordElement;
    @FindBy(id = "categories")
    private WebElement categoryElement;
    @FindBy(xpath = "//button[@name='submit']")
    private WebElement signUpButton;
    String randomFirstName = dataGenerator(4);
    String randomLastName = dataGenerator(5);
    String domain = domainExample();
    String randomEmail = randomFirstName + "." + randomLastName + domain;
    String randomPassword = generatePassword();

    public VolunteersSignUpPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void inputRandomEmailmail() {
        emailElement.sendKeys(randomEmail);
        log.info("Email is written: " + randomEmail);
    }

    // enter random first name
    public void inputRandomFirstName() {
        firstNameElement.sendKeys(randomFirstName);
        log.info("First name is written: " + randomFirstName);
    }

    // enter random last name
    public void inputRandomLastName() {
        lastNameElement.sendKeys(randomLastName);
        log.info("Last name is written: " + randomLastName);
    }

    // enter password and confirmation
    public void inputRandomPasswords() {
        passwordElement.sendKeys(randomPassword);
        confirmPasswordElement.sendKeys(randomPassword);
        log.info("Password & Confirmation are written");
    }

    // Select category "Programming"
    public void selectProgrammingCategory() {
        Select select = new Select(categoryElement);
        select.selectByIndex(4);
        select.selectByVisibleText("Programming");
        log.info("'Programming' category is chosen");
    }

    // Complete registration. Click Sign Up
    public CongratsNgoPage clickSignUpButton() {
        signUpButton.click();
        log.info("Sign Up button is clicked.");
        return new CongratsNgoPage(driver);
    }
}

package ru.volsu.qa.ui.pageobject;

import lombok.Getter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.springframework.stereotype.Component;
import ru.volsu.qa.models.Account;

@Component
public class AccountCreationForm extends BasePage {

    private static final Logger log = LogManager.getLogger(AccountCreationForm.class);

    private final By formContainer = By.id("account-creation_form");

    private final By infoAccount = By.className("info-account");

    private final By errorMessage = By.cssSelector(".alert.alert-danger");

    public boolean isFormDisplayed() {
        this.waitForElementDisplayed(formContainer);
        return true;
    }

    public boolean reg_Ok() {
        this.waitForElementDisplayed(infoAccount);
        return true;
    }

    public String getErrorMessage() {
        this.waitForElementDisplayed( errorMessage );
        return webDriver.findElement( errorMessage ).getText();
    }

//    private By genderManInput = By.id("id_gender1");
//    private By genderWomanInput = By.id("id_gender2");
//    private By customFirstnameInput = By.id("customer_firstname");
//    private By customLastnameInput = By.id("customer_lastname");
//    private By passwordInput = By.id("passwd");
//    private By daysSelect = By.id("days");
//    private By monthsSelect = By.id("months");
//    private By yearsSelect = By.id("years");
//    private By address1Input = By.id("address1");
//    private By cityInput = By.id("city");
//    private By stateSelect = By.id("id_state");
//    private By postCodeInput = By.id("postcode");
//    private By countySelect = By.id("id_country");
//    private By phoneMobilInput = By.id("phone_mobile");

    @FindBy( id = "id_gender1" )
    private WebElement genderManInput;
    @FindBy( id = "id_gender2" )
    private WebElement genderWomanInput;
    @FindBy( id = "customer_firstname" )
    private WebElement customfirstNameInput;
    @FindBy( id = "customer_lastname" )
    private WebElement customlastNameInput;
    @FindBy( id = "passwd" )
    private WebElement passwordInput;
    @FindBy( id = "days" )
    private WebElement daysSelect;
    @FindBy( id = "months" )
    private WebElement monthsSelect ;
    @FindBy(id = "years")
    private WebElement yearsSelect;
    @FindBy( id = "address1" )
    private WebElement address1Input ;
    @FindBy( id = "city" )
    private WebElement cityInput;
    @FindBy( id = "id_state" )
    private WebElement stateSelect;
    @FindBy( id = "postcode" )
    private WebElement postCodeInput ;
    @FindBy( id = "id_country" )
    private WebElement countrySelect ;
    @FindBy( id = "phone_mobile" )
    private WebElement phoneMobileInput;
    @FindBy( id = "submitAccount" )
    private WebElement registerButton;

    public void fillForm(Account account) {
        this.waitForElementDisplayed( formContainer );
        PageFactory.initElements(webDriver, this);

        genderManInput.click();

        customfirstNameInput.sendKeys( account.getFirstName());

        customlastNameInput.sendKeys( account.getLastName());

        passwordInput.sendKeys( account.getPassword());

        Select select = new Select(daysSelect);
        select.selectByValue(account.getDayBirth());

        select = new Select(monthsSelect);
        select.selectByValue(account.getMonthBirth());

        select = new Select(yearsSelect);
        select.selectByValue(account.getYearBirth());

        address1Input.sendKeys( account.getAddress());

        cityInput.sendKeys( account.getCity());

        select = new Select(stateSelect);
        select.selectByVisibleText(account.getState());

        postCodeInput.sendKeys( account.getZip());

        phoneMobileInput.sendKeys( account.getPhone());

        registerButton.click();

    }
}
//        webDriver.findElement( genderManInput ).click();
//
//        webDriver.findElement( customFirstnameInput ).sendKeys( account.getFirstName());
//
//        webDriver.findElement( customLastnameInput ).sendKeys( account.getLastName());
//
//        webDriver.findElement( passwordInput ).sendKeys( account.getPassword());
//
//        Select select = new Select(webDriver.findElement( daysSelect ));
//        select.selectByValue(account.getDayBirth());
//
//        select = new Select(webDriver.findElement( monthsSelect ));
//        select.selectByValue(account.getMonthBirth());
//
//        select = new Select(webDriver.findElement( yearsSelect ));
//        select.selectByValue(account.getYearBirth());
//
//        webDriver.findElement( address1Input ).sendKeys( account.getAddress());
//
//        webDriver.findElement( cityInput ).sendKeys( account.getCity());
//
//        select = new Select(webDriver.findElement( stateSelect ));
//        select.selectByVisibleText(account.getState());
//
//        webDriver.findElement( postCodeInput ).sendKeys( account.getZip());
//
//        webDriver.findElement( phoneMobilInput ).sendKeys( account.getPhone());
//
//        webDriver.findElement( registerButton ).click();

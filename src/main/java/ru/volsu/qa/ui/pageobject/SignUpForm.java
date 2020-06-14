package ru.volsu.qa.ui.pageobject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.stereotype.Component;
import ru.volsu.qa.ui.pagefactory.TopBar;

@Component
public class SignUpForm extends BasePage {

    private static final Logger log = LogManager.getLogger(SignUpForm.class);

    private By formContainer = By.id("create-account_form");

    private By emailAddressInput = By.id("email_create");

    private By createAccountButton = By.id("SubmitCreate");

    private By errorMessage = By.id("create_account_error");

    public void fillForm( String email ) {
        TopBar topBar = PageFactory.initElements(webDriver, TopBar.class);
        topBar.signIn();

        log.debug("Wait for sign up form to be shown.");
        this.waitForElementDisplayed( formContainer );

        log.info("Fill sign up form.");
        webDriver.findElement( emailAddressInput ).sendKeys( email );
    }

    public void clickCreateAccountButton() {
        log.info("Click 'Create an account' button.");
        log.debug("Click element with locator: {}", createAccountButton.toString());
        webDriver.findElement( createAccountButton ).click();
    }

    public String getErrorMessage() {
        this.waitForElementDisplayed( errorMessage );
        return webDriver.findElement( errorMessage ).getText();
    }
}
//    public void fillForm( String email ) {
//        this.waitForElementDisplayed( formContainer );
//        webDriver.findElement( emailAddressInput ).sendKeys( email );
//    }
//
//    public void clickCreateAccountButton() {
//        webDriver.findElement( createAccountButton ).click();
//    }
//
//    public String getErrorMessage() {
//        this.waitForElementDisplayed( errorMessage );
//        return webDriver.findElement( errorMessage ).getText();
//    }


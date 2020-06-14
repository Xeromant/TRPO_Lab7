package ru.volsu.qa.ui;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.volsu.qa.models.Account;
import ru.volsu.qa.ui.expectedconditions.PageLoaded;
import ru.volsu.qa.ui.pagefactory.TopBar;
import ru.volsu.qa.ui.pageobject.AccountCreationForm;
import ru.volsu.qa.ui.pageobject.SignUpForm;
import ru.volsu.qa.ui.utils.EmailGenerator;

public class RegistrationNegativeTests extends BaseTest {

    private static final Logger log = LogManager.getLogger(RegistrationNegativeTests.class);

    @Autowired
    SignUpForm signUpForm;

    @Autowired
    AccountCreationForm accountCreationForm;

    @DataProvider(name = "accountNegativeDataProvider")
    public Object[][] accountNegativeDataProvider() {
        Account accountWithAlreadyUsedEmail = new Account();
        accountWithAlreadyUsedEmail.setEmail("john.doe@yahoo.com");

        Account accountWithInvalidEmail = new Account();
        accountWithInvalidEmail.setEmail("john.doeyahoo.com");

        return new Object[][] {
                {accountWithAlreadyUsedEmail, "An account using this email address has already been registered. Please enter a valid password or request a new one."},
                {accountWithInvalidEmail, "Invalid email address."}
        };
    }


    @Test(dataProvider = "accountNegativeDataProvider")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify user registration with incorrect email value.")
    public void registerAccountNegativeTest(Account account, String errorMessage ) {

        signUpForm.fillForm( account.getEmail() );
        signUpForm.clickCreateAccountButton();

        String errorOnPage = signUpForm.getErrorMessage();

        log.info("Verify that correct error message is shown.");
        Assert.assertEquals(errorOnPage, errorMessage);

    }

    @DataProvider(name = "testAccountCreationFormNegativeNullOneValue")
    public Object[][] testAccountCreationFormNegativeNullOneValue() {
        Account accountNullVallue= new Account("Tim" ,
                "Zheltov",
                EmailGenerator.generateEmail(),
                "123123WErewr!",
                "1",
                "1",
                "1999",
                "Volgograd",
                "LA",
                "New Mexico",
                "",
                "United States",
                "88005553535");

        return new Object[][] {
                {accountNullVallue, "There is 1 error\n" +
                        "The Zip/Postal code you've entered is invalid. It must follow this format: 00000"},
        };
    }

    @Test(dataProvider = "testAccountCreationFormNegativeNullOneValue")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify user registration with incorrect Zip/Postal code value.")
    public void testAccountCreationFormNegativeNullOneValue(Account account, String errorMessage ) {

        signUpForm.fillForm( account.getEmail() );
        signUpForm.clickCreateAccountButton();

        accountCreationForm.fillForm(account);

        String errorOnPage = accountCreationForm.getErrorMessage();

        log.info("Verify that correct error message is shown.");
        Assert.assertEquals(errorOnPage, errorMessage);

    }
}

//SignUpForm signUpForm = new SignUpForm(webdriver);
//        System.out.println("Ожидаемая ошибка:"+errorMessage);
//        System.out.println("Текущая ошибка:"+errorOnPage);
//
//        Assert.assertEquals(errorOnPage, errorMessage);
//SignUpForm signUpForm = new SignUpForm(webdriver);
//AccountCreationForm accountCreationForm = new AccountCreationForm(webdriver);
//        System.out.println("Ожидаемая ошибка:"+errorMessage);
//        System.out.println("Текущая ошибка:"+errorOnPage);
//
//        Assert.assertEquals(errorOnPage, errorMessage);
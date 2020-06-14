package ru.volsu.qa.ui;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.volsu.qa.ui.utils.EmailGenerator;
import ru.volsu.qa.models.Account;
import ru.volsu.qa.ui.pagefactory.TopBar;
import ru.volsu.qa.ui.pageobject.AccountCreationForm;
import ru.volsu.qa.ui.pageobject.SignUpForm;

public class RegistrationTests extends BaseTest {

    private static final Logger log = LogManager.getLogger(RegistrationTests.class);

    @Autowired
    SignUpForm signUpForm;

    @Autowired
    AccountCreationForm accountCreationForm;

    @DataProvider(name = "accountDataProvider")
    public Object[][] accountDataProvider() {
        Account account = new Account();

        account.setEmail(EmailGenerator.generateEmail());

        return new Object[][] {
                {account}
        };
    }

    @Test(dataProvider = "accountDataProvider")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify successful user registration.")
    public void registerAccount(Account account) {

        signUpForm.fillForm( account.getEmail() );
        signUpForm.clickCreateAccountButton();


        log.info("Verify 'Create Account' form is opened.");
        Assert.assertTrue(accountCreationForm.isFormDisplayed());

        accountCreationForm.fillForm(account);

        log.info("Verify 'Account info' form is opened.");
        Assert.assertTrue(accountCreationForm.reg_Ok());
    }
}

//        log.info("Verify 'Create Account' form is opened.");
//        Assert.assertTrue(accountCreationForm.isFormDisplayed());
//AccountCreationForm accountCreationForm = new AccountCreationForm(webdriver);
//SignUpForm signUpForm = new SignUpForm(webdriver);
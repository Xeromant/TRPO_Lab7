package ru.volsu.qa.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.*;
import ru.volsu.qa.config.AppConfig;
import ru.volsu.qa.listeners.FailuresListener;
import ru.volsu.qa.ui.pageobject.BasePage;

@Listeners({FailuresListener.class})
@ContextConfiguration( classes = AppConfig.class )
public class BaseTest extends BasePage {


    @BeforeMethod
    public void openBaseUrl(){
        getPage();
    }

    @AfterSuite
    public void closeBrowser(){}
}


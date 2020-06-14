package ru.volsu.qa.listeners;

import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import ru.volsu.qa.ui.utils.ApplicationContextHolder;

import java.io.File;
import java.io.IOException;

public class FailuresListener extends TestListenerAdapter {

    private static final Logger log = LogManager.getLogger(ru.volsu.qa.listeners.FailuresListener.class);

    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = ApplicationContextHolder.getBean(WebDriver.class);
        byte[] srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        saveScreenshot(srcFile);
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    private byte[] saveScreenshot(byte[] screenshot) {
        return screenshot;
    }
}

//Object currentClass = result.getInstance();
//WebDriver driver = ((AbstractTest) currentClass).getDriver();
//public class FailuresListener implements ITestListener {
//        @Attachment(value = "Page screenshot", type = "image/png")
//        public byte[] captureScreenshot() {
//
//            WebDriver webDriver = ApplicationContextHolder.getBean(WebDriver.class);
//            byte[] screenshot = ((TakesScreenshot) webDriver.getWebDriver).getScreenshotAs(OutputType.BYTES);
//            return screenshot;
//        }
//        @Override
//    public void onTestFailure(ITestResult result) {
//        this.captureScreenshot();
//        try {
//            FileUtils.copyFile(screenshot, new File("c:\\tmp\\screenshot.png"));
//        } catch (IOException e) {
//            log.warn("Failed to save captured screenshot due to error: " + e.getMessage());
//        }
//    }

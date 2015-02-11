package com.company;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.rules.TestName;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

/**
 * Created by Alex on 03.02.15.
 */
public class TestHelper {
    public static WebDriver webDriver;
    public static boolean testPassed;

    public TestName name = new TestName();

    @Before
    public void  Init() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:/AUT5/chromedriver.exe");
        //System.setProperty("webdriver.chrome.driver", "D:/Soft/IDE/chromedriver_win32/chromedriver.exe");
        webDriver = new ChromeDriver();
        StrahovatorPage.open(webDriver);
        testPassed = false;
        Thread.sleep(3000);
    }

    @After
    public void  CleanUp() throws IOException {
        if (!testPassed) {
            File scrFile = ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("D:\\AUT5\\temp\\" + name.getMethodName() + ".png"));
            //FileUtils.copyFile(scrFile, new File("d:\\Testing\\temp\\" + name.getMethodName() + ".png"));
        }
        webDriver.quit();
    }

    public static WebElement waitElement(WebDriver webDriver,  String path) throws InterruptedException {
        int timeout = 30000, timepassed = 0, s;
        while(timepassed < timeout) {
            s = webDriver.findElements(By.xpath(path)).size();
            if (webDriver.findElements(By.xpath(path)).size() > 0) {
            //if (s > 0) {
                WebElement we = webDriver.findElements(By.xpath(path)).get(0);
                //System.out.println(we.getAttribute("value"));
                return we;
            }
            Thread.sleep(100);
            timepassed += 100;
            //System.out.println(timepassed);
        }
        Assert.fail();
        return null;
    }

    public static void waitValue(WebDriver webDriver,  String path, String val) throws InterruptedException {
        int timeout = 30000, timepassed = 0, s;
        while(timepassed < timeout) {
            if (webDriver.findElements(By.xpath(path)).size() > 0) {
                WebElement we = webDriver.findElements(By.xpath(path)).get(0);
                if(val.equals(we.getAttribute("value"))) {
                    return;
                }
            }
            Thread.sleep(100);
            timepassed += 100;
        }
        Assert.fail();

    }

    public static void waitText(WebDriver webDriver,  String path, String val) throws InterruptedException {
        int timeout = 30000, timepassed = 0, s;
        while(timepassed < timeout) {
            if (webDriver.findElements(By.xpath(path)).size() > 0) {
                WebElement we = webDriver.findElements(By.xpath(path)).get(0);
                if(val.equals(we.getText())) {
                    return;
                }
            }
            Thread.sleep(100);
            timepassed += 100;
        }
        Assert.fail();

    }
}

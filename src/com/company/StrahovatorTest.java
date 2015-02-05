package com.company;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

/**
 * Created by user on 2/4/15.
 */
@RunWith(JUnit4.class)
public class StrahovatorTest {

    WebDriver webDriver;
    boolean testPassed;

    @Rule
    public TestName name = new TestName();

    @Before
    public void  Init() throws InterruptedException {
        //System.setProperty("webdriver.chrome.driver", "D:/AUT5/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", "D:/Soft/IDE/chromedriver_win32/chromedriver.exe");
        webDriver = new ChromeDriver();
        StrahovatorPage.open(webDriver);
        testPassed = false;
        Thread.sleep(3000);
    }

    @After
    public void  CleanUp() throws IOException {
        if (!testPassed) {
            File scrFile = ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);
            //FileUtils.copyFile(scrFile, new File("D:\\AUT5\\temp\\" + name.getMethodName() + ".png"));
            FileUtils.copyFile(scrFile, new File("d:\\Testing\\temp\\" + name.getMethodName() + ".png"));
        }
        webDriver.quit();
    }



    @Test
    public void CheckMainMenu() throws InterruptedException, IOException {
        StrahovatorPage.CheckNameMenu(webDriver);
        testHelper.testPassed = true;
    }

    @Test
    public void DefaultValueOSAGO() throws InterruptedException, IOException {
        StrahovatorPage.openMenuOSAGO(webDriver);
        StrahovatorPage.CheckDefaultValueOSAGO(webDriver);
        testHelper.testPassed = true;
    }


}

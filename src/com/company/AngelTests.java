package com.company;

import org.apache.commons.io.FileUtils;
import org.junit.*;
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
 * Created by user on 1/30/15.
 */

@RunWith(JUnit4.class)
public class AngelTests {
    WebDriver webDriver;
    boolean testPassed;

    @Rule
    public TestName name = new TestName();

    @Before
    public void  Init() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:/AUT5/chromedriver.exe");
        //System.setProperty("webdriver.chrome.driver", "D:/Soft/IDE/chromedriver_win32/chromedriver.exe");
        webDriver = new ChromeDriver();
        AngelForm.open(webDriver);
        testPassed = false;
        Thread.sleep(3000);
    }

    @Test
    public void emptyMaster_PasswordGererates(){
        AngelForm.setMaster(webDriver, "");
        AngelForm.setSite(webDriver, "angel.net");
        AngelForm.generate(webDriver);
        Assert.assertEquals("Is2nfhWTJLvq0@1a", AngelForm.getPassword(webDriver));
    }

    @Test
     public void fillMaster_fillSite_PasswordCorrect(){
        AngelForm.setMaster(webDriver, "asdasd");
        AngelForm.setSite(webDriver, "angel.net");
        AngelForm.generate(webDriver);
        Assert.assertEquals("B9ya7yayeK/Zn@1a", AngelForm.getPassword(webDriver));
    }

    @Test
    public void differentMaster_fillSite(){
        AngelForm.setMaster(webDriver, "qweqwe");
        AngelForm.setSite(webDriver, "angel.net");
        AngelForm.generate(webDriver);
        Assert.assertNotEquals("B9ya7yayeK/Zn@1a", AngelForm.getPassword(webDriver));
    }

    @Test
    public void fillMasterSpecialSymbols(){
        AngelForm.setMaster(webDriver, "ASdfйцУК12!@#$%^&**()_+={}|?><");
        AngelForm.setSite(webDriver, "angel.net");
        AngelForm.generate(webDriver);
        Assert.assertEquals("Ae4HD9Gf81/AK@1a", AngelForm.getPassword(webDriver));
        Assert.assertEquals("ASdfйцУК12!@#$%^&**()_+={}|?><", AngelForm.getMaster(webDriver));
    }

    @Test
    public void fillMaster32_fillSite128(){
        AngelForm.setMaster(webDriver, "aaaaaaaaaabbbbbbbbbbccccccccccdd");
        AngelForm.setSite(webDriver, "angel.net");
        AngelForm.generate(webDriver);
        Assert.assertEquals("Ae4HD9Gf81/AK@1a", AngelForm.getPassword(webDriver));
        Assert.assertEquals("ASdfйцУК12!@#$%^&**()_+={}|?><", AngelForm.getMaster(webDriver));
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


}

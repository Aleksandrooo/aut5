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

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.List;

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
        //System.setProperty("webdriver.chrome.driver", "D:/AUT5/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", "D:/Soft/IDE/chromedriver_win32/chromedriver.exe");
        webDriver = new ChromeDriver();
        AngelForm.open(webDriver);
        testPassed = false;
        Thread.sleep(3000);
    }

    @Test
    public void emptyMaster_PasswordGererates() throws InterruptedException {
        AngelForm.setMaster(webDriver, "");
        AngelForm.setSite(webDriver, "angel.net");
        AngelForm.generate(webDriver);
        Assert.assertEquals("Is2nfhWTJLvq0@1a", AngelForm.getPassword(webDriver));
    }

    @Test
     public void emptySite_PasswordGererates() throws InterruptedException {
        AngelForm.setMaster(webDriver, "asdasd");
        AngelForm.setSite(webDriver, "");
        AngelForm.generate(webDriver);
        Assert.assertEquals("6NHbUE0n0Hlfs@1a", AngelForm.getPassword(webDriver));
    }

    @Test
    public void emptyMaster_emptySite_PasswordGererates() throws InterruptedException {
        AngelForm.setMaster(webDriver, "");
        AngelForm.setSite(webDriver, "");
        AngelForm.generate(webDriver);
        Assert.assertEquals("BaefBs8/Z/cm2@1a", AngelForm.getPassword(webDriver));
    }

    @Test
     public void fillMaster_fillSite_PasswordCorrect() throws InterruptedException {
        AngelForm.setMaster(webDriver, "asdasd");
        AngelForm.setSite(webDriver, "angel.net");
        AngelForm.generate(webDriver);
        Assert.assertEquals("B9ya7yayeK/Zn@1a", AngelForm.getPassword(webDriver));
    }

    @Test
    public void differentMaster_fillSite() throws InterruptedException {
        AngelForm.setMaster(webDriver, "qweqwe");
        AngelForm.setSite(webDriver, "angel.net");
        AngelForm.generate(webDriver);
        Assert.assertNotEquals("B9ya7yayeK/Zn@1a", AngelForm.getPassword(webDriver));
    }

    @Test
    public void fillMasterSpecialSymbols() throws InterruptedException {
        AngelForm.setMaster(webDriver, "ASdfйцУК12!@#$%^&**()_+={}|?><");
        AngelForm.setSite(webDriver, "angel.net");
        AngelForm.generate(webDriver);
        Assert.assertEquals("Ae4HD9Gf81/AK@1a", AngelForm.getPassword(webDriver));
        Assert.assertEquals("ASdfйцУК12!@#$%^&**()_+={}|?><", AngelForm.getMaster(webDriver));
    }

    @Test
    public void fillMaster32_fillSite128() throws InterruptedException {
        AngelForm.setMaster(webDriver, "aaaaaaaabbbbbbbbccccccccccdddddddd");
        AngelForm.setSite(webDriver, "aaaaaaaabbbbbbbbccccccccccdddddddd" +
                "aaaaaaaabbbbbbbbccccccccccdddddddd" +
                "aaaaaaaabbbbbbbbccccccccccdddddddd" +
                "aaaaaaaabbbbbbbbccccccccccdddddddd");
        AngelForm.generate(webDriver);
        Assert.assertEquals("QAc6hTFKIT9Jr@1a", AngelForm.getPassword(webDriver));
        Assert.assertEquals("aaaaaaaabbbbbbbbccccccccccdddddddd", AngelForm.getMaster(webDriver));
        Assert.assertEquals("aaaaaaaabbbbbbbbccccccccccdddddddd" +
                "aaaaaaaabbbbbbbbccccccccccdddddddd" +
                "aaaaaaaabbbbbbbbccccccccccdddddddd" +
                "aaaaaaaabbbbbbbbccccccccccdddddddd", AngelForm.getSite(webDriver));
    }

    @Test
    public void fillMasterPass_fillSitePass_PasswordCorrect() throws InterruptedException {
        String s = "";
        AngelForm.setMaster(webDriver, "asdasd");
        AngelForm.setSite(webDriver, "angel.net");
        AngelForm.generate(webDriver);
        s = AngelForm.getPassword(webDriver);
        AngelForm.setMaster(webDriver, s);
        AngelForm.setSite(webDriver, s);
        AngelForm.generate(webDriver);
        Assert.assertEquals("p8Y3qXpb0FUGO@1a", AngelForm.getPassword(webDriver));
    }

    @Test
    public void fillMasterPass_fillSitePass_GereratePassword1000() throws InterruptedException {
        int i, j;
        for (i=0; i<10; i++){
            AngelForm.setMaster(webDriver, "qwerty");
            AngelForm.setSite(webDriver, "angel.net");
            AngelForm.generate(webDriver);
            Assert.assertEquals("VdONTdKnLXw6G@1a", AngelForm.getPassword(webDriver));
        }
    }

    @Test
    public void Gererate1000DifferentPasswords() throws InterruptedException {
        int i, j;
        List<String> passwords = new ArrayList<String>();
        for (i=0; i<10; i++){
            AngelForm.setMaster(webDriver, "qwerty");
            AngelForm.setSite(webDriver, "angel.net" + i);
            AngelForm.generate(webDriver);
            passwords.add(i, AngelForm.getPassword(webDriver));
        }
        for (i=0; i<10; i++){
            for(j=0; j<10; j++){
                if(i!=j){
                    Assert.assertNotEquals(passwords.get(i), passwords.get(j));
                }
            }
        }
    }

    @Test
    public void pushEnter_GeneratePasswordCorrect() throws AWTException, InterruptedException {
        AngelForm.setMaster(webDriver, "asdasd");
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
        AngelForm.setSite(webDriver, "angel.net");
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Assert.assertEquals("B9ya7yayeK/Zn@1a", AngelForm.getPassword(webDriver));
    }

    @Test
    public void refreshPage_emptyMasterSitePassword() throws AWTException, InterruptedException {
        AngelForm.setMaster(webDriver, "asdasd");
        AngelForm.setSite(webDriver, "angel.net");
        AngelForm.generate(webDriver);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_F5);
        robot.keyRelease(KeyEvent.VK_F5);
        Thread.sleep(5000);
        Assert.assertEquals("", AngelForm.getMaster(webDriver));
        Assert.assertEquals("", AngelForm.getSite(webDriver));
        Assert.assertEquals("", AngelForm.getPassword(webDriver));
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


}

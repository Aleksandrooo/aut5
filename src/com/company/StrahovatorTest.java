package com.company;

import org.apache.commons.io.FileUtils;
import org.junit.*;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

/**
 * Created by user on 2/4/15.
 */
@RunWith(JUnit4.class)
public class StrahovatorTest extends TestHelper {

//    WebDriver webDriver;
//    boolean testPassed;

    @Rule
    public TestName name = new TestName();

    @Before
    public void  Init() throws InterruptedException {
        //System.setProperty("webdriver.chrome.driver", "D:/AUT5/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", "D:/Soft/IDE/chromedriver_win32/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
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
        StrahovatorPage.CheckNameMenu();
        testPassed = true;
    }

    @Test
    public void DefaultValueOSAGO() throws InterruptedException, IOException {
        StrahovatorPage.openMenuOSAGO();

        //Assert.assertEquals("--необходимо выбрать--", OsagoPage.getDefaultValue(OsagoPage.getFldTransport()));
        //Assert.assertEquals("--необходимо выбрать--", OsagoPage.getDefaultValue(OsagoPage.getFldDetails()));
        Assert.assertEquals("--необходимо выбрать--", OsagoPage.getDefaultValueTransport());
        Assert.assertEquals("--необходимо выбрать--", OsagoPage.getDefaultValueDetails());
        Assert.assertEquals("Киев", OsagoPage.getDefaultValueLocation());
        Assert.assertEquals("3 года", OsagoPage.getDefaultValueExperience());
        Assert.assertEquals("1 год", OsagoPage.getDefaultValuePeriod());
        Assert.assertEquals("нет", OsagoPage.getDefaultValueDGO());
        testPassed = true;
    }

    @Test
    public void Top3Company() throws InterruptedException, IOException {
        StrahovatorPage.openMenuOSAGO();
        //OsagoPage.getFldTransport().selectByIndex(2);
        OsagoPage.SetValueFldTransport("1");
        OsagoPage.SetValueFldDetails("b1");
        Assert.assertEquals("/images/custom/osago/ut.gif", OsagoPage.getResultCompany(1));
        Assert.assertEquals("/images/custom/osago/sk.gif", OsagoPage.getResultCompany(2));
        Assert.assertEquals("/images/custom/osago/il.gif", OsagoPage.getResultCompany(3));
        testPassed = true;
    }


}

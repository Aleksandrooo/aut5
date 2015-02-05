package com.company;

import org.apache.commons.io.FileUtils;
import org.junit.*;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

/**
 * Created by user on 1/28/15.
 */
@RunWith(JUnit4.class)
public class FirstTests {
    WebDriver w;
    boolean testPassed;

    @Rule
    public TestName name = new TestName();

    //@Rule
   // public TestName name = new TestName();


    @Before
    public void  Init() throws InterruptedException {
        //System.setProperty("webdriver.chrome.driver", "D:/AUT5/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", "D:/Soft/IDE/chromedriver_win32/chromedriver.exe");
        w = new ChromeDriver();
        //w.get("http://demoqa.com/registration/");
        RegistrationForm.open(w);
        testPassed = false;
        Thread.sleep(3000);
    }

    @After
    public void  CleanUp() throws IOException {
        if (!testPassed) {
            File scrFile = ((TakesScreenshot)w).getScreenshotAs(OutputType.FILE);
            //FileUtils.copyFile(scrFile, new File("D:\\AUT5\\temp\\" + name.getMethodName() + ".png"));
            FileUtils.copyFile(scrFile, new File("d:\\Testing\\temp\\" + name.getMethodName() + ".png"));
        }
        w.quit();
    }

    @Test
    public void MyTest1() throws InterruptedException, IOException {
        RegistrationForm.setFirstName(w, "Testa");
        RegistrationForm.setLastName(w, "Testik");
        RegistrationForm.setMaritalStatus(w, 1);
        RegistrationForm.setHobby(w, 1);
        RegistrationForm.setCountry(w, "Ukraine");
        RegistrationForm.setDay(w, "21");
        RegistrationForm.setMonth(w, "10");
        RegistrationForm.setYear(w, "2000");

        Thread.sleep(3000);
        testPassed = true;
    }

    @Test
    public void MyTest2() throws InterruptedException, IOException {

        //Assert.assertEquals("First Name", RegistrationForm.getLabelFirstName(w));
        //Assert.assertEquals("Last Name", RegistrationForm.getLabelLastName(w));
        Assert.assertEquals("Marital Status", RegistrationForm.getLabelMaritalStatus(w));
        Assert.assertEquals("Single", RegistrationForm.getLabelSingle(w));
        Assert.assertEquals("Married", RegistrationForm.getLabelMarried(w));
        Assert.assertEquals("Divorced", RegistrationForm.getLabelDivorced(w));
        Assert.assertEquals("Hobby", RegistrationForm.getLabelHobby(w));
        Assert.assertEquals("Dance", RegistrationForm.getLabelDance(w));
        Assert.assertEquals("Reading", RegistrationForm.getLabelReading(w));
        Assert.assertEquals("Cricket", RegistrationForm.getLabelCricket(w));
        Assert.assertEquals("Country", RegistrationForm.getLabelCountry(w));
        Assert.assertEquals("Date of Birth", RegistrationForm.getLabelDateOfBirth(w));
        testPassed = true;

    }

    @Test
    public void MyTest3() throws InterruptedException, IOException {
        //WebElement label1 = w.findElement(By.xpath("//div[input[@name='last_name']]/label"));
        Assert.assertEquals("", RegistrationForm.getFirstName(w));
        Assert.assertEquals("", RegistrationForm.getLastName(w));
        //Assert.assertEquals("", RegistrationForm.getMaritalStatus(w));
        //Assert.assertEquals("", RegistrationForm.getHobby(w));
        Assert.assertEquals("Month", RegistrationForm.getMonth(w));
        Assert.assertEquals("Day", RegistrationForm.getDay(w));
        Assert.assertEquals("Year", RegistrationForm.getYear(w));
        testPassed = true;


    }

    @Test
    public void MyTest4() throws InterruptedException {

        WebElement submit = w.findElement(By.name("pie_submit"));
        submit.click();
        WebElement errormes = w.findElement(By.xpath("//div[@class='legend_txt']/span"));
        Assert.assertEquals("* This field is required", errormes.getText());
        testPassed = true;

    }
}

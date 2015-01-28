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
        System.setProperty("webdriver.chrome.driver", "D:/AUT5/chromedriver.exe");
        //System.setProperty("webdriver.chrome.driver", "D:/Soft/IDE/chromedriver_win32/chromedriver.exe");
        w = new ChromeDriver();
        w.get("http://demoqa.com/registration/");
        Thread.sleep(3000);
    }

    @After
    public void  CleanUp() throws IOException {
        File scrFile = ((TakesScreenshot)w).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("c:\\tmp\\" + name.getMethodName() + ".png"));
                w.quit();
    }

    @Test
    public void MyTest() throws InterruptedException, IOException {
       //int a= 6,  b =7;
       // Assert.assertEquals(a, b);
        Init();
        WebElement Name = w.findElement(By.id("name_3_firstname"));
        // Name = a.findElement(By.xpath("//input[@name='first_name']/../label"));
        WebElement label1 = w.findElement(By.xpath("//div[input[@name='first_name']]/label"));
        //System.out.println("Значения  по умолчанию");
        //printresult("Значениe по умолчанию firstname", Name.getText().equals(""));
        //Name.sendKeys("Testa");
        Assert.assertEquals("", Name.getText());
        CleanUp();
    }

    @Test
    public void MyTest2() throws InterruptedException, IOException {
        Init();
        //WebElement Name = a.findElement(By.id("name_3_lastname"));
        WebElement label1 = w.findElement(By.xpath("//div[input[@name='last_name']]/label"));
        //System.out.println(label1.getText());
        //printresult("Значение по умолчанию lastname", Name.getText().equals(""));
        Assert.assertEquals("Last Name", label1.getText());
        CleanUp();
    }

    @Test
    public void MyTest3() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:/AUT5/chromedriver.exe");
        //System.setProperty("webdriver.chrome.driver", "D:/Soft/IDE/chromedriver_win32/chromedriver.exe");
        WebDriver a = new ChromeDriver();
        a.get("http://demoqa.com/registration/");
        Thread.sleep(3000);
        //WebElement Name = a.findElement(By.id("name_3_firstname"));
        // Name = a.findElement(By.xpath("//input[@name='first_name']/../label"));
        WebElement submit = a.findElement(By.name("pie_submit"));
       // printresult("Значение по умолчанию submit", submit.getAttribute("value").equals("Submit"));
        submit.click();
        WebElement errormes = a.findElement(By.xpath("//div[@class='legend_txt']/span"));
        //System.out.println(label1.getText());
        //System.out.println("Значения  по умолчанию");
        //printresult("Значениe по умолчанию firstname", Name.getText().equals(""));
        //Name.sendKeys("Testa");
        Assert.assertEquals("* This field is required", errormes.getText());
        a.quit();
    }
}

package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.*;
import java.util.List;

/**
 * Created by Alex on 24.01.15.
 */
public class demoqa_registration {

    public static void main (String[] args) throws InterruptedException, AWTException {
        int i = 0;
        // System.setProperty("webdriver.chrome.driver", "D:/AUT5/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", "D:/Soft/IDE/chromedriver_win32/chromedriver.exe");

        WebDriver a = new ChromeDriver();
        a.get("http://demoqa.com/registration/");
        Thread.sleep(3000);

        WebElement Name = a.findElement(By.id("name_3_firstname"));
        Name.sendKeys("Testa");
        Name = a.findElement(By.id("name_3_lastname"));
        Name.sendKeys("Testik");
        System.out.println("Testa  Testik");


        List<WebElement> Status = a.findElements(By.name("radio_4[]"));
        Status.get(1).click();

        List<WebElement> Hobby = a.findElements(By.name("checkbox_5[]"));
        Hobby.get(1).click();

        WebElement country = a.findElement(By.id("dropdown_7"));
        Select s = new Select(country);
        s.selectByValue("Ukraine");//).selectByVisibleText("Europe");

        WebElement month = a.findElement(By.id("mm_date_8"));
        s = new Select(month);
        s.selectByValue("10");

        WebElement day = a.findElement(By.id("dd_date_8"));
        s = new Select(day);
        s.selectByValue("21");

        WebElement year = a.findElement(By.id("yy_date_8"));
        s = new Select(year);
        s.selectByValue("2000");

        WebElement phone  = a.findElement(By.id("phone_9"));
        phone.sendKeys("0441112233");

        WebElement username = a.findElement(By.id("username"));
        username.sendKeys("LoginUser");

        WebElement email  = a.findElement(By.id("email_1"));
        email.sendKeys("email@mail.ua");

        WebElement Profile  = a.findElement(By.id("profile_pic_10"));
        Profile.click();
        //StringSelection ss = new StringSelection("C:\\MyWork\\AUT5\\newRepo\\.gitignore");
        StringSelection ss = new StringSelection("D:\\Ris\\kot_40912552_big_.jpeg");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
        //imitate mouse events like ENTER, CTRL+C, CTRL+V
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        WebElement about = a.findElement(By.id("description"));
        about.sendKeys("Bla - bla bla Bla - bla blaBla - bla blaBla - bla blaBla - " +
                "bla blaBla - bla blaBla - bla blaBla - bla bla ");

        WebElement password = a.findElement(By.id("password_2"));
        password.sendKeys("PASSpass1234!@#$");

        WebElement password2 = a.findElement(By.id("confirm_password_password_2"));
        password2.sendKeys("PASSpass1234!@#$");

        WebElement submit = a.findElement(By.name("pie_submit"));
        submit.click();

        //piereg_message  Thank you for your registration

        /*if (link1.getAttribute("href").equals("http://www.toolsqa.com/automation-practice-form/")){
            System.out.println("Test link1  : passed ");
        } else {
            System.out.println("Test link1  : failed ");
            System.out.println(link1.getAttribute("href"));
        }
        */
       // a.quit();
    }
}

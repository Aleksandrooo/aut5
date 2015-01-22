package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by user on 1/21/15.
 */
public class PracticeForm {
    public static void main (String[] args) throws InterruptedException {
        int n = 0;
        //String[] input = {"синий", "белый", "черный", "желтый"};
       // String[] output = {"blue", "white", "black", "yellow"};
        //System.setProperty("webdriver.chrome.driver", "D:/AUT5/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", "D:/Soft/IDE/chromedriver_win32/chromedriver.exe");
        //Automation Practice Form
        WebDriver a = new ChromeDriver();
        a.get("http://www.toolsqa.com/automation-practice-form");
        Thread.sleep(3000);
       // WebElement link = a.findElement(By.tagName("a"));
        //link.click();

        WebElement name = a.findElement(By.name("firstname"));
        name.sendKeys("Testa");
        name = a.findElement(By.name("lastname"));
        name.sendKeys("Testik");
        System.out.println("Testa  Testik");
        WebElement RB = a.findElement(By.id("sex-1"));
        RB.click();
        RB = a.findElement(By.id("sex-0"));
        RB.click();
        System.out.println("Male     Female");
        WebElement exp = a.findElement(By.id("exp-0"));
        n=1;
        //while(n < exp.getSize()) {
        while(n < 7) {
            exp = a.findElement(By.id("exp-" + n));
            exp.click();
            n++;
        }
        WebElement dt = a.findElement(By.id("datepicker"));
        dt.sendKeys("12.11.2014");
        dt.clear();
        dt.sendKeys("2014-11-12");
        WebElement prof = a.findElement(By.id("profession-0"));
        prof.click(); // prof.isSelected();
        prof = a.findElement(By.id("profession-1"));
        prof.click();//prof.isSelected();
        WebElement photo = a.findElement(By.id("photo"));
        photo.click(); //kot_40912552_big_.jpeg
    }
}

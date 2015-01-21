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
        String[] input = {"синий", "белый", "черный", "желтый"};
        String[] output = {"blue", "white", "black", "yellow"};
        System.setProperty("webdriver.chrome.driver", "D:/AUT5/chromedriver.exe");

        WebDriver a = new ChromeDriver();
        a.get("http://www.toolsqa.com/automation-practice-form");
        WebElement i = a.findElement(By.id("sex-1"));

    }
}

package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by user on 1/30/15.
 */
public class AngelForm {
    private static String masterXpath = "//input[@name='master']";
    private static String siteXpath = "//input[@name='site']";
    private static String submitXpath = "//input[@type='submit']";
    private static String passwordXpath = "//input[@name='password']";


    public static void open(WebDriver webDriver) {
        webDriver.get("http://angel.net/~nic/passwd.current.html");
    }

    public static void setMaster(WebDriver webDriver, String s) {
        WebElement f = webDriver.findElement(By.xpath(masterXpath));
        f.clear();
        f.sendKeys(s);
    }

    public static void setSite(WebDriver webDriver, String s) {
        WebElement f = webDriver.findElement(By.xpath(siteXpath));
        f.clear();
        f.sendKeys(s);
    }

    public static void generate(WebDriver webDriver) {
        WebElement submit = webDriver.findElement(By.xpath(submitXpath));
        submit.click();
    }

    public static String getPassword(WebDriver webDriver) {
        WebElement f = webDriver.findElement(By.xpath(passwordXpath));
        return f.getAttribute("value");
    }

    public static String getMaster(WebDriver webDriver) {
        WebElement f = webDriver.findElement(By.xpath(masterXpath));
        return f.getAttribute("value");

    }

    public static String getSite(WebDriver webDriver) {
        WebElement f = webDriver.findElement(By.xpath(siteXpath));
        return f.getAttribute("value");
    }
}

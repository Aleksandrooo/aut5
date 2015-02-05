package com.company;

import org.junit.Assert;
import org.junit.Before;
import org.junit.rules.TestName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
//import testHelper;
/**
 * Created by Alex on 05.02.15.
 */
public class StrahovatorPage {
    private static String mainMenuXpath = "//div[@class='nav-collapse collapse']/ul[@class='nav']";
    private static String mainMenuXpath2 = "//div[@class='nav-collapse collapse']/ul[@class='nav']/li/a";
    private static String transportXpath = "//select[@id='ts_type']";
    private static String detailsXpath = "//select[@id='ts_details_type']";
    private static String locationXpath = "//select[@id='ts_zone']";
    private static String experienceXpath = "//select[@id='no_crash_years_qty']";
    private static String periodXpath = "//select[@id='period']";
    private static String dgoXpath = "//select[@id='dgo']";
    //private static String detailsXpath = "//select[@id='ts_details_type']";



    public static void open(WebDriver webDriver) {
       webDriver.get("https://strahovator.com.ua/");
    }

    public static void CheckNameMenu(WebDriver webDriver) {
        //WebElement m = testHelper.webDriver.findElement(By.xpath(mainMenuXpath));
        //WebElement m = webDriver.findElement(By.xpath(mainMenuXpath));
        //List<WebElement> menu = m.findElements(By.tagName("a"));
        List<WebElement> menu = webDriver.findElements(By.xpath("//div[@class='nav-collapse collapse']/ul[@class='nav']/li/a"));
        Assert.assertEquals("Главная", menu.get(0).getText());
        Assert.assertEquals("ОСАГО", menu.get(1).getText());
        Assert.assertEquals("КАСКО", menu.get(2).getText());
        Assert.assertEquals("Зеленая карта", menu.get(3).getText());
        Assert.assertEquals("Для выезжающих за границу", menu.get(4).getText());
        Assert.assertEquals("Как мы работаем", menu.get(5).getText());
        Assert.assertEquals("Контакты", menu.get(6).getText());
}

    public static void openMenuOSAGO(WebDriver webDriver) {
        List<WebElement> menu = webDriver.findElements(By.xpath(mainMenuXpath2));
        menu.get(1).click();
    }

    public static void CheckDefaultValueOSAGO(WebDriver webDriver) {
        List<WebElement> menu = webDriver.findElements(By.xpath(mainMenuXpath2));
    }
}

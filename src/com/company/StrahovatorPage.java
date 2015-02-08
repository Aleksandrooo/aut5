package com.company;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
//import TestHelper;
/**
 * Created by Alex on 05.02.15.
 */
public class StrahovatorPage {
    private static String mainMenuXpath = "//div[@class='nav-collapse collapse']/ul[@class='nav']";
    private static String mainMenuXpath2 = "//div[@class='nav-collapse collapse']/ul[@class='nav']/li/a";

    public static void open(WebDriver webDriver) {
       webDriver.get("https://strahovator.com.ua/");
       webDriver.manage().window().maximize();
//       TestHelper.webDriver.manage().window().maximize();
//       TestHelper.webDriver.navigate().back();
//       TestHelper.webDriver.switchTo().alert().accept();
//       TestHelper.webDriver.switchTo().frame("topFrame");
//       TestHelper.webDriver.switchTo().parentFrame();
    }

    private static int convertMenuNameToIndex(String menuName) {
        if (menuName.equals("Главная"))return 0;
        if (menuName.equals("ОСАГО"))return 1;
        if (menuName.equals("КАСКО"))return 2;
        if (menuName.equals("Зеленая карта"))return 3;
        if (menuName.equals("Для выезжающих за границу"))return 4;
        if (menuName.equals("Как мы работаем"))return 5;
        if (menuName.equals("Контакты"))return 6;
        else
            Assert.fail("Unknown MainMenu requested");
        return 100;
    }

     static void CheckNameMenu() {
        //WebElement m = TestHelper.webDriver.findElement(By.xpath(mainMenuXpath));
        //WebElement m = webDriver.findElement(By.xpath(mainMenuXpath));
        //List<WebElement> menu = m.findElements(By.tagName("a"));
        List<WebElement> menu = TestHelper.webDriver.findElements(By.xpath("//div[@class='nav-collapse collapse']/ul[@class='nav']/li/a"));
        Assert.assertEquals("Главная", menu.get(0).getText());
        Assert.assertEquals("ОСАГО", menu.get(1).getText());
        Assert.assertEquals("КАСКО", menu.get(2).getText());
        Assert.assertEquals("Зеленая карта", menu.get(3).getText());
        Assert.assertEquals("Для выезжающих за границу", menu.get(4).getText());
        Assert.assertEquals("Как мы работаем", menu.get(5).getText());
        Assert.assertEquals("Контакты", menu.get(6).getText());
     }

    public static void clickMenu(String menuName) {
        List<WebElement> menu = TestHelper.webDriver.findElements(By.xpath(mainMenuXpath2));
        menu.get(convertMenuNameToIndex(menuName)).click();
    }
}

package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

/**
 * Created by Alex on 03.02.15.
 */
public class waitElements {

    public static WebElement waitElement(WebDriver webDriver,  String path) throws InterruptedException {
        WebElement we = null; // = webDriver.findElement(By.xpath(siteXpath));
        int timeout = 30000, timepassed = 0, s;
        while(timepassed < timeout) {
            s = webDriver.findElements(By.xpath(path)).size();
            //if (webDriver.findElements(By.xpath(path)).size() > 0) {
            if (s > 0) {
                we = webDriver.findElements(By.xpath(path)).get(0);
                System.out.println(we.getAttribute("value"));
                break;
            }
            Thread.sleep(100);
            timepassed += 100;
            System.out.println(timepassed);
        }
        return we; //Assert.fail();
    }
}

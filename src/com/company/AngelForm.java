package com.company;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by user on 1/30/15.
 */
public class AngelForm {
//    private static String masterXpath = "//input[@name='master']";
//    private static String siteXpath = "//input[@name='site']";
//    private static String submitXpath = "//input[@type='submit']";
//    private static String passwordXpath = "//input[@name='password']";
      private static String masterXpath = "//td[text()='Your master password']/following-sibling::td/input";
      private static String siteXpath = "//td[text()='Site name']/following-sibling::td/input";
      private static String submitXpath = "//input[@type='submit']";
      private static String passwordXpath = "//td[text()='Generated password']/following-sibling::td/input";


    //public static void open(WebDriver webDriver){ webDriver.get("http://angel.net/~nic/passwd.current.html");
    public static void open(WebDriver webDriver){ webDriver.get("http://oxogamestudio.com/passwd.current7.htm");
    }

    public static void setMaster(WebDriver webDriver, String s) throws InterruptedException {
        //WebElement f = webDriver.findElement(By.xpath(masterXpath));
        WebElement f = TestHelper.waitElement(webDriver, masterXpath);
        f.clear();
        f.sendKeys(s);
    }

    public static void setSite(WebDriver webDriver, String s) throws InterruptedException {
        //WebElement f = webDriver.findElement(By.xpath(siteXpath));
        WebElement f = TestHelper.waitElement(webDriver, siteXpath);
        f.clear();
        f.sendKeys(s);
    }

    public static void generate(WebDriver webDriver) throws InterruptedException {
        //WebElement submit = webDriver.findElement(By.xpath(submitXpath));
        WebElement submit = TestHelper.waitElement(webDriver, submitXpath);
        submit.click();
    }

    public static String getPassword(WebDriver webDriver) throws InterruptedException {
        WebElement f = TestHelper.waitElement(webDriver, passwordXpath);
        //waitElements.waitValue(webDriver, passwordXpath, val);

        return f.getAttribute("value");
    }

    public static void assertPassword(WebDriver webDriver, String val) throws InterruptedException {
        //WebElement f = waitElements.waitValue(webDriver, passwordXpath, val);
        TestHelper.waitValue(webDriver, passwordXpath, val);

        //return f.getAttribute("value");
    }

    public static String getMaster(WebDriver webDriver) throws InterruptedException {
        //WebElement f = webDriver.findElement(By.xpath(masterXpath));
        WebElement f = TestHelper.waitElement(webDriver, masterXpath);
        return f.getAttribute("value");

    }

    public static String getSite(WebDriver webDriver) throws InterruptedException {
        //WebElement f = webDriver.findElement(By.xpath(siteXpath));
        WebElement f = TestHelper.waitElement(webDriver, siteXpath);
        return f.getAttribute("value");
    }

//    public static WebElement waitElements(WebDriver webDriver,  String path) throws InterruptedException {
//       WebElement we = null; // = webDriver.findElement(By.xpath(siteXpath));
//        int timeout = 30000, timepassed = 0, s;
//        while(timepassed < timeout) {
//            s = webDriver.findElements(By.xpath(path)).size();
//            //if (webDriver.findElements(By.xpath(path)).size() > 0) {
//            if (s > 0) {
//                we = webDriver.findElements(By.xpath(path)).get(0);
//                System.out.println(we.getAttribute("value"));
//                break;
//            }
//            Thread.sleep(100);
//            timepassed += 100;
//            System.out.println(timepassed);
//        }
//        return we;
//    }

}

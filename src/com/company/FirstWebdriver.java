package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

/**
 * Created by user on 1/19/15.
 */
public class FirstWebdriver {
    public static void main (String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:/AUT5/chromedriver.exe");

        WebDriver a = new ChromeDriver();
        a.get("http://google.com");

        //By.id(lst-ib)
        WebElement i = a.findElement(By.id("gbqfq"));

        i.sendKeys("qa factory");
        //i.sendKeys("itlab");
        WebElement j = a.findElement(By.id("gbqfb"));
        j.click();

        Thread.sleep(1000);
        WebElement d = a.findElement(By.id("ires"));


        List<WebElement> l = d.findElements(By.tagName("a"));

        int n= 0 ;
       // WebElement f = l.get(0);

        while (n < l.size()){
         ///m[n] = l.get(n);
            WebElement f = l.get(n);
          System.out.println(f.getText());
          System.out.println(f.getAttribute("href"));
          n++;
        }


        WebElement f = l.get(0);

        System.out.println(f.getText());
        System.out.println(f.getAttribute("href"));

        if (f.getText().equals("QA Factory")){
            System.out.println("Test name  : passed ");
        } else System.out.println("Test name  : failed ");

        if (f.getAttribute("href").equals("http://qafactory.com.ua/")){
            System.out.println("Test link  : passed ");
        } else System.out.println("Test link  : failed ");



        a.quit();
    }
}

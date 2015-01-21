package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by Alex on 20.01.15.
 */
public class GoogleTWebDriver {

    public static void main (String[] args) throws InterruptedException {
        int n = 0;  String[] input = {"синий", "белый",  "черный",  "желтый"};
        String[] output = {"blue", "white", "black", "yellow"};
        System.setProperty("webdriver.chrome.driver", "D:/AUT5/chromedriver.exe");

        WebDriver a = new ChromeDriver();
        a.get("https://translate.google.com/#ru/en/");
        WebElement i = a.findElement(By.id("source"));
        while (n < input.length){
            i.clear();
            i.sendKeys(input[n]);

            WebElement j = a.findElement(By.id("gt-submit"));
            j.click();
            Thread.sleep(1000);
            WebElement d = a.findElement(By.id("result_box"));
            System.out.println(input[n] + " - " + d.getText());
            if (d.getText().equals(output[n])){
                System.out.println("Test name  : passed ");
            } else System.out.println("Test name  : failed ");

            n++;
        }


        // i.sendKeys("qa factory");
        //i.sendKeys("itlab");
       /* WebElement j = a.findElement(By.id("gt-submit"));
        j.click();

        Thread.sleep(1000);
        WebElement d = a.findElement(By.id("result_box"));

        //List<WebElement> l = d.getText();
        String str = new String();
        str = d.getText();
        System.out.println("red - " + str);

*/
        // System.out.println(m[n].getAttribute("href"));

        /*
        if (f.getText().equals("QA Factory")){
            System.out.println("Test name  : passed ");
        } else System.out.println("Test name  : failed ");

        if (f.getAttribute("href").equals("http://qafactory.com.ua/")){
            System.out.println("Test link  : passed ");
        } else System.out.println("Test link  : failed ");

*/

      //  a.quit();
    }

}
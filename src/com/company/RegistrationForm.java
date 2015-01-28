package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by user on 1/28/15.
 */
public class RegistrationForm {
    public static void open(WebDriver w){
       w.get("http://demoqa.com/registration/");

    }

    public static void setFirstName(WebDriver w, String i ){
        w.findElement((By.xpath("//div[input[@name='first_name']")));
    }
}

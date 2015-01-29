package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

/**
 * Created by user on 1/28/15.
 */
public class RegistrationForm {
    private static String firstNameXpath = "//input[@name='first_name']";
    private static String lastNameXpath = "//input[@name='last_name']";
    private static String maritalStatusXpath = "//div[@class='radio_wrap']/input[@name='radio_4[]']";
    private static String hobbyXpath = "//div[@class='radio_wrap']/input[@name='checkbox_5[]']";
    private static String countryXpath = "//div[@class='fieldset']/select[@name='dropdown_7']";
    private static String monthXpath = "//select[@id='mm_date_8']";
    private static String dayXpath = "//select[@id='dd_date_8']";
    private static String yearXpath = "//select[@id='yy_date_8']";



    public static void open(WebDriver w){
       w.get("http://demoqa.com/registration/");
    }

    public static void setFirstName(WebDriver w, String i){
        WebElement f = w.findElement(By.xpath(firstNameXpath));
        f.sendKeys(i);
    }

    public static String getFirstName(WebDriver w){
        WebElement f = w.findElement(By.xpath(firstNameXpath));
        return f.getText();
    }

    public static String getLabelFirstName(WebDriver w){
        WebElement f = w.findElement(By.xpath(firstNameXpath  + "/preceding-sibling::label"));
        return f.getText();
    }

    public static void setLastName(WebDriver w, String i){
        WebElement f = w.findElement(By.xpath(lastNameXpath));
        f.sendKeys(i);
    }

    public static String getLastName(WebDriver w){
        WebElement f = w.findElement(By.xpath(lastNameXpath));
        return f.getText();
    }

    public static String getLabelLastName(WebDriver w){
        WebElement f = w.findElement(By.xpath(lastNameXpath  + "/preceding-sibling::label"));
        return f.getText();
    }

    public static void setMaritalStatus(WebDriver w, int i){
        List<WebElement> Status = w.findElements(By.xpath(maritalStatusXpath));
        Status.get(1).click();
    }

    public static Boolean getMaritalStatus(WebDriver w){
        List<WebElement> Status = w.findElements(By.xpath(maritalStatusXpath));
        int i=0; boolean bl = true;
        while (i < Status.size()){
            if(Status.get(i).isSelected()){bl = false; break;
            } else{ bl = true;}
            i++;
        }
        return bl;
    }

    public static void setHobby(WebDriver w, int i){
        List<WebElement> Status = w.findElements(By.xpath(hobbyXpath));
        Status.get(1).click();
    }

    public static Boolean getHobby(WebDriver w){
        List<WebElement> Status = w.findElements(By.xpath(hobbyXpath));
        int i=0; boolean bl = true;
        while (i < Status.size()){
            if(Status.get(i).isSelected()){bl = false; break;
            } else{ bl = true;}
            i++;
        }
        return bl;
    }

    public static void setCountry(WebDriver w, String i){
        WebElement country = w.findElement(By.xpath(countryXpath));
        Select s = new Select(country);
       // printresult("Значение по умолчанию Country ",
       //         country.findElements(By.tagName("option")).get(0).getText().equals("Afghanistan"));
        s.selectByValue(i);
    }

    public static String getCountry(WebDriver w){
        WebElement country = w.findElement(By.xpath(countryXpath));
        return country.findElements(By.tagName("option")).get(0).getText();
    }

    public static void setMonth(WebDriver w, String i){
        WebElement month = w.findElement(By.xpath(monthXpath));
        Select s = new Select(month);
        s.selectByValue(i);
    }

    public static String getMonth(WebDriver w){
        WebElement month = w.findElement(By.xpath(monthXpath));
        return month.findElements(By.tagName("option")).get(0).getText();
    }

    public static void setDay(WebDriver w, String i){
        WebElement day = w.findElement(By.xpath(dayXpath));
        Select s = new Select(day);
        s.selectByValue(i);
    }

    public static String getDay(WebDriver w){
        WebElement day = w.findElement(By.xpath(dayXpath));
        return day.findElements(By.tagName("option")).get(0).getText();
    }

    public static void setYear(WebDriver w, String i){
        WebElement year = w.findElement(By.xpath(yearXpath));
        Select s = new Select(year);
        s.selectByValue(i);
    }

    public static String getYear(WebDriver w){
        WebElement year = w.findElement(By.xpath(yearXpath));
        return year.findElements(By.tagName("option")).get(0).getText();
    }




}

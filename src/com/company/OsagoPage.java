package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

/**
 * Created by trofimenko on 06.02.2015.
 */
public class OsagoPage extends StrahovatorPage{
    private static String transportXpath = "//select[@id='ts_type']";
    private static String detailsXpath = "//select[@id='ts_details_type']";
    private static String locationXpath = "//select[@id='ts_zone']";
    private static String experienceXpath = "//select[@id='no_crash_years_qty']";
    private static String periodXpath = "//select[@id='period']";
    private static String dgoXpath = "//select[@id='dgo']";
    private static String imgXpath = "//img [@class='osago_partner_logo']";

    public static Select getFldTransport() {
        return new Select(TestHelper.webDriver.findElement(By.xpath(transportXpath)));
    }

    public static Select getFldDetails() {
        return new Select(TestHelper.webDriver.findElement(By.xpath(detailsXpath)));
    }


    public static String getDefaultValue(Select select) {
        return select.getFirstSelectedOption().getText();
    }


//////////////////////////////////////////////////////
    public static String getDefaultValueTransport() {
        Select s = getFldTransport();
        return s.getFirstSelectedOption().getText();
    }

    public static String getDefaultValueDetails() {
        Select s = new Select(TestHelper.webDriver.findElement(By.xpath(detailsXpath)));
        return s.getFirstSelectedOption().getText();
    }

    public static String getDefaultValueLocation() {
        Select s = new Select(TestHelper.webDriver.findElement(By.xpath(locationXpath)));
        return s.getFirstSelectedOption().getText();
    }

    public static String getDefaultValueExperience() {
        Select s = new Select(TestHelper.webDriver.findElement(By.xpath(experienceXpath)));
        return s.getFirstSelectedOption().getText();
    }

    public static String getDefaultValuePeriod() {
        Select s = new Select(TestHelper.webDriver.findElement(By.xpath(periodXpath)));
        return s.getFirstSelectedOption().getText();
    }

    public static String getDefaultValueDGO() {
        Select s = new Select(TestHelper.webDriver.findElement(By.xpath(dgoXpath)));
        return s.getFirstSelectedOption().getText();
    }

    public static void SetValueFldTransport(String i) {
        Select s = new Select(TestHelper.webDriver.findElement(By.xpath(transportXpath)));
        s.selectByValue(i);
    }

    public static void SetValueFldDetails(String i) {
        Select s = new Select(TestHelper.webDriver.findElement(By.xpath(detailsXpath)));
        s.selectByValue(i);
    }

    public static String getResultCompany(int i) {
        List<WebElement> w = TestHelper.webDriver.findElements(By.xpath(imgXpath));
        String[] str = w.get(i).getAttribute("src").split("/");
        return str[str.length -1 ];
    }
}

package com.company;

import org.openqa.selenium.By;

/**
 * Created by user on 2/9/15.
 */
public class ChoiceOfRegistrationPage extends TestHelper {
    private static String withoutRegistrationXpath = "//a[@href][text()='Продолжить ']";
    private static String BuyForLessAt20UAHXpath = "//a[@class='btn btn-success'][text()='Купить на 20 гривен дешевле']";

    public static void clickWithoutRegistrationLink() {
        TestHelper.webDriver.findElement(By.xpath(withoutRegistrationXpath)).click();
    }

    public static void clickBuyForLessAt20UAH() {
        TestHelper.webDriver.findElement(By.xpath(BuyForLessAt20UAHXpath)).click();
    }
}

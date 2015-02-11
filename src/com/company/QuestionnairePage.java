package com.company;

import org.openqa.selenium.By;

/**
 * Created by Alex on 10.02.15.
 */
public class QuestionnairePage {
    private static String lastNameXpath = "//input[@id='policy_last_name']";
    private static String firstNameXpath = "//input[@id='policy_first_name']";
    private static String parentNameXpath = "//input[@id='policy_parent_name']";
    private static String personAddressCityXpath = "//input[@id='policy_registration_address_city']";
    private static String personAddressStreetXpath = "//input[@id='policy_registration_address_street']";
    private static String personAddressHouseXpath = "//input[@id='policy_registration_address_house']";
    private static String personAddressFlatXpath = "//input[@id='policy_registration_address_app']";
    private static String INNXpath = "//input[@id='policy_identity_code']";
//    private static String parentNameXpath = "//input[@id='policy_parent_name']";
//    private static String parentNameXpath = "//input[@id='policy_parent_name']";
//    private static String parentNameXpath = "//input[@id='policy_parent_name']";
//    private static String parentNameXpath = "//input[@id='policy_parent_name']";
//    private static String parentNameXpath = "//input[@id='policy_parent_name']";
//    private static String parentNameXpath = "//input[@id='policy_parent_name']";
//    private static String parentNameXpath = "//input[@id='policy_parent_name']";
//    private static String parentNameXpath = "//input[@id='policy_parent_name']";
//    private static String parentNameXpath = "//input[@id='policy_parent_name']";
//    private static String parentNameXpath = "//input[@id='policy_parent_name']";
//    private static String parentNameXpath = "//input[@id='policy_parent_name']";
//    private static String parentNameXpath = "//input[@id='policy_parent_name']";
//    private static String parentNameXpath = "//input[@id='policy_parent_name']";
//    private static String parentNameXpath = "//input[@id='policy_parent_name']";
//    private static String parentNameXpath = "//input[@id='policy_parent_name']";
//    private static String parentNameXpath = "//input[@id='policy_parent_name']";
//    private static String parentNameXpath = "//input[@id='policy_parent_name']";



//    private static String BuyForLessAt20UAHXpath = "//a[@class='btn btn-success'][text()='Купить на 20 гривен дешевле']";
//
    public static void setValueToFld(String val, String path) {
        TestHelper.webDriver.findElement(By.xpath(path)).sendKeys(val);
    }

    public static void fillNormalCustomer() throws InterruptedException {
        setValueToFld("Testik", lastNameXpath);
        setValueToFld("Test", firstNameXpath);
        setValueToFld("Testovich", parentNameXpath);
        setValueToFld("Киев", personAddressCityXpath);
        setValueToFld("Мира", personAddressStreetXpath);
        setValueToFld("123", personAddressHouseXpath);
        setValueToFld("23", personAddressFlatXpath);
        Thread.sleep(3000);
    }

}

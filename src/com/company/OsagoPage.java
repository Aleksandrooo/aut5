package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.*;

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
    private static String priceCompanyXpath = "//span[@class='price']";

    private static Map<String, String> fieldNameOsago = new HashMap<String, String>(){{
        put("я хочу застраховать", transportXpath);
        put("детали", detailsXpath);
        put("зарегистирирован в", locationXpath);
        put("стаж безаварийной езды", experienceXpath);
        put("срок действия страховки", periodXpath);
        put("хотите ли также заключить договор ДГО ?", dgoXpath);
    }};

    public static String[] mappingValueDetailsToTransport(String Transport){
        String[] s = null;
        if(Transport.equals("легковой автомобиль")){
            return s = new String[]{
                    "--необходимо выбрать--",
                    "объем двигателя до 1600 см³ включительно",
                    "объем двигателя от 1601 до 2000 см³",
                    "объем двигателя от 2001 до 3000 см³",
                    "объем двигателя 3001 см³ и более"};
        }
        if(Transport.equals("прицеп")){
            return s = new String[]{
                    "--необходимо выбрать--",
                    "для легкового автомобиля",
                    "для грузового автомобиля"};
        }
        if(Transport.equals("автобус")){
            return s = new String[]{
                    "--необходимо выбрать--",
                    "вместимость до 20 мест включительно",
                    "вместимость более 20 мест",
                    "объем двигателя 3001 см³ и более"};
        }
        if(Transport.equals("грузовой автомобиль")){
            return s = new String[]{
                    "--необходимо выбрать--",
                    "грузоподъемность до 2 тонн включительно",
                    "грузоподъемность более 2 тонн"};
        }
        if(Transport.equals("мотоцикл или мотороллер")){
            return s = new String[]{
                    "--необходимо выбрать--",
                    "объем двигателя до 300 см³ включительно",
                    "объем двигателя более 300 см³"};
        }
        else
            org.junit.Assert.fail("Unknown type of machine");
        return s;
    }


    private static Map<String, String> companies = new HashMap<String, String>(){{
    put("sk.gif", "СКАЙД");
    put("ax.gif", "АХА");
    put("il.gif", "ІЛЛІЧІВСЬКЕ");
}};
///////////////////////////////////////////////////////
    public static Select getFldTransport() {
        return new Select(TestHelper.webDriver.findElement(By.xpath(transportXpath)));
    }

    public static Select getFldDetails() {
        return new Select(TestHelper.webDriver.findElement(By.xpath(detailsXpath)));
    }


    public static String getDefaultValue(Select select) {
        return select.getFirstSelectedOption().getText();
    }
////////////////////////////////////////////////////////////
//private static Map<String, String> companies = new HashMap<String, String>(){{
//    put("sk.gif", "СКАЙД");
//    put("ax.gif", "АХА");
//    put("il.gif", "ІЛЛІЧІВСЬКЕ");
//}};
//
//    public static String convertCompany(String img){
//        if (img.equals("sk.gif"))
//            return "СКАЙД";
//        if (img.equals("ax.gif"))
//            return "АХА";
//        if (img.equals("il.gif"))
//            return "ІЛЛІЧІВСЬКЕ";
//        Assert.fail("Unknown company requested");
//        return "UNKNOWN COMPANY!";
//    }
//public static String convertCompany2(String img){
//    return companies.get(img);
//}

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

    public static String getResultCompany(int i) {
        List<WebElement> w = TestHelper.webDriver.findElements(By.xpath(imgXpath));
        String[] str = w.get(i).getAttribute("src").split("/");
        return str[str.length -1 ];
    }

    public static String getPriceCompany(int i) {
        List<WebElement> w = TestHelper.webDriver.findElements(By.xpath(priceCompanyXpath));
        return w.get(i).getText();
    }

    public static void setDropDown(String fieldName, String val) {
        //WebElement w = TestHelper.webDriver.findElement(By.xpath(convertFldName(fieldName))); //priceCompanyXpath));
        //w.(ConverValue());
        Select s = new Select(TestHelper.webDriver.findElement(By.xpath(fieldNameOsago.get(fieldName))));
        s.selectByVisibleText(val);
    }

    public static void AssertDetailsForOsago(String val) {
        setDropDown("я хочу застраховать", val);
        Select s = new Select(TestHelper.webDriver.findElement(By.xpath(fieldNameOsago.get("детали"))));
        if(val.equals("легковой автомобиль")){
            for(int i =0; i < s.getOptions().size(); i++){
            Assert.assertEquals(mappingValueDetailsToTransport(val)[i], s.getOptions().get(i).getText());
            }
        }
        if(val.equals("прицеп")){
            for(int i =0; i < s.getOptions().size(); i++){
                Assert.assertEquals(mappingValueDetailsToTransport(val)[i], s.getOptions().get(i).getText());
            }
        }
        if(val.equals("автобус")){
            for(int i =0; i < s.getOptions().size(); i++){
                Assert.assertEquals(mappingValueDetailsToTransport(val)[i], s.getOptions().get(i).getText());
            }
        }
        if(val.equals("грузовой автомобиль")){
            for(int i =0; i < s.getOptions().size(); i++){
                Assert.assertEquals(mappingValueDetailsToTransport(val)[i], s.getOptions().get(i).getText());
            }
        }
        if(val.equals("мотоцикл или мотороллер")){
            for(int i =0; i < s.getOptions().size(); i++){
                Assert.assertEquals(mappingValueDetailsToTransport(val)[i], s.getOptions().get(i).getText());
            }
        }



    }
}

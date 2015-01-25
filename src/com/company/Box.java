package com.company;

import org.openqa.selenium.By;

public class Box {
    private String boxName = "Box";

    public void name() {
        System.out.println(boxName);
    }

    public void rename(String newName) {
        boxName = newName;
    }

    public void fillFirstName(String firstName) {
        //aa.findElement(By.id("firstNameNewCool")).sendKeys(firstName);
    }
}
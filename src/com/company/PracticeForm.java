package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by user on 1/21/15.
 */
public class PracticeForm {
    public static void main (String[] args) throws InterruptedException {
        int n = 0;
        //String[] input = {"синий", "белый", "черный", "желтый"};
       // String[] output = {"blue", "white", "black", "yellow"};
        System.setProperty("webdriver.chrome.driver", "D:/AUT5/chromedriver.exe");
        //System.setProperty("webdriver.chrome.driver", "D:/Soft/IDE/chromedriver_win32/chromedriver.exe");
        //Automation Practice Form
        WebDriver a = new ChromeDriver();
        a.get("http://www.toolsqa.com/automation-practice-form");
        Thread.sleep(3000);
        WebElement link1 = a.findElement(By.id("content")).findElements(By.tagName("a")).get(0);
        //link1.click();

        if (link1.getAttribute("href").equals("http://www.toolsqa.com/automation-practice-form/")){
            System.out.println("Test link1  : passed ");
        } else {
            System.out.println("Test link1  : failed ");
            System.out.println(link1.getAttribute("href"));
        }
        WebElement cont = a.findElement(By.id("continents"));
        Select s = new Select(cont);
        s.selectByVisibleText("Europe");
        System.out.println(s.getFirstSelectedOption().getText());

        WebElement command = a.findElement(By.id("selenium_commands"));
        s = new Select(command);
       // s.selectByVisibleText("Navigation Commands"); //Switch Commands
        s.selectByIndex(1);
        command.sendKeys(Keys.CONTROL);
        s.selectByIndex(2);

        //command.sendKeys(Keys.SHIFT);
        //s.selectByIndex('4');
        n=0;
        while (n < s.getAllSelectedOptions().size()) {
            System.out.println(s.getAllSelectedOptions().get(n).getText());
            n++;
        }


       // setClipboardData("C:\\path to file\\example.jpg");
//native key strokes for CTRL, V and ENTER keys
      //  Robot robot = new Robot();
     //   robot.keyPress(KeyEvent.VK_CONTROL);
      //  robot.keyPress(KeyEvent.VK_V);
      //  robot.keyRelease(KeyEvent.VK_V);
      //  robot.keyRelease(KeyEvent.VK_CONTROL);
      //  robot.keyPress(KeyEvent.VK_ENTER);
     //   robot.keyRelease(KeyEvent.VK_ENTER);

     //   http://demoqa.com/
      /*  WebElement name = a.findElement(By.name("firstname"));
        name.sendKeys("Testa");
        name = a.findElement(By.name("lastname"));
        name.sendKeys("Testik");
        System.out.println("Testa  Testik");
        WebElement RB = a.findElement(By.id("sex-1"));
        RB.click();
        RB = a.findElement(By.id("sex-0"));
        RB.click();
        System.out.println("Male     Female");
        WebElement exp = a.findElement(By.id("exp-0"));
        n=1;
        //while(n < exp.getSize()) {
        while(n < 7) {
            exp = a.findElement(By.id("exp-" + n));
            exp.click();
            n++;
        }
        WebElement dt = a.findElement(By.id("datepicker"));
        dt.sendKeys("12.11.2014");
        dt.clear();
        dt.sendKeys("2014-11-12");
        WebElement prof = a.findElement(By.id("profession-0"));
        prof.click(); // prof.isSelected();
        prof = a.findElement(By.id("profession-1"));
        prof.click();//prof.isSelected();
        WebElement photo = a.findElement(By.id("photo"));
        photo.click(); //kot_40912552_big_.jpeg
        */
        a.quit();
    }
}

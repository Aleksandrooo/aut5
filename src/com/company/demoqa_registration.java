package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Random;

/**
 * Created by Alex on 24.01.15.
 */
public class demoqa_registration {

    public static void main (String[] args) throws InterruptedException, AWTException {
        int i = 0;
        //System.setProperty("webdriver.chrome.driver", "D:/AUT5/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", "D:/Soft/IDE/chromedriver_win32/chromedriver.exe");

        WebDriver a = new ChromeDriver();
        a.get("http://demoqa.com/registration/");
        Thread.sleep(3000);
       /* String forName = "qwertyuiopasdfghjklQWERTYUIOASGHJKLZXCVBNM";
        Random r = new Random();
        int o =0;
        String userName = "";
        while( o < 10){
            int nnn = r.nextInt(forName.length());
            userName = userName + forName.charAt(nnn);
            o++;
         }*/

        //////new Random().
        //-------------------------------
       // System.out.println("Значения  по умолчанию");
        //Name.getText();
        //-------------------------------

        WebElement Name = a.findElement(By.id("name_3_firstname"));
       // Name = a.findElement(By.xpath("//input[@name='first_name']/../label"));
        WebElement label1 = a.findElement(By.xpath("//div[input[@name='first_name']]/label"));
        System.out.println(label1.getText());
        //System.out.println("Значения  по умолчанию");
        printresult("Значениe по умолчанию firstname", Name.getText().equals(""));
        Name.sendKeys("Testa");

        Name = a.findElement(By.id("name_3_lastname"));
        label1 = a.findElement(By.xpath("//div[input[@name='last_name']]/label"));
        System.out.println(label1.getText());
        printresult("Значение по умолчанию lastname", Name.getText().equals(""));
        Name.sendKeys("Testik");
        //System.out.println("Testa  Testik");


        List<WebElement> Status = a.findElements(By.name("radio_4[]"));
        i=0; boolean bl = true;
        while (i < Status.size()){
            if(Status.get(i).isSelected()){bl = false; break;
            } else{ bl = true;}
            i++;
        }
        printresult("Значение по умолчанию Marital Status ", bl);
        List<WebElement> labels = a.findElements(By.xpath("//div[input[@name='radio_4[]']]/label"));
        i=0;
        while(i < labels.size() ){
            System.out.print("Label - " + labels.get(i).getText() +  "; ");
            i++;
        }
        Status.get(1).click();

        List<WebElement> Hobby = a.findElements(By.name("checkbox_5[]"));
        i=0;  bl = true;
        while (i < Hobby.size()){
            if(Hobby.get(i).isSelected()){bl = false; break;
            }
            i++;
        }
        printresult("Значение по умолчанию Hobby ", bl);
        labels = a.findElements(By.xpath("//div[input[@name='checkbox_5[]']]/label"));
        i=0;
        while(i < labels.size() ){
            System.out.print("Label - " + labels.get(i).getText() + "; ");
            i++;
        }
        Hobby.get(1).click();

        WebElement country = a.findElement(By.id("dropdown_7"));
        Select s = new Select(country);
        printresult("Значение по умолчанию Country ",
                country.findElements(By.tagName("option")).get(0).getText().equals("Afghanistan"));
        s.selectByValue("Ukraine");//).selectByVisibleText("Europe");

        WebElement month = a.findElement(By.id("mm_date_8"));
        s = new Select(month);
        printresult("Значение по умолчанию Month ",
                month.findElements(By.tagName("option")).get(0).getText().equals("Month"));
        s.selectByValue("10");

        WebElement day = a.findElement(By.id("dd_date_8"));
        s = new Select(day);
        printresult("Значение по умолчанию Day ",
                day.findElements(By.tagName("option")).get(0).getText().equals("Day"));
        s.selectByValue("21");

        WebElement year = a.findElement(By.id("yy_date_8"));
        s = new Select(year);
        printresult("Значение по умолчанию Year ",
                year.findElements(By.tagName("option")).get(0).getText().equals("Year"));
        s.selectByValue("2000");

        WebElement phone  = a.findElement(By.id("phone_9"));
        printresult("Значение по умолчанию phone", phone.getText().equals(""));
        //label1 = a.findElement(By.xpath("//input[@id='phone_9']/.label"));
        label1 = a.findElement(By.xpath("//div[input[@name='phone_9']]/label"));
        System.out.println("Label - " + label1.getText());
        phone.sendKeys("0441112233");

        WebElement username = a.findElement(By.id("username"));
        printresult("Значение по умолчанию username", username.getText().equals(""));
        username.sendKeys("LoginUser");

        WebElement email  = a.findElement(By.id("email_1"));
        printresult("Значение по умолчанию email", email.getText().equals(""));
        email.sendKeys("email@mail.ua");

        WebElement Profile  = a.findElement(By.id("profile_pic_10"));
        Profile.click();
        Thread.sleep(3000);
        //StringSelection ss = new StringSelection("C:\\MyWork\\AUT5\\newRepo\\.gitignore");
        StringSelection ss = new StringSelection("D:\\Ris\\kot_40912552_big_.jpeg");
        //StringSelection ss = new StringSelection("D:\\AUT5\\ris1.JPG");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
        //imitate mouse events like ENTER, CTRL+C, CTRL+V
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        WebElement about = a.findElement(By.id("description"));
        printresult("Значение по умолчанию About Yourself", about.getText().equals(""));
        about.sendKeys("Bla - bla bla Bla - bla blaBla - bla blaBla - bla blaBla - " +
                "bla blaBla - bla blaBla - bla blaBla - bla bla ");

        WebElement password = a.findElement(By.id("password_2"));
        printresult("Значение по умолчанию password", password.getText().equals(""));
        password.sendKeys("PASSpass1234!@#$");

        WebElement password2 = a.findElement(By.id("confirm_password_password_2"));
        printresult("Значение по умолчанию Confirm Password", password2.getText().equals(""));
        password2.sendKeys("PASSpass1234!@#$");

        WebElement submit = a.findElement(By.name("pie_submit"));
        printresult("Значение по умолчанию submit", submit.getAttribute("value").equals("Submit"));
        submit.click();

        //piereg_message  Thank you for your registration

        /*if (link1.getAttribute("href").equals("http://www.toolsqa.com/automation-practice-form/")){
            System.out.println("Test link1  : passed ");
        } else {
            System.out.println("Test link1  : failed ");
            System.out.println(link1.getAttribute("href"));
        }
        */
       // a.quit();
    }

    public static  void printresult (String str, boolean passed){

        if (passed){
            System.out.println(str + " : passed ");
        } else {
            System.out.println(str + " : failed ");
           // System.out.println(link1.getAttribute("href"));
        }
    }
}

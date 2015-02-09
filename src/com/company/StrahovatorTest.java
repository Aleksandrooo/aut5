package com.company;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;

/**
 * Created by user on 2/4/15.
 */
@RunWith(JUnit4.class)
public class StrahovatorTest extends TestHelper {

//    WebDriver webDriver;
//    boolean testPassed;

//    @Rule
//    public TestName name = new TestName();
//
//    @Before
//    public void  Init() throws InterruptedException {
//        //System.setProperty("webdriver.chrome.driver", "D:/AUT5/chromedriver.exe");
//        System.setProperty("webdriver.chrome.driver", "D:/Soft/IDE/chromedriver_win32/chromedriver.exe");
//        webDriver = new ChromeDriver();
//        webDriver.manage().window().maximize();
//        StrahovatorPage.open(webDriver);
//        testPassed = false;
//        Thread.sleep(3000);
//    }
//
//    @After
//    public void  CleanUp() throws IOException {
//        if (!testPassed) {
//            File scrFile = ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);
//            FileUtils.copyFile(scrFile, new File("D:\\AUT5\\temp\\" + name.getMethodName() + ".png"));
//           // FileUtils.copyFile(scrFile, new File("d:\\Testing\\temp\\" + name.getMethodName() + ".png"));
//        }
//        webDriver.quit();
//    }



    @Test
    public void CheckMainMenu() throws InterruptedException, IOException {
        StrahovatorPage.CheckNameMenu();
        testPassed = true;
    }

    @Test
    public void DefaultValueOSAGO() throws InterruptedException, IOException {
        StrahovatorPage.clickMenu("ОСАГО");
        Assert.assertEquals("--необходимо выбрать--", OsagoPage.getDefaultValueTransport());
        Assert.assertEquals("--необходимо выбрать--", OsagoPage.getDefaultValueDetails());
        Assert.assertEquals("Киев", OsagoPage.getDefaultValueLocation());
        Assert.assertEquals("3 года", OsagoPage.getDefaultValueExperience());
        Assert.assertEquals("1 год", OsagoPage.getDefaultValuePeriod());
        Assert.assertEquals("нет", OsagoPage.getDefaultValueDGO());
        testPassed = true;
    }

    @Test
    public void Top3Company() throws InterruptedException, IOException {
        StrahovatorPage.clickMenu("ОСАГО");
        OsagoPage.setDropDown("я хочу застраховать", "легковой автомобиль");
        OsagoPage.setDropDown("детали", "объем двигателя до 1600 см³ включительно");
        Assert.assertEquals("ut.gif", OsagoPage.getResultCompany(0));
        Assert.assertEquals("sk.gif", OsagoPage.getResultCompany(1));
        Assert.assertEquals("il.gif", OsagoPage.getResultCompany(2));
        testPassed = true;
    }

    @Test
    public void BestPriceForOsago() throws InterruptedException, IOException {
        StrahovatorPage.clickMenu("ОСАГО");
        OsagoPage.setDropDown("я хочу застраховать", "легковой автомобиль");
        OsagoPage.setDropDown("детали", "объем двигателя до 1600 см³ включительно");
        Assert.assertEquals("530 грн.", OsagoPage.getPriceCompany(0));
        Assert.assertEquals("571 грн.", OsagoPage.getPriceCompany(1));
        Assert.assertEquals("694 грн.", OsagoPage.getPriceCompany(2));
        testPassed = true;
    }

    @Test
    public void CheckValueDetailsForOsago() throws InterruptedException, IOException {
        StrahovatorPage.clickMenu("ОСАГО");
        OsagoPage.AssertDetailsForOsago("легковой автомобиль");
        OsagoPage.AssertDetailsForOsago("прицеп");
        OsagoPage.AssertDetailsForOsago("автобус");
        OsagoPage.AssertDetailsForOsago("грузовой автомобиль");
        OsagoPage.AssertDetailsForOsago("мотоцикл или мотороллер");
        testPassed = true;
    }

    @Test
    public void checkFranchiseForBestPrice() throws InterruptedException, IOException {
        StrahovatorPage.clickMenu("ОСАГО");
        OsagoPage.setDropDown("я хочу застраховать", "легковой автомобиль");
        OsagoPage.setDropDown("детали", "объем двигателя до 1600 см³ включительно");
        OsagoPage.checkFranchise(0);
        testPassed = true;
    }

    @Test
    public void checkBuyForBestPrice() throws InterruptedException, IOException {
        StrahovatorPage.clickMenu("ОСАГО");
        OsagoPage.setDropDown("я хочу застраховать", "легковой автомобиль");
        OsagoPage.setDropDown("детали", "объем двигателя до 1600 см³ включительно");
        OsagoPage.clickButBuy(0);
        testPassed = true;
    }

//    @Test
//    public void MyTest() {
//        StrahovatorPage.clickMenu("ОСАГО");
//        StrahovatorPage.setDropDown("я хочу застраховать", "прицеп");
//        StrahovatorPage.setDropDown("детали", "для легкового автомобиля");
//        StrahovatorPage.assertFirstCompany("СКАЙД");
//    }


}

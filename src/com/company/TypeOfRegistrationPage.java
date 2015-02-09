package com.company;

/**
 * Created by user on 2/9/15.
 */
public class TypeOfRegistrationPage extends TestHelper {
    private static String transportXpath = "//button[@class='btn btn-success osago_order'][text()='купить']";

    //class="btn btn-success osago_order"
    public static void checkFranchise(int j) throws InterruptedException {
//        WebElement w = TestHelper.webDriver.findElement(By.xpath(franchiseCompanyXpath));
//        new Actions(TestHelper.webDriver).moveToElement(w).perform();
//        //Thread.sleep(2000);
//        //List<WebElement> fran = TestHelper.webDriver.findElements(By.xpath(franchiseCompanyXpath + "/following-sibling::div[1]/div[@class='tooltip-inner']/p"));
//        //Assert.assertEquals(franchiseText[j], fran.get(j).getText());
//        TestHelper.waitText(TestHelper.webDriver,
//                franchiseCompanyXpath + "/following-sibling::div[1]/div[@class='tooltip-inner']/p",
//                franchiseText[j]);
    }

}

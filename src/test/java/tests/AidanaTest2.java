package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utilities.Config;
import utilities.Driver;

public class AidanaTest2 {

    @BeforeTest
    public void test1() throws InterruptedException {
        Driver.getDriver().get(Config.getValue("url"));
        Driver.getDriver().findElement(By.id("email")).sendKeys(Config.getValue("username"));
        Driver.getDriver().findElement(By.id("password")).sendKeys(Config.getValue("password1"));
        Driver.getDriver().findElement(By.name("go")).click();
        Driver.getDriver().findElement(By.id("library-nav-link")).click();
        Thread.sleep(1500);
        Driver.getDriver().findElement(By.id("start-new-scout-button")).click();
        Thread.sleep(3000);

    }

    @Test
    public void chooseTodayDate(){
        String scoutingReportName = "AtlantaNew123";
        Driver.getDriver().findElement(By.id("newReportNameInput")).sendKeys(scoutingReportName);
        Driver.getDriver().findElement(By.className("Select-placeholder")).click();
        Driver.getDriver().findElement(By.xpath("//div[contains(@class,'Select-menu-outer')]//span[text()='Boston']")).click();
        Driver.getDriver().findElement(By.id("blankTemplate")).click();
        WebElement date = Driver.getDriver().findElement(By.xpath("(//input)[5]"));
        String text = date.getAttribute("value");
        System.out.println(text);

//        Driver.getDriver().findElement(By.id("createReportButton")).click();
    }
}

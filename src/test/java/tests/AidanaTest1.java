package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;
import utilities.Config;
import utilities.Driver;

import java.util.List;

public class AidanaTest1 {
    @BeforeMethod
    public void test1() throws InterruptedException {
        Driver.getDriver().get(Config.getValue("url"));
        Driver.getDriver().findElement(By.id("email")).sendKeys(Config.getValue("username"));
        Driver.getDriver().findElement(By.id("password")).sendKeys(Config.getValue("password1"));
        Driver.getDriver().findElement(By.name("go")).click();
        Driver.getDriver().findElement(By.id("library-nav-link")).click();
        Driver.getDriver().findElement(By.id("start-new-scout-button")).click();
        Thread.sleep(3000);

    }

    @Test
    public void scoutingReportName() throws InterruptedException {
        String scoutingReportName = "AtlantaNew123";
        Driver.getDriver().findElement(By.id("newReportNameInput")).sendKeys(scoutingReportName);
        Driver.getDriver().findElement(By.className("Select-placeholder")).click();
        Driver.getDriver().findElement(By.xpath("//div[contains(@class,'Select-menu-outer')]//span[text()='Boston']")).click();
        Driver.getDriver().findElement(By.id("blankTemplate")).click();
        Driver.getDriver().findElement(By.id("createReportButton")).click();
        Thread.sleep(1500);
        Driver.getDriver().navigate().back();
        Thread.sleep(1500);
        String actualReportName = Driver.getDriver().findElement(By.xpath("//tbody/tr[2]/td[3]/span/div/span[1]")).getText();
        Assert.assertEquals(actualReportName, scoutingReportName);


    }

    @Test
    public void numericCharacters() throws InterruptedException {
        String scoutingReportName = "12345";
        Driver.getDriver().findElement(By.id("newReportNameInput")).sendKeys(scoutingReportName);
        Driver.getDriver().findElement(By.className("Select-placeholder")).click();
        Driver.getDriver().findElement(By.xpath("//div[contains(@class,'Select-menu-outer')]//span[text()='Boston']")).click();
        Driver.getDriver().findElement(By.id("blankTemplate")).click();
        Driver.getDriver().findElement(By.id("createReportButton")).click();
        Thread.sleep(1500);
        Driver.getDriver().navigate().back();
        Thread.sleep(1500);
        String actualReportName = Driver.getDriver().findElement(By.xpath("//tbody/tr[2]/td[3]/span/div/span[1]")).getText();
        Assert.assertEquals(actualReportName, scoutingReportName);
    }

    @Test
    public void alphabeticCharacters() throws InterruptedException {
        String scoutingReportName = "AtlantaNew";
        Driver.getDriver().findElement(By.id("newReportNameInput")).sendKeys(scoutingReportName);
        Driver.getDriver().findElement(By.className("Select-placeholder")).click();
        Driver.getDriver().findElement(By.xpath("//div[contains(@class,'Select-menu-outer')]//span[text()='Boston']")).click();
        Driver.getDriver().findElement(By.id("blankTemplate")).click();
        Driver.getDriver().findElement(By.id("createReportButton")).click();
        Thread.sleep(1500);
        Driver.getDriver().navigate().back();
        Thread.sleep(1500);
        String actualReportName = Driver.getDriver().findElement(By.xpath("//tbody/tr[2]/td[3]/span/div/span[1]")).getText();
        Assert.assertEquals(actualReportName, scoutingReportName);
    }

    @Test
    public void specialCharacters() throws InterruptedException {
        String scoutingReportName = ">?@!@";
        Driver.getDriver().findElement(By.id("newReportNameInput")).sendKeys(scoutingReportName);
        Driver.getDriver().findElement(By.className("Select-placeholder")).click();
        Driver.getDriver().findElement(By.xpath("//div[contains(@class,'Select-menu-outer')]//span[text()='Boston']")).click();
        Driver.getDriver().findElement(By.id("blankTemplate")).click();
        Driver.getDriver().findElement(By.id("createReportButton")).click();
        String https = "https://fastscout-staging.fastmodelsports.com/library/opponents?league=NBA&season=23";
        Thread.sleep(1500);
        Assert.assertNotEquals(Driver.getDriver().getCurrentUrl(), https);
    }

    @Test
    public void emptyField() throws InterruptedException {
        String scoutingReportName = " ";
        Driver.getDriver().findElement(By.id("newReportNameInput")).sendKeys(scoutingReportName);
        Driver.getDriver().findElement(By.className("Select-placeholder")).click();
        Driver.getDriver().findElement(By.xpath("//div[contains(@class,'Select-menu-outer')]//span[text()='Boston']")).click();
        Driver.getDriver().findElement(By.id("blankTemplate")).click();
        Driver.getDriver().findElement(By.id("createReportButton")).click();
        Thread.sleep(1500);
        String actualReportName = Driver.getDriver().findElement(By.xpath("//tbody/tr[2]/td[3]/span/div/span[1]")).getText();
        Assert.assertNotEquals(actualReportName, scoutingReportName);
    }

    @Test
    public void checkIfAllTeamsArePresent(){

    }

    @AfterMethod
    public void afterMethod(){
        Driver.quit();
    }


}

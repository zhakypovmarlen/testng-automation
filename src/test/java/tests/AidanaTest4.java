package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.Config;
import utilities.Driver;

public class AidanaTest4 {

    @BeforeMethod
    public void before() throws InterruptedException {
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
    public void checkCreateButton() throws InterruptedException {
        // create new opponent scout without scouting report name
        String scoutingReportName = "NBA 2023";
        Driver.getDriver().findElement(By.id("newReportNameInput")).sendKeys(" ");
        Driver.getDriver().findElement(By.className("Select-placeholder")).click();
        Driver.getDriver().findElement(By.xpath("//div[contains(@class,'Select-menu-outer')]//span[text()='Boston']")).click();
        Driver.getDriver().findElement(By.id("blankTemplate")).click();
        WebElement createButton = Driver.getDriver().findElement(By.id("createReportButton"));
        createButton.click();
        Thread.sleep(1500);
        String actualReportName = Driver.getDriver().findElement(By.xpath("//tbody/tr[2]/td[3]/span/div/span[1]")).getText();
//        Driver.getDriver().findElement(By.id("newReportNameInput")).sendKeys(Keys.COMMAND, "a");
//        Driver.getDriver().findElement(By.id("newReportNameInput")).sendKeys(Keys.COMMAND, "c");
//        Driver.getDriver().findElement(By.id("newReportNameInput")).sendKeys(Keys.DELETE);
        Assert.assertNotEquals(actualReportName, scoutingReportName);
    }

    @Test
    public void checkCreateButtonWithoutOpponentTeam() throws InterruptedException {
        String scoutingReportName = "NBA 2023";
        Driver.getDriver().findElement(By.id("newReportNameInput")).sendKeys(scoutingReportName);
        Driver.getDriver().findElement(By.id("blankTemplate")).click();
        Driver.getDriver().findElement(By.id("createReportButton")).click();
        Thread.sleep(1500);
        String actualReportName = Driver.getDriver().findElement(By.xpath("//tbody/tr[2]/td[3]/span/div/span[1]")).getText();
        Assert.assertNotEquals(actualReportName, scoutingReportName);
    }

    @Test
    public void checkCreateButtonWithoutRadioButtonClicked() throws InterruptedException {
        String scoutingReportName = "AtlantaNew123";
        Driver.getDriver().findElement(By.id("newReportNameInput")).sendKeys(scoutingReportName);
        Driver.getDriver().findElement(By.className("Select-placeholder")).click();
        Driver.getDriver().findElement(By.xpath("//div[contains(@class,'Select-menu-outer')]//span[text()='Boston']")).click();

        Driver.getDriver().findElement(By.id("createReportButton")).click();

        Thread.sleep(1500);
        String actualReportName = Driver.getDriver().findElement(By.xpath("//tbody/tr[2]/td[3]/span/div/span[1]")).getText();
        Assert.assertNotEquals(actualReportName, scoutingReportName);
    }

    @AfterMethod
    public void after(){
        Driver.quit();
    }
}

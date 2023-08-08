package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.Config;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;

public class AidanaTest3 {


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
    public void test1() throws InterruptedException {
        List<String> teams = new ArrayList<>();
        teams.add("Atlanta");
        teams.add("Boston");
        teams.add("Brooklyn");
        teams.add("Charlotte");
        teams.add("Chicago");
        teams.add("Cleveland");
        teams.add("Dallas");
        teams.add("Denver");
        teams.add("Detroit");
        teams.add("Golden State");
        teams.add("Houston");
        teams.add("Indiana");
        teams.add("LA");
        teams.add("Los Angeles");
        teams.add("Memphis");
        teams.add("Minnesota");
        teams.add("Milwaukee");
        teams.add("Myami");
        teams.add("New Orleans");
        teams.add("New York");
        teams.add("Oklahoma City");
        teams.add("Orlando");
        teams.add("Philadelphia");
        teams.add("Phoenix");
        teams.add("Portland");
        teams.add("Sacramento");
        teams.add("San Antonio");
        teams.add("Toronto");
        teams.add("Utah");
        teams.add("Washington");


        for(int i = 0; i < teams.size(); i++){
            Driver.getDriver().findElement(By.className("Select-placeholder")).click();
            Assert.assertEquals(Driver.getDriver().findElement(By.xpath("//div[contains(@class,'Select-menu-outer')]//span[text()='"+teams.get(i)+"']")).getText(), teams.get(i));
        }
    }
}

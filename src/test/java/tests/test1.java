package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class test1 {

    @Test(priority = 2)
    public void testing(){
        Driver.getDriver().get("https://google.com");
        Faker faker = new Faker();
        Driver.getDriver().findElement(By.name("q")).sendKeys(faker.harryPotter().character() + Keys.ENTER);
    }

    @Test(priority = 1)
    public void testing1(){
        Driver.getDriver().get("https://etsy.com");
    }
    @Test(priority = 3)
    public void testFacebook(){
        Driver.getDriver().get("https://facebook.com");
    }

}


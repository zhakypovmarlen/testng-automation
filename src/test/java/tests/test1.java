package tests;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.ApplicationFlow;
import utilities.Driver;

public class test1 {

    @Test
    public void testing(){
        Driver.getDriver().get("https://google.com");
        Faker faker = new Faker();
        Driver.getDriver().findElement(By.name("q")).sendKeys(faker.harryPotter().character() + Keys.ENTER);



    }
    @Test
    public void testFacebook(){
        Driver.getDriver().get("https://facebook.com");
    }
}

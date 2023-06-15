package cashwise;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CashWiseHomePage;
import utilities.ApplicationFlow;
import utilities.Config;
import utilities.Driver;

public class CashwiseHomeTests1 {
    Faker faker = new Faker();

    @BeforeMethod
    public void setup(){
        Driver.getDriver().get(Config.getValue("cashwiseURL"));
    }

    @AfterMethod
    public void cleanup(){
        Driver.quit();
    }
    @Test
    public void contactUs(){
        CashWiseHomePage cashWiseHomePage = new CashWiseHomePage();
        cashWiseHomePage.sendMyInfo(faker.harryPotter().character(), faker.phoneNumber().subscriberNumber(9), faker.internet().emailAddress());
        Assert.assertTrue(cashWiseHomePage.contactSubmittedPopup.isDisplayed());
    }

    @Test
    public void languageOptionTest(){
        CashWiseHomePage cashWiseHomePage = new CashWiseHomePage();
        cashWiseHomePage.languageOptionsBtn.click();
        for(WebElement option : cashWiseHomePage.languageOptions){
            System.out.println(option.getText());
        }
        Assert.assertEquals(cashWiseHomePage.languageOptions.size(), 2);
    }








}

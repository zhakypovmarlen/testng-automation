package cashwise;

import com.github.javafaker.App;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CashWiseHomePage;
import pages.CashwiseDashboardPage;
import utilities.ApplicationFlow;
import utilities.Config;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;

public class CashwiseDashboard {

    @BeforeMethod
    public void setup(){
        Driver.getDriver().get(Config.getValue("cashwiseURL"));
    }

    @AfterMethod
    public void cleanup(){
        Driver.quit();
    }
    @Test
    public void sideMenuTest(){
        CashWiseHomePage cashWiseHomePage = new CashWiseHomePage();
        CashwiseDashboardPage cashwiseDashboardPage = new CashwiseDashboardPage();
        cashWiseHomePage.signIn(Config.getValue("cashwiseEmail"), Config.getValue("cashwisePassword"));
        ApplicationFlow.pause(4000);

        String currentURL = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(currentURL, Config.getValue("cashwiseHomePageURL"));

        List<String> expectedOptionsText = new ArrayList<>();
        expectedOptionsText.add("Sales");
        expectedOptionsText.add("Expenses");
        expectedOptionsText.add("Reports");
        int i = 0;

        for(WebElement buttons : cashwiseDashboardPage.menuBarButtons){
            buttons.click();
            Assert.assertEquals(buttons.getText(), expectedOptionsText.get(i));
            ApplicationFlow.pause(4000);
            Assert.assertNotEquals(currentURL, Driver.getDriver().getCurrentUrl());
            currentURL = Driver.getDriver().getCurrentUrl();
            i++;
        }
        cashwiseDashboardPage.infographicsMenuBtn.click();


    }
}

package studymate;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.TestInstance;
import pages.StudyMateGroupPage;
import pages.StudyMateLoginPage;
import utilities.ApplicationFlow;
import utilities.Config;
import utilities.Driver;

public class StudyMateLogin {

    Faker faker = new Faker();
    

    @BeforeMethod
    public void setup(){
        Driver.getDriver().get(Config.getValue("studyMateURL"));
    }



    @Test(priority = 2, groups = {"smoke"})
    public void login(){
        StudyMateLoginPage studyMateLoginPage = new StudyMateLoginPage();
        studyMateLoginPage.emailInput.sendKeys(Config.getValue("email"));
        studyMateLoginPage.passwordInput.sendKeys(Config.getValue("password"));
        studyMateLoginPage.loginButton.click();
        ApplicationFlow.pause(1500);
        Assert.assertNotEquals(Driver.getDriver().getCurrentUrl(),Config.getValue("studyMateURL"), "Failure!!! Could not log in!");
    }
    @Test(priority = 1)
    public void createGroupTest(){
        StudyMateLoginPage studyMateLoginPage = new StudyMateLoginPage();
        StudyMateGroupPage studyMateGroupPage = new StudyMateGroupPage();
        studyMateLoginPage.login(Config.getValue("email"), Config.getValue("password"));
        studyMateGroupPage.groupsCategoryBtn.click();
        String groupName = faker.harryPotter().house() + System.currentTimeMillis();

        studyMateGroupPage.createGroupBtn.click();
        studyMateGroupPage.groupNameInput.sendKeys(groupName);
        studyMateGroupPage.descriptionInput.sendKeys(groupName);;
        studyMateGroupPage.dateInput.click();
        studyMateGroupPage.dateInput.sendKeys("06202023");
        studyMateGroupPage.createBtn.click();
        ApplicationFlow.pause(2000);

        Assert.assertEquals(groupName,studyMateGroupPage.groupName.getText());
    }

    @AfterMethod
    public void cleanup(){
        Driver.quit();
    }
}

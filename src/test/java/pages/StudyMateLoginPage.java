package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class StudyMateLoginPage {

    public StudyMateLoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(name = "email")
    public WebElement emailInput;

    @FindBy(name = "password")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[.='Log in']")
    public WebElement loginButton;




    public void login(String email, String password){
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

    public void chooseLanguage(String language){
        Driver.getDriver().findElement(By.xpath("//div[@id='mui-component-select-language']")).click();
        Driver.getDriver().findElement(By.xpath("//li[.='" + language + "']")).click();
    }
}

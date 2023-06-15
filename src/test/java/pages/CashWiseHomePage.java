package pages;

import com.github.javafaker.App;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.ApplicationFlow;
import utilities.Driver;

import java.util.List;

public class CashWiseHomePage {


    public CashWiseHomePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//button[1]")
    public WebElement signInButton;

    @FindBy(xpath = "//button[2]")
    public WebElement signUpButton;

    @FindBy(name = "name")
    public WebElement nameInputCu;

    @FindBy(name = "phone")
    public WebElement phoneNumberInputCu;

    @FindBy(name = "email")
    public WebElement emailInputCu;

    @FindBy(xpath = "(//button)[4]")
    public WebElement sendButtonCu;

    @FindBy(xpath = "//div[@type='MINI']//h2")
    public WebElement contactSubmittedPopup;

    @FindBy(xpath = "(//div[@class='App']/div/div/div/div)[1]")
    public WebElement languageOptionsBtn;

    @FindBy(xpath = "//ul/li")
    public List<WebElement> languageOptions;

    @FindBy(name = "email")
    public WebElement signInEmailInput;

    @FindBy(name = "password")
    public WebElement signInPasswordInput;

    public void sendMyInfo(String name, String phone, String email){
        nameInputCu.sendKeys(name);
        phoneNumberInputCu.sendKeys(phone);
        emailInputCu.sendKeys(email);
        sendButtonCu.click();
    }

    public void signIn(String email, String password){
        signInButton.click();
        ApplicationFlow.pause(1500);
        signInEmailInput.sendKeys(email);
        signInPasswordInput.sendKeys(password + Keys.ENTER);

    }

    public void signUp(String email, String password, String name, String surname, String nameOfYourBus, String address, String currency){
        signUpButton.click();
        ApplicationFlow.pause(2000);
        Driver.getDriver().findElement(By.name("email")).sendKeys(email);
        Driver.getDriver().findElement(By.name("password")).sendKeys(password);
        Driver.getDriver().findElement(By.name("repeat_password")).sendKeys(password + Keys.ENTER);
        ApplicationFlow.pause(1500);

        Driver.getDriver().findElement(By.name("first_name")).sendKeys(name);
        Driver.getDriver().findElement(By.name("last_name")).sendKeys(surname);
        Driver.getDriver().findElement(By.name("company_name")).sendKeys(nameOfYourBus);
        Driver.getDriver().findElement(By.name("address")).sendKeys(address);
    }


}

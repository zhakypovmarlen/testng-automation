package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class StudyMateGroupPage {
    public StudyMateGroupPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//li[.='Groups']")
    public WebElement groupsCategoryBtn;

    @FindBy(xpath = "//button[.='Create group']")
    public WebElement createGroupBtn;

    @FindBy(name = "name")
    public WebElement groupNameInput;

    @FindBy(xpath = "//textarea[@type='text']")
    public WebElement descriptionInput;

    @FindBy(xpath = "//input[@placeholder='MM/DD/YYYY']")
    public WebElement dateInput;

    @FindBy(xpath = "(//div[@class='css-1qf1rpk']/div/div[2]/div/div)[1]")
    public WebElement groupName;

    @FindBy(xpath = "//button[.='Create']")
    public WebElement createBtn;




}

package pages;

import cashwise.CashwiseDashboard;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class CashwiseDashboardPage {

    public CashwiseDashboardPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[@role='button']")
    public List<WebElement> menuBarButtons;

    @FindBy(xpath = "//a[.='Infographics']")
    public WebElement infographicsMenuBtn;
}

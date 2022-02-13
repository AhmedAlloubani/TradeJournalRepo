package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class SaveTradePage {

    public SaveTradePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//p[@class='h4 mb-4']")
    public WebElement SavePageTitle;

    @FindBy (id = "longTrade")
    public List<WebElement> buyOrSellOptions;

    @FindBy (xpath = "//div/input[@name='symbol']")
    public WebElement symbolField;

    @FindBy (xpath = "//input[@name='openDate']")
    public WebElement openDateField;

    @FindBy (css  = "input[name='entry']")
    public WebElement entryPriceField;

    @FindBy (css = "input[name='closeDate']")
    public WebElement closeDateField;

    @FindBy (css  = "input[name='exit']")
    public WebElement exitPriceField;

    @FindBy (xpath  = "(//button[@type='submit'])[3]")
    public WebElement saveBtn;

    @FindBy (linkText = "Back to Transactions")
    public WebElement backToTransactionsBtn;
}

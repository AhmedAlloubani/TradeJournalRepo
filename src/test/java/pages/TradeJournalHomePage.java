package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class TradeJournalHomePage {


    public TradeJournalHomePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath  = "//a[text()='Home ']")
    public WebElement homePageTitle;

    @FindBy (xpath = "//a[text()='Finom Group']")
    public WebElement finomGroup;

    @FindBy (linkText  = "Slack Channel")
    public WebElement slackChannel;

    @FindBy (xpath = "//span[text()='PrimeTech_SDET_Batch1']")
    public WebElement batch1SlackChannel;

    @FindBy (css = "#navbarDropdown")
    public  WebElement toolsDropDown;

    @FindBy (xpath = "//a[@class='dropdown-item']")
    public List<WebElement> toolsDropDownOptions;

    @FindBy (xpath = "//input[@name='symbol']")
    public  WebElement symbolBox;

    @FindBy (xpath = "(//button[@type='submit'])[1]")
    public  WebElement searchBtn;

    @FindBy (xpath = "//input[@type='date']")
    public  WebElement dateBox;

    @FindBy (xpath = "(//button[@type='submit'])[2]")
    public  WebElement logOutBtn;

    @FindBy (linkText  = "Add trade")
    public  WebElement addTradeBtn;

    @FindBy (xpath = "//a[@class='btn btn-info btn-sm']")
    public List <WebElement> updateBtn;

    @FindBy (xpath = "//a[@class='btn btn-danger btn-sm']")
    public List <WebElement> deleteBtn;

    @FindBy(xpath = "//table/tbody/tr[1]/td")
    public List<WebElement> tradRecord;



    @FindBy (css = "h1[class='pageHeading']")
    public  WebElement optionCalPageHeader;

    @FindBy(xpath = "//table/tbody/tr")
    public List<WebElement> tableRecords;


    @FindBy(xpath = "//table/tbody/tr/td[text()='Delta']/following-sibling::td[6]//a[contains(text(),'Update')]")
    public WebElement deltaUpdate;

    @FindBy(xpath = "//table/tbody/tr/td[text()='Virginia']/following-sibling::td[6]//a[contains(text(),'Update')]")
    public WebElement deltaUpdate1;

    @FindBy(xpath = "//table/tbody/tr/td[text()='Maryland']/following-sibling::td[6]//a[contains(text(),'Update')]")
    public WebElement deltaUpdate2;












}

package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TradeJournalLoginPage {

   public  TradeJournalLoginPage(){
       PageFactory.initElements(Driver.getDriver(), this);
   }


    @FindBy(id = "username")
    public WebElement userNameBox;

    @FindBy (id = "password")
    public WebElement passwordBox;

    @FindBy (xpath = "//button[@type='submit']")
    public WebElement signInBtn;

    @FindBy (tagName = "h2")
    public WebElement loginPageHeader;

    @FindBy (xpath = "//div[text()='Bad credentials']")
    public WebElement badCredentialText;
}

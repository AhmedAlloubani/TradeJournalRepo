package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.TradeJournalHomePage;
import pages.TradeJournalLoginPage;
import utilities.Driver;
import utilities.PropertiesReader;

public class TradeJournalLoginComponentsSteps {

    TradeJournalLoginPage lp;
    TradeJournalHomePage hp;


    //@ComponentsTest #Starts
    @Given("I am a Trade Journal user")
    public void i_am_a_trade_journal_user() {

    }

    @When("User navigate to Trade Journal Login Page")
    public void user_navigate_to_trade_journal_login_page() {
        Driver.getDriver().get(PropertiesReader.getProperty("TradeAppUrl"));
    }

    @Then("User should be directed to the Trade Journal Login Page")
    public void user_should_be_directed_to_the_trade_journal_login_page() {
        lp = new TradeJournalLoginPage();
        Assert.assertTrue(lp.loginPageHeader.isDisplayed());

    }

    @Then("System should display pageHeader {string} username {string} password {string} signIn {string}")
    public void system_should_display_page_header_username_password_sign_in(String pageHeader, String username, String password, String signIn) {
        lp = new TradeJournalLoginPage();
        Assert.assertTrue(lp.loginPageHeader.isDisplayed());
        Assert.assertTrue(lp.userNameBox.isDisplayed());
        Assert.assertTrue(lp.passwordBox.isDisplayed());
        Assert.assertTrue(lp.signInBtn.isDisplayed());

        Assert.assertEquals(lp.loginPageHeader.getText().trim(), pageHeader);
        Assert.assertEquals(lp.userNameBox.getAttribute("placeholder"), username);
        Assert.assertEquals(lp.passwordBox.getAttribute("placeholder"), password);
        Assert.assertEquals(lp.signInBtn.getText().trim(), signIn);

    }
    //@ComponentsTest #Ends


    //@validLoginTest #Starts
    @Given("User navigated to the Trade Journal login Page")
    public void user_navigated_to_the_trade_journal_login_page() {
        lp = new TradeJournalLoginPage();
        Driver.getDriver().get(PropertiesReader.getProperty("TradeAppUrl"));
        Assert.assertTrue(lp.loginPageHeader.isDisplayed());
    }

    @When("User enters valid Username and user enters valid Password")
    public void user_enters_valid_username_and_user_enters_valid_password() {
        lp = new TradeJournalLoginPage();
        lp.userNameBox.sendKeys(PropertiesReader.getProperty("username"));
        lp.passwordBox.sendKeys(PropertiesReader.getProperty("password"));
    }

    @When("User clicks on Sign in button")
    public void user_clicks_on_sign_in_button() {
        lp = new TradeJournalLoginPage();
        lp.signInBtn.click();
    }

    @Then("User should be directed to the Trade Journal App Home Page")
    public void user_should_be_directed_to_the_trade_journal_app_home_page() {
        hp = new TradeJournalHomePage();
        Assert.assertTrue(hp.homePageTitle.isDisplayed());
    }
    //@validLoginTest #Ends


    //@InvalidLoginTest #Starts

    @When("User enters invalid username {string} and invalid password {string}")
    public void user_enters_invalid_username_and_invalid_password(String username, String password) {
        lp = new TradeJournalLoginPage();
        hp = new TradeJournalHomePage();
        lp.userNameBox.sendKeys(username);
        lp.passwordBox.sendKeys(password);
    }

    @When("User enters valid UserName {string} and invalid password {string}")
    public void user_enters_valid_user_name_and_invalid_password(String string, String password) {
        lp = new TradeJournalLoginPage();
        hp = new TradeJournalHomePage();
        lp.userNameBox.sendKeys(PropertiesReader.getProperty("username"));
        lp.passwordBox.sendKeys(password);
    }

    @When("User enters invalid Username {string} and user enters valid PassWord")
    public void user_enters_invalid_username_and_user_enters_valid_pass_word(String username) {
        lp = new TradeJournalLoginPage();
        hp = new TradeJournalHomePage();
        lp.userNameBox.sendKeys(username);
        lp.passwordBox.sendKeys(PropertiesReader.getProperty("password"));
    }

    @Then("User should not be directed to the Trade Journal Home Page")
    public void user_should_not_be_directed_to_the_trade_journal_home_page() {
        lp = new TradeJournalLoginPage();
        hp = new TradeJournalHomePage();
        lp.loginPageHeader.isDisplayed();
    }

    @Then("System should display message {string}")
    public void system_should_display_message(String expectedErrorMessage) {
        lp = new TradeJournalLoginPage();
        hp = new TradeJournalHomePage();
        Assert.assertEquals(lp.badCredentialText.getText().trim(), expectedErrorMessage);


        //InvalidLoginTest #Ends

    }
}
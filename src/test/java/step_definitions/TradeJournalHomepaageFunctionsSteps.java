package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.TradeJournalHomePage;
import pages.TradeJournalLoginPage;
import utilities.BrowserUtils;
import utilities.Driver;
import utilities.PropertiesReader;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class TradeJournalHomepaageFunctionsSteps {
    TradeJournalLoginPage lp = new TradeJournalLoginPage();
    TradeJournalHomePage hp = new TradeJournalHomePage();
    BrowserUtils utils = new BrowserUtils();


    @Given("User is on home page of trade Journal app")
    public void user_is_on_home_page_of_trade_journal_app() {
        Driver.getDriver().get("http://ec2-3-145-116-184.us-east-2.compute.amazonaws.com:8080/login");
        lp.userNameBox.sendKeys(PropertiesReader.getProperty("username"));
        lp.passwordBox.sendKeys(PropertiesReader.getProperty("password"));
        lp.signInBtn.click();
    }
    @When("User clicks on Finom Group tab")
    public void user_clicks_on_finom_group_tab() {
        hp.finomGroup.click();
    }
    @Then("User Should be Directed to new Page with  the URL {string}")
    public void user_should_be_directed_to_new_page_with_the_url(String expectedURL) {
        String parentWindow = Driver.getDriver().getWindowHandle();
        Set<String> windows = Driver.getDriver().getWindowHandles();
        for(String window: windows){
            if (!parentWindow.equals(window)){
                Driver.getDriver().switchTo().window(window);
            }
        }
        String actualURL = Driver.getDriver().getCurrentUrl();

        System.out.println(actualURL);
        System.out.println(expectedURL);

        Assert.assertEquals(actualURL, expectedURL);
    }
    @Then("The page title is {string}")
    public void the_page_title_is(String expectedPageTitle) {
        String actualPageTitle = Driver.getDriver().getTitle().trim();
        Assert.assertEquals(actualPageTitle, expectedPageTitle);
    }

    @When("User clicks on Slack Channel tab and user is  logged in to Slack")
    public void user_clicks_on_slack_channel_tab_and_user_is_logged_in_to_slack() {
        hp.slackChannel.click();
    }
    @Then("User should be directed to {string}")
    public void user_should_be_directed_to(String expectedPageTitle) {
       String parantWindow = Driver.getDriver().getWindowHandle();
       Set<String> windows = Driver.getDriver().getWindowHandles();
       for (String window : windows){
           if (!parantWindow.equals(window)){
               Driver.getDriver().switchTo().window(window);
           }
       }

       String actualPageTitle = hp.batch1SlackChannel.getText().trim();

       Assert.assertEquals(actualPageTitle, expectedPageTitle);

    }


}

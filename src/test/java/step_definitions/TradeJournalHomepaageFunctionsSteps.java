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

import java.awt.*;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class TradeJournalHomepaageFunctionsSteps {
    TradeJournalLoginPage lp = new TradeJournalLoginPage();
    TradeJournalHomePage hp = new TradeJournalHomePage();
    BrowserUtils utils = new BrowserUtils();

            // finum group funcinality # STARTS
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
    // finum group funcinality # ENDS



    // slack channel functionality #STARTS
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
    // slack channel functionality #ENDS


     // test tools dropdown  #STARTS
    @When("User clicks on the dropdown titled {string}")
    public void user_clicks_on_the_dropdown_titled(String toolsText) {
        hp.toolsDropDown.click();
        Assert.assertEquals(hp.toolsDropDown.getText(), toolsText);
    }
    @Then("User should see the following {string} {string} {string}")
    public void user_should_see_the_following(String opt1, String opt2, String opt3) {
        Assert.assertEquals(hp.toolsDropDownOptions.get(0).getText().trim(), opt1);
        Assert.assertEquals(hp.toolsDropDownOptions.get(1).getText().trim(), opt2);
        Assert.assertEquals(hp.toolsDropDownOptions.get(2).getText().trim(), opt3);


    }

    @When("user clicks on {string} option")
    public void user_clicks_on_option(String optionCalculator) {
        System.out.println(hp.toolsDropDownOptions.get(2).getText());
        hp.toolsDropDownOptions.get(0).click();

    }
    @Then("User should be directed to a new page with the URL {string}")
    public void user_should_be_directed_to_a_new_page_with_the_url(String expOpiCalURL) {
        String parntWindow = Driver.getDriver().getWindowHandle();
        Set <String> windows = Driver.getDriver().getWindowHandles();
        for (String window:windows){
            if (!parntWindow.equals(window)){
                Driver.getDriver().switchTo().window(window);
            }
        }
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), expOpiCalURL);

    }
    @Then("Page title for the page should be {string}")
    public void page_title_for_the_page_should_be(String opti_Cal_Title) {
     String actualPageTitle  = hp.optionCalPageHeader.getText().trim();
        Assert.assertEquals(actualPageTitle, opti_Cal_Title);
    }
    @When("User clicks on the {string} option")
    public void user_clicks_on_the_option(String to_mar_inf) {
        String childWidow = Driver.getDriver().getWindowHandle();
        Set <String> windows = Driver.getDriver().getWindowHandles();
        for (String window:windows){
            if (!childWidow.equals(window)){
                Driver.getDriver().switchTo().window(window);
            }
        }
        hp.toolsDropDown.click();
        hp.toolsDropDownOptions.get(1).click();
    }
    @Then("User should be directed to new page {string}")
    public void user_should_be_directed_to_new_page(String tod_mark_url) {
        String parntWindow = Driver.getDriver().getWindowHandle();
        Set <String> windows = Driver.getDriver().getWindowHandles();
        for (String window:windows){
            if (!parntWindow.equals(window)){
                Driver.getDriver().switchTo().window(window);
            }
        }
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), tod_mark_url);

    }
    @Then("Page TITLE  should be {string}")
    public void page_title_should_be(String exp_todayMarketTitle) {
        String actualTitle = Driver.getDriver().getTitle().trim().substring(0, 6).toLowerCase();
        Assert.assertEquals(actualTitle, exp_todayMarketTitle);
    }
    @When("User clicks on {string}")
    public void user_clicks_on(String priceConvertor) {
        hp.toolsDropDownOptions.get(2).click();
    }
    @Then("User should be directed to new page titled {string}")
    public void user_should_be_directed_to_new_page_titled(String priceConvertorTitle) {

        String parntWindow = Driver.getDriver().getWindowHandle();
        Set <String> windows = Driver.getDriver().getWindowHandles();
        for (String window:windows) {
            if (!parntWindow.equals(window)) {
                Driver.getDriver().switchTo().window(window);
            }
        }
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle, priceConvertorTitle);

    }
    // test tools dropdown  #ENDS








}

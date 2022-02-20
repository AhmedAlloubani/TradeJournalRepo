package step_definitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pages.SaveTradePage;
import pages.TradeJournalHomePage;
import pages.TradeJournalLoginPage;
import utilities.BrowserUtils;
import utilities.Driver;
import utilities.PropertiesReader;

import java.util.ArrayList;
import java.util.List;

public class AddTradeSteps {

    TradeJournalLoginPage lp = new TradeJournalLoginPage();
    TradeJournalHomePage hp = new TradeJournalHomePage();
    BrowserUtils util = new BrowserUtils();
    SaveTradePage savePage = new SaveTradePage();
    String symbol;
    List<String> tableDta;
    List<String> recordItem;


    @Given("I am on the Trade Journal Login page")
    public void i_am_on_the_trade_journal_login_page() {
        Driver.getDriver().get(PropertiesReader.getProperty("TradeAppUrl"));
        Assert.assertTrue(lp.passwordBox.isDisplayed());
    }

    @Given("User is logged in")
    public void user_is_logged_in() {
        lp.userNameBox.sendKeys(PropertiesReader.getProperty("username"));
        lp.passwordBox.sendKeys(PropertiesReader.getProperty("password"));
        lp.signInBtn.click();
    }

    @When("User clicks add trade button")
    public void user_clicks_add_trade_button() {
        Assert.assertTrue(hp.addTradeBtn.isDisplayed());
        hp.addTradeBtn.click();
    }

    @Then("User should be directed to URL {string}")
    public void user_should_be_directed_to_url(String expectedUrl) {
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);
    }

    @When("user enters the following into the fields")
    public void user_enters_the_following_into_the_fields(DataTable dataTable) {
        Assert.assertTrue(savePage.SavePageTitle.isDisplayed());
        tableDta = dataTable.asList();
        symbol = tableDta.get(1);
        String buyOrSell = tableDta.get(0);
        util.selectByVisibleText(savePage.buyOrSellOptions, buyOrSell);
        savePage.symbolField.sendKeys(symbol);
        savePage.openDateField.sendKeys(tableDta.get(2));
        savePage.entryPriceField.sendKeys(tableDta.get(3));
        savePage.closeDateField.sendKeys(tableDta.get(4));
        savePage.exitPriceField.sendKeys(tableDta.get(5));


    }

    @When("User clicks on save button")
    public void user_clicks_on_save_button() {
        savePage.saveBtn.click();
    }

    @Then("New Trade should be added to the Trade table")
    public void new_trade_should_be_added_to_the_trade_table() {
        Assert.assertTrue(hp.addTradeBtn.isDisplayed());
        hp.symbolBox.sendKeys(symbol);
        hp.searchBtn.click();
        recordItem = new ArrayList<>();
        for (WebElement elm : hp.tradRecord) {
            recordItem.add(elm.getText());

        }
        recordItem.remove(recordItem.get(7));
        recordItem.remove(recordItem.get(6));
        String openDate = "02-12-2020";
        String closeDate = "02-02-2021";
        recordItem.set(2, openDate);
        recordItem.set(4, closeDate);
        String entryPrice = recordItem.get(3).replace('$', ' ').trim();
        String exitPrice = recordItem.get(5).replace('$', ' ').trim();
        recordItem.set(3, entryPrice);
        recordItem.set(5, exitPrice);
        System.out.println(tableDta);
        System.out.println(recordItem);

        Assert.assertTrue(recordItem.equals(tableDta));
    }

    @Then("Trade should be deleted")
    public void trade_should_be_deleted() {

        hp.symbolBox.sendKeys(symbol);

        hp.searchBtn.click();
        Assert.assertTrue(hp.tradRecord.get(0).isDisplayed());
        Assert.assertEquals(hp.tradRecord.get(1).getText().trim(), symbol);
        hp.deleteBtn.get(0).click();
        util.alertAccept();
        hp.symbolBox.sendKeys(symbol);
        hp.searchBtn.click();
        System.out.println(hp.tableRecords.size());
        Assert.assertTrue(hp.tableRecords.size()==0);

    }
}

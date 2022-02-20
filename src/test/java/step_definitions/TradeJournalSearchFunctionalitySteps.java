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

public class TradeJournalSearchFunctionalitySteps {

    BrowserUtils util = new BrowserUtils();
    TradeJournalHomePage hp = new TradeJournalHomePage();
    TradeJournalLoginPage lp = new TradeJournalLoginPage();
    String symbolValue;
    String dateValue;
    String actualDateValue;



    // test Search on symbol value #STAARTS
    @Given("User is logged in and on the homepage of Trade Journal app")
    public void user_is_logged_in_and_on_the_homepage_of_trade_journal_app() {
        Driver.getDriver().get(PropertiesReader.getProperty("TradeAppUrl"));
        Assert.assertTrue(lp.signInBtn.isDisplayed());
        lp.userNameBox.sendKeys(PropertiesReader.getProperty("username"));
        lp.passwordBox.sendKeys(PropertiesReader.getProperty("password"));
        lp.signInBtn.click();
        Assert.assertTrue(hp.addTradeBtn.isDisplayed());
    }

    @When("User enters a value for symbol {string} text box")
    public void user_enters_a_value_for_symbol_text_box(String value) {
        symbolValue = value;
        hp.symbolBox.sendKeys(value);

    }

    @Then("System should display the entered value in the symbol text box")
    public void system_should_display_the_entered_value_in_the_symbol_text_box() {
        String actualValue = hp.symbolBox.getAttribute("value");
        System.out.println("the value is   " + actualValue);

        Assert.assertEquals(actualValue, symbolValue);

    }

    @Then("User clicks on search button")
    public void user_clicks_on_search_button() {
        hp.searchBtn.click();
    }

    @Then("System should filter and display the records associated with the symbol")
    public void system_should_filter_and_display_the_records_associated_with_the_symbol() {
        Assert.assertEquals(hp.tradRecord.get(1).getText().trim(), symbolValue);
    }
    // test Search on symbol value #ENDS






    // test search on date values #STARTS
    @When("User enters a value for date {string} text box")
    public void user_enters_a_value_for_date_text_box(String value) {
        dateValue = value;
        hp.dateBox.sendKeys(dateValue);
    }

    @Then("System should display the entered value in the date text box")
    public void system_should_display_the_entered_value_in_the_date_text_box() {
        String [] array = hp.dateBox.getAttribute("value").split("-");
        System.out.println("the value is "+actualDateValue);
         actualDateValue = array[1]+"-"+array[2]+"-"+array[0];

      Assert.assertEquals(actualDateValue, dateValue);
    }

    @Then("System should filter and display the records associated with the date")
    public void system_should_filter_and_display_the_records_associated_with_the_date() {
        String[] array = hp.tradRecord.get(2).getText().split("-");
        String actualdateValue = array[1]+"-"+array[2]+"-"+array[0];
        Assert.assertEquals(actualdateValue, dateValue);
    }
    // test search on date values #ENGS







    // test search on symbol and date #STARTS
    @Then("System should filter and display the records associated with the symbol and the date")
    public void system_should_filter_and_display_the_records_associated_with_the_symbol_and_the_date() {
        String actualSymbol = hp.tradRecord.get(1).getText().trim();
        String[] date = hp.tradRecord.get(2).getText().split("-");
        String actualDate = date[1]+"-"+date[2]+"-"+date[0];
        Assert.assertEquals(actualSymbol, symbolValue);
        Assert.assertEquals(actualDate, dateValue);
    }
    // test search on symbol and date #ENDS





    // test search on symbol non-matching #STARTS
    @Then("System should not filter and display the records associated with the symbol")
    public void system_should_not_filter_and_display_the_records_associated_with_the_symbol() {
       Assert.assertTrue(hp.tableRecords.size()==0);
    }
    // test search on symbol non-matching #ENDS






    // test search on date non-matching #STARTS
    @Then("System should not filter and display the records associated with the date")
    public void system_should_not_filter_and_display_the_records_associated_with_the_date() {
        Assert.assertTrue(hp.tableRecords.size()==0);
    }
    // test search on date non-matching #ENDS







    // test search on symbol and date non-matching #STARTS
    @Then("System should not filter and display the records associated with the symbol and the date")
    public void system_should_not_filter_and_display_the_records_associated_with_the_symbol_and_the_date() {
        Assert.assertTrue(hp.tableRecords.size()==0);
    }
    // test search on symbol and date non-matching #ENDS






}

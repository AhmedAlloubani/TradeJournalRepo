package step_definitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import pages.SaveTradePage;
import pages.TradeJournalHomePage;
import pages.TradeJournalLoginPage;
import utilities.BrowserUtils;
import utilities.DButils;
import utilities.Driver;
import utilities.PropertiesReader;

import java.util.List;

public class TradeJournalUpdateFunctionalitySteps {

    TradeJournalLoginPage lp = new TradeJournalLoginPage();
    TradeJournalHomePage hp = new TradeJournalHomePage();
    SaveTradePage st = new SaveTradePage();
    BrowserUtils util = new BrowserUtils();
    DButils dataBaseUtil = new DButils();
    String symbol;
    List<String> values;

     // test update functionality valid #Starts
    @Given("User is logged in and on the home page of the Trade Journal app")
    public void user_is_logged_in_and_on_the_home_page_of_the_trade_journal_app() throws InterruptedException {
        Driver.getDriver().get(PropertiesReader.getProperty("TradeAppUrl"));
        Assert.assertTrue(lp.signInBtn.isDisplayed());
        lp.userNameBox.sendKeys(PropertiesReader.getProperty("username"));
        lp.passwordBox.sendKeys(PropertiesReader.getProperty("password"));
        lp.signInBtn.click();
        Assert.assertTrue(hp.homePageTitle.isDisplayed());


    }

    @When("User clicks on Update button for a particular row in the table {string}")
    public void user_clicks_on_update_button_for_a_particular_row_in_the_table(String symbol) throws InterruptedException {
        this.symbol = symbol;

        switch (symbol) {
            case "Delta":
                hp.deltaRecord.click();
                break;
            case "Virginia":
                hp.virginiaRecord.click();
                break;
            case "Maryland":
                hp.marylandRecord.click();
                break;

        }

    }

    @Then("User should be directed to Save Trade page with page heading {string}")
    public void user_should_be_directed_to_save_trade_page_with_page_heading(String pageHeading) {
        String actualPageHeading = st.SavePageTitle.getText().trim();
        Assert.assertEquals(actualPageHeading, pageHeading);
    }

    @When("User updates the values of the record with the following data")
    public void user_updates_the_values_of_the_record_with_the_following_data(DataTable dataTable) throws InterruptedException {
        values = dataTable.asList();

        util.selectByVisibleText(st.buyOrSellOptions, values.get(0));

        st.entryPriceField.clear();
        st.entryPriceField.sendKeys(values.get(1));

        st.exitPriceField.clear();
        st.exitPriceField.sendKeys(values.get(2));
    }

    @When("User clicks on the save button")
    public void user_clicks_on_the_save_button() throws InterruptedException {

        st.saveBtn.click();

    }

    @Then("Record should be updated and saved with the new given values")
    public void record_should_be_updated_and_saved_with_the_new_given_values()  {
        hp.symbolBox.sendKeys(symbol);

        hp.searchBtn.click();

        for (WebElement elm : hp.tradRecord) {
            if (elm.getText().equals(values.get(0))) {
                Assert.assertTrue(elm.getText().equals(values.get(0)));
            }
            if (elm.getText().equals(symbol)) {
                Assert.assertTrue(elm.getText().equals(symbol));
            }
            if (elm.getText().substring(1).equals(values.get(1))) {
                Assert.assertTrue(elm.getText().substring(1).equals(values.get(1)));
            }
            if (elm.getText().substring(1).equals(values.get(2))) {
                Assert.assertTrue(elm.getText().substring(1).equals(values.get(2)));
            }

        }


    }

    @Then("Database is updated with the new updated values")
    public void database_is_updated_with_the_new_updated_values() {

        List<String> dbRecord1 = dataBaseUtil.selectARecord("SELECT * FROM records WHERE id='46135';");
        String dbEntryPrice = dbRecord1.get(5);
        String dbExitPrice = dbRecord1.get(7);
        int DBsellOrBuy = Integer.parseInt(dbRecord1.get(2));

        switch (DBsellOrBuy) {
            case 0:
                Assert.assertTrue(true);
                break;
            case 1:
                Assert.assertFalse(false);
                break;
        }
        Assert.assertEquals(dbEntryPrice, values.get(1) + ".0");
        Assert.assertEquals(dbExitPrice, values.get(2) + ".0");


        List<String> dbRecord2 = dataBaseUtil.selectARecord("SELECT * FROM records WHERE id='46134';");
        String dbEntryPrice2 = dbRecord1.get(5);
        String dbExitPrice2 = dbRecord1.get(7);
        int DBsellOrBuy2 = Integer.parseInt(dbRecord1.get(2));
        switch (DBsellOrBuy2) {
            case 0:
                Assert.assertTrue(true);
                break;
            case 1:
                Assert.assertFalse(false);
                break;
        }
        Assert.assertEquals(dbEntryPrice2, values.get(1) + ".0");
        Assert.assertEquals(dbExitPrice2, values.get(2) + ".0");

        List<String> dbRecord3 = dataBaseUtil.selectARecord("SELECT * FROM records WHERE id='46130';");
        System.out.println(dbRecord3);
        String dbEntryPrice3 = dbRecord1.get(5);
        String dbExitPrice3 = dbRecord1.get(7);
        int DBsellOrBuy3 = Integer.parseInt(dbRecord1.get(2));
        switch (DBsellOrBuy3) {
            case 0:
                Assert.assertTrue(true);
                break;
            case 1:
                Assert.assertFalse(false);
                break;
        }
        Assert.assertEquals(dbEntryPrice3, values.get(1) + ".0");
        Assert.assertEquals(dbExitPrice3, values.get(2) + ".0");

    }
    // test update functionality valid #Ends









    // test update invalid functionality #Starts
    @When("User clicks on update for a particular record")
    public void user_clicks_on_update_for_a_particular_record() {
        Assert.assertTrue(hp.virginiaRecord.isDisplayed());
        hp.virginiaRecord.click();
    }
    @When("User updates symbol text box with an empty field")
    public void user_updates_symbol_text_box_with_an_empty_field() {
        st.symbolField.clear();

    }
    @Then("The system should display message {string}")
    public void the_system_should_display_message(String expectedErrorMessage) {
        JavascriptExecutor jsE = (JavascriptExecutor)Driver.getDriver();
        System.out.println(hp.symbolError.getAttribute("innerHTML"));
        System.out.println("somthing");

    }
    @Then("Record should not be updated in the data base and the table view")
    public void record_should_not_be_updated_in_the_data_base_and_the_table_view() {

    }
    // test update ib=nvalid functionality #Ends
}

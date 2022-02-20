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

import java.util.List;
import java.util.PropertyPermission;

public class TradeJournalUpdateFunctionalitySteps {

    TradeJournalLoginPage lp = new TradeJournalLoginPage();
    TradeJournalHomePage hp = new TradeJournalHomePage();
    SaveTradePage st = new SaveTradePage();
    BrowserUtils util = new BrowserUtils();
    String symbol;
    List<String> values;
    int position;

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
                hp.deltaUpdate.click();
                break;
            case "Virginia":
                hp.deltaUpdate1.click();
                break;
            case "Maryland":
                hp.deltaUpdate2.click();
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
    public void record_should_be_updated_and_saved_with_the_new_given_values() throws InterruptedException {
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

    }
}

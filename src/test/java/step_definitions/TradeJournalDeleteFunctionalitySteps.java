package step_definitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.SaveTradePage;
import pages.TradeJournalHomePage;
import pages.TradeJournalLoginPage;
import utilities.BrowserUtils;
import utilities.DButils;
import utilities.Driver;
import utilities.PropertiesReader;

import java.util.List;

public class TradeJournalDeleteFunctionalitySteps {

    TradeJournalLoginPage lp = new TradeJournalLoginPage();
    TradeJournalHomePage hp = new TradeJournalHomePage();
    BrowserUtils util = new BrowserUtils();
    SaveTradePage st = new SaveTradePage();
    DButils dbUtil = new DButils();


  // test delete record #Starts
    @Given("User is logged in to Trade journal app and on the home page")
    public void user_is_logged_in_to_trade_journal_app_and_on_the_home_page() {
        Driver.getDriver().get(PropertiesReader.getProperty("TradeAppUrl"));
        Assert.assertTrue(lp.signInBtn.isDisplayed());
        lp.userNameBox.sendKeys(PropertiesReader.getProperty("username"));
        lp.passwordBox.sendKeys(PropertiesReader.getProperty("password"));
        lp.signInBtn.click();
    }
    @When("User clicks on delete button for a particular record")
    public void user_clicks_on_delete_button_for_a_particular_record() {
        Assert.assertTrue(hp.homePageTitle.isDisplayed());
        hp.ohioRecord.click();
        util.switchToAlert();
    }

    @Then("system should display message {string}")
    public void system_should_display_message(String expectedAlertMessage) {
        String actualAlertMessage = util.alertGetText().trim();
        Assert.assertEquals(actualAlertMessage, expectedAlertMessage);
    }

    @When("User clicks cancel")
    public void user_clicks_cancel() {
        util.alertDismiss();
    }
    @Then("The modal should close without deleting the record from the datbase and table view")
    public void the_modal_should_close_without_deleting_the_record_from_the_datbase_and_table_view() {
        Assert.assertTrue(hp.ohioRecord.isDisplayed());

    }
    @When("User clicks Ok")
    public void user_clicks_ok() {
        hp.ohioRecord.click();
       util.alertAccept();
    }
    @Then("The modal should close and the record should be deleted from database and the table view")
    public void the_modal_should_close_and_the_record_should_be_deleted_from_database_and_the_table_view() {
        hp.symbolBox.sendKeys("Ohio");
        hp.searchBtn.click();
        Assert.assertTrue(hp.tableRecords.size()==0);

      List<String> dbRecord =  dbUtil.selectARecord("select * from records where symbol='Ohio'");
      Assert.assertTrue(dbRecord.size()==0);
    }

    @Then("New record with the following values is added")
    public void new_record_with_the_following_values_is_added(DataTable dataTable) {
        hp.addTradeBtn.click();
        List<String> featureData = dataTable.transpose().asList();
        util.selectByVisibleText(st.buyOrSellOptions, featureData.get(0));
        st.symbolField.sendKeys(featureData.get(1));
        st.openDateField.sendKeys(featureData.get(2));
        st.entryPriceField.sendKeys(featureData.get(3));
        st.closeDateField.sendKeys(featureData.get(4));
        st.exitPriceField.sendKeys(featureData.get(5));
        st.saveBtn.click();
        Assert.assertTrue(hp.ohioRecord.isDisplayed());
    }
    // test delete record #Starts
}

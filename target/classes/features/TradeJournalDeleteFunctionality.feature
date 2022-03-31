Feature: Delete Trade Functionality
        User should be able to delete records

  @ValidateDeleteFunctionality @SmokeTest
  Scenario: User should be able to delete particular trade record
    Given User is logged in to Trade journal app and on the home page
    When User clicks on delete button for a particular record
    Then  system should display message "Are you sure you want to delete this record?"
    When User clicks cancel
    Then The modal should close without deleting the record from the datbase and table view
    When User clicks Ok
    Then The modal should close and the record should be deleted from database and the table view
    And New record with the following values is added
    |Buy to Open|Ohio|03-03-2020|40.0|06-07-2021|60.0|





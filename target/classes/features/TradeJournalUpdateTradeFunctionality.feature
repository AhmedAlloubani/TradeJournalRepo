Feature: Update Trade Functionality
  User is able to update trades valid
  user is not able to update trades invalid

  @UpdateTradeFunctionalityValid
  Scenario Outline: User is able to update a valid trade in the Trade Journal app
    Given User is logged in and on the home page of the Trade Journal app
    When User clicks on Update button for a particular row in the table "<Symbol>"
    Then User should be directed to Save Trade page with page heading "Save Trade"
    When User updates the values of the record with the following data
      | Sell to Open | 60 | 70 |
    When User clicks on the save button
    Then Record should be updated and saved with the new given values
    And Database is updated with the new updated values
    Examples:
      | Symbol |
      | Delta  |
      | Virginia |
      | Maryland |

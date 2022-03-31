Feature: Trade Journal Application Add Functionality
       User should be able to add trades


    @AddTrade   @SmokeTest
  Scenario: As a user of Trade Journal app I should be able to add a trade
    Given I am on the Trade Journal Login page
    And User is logged in
    When User clicks add trade button
    Then User should be directed to URL "http://ec2-3-145-116-184.us-east-2.compute.amazonaws.com:8080/records/showFormForAdd"
    When user enters the following into the fields
    |Buy to Open|Fabinio|02-12-2020|50.0|02-02-2021|60.0|
    And User clicks on save button
    Then New Trade should be added to the Trade table
      And Trade should be deleted
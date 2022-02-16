Feature: As a User for Trade Journal app I should be able to use
  Finom Group, Slack Channel functionalities


  @FinomGrooupFunctionality @SmokeTest
  Scenario: As a user I should be able to click Finom Group tab and be directd to new page
    Given User is on home page of trade Journal app
    When User clicks on Finom Group tab
    Then User Should be Directed to new Page with  the URL "https://www.finomgroup.com/"
    And The page title is "Home - Finom Group"



@SlackChannelFunctionality  @SmokeTest
 Scenario: As a user for Trade Journal app I should be able to click Slack Channel tab and be directed to new page
  Given User is on home page of trade Journal app
   When User clicks on Slack Channel tab and user is  logged in to Slack
   Then User should be directed to "PrimeTech_SDET_Batch1"

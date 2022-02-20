@ToolsTabFunctionality   @Regression
Feature: As a User for Trade Journal app I should be able to use
  Finom Group, Slack Channel functionalities and the tools tab functionality


  @FinomGrooupFunctionality @SmokeTest @Regression
  Scenario: As a user I should be able to click Finom Group tab and be directd to new page
    Given User is on home page of trade Journal app
    When User clicks on Finom Group tab
    Then User Should be Directed to new Page with  the URL "https://www.finomgroup.com/"
    And The page title is "Home - Finom Group"



@SlackChannelFunctionality  @SmokeTest @Regression
 Scenario: As a user for Trade Journal app I should be able to click Slack Channel tab and be directed to new page
  Given User is on home page of trade Journal app
   When User clicks on Slack Channel tab and user is  logged in to Slack
   Then User should be directed to "PrimeTech_SDET_Batch1"

@ToolsDropdownFunctionalities    @SmokeTest @Regression
Scenario: As a user i should be able to navigate the tools tab functionality
  Given User is on home page of trade Journal app
  When User clicks on the dropdown titled "Tools"
  Then User should see the following "Options Calculator" "Today's Market Info" "Vol ETF/ETN Price Converter"
  When user clicks on "Options Calculator" option
  Then User should be directed to a new page with the URL "https://www.optionseducation.org/toolsoptionquotes/optionscalculator"
  And Page title for the page should be "Options Calculator"
  When User clicks on the "Today's Market Info" option
  Then User should be directed to new page "https://finviz.com/"
    And Page TITLE  should be "finviz"
  When User clicks on "Vol ETF/ETN Price Converter"
  Then User should be directed to new page titled "Vol ETF/ETN Price Converter"



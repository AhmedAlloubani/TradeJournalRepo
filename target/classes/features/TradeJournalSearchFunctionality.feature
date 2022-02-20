Feature: Validate search Trade functionality
  as a user i should be able to search valid and invalid records

  @SearchFunctionalityValid @SmokeTest
  Scenario Outline: As a user i should be able to filter on symbol value
    Given User is logged in and on the homepage of Trade Journal app
    When User enters a value for symbol "<symbol>" text box
    Then System should display the entered value in the symbol text box
    And User clicks on search button
    Then System should filter and display the records associated with the symbol

    Examples:
      | symbol          |
      | United          |
      | AmericanExpress |
      | ChaseBank       |




  @SearchFunctionalityValid     @SmokeTest
  Scenario Outline: As a user i should be able to filter on date value
    Given User is logged in and on the homepage of Trade Journal app
    When User enters a value for date "<date>" text box
    Then System should display the entered value in the date text box
    And User clicks on search button
    Then System should filter and display the records associated with the date
    Examples:
      | date       |
      | 09-09-2020 |
      | 09-07-2020 |
      | 04-03-2022 |




  @SearchFunctionalityValid
  Scenario Outline: As a user I should be able to filter on symbol and date values
    Given User is logged in and on the homepage of Trade Journal app
    When User enters a value for symbol "<symbol>" text box
    Then System should display the entered value in the symbol text box
    When User enters a value for date "<date>" text box
    Then System should display the entered value in the date text box
    When User clicks on search button
    Then System should filter and display the records associated with the symbol and the date
    Examples:
      | symbol          | date       |
      | United          | 09-09-2020 |
      | AmericanExpress | 09-07-2020 |
      | ChaseBank       | 04-03-2022 |






  @SearchFunctionalityInValid   @SmokeTest
  Scenario Outline: As a user I should not be able to see non matching values when I filter on symbol
    Given User is logged in and on the homepage of Trade Journal app
    When User enters a value for symbol "<symbol>" text box
    Then System should display the entered value in the symbol text box
    When User clicks on search button
    Then System should not filter and display the records associated with the symbol
    Examples:
      | symbol    |
      | downJones |
      | nasDak    |
      | squidGame |





  @SearchFunctionalityInValid
  Scenario Outline: As a user I should not be able to see non matching values when I filter on date

    Given User is logged in and on the homepage of Trade Journal app
    When User enters a value for date "<date>" text box
    Then System should display the entered value in the date text box
    And User clicks on search button
    Then System should not filter and display the records associated with the date

    Examples:
      | date       |
      | 12-01-1990 |
      | 12-02-1980 |
      | 10-09-1970 |




  @SearchFunctionalityInValid      @SmokeTest
  Scenario Outline: As a user I should not be able to see non matching values when I filter on symbol and date
    Given User is logged in and on the homepage of Trade Journal app
    When User enters a value for symbol "<symbol>" text box
    Then System should display the entered value in the symbol text box
    When User enters a value for date "<date>" text box
    Then System should display the entered value in the date text box
    When User clicks on search button
    Then System should not filter and display the records associated with the symbol and the date
    Examples:
      | symbol    | date       |
      | downJones | 12-01-1990 |
      | nasDak    | 12-02-1980 |
      | squidGame | 10-09-1970 |



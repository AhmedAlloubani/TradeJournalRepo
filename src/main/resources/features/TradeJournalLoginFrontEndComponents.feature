Feature: Verify the Login Page front end components
  Validate Trade Journal login functionality valid and invalid

  @VerifyTradeJournalLoginComponents  @Regression
  Scenario: Front End Components are displayed for the Login Page
    Given I am a Trade Journal user
    When User navigate to Trade Journal Login Page
    Then User should be directed to the Trade Journal Login Page
    And System should display pageHeader "Please sign in" username "Username" password "Password" signIn "Sign in"




  @ValidTradeJournalLogin @SmokeTest @Regression
  Scenario: Login to Trade Journal App with valid credentials
    Given User navigated to the Trade Journal login Page
    When User enters valid Username and user enters valid Password
    And User clicks on Sign in button
    Then User should be directed to the Trade Journal App Home Page




  @InvalidTradeJournalLogin  @SmokeTest @Regression
  Scenario Outline: Login to trade Journal App with invalid credentials
    Given User navigated to the Trade Journal login Page
    When User enters invalid username "<Username>" and invalid password "<Password>"
    And User clicks on Sign in button
    Then User should not be directed to the Trade Journal Home Page
    And System should display message "Bad credentials"

    Examples:
      | Username     | Password       |
      | Ahmed        | Super          |
      | Ahmad123     | Super123       |
      | Ahmeed4      | SuperAhmed123! |
      | AhmedBoreeni | SuperAhmad     |

  @InvalidTradeJournalLogin  @SmokeTest @Regression
  Scenario Outline: Login to trade Journal App with valid Username and invalid Password
    Given User navigated to the Trade Journal login Page
    When User enters valid UserName "Username" and invalid password "<Password>"
    And User clicks on Sign in button
    Then User should not be directed to the Trade Journal Home Page
    And System should display message "Bad credentials"
    Examples:
      | Password |
      | Ahmed435 |
      | Samir45  |
      | Ralf123  |


  @InvalidTradeJournalLogin  @SmokeTest @Regression
  Scenario Outline: Login to trade Journal App with invalid Username and valid Password
    Given User navigated to the Trade Journal login Page
    When User enters invalid Username "<invalidUserName>" and user enters valid PassWord
    And User clicks on Sign in button
    Then User should not be directed to the Trade Journal Home Page
    And System should display message "Bad credentials"
    Examples:
      | invalidUserName |
      | Ahmaaad32 |
      | Rami54 |
      | John123 |



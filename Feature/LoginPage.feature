Feature: Verify login page elements and functionality

  Background: Verify User is on the login page
    Given User Open URL "https://igmsuat.irda.gov.in/LoginAdmin/Login"
    When User click on backToSafety button
    Then User is on the login page

#  @Positive
#  Scenario: Verify the Login page elements
#    Given User is on the login page
#    Then Buttons should be clickable
#    And Captcha present on the web page
#    When User click on the refresh icon of the captcha
#    Then New captcha displayed
#    When User enter valid userId "User"
#    And User enter valid password "admin1234"
#    And Click on clear button
#    Then All input field should clear
#
#  @Negative
#  Scenario: Verify login functionality with empty username and password
#    Given User is on the login page
#    When Click on login button
#    Then Error message displayed for empty username "Please Enter User Name"
#    And Error message displayed for empty password "Please Enter Password"
#
#  @Negative
#  Scenario: Verify login functionality with empty username and valid password
#    Given User is on the login page
#    When User enter valid password "Hdfc@1234"
#    And Click on login button
#    Then Error message displayed for empty username "Please Enter User Name"
#
#  @Negative
#  Scenario: Verify login functionality with valid username and empty password
#    Given User is on the login page
#    When User enter valid userId "HDFCGADMIN"
#    And Click on login button
#    Then Error message displayed for empty password "Please Enter Password"
#
#  @Negative
#  Scenario: Verify login functionality with invalid username and valid password
#    Given User is on the login page
#    When User enter invalid userID
#    And User enter valid password "Hdfc@1234"
#    And User enter valid Captcha
#    And Click on login button
#    Then Alert pop up displayed with error message "Invalid Credential"

  @Positive@Smoke
  Scenario Outline: Verify user able to login successful
    Given User is on the login page
    When User enter valid userId "<UserID>"
    And User enter valid password "<Password>"
    And User enter valid Captcha
    And Click on login button
    Then User successfully logged in

    Examples:
      | UserID     | Password   |
      | SILICADMIN | saharaa123 |






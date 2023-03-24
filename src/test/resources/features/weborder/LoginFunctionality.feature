Feature: Testing Login Functionality of WebOrder Page

  Scenario: Testing positive login(correct username + correct password)
    When User provides 'guest1@microworks.com' and 'Guest1!' for WebOrder
    Then User validates the 'ORDER DETAILS - Weborder' from homepage

  Scenario: Testing negative login(correct username + wrong password)
    When User provides 'guest1@microworks.com' and 'ahmet' for WebOrder
    Then User validates the 'Sign in Failed' error message


Feature: Testing Login Functionality for WebOrder

  Scenario Outline:first version
    When User provides '<username>' and '<password>' for WebOrder
    Then User validates the '<errorMessage>' error message

    Examples:
      | username              | password | errorMessage   |
      | guest1@microworks.com | 34534    | Sign in Failed |
      | ahmet@microworks.com  | Guest1!  | Sign in Failed |
      |                       |          | Sign in Failed |
  @smoke
  Scenario Outline:second version
    When User provides '<username>' and '<password>' for WebOrder
    Then User validates the 'Sign in Failed' error message

    Examples:
      | username              | password |
      | guest1@microworks.com | 34534    |
      | ahmet@microworks.com  | Guest1!  |
      |                       |          |
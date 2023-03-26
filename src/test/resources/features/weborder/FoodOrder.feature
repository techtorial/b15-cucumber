@regression
Feature: WebOrder Page Food Order Functionality

  Background: Food order same steps
    Given User provides 'guest1@microworks.com' and 'Guest1!' for WebOrder
    And User validates the 'ORDER DETAILS - Weborder' from homepage
    When User clicks Group Order Box and Next Button
    And User sends the word 'I love Cucumber' for note to the Invitees Section
    And User sends e-mail address which are 'ahmet@gmail.com' and 'mehmet@gmail.com' to the Invite List
  @smoke @ahmet @mehmet
  Scenario: Testing the happy path food order for My House
    And User chooses the delivery address 'My House' and validates the address '3137 Laguna'
    And User clicks the create Group Order Button
    Then User validates the header of page 'View Group Order'
    And User validates the word 'Your group order is now pending' from description

@smoke @mahmut @ayse
  Scenario: Testing the happy path food order for Office
    And User chooses the delivery address 'Office' and validates the address '2012 EMPIRE BLVD'
    And User clicks the create Group Order Button
    Then User validates the header of page 'View Group Order'





@regression
Feature: Testing the Search Functionality of Etsy

  Scenario: Validation Title of Etsy Hat
    When User searches for 'Hat' for Etsy WebPage
    Then User validates the title 'Hat - Etsy' from Etsy

  Scenario: Validation Title of Etsy Key
    When User searches for 'Key' for Etsy WebPage
    Then User validates the title 'Key - Etsy' from Etsy

  Scenario: Validation Title of Etsy Pin
    When User searches for 'Pin' for Etsy WebPage
    Then User validates the title 'Pin - Etsy' from Etsy


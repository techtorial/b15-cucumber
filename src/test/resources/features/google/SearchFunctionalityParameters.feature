Feature: Testing Google Search Functionality

  Background: navigation to the website
    Given User navigates to the 'https://www.google.com/'

  Scenario: Happy Path(positive) Testing Search
  #  Given User navigates to the 'https://www.google.com/'
    When User searches for 'Codefish'
    Then User gets more than 10 links from first page

    Scenario: Happy Path(positive) Result Search
   #   Given User navigates to the 'https://www.google.com/'
      When User searches for 'Kyrgyz Food in USA'
      Then User validates the result is more than 1000000


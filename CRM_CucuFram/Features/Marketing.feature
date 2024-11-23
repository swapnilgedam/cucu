Feature: Marketing

  Scenario: Create New Campaign
    Given User launch Chrome browser
    When User opens URL "http://eximsoftwares.com/Projects/CRM/index.php/site/login"
    And User enters Username as "admin" and Password "pass"
    And Click on Login
    Then User can view Home page
    When User click on Marketing menu
    And click on create campaign
    Then User can view create campaign page
    When user enters campaign info
    And click on create button for save campaign
    Then User can view campaign added in all camapign
    And close browser

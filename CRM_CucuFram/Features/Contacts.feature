Feature: Contacts

  Scenario: Create New Contact
  Given User launch Chrome browser
    When User opens URL "http://eximsoftwares.com/Projects/CRM/index.php/site/login"
    And User enters Username as "admin" and Password "pass"
    And Click on Login
    Then User can view Home page
    When User click on contacts menu
    And click on create contact
    Then User can view create contact page
    When user enters contact info
    And click on create button
    Then User can view contact added in all contacts
    And close browser

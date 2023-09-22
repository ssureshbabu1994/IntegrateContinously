@driverAppScreens
@driverAppDateFlow
Feature: Date flow of DriverApp
      
      @dateStartFlow
  Scenario Outline: Date Start flow validations
    Given I launch the application in "<OSVersion>" for "<Functionality>"
    Then I click on driver app to access location
    And I click on driver app to access media
    Then I enter username and password
    And I click login button
    And I verify operator text in "<OSVersion>"
    Then I click on operator
    And I click on route with multiple schedules in "<OSVersion>"
    Then validate if Date page is displayed for "<OSVersion>"
    And validate if selected route with multiple schedules is displayed in Date screen
    And validate if "Start" and "View" buttons are displayed
    And validate if dates are displayed in ascending order
    When I click on enabled "Start" button
    And validate if "Scheduled Asset" screen is displayed
    Then validate if "any" action can be performed in scheduled asset screen for "<OSVersion>" version
    And Update execution status for "<Functionality>" functionality

    Examples: 
      | OSVersion | Functionality            |
      | android   | StartDateFlowFunctionality |
      
      @dateViewFlow
  Scenario Outline: Date View flow validations
    Given I launch the application in "<OSVersion>" for "<Functionality>"
    Then I click on driver app to access location
    And I click on driver app to access media
    Then I enter username and password
    And I click login button
    And I verify operator text in "<OSVersion>"
    Then I click on operator
   And I click on route with multiple schedules in "<OSVersion>"
    Then validate if Date page is displayed for "<OSVersion>"
    And validate if selected route with multiple schedules is displayed in Date screen
    And validate if "Start" and "View" buttons are displayed
    And validate if dates are displayed in ascending order
    When I click on enabled "View" button
    Then validate if "no" action can be performed in scheduled asset screen for "<OSVersion>" version
    And I navigate back to Date screen from Scheduled Asset screen
    Then I click logout
    And Update execution status for "<Functionality>" functionality

    Examples: 
      | OSVersion | Functionality            |
      | android   | ViewDateFlowFunctionality |
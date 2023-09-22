@driverAppScreens
@driverAppOperatorFlow
Feature: Opertor flow of DriverApp
      
  #@operatorFlow
  #Scenario Outline: Operator flow
    #Given I launch the application in "<OSVersion>" for "<Functionality>"
    #Then I enter "<username>" and "<password>"
    #And I click login button
    #And I verify operator text in "<OSVersion>"
    #Then I click on "<Operator>" operator
    #And I click on "<Route>" route in "<OSVersion>"
    #Then I click logout
    #And Update execution status for "<Functionality>" functionality
#
    #Examples: 
      #| OSVersion | username | password | Operator |  Route | Functionality            |
      #| iOS       | skaushik@cantaloupe.com      | Saurabh@123   | OperatorFlowFunctionality |
      #| android   | skaushik@cantaloupe.com      | Saurabh@123  | Accent - Main HQ (TX) | 101 | OperatorPageFunctionality |
      
      
      @operatorPage
  Scenario Outline: Operator page elements validation
    Given I launch the application in "<OSVersion>" for "<Functionality>"
    Then I click on driver app to access location
    And I click on driver app to access media
    Then I enter username and password
    And I click login button
    And I verify operator text in "<OSVersion>"
    And I validate if logout button along with username is displayed
    Then I extract list of operators
    When I enter invalid operator in operator search field
    Then I validate if invalid operator name eror message is displayed
    And I clear operator field
    And I validate if operators are displayed in alphabetical order
    When I enter valid operator in operator search field
    Then validate if list is narrowed down with operator entered
    And validate if operator field is cleared on clicking close
    Then I click on operator
    And validate if route page is displayed in "<OSVersion>"
    Then I click logout
    And Update execution status for "<Functionality>" functionality

    Examples: 
      | OSVersion | Functionality |
      | android   | OperatorPageFunctionality |
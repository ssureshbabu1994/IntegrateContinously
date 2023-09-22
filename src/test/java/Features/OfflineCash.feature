@driverAppScreens
@driverAppCashFlow
Feature: Cash flow of DriverApp
      
      @offlineCashFlow
  Scenario Outline: Cash flow validations
    Given I launch the application in "<OSVersion>" for "<Functionality>"
    Then I click on driver app to access location
    And I click on driver app to access media
    And I disable wifi and data
    Then I enter username and password
    And I click login button
    And I verify operator text in "<OSVersion>"
    Then I click on operator
    And I click on route in "<OSVersion>"
    Then validate if Date page is displayed for "<OSVersion>"
    When I click on enabled "Start" button
    And I extract asset ID type and place from Scheduled asset screen for "<OSVersion>"
    And I click on asset in scheduled asset screen for "<OSVersion>"
    When I click on "Cash" icon for "<OSVersion>"
    Then validate if route place and type is displayed in Cash screen
    And validate if cash headers are displayed
    And validate watermark displayed for  all feilds in cash screen
    Then validate the character limits of all fields
    And I click on "Bag" field
    Then I validate if doing tap on field will make focus to "Bag"
    Then I click on "DONE" button in cash screen
    And validate if "Cash" icon has "completed" mark on all fields entry
    When I click on "Cash" icon for "<OSVersion>"
    Then validate data is saved for all fields in cash page
    And validate if "Refund" field accepts decimal value
    Then I click on "DONE" button in cash screen
    And I navigate back to Scheduled asset screen from select activity screen
    And I click on another asset in scheduled asset screen
    When I click on "Cash" icon for "<OSVersion>"
    And I click on "Bag" field
    And I enter previous asset value in "Bag" field
    Then I click on "DONE" button in cash screen
    And validate if duplicate "Bag" value error message is displayed
    Then I click on Okay button in cash screen
    And Update execution status for "<Functionality>" functionality

    Examples: 
      | OSVersion | Functionality |
      | android   | CashPageFunctionality |
@driverAppScreens
@driverAppPicklistFlow
Feature: Picklist flow of DriverApp
      
      @picklistFlow
  Scenario Outline: Picklist flow validations
    Given I launch the application in "<OSVersion>" for "<Functionality>"
    Then I click on driver app to access location
    And I click on driver app to access media
    Then I enter username and password
    And I click login button
    And I verify operator text in "<OSVersion>"
    Then I click on operator
    And I click on route in "<OSVersion>"
    Then validate if Date page is displayed for "<OSVersion>"
    When I click on enabled "Start" button
    And I extract asset ID type and place from Scheduled asset screen for "<OSVersion>"
    And I click on asset in scheduled asset screen for "<OSVersion>"
    When I click on "Pick List" icon
    Then validate if route place and type is displayed in Pick list screen for "<OSVersion>"
    And I extract coils details from Picklist screen
    And I extract coil names from Picklist screen to validate in Service Inventory screen
    And I navigate back to select activity screen from Pick list screen
    And validate if "Pick List" icon has "not completed" mark
    When I navigate to "Service/Inventory" screen for "<OSVersion>"
    And validate if coil details in Picklist screen is displayed in Service Inv screen
    #And I click on coils retrieved from Picklist screen and fill values in "Inv" fields
    Then I navigate back to select activity screen from Service Inv screen
    #And I click on Leave in Service Inv Error message if displayed
    #And validate if "Pick list" icon has "completed" mark
    When I click on "Pick List" icon
    And I validate price mismatch error message in Pick list screen if displayed
    And I navigate back to select activity screen from Pick list screen
    And Update execution status for "<Functionality>" functionality

    Examples: 
      | OSVersion | Functionality |
      | android   | PicklistPageFunctionality |
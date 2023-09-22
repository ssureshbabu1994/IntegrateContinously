@driverAppScreens
@driverAppScheduledAssetFlow
Feature: Scheduled Asset flow of DriverApp
      
      @scheduledAssetFlow
  Scenario Outline: Scheduled Asset validations
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
     And validate if "Scheduled Asset" screen is displayed
    And I extract asset ID type and place from Scheduled asset screen for "<OSVersion>"
    And validate if selected route is displayed in scheduled asset screen
    Then validate if locations are displayed
    And validate if assets are displayed
    Then validate if "Scheduled" asset and "Serviced" asset pane are displayed
    And Update execution status for "<Functionality>" functionality

    Examples: 
      | OSVersion | Functionality |
      | android   | ScheduledAssetFunctionality |
@driverAppScreens
@driverAppPhotoFlow
Feature: Photo flow of DriverApp
      
      @photoFlow
  Scenario Outline: Photo flow validations
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
    And I navigate back to select activity screen from Pick list screen
    And validate if "Photo" icon has "not completed" mark
    When I click on "Photo" icon and navigate to photo screen for "<OSVersion>"
    And I click on driver app to take photo and video
    Then validate if photo features are displayed
    And I click on "Capture" icon in photo screen
    And I click on "Cancel" icon
    Then validate if Photo icon is displayed
    When I click on "Photo" icon and navigate to photo screen for "<OSVersion>"
    And I click on "Capture" icon in photo screen
    Then I click on "Save" icon in photo screen
    And validate if "Photo" icon has "completed" mark
     When I click on "Photo" icon and navigate to photo screen for "<OSVersion>"
     Then validate if Preview option is displayed for the previously captured photo
    And Update execution status for "<Functionality>" functionality

    Examples: 
      | OSVersion | Functionality |
      | android   | PhotoScreenFunctionality |
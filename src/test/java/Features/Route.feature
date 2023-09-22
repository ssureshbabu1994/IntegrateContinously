@driverAppScreens
@driverAppRouteFlow
Feature: Route flow of DriverApp
      
      @routePage
  Scenario Outline: Route flow validation
    Given I launch the application in "<OSVersion>" for "<Functionality>"
    Then I click on driver app to access location
    And I click on driver app to access media
    Then I enter username and password
    And I click login button
    And I verify operator text in "<OSVersion>"
    Then I click on operator
    When I enter invalid route in route search field in "<OSVersion>"
    Then I validate if invalid route name eror message is displayed
    And I clear route field
    Then I extract list of routes
    And I validate if routes are displayed in alphabetical order
    When I enter valid route in route search field
    Then validate if list is narrowed down with route entered
    And validate if route field is cleared on clicking close
    And I click on route in "<OSVersion>"
     Then validate if Date page is displayed for "<OSVersion>"
    When I click on enabled "Start" button
    And validate if "Scheduled Asset" screen is displayed
    And Update execution status for "<Functionality>" functionality

    Examples: 
      | OSVersion | Functionality |
      | android   | RoutePageFunctionality |
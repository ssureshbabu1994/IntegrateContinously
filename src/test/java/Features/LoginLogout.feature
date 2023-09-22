 @driverAppScreens
@driverAppLoginLogout
Feature: Login Logout functionality of DriverApp
      
  #@loginLogoutFunctionality
  #Scenario Outline: Validate login and logout functionality
    #When I launch the application in "<OSVersion>" for "<Functionality>"
    #And I validate login page objects
    #Then I enter username and password
    #And I click login button
    #And I verify operator text in "<OSVersion>"
    #Then I click logout
    #And validate if logout is done successfully
    #And Update execution status for "<Functionality>" functionality
#
    #Examples: 
      #| OSVersion | Functionality |
      #| iOS       | LoginLogoutFunctionality |
      #| android   | LoginLogoutFunctionality |
      
  @endToEndloginLogoutFunctionality
  Scenario Outline: Validate End to End login and logout functionality
    Given I launch the application in "<OSVersion>" for "<Functionality>"
    Then I click on driver app to access location
    And I click on driver app to access media
    #And validate if splash screen is displayed
		When I click login button
    And validate if hide or show is displayed
    And validate if skip username or password error msg is displayed
    And validate if blank username and valid pwd error msg is dispalyed
    And validate if valid username and blank pwd error msg is dispalyed
    And validate if valid username and incorrect pwd error msg is dispalyed
    And validate if copyright text and version is displayed
    And validate if user gets error msg when logged in with blank spaces in username and password
    Then I enter username and password
    And I click login button
    And I verify operator text in "<OSVersion>"
    Then I click logout alone
    And validate logout yes or no is displayed
    And validate logout popup "No" functionality
    Then I click logout alone
    And validate logout popup "Yes" functionality
    And validate if logout is done successfully
    And Update execution status for "<Functionality>" functionality

    Examples: 
      | OSVersion | Functionality |
      | android   | EndtoEndLoginLogoutFunctionality |
    
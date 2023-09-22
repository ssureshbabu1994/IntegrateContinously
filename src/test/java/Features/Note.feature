@driverAppScreens
@driverAppNoteFlow
Feature: Note flow of DriverApp
      
      @noteFlow
  Scenario Outline: Note flow validations
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
     And validate if "Note" icon has "not completed" mark
    When I click on "Note" icon in select activity screen for "<OSVersion>"
    Then validate if route place and type is displayed in note screen
    And validate if "Note" is displayed in Note screen
    Then I navigate back to select activity screen from Note screen
    When I click on "Note" icon in select activity screen for "<OSVersion>"
    And validate if text box to compose message is displayed
    Then validate if user can enter text in note text box
    And I navigate back and validate pop up confirmation
   And validate if "Note" icon has "completed" mark
    When I click on "Note" icon in select activity screen for "<OSVersion>"
    And validate if last saved note is displayed in Note text box
    #Then validate user is able to edit the existing notes
    And Update execution status for "<Functionality>" functionality

    Examples: 
      | OSVersion | Functionality |
      | android   | NoteScreenFunctionality |
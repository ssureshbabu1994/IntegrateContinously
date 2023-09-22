@driverAppScreens
@driverAppServicePlanogramFlow
Feature: Service Planogram flow of DriverApp
      
      @servicePlanogramFeaturesDisplayInvFillValidationFlow
  Scenario Outline: Service Planogram Features Display Inv fill field values validations
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
    And I extract asset ID type and place of asset having Service Inv mandatory icon from Scheduled asset screen for "<OSVersion>"
    And I click on asset in scheduled asset screen having Service Inv mandatory for "<OSVersion>"
    #When I click on "Pick List" icon
    #Then validate if route place and type is displayed in Pick list screen for "<OSVersion>"
    #And I navigate back to select activity screen from Pick list screen
    #And validate if "Service/Inventory" icon has "not completed" mark
    When I navigate to "Service/Inventory" screen for "<OSVersion>"
    And validate coil details for each coil displayed
    And I enter value in "Fill" and "Inv" field in any of the coil
    Then I navigate back to select activity screen from Service Inv screen
    And validate Inv mandatory error message displayed
    Then I click on Leave in Service Inventory screen
     When I navigate to "Service/Inventory" screen for "<OSVersion>"
      And I enter value in "Fill" and "Inv" field in any of the coil
      Then I navigate back to select activity screen from Service Inv screen
     Then I click on Continue in Service Inventory screen
     And validate swipe left or right to move between coils is displayed 
    #And validate coil details for each coil displayed
    And validate fields dispalyed for each coil
     And validate if "Inv" value cannot be lesser than Fill
     #And validate if "Inv" value cannot be greater than Cap
    #Then validate if fields values for each coil is not empty by default
    #And validate if "Inv" field value is empty by default
    #And validate field values of each coil is lesser than or equal to respective coil Cap value
    #And I click on coils and fill values in "Inv" fields
    #Then I navigate back to select activity screen from Service Inv screen
    #And validate if "Service/Inventory" icon has "completed" mark
    And Update execution status for "<Functionality>" functionality

    Examples: 
      | OSVersion | Functionality |
      | android   | ServicePlanogramFeaturesDisplayInvFillValidation |
      
       @servicePlanogramInvCapValidationFlow
  Scenario Outline: Service Planogram Inv Cap Fields Valdiation validations
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
    And I extract asset ID type and place of asset having Service Inv mandatory icon from Scheduled asset screen for "<OSVersion>"
    And I click on asset in scheduled asset screen having Service Inv mandatory for "<OSVersion>"
    #When I click on "Pick List" icon
    #Then validate if route place and type is displayed in Pick list screen for "<OSVersion>"
    #And I navigate back to select activity screen from Pick list screen
    #And validate if "Service/Inventory" icon has "not completed" mark
    When I navigate to "Service/Inventory" screen for "<OSVersion>"
    And validate coil details for each coil displayed
    #And I enter value in "Fill" and "Inv" field in any of the coil
    #Then I navigate back to select activity screen from Service Inv screen
    #And validate Inv mandatory error message displayed
    #Then I click on Leave in Service Inventory screen
     #When I navigate to "Service/Inventory" screen for "<OSVersion>"
      #And I enter value in "Fill" and "Inv" field in any of the coil
      #Then I navigate back to select activity screen from Service Inv screen
     #Then I click on Continue in Service Inventory screen
     #And validate swipe left or right to move between coils is displayed 
    #And validate coil details for each coil displayed
    #And validate fields dispalyed for each coil
     #And validate if "Inv" value cannot be lesser than Fill
     And validate if "Inv" value cannot be greater than Cap
    #Then validate if fields values for each coil is not empty by default
    #And validate if "Inv" field value is empty by default
    #And validate field values of each coil is lesser than or equal to respective coil Cap value
    #And I click on coils and fill values in "Inv" fields
    #Then I navigate back to select activity screen from Service Inv screen
    #And validate if "Service/Inventory" icon has "completed" mark
    And Update execution status for "<Functionality>" functionality

    Examples: 
      | OSVersion | Functionality |
      | android   | ServicePlanogramInvCapValidation |
      
       @servicePlanogramFieldsValuesValidation
  Scenario Outline: Service Planogram Field values validations
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
    And I extract asset ID type and place of asset having Service Inv mandatory icon from Scheduled asset screen for "<OSVersion>"
    And I click on asset in scheduled asset screen having Service Inv mandatory for "<OSVersion>"
    #When I click on "Pick List" icon
    #Then validate if route place and type is displayed in Pick list screen for "<OSVersion>"
    #And I navigate back to select activity screen from Pick list screen
    #And validate if "Service/Inventory" icon has "not completed" mark
    When I navigate to "Service/Inventory" screen for "<OSVersion>"
    #Then I navigate back to select activity screen from Service Inv screen
    #And validate Inv mandatory error message displayed
    #Then I click on Leave in Service Inventory screen
     #When I navigate to "Service/Inventory" screen for "<OSVersion>"
      #Then I navigate back to select activity screen from Service Inv screen
     #Then I click on Continue in Service Inventory screen
     #And validate swipe left or right to move between coils is displayed 
    And validate coil details for each coil displayed
    #And validate fields dispalyed for each coil
    Then validate if fields values for each coil is not empty by default
    #And validate if "Inv" field value is empty by default
    #And validate field values of each coil is lesser than or equal to respective coil Cap value
    #And I click on coils and fill values in "Inv" fields
    #Then I navigate back to select activity screen from Service Inv screen
    #And validate if "Service/Inventory" icon has "completed" mark
    And Update execution status for "<Functionality>" functionality

    Examples: 
      | OSVersion | Functionality |
      | android   | ServicePlanogramFieldsValuesValidation |
      
      @servicePlanogramInvFieldValidation
  Scenario Outline: Service Planogram Inv Field value validations
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
    And I extract asset ID type and place of asset having Service Inv mandatory icon from Scheduled asset screen for "<OSVersion>"
    And I click on asset in scheduled asset screen having Service Inv mandatory for "<OSVersion>"
    #When I click on "Pick List" icon
    #Then validate if route place and type is displayed in Pick list screen for "<OSVersion>"
    #And I navigate back to select activity screen from Pick list screen
    #And validate if "Service/Inventory" icon has "not completed" mark
    When I navigate to "Service/Inventory" screen for "<OSVersion>"
    #Then I navigate back to select activity screen from Service Inv screen
    #And validate Inv mandatory error message displayed
    #Then I click on Leave in Service Inventory screen
     #When I navigate to "Service/Inventory" screen for "<OSVersion>"
      #Then I navigate back to select activity screen from Service Inv screen
     #Then I click on Continue in Service Inventory screen
     #And validate swipe left or right to move between coils is displayed 
    And validate coil details for each coil displayed
    #And validate fields dispalyed for each coil
    #Then validate if fields values for each coil is not empty by default
    And validate if "Inv" field value is empty by default
    #And validate field values of each coil is lesser than or equal to respective coil Cap value
    #And I click on coils and fill values in "Inv" fields
    #Then I navigate back to select activity screen from Service Inv screen
    #And validate if "Service/Inventory" icon has "completed" mark
    And Update execution status for "<Functionality>" functionality

    Examples: 
      | OSVersion | Functionality |
      | android   | ServicePlanogramInvFieldValidation |
      
      @servicePlanogramFieldsValuesCapComparisonValidation
  Scenario Outline: Service Planogram Field values Cap comparison validations
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
    And I extract asset ID type and place of asset having Service Inv mandatory icon from Scheduled asset screen for "<OSVersion>"
    And I click on asset in scheduled asset screen having Service Inv mandatory for "<OSVersion>"
    #When I click on "Pick List" icon
    #Then validate if route place and type is displayed in Pick list screen for "<OSVersion>"
    #And I navigate back to select activity screen from Pick list screen
    #And validate if "Service/Inventory" icon has "not completed" mark
    When I navigate to "Service/Inventory" screen for "<OSVersion>"
    #Then I navigate back to select activity screen from Service Inv screen
    #And validate Inv mandatory error message displayed
    #Then I click on Leave in Service Inventory screen
     #When I navigate to "Service/Inventory" screen for "<OSVersion>"
      #Then I navigate back to select activity screen from Service Inv screen
     #Then I click on Continue in Service Inventory screen
     #And validate swipe left or right to move between coils is displayed 
    And validate coil details for each coil displayed
    #And validate fields dispalyed for each coil
    #Then validate if fields values for each coil is not empty by default
    #And validate if "Inv" field value is empty by default
    And validate field values of each coil is lesser than or equal to respective coil Cap value
    #And I click on coils and fill values in "Inv" fields
    #Then I navigate back to select activity screen from Service Inv screen
    #And validate if "Service/Inventory" icon has "completed" mark
    And Update execution status for "<Functionality>" functionality

    Examples: 
      | OSVersion | Functionality |
      | android   | ServicePlanogramFieldsValuesCapComparisonValidation |
      
       @servicePlanogramCheckMarkValidation
  Scenario Outline: Service Planogram Check mark completion flow validations
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
    And I extract asset ID type and place of asset having Service Inv mandatory icon from Scheduled asset screen for "<OSVersion>"
    And I click on asset in scheduled asset screen having Service Inv mandatory for "<OSVersion>"
    When I click on "Pick List" icon
    Then validate if route place and type is displayed in Pick list screen for "<OSVersion>"
    And I navigate back to select activity screen from Pick list screen
    And validate if "Service/Inventory" icon has "not completed" mark
    #When I navigate to "Service/Inventory" screen for "<OSVersion>"
    #Then I navigate back to select activity screen from Service Inv screen
    #And validate Inv mandatory error message displayed
    #Then I click on Leave in Service Inventory screen
     When I navigate to "Service/Inventory" screen for "<OSVersion>"
      #Then I navigate back to select activity screen from Service Inv screen
     #Then I click on Continue in Service Inventory screen
     #And validate swipe left or right to move between coils is displayed 
    And validate coil details for each coil displayed
    #And validate fields dispalyed for each coil
    #Then validate if fields values for each coil is not empty by default
    #And validate if "Inv" field value is empty by default
    #And validate field values of each coil is lesser than or equal to respective coil Cap value
    And I click on coils and fill values in "Inv" fields
    Then I navigate back to select activity screen from Service Inv screen
    And validate if "Service/Inventory" icon has "completed" mark
    And Update execution status for "<Functionality>" functionality

    Examples: 
      | OSVersion | Functionality |
      | android   | ServicePlanogramCheckMarkValidation |
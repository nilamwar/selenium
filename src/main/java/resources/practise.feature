Feature: OrangeHRM Login Validations

  Background:
    Given the user is on the OrangeHRM login page

   Scenario: Validate error for empty password and username
    When the user enters username "" and password "hvkvki"
    And clicks the login button
    Then the error message "Required" should be displayed

   Scenario: Validate enter password and username
    When the user enters username "admin" and password "admin123"
    And clicks the login button
    Then the  message "OranggeHrm" should be displayed
    
    Scenario: Validate error for empty password and username
    When the user enters username "" and password ""
    And clicks the login button
    Then the error message "Required" should be displayed
    
    Scenario: Validate error for number password and username
    When the user enters username "858585" and password "865858"
    And clicks the login button
    Then the error message "invalid" should be displayed
    
    Scenario: Validate error for number password and username
    When the user enters username "#$%^^&(87696" and password "#$598i9%&*&^"
    And clicks the login button
    Then the error message "invalid" should be displayed



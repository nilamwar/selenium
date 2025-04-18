Feature: OrangeHRM Login Validations

  Background:
    Given the user is on the OrangeHRM login page

  Scenario: Validate error for empty username and password
    When the user enters username "" and password "hvkvki"
    And clicks the login button
    Then the error message "Required" should be displayed

    
   Scenario: Validate enter username and password
    When the user enters username "Admin" and password "admin123"
    And clicks the login button
    Then the page title should be "OrangeHRM"

   
    
    
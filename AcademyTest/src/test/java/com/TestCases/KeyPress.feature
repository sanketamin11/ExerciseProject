Feature: please click on Key presses on Menu

  Background: 
    Given Navigate to given URL

  @KeyPress
  Scenario: Key presses on Menu
    Given I am on Key press page
    When I press on key "ENTER","CONTROL","ALT","SHIFT"
    Then Confirm Success and close the broweser

    
    
    
    
    
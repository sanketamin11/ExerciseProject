Feature: please click on Infinite scroll on Menu

  @Scroll
  Scenario: scroll to the bottom of the page twice and scroll back to the top of the page and assert the value
    Given Navigate to given URL
    When I click on Infinite scroll on Menu
    And scroll to the bottom of the page twice
    And scroll back to the top of the page
    Then validate assertation value "Infinite Scroll"

    
    
    
    
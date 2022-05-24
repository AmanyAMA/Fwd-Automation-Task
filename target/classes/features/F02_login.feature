@smoke
Feature: User should be able to Login to the system

  #Test Scenario:
  Scenario: user Login with valid data
    When user Enter valid data in "amany.atef@gamil.com" and "123456"
    #Expected result
    Then system redirects to Home page and system display Account tab
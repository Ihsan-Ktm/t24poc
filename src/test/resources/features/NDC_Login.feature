
@tag
Feature: This is Demo test case of NDC application.

  @NDC_Login
  Scenario Outline: Verify User can Log in into application through Valid credentials

  Given I am on NDC home page
  And I enter username as "<username>" and password as "<password>" to login page
  And I click on login button
  And I click on tools 
  And I select the branch
  And I verify that I am on desired Page
  
Examples:
|  username | password   | 
|  NADIR001 |  123456    |

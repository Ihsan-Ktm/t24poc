
@createAccount
Feature:  Branch user can create an account in system

  @Create_Account
  Scenario Outline: Verify that branch user can create an Account in system.
  
  Given I am on NDC home page
  And I enter username as "<username>" and password as "<password>" to login page
  And I click on login button
  And I click on tools 
  And I select the branch
  And I click on "<link>" through user menu
  And I click on current account through accounts menu from product groups
  And I click on new arrangements from product for current account
  And I enter the customer number as "<customerNumber>"
  And I enter the currency
  Then I validate the deal
  And I click on "<tab_name>" tab and filled the required data
  And I click on "<tab_name1>" tab and filled the required data
  And I click on "<tab_name2>" tab and filled the required data
  And I click on "<tab_name3>" tab and filled the required data
  And I click on "<tab_name4>" tab and filled the required data
  Then I Commit the deal
  And I verify the commit
  
Examples:
|  username | password   |    customerNumber   |  tab_name  |       tab_name1         |    tab_name2    |    tab_name3    |   tab_name4   |       link        |     
|  NADIR001 |  123456    |     100261          |   Account  |  Regulatory Information |  Tax Exemption  | cheque book tab |  ATM card tab |  product catalog  |


@depositeCreation
Feature: Deposit can be create and authorize

@deposit_creation
	Scenario Outline: Verify the creation and autorization process of deposit arrangements
		    Given I am on NDC home page
		    And I enter username as "<username>" and password as "<password>" to login page
        And I click on login button
        And I click on tools 
      	And I select the branch
        And I verify that I am on desired Page
        Then I enter "<value>" in command line 
        Then I click on AA Accounts & Deposits Conventional
        And I click on retail product catalog
        And I click on deposit plan
        And I enter the customer number as "<customerNumber>"
        Then I validate the deal
        And I copy the txn number
        And I filled up the required fields for deposit
        Then I validate the deal
        Then I Commit the deal
        And I verify the commit
        Given I am on NDC home page
		    And I enter username as "<username1>" and password as "<password>" to login page
        And I click on login button
        And I click on tools 
      	And I select the branch
        And I verify that I am on desired Page
        And I click on "<link>" through user menu
        And I click on find deposit link
        And I click on unauthorised tab
        And I click on find deposit button
        And I click on overview the deposit
        And I click on approval button from pending approval box
        And I click on authorise the deal button
        Then I verify the commit
        
       
            
			Examples: 
			|  username | password   | value  |  customerNumber | username1 |         link       |
			|  NADIR001 |  123456    | ?10	  |     100261      |  NADIR002 |  Retail Operations |
			
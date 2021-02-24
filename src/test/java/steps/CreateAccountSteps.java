package steps;

import cucumber.api.java.en.*;
import pages.CreateAccountPage;


public class CreateAccountSteps {

	CreateAccountPage accCreation= new CreateAccountPage();
	
	@Given("^I click on \"([^\"]*)\" through user menu$")
	public void selectLinkThroughMenu(String link) throws Exception   {
	    // Write code here that turns the phrase above into concrete actions
		accCreation.clickDesiredLinkFromMenu(link);
	}
	
	@And("^I click on current account through accounts menu from product groups$")
	public void selectCurrentAccountThroughAccounts()    {
	    // Write code here that turns the phrase above into concrete actions
		accCreation.clickCurrentAccountThroughAccounts();
	}
	
	@And("^I click on new arrangements from product for current account$")
	public void selectNewArrangementsForCurrentAccount() throws Exception    {
	    // Write code here that turns the phrase above into concrete actions
		accCreation.clickNewArrangementsForCurrentAccount();
	}
	
	@And("^I enter the customer number as \"([^\"]*)\"$")
	public void enterCustomerNumber(String customerNumber) {
	    // Write code here that turns the phrase above into concrete actions
	    accCreation.enterCustomerNumber(customerNumber);
	}
	
	@And("^I enter the currency$")
	public void enterCurrency() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    accCreation.enterCurrency();
	}
	
	
	@Then("^I validate the deal$")
	public void validateDeal() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    accCreation.validatingDeal();
	}
	
	
	@And("^I click on \"([^\"]*)\" tab and filled the required data$")
	public void clickAccountTab(String tab_name) throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    accCreation.clickAccountTab(tab_name);
	}
	

	@Then("^I Commit the deal$")
	public void commitDeal() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    accCreation.commitingDeal();
	}
	
	@And("^I verify the commit$")
	public void verifycommitDeal() {
	    // Write code here that turns the phrase above into concrete actions
	    accCreation.verifyCommit();
	}
}

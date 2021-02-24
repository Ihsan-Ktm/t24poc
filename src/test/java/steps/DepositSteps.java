package steps;

import cucumber.api.java.en.*;
import pages.CreateAccountPage;
import pages.DepositPage;

public class DepositSteps {
	
	DepositPage deposit= new DepositPage();
	CreateAccountPage accCreation= new CreateAccountPage();
	
	@Then("^I enter \"([^\"]*)\" in command line$")
	public void enterTextInCmd(String arg1) {
		deposit.enterValueInCmd(arg1);
	}

	@Then("^I click on AA Accounts & Deposits Conventional$")
	public void clickonAAAccount()  {
		deposit.clickDepositeAccount();
	}

	@Then("^I click on retail product catalog$")
	public void clickRetailProduct() {
		deposit.retailProduct();
	}
	
	@And("^I click on deposit plan$")
	public void clickDepositPlan() {
		deposit.selectBOKPlan();
	}
	@And("^I copy the txn number$")
	public void copyTxnNum() {
		deposit.copyTxnNumber();
	}
	
	@And("^I filled up the required fields for deposit$")
	public void fillUpRequiredFields()  {
		deposit.fillUpRequiredFields();
	}
	
	@And("^I quit the browser$")
	public void quitBrowser()  {
		deposit.quitingBrowser();
	}
	@And("^I click on find deposit link$")
	public void clickFindDepositLink()  {
		accCreation.clickFindDeposits();
	}
		
	@And("^I click on unauthorised tab$")
	public void clickUnauthorisedTab()  {
		deposit.clickUnauthorisedTab();
	}
	
	@And("^I click on find deposit button$")
	public void clickFindDeposit()  {
		deposit.clickFindDeposit();
	}
	
	@And("^I click on overview the deposit$")
	public void clickDepositOverview() throws Exception  {
		deposit.clickOverViewDeposit();
	}
	
	
	@And("^I click on approval button from pending approval box$")
	public void clickApproval()  {
		deposit.clickApprovalButton();
	}
	@And("^I click on authorise the deal button$")
	public void clickAuthoriseButton()  {
		deposit.clickAuthoriseBtn();
	}
}

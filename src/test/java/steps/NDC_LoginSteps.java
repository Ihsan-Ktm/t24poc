package steps;

import cucumber.api.java.en.*;
import pages.NDC_LoginPage;
import runners.CucumberRunner;

public class NDC_LoginSteps {

	CucumberRunner c = new CucumberRunner();
	NDC_LoginPage login=new NDC_LoginPage();
	@Given("^I am on NDC home page$")
	public void openNDC() throws Exception  {
	    // Write code here that turns the phrase above into concrete actions
	    c.setEnv();
	}

	@And("^I enter username as \"([^\"]*)\" and password as \"([^\"]*)\" to login page$")
	public void enterUserNameAndPassword(String userName, String password){
	    // Write code here that turns the phrase above into concrete actions
	    login.enterUserName(userName);
	    login.enterPassword(password);
	}
	
	@And("^I click on login button$")
	public void clickLoginButton() {
	    // Write code here that turns the phrase above into concrete actions
	    login.clickLoginButton();
	}

	@And("^I click on tools$")
	public void clickTools() {
	    // Write code here that turns the phrase above into concrete actions
	    login.clickTools();
	}
	
	@And("^I select the branch$")
	public void clickBranch() {
	    // Write code here that turns the phrase above into concrete actions
	    login.clickBranch();
	}
	
	@And("^I verify that I am on desired Page$")
	public void verifyDesiredPage() {
	    // Write code here that turns the phrase above into concrete actions
	    login.verifyDesiredPage();
	}
}

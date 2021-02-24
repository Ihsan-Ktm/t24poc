package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import runners.CucumberRunner;

public class DepositPage extends CucumberRunner {
	
	String txnNumber="";
	
	By cmd = By.xpath("//input[@name='commandValue']");
	By depositeAcc = By.xpath("//img[@alt='AA Accounts & Deposits (Conventional)']");
	By searchIcon = By.xpath("//img[@id='cmdline_img']");
	By retailsOpt=By.xpath("//a[contains(text(),'Retail Product Catalog ')]");
	
	//Fiaz
	By BOKBeBahaMahana= By.xpath("//img[contains(@id,'treestop96')]");
	By newArrangement= By.xpath("(//a[@title='New Arrangement'])[83]");
	By txnNum=By.id("disabled_ARRANGEMENT");
	
	By gbAccountName= By.xpath("//input[@id='fieldName:SHORT.TITLE:1']");
	By commitmentAmount= By.xpath("//input[@id='fieldName:AMOUNT']");
	
   //initial Funding, Charges Settlement
	By sattlementAccount= By.xpath("//input[@id='fieldName:PAYIN.ACCOUNT:1:1' and @tabname='tab1']");
	By sattlementAccount1= By.xpath("//input[@id='fieldName:PAYIN.ACCOUNT:2:1' and @tabname='tab1']");
	By sattlementAccount2= By.xpath("//input[@id='fieldName:PAYIN.ACCOUNT:3:1' and @tabname='tab1']");	
	
	//Interest & Redemption Settlement
	By sattlementAccount3= By.xpath("//input[@id='fieldName:PAYOUT.ACCOUNT:1:1' and @tabname='tab1']");
	By sattlementAccount4= By.xpath("//input[@id='fieldName:PAYOUT.ACCOUNT:2:1' and @tabname='tab1']");
	
	By unauthorisedTab= By.xpath("//span[contains(text(), 'Unauthorised')]");
    By depositFind= By.xpath("//a[@title='Run Selection']");	
    
    
    By approvalBtn=By.xpath("//a[@title='Select Drilldown']");
    By authoriseDeal=By.xpath("//a[@title='Authorises a deal']");
    
    
public void enterValueInCmd(String value){
	
		switchToWindow();
	    implicitWait(15);
	    driver.switchTo().frame(0);
		WebElement cmdTextField= driver.findElement(cmd);
		assert(cmdTextField).isDisplayed();
		cmdTextField.sendKeys(value);
		WebElement searchBtn= driver.findElement(searchIcon);
		searchBtn.click();
		implicitWait(20);
	}
	
	public void clickDepositeAccount() {
		switchToWindow();
		WebElement DepositAccount= driver.findElement(depositeAcc);
		DepositAccount.click();
		switchToWindow();
			
	}
	
	public void retailProduct() {
		WebElement retailsOption= driver.findElement(retailsOpt);
		retailsOption.click();
		switchToWindow();	
	}	
	
	public void selectBOKPlan() {
		implicitWait(20);
		WebElement bokPlan= driver.findElement(BOKBeBahaMahana);
		bokPlan.click();
		implicitWait(20);
		WebElement newArrang= driver.findElement(newArrangement);
		newArrang.click();
		switchToWindow();		
		
	}
	
	public void copyTxnNumber() {
		implicitWait(20);
		WebElement txnNumberText= driver.findElement(txnNum);
		txnNumber= txnNumberText.getText();
		System.out.print(txnNumber);
		
	}
	
	public void fillUpRequiredFields() {
		implicitWait(20);
		WebElement gbAccountNameText= driver.findElement(gbAccountName);
		gbAccountNameText.sendKeys("Current");
		implicitWait(10);
		WebElement amountText=driver.findElement(commitmentAmount);
		amountText.sendKeys("100000");
		implicitWait(10);
		
		//Initial Funding, Charges Settlement
		WebElement initialSettlementAcc=driver.findElement(sattlementAccount);
		initialSettlementAcc.sendKeys("2000172211");
		implicitWait(10);
		WebElement initialSettlementAcc1=driver.findElement(sattlementAccount1);
		initialSettlementAcc1.sendKeys("2000172211");
		implicitWait(10);
		WebElement initialSettlementAcc2=driver.findElement(sattlementAccount2);
		initialSettlementAcc2.sendKeys("2000172211");
		
		//Interest & Redemption Settlement
		implicitWait(10);
		WebElement interestSettlementAcc3=driver.findElement(sattlementAccount3);
		interestSettlementAcc3.sendKeys("2000172211");
		implicitWait(10);
		WebElement interestSettlementAcc4=driver.findElement(sattlementAccount4);
		interestSettlementAcc4.sendKeys("2000172211");
	}
	
	public void quitingBrowser() {
		driver.quit();
	}
	
	public void clickUnauthorisedTab() {
		implicitWait(10);
		WebElement unauthorisedTabLink=driver.findElement(unauthorisedTab);
		unauthorisedTabLink.click();
	}
	
	public void clickFindDeposit() {
		implicitWait(10);
		WebElement depositFindBtn =driver.findElement(depositFind);
		depositFindBtn.click();
	}
	
	public void clickOverViewDeposit() throws Exception {
		Thread.sleep(15000);
		By overViewDeposit= By.xpath("//td[contains(text(),'"+txnNumber+"')]/following-sibling::td/a[@title='Overview']/img");
		System.out.println("//td[contains(text(),'"+txnNumber+"')]/following-sibling::td/a[@title='Overview']/img");
		WebElement overViewDepositBtn =driver.findElement(overViewDeposit);
		overViewDepositBtn.click();
		implicitWait(20);
	}
	
	public void clickApprovalButton() {
		implicitWait(20);
		switchToWindow();
		WebElement approvalButton =driver.findElement(approvalBtn);
		approvalButton.click();
		implicitWait(10);
		switchToWindow();
	}
	
	public void clickAuthoriseBtn() {
		implicitWait(20);
		switchToWindow();
		WebElement authoriseButton =driver.findElement(authoriseDeal);
		authoriseButton.click();
		implicitWait(10);
		switchToWindow();
	}
}


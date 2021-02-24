package pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import runners.CucumberRunner;

public class CreateAccountPage extends CucumberRunner {

	By menu= By.xpath("//span[contains(text(), 'User Menu')]");
	By productCatalog= By.xpath("//ul[@class='menuMargin']/li/ul/li[7]/a[contains(text(), 'Product Catalog')]");	
	By retailOperation=By.xpath("(//span[contains(text(), 'Retail Operations')])[1]");
	By findDeposit=By.xpath("(//a[contains(text(), 'Find Deposit ')])[1]");
	By accounts=By.xpath("(//td[contains(text(), 'Accounts')]/a)[4]");
	By currentAccount=By.xpath("(//a[@title='Products']/img)[18]");
	By newArrangementForCurrentAccount= By.xpath("(//a[@title='New Arrangement'])[4]");	
	//New Arrangement 
	By customerNum= By.xpath("//input[contains(@id,'fieldName:CUSTOMER:1')]");
	By roleDrpDown= By.xpath("(//a[@title='Dropdown List'])[2]");
	By roleSelection= By.xpath("//*[@id='dropDownRow9']/td/b");
	By currencyDrpDown= By.xpath("(//a[@title='Dropdown List'])[4]");
	By validateDeal= By.xpath("//a[@title='Validate a deal']");
	By commitDeal= By.xpath("//a[@title='Commit the deal']");
	By completeMsg= By.xpath("//td[@class='message']");
	//After Validating Page
	
	By accountTab= By.xpath("//div[@id='topPart']/div[3]");
	By regulatoryInfoTab=By.xpath("//span[contains(text(),'Regulatory Information')]");
	By smsSubscription=By.xpath("//input[@id='radio:tab4:L.ALT.SUBSCRIBE' and @value='YES']");
	By smsCharges=By.xpath("//input[@id='radio:tab4:L.SMS.CHG' and @value='Waive']");
	By internetBankingCharges= By.xpath("//input[@id='radio:tab4:L.INT.CHG' and @value='Not Waived']");
	By initialDeposit=By.xpath("//input[@id='fieldName:L.INT.DEP']");
	By taxExemptionTab=By.xpath("//span[contains(text(),'Tax Exemption Details')]");
	By taxExemption=By.xpath("//input[@id='radio:tab5:L.TAX.EXMP' and @value='No']");
	By chequeBookTab=By.xpath("//span[contains(text(),'Cheque Book Request')]");
	By chequeBookRequired=By.xpath("//input[@id='radio:tab6:L.CHQ.WV.CHG' and @value='NO']");
	By leaves=By.xpath("//input[@id='radio:tab6:L.CHQ.NO.ISSUED' and @value='50']");
	By atmCardTab=By.xpath("//span[contains(text(),'ATM Card Request')]");
	By atmCardRequired=By.xpath("//input[@id='radio:tab7:L.CARD.WV.CHG' and @value='YES']");
	
	
	public void clickDesiredLinkFromMenu(String link) throws Exception  {
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs2.get(2));
	    implicitWait(10);
		driver.switchTo().frame(driver.findElement(By.xpath("//frame[contains(@id, 'menu')]")));
		Thread.sleep(10000);
		WebElement menuLink= driver.findElement(menu);		
		menuLink.click();
		implicitWait(5);
		if (link.equals("product catalog")) {
		WebElement productCat= driver.findElement(productCatalog);
		productCat.click();
		
		Thread.sleep(10000);		
		}
		
		else if(link.equals("Retail Operations")) {
			WebElement retailOperationLink= driver.findElement(retailOperation);
			retailOperationLink.click();
			implicitWait(20);
		}
		    
	}
	
	public void clickCurrentAccountThroughAccounts() {	
		switchToWindow();  
		driver.switchTo().frame(driver.findElement(By.xpath("//frame[contains(@id, 'ProductGroups')]")));
	    WebElement accountsLink= driver.findElement(accounts);
	    accountsLink.click();
	    implicitWait(30);	    
	    driver.findElement(currentAccount).click();
	    driver.switchTo().defaultContent();
				
	}
	
	public void clickNewArrangementsForCurrentAccount() throws Exception {	
		Thread.sleep(30000);
		driver.switchTo().frame(driver.findElement(By.xpath("//frame[contains(@name,'Products')]")));
	    WebElement currentAccountNewArrangement= driver.findElement(newArrangementForCurrentAccount);
	    currentAccountNewArrangement.click();
	    implicitWait(30);
	    driver.switchTo().defaultContent();
	    switchToWindow();
	    
	   	}
	
	public void enterCustomerNumber(String customerNumber) {
		
		    WebElement customerNumberField=  driver.findElement(customerNum);
		    customerNumberField.sendKeys(customerNumber);
			implicitWait(5);
			//Clicking on Role:1 dropdown
			WebElement roleDropDown=driver.findElement(roleDrpDown);
			roleDropDown.click();
			implicitWait(15);
			WebElement desiredRole=driver.findElement(roleSelection);
			desiredRole.click();
			implicitWait(5);

	}
		
	public void enterCurrency() throws Exception {
		
		WebElement currencyDropDown= driver.findElement(currencyDrpDown);
		currencyDropDown.click();
		implicitWait(30);
		
		switchToWindow();
		
		driver.findElement(By.xpath("//*[@id='r11']/td[1]/a/b")).click();
		
		implicitWait(30);
		switchToWindow();
		
		driver.findElement(By.id("enri_CURRENCY")).click();
		Thread.sleep(15000);
					
	}
	
	public void validatingDeal() throws Exception {
			
		WebElement validateDealBtn=driver.findElement(validateDeal);
		validateDealBtn.click();
		Thread.sleep(15000);
		try {
		WebElement validateDealBtn1=driver.findElement(validateDeal);
		validateDealBtn1.click();
		implicitWait(60);
		}
		catch (Exception e) {
			System.out.println("Already validated");
		}
	}
	
	public void clickAccountTab(String tabName) {
		
		if(tabName.equals("Account")){
			
			WebElement accountTabLink=driver.findElement(accountTab);
			accountTabLink.click();
			implicitWait(10);
			
			driver.findElement(By.xpath("//input[@id='fieldName:ACCOUNT.TITLE.1:1']")).sendKeys("Current Account");
			implicitWait(10);
			driver.findElement(By.id("fieldName:SHORT.TITLE:1")).sendKeys("Current");
			implicitWait(10);
		}
		
		else if(tabName.equals("Regulatory Information")) {
		
		    WebElement regulatoryInfoTabLink=driver.findElement(regulatoryInfoTab);
			regulatoryInfoTabLink.click();
		    
			implicitWait(10);
			
			WebElement smsSubscriptionRadio=driver.findElement(smsSubscription);
			smsSubscriptionRadio.click();
			implicitWait(10);
			WebElement smsChargesRadio=driver.findElement(smsCharges);
			smsChargesRadio.click();
			
			implicitWait(10);
			WebElement internetBankingChargesRadio=driver.findElement(internetBankingCharges);
			internetBankingChargesRadio.click();
			
			implicitWait(10);
			WebElement initialDepositTxtField=driver.findElement(initialDeposit);
			initialDepositTxtField.sendKeys("5000"); 
			
		}
	
		else if (tabName.equals("Tax Exemption")) {
			
			implicitWait(10);
			WebElement taxExemptionTabLink=driver.findElement(taxExemptionTab);
			taxExemptionTabLink.click(); 
			implicitWait(10);
			WebElement taxExemptionRadio=driver.findElement(taxExemption);
			taxExemptionRadio.click();
			implicitWait(10);
		
		}
		//Cheque Book Request Tab
		else if(tabName.equals("cheque book tab")) {
			
			implicitWait(10);
			WebElement chequeBookTabLink=driver.findElement(chequeBookTab);
			chequeBookTabLink.click();
			implicitWait(10);
			
			WebElement chequeBookRequiredRadio=driver.findElement(chequeBookRequired);
			chequeBookRequiredRadio.click(); 
			implicitWait(10);
			
			WebElement leavesRadio=driver.findElement(leaves);
			leavesRadio.click();
			
			implicitWait(10);
		}	
		//ATM Card Request Tab
		
		else if(tabName.equals("ATM card tab")) {
						
			WebElement atmCardTabLink=driver.findElement(atmCardTab);
			atmCardTabLink.click(); 
			implicitWait(10);			
			WebElement atmCardRequiredRadio=driver.findElement(atmCardRequired);
			atmCardRequiredRadio.click(); 
			implicitWait(10);
		
		}
	}
	
	public void commitingDeal() throws Exception {

		WebElement commitDealBtn=driver.findElement(commitDeal);
		commitDealBtn.click();
		Thread.sleep(15000);
			
	}
	
	public void verifyCommit() {
		WebElement commitCompleteMsg=driver.findElement(completeMsg);
		String ConfirmCompleteMsg= commitCompleteMsg.getText();
		Assert.assertTrue(ConfirmCompleteMsg.contains("Txn Complete:"));
	}
	
	public void clickFindDeposits() {
		implicitWait(10);
		WebElement findDepositLink=driver.findElement(findDeposit);
		findDepositLink.click();
		switchToWindow();
		
	}
	
	
}

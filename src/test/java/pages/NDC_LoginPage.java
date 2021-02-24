package pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import runners.CucumberRunner;

public class NDC_LoginPage extends CucumberRunner{
	
	By username= By.id("signOnName");
	By password= By.id("password");
	By login_button= By.id("sign-in");
	By tools= By.xpath("//a[@title='Tools']");
	By myCompanies= By.xpath("(//img[@id='imgError'])[2]");
	By city= By.xpath("(//a[contains(text(), 'ISLAMABAD')])[1]");
	
	
	public void enterUserName(String userName) {
		
		WebElement userNameField= driver.findElement(username);
		userNameField.sendKeys(userName);
	}
	
	public void enterPassword(String Password) {
		
		WebElement passwordField= driver.findElement(password);
		passwordField.sendKeys(Password);
	}
	
	public void clickLoginButton() {
		
		WebElement loginButton= driver.findElement(login_button);
		loginButton.click();
	}
	
	public void clickTools() {
		driver.switchTo().frame(0);
		implicitWait(15);
		WebElement toolsLink= driver.findElement(tools);
		toolsLink.click();
		driver.switchTo().defaultContent();
	}
	
	public void clickBranch() {
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs2.get(1));
		implicitWait(15);
		WebElement myCompaniesLink= driver.findElement(myCompanies);
		myCompaniesLink.click();
		implicitWait(5);
		WebElement branchCity= driver.findElement(city);
		branchCity.click();
		implicitWait(15);
		
	}
	
	public void verifyDesiredPage() {
		String expected="T24 - ISLAMABAD";
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs2.get(2));
		implicitWait(15);
		String actuall= driver.getTitle();
		System.out.print(actuall);
		Assert.assertEquals(actuall, expected);
		
		
	}
}

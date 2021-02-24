package runners;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cucumber.listener.ExtentCucumberFormatter;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions
(
		plugin = {"json:target/positive/cucumber.json", "pretty", "html:target/positive/cucumber.html","com.cucumber.listener.ExtentCucumberFormatter"},
		features = {"src/test/resources/features"},
		glue = "steps",
		tags = { "@deposit_creation" }
		)
public class CucumberRunner extends AbstractTestNGCucumberTests {
	
	public static Properties config = null;
	public static WebDriver driver;
	public static Logger logger;
	
	@BeforeClass
	public void generateHTMLReports() {
		SimpleDateFormat sdf = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date curDate = new Date();
		String strDate = sdf.format(curDate);
		String fileName = System.getProperty("user.dir")+"\\ExtentReport\\The Demo Report " + strDate+".html";
		File newFile = new File(fileName);
		ExtentCucumberFormatter.initiateExtentCucumberFormatter(newFile,true);
		ExtentCucumberFormatter.loadConfig(new File("src/test/resources/extent-config.xml"));
        
		ExtentCucumberFormatter.addSystemInfo("Browser Name", "Chrome ");
		ExtentCucumberFormatter.addSystemInfo("Browser version", "79.0.45");
		ExtentCucumberFormatter.addSystemInfo("Selenium version", "v2.53.0");
		   
	}
	
public void LoadConfigProperty() throws IOException {
		
		logger=Logger.getLogger("BullhornTest"); //Added logger
		PropertyConfigurator.configure("Log4j.properties");//Added logger
		
		config = new Properties();
		FileInputStream ip = new FileInputStream(
				System.getProperty("user.dir") + "//src//test//resources//config//config.properties");
		config.load(ip);
	}

	public void configureDriverPath() throws IOException {
		if(System.getProperty("os.name").startsWith("Linux")) {
			String firefoxDriverPath = System.getProperty("user.dir") + "/src/test/resources/drivers/linux/geckodriver";
			System.setProperty("webdriver.gecko.driver", firefoxDriverPath);
			String chromeDriverPath = System.getProperty("user.dir") + "/src/test/resources/drivers/linux/chromedriver";
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		}
		if(System.getProperty("os.name").startsWith("Mac")) {
			String firefoxDriverPath = System.getProperty("user.dir") + "/src/test/resources/drivers/mac/geckodriver";
			System.setProperty("webdriver.gecko.driver", firefoxDriverPath);
			String chromeDriverPath = System.getProperty("user.dir") + "/src/test/resources/drivers/mac/chromedriver";
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		}
		if(System.getProperty("os.name").startsWith("Windows")) {
			String firefoxDriverPath = System.getProperty("user.dir") + "//src//test//resources//drivers//windows//geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", firefoxDriverPath);
			String chromeDriverPath = System.getProperty("user.dir") + "//src//test//resources//drivers//windows//chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		}
	}

	public WebDriver openBrowser() throws Exception {
		// loads the config options
		LoadConfigProperty();
		// configures the driver path
		configureDriverPath();
		if (config.getProperty("browserType").equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (config.getProperty("browserType").equals("chrome")) {
			ChromeOptions options = new ChromeOptions();
			//			options.addArguments("--headless");
			//			options.addArguments("--disable-gpu");
			options.addArguments("--no-sandbox");
			options.addArguments("--disable-dev-shm-usage");
			options.setExperimentalOption("useAutomationExtension", false);
			driver = new ChromeDriver(options);
			
		}
		return driver;
	}

	public void maximizeWindow() {
		driver.manage().window().maximize();
	}

	public void implicitWait(int time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

	public void explicitWaitBy(By element) {
		WebDriverWait wait = new WebDriverWait(driver, 25000);
		wait.until(ExpectedConditions.visibilityOf((WebElement) element));
	}

	public void explicitWait(WebElement element) {
		try{
		WebDriverWait wait = new WebDriverWait(driver, 30000);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
		catch (Exception e){
			System.out.println("exception catch");
			e.printStackTrace();
		}
	}
	public void explicitWaitClick(WebElement element) {
		try{
		WebDriverWait wait = new WebDriverWait(driver, 10000);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
		catch (Exception e){
			System.out.println("exception catch");
			e.printStackTrace();
		}}

	public void pageLoad(int time) {
		driver.manage().timeouts().pageLoadTimeout(time, TimeUnit.SECONDS);
	}

	public void deleteAllCookies() {
		driver.manage().deleteAllCookies();
	}

	public void setEnv() throws Exception {
		LoadConfigProperty();
		String baseUrl = config.getProperty("NDCSiteUrl");
		driver.get(baseUrl);
		logger.info("******** Launching Browser*********");
	}
	public static String SplitNumbers(String split){

		String regex = "\\d+";
		//Creating a pattern object
		Pattern pattern = Pattern.compile(regex);
		//Creating a Matcher object
		Matcher matcher = pattern.matcher(split);
		System.out.println("Digits in the given string are: ");
		while (matcher.find()) {
			System.out.print(matcher.group() + "");
			String a = (matcher.group() + "");

			return a;
		}
		return null;
	}

	public static String currentDateTime() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		String cal1 = dateFormat.format(cal.getTime());
		return cal1;
	}
    public void setPeopleNetEnv() throws Exception {
        LoadConfigProperty();
        String baseUrl = config.getProperty("peopleNet");
        driver.get(baseUrl);
        Thread.sleep(5000);
        logger.info("******** Hitting People Net Site*********");
    }
    
    
    public void selectDropDownValueByIndex(WebElement element,int index) throws Exception {
        implicitWait(120);
        Select dropdown = new Select((element));
        dropdown.selectByIndex(index);
        logger.info("******** Selected Most Recent Date *********");
    }
    public void selectDropDownValueByValue(WebElement element,String Value ) throws Exception {
        implicitWait(120);
        Select dropdown = new Select((element));
        dropdown.selectByVisibleText(Value);
        logger.info("******** DropDown Value Selected *********");

    }


	public static WebDriver getDriver() {
		return driver;
	}
	
	@BeforeSuite
	public void setUp() throws Exception {
		openBrowser();
		maximizeWindow();
		implicitWait(60);
		deleteAllCookies();
	}
	
	//todo Methods reusubale
	public void JsClick(WebElement element) throws InterruptedException {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		Thread.sleep(3000);
		jse.executeScript("arguments[0].click();", element);


	}
	public void Iframe(String element) throws InterruptedException {
		driver.switchTo().frame(element);

	}
	
	public void switchToWindow() {
		
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		    driver.manage().window().maximize();
		    
		}
	}
	@AfterSuite
	public void quit() throws IOException, InterruptedException {
//		driver.quit();	
	}
//	public void JsSendKeys(WebElement element) throws InterruptedException {
//		JavascriptExecutor jse = (JavascriptExecutor) driver;
//		Thread.sleep(3000);
//		jse.executeScript("arguments[0].value=�Avinash Mishra�;", element);
//
//
//	}


}





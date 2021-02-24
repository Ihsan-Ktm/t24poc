package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class utility {
	public static Logger logger;
	public static Properties config = null;
	
      public void LoadConfigProperty() throws IOException {
		
		logger=Logger.getLogger("BullhornTest"); //Added logger
		PropertyConfigurator.configure("Log4j.properties");//Added logger
		
		config = new Properties();
		FileInputStream ip = new FileInputStream(
				System.getProperty("user.dir") + "//src//test//resources//config//config.properties");
		config.load(ip);
	}

	
	
}

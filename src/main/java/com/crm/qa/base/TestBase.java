package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	
	
	public TestBase() throws IOException {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\User\\eclipse-workspace\\Naveen-Java-Training\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
						e.printStackTrace();
			
		}
	}
	
         public static void intialization() {
        	 String browserName = prop.getProperty("browser");
        	 
        	 if(browserName.equals("chrome")) {
        		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\eclipse-workspace\\Naveen-Java-Training\\FreeCRMTest\\src\\main\\resources\\chromedriver.exe");
        		 driver = new ChromeDriver();
        	 }
        	 
        	 else if(browserName.equals("FF")) {
        		 
        		 System.setProperty("webdriver.gecko.driver", "C:\\Users\\User\\eclipse-workspace\\Naveen-Java-Training\\FreeCRMTest\\src\\main\\resources\\geckodriver.exe");
        		 driver = new FirefoxDriver();
        	 }
        	 
        	 driver.manage().window().maximize();
        	 driver.manage().deleteAllCookies();
        	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        	 driver.get(prop.getProperty("url"));
        	   	 
         }
	
	
	
}

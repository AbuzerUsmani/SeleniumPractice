package com.qa.practice.base;
import com.qa.practice.util.TestUtil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class TestBase {
	
	public static Properties prop;
	public static WebDriver driver;
	
	
	public TestBase()
	{
		try {
		prop = new Properties();
		FileInputStream fis = new FileInputStream("E:\\study\\GitDemo\\src\\"
				+ "main\\java\\com\\qa\\crm\\config\\config.properties");
		prop.load(fis);
		}
		catch(FileNotFoundException e) {
			e.getStackTrace();
		}
		catch(IOException e) {
			e.getStackTrace();	
		}	
	}
	

	public void Initialization()
	{
		
		String browserName= prop.getProperty("browser");
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "E:\\study\\GitDemo\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.equals("FF"))
		{
			System.setProperty("webdriver.gecko.driver", "E:\\study\\GitDemo\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browserName.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver", "E:\\study\\GitDemo\\Drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}	
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.pageload_time));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.Implicit_wait));
			
			driver.get(prop.getProperty("url"));
	}
}

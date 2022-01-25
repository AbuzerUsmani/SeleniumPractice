package InterviewDemos;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaleElementExceptionDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "E:\\study\\SeleniumDemo\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.pavantestingtools.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		WebElement element = driver.findElement(By.xpath("//*[@id=\"menu-primary-items\"]/li[4]/a"));
		
		element.click();
		
		Thread.sleep(3000);
		
		driver.navigate().back();
		
		Thread.sleep(5000);
		
		try
		{
		
		element.click();
		
		}
		catch(StaleElementReferenceException e)
		{
			element = driver.findElement(By.xpath("//*[@id=\"menu-primary-items\"]/li[4]/a"));
			
			element.click();
		}
		
		driver.quit();
		
	}

}

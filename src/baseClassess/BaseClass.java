package baseClassess;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {

	
	
	WebDriver driver;
	

	public static WebDriver getWebDriver() throws InterruptedException
	{
	
        System.setProperty("webdriver.chrome.driver", "F:\\Pandit\\Required Document\\Selenium\\chromedriver.exe");
	
	
		WebDriver driver = new ChromeDriver();      //upcasting
		
		driver.get("https://www.flipkart.com/"); //get.(string url):void-webdriverpackage selenium;

		Thread.sleep(2000);
		
		driver.manage().window().maximize();      //for maximize the method
		
		return driver;
		
	}

}

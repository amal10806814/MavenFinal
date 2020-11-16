package DemoTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Google {
	
	WebDriver driver;
	
	@Test
	public void verifyLinks()
	{
		
		System.setProperty("webdriver.chrome.driver", "/Users/Chaudhary/Documents/Drivers/chromedriver");
		
		driver = new ChromeDriver();
		
		driver.get("https://www.google.com/");
		
		driver.manage().window().maximize();
		
		List<WebElement> ll= driver.findElements(By.tagName("a"));
		
		for(int i =0 ; i < ll.size() ;i++)
		{
			ll.get(i).getText();
		}
		
	}

}

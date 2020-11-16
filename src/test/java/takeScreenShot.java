import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class takeScreenShot {
	
	WebDriver driver;
	
	@Test
	public void openBrowser() throws IOException
	{
		System.setProperty("webdriver.chrome.driver", "/Users/Chaudhary/Documents/Drivers/chromedriver");
		
		driver = new ChromeDriver();
		
		driver.get("https://www.google.com/");
		
		try{
			//driver.findElement(By.name("gsdsdsd")).sendKeys("sachin");
			
			//driver.findElement(By.name("q")).sendKeys("sachin");
		}
		catch(Exception e)
		{
			System.out.println("element not found");
			
			callScreenshot();
			
		}	
		
	}
	
	public void callScreenshot() throws IOException
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src , new File ("/Users/Chaudhary/Documents/Drivers/screenshot.png"));
	}

}

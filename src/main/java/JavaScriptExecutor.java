import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver;
		
		System.setProperty("webdriver.chrome.driver", "/Users/Chaudhary/Documents/Drivers/chromedriver");
		
		driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		
		JavascriptExecutor JS = (JavascriptExecutor)driver;
		// Enter username
		JS.executeScript("document.getElementById('email').value='amal'");
		// Enter password
		JS.executeScript("document.getElementById('pass').value='password123'");
		
		
	

	}

}

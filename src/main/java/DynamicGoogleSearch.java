import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DynamicGoogleSearch {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;
        WebDriverWait wait;
        String browser = "chrome";
        if(browser.equalsIgnoreCase("firefox"))
        {
            System.setProperty("webdriver.gecko.driver" , "D:\\ChromeDriver\\GeekoDriver\\geckodriver.exe");
            driver = new FirefoxDriver();
        }
        else
        {
            System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver\\new\\chromedriver.exe");
            driver = new ChromeDriver();
        }

        //driver.get("https://www.ebay.com/");
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

        List<WebElement> ll = driver.findElements(By.xpath("//ul[@role='listbox']//li//div//div/descendant::div[@class='sbl1']"));

        System.out.println(ll.size());

    }
}

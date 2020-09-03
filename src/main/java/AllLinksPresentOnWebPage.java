import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AllLinksPresentOnWebPage {

    public static void main(String[] args) {
        WebDriver driver;
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
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

        //way to find total links on page
        List<WebElement> ll = driver.findElements(By.tagName("a"));

       //List<WebElement> ll =driver.findElements(By.tagName("button"));

        System.out.println(ll.size());

        for(int i = 0 ; i < ll.size(); i++)
        {
            System.out.println(ll.get(i).getText());
        }

        driver.quit();
    }
}

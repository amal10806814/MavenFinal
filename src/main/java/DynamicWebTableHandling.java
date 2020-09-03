import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DynamicWebTableHandling {

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
        driver.get("https://ui.freecrm.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

        driver.findElement(By.name("email")).sendKeys("amal.chaudhary@gmail.com");
        driver.findElement(By.name("password")).sendKeys("Iphone#4567");
        driver.findElement(By.xpath("//div[text()= 'Login']")).click();

        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//span[text() ='Contacts']")).click();

           // Thread.sleep(1000);

                String beforeXpath = "/html/body/div[1]/div/div[2]/div[2]/div/div[2]/table/tbody/tr[";
                String afterXpath = "]/td[2]";

                wait = new WebDriverWait(driver, 20);
                 //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/table/tbody/tr[1]/td[2]")));

                //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/table/tbody/tr[1]/td[2]"))).click();

                //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/table/tbody/tr[1]/td[2]")));

                Boolean x = wait.until(ExpectedConditions.textToBe(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/table/tbody/tr[1]/td[2]"), "amal chaudhary1"));
                System.out.println(x);

                for(int i = 1 ; i <=2; i++)
                {

                   String name = driver.findElement(By.xpath(beforeXpath+i+afterXpath)).getText();
                    System.out.println(name);
                   if(name.contains("gaurav kumar"))
                   {

                       driver.findElement(By.xpath(beforeXpath+i+afterXpath)).click();
                   }
                }

        //driver.quit();
    }
}

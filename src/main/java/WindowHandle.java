import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WindowHandle {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver ;
        WebDriverWait wait;

        System.setProperty("webdriver.chrome.driver" , "/Users/Chaudhary/Documents/Drivers/chromedriver");

        driver = new ChromeDriver();

        //driver.get("https://demoqa.com/browser-windows");
        
        driver.get("https://www.nykaa.com/");

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

       String window1=  driver.getWindowHandle(); //getting current window uniqueID
        System.out.println(window1);

       // driver.findElement(By.id("messageWindowButton")).click();
        
//        Actions action = new Actions(driver);
//        
//        action.moveToElement(driver.findElement(By.xpath("//a[@target='_blank' and text(), 'makeup']"))).perform();

        //driver.findElement(By.linkText("makeup")).click();
        
        driver.findElement(By.xpath("//a[text()='makeup']")).click();
        
       Set<String> setWindow = driver.getWindowHandles(); //for multiple windows

        System.out.println(setWindow);

        for(String windowNew : setWindow)
        {
            System.out.println(windowNew);
            driver.switchTo().window(windowNew);  //switched to pop up window on loop 2 then close window
        }
  
        driver.findElement(By.xpath("//img[@alt='Own It Like Masaba Nail Enamel']")).click();
        
        Set<String> Windows_Makeup = driver.getWindowHandles(); 
        
        for(String makeup : Windows_Makeup)
        {
            System.out.println(makeup);
            driver.switchTo().window(makeup);  //switched to pop up window on loop 2 then close window
        }
        
        driver.findElement(By.xpath("//button[@class='combo-add-to-btn prdt-des-btn js--toggle-sbag nk-btn nk-btn-rnd atc-simple m-content__product-list__cart-btn  ']")).click();
        
       
        //driver.close();

      //  driver.switchTo().window(window1);

      //  driver.findElement(By.xpath("//img[@src= '/images/Toolsqa.jpg']")).click();

    }
}

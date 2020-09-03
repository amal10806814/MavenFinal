import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WindowHandle {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver ;
        WebDriverWait wait;

        System.setProperty("webdriver.chrome.driver" , "D:\\ChromeDriver\\new\\chromedriver.exe");

        driver = new ChromeDriver();

        driver.get("https://demoqa.com/browser-windows");

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

       String window1=  driver.getWindowHandle(); //getting current window uniqueID
        System.out.println(window1);

        driver.findElement(By.id("messageWindowButton")).click();

       Set<String> setWindow = driver.getWindowHandles(); //for multiple windows

        System.out.println(setWindow);

        for(String windowNew : setWindow)
        {
            System.out.println(windowNew);
            driver.switchTo().window(windowNew);  //switched to pop up window on loop 2 then close window
        }
        driver.close();

        driver.switchTo().window(window1);

        driver.findElement(By.xpath("//img[@src= '/images/Toolsqa.jpg']")).click();

    }
}

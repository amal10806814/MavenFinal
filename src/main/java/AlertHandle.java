import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class AlertHandle {
    public static void main(String[] args) {


        WebDriver driver ;
        WebDriverWait wait;

        System.setProperty("webdriver.chrome.driver" , "D:\\ChromeDriver\\new\\chromedriver.exe");

        driver = new ChromeDriver();

        driver.get("https://demoqa.com/alerts");

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

       // driver.findElement(By.xpath("//*[@id='item-1']")).click();

        driver.findElement(By.id("alertButton")).click();

        Alert al = driver.switchTo().alert();
        al.accept();

        driver.findElement(By.id("promtButton")).click();

      Alert al1=  driver.switchTo().alert();

        al1.sendKeys("amal chaudhary");
        al1.accept();
    }
}

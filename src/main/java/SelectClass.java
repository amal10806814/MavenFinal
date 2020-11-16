import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SelectClass {
    public static void main(String[] args) {

        WebDriver driver ;

        System.setProperty("webdriver.chrome.driver" , "D:\\ChromeDriver\\new\\chromedriver.exe");

        driver = new ChromeDriver();

        driver.get("https://www.facebook.com/");

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

        Select selDay = new Select(driver.findElement(By.id("day")));
         selDay.selectByVisibleText("3");
         

         Select selMonth = new Select(driver.findElement(By.id("month")));
         selMonth.selectByValue("3");

         Select selYear = new Select(driver.findElement(By.id("year")));
         selYear.selectByIndex(3);

         List<WebElement> allyearElement = selYear.getOptions();
        System.out.println(allyearElement.size());

         driver.findElement(By.name("sex") ).click();

         driver.findElement(By.name("websubmit")).click();

        List<WebElement> ButtonElement=  driver.findElements(By.tagName("button"));

        System.out.println(ButtonElement.size());


        driver.close();

    }
}

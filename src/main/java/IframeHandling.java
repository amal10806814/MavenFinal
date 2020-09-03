import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class IframeHandling {

    public static void main(String[] args) {

        WebDriver driver;

        System.setProperty("webdriver.chrome.driver" , "D:\\ChromeDriver\\new\\chromedriver.exe");

        driver = new ChromeDriver();

        driver.get("https://demoqa.com/frames");

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        List<WebElement> ll = driver.findElements(By.tagName("iframe"));
        System.out.println(ll.size());

        //we can also swtich to frame using iframe index, name attribute,id attribute ,webelement as well
        // driver.swtichTo.frame(1); -- command using frame index value to switch to a particular index
        driver.switchTo().frame("frame1");

       String text=  driver.findElement(By.id("sampleHeading")).getText();
        System.out.println(text);

        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//img[@src='/images/Toolsqa.jpg']")).click();

        //in order to switch between multiple frame , first switch to first frame then
        // using driver.switchTo().defaultContent , switch to main frame and then again
        // using swtich command switch to second frame
        // if we dont switch to main frame before moving to second frame
        // we will get NoSuchFrameException



        driver.close();

    }
}

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import sun.awt.SunHints;

import java.security.Key;
import java.util.concurrent.TimeUnit;

public class ActionsShiftKeyPress {

    public static void main(String[] args) {

        WebDriver driver;

        System.setProperty("webdriver.chrome.driver","D:\\ChromeDriver\\new\\chromedriver.exe");

        driver = new ChromeDriver();

        driver.get("https://demoqa.com/text-box");

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        WebElement userName = driver.findElement(By.id("userName"));
        Actions action = new Actions(driver);

        action.keyDown(userName, Keys.SHIFT).sendKeys("amal").perform();
        action.keyUp(Keys.SHIFT);

        // right click and double click

        driver.get("https://demoqa.com/buttons");

        action.contextClick(driver.findElement(By.id("rightClickBtn"))).perform();

        action.doubleClick(driver.findElement(By.id("doubleClickBtn"))).perform();

    // mouse hover over

        driver.get("https://demoqa.com/menu/");

        action.moveToElement(driver.findElement(By.xpath("//a[text()= 'Main Item 2']"))).perform();

        action.moveToElement(driver.findElement(By.xpath("//a[text()='SUB SUB LIST »']"))).perform();

        driver.findElement(By.xpath("//a[text()='Sub Sub Item 2']")).click();

        // drag and drop action
        driver.get("https://demoqa.com/droppable");

        WebElement w1 = driver.findElement(By.id("draggable"));
        WebElement w2 = driver.findElement(By.id("droppable"));

        action.dragAndDrop(w1, w2).perform();

        String s1 = w2.getText();
        System.out.println(s1);

        //dragabble

        driver.get("https://demoqa.com/dragabble");

        WebElement element1 = driver.findElement(By.id("dragBox"));

        int offset1 = element1.getLocation().getX();


        int offset2 = element1.getLocation().getY();

        System.out.println(offset1);
        System.out.println(offset2);

        action.dragAndDropBy(element1, 30, 10).perform();

    }
}

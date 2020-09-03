import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BrokenLinks {
    public static void main(String[] args) throws IOException {

        WebDriver driver ;

        System.setProperty("webdriver.chrome.driver" , "D:\\ChromeDriver\\new\\chromedriver.exe");

        driver = new ChromeDriver();

        driver.get("https://www.facebook.com/");

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

        List<WebElement> linklist = driver.findElements(By.tagName("a"));

        linklist.addAll(driver.findElements(By.tagName("img")));

        System.out.println(linklist.size());

        for(int p = 0 ; p< linklist.size(); p++)
        {
            System.out.println(linklist.get(p).getAttribute("href"));
        }

        ArrayList<WebElement> al = new ArrayList<WebElement>();

        for(int i = 0 ; i < linklist.size(); i++)
        {
            if(linklist.get(i).getAttribute("href") != null && !(linklist.get(i).getAttribute("href").contains("javascript")))
            {
                al.add(linklist.get(i));
                System.out.println(al.get(i).getAttribute("href"));
            }
        }
        System.out.println(al.size());

        for(int j =0 ; j< al.size(); j++)
        {
          HttpURLConnection connect =   (HttpURLConnection)new URL(al.get(j).getAttribute("href")).openConnection();
          String responsemessage = connect.getResponseMessage();
          connect.disconnect();
          System.out.println(al.get(j).getAttribute("href") + "---->" + responsemessage);
        }
    }
}

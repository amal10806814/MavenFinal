import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class HandleCalender {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver ;

        System.setProperty("webdriver.chrome.driver" , "D:\\ChromeDriver\\new\\chromedriver.exe");

        driver = new ChromeDriver();

        driver.get("https://demos.telerik.com/kendo-ui/calendar/index");

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//a[contains(text(), 'August 2020')]")).click();

        String beforeXpath = "//*[@id=\"calendar\"]/div[2]/table/tbody/tr[" ;
        String afterXpath = "]/td[" ;

        Boolean val = false;

        for(int i= 1 ; i <=3 ; i ++)
        {
            for (int j = 1; j <= 4; j++) {
                String month = driver.findElement(By.xpath(beforeXpath + i + afterXpath + j + "]/a")).getText();
                System.out.println(month);

                if (month.contains("Feb")) {
                    driver.findElement(By.xpath(beforeXpath + i + afterXpath + j + "]/a")).click();
                    val = true;
                    break;
                }
            }

            if (val) {
                break;
            }

        }

            //driver.findElement(By.xpath("//*[@id='calendar']/div[2]/table/tbody/tr[2]/td[2]/a")).click();

            //*[@id="calendar"]/div[2]/table/tbody/tr[1]/td[1]/a
            //*[@id="calendar"]/div[2]/table/tbody/tr[2]/td[2]/a

            String beforeXpath1 = "//*[@id=\"calendar\"]/div[2]/table/tbody/tr[" ;
            String afterXpath1 = "]/td[" ;
            String endingXpath = "]/a" ;

            String date = null;
            Boolean flag = false;

            WebDriverWait ww = new WebDriverWait(driver , 20);

            //*[@id="calendar"]/div[2]/table/tbody/tr[2]/td[2]/a

//           Boolean x =  ww.until(ExpectedConditions.textToBe(By.xpath("//*[@id='calendar']/div[2]/table/tbody/tr[2]/td[2]/a"), "3" ));
//            System.out.println(x);

            for(int k = 1 ; k <=5 ; k++)
            {
                for(int q = 1 ; q<=7; q++)
                {
                    try{
                         date = driver.findElement(By.xpath(beforeXpath1 + k + afterXpath1 + q + endingXpath)).getText();
                    }
                    catch (ElementNotInteractableException e)
                    {
                        System.out.println("date field disable ");
                        flag = false;
                        break;

                    }
                    //System.out.println(date);

                    if(date.contains("11"))
                    {
                        flag= true;
                        driver.findElement(By.xpath(beforeXpath1 + k + afterXpath1 + q + endingXpath)).click();
                    }
                }

                if(flag)
                {
                    break;
                }
            }

        }

    }
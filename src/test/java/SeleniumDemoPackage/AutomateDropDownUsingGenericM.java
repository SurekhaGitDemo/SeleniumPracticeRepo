package SeleniumDemoPackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class AutomateDropDownUsingGenericM {
       public static WebDriver driver;
    public static void main(String[] args) {

        WebDriverManager.firefoxdriver().setup();
        driver=new FirefoxDriver();
        driver.get("https://www.browserstack.com/guide/handling-dropdown-in-selenium-without-select-class"); //https://demoqa/select-menu
        driver.manage().window().maximize();

       WebElement Ddropdown=driver.findElement(By.xpath("//button[text()='Developers']"));
       Actions act=new Actions(driver);
       act.moveToElement(Ddropdown).perform();
       SdropDown("Champion");
       driver.close();

    }

    public static void SdropDown(String element)
    {
        List<WebElement> dropdwnlist= driver.findElements(By.xpath("//div[@class=\"bstack-mm-sub-li\"]//a"));
        int count=dropdwnlist.size();
        System.out.println(count);

        for(int i=0;i<count;i++)
        {
            if(dropdwnlist.get(i).getText().contains(element))
            {
                dropdwnlist.get(i).click();
                System.out.println("Element is Clicked");
                break;
            }
        }

    }

}

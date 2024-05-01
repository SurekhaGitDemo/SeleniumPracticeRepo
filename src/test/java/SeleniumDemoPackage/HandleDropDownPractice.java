package SeleniumDemoPackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class HandleDropDownPractice {

    static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        driver=new FirefoxDriver();

        driver.get("https://www.sugarcrm.com/au/request-demo/");

        driver.findElement(By.xpath("//button[text()=\"Accept All Cookies\"]")).click();

       List<WebElement> allOptions =driver.findElements(By.xpath("//select[@name=\"employees_c\"]//option"));
       System.out.println(allOptions.size());
        System.out.println("Second last value is: "+allOptions.get(allOptions.size()-4).getText());

       for(int i=0;i<allOptions.size();i++)
       {
           //if(allOptions.get(i).getText().contains("5,001 - 10,000 employees"))
           //{
               System.out.println("values are: "+allOptions.get(i).getText());
          // }
       }

       allOptions.get(allOptions.size()-5).click();

       Thread.sleep(5000);

        driver.close();


//
//        driver.findElement(By.xpath("//button[text()=\"Accept All Cookies\"]")).click();
//
//        WebElement dropDown=driver.findElement(By.xpath("//select[@name=\"employees_c\"]"));
//        Select ss=new Select(dropDown);
//
//        ss.selectByVisibleText("5,001 - 10,000 employees");
//
//        System.out.println("Value has been selected from dropdown");
//        driver.close();
    }
}

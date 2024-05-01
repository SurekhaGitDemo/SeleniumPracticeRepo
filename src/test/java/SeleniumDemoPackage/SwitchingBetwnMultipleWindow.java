package SeleniumDemoPackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class SwitchingBetwnMultipleWindow {

   static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        driver=new FirefoxDriver();
        driver.get("https://www.sugarcrm.com/au/request-demo/");
        driver.findElement(By.xpath("//button[text()=\"Accept All Cookies\"]")).click();

        driver.findElement(By.xpath("//input[@name=\"email\"]")).sendKeys("dhrdgf@gmail.com");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@name=\"firstname\"]")).sendKeys("abcd");
        driver.findElement(By.xpath("//input[@name=\"lastname\"]")).sendKeys("ghvjh");
        driver.findElement(By.xpath("//input[@name=\"phone_work\"]")).sendKeys("987654321");
        driver.findElement(By.xpath("//input[@name=\"title\"]")).sendKeys("new");
        driver.findElement(By.xpath("//input[@name=\"account_name\"]")).sendKeys("company");

        List<WebElement> comapnySize =driver.findElements(By.xpath("//select[@name=\"employees_c\"]//option"));
        comapnySize.get(comapnySize.size()-5).click();

        List<WebElement> comapnyInfo =driver.findElements(By.xpath("//select[@name=\"awareness_source_c\"]//option"));
        comapnyInfo.get(comapnyInfo.size()-6).click();

        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@value=\"Request a Demo\"]")).click();

        Thread.sleep(5000);
        WebElement frame1=driver.findElement(By.xpath("//iframe[@class=\"drift-frame-chat\"]"));
        driver.switchTo().frame(frame1);

        driver.findElement(By.xpath("//button[text()=\"Book a meeting\"]")).click();

        Thread.sleep(5000);

        //WebElement frame2=driver.findElement(By.xpath("//iframe[@class=\"drift-frame-chat\"]"));
       // driver.switchTo().frame("_hjSafeContext_31689393");
       // driver.switchTo().frame(frame2);
        driver.findElement(By.xpath("//span[text()=\"Thursday, May 2, 2024\"]")).click();

        //Thread.sleep(5000);
        driver.switchTo().frame(frame1);
        driver.findElement(By.xpath("//span[text()=\"2:00 AM\"]")).click();

        Thread.sleep(5000);
       String time= driver.findElement(By.xpath("//strong[@class=\"drift-meeting-confirmation--time\"]")).getText();
       System.out.println(time);
    }
}

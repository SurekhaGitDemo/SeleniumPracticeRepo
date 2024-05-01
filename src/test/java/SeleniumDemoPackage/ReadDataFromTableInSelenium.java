package SeleniumDemoPackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadDataFromTableInSelenium {

    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
      //  System.setProperty("webdriver.chrome.driver","C:\\Ddrive\\selenium_testing_practice\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationpanda.com/testing/");
       boolean conditionSuccess=Result("Ruby");
       System.out.println("found: "+conditionSuccess);
    }

    //Making a generic method
    public static boolean Result(String name)
    {
        WebElement element = driver.findElement(By.xpath("//figure[@class=\"wp-block-table\"]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
        int RowNum = driver.findElements(By.xpath("//figure[@class=\"wp-block-table\"][2]//tbody/tr")).size();
        int ColumnNum = driver.findElements(By.xpath("//figure[@class=\"wp-block-table\"][2]//tbody/tr[1]//td")).size();


        for (int i = 1; i < RowNum; i++) {
            for (int j = 1; j <= ColumnNum; j++) {

                //String xpath="//figure[@class=\"wp-block-table\"][2]//tbody/tr["+i+"]/td["+j+"]";
                String actualValue = driver.findElement(By.xpath("//figure[@class='wp-block-table'][2]//tbody/tr[" + i + "]/td[" + j + "]")).getText();
                //System.out.println("valFrom: " + actualValue);
                if (actualValue.equals(name)) {
                    System.out.println("Element found: " + actualValue);
                    driver.close();
                    return true;
                }
            }
        }
return false;
    }
}

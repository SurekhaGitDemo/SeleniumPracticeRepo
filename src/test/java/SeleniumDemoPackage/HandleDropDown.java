package SeleniumDemoPackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class HandleDropDown {
    public static void main(String[] args) {

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.goindigo.in/");
        driver.manage().window().maximize();

        WebElement element = driver.findElement(By.xpath("//input[@placeholder=\"From\"]"));
        element.click();
        element.sendKeys("Mumbai(BOM)");

        List<WebElement> alloptions=driver.findElements(By.xpath("//div[text()='Chhatrapati Shivaji Maharaj International Airport']"));

        for(int i=0;i<alloptions.size();i++)
        {
            String text=alloptions.get(i).getText();
            System.out.println(text);
            if(text.contains("Mumbai"))
            {
                alloptions.get(i).click();
                break;
            }
        }


    }

}

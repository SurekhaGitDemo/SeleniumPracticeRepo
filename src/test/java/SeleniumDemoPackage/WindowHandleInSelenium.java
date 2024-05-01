package SeleniumDemoPackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Set;

public class WindowHandleInSelenium
{
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");

        WebElement element = driver.findElement(By.id("newWindowBtn"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);

        String parentWindow=driver.getWindowHandle(); //it will give unique string of currently focus parent window i.e. window handle of parent window
        System.out.println("Currently focus Parent Window handle: "+parentWindow);
        driver.findElement(By.id("newWindowBtn")).click();
        Set<String> AllWindowHandles= driver.getWindowHandles(); //it will have handles of all window including parent window
        System.out.println(AllWindowHandles);
        for(String handle: AllWindowHandles)
        {
            //System.out.println("Child Window handles: " + handle);
            if(!parentWindow.equals(handle)) {
                driver.switchTo().window(handle);
                System.out.println("Child windows are "+driver.switchTo().window(handle).getTitle());
                driver.findElement(By.id("firstName")).sendKeys("ABCD");
                Thread.sleep(2000);
                driver.close();
            }
        }
        driver.switchTo().window(parentWindow);
        driver.findElement(By.id("name")).sendKeys("We are back to the parent window");
        driver.close();
    }
}

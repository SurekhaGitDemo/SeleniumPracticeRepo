package SeleniumDemoPackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FramesHandle {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.hyrtutorials.com/p/frames-practice.html");
        driver.findElement(By.className("frmTextBox")).sendKeys("mainWebpage");
        driver.switchTo().frame(driver.findElement(By.id("frm3")));
        driver.findElement(By.className("frmTextBox")).sendKeys("InsideFrame3");
        driver.switchTo().frame(driver.findElement(By.id("frm1")));

        Thread.sleep(3000);
        WebElement dropd=driver.findElement(By.id("course"));
        Select dropdown = new Select(dropd);
        dropdown.selectByVisibleText("Java");

        Thread.sleep(3000);
        driver.switchTo().parentFrame();
        driver.findElement(By.className("frmTextBox")).clear();
        driver.findElement(By.className("frmTextBox")).sendKeys("Back to the frame3 main window");

        Thread.sleep(3000);
        driver.switchTo().defaultContent();
        driver.findElement(By.className("frmTextBox")).clear();
        driver.findElement(By.className("frmTextBox")).sendKeys("Finally done!! Root window");

        Thread.sleep(3000);
        driver.close();
    }
}

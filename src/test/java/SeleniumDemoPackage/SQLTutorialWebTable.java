package SeleniumDemoPackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SQLTutorialWebTable {
    static WebDriver driver;
    public static void main(String[] args)
    {
        WebDriverManager.firefoxdriver().setup();
        driver=new FirefoxDriver();
        driver.get("https://cosmocode.io/automation-practice-webtable/");
        driver.manage().window().maximize();

        int rowCount=driver.findElements(By.xpath("//table[@id=\"countries\"]//tr")).size();
        System.out.println("Row Count of table is : "+rowCount);

        int columnCount=driver.findElements(By.xpath("//table[@id=\"countries\"]//tr[1]//td")).size();
        System.out.println("Column Count of table is : "+columnCount);



     for(int i=1;i<=rowCount;i++) {
    for (int j=1;j<=columnCount;j++) {
        String tableData = driver.findElement(By.xpath("//table[@id=\"countries\"]//tr["+i+"]//td["+j+"]")).getText();
        System.out.print(tableData+"      ");
    }
    System.out.println();

}
        driver.close();
    }
}

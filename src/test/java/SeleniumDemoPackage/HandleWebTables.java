package SeleniumDemoPackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class HandleWebTables {

    static WebDriver driver;
    public static void main(String[] args) {

        WebDriverManager.firefoxdriver().setup();
         driver = new FirefoxDriver();
        driver.manage().window().maximize();

        driver.get("https://www.w3schools.com/html/html_tables.asp");
        System.out.println(CountRowColumn("Francisco Chang"));
      //  driver.close();
    }


    public static boolean CountRowColumn(String name){
        int rowCount=driver.findElements(By.xpath("//table[@class=\"ws-table-all\"]//tr")).size();
        System.out.println("rowCount : "+rowCount);
        int columnCount=driver.findElements(By.xpath("//table[@class=\"ws-table-all\"]//th")).size();
        System.out.println("columnCount : "+columnCount);
        boolean flag=false;

        //String actualVal = driver.findElement(By.xpath("//table[@class=\"ws-table-all\"]//tr["+i+"]//td["+j+"]")).getText();
        for (int i=2;i<=rowCount;i++){
        for(int j=1;j<=columnCount;j++) {
            String actualVal = driver.findElement(By.xpath("//table[@class=\"ws-table-all\"]//tr["+i+"]//td["+j+"]")).getText();
            System.out.print(actualVal+ " ");
            if (actualVal.equals(name)) {
                flag = true;
                System.out.println(name+" is present on row :"+i+" and column : "+j);
                break;
            }
        }
        System.out.println();
        }
        if(flag) {
            return true;
        }
        return flag;

    }

}

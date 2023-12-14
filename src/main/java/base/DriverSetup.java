package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class DriverSetup {

    public static WebDriver driver;

    @BeforeSuite

    public static void setDriver()
    {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        /*driver.navigate().to("http://139.59.35.127:3000/");
        driver.manage().window().maximize();*/
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2) );

    }


    @AfterSuite
    public static void closeWindow()
    {
       // driver.quit();
    }




}

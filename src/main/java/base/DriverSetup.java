package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); //Runs in headless mode for CI/CD
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2) );

    }


    @AfterSuite
    public static void closeWindow()
    {
        driver.quit();
    }




}

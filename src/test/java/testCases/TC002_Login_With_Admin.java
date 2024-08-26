package testCases;

import base.DriverSetup;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TC002_Login_With_Admin extends DriverSetup {

    String baseUrl="https://uatapp.propsoft.ai";

    @Test
    public void loginWithAdmin() throws InterruptedException {
        driver.get(baseUrl);
        driver.manage().window().maximize();

        driver.findElement(By.id("user_email_address")).sendKeys("mrmanager@gmail.com");
        driver.findElement(By.id("user_password")).sendKeys("12345678");
        driver.findElement(By.xpath("//input[contains(@class, 'ccb-blue') and contains(@class, 'ccb-full')]")).click();
        Thread.sleep(2000);

        String currentUrl=driver.getCurrentUrl();
        String expectedUrl="https://uatapp.propsoft.ai/dashboard";

        SoftAssert softly = new SoftAssert();
        softly.assertEquals(currentUrl,expectedUrl) ;
        softly.assertAll();



    }
}

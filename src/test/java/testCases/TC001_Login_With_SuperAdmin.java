package testCases;

import base.DriverSetup;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TC001_Login_With_SuperAdmin extends DriverSetup {

    String  baseUrl="https://awsuatapp.propsoft.ai/";

    @Test
    public void login() throws InterruptedException {
        driver.get(baseUrl);
        driver.manage().window().maximize();


        driver.findElement(By.id("user_email_address")).sendKeys("support@propsoft.ai");
        driver.findElement(By.id("user_password")).sendKeys("123456789");
        driver.findElement(By.xpath("//input[contains(@class, 'ccb-blue') and contains(@class, 'ccb-full')]")).click();
        Thread.sleep(5000);

        String currentUrl=driver.getCurrentUrl();
        String expectedUrl="https://awsuatapp.propsoft.ai/dashboard";

        SoftAssert softly = new SoftAssert();
        softly.assertEquals(currentUrl,expectedUrl) ;
        softly.assertAll();


    }



}

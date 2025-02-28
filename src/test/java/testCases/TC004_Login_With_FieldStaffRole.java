package testCases;

import base.DriverSetup;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TC004_Login_With_FieldStaffRole extends DriverSetup {


    String  baseUrl="https://awsuatapp.propsoft.ai/";

    @Test
    public void loginWithFieldStaffRole() throws InterruptedException {
        driver.get(baseUrl);
        driver.manage().window().maximize();


        driver.findElement(By.id("user_email_address")).sendKeys("khurshedFS@gmail.com");
        driver.findElement(By.id("user_password")).sendKeys("12345678");
        driver.findElement(By.xpath("//input[contains(@class, 'ccb-blue') and contains(@class, 'ccb-full')]")).click();
        Thread.sleep(2000);

        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "https://awsuatapp.propsoft.ai/dashboard";

        SoftAssert softly = new SoftAssert();
        softly.assertEquals(currentUrl, expectedUrl);
        softly.assertAll();
    }
}

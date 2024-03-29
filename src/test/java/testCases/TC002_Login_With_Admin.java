package testCases;

import base.DriverSetup;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TC002_Login_With_Admin extends DriverSetup {

    String baseUrl="http://139.59.35.127:3000/";

    @Test
    public void loginWithAdmin() throws InterruptedException {
        driver.get(baseUrl);
        driver.manage().window().maximize();

        driver.findElement(By.id("user_email_address")).sendKeys("mrmanager@gmail.com");
        driver.findElement(By.id("user_password")).sendKeys("12345678");
        driver.findElement(By.xpath("//body/div[@id='__next']/div[1]/div[1]/div[1]/form[1]/div[4]/div[1]/div[1]/input[1]")).click();
        Thread.sleep(2000);

        String currentUrl=driver.getCurrentUrl();
        String expectedUrl="http://139.59.35.127:3000/dashboard";

        SoftAssert softly = new SoftAssert();
        softly.assertEquals(currentUrl,expectedUrl) ;
        softly.assertAll();



    }
}

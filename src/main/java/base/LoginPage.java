package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class LoginPage {

    public WebDriver driver=null;

    public LoginPage(WebDriver driver)
    {
        this.driver=driver;
    }

    public WebElement emailField()
    {
        return driver.findElement(By.xpath("//input[@type='email' and @id='user_email_address']"));
    }

    public WebElement passWordField(){
        return driver.findElement(By.id("user_password"));
    }

    public WebElement btnLogin(){
        return driver.findElement(By.xpath("//input[@value = 'Login']"));
    }

    public void doLogin(){
        String  baseUrl="http://139.59.35.127:3000/";
        driver.navigate().to(baseUrl);
        driver.manage().window().maximize();
        emailField().click();
        emailField().sendKeys("dhaka@gmail.com");
        passWordField().click();
        passWordField().sendKeys("12345678");
        btnLogin().click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
}

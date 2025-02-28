package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CardProfileDropDown {
    public WebDriver driver;

    public CardProfileDropDown(WebDriver driver){
        this.driver=driver;
    }

    public WebElement Cardprofileclick() throws InterruptedException {
        Thread.sleep(1000);
        return driver.findElement(By.xpath("//span[@class='link-arrow']"));
    }
    public WebElement userList() throws InterruptedException {
        Thread.sleep(1000);
        return driver.findElement(By.xpath("//a[text()='User List']"));
    }


    public void ClickOnCardprofileDropdown() throws InterruptedException {
        Cardprofileclick().click();
    }
    public void goToUserlistpage() throws InterruptedException {
        userList().click();
    }
}

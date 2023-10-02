package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserListPage {

    public WebDriver driver;

    public UserListPage(WebDriver driver){
        this.driver=driver;
    }


    public WebElement newInvitaion(){
        return driver.findElement(By.xpath("//span[contains(text(),'New Invitation')]"));
    }

    public void goToNewInvite(){
        newInvitaion().click();
    }
}

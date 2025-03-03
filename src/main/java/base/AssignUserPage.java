package base;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AssignUserPage {

    public WebDriver driver;

    public AssignUserPage(WebDriver driver)
    {
        this.driver=driver;
    }

    public WebElement AssignUserBtn()
    {
        return driver.findElement(By.xpath("//span[contains(text(),'Assign Users')]"));
    }

    public void goToAssignUser(){
        AssignUserBtn().click();

    }

    public WebElement AssignUserModal(){
        return driver.findElement(By.xpath("//input[contains(@id,'react-select')]"));
    }

    public WebElement AddClient(){
        return driver.findElement(By.xpath("//button[contains(text(),'Add to Project')]") );
    }

    public void goToAddClient() throws InterruptedException {

       AssignUserBtn().click();
       Thread.sleep(5000);
       //AssignUserModal().sendKeys(Keys.ENTER);
       //Thread.sleep(2000);
        AssignUserModal().click();
       AssignUserModal().sendKeys("Client");
       Thread.sleep(5000);
       AssignUserModal().sendKeys(Keys.ENTER);
       Thread.sleep(2000);
        AddClient().click();
    }
}

package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.nio.file.Watchable;

public class ManageOrganization {

    public WebDriver driver;

    public ManageOrganization(WebDriver driver){

        this.driver=driver;
    }

    public WebElement userProfile(){
        return driver.findElement(By.xpath("//body/div[@id='__next']/main[@id='master_container']/nav[1]/div[1]/div[1]/div[1]/ul[2]/li[1]/a[1]/div[1]/div[1]"));
    }

    public WebElement manageOrganizationBtn(){
        return driver.findElement(By.xpath("//body/div[@id='__next']/main[@id='master_container']/nav[1]/div[1]/div[1]/div[1]/ul[2]/li[1]/div[1]/a[6]"));
    }

    public WebElement addOrganizationBtn(){
        return driver.findElement(By.xpath("//body/div[@id='__next']/main[@id='master_container']/div[2]/main[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/button[1]") );
    }

    public WebElement addOrganizationModal(){
        return driver.findElement(By.xpath("//input[@placeholder='Enter Organization Name']"));
    }

    public WebElement saveBtn(){
        return driver.findElement(By.xpath("//button[contains(text(),'Save')]"));

    }

    public void doAddNewProject(){
        userProfile().click();
        manageOrganizationBtn().click();
        addOrganizationBtn().click();
        addOrganizationModal().sendKeys("new test Organization");
        saveBtn().click();

    }







}

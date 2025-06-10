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

    public WebElement allSettings(){

        return driver.findElement(By.xpath("//a[@href='/all_settings']"));

    }

    public WebElement manageOrganizationBtn(){
        return driver.findElement(By.xpath("//a[text()='Manage Client']"));
    }

    public WebElement addOrganizationBtn(){
        return driver.findElement(By.xpath("//button[contains(text(),' Add New Client')]") );
    }

    public WebElement addOrganizationModal(){
        return driver.findElement(By.xpath("//input[@placeholder='Enter Client Name']"));
    }

    public WebElement addOrganizationCode(){
        return driver.findElement(By.xpath("//input[@placeholder='Enter Client Code']"));
    }

    public WebElement saveBtn(){
        return driver.findElement(By.xpath("//button[contains(text(),'Save')]"));

    }

    public void doAddNewProject() throws InterruptedException {
        CardProfileDropDown cardProfileDropDown=new CardProfileDropDown(driver);
        Thread.sleep(5000);
        cardProfileDropDown.ClickOnCardprofileDropdown();
        allSettings().click();
        //userProfile().click();
        manageOrganizationBtn().click();
        addOrganizationBtn().click();
        addOrganizationModal().sendKeys(java.util.UUID.randomUUID().toString().substring(0,10));
        addOrganizationCode().click();
        addOrganizationCode().sendKeys(java.util.UUID.randomUUID().toString().substring(0,10));
        saveBtn().click();

    }







}

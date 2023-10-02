package testCases;

import base.DriverSetup;
import base.LoginPage;
import base.SidebarPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC007_ProjectCreationTest extends DriverSetup {



    @Test
    public void userShouldBeAbleToCreatePage_ThroughPopUpModalLocationSearch() throws InterruptedException {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.doLogin();

        SidebarPage sidebarPage = new SidebarPage(driver);
        sidebarPage.goToProjects();

        WebElement CreateProjectBtn = driver.findElement(By.xpath("//span[contains(text(), 'Create Project')]"));
        CreateProjectBtn.click();

       // Thread.sleep(5000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        By searchBoxLocator = By.xpath("//body/div[3]/div[1]/div[1]/div[2]/input[1]");

        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(searchBoxLocator));
        element.click();
        String searchedLocation="badda,Bangladesh";
        element.sendKeys(searchedLocation);
        element.sendKeys(Keys.ARROW_DOWN);
        element.sendKeys(Keys.ENTER);

        Thread.sleep(2000);
        WebElement projectAddress1=driver.findElement(By.id("ProjectAddress1"));
        projectAddress1.sendKeys("badda,Bangladesh");

        Thread.sleep(2000);
        WebElement csa= driver.findElement(By.id("CSA"));
        csa.sendKeys("100");

        Thread.sleep(2000);
        WebElement evp=driver.findElement(By.id("EVP"));
        evp.sendKeys("80");

        Thread.sleep(1000);
        By clientOrganizationDropDown=By.xpath("//input[@name= 'bidAmount']/following::input[1]");

        WebElement clientOrganizationDropDownWait=wait.until(ExpectedConditions.elementToBeClickable(clientOrganizationDropDown));
        clientOrganizationDropDownWait.sendKeys(Keys.ARROW_DOWN);
        clientOrganizationDropDownWait.sendKeys(Keys.ENTER);

        Thread.sleep(1000);
        By contactPersonDropDown=By.xpath("//input[@name= 'bidAmount']/following::input[3]");

        WebElement contactPersonDropDownWait=wait.until(ExpectedConditions.elementToBeClickable(contactPersonDropDown));
        Thread.sleep(1000);
        contactPersonDropDownWait.sendKeys(Keys.ENTER);
        contactPersonDropDownWait.sendKeys(Keys.ARROW_DOWN);
        contactPersonDropDownWait.sendKeys(Keys.ENTER);

        Thread.sleep(2000);
        By orderTypeDropDown=By.xpath("//input[@name= 'bidAmount']/following::input[5]");

        WebElement orderTypeDropDownWait=wait.until(ExpectedConditions.elementToBeClickable(orderTypeDropDown));
        orderTypeDropDownWait.sendKeys(Keys.ARROW_DOWN);
        orderTypeDropDownWait.sendKeys(Keys.ENTER);



        Thread.sleep(2000);
        WebElement WO=driver.findElement(By.id("WO_No"));
        WO.sendKeys("W-123");

        Thread.sleep(2000);
        WebElement lockbox=driver.findElement(By.id("Lockbox"));
        lockbox.sendKeys("123");

        Thread.sleep(2000);
        WebElement btnSubmitClick=driver.findElement(By.xpath("//button[contains(text(),'Create Project')]"));
        btnSubmitClick.sendKeys(Keys.ENTER);















    }


}

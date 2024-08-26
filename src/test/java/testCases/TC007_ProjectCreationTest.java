package testCases;

import base.DriverSetup;
import base.LoginPage;
import base.SidebarPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

        Thread.sleep(5000);
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

        Thread.sleep(5000);
        WebElement projectAddress1=driver.findElement(By.id("ProjectAddress1"));
        //projectAddress1.sendKeys("badda,Bangladesh");
        projectAddress1.sendKeys(java.util.UUID.randomUUID().toString().substring(0, 10));

       /* Thread.sleep(2000);
        WebElement csa= driver.findElement(By.id("CSA"));
        csa.sendKeys("100");*/

      /*  Thread.sleep(2000);
        WebElement evp=driver.findElement(By.id("EVP"));
        evp.sendKeys("80");*/

        Thread.sleep(1000);
        By clientOrganizationDropDown=By.xpath("//input[@name= 'bidAmount']/following::input[1]");

        WebElement clientOrganizationDropDownWait=wait.until(ExpectedConditions.elementToBeClickable(clientOrganizationDropDown));
        clientOrganizationDropDownWait.sendKeys(Keys.ARROW_DOWN);
        clientOrganizationDropDownWait.sendKeys(Keys.ENTER);

        Thread.sleep(1000);
        By contactPersonDropDown=By.xpath("//input[@name= 'bidAmount']/following::input[3]");

        WebElement contactPersonDropDownWait=wait.until(ExpectedConditions.elementToBeClickable(contactPersonDropDown));
        Thread.sleep(1000);
        //contactPersonDropDownWait.sendKeys(Keys.ENTER);
        contactPersonDropDownWait.sendKeys(Keys.ARROW_DOWN);
        /*contactPersonDropDownWait.sendKeys(Keys.ARROW_DOWN);
        contactPersonDropDownWait.sendKeys(Keys.ARROW_DOWN);
        contactPersonDropDownWait.sendKeys(Keys.ARROW_DOWN);
        contactPersonDropDownWait.sendKeys(Keys.ARROW_DOWN);
        contactPersonDropDownWait.sendKeys(Keys.ARROW_DOWN);*/
        contactPersonDropDownWait.sendKeys(Keys.ENTER);

        Thread.sleep(2000);
       /* By assignUser=By.xpath("//body/div[@id='__next']/main[@id='master_container']/div[2]/main[1]/form[1]/div[1]/div[2]/div[11]/div[1]/div[1]/div[1]");
        Thread.sleep(5000 );
        WebElement assignUserWait=wait.until(ExpectedConditions.elementToBeClickable(assignUser));
        assignUserWait.sendKeys(Keys.ENTER);
        assignUserWait.sendKeys(Keys.ARROW_DOWN);
        assignUserWait.sendKeys(Keys.ENTER);*/


/*        // Define the XPath for the element
        By assignUser = By.xpath("//body/div[@id='__next']/main[@id='master_container']/div[2]/main[1]/form[1]/div[1]/div[2]/div[11]/div[1]/div[1]/div[1]");

// Use explicit wait to wait until the element is clickable
        WebElement assignUserWait = wait.until(ExpectedConditions.elementToBeClickable(assignUser));

// Now perform the actions on the element
        assignUserWait.click();  // Use click instead of sendKeys(Keys.ENTER) for better clarity

// Wait for the dropdown options to be visible, if necessary
        Thread.sleep(500); // You may still need a short sleep here, depending on how fast the dropdown appears*/
        Thread.sleep(5000);
        WebElement assignUser = driver.findElement(By.xpath("//div[@class='form-field two-input']//input[@id='react-select-4-input']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", assignUser);
// Navigate through the dropdown options
        assignUser.sendKeys(Keys.ARROW_DOWN);
        assignUser.sendKeys(Keys.ENTER);


        Thread.sleep(4000);
        By orderTypeDropDown=By.xpath("//div[@class='form-field two-input']//div[@class='css-13cywwt-control']//div[@class='css-19bb58m']");

        WebElement orderTypeDropDownWait=wait.until(ExpectedConditions.elementToBeClickable(orderTypeDropDown));
        orderTypeDropDownWait.sendKeys(Keys.ARROW_DOWN);
        orderTypeDropDownWait.sendKeys(Keys.ENTER);



        /*Thread.sleep(5000);
        WebElement WO=driver.findElement(By.id("WO_No"));
        WO.sendKeys("W-123");*/

        Thread.sleep(2000);
        WebElement lockbox=driver.findElement(By.id("Lockbox"));
        lockbox.sendKeys("123");

        Thread.sleep(2000);
        WebElement btnSubmitClick=driver.findElement(By.xpath("//button[contains(text(),'Create Project')]"));
        btnSubmitClick.sendKeys(Keys.ENTER);






    }


}

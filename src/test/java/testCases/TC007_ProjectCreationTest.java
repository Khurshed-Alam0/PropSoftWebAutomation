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

      /*  Thread.sleep(5000);
        WebElement CreateProjectBtn = driver.findElement(By.xpath("//span[contains(text(), 'Create Project')]"));

        CreateProjectBtn.click();*/

// Initialize WebDriverWait with a timeout of 10 seconds
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

  /*      // Clear cookies and local storage before each iteration
        driver.manage().deleteAllCookies();
        ((JavascriptExecutor) driver).executeScript("window.localStorage.clear();");*/

// Wait for the "Create Project" button to be clickable
        WebElement createProjectBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(), 'Create Project')]")));

// Once the button is clickable, click it
        createProjectBtn.click();



        WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));
        By searchBoxLocator = By.xpath("//body/div[3]/div[1]/div[1]/div[2]/input[1]");

        WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(searchBoxLocator));
        element.click();
        String searchedLocation="badda,Bangladesh";
        element.sendKeys(searchedLocation);
        element.sendKeys(Keys.ARROW_DOWN);
        element.sendKeys(Keys.ENTER);

        Thread.sleep(1000);
        WebElement projectAddress1=driver.findElement(By.id("ProjectAddress1"));
        //projectAddress1.sendKeys("badda,Bangladesh");
        projectAddress1.sendKeys(java.util.UUID.randomUUID().toString().substring(0, 10));

       /* Thread.sleep(2000);
        WebElement csa= driver.findElement(By.id("CSA"));
        csa.sendKeys("100");*/

      /*  Thread.sleep(2000);
        WebElement evp=driver.findElement(By.id("EVP"));
        evp.sendKeys("80");*/

        Thread.sleep(2000);
        By clientOrganizationDropDown=By.xpath("//input[@id='react-select-2-input']");
        WebElement clientOrganizationDropDownWait=wait.until(ExpectedConditions.elementToBeClickable(clientOrganizationDropDown));
        clientOrganizationDropDownWait.sendKeys(Keys.ARROW_DOWN);
        clientOrganizationDropDownWait.sendKeys(Keys.ENTER);

        Thread.sleep(500);
        By contactPersonDropDown=By.xpath("//input[@id='react-select-3-input']");

        WebElement contactPersonDropDownWait=wait.until(ExpectedConditions.elementToBeClickable(contactPersonDropDown));
        Thread.sleep(1000);
        contactPersonDropDownWait.sendKeys(Keys.ENTER);
        contactPersonDropDownWait.sendKeys(Keys.ARROW_DOWN);
        contactPersonDropDownWait.sendKeys(Keys.ENTER);

        Thread.sleep(1000);
        WebElement assignUser = driver.findElement(By.xpath("//div[@class='form-field two-input']//input[@id='react-select-4-input']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", assignUser);
        // Navigate through the dropdown options
        assignUser.sendKeys(Keys.ARROW_DOWN);
        assignUser.sendKeys(Keys.ENTER);


        // Initialize WebDriverWait
        WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Locate the input field within the custom dropdown
        By orderTypeInput = By.id("react-select-5-input");
        WebElement orderTypeInputElement = wait.until(ExpectedConditions.elementToBeClickable(orderTypeInput));

        // Focus the dropdown input field
        orderTypeInputElement.click();

        // Option 1: Use keypresses to select an option
        orderTypeInputElement.sendKeys(Keys.ARROW_DOWN);  // Navigate to the desired option
        orderTypeInputElement.sendKeys(Keys.ENTER);       // Confirm the selection

        // Option 2: Select option by visible text (uncomment if needed)
        // By desiredOption = By.xpath("//div[text()='After Turn']");  // Replace with the actual option text
        // WebElement optionElement = wait.until(ExpectedConditions.elementToBeClickable(desiredOption));
        // optionElement.click();


        /*Thread.sleep(5000);
        WebElement WO=driver.findElement(By.id("WO_No"));
        WO.sendKeys("W-123");*/

        /*Thread.sleep(500);
        WebElement lockbox=driver.findElement(By.id("Lockbox"));
        lockbox.sendKeys("123");*/

        Thread.sleep(500);
        WebElement btnSubmitClick=driver.findElement(By.xpath("//button[contains(text(),'Create Project')]"));
        btnSubmitClick.sendKeys(Keys.ENTER);


    }


}

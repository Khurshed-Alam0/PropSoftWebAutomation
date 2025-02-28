package Estimate;

import base.DriverSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import testCases.TC007_ProjectCreationTest;

import java.time.Duration;

public class TC002_UserShouldAbleToCreateEstimateThroughImportExcel extends DriverSetup {

    @Test
    public void userShouldAbleToCreateEstimateThroughImportExcel() throws InterruptedException {

        TC007_ProjectCreationTest createProject=new TC007_ProjectCreationTest();
        createProject.userShouldBeAbleToCreatePage_ThroughPopUpModalLocationSearch();

        Thread.sleep(5000);
        WebElement tabEstimate=driver.findElement(By.id("projectsTabs-tab-Estimate"));
        tabEstimate.click();

        Thread.sleep(5000);
/*        WebElement btnCreateEstimate= driver.findElement(By.xpath("//body/div[@id='__next']/main[@id='master_container']/div[2]/main[1]/div[1]/div[2]/div[1]/div[2]/div[4]/div[1]/div[1]/div[1]/div[1]"));
        btnCreateEstimate.click();*/

        // Initialize the WebDriverWait object
        WebDriverWait  wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Locate the "Create Estimate" button using XPath
        By createEstimateButton = By.xpath("//div[contains(@class, 'btn-container')]//button[contains(@class, 'psb-primary') and contains(., 'Create Estimate')]");

        // Wait for the button to be clickable
        WebElement createEstimateButtonElement = wait.until(ExpectedConditions.elementToBeClickable(createEstimateButton));

        // Click the button
        createEstimateButtonElement.click();

        Thread.sleep(2000);
        WebElement fileInput= driver.findElement(By.xpath("//input[@type='file']"));
        String filePath = ("D:/KHURSHED/ProftSoft.ai/Create_Estimate/Estimate_dummy_format(current).xlsx");
        fileInput.sendKeys(filePath);


        WebElement selectAllButton=driver.findElement(By.id("test"));
        selectAllButton.click();

        WebElement markUpButtonModal= driver.findElement(By.xpath("//button[@type='button' and contains(text(),'Mark Up')]"));
        markUpButtonModal.click();

        Thread.sleep(2000);
        WebElement markupValue= driver.findElement(By.xpath("//input[@type='number' and @name='markup']"));
        markupValue.click();
        markupValue.sendKeys("50");


        // Initialize WebDriverWait with a timeout of 10 seconds
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Define the XPath for the "Save" button
        By saveButton = By.xpath("//button[@type='button' and contains(@class, 'btn ccb-blue') and text()='Save']");

        // Wait until the "Save" button is clickable
        WebElement saveButtonElement = wait1.until(ExpectedConditions.elementToBeClickable(saveButton));

        // Click the "Save" button
        saveButtonElement.click();




        WebElement createEstimateButtonClick= driver.findElement(By.xpath("//button[contains(text(),'Create Estimate')]"));
        createEstimateButtonClick.click();



    }


}

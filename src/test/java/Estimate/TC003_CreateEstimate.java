package Estimate;

import base.DriverSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import testCases.TC007_ProjectCreationTest;

import java.time.Duration;

public class TC003_CreateEstimate extends DriverSetup {

    @Test
    public void userShouldAbleToCreateEstimateManual() throws InterruptedException {

        TC007_ProjectCreationTest createProject = new TC007_ProjectCreationTest();
        try {
            createProject.userShouldBeAbleToCreatePage_ThroughPopUpModalLocationSearch();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Thread.sleep(2000);
        WebElement tabEstimate = driver.findElement(By.id("projectsTabs-tab-Estimate"));
        tabEstimate.click();

     /*   Thread.sleep(5000);
        WebElement btnCreateEstimate= driver.findElement(By.xpath("//button[contains(@class, 'psb-primary') and contains(text(), 'Create Estimate')"));
        btnCreateEstimate.click();*/

        // Initialize the WebDriverWait object
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Locate the "Create Estimate" button using XPath
        By createEstimateButton = By.xpath("//div[contains(@class, 'btn-container')]//button[contains(@class, 'psb-primary') and contains(., 'Create Estimate')]");

        // Wait for the button to be clickable
        WebElement createEstimateButtonElement = wait.until(ExpectedConditions.elementToBeClickable(createEstimateButton));

        // Click the button
        createEstimateButtonElement.click();


        Thread.sleep(2000);
        WebElement lineItem0 = driver.findElement(By.id("line_item_name0"));
        lineItem0.sendKeys("1");

        WebElement locationAndNotes = driver.findElement(By.id("location_note0"));
        locationAndNotes.sendKeys("1");

        WebElement unit0 = driver.findElement(By.id("unit0"));
        unit0.sendKeys("1");

        WebElement markup0 = driver.findElement(By.id("markup0"));
        markup0.sendKeys("1");

        WebElement addRow1 = driver.findElement(By.xpath("//body/div[@id='__next']/main[@id='master_container']/div[2]/main[1]/div[1]/div[1]/div[2]/div[1]/div[1]/table[1]/tfoot[1]/tr[2]/td[1]/div[1]/i[1]"));
        addRow1.click();

        WebElement lineItem1 = driver.findElement(By.id("line_item_name1"));
        lineItem1.sendKeys("2");

        WebElement locationAndNotes1 = driver.findElement(By.id("location_note1"));
        locationAndNotes1.sendKeys("2");

        WebElement unit1 = driver.findElement(By.id("unit1"));
        unit1.sendKeys("2");

        WebElement markup1 = driver.findElement(By.id("markup1"));
        markup1.sendKeys("2");

        WebElement createEstimateButtonClick = driver.findElement(By.xpath("//button[contains(text(),'Create Estimate')]"));
        createEstimateButtonClick.click();
    }
}

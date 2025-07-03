package testCases;

import Estimate.TC002_UserShouldAbleToCreateEstimateThroughImportExcel;
import base.DriverSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class TC018_UserShouldAbleToCreateClientInvoice extends DriverSetup {

    @Test
    public void userShouldAbleToCreateClientInvoice() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        TC002_UserShouldAbleToCreateEstimateThroughImportExcel createEstimateThroughImportExcel = new TC002_UserShouldAbleToCreateEstimateThroughImportExcel();
        createEstimateThroughImportExcel.userShouldAbleToCreateEstimateThroughImportExcel();

        Thread.sleep(2000);

        WebElement ClickOnEstimateNo = driver.findElement(By.partialLinkText("ES"));
        ClickOnEstimateNo.click();

        Thread.sleep(2000);
        WebElement selectAllButton = driver.findElement(By.xpath("//thead[@class='esti-top']//tr//th//input[@type='checkbox']"));
        selectAllButton.click();

        Thread.sleep(2000);
        WebElement ClickOnApproveButton = driver.findElement(By.xpath("//button[@class='sortnew' and text()='Approve']"));
        ClickOnApproveButton.click();

        WebElement clickOnYesAgreeButton = driver.findElement(By.xpath("//button[contains(text(),'Yes, agree')]"));
        clickOnYesAgreeButton.click();

        Thread.sleep(2000);
        WebElement fileInput = driver.findElement(By.id("attach"));
        String filePath = ("D:/Sample File/Docs/sample.pdf");
        fileInput.sendKeys(filePath);

        WebElement addNote = driver.findElement(By.id("adnote"));
        addNote.sendKeys("Automation test note...");

        Thread.sleep(2000);
        WebElement approveButton = driver.findElement(By.xpath("//a[contains(text(),'Approve')]"));
        approveButton.click();

        Thread.sleep(5000);


        //Collect all line item checkboxes (that are not selected yet)
        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox' and contains(@class,'chkesti') and @value and @checked='false']"));

// OR if @checked is not present, just collect all and iterate
        checkboxes = driver.findElements(By.xpath("//input[@type='checkbox' and contains(@class,'chkesti')]"));

        System.out.println("Total line items found: " + checkboxes.size());

        for (int i = 1; i < checkboxes.size(); i++) {
            System.out.println("Running iteration: " + (i + 1));

            // Click the main 'Generate Invoice' button
            WebElement generateInvoiceBtn = driver.findElement(By.xpath("//button[contains(text(),'Generate Invoice')]"));
            generateInvoiceBtn.click();

            Thread.sleep(1000); // Wait for modal to fully load

            // ✅ Find checkboxes only inside the modal (avoid estimate table)
            List<WebElement> modalCheckboxes = driver.findElements(
                    By.xpath("//div[contains(@class,'modal') and contains(@style,'display: block')]//input[@type='checkbox' and contains(@class,'chkesti')]")
            );

            if (i < modalCheckboxes.size()) {
                WebElement checkbox = modalCheckboxes.get(i);

                // Scroll and click via JavaScript (avoid overlay issues)
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkbox);
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox);

                // ✅ Also confirm button inside modal only
                WebElement confirmBtn = driver.findElement(
                        By.xpath("//div[contains(@class,'modal') and contains(@style,'display: block')]//a[contains(text(),'Generate Invoice')]")
                );
                confirmBtn.click();

                Thread.sleep(2000); // Wait for invoice generation
            } else {
                System.out.println("No modal checkbox found at index " + i);
            }
        }




    }
}

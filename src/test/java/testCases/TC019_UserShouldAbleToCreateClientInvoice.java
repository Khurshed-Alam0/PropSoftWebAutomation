package testCases;

import Estimate.TC002_UserShouldAbleToCreateEstimateThroughImportExcel;
import base.DriverSetup;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class TC019_UserShouldAbleToCreateClientInvoice extends DriverSetup {

    @Test
    public void userShouldAbleToCreateClientInvoice() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        TC002_UserShouldAbleToCreateEstimateThroughImportExcel createEstimateThroughImportExcel =
                new TC002_UserShouldAbleToCreateEstimateThroughImportExcel();

        int totalRuns = 3; // Repeat the whole flow 3 times (change as needed)

        for (int run = 1; run <= totalRuns; run++) {
            System.out.println("====== Starting Estimate Cycle #" + run + " ======");

            // Step 1: Create Estimate
            createEstimateThroughImportExcel.userShouldAbleToCreateEstimateThroughImportExcel();
            Thread.sleep(2000);

            // Step 2: Open the estimate
            WebElement ClickOnEstimateNo = driver.findElement(By.partialLinkText("ES"));
            ClickOnEstimateNo.click();

            Thread.sleep(2000);
            driver.findElement(By.xpath("//thead[@class='esti-top']//tr//th//input[@type='checkbox']")).click();
            Thread.sleep(1000);

            driver.findElement(By.xpath("//button[@class='sortnew' and text()='Approve']")).click();
            driver.findElement(By.xpath("//button[contains(text(),'Yes, agree')]")).click();

            Thread.sleep(1000);
            driver.findElement(By.id("attach")).sendKeys("D:/Sample File/Docs/sample.pdf");
            driver.findElement(By.id("adnote")).sendKeys("Automation test note...");

            Thread.sleep(1000);
            driver.findElement(By.xpath("//a[contains(text(),'Approve')]")).click();

            Thread.sleep(3000);

            // Step 3: Generate invoice for each checkbox (starting from 2nd)
            List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox' and contains(@class,'chkesti')]"));
            System.out.println("✅ Total line items in estimate: " + checkboxes.size());

            for (int i = 1; i < checkboxes.size(); i++) {  // start from 2nd checkbox
                System.out.println("➡ Invoice iteration: " + (i + 1));

                WebElement generateInvoiceBtn = driver.findElement(By.xpath("//button[contains(text(),'Generate Invoice')]"));
                generateInvoiceBtn.click();
                Thread.sleep(1000);

                List<WebElement> modalCheckboxes = driver.findElements(By.xpath("//div[contains(@class,'modal') and contains(@style,'display: block')]//input[@type='checkbox' and contains(@class,'chkesti')]"));

                if (i < modalCheckboxes.size()) {
                    WebElement checkbox = modalCheckboxes.get(i);
                    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkbox);
                    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox);

                    WebElement confirmBtn = driver.findElement(
                            By.xpath("//div[contains(@class,'modal') and contains(@style,'display: block')]//a[contains(text(),'Generate Invoice')]"));
                    confirmBtn.click();

                    Thread.sleep(2000);
                } else {
                    System.out.println("❌ No checkbox found at index: " + i);
                }
            }

            System.out.println("✅ Estimate Cycle #" + run + " Completed.\n");
        }

        System.out.println("🎉 All cycles completed.");
    }
}

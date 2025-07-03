package testCases;

import Estimate.TC002_UserShouldAbleToCreateEstimateThroughImportExcel;
import base.DriverSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC017_UserShouldAbleToCreateClientInvoice extends DriverSetup {

    @Test
    public void userShouldAbleToCreateClientInvoice() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        for (int i = 0; i <200; i++) {

            System.out.println("Running iteration: " + (i + 1));


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
            WebElement generateInvoicebutton = driver.findElement(By.xpath("//button[contains(text(),'Generate Invoice')]"));
            generateInvoicebutton.click();

            Thread.sleep(2000);
            WebElement checkbox = driver.findElement(By.xpath("(//input[@value='false'])[2]"));
            checkbox.click();

            WebElement generateinvoicebtnClick = driver.findElement(By.xpath("//a[contains(text(),'Generate Invoice')]"));
            generateinvoicebtnClick.click();
        }

    }
}

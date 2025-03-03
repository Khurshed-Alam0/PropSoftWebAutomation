package PO;

import base.DriverSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC001_CreatePO extends DriverSetup {


    @Test
    public void userShouldAbleToCreatePO() throws InterruptedException {

        TC003_CreateEstimate estimateCreation=new TC003_CreateEstimate();
        estimateCreation.userShouldAbleToCreateEstimateManual();

        WebElement ClickOnEstimateNo= driver.findElement(By.partialLinkText("ES"));
        ClickOnEstimateNo.click();

        Thread.sleep(2000);
        WebElement selectAllButton= driver.findElement(By.xpath("//thead[@class='esti-top']//tr//th//input[@type='checkbox']"));
        selectAllButton.click();

        Thread.sleep(2000);
        WebElement ClickOnApproveButton= driver.findElement(By.xpath("//button[@class='sortnew' and text()='Approve']"));
        ClickOnApproveButton.click();

        WebElement clickOnYesAgreeButton= driver.findElement(By.xpath("//button[contains(text(),'Yes, agree')]"));
        clickOnYesAgreeButton.click();

        Thread.sleep(2000);
        WebElement fileInput= driver.findElement(By.id("attach"));
        String filePath = ("D:/Sample File/Docs/sample.pdf");
        fileInput.sendKeys(filePath);

        WebElement addNote= driver.findElement(By.id("adnote"));
        addNote.sendKeys("Automation test note...");

        Thread.sleep(2000);
        WebElement approveButton= driver.findElement(By.xpath("//a[contains(text(),'Approve')]"));
        approveButton.click();

        Thread.sleep(2000);
        WebElement selectAllButton2= driver.findElement(By.xpath("//tbody/tr[1]/td[1]/span[1]/input[1]"));
        Thread.sleep(2000);
        selectAllButton2.click();

        Thread.sleep(2000);
        WebElement ClickOnCreatePoButton= driver.findElement(By.xpath("//button[@class='sortnew' and text()='Create PO']"));
        ClickOnCreatePoButton.click();

        Thread.sleep(2000);
        WebElement woNoField= driver.findElement(By.name("work_order_number"));
        woNoField.sendKeys("w-001");

        // Explicit wait
        WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(10));
        System.out.println("Finding the element...");
        WebElement selectPoWoType = waits.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='react-select-2-input']")));
        System.out.println("Element found!");


        // Perform actions
        selectPoWoType.click();
        selectPoWoType.sendKeys("PO Work Test");
        selectPoWoType.sendKeys(Keys.ARROW_DOWN);
        selectPoWoType.sendKeys(Keys.ENTER);



        WebElement selectVendorDropDown= driver.findElement(By.id("react-select-3-input"));
        selectVendorDropDown.click();
        selectVendorDropDown.sendKeys("Mr Vendor");
        selectVendorDropDown.sendKeys(Keys.ARROW_DOWN);
        selectVendorDropDown.sendKeys(Keys.ENTER);

        WebElement markDownField= driver.findElement(By.id("markdown"));
        markDownField.sendKeys("50");

        WebElement createPOButton= driver.findElement(By.xpath("//a[contains(text(),'Create PO')]"));
        createPOButton.click();


    }
}

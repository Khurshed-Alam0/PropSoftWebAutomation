package PO;

import Estimate.TC001_CreateEstimate;
import base.DriverSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TC001_CreatePO extends DriverSetup {


    @Test
    public void userShouldAbleToCreatePO() throws InterruptedException {

        TC001_CreateEstimate estimateCreation=new TC001_CreateEstimate();
        estimateCreation.userShouldAbleToCreateEstimate();

        WebElement ClickOnEstimateNo= driver.findElement(By.partialLinkText("ES"));
        ClickOnEstimateNo.click();

        Thread.sleep(2000);
        WebElement selectAllButton= driver.findElement(By.xpath("//thead[@class='esti-top']//tr//th//input[@type='checkbox']"));
        selectAllButton.click();

        Thread.sleep(2000);
        WebElement ClickOnApproveButton= driver.findElement(By.xpath("//body/div[@id='__next']/main[@id='master_container']/div[2]/main[1]/div[1]/div[1]/form[1]/div[2]/button[1]"));
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
        WebElement ClickOnCreatePoButton= driver.findElement(By.xpath("//body/div[@id='__next']/main[@id='master_container']/div[2]/main[1]/div[1]/div[1]/form[1]/div[2]/button[4]"));
        ClickOnCreatePoButton.click();

        Thread.sleep(2000);
        WebElement woNoField= driver.findElement(By.name("work_order_number"));
        woNoField.sendKeys("w-001");

        WebElement selectVendorDropDown= driver.findElement(By.id("react-select-2-input"));
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

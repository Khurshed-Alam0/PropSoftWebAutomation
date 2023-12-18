package Estimate;

import base.DriverSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import testCases.TC007_ProjectCreationTest;

public class TC002_UserShouldAbleToCreateEstimateThroughImportExcel extends DriverSetup {

    @Test
    public void userShouldAbleToCreateEstimateThroughImportExcel() throws InterruptedException {

        TC007_ProjectCreationTest createProject=new TC007_ProjectCreationTest();
        createProject.userShouldBeAbleToCreatePage_ThroughPopUpModalLocationSearch();

        Thread.sleep(5000);
        WebElement tabEstimate=driver.findElement(By.id("projectsTabs-tab-Estimate"));
        tabEstimate.click();

        Thread.sleep(5000);
        WebElement btnCreateEstimate= driver.findElement(By.xpath("//body/div[@id='__next']/main[@id='master_container']/div[2]/main[1]/div[1]/div[2]/div[1]/div[2]/div[4]/div[1]/div[1]/div[1]/div[1]"));
        btnCreateEstimate.click();

        Thread.sleep(2000);
        WebElement fileInput= driver.findElement(By.xpath("//input[@type='file']"));
        String filePath = ("D:/KHURSHED/ProftSoft.ai/Create_Estimate/Estimate_dummy_format-1.xlsx");
        fileInput.sendKeys(filePath);


        WebElement selectAllButton=driver.findElement(By.id("test"));
        selectAllButton.click();

        WebElement markUpButtonModal= driver.findElement(By.xpath("//button[@type='button' and contains(text(),'Mark Up')]"));
        markUpButtonModal.click();

        Thread.sleep(2000);
        WebElement markupValue= driver.findElement(By.xpath("//input[@type='number' and @name='markup']"));
        markupValue.click();
        markupValue.sendKeys("50");

        WebElement markupSaveButton= driver.findElement(By.xpath("//button[contains(text(),'Save')]"));
        markupSaveButton.click();

        WebElement createEstimateButtonClick= driver.findElement(By.xpath("//button[contains(text(),'Create Estimate')]"));
        createEstimateButtonClick.click();



    }


}

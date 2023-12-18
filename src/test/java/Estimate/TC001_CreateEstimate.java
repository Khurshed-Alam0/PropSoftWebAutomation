package Estimate;

import base.DriverSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import testCases.TC007_ProjectCreationTest;

public class TC001_CreateEstimate extends DriverSetup {

    @Test
    public void userShouldAbleToCreateEstimate() throws InterruptedException {


        TC007_ProjectCreationTest createProject=new TC007_ProjectCreationTest();
        createProject.userShouldBeAbleToCreatePage_ThroughPopUpModalLocationSearch();

      /*  Thread.sleep(5000);
        ProjectDetailsPage project=new ProjectDetailsPage(driver);
        project.goToProjectDetailsPage();*/

        Thread.sleep(5000);
        WebElement tabEstimate=driver.findElement(By.id("projectsTabs-tab-Estimate"));
        tabEstimate.click();

        Thread.sleep(5000);
        WebElement btnCreateEstimate= driver.findElement(By.xpath("//body/div[@id='__next']/main[@id='master_container']/div[2]/main[1]/div[1]/div[2]/div[1]/div[2]/div[4]/div[1]/div[1]/div[1]/div[1]"));
        btnCreateEstimate.click();

        /*Thread.sleep(5000);
        driver.findElement(By.xpath("//body/div[@id='__next']/main[@id='master_container']/div[2]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[2]/button[1]")).sendKeys("Desktop\\1.xlsx");
        //buttonImport.click();
       // Thread.sleep(2000);
        //buttonImport.sendKeys("Desktop\\1.xlsx");

        *//*StringSelection ss = new StringSelection("D:/KHURSHED/ProftSoft.ai/Create_Estimate/Estimate_dummy_format.xlsx");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);*//*

      *//*  // Locate the file input element for uploading
        WebElement fileInput = driver.findElement(By.id("fileInputId")); // Replace with the actual ID*//*

        // Get the absolute path of the Excel file to be uploaded
      *//*  String filePath = "D:\\KHURSHED\\ProftSoft.ai\\Create_Estimate\\Estimate_dummy_format.xlsx";
        File file = new File(filePath);

        // Use the LocalFileDetector to upload the file
        ((RemoteWebElement) buttonImport).setFileDetector(new LocalFileDetector());
        buttonImport.sendKeys(file.getAbsolutePath());
        *//*
*/
        WebElement lineItem0= driver.findElement(By.id("line_item_name0"));
        lineItem0.sendKeys("1");

        WebElement locationAndNotes= driver.findElement(By.id("location_note0"));
        locationAndNotes.sendKeys("1");

        WebElement unit0= driver.findElement(By.id("unit0"));
        unit0.sendKeys("1");

        WebElement markup0= driver.findElement(By.id("markup0"));
        markup0.sendKeys("1");

        WebElement addRow1=driver.findElement(By.xpath("//body/div[@id='__next']/main[@id='master_container']/div[2]/main[1]/div[1]/div[1]/div[2]/div[1]/div[1]/table[1]/tfoot[1]/tr[2]/td[1]/div[1]/i[1]"));
        addRow1.click();

        WebElement lineItem1= driver.findElement(By.id("line_item_name1"));
        lineItem1.sendKeys("2");

        WebElement locationAndNotes1= driver.findElement(By.id("location_note1"));
        locationAndNotes1.sendKeys("2");

        WebElement unit1= driver.findElement(By.id("unit1"));
        unit1.sendKeys("2");

        WebElement markup1= driver.findElement(By.id("markup1"));
        markup1.sendKeys("2");

        WebElement createEstimateButtonClick= driver.findElement(By.xpath("//button[contains(text(),'Create Estimate')]"));
        createEstimateButtonClick.click();
    }
}

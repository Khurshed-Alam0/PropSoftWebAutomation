package testCases;

import base.DriverSetup;
import base.LoginPage;
import base.ProjectDetailsPage;
import base.SidebarPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TC008_ProjectEditTest extends DriverSetup {

    @Test
    public void userShouldBeAbleToEditProject() throws InterruptedException {
        LoginPage loginpage=new LoginPage(driver);
        loginpage.doLogin();

        SidebarPage sidebarPage=new SidebarPage(driver);
        sidebarPage.goToProjects();



        ProjectDetailsPage projectDetailsPage=new ProjectDetailsPage(driver);
        Thread.sleep(2000);
        projectDetailsPage.goToProjectDetailsPage();
        Thread.sleep(2000);
        projectDetailsPage.ManageBtnClick();
        projectDetailsPage.GoToEditProject();


        WebElement additionalinfo=driver.findElement(By.xpath("//h6[text()='Additional Info']"));
        additionalinfo.click();

        WebElement lockbox=driver.findElement(By.id("Lockbox"));
        String beforeEdit=lockbox.getText();
        Thread.sleep(2000);
        lockbox.clear();
        Thread.sleep(2000);
        lockbox.sendKeys("456");
        String afterEdit=lockbox.getText();

        Thread.sleep(2000);
        WebElement btnSubmitClick=driver.findElement(By.xpath("//button[contains(text(),'Save Project')]"));
        btnSubmitClick.sendKeys(Keys.ENTER);

        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(beforeEdit,afterEdit);
        softAssert.assertAll();



    }
}

package testCases;

import base.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class TC009_InviteUser_SuperAdmin_AcceptThrough_ManuallyAcceptTest extends DriverSetup {

    @Test
    public void inviteUser_SuperAdmin_Manually_AcceptTest() throws InterruptedException {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.doLogin();


        SidebarPage sidebarPage=new SidebarPage(driver);
        sidebarPage.goToUserListPage();

        UserListPage userListPage=new UserListPage(driver);
        userListPage.goToNewInvite();

        WebElement firstName= driver.findElement(By.id("user_first_name"));
        firstName.sendKeys("Super Admin");

        WebElement lastName= driver.findElement(By.id("user_last_name"));
        lastName.sendKeys("Test");

        WebElement emailAddress= driver.findElement(By.id("user_email_address"));
        emailAddress.sendKeys("khurshed.apexdmit@gmail.com");

        WebElement phoneNumber= driver.findElement(By.id("user_phone_number"));
        phoneNumber.sendKeys("123456789");


       /* WebElement selectOrganization=driver.findElement(By.xpath("//div[@class=' css-1hb7zxy-IndicatorsContainer'] "));
        selectOrganization.click();
        Thread.sleep(2000);
        Actions actions=new Actions(driver);
        actions.moveToElement(selectOrganization).click().build().perform();
        actions.click()*/

        Thread.sleep(2000);

        WebElement selectPermissionRole=driver.findElement(By.xpath("//body[1]/div[1]/main[1]/div[2]/main[1]/div[1]/form[1]/fieldset[1]/div[1]/section[1]/ul[1]/li[1]/span[1]/button[1]"));
        selectPermissionRole.click();

        WebElement btnSendInvite= driver.findElement(By.xpath("//input[@value='Send Invite']"));
        btnSendInvite.click();














    }

}

package testCases;

import base.DriverSetup;
import base.LoginPage;
import base.SidebarPage;
import base.UserListPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TC010_InviteUser_Admin_AcceptThrough_ManuallyAcceptTest extends DriverSetup {

    @Test
    public void inviteUser_Admin_Manually_AcceptTest() throws InterruptedException {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.doLogin();


        SidebarPage sidebarPage = new SidebarPage(driver);
        sidebarPage.goToUserListPage();

        UserListPage userListPage = new UserListPage(driver);
        userListPage.goToNewInvite();

        WebElement firstName = driver.findElement(By.id("user_first_name"));
        firstName.sendKeys("Super Admin");

        WebElement lastName = driver.findElement(By.id("user_last_name"));
        lastName.sendKeys("Test");

        WebElement emailAddress = driver.findElement(By.id("user_email_address"));
        emailAddress.sendKeys("khurshed.apexdmit@gmail.com");

        WebElement phoneNumber = driver.findElement(By.id("user_phone_number"));
        phoneNumber.sendKeys("123456789");


        Thread.sleep(2000);

        WebElement selectPermissionRole = driver.findElement(By.xpath("//body/div[@id='__next']/main[@id='master_container']/div[2]/main[1]/div[1]/form[1]/fieldset[1]/div[1]/section[1]/ul[1]/li[2]/span[1]/button[1]/i[1]"));
        selectPermissionRole.click();

        WebElement btnSendInvite = driver.findElement(By.xpath("//input[@value='Send Invite']"));
        btnSendInvite.click();


    }
}

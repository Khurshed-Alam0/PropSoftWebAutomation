package testCases;

import base.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.util.Random;

public class TC009_InviteUser_SuperAdmin_AcceptThrough_ManuallyAcceptTest extends DriverSetup {

    @Test
    public void inviteUser_SuperAdmin_Manually_AcceptTest() throws InterruptedException {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.doLogin();

        Thread.sleep(5000);
        CardProfileDropDown cardProfileDropDown=new CardProfileDropDown(driver);
        Thread.sleep(5000);
        cardProfileDropDown.ClickOnCardprofileDropdown();
        cardProfileDropDown.goToUserlistpage();
       /*
        SidebarPage sidebarPage = new SidebarPage(driver);
        sidebarPage.goToUserListPage();*/

        UserListPage userListPage = new UserListPage(driver);
        userListPage.goToNewInvite();

        WebElement firstName = driver.findElement(By.id("user_first_name"));
        firstName.sendKeys("Super Admin");

        WebElement lastName = driver.findElement(By.id("user_last_name"));
        lastName.sendKeys("Test");

        WebElement emailAddress = driver.findElement(By.id("user_email_address"));
        emailAddress.sendKeys(java.util.UUID.randomUUID().toString().substring(0,10) + "@gmail.com");
        //emailAddress.sendKeys("khurshed.apexdmit@gmail.com");

    /*    WebElement phoneNumber = driver.findElement(By.id("user_phone_number"));
        phoneNumber.sendKeys("123456789");*/

        // Locate the phone number input field
        WebElement phoneNumber = driver.findElement(By.id("user_phone_number"));

        // Generate a random 9 or 10-digit phone number
        Random rand = new Random();
        int length = rand.nextBoolean() ? 9 : 10;  // Randomly choose 9 or 10 digits
        long randomPhoneNumber = (long) (Math.pow(10, length - 1) + rand.nextDouble() * 9 * Math.pow(10, length - 1));

        // Send the generated phone number to the input field
        phoneNumber.sendKeys(String.valueOf(randomPhoneNumber));


       /* WebElement selectOrganization=driver.findElement(By.xpath("//div[@class=' css-1hb7zxy-IndicatorsContainer'] "));
        selectOrganization.click();
        Thread.sleep(2000);
        Actions actions=new Actions(driver);
        actions.moveToElement(selectOrganization).click().build().perform();
        actions.click()*/

        Thread.sleep(2000);

        WebElement selectPermissionRole = driver.findElement(By.xpath("//body[1]/div[1]/main[1]/div[2]/main[1]/div[1]/form[1]/fieldset[1]/div[1]/section[1]/ul[1]/li[1]/span[1]/button[1]"));
        selectPermissionRole.click();

        WebElement btnSendInvite = driver.findElement(By.xpath("//input[@value='Send Invite']"));
        btnSendInvite.click();


    }

}

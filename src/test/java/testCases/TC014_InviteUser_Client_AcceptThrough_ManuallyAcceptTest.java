package testCases;

import base.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class TC014_InviteUser_Client_AcceptThrough_ManuallyAcceptTest extends DriverSetup {

    @Test
    public void inviteUser_Client_Manually_AcceptTest() throws InterruptedException {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.doLogin();


        /*SidebarPage sidebarPage = new SidebarPage(driver);
        sidebarPage.goToUserListPage();*/

        Thread.sleep(5000);
        CardProfileDropDown cardProfileDropDown=new CardProfileDropDown(driver);
        Thread.sleep(5000);
        cardProfileDropDown.ClickOnCardprofileDropdown();
        cardProfileDropDown.goToUserlistpage();

        UserListPage userListPage = new UserListPage(driver);
        userListPage.goToNewInvite();

        WebElement firstName = driver.findElement(By.id("user_first_name"));
        firstName.sendKeys("Client");

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

        Thread.sleep(5000);
      WebElement organization= driver.findElement(By.xpath("//div[contains(text(),'Select Organization')]"));
      Thread.sleep(5000);
      organization.click();
      organization.sendKeys("test");
      organization.sendKeys(Keys.ARROW_DOWN);
      organization.sendKeys(Keys.ENTER);





        Thread.sleep(2000);

        WebElement selectPermissionRole = driver.findElement(By.xpath("//body/div[@id='__next']/main[@id='master_container']/div[2]/main[1]/div[1]/form[1]/fieldset[1]/div[1]/section[1]/ul[1]/li[6]/span[1]/button[1]/i[1]"));
        selectPermissionRole.click();

        WebElement btnSendInvite = driver.findElement(By.xpath("//input[@value='Send Invite']"));
        btnSendInvite.click();


    }
}

package testCases;

import base.DriverSetup;
import base.LoginPage;
import base.ManageOrganization;
import org.testng.annotations.Test;

public class TC015_OrganizationCreationTest extends DriverSetup {

    @Test

    public void organizationCreationTest() throws InterruptedException {

        LoginPage loginPage=new LoginPage(driver);
        loginPage.doLogin();

        Thread.sleep(10000);

        ManageOrganization manageOrganization=new ManageOrganization(driver);
        manageOrganization.doAddNewProject();


    }
}

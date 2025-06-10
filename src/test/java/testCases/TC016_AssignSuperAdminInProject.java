package testCases;

import base.*;
import org.testng.annotations.Test;

public class TC016_AssignSuperAdminInProject extends DriverSetup  {

    @Test
    public void assignSuperAdminInProject() throws InterruptedException {
        LoginPage loginPage=new LoginPage(driver);
        loginPage.doLogin();

        SidebarPage sidebarPage=new SidebarPage(driver);
        sidebarPage.goToProjects();

        ProjectDetailsPage projectDetailsPage=new ProjectDetailsPage(driver);
        projectDetailsPage.goToProjectDetailsPage();
        projectDetailsPage.ManageBtnClick();
        projectDetailsPage.goToAssignUserOption();

        Thread.sleep(5000);

        AssignUserPage assignUserPage=new AssignUserPage(driver);
        assignUserPage.goToAddClient();
    }
}

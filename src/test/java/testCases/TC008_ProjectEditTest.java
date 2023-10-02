package testCases;

import base.DriverSetup;
import base.LoginPage;
import base.ProjectDetailsPage;
import base.SidebarPage;
import org.testng.annotations.Test;

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




    }
}

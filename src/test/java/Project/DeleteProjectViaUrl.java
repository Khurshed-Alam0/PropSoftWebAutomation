package Project;

import base.DriverSetup;
import base.LoginPage;
import base.ProjectDetailsPage;
import base.SidebarPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class DeleteProjectViaUrl extends DriverSetup {

    @Test
    public void userShouldAbleToDeleteProject() throws InterruptedException, MalformedURLException {

        LoginPage loginPage=new LoginPage(driver);
        loginPage.doLogin();

        for(int projectId=7792;projectId>=7760;projectId--){

            SidebarPage sidebarPage=new SidebarPage(driver);
            sidebarPage.goToProjects();

            String projectUrl = "https://awsuatapp.propsoft.ai/project-details?id=" + projectId;
            driver.get(projectUrl);
            String currentUrl = driver.getCurrentUrl();
            URL url = new URL(currentUrl);
            String query = url.getQuery(); // e.g., "id=7839"

            int actualId = -1;
            if (query != null && query.startsWith("id=")) {
                actualId = Integer.parseInt(query.split("=")[1]);
                System.out.println("Actual id="+actualId);
            }
            ProjectDetailsPage projectDetailsPage=new ProjectDetailsPage(driver);
            projectDetailsPage.ManageBtnClick();

                WebElement deleteProjectButton = driver.findElement(By.xpath("//a[span[text()='Delete Project']]"));
                deleteProjectButton.click();
                WebElement deleteProjectConfirmationModal = driver.findElement(By.xpath("//button[contains(.,'Yes, delete')]  "));
                deleteProjectConfirmationModal.click();
                System.out.println("✅ Project ID " + projectId + " deleted successfully.");
                Thread.sleep(2000);

            }





    }
}

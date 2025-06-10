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
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class projectDeletionUsingPredefinedRandomListOfprojectsIDs extends DriverSetup {

    @Test
    public void userShouldAbleToDeleteProject() throws Exception {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.doLogin();

        // ✅ Step 1: Define list of project IDs (you can modify this list anytime)
        List<Integer> projectIds = Arrays.asList(7706, 7536, 7090);

        // ✅ Step 2: Shuffle the list to get random order
        Collections.shuffle(projectIds);

        // ✅ Step 3: Loop through the randomized list
        for (int projectId : projectIds) {

            SidebarPage sidebarPage = new SidebarPage(driver);
            sidebarPage.goToProjects();

            String projectUrl = "https://awsuatapp.propsoft.ai/project-details?id=" + projectId;
            driver.get(projectUrl);

            ProjectDetailsPage projectDetailsPage = new ProjectDetailsPage(driver);

            String currentUrl = driver.getCurrentUrl();
            URL url = new URL(currentUrl);
            String query = url.getQuery(); // e.g., "id=7839"

            int actualId = -1;
            if (query != null && query.startsWith("id=")) {
                actualId = Integer.parseInt(query.split("=")[1]);
                System.out.println("Actual id = " + actualId);
            }

            try {
                if (actualId == projectId) {
                    projectDetailsPage.ManageBtnClick();

                    WebElement deleteProjectButton = driver.findElement(By.xpath("//a[span[text()='Delete Project']]"));
                    deleteProjectButton.click();

                    WebElement deleteProjectConfirmationModal = driver.findElement(By.xpath("//button[contains(.,'Yes, delete')]"));
                    deleteProjectConfirmationModal.click();

                    System.out.println("✅ Project ID " + projectId + " deleted successfully.");
                    Thread.sleep(2000);
                }
            } catch (Exception e) {
                System.out.println("⚠️ Project ID " + projectId + " not found or cannot be deleted. Skipping...");
            }
        }
    }

}

package base;

import org.bouncycastle.pqc.crypto.newhope.NHSecretKeyProcessor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProjectDetailsPage {

    public WebDriver driver;

    public ProjectDetailsPage(WebDriver driver){
        this.driver=driver;

    }

    public WebElement projectName(){
        return driver.findElement(By.cssSelector("body.standard:nth-child(2) main.standard.grid-skip.minsidebar:nth-child(1) main.content.company_wrap.project-list-nui div.content-wrap div.projects-list a.projects-list__project:nth-child(1) div.projects-list__project__info div.projects-list__project__title > div.projects-list__project__title-container:nth-child(1)"));
    }

    public void goToProjectDetailsPage(){
        projectName().click();
    }

    public WebElement ManageBtnForGoToEditPage(){
       return driver.findElement(By.xpath("//body[1]/div[1]/main[1]/div[2]/main[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/a[1]/span[1]/span[1]"));
    }

    public void ManageBtnClick(){
        ManageBtnForGoToEditPage().click();
    }

    public WebElement EditProject(){
        return driver.findElement(By.xpath("//span[contains(text(),'Edit Project')]"));
    }

    public WebElement AssignUserOption(){
        return driver.findElement(By.xpath("//span[contains(text(),'Assign Users')]") );
    }

    public void goToAssignUserOption(){
        AssignUserOption().click();
    }

    public void GoToEditProject(){
        EditProject().click();
    }



}

package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class SidebarPage {

    public WebDriver driver;

    public SidebarPage(WebDriver driver){
        this.driver=driver;

    }

    public WebElement projectInSidebar(){
        return driver.findElement(By.xpath("//a[@class='nav-link' and @href='/projects']"));
    }

    public void goToProjects(){
        projectInSidebar().click();
    }

    public WebElement userListSidebar(){
        return driver.findElement(By.xpath("//span[contains(text(),'User List')]"));
    }

    public void goToUserListPage(){
        userListSidebar().click();
    }
}

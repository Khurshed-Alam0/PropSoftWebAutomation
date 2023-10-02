package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.security.PublicKey;

public class SidebarPage {

    public WebDriver driver;

    public SidebarPage(WebDriver driver){
        this.driver=driver;

    }

    public WebElement projectInSidebar(){
        return driver.findElement(By.xpath("//body/div[@id='__next']/main[@id='master_container']/div[1]/nav[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[2]/a[1]"));
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

package mantis.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Евгения on 9/1/2016.
 */
public class ManagePage {
    private WebDriver driver;
    private static Logger log = LoggerFactory.getLogger(ManagePage.class);


    //The  "Manage Projects" bracket-link

    @FindBy(linkText = "Manage Projects")
    private WebElement manageProjectsLink;

    public ManagePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    private ManagePage goToManageProjectsPage (WebDriver driver) {
        manageProjectsLink.click();
        log.info("The 'Manage Projects' bracket-link was clicked");
        return this;
    }



}

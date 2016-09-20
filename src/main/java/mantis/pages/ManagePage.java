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
public class ManagePage extends AbstractPage {
    private WebDriver driver;
    private static Logger log = LoggerFactory.getLogger(ManagePage.class);


    //The  "Manage Projects" bracket-link

    @FindBy(linkText = "Manage Projects")
    private WebElement manageProjectsLink;

    @FindBy(linkText = "Manage Users")
    private WebElement manageUsersLink;

    public ManagePage(WebDriver driver) {
        super (driver);
        PageFactory.initElements(driver, this);

    }

    public ManagePage goToManageUsersPage () {
        manageUsersLink.click();
        log.info("The 'ManageUsers' link was clicked");
        return this;
    }

    private ManagePage goToManageProjectsPage (WebDriver driver) {
        manageProjectsLink.click();
        log.info("The 'Manage Projects' bracket-link was clicked");
        return this;
    }



}

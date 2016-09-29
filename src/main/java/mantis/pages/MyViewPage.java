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
public class MyViewPage extends AbstractPage{
    private WebDriver driver;
    private static Logger log = LoggerFactory.getLogger(MyViewPage.class);
 

    //The  "Manage" tab

    @FindBy(linkText = "Manage")
    private WebElement manageTab;

    @FindBy(linkText = "Logout")
    private WebElement logoutLink;


    //The 'Report Issue' link on 'MyView' page
    @FindBy(linkText = "Report Issue")
    private WebElement reportIssueLink;

    public MyViewPage (WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);

    }

    private MyViewPage goToManagePage (WebDriver driver) {
        manageTab.click();
        log.info("The 'Manage' tab was clicked");
        return this;

    }
    public MyViewPage goToManagePage () {
        manageTab.click();
        log.info("The 'Manage' tab was clicked");
        return this;

    }
    public String getLogoutText(){
        String logout=logoutLink.getText();
        logoutLink.click();
        return logout;
    }

    //Go to 'ReportIssue' page'
    public MyViewPage goReportIssuePage () {
        reportIssueLink.click();
        log.info("The 'Report Issue' link has been clicked");
        return this;

    }


}


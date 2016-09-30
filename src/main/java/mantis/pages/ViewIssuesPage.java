package mantis.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by sveta on 30.09.16.
 */
public class ViewIssuesPage extends AbstractPage {

    private static Logger log = LoggerFactory.getLogger (ViewIssuesPage.class);
    public WebDriver driver;

    public ViewIssuesPage(WebDriver driver) {

        super (driver);
        PageFactory.initElements (driver, this);

    }

    //LogOut link
    @FindBy (linkText = "Logout")
    private WebElement logout;

    //View Issues link
    @FindBy (partialLinkText = "Viewing Issues ")
    private WebElement viewing_issues;



    public void logOut() {
        logout.click ();


    }

    public void waitFor() {

        getDriver ().manage ().timeouts ().implicitlyWait (20, TimeUnit.SECONDS);
    }


    public String getTitle() {
        return (getDriver ().getTitle ());



    }




}

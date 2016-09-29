package mantis.pages;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by roma.barabash on 9/17/2016.
 */

public class ManageGlobalProfilesPage extends AbstractPage {

    public WebDriver driver;
    public Select select;
    private static Logger log = LoggerFactory.getLogger(CreateUserCheckingPage.class);

    @FindBy(name = "platform")
    private WebElement platformField;

    @FindBy(name = "os")
    private WebElement osField;

    @FindBy(name = "os_build")
    private WebElement osBuildField;

    @FindBy(name = "description")
    private WebElement descriptionTextArea;

    @FindBy(xpath = "//input[contains(@value,'Add Profile')]")
    private WebElement addProfileButton;

    @FindBy(xpath = "//a[contains(.,'Manage')]")
    private WebElement manageLink;

    @FindBy(xpath = "//a[contains(.,'Manage Global Profiles')]")
    private WebElement manageGlobalProfilesLink;

    @FindBy(name = "profile_id")
    private WebElement profile;

    @FindBy(xpath = "//input[@value='delete']")
    private WebElement deleteProfileRadio;

    @FindBy (xpath = "//input[contains(@value,'Submit')]")
    private WebElement submitButton;

    @FindBy (xpath = "//table/tbody/tr[2]/td/p")
    private WebElement errorNoRequiredField;

    @FindBy (xpath = "//a[contains(.,'Report Issue')]")
    private WebElement reportIssueLink;

    //constructor
    public ManageGlobalProfilesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

   // the way to go to addGlobalProfile form
   public ManageGlobalProfilesPage openCreateOSProfileForm(){
       manageLink.click();
       log.info("Manage is clicked");
       manageGlobalProfilesLink.click();
       log.info("ManageGlobalProfiles is clicked");
       return this;
   }

    //add OS profile meth
    public ManageGlobalProfilesPage addGlobalProfile (String platform, String OS, String OSVers, String additionalDescription ){
        platformField.sendKeys(platform);
        log.info("platformField got char");
        osField.sendKeys(OS);
        log.info("osField got char");
        osBuildField.sendKeys(OSVers);
        log.info("osBuildField got char");
        descriptionTextArea.sendKeys(additionalDescription);
        log.info("descriptionTextArea got char");
        addProfileButton.submit();
        log.info("addProfileButton is clicked");
        return this;
    }

    //select created profile meth
    public ManageGlobalProfilesPage selectCreatedOSProfile() {
        try{
            select = new Select(profile);
            select.selectByVisibleText("linux Ubuntu 13.04LTS");
            log.info("linux Ubuntu 13.04LTS is selected");
        }
        catch(StaleElementReferenceException e)
        {
            log.info("catched StaleElementReferenceException e");
        }
        return this;
    }

    //assert profile isDisplayed
    public boolean assertIfProfileIsDisplayed() {
        return profile.isDisplayed();
    }

    //delete OS profile to return default state
    public ManageGlobalProfilesPage testCleanUp() {
        deleteProfileRadio.click();
        submitButton.submit();
        log.info("profile is Deleted");
        return this;
    }

    //get text of errors are occurred
    public String errorGetText() {
        log.info("error text is captured");
        return  errorNoRequiredField.getText();
    }

    //get text of errors are occurred
    public  ManageGlobalProfilesPage openReportIssueForm() {
        reportIssueLink.click();
        return  this;
    }

    //get created profile content
    public String getCreatedProfileContent() {
        log.info("profile content is captured");
        return  profile.getText();
    }

}

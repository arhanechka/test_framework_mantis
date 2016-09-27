package mantis.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by sveta on 19.09.16.
 */
public class ValidateFieldsPage extends AbstractPage {


    private static Logger log = LoggerFactory.getLogger (ValidateFieldsPage.class);
    public WebDriver driver;

    public ValidateFieldsPage(WebDriver driver)

    {

        super (driver);
        PageFactory.initElements (driver, this);

    }

    //go to 'Report issue'
    @FindBy (how = How.LINK_TEXT, linkText = "Report Issue")
    private WebElement reportIssue;


    //a Category field
    @FindBy (name = "category_id")
    private WebElement category;

    //a Reproducibility field
    @FindBy (name = "reproducibility")
    private WebElement reproducibility;

    // a Severity field
    @FindBy (name = "severity")
    private WebElement severity;

    // a  Priority field
    @FindBy (name = "priority")
    private WebElement priority;

    // a Profile field
    @FindBy (name = "handler_id")
    private WebElement select_profile;

    // a Platform field
    @FindBy (id = "platform")
    private WebElement platform;

    //a  OS field
    @FindBy (id = "os")
    private WebElement os;

    // a OS build field
    @FindBy (id = "os_build")
    private WebElement os_build;


    // a assign to field
    @FindBy (name = "handler_id")
    private WebElement assign_to;

    // a summaryText field
    @FindBy (name = "summary")
    private WebElement summaryText;

    // a descriptionText field
    @FindBy (name = "description")
    private WebElement descriptionText;

    // steps to reproduce
    @FindBy (name = "steps_to_reproduce")
    private WebElement steps_to_reproduceText;

    //a add info field
    @FindBy (name = "additional_info")
    private WebElement additional_infoText;

    //a  upload file
    @FindBy (name = "ufile[]")
    private WebElement ufile;


    //view state
    @FindBy (name = "view_state")
    private WebElement view_state;


    //submit report
    @FindBy (css = "input.button")
    private WebElement submit_report;


    // метод обязательных к заполнению полей ввода багрепорта

    public String fillOutRequiredFields(String summary,
                                        String description,
                                        String steps,
                                        String addInfo) {

        new LoginPage (getDriver ()).clickLoginAdmin ();//enter as admin
        log.info ("Enter as admin was successfull");
        new MyViewPage (getDriver ()).goReportIssuePage ();//go to Report Issue page
        log.info ("go to Report Issue page");
        new ValidateFieldsPage (getDriver ());
        //driver.findElement (By.name ("category_id"));//.selectByVisibleText ("[All Projects] General");
       //category.click ();
        log.info ("select");
        summaryText.sendKeys (summary);
        log.info ("input summary");
        descriptionText.sendKeys (description);
        log.info ("input description");
        steps_to_reproduceText.sendKeys (steps);
        log.info ("input steps");
        additional_infoText.sendKeys (addInfo);
        log.info ("input addInfo");
        submit_report.click ();
        log.info ("Finish of method");
        new WrongValidateFieldsPage (getDriver ());
        String errorText = new WrongValidateFieldsPage (getDriver ()).getMistakeText ();


        return errorText;
    }


}












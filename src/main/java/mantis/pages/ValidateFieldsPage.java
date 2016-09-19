package mantis.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by sveta on 19.09.16.
 * to be countinued
 */
public class ValidateFieldsPage extends AbstractPage {


    private static Logger log = LoggerFactory.getLogger ( ValidateFieldsPage.class );
    public WebDriver driver;

    public ValidateFieldsPage(WebDriver driver) {

        super ( driver );
        PageFactory.initElements ( driver, this );

    }


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

    // a summary field
    @FindBy (name = "summary")
    private WebElement summary;

    // a description field
    @FindBy (name = "description")
    private WebElement description;

    // steps to reproduce
    @FindBy (name = "steps_to_reproduce")
    private WebElement steps_to_reproduce;

    //a add info field
    @FindBy (name = "additional_info")
    private WebElement additional_info;

    //a  upload file
    @FindBy (name = "ufile[]")
    private WebElement ufile;


    //view state
    @FindBy (name = "view_state")
    private WebElement view_state;


    //submit report
    @FindBy (css = "input.button")
    private WebElement submit_report;


    public void clickFields() {
        category.click ();
        reproducibility.click ();
        severity.click ();
        priority.click ();
        select_profile.click ();
        platform.click ();
        os.click ();
        os_build.click ();
        assign_to.click ();
        summary.click ();
        description.click ();
        steps_to_reproduce.click ();
        additional_info.click ();
        //ufile.click ();
        submit_report.click ();

    }

    public void inputData(WebDriver driver,
                          String summary,
                          String description,
                          String steps,
                          String addInfo) {


    }

    public void selectItems() {


    }


}


package mantis.pages;

import mantis.utils.StatusDropDown;
import mantis.utils.ViewStatusDropDown;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Евгения on 9/11/2016.
 */
public class CreateNewProjectPage extends AbstractPage {
    private WebDriver driver;
    private static Logger log = LoggerFactory.getLogger(ManagePage.class);


    // The input field to create the new Project name
    @FindBy(name = "name")
    private WebElement projectNameInput;

    // The 'Status' drop-down menu
    @FindBy(name = "status")
    private WebElement statusDropdown;


    // The checkbox 'Inherit Global Categories' is checked
    @FindBy(name = "inherit_global")
    private WebElement inheritGlobalCategoriesCheckbox;

    // The 'View Status' drop-down menu
    @FindBy(name = "view_state")
    private WebElement viewStatusDropdown;

    // The input field 'Description'
    @FindBy(name = "description")
    private WebElement descriptionInputField;

    // The 'Add Project' button
    @FindBy(className = "button")
    private WebElement addProjectButton;


    public CreateNewProjectPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    private CreateNewProjectPage createNewProject(WebDriver driver, String projectName, StatusDropDown status, ViewStatusDropDown viewStatus, String description) {
        projectNameInput.click();
        projectNameInput.clear();
        projectNameInput.sendKeys(projectName);
        log.debug("The project name was entered: {}", projectName);

        Select statusDropdownEl = new Select(statusDropdown);
        switch (status) {
            case DEVELOPMENT_STATUS_DROP_DOWN:
                statusDropdownEl.selectByValue("10");
                break;
            case RELEASE_STATUS_DROP_DOWN:
                statusDropdownEl.selectByValue("30");
                break;
            case STABLE_STATUS_DROP_DOWN:
                statusDropdownEl.selectByValue("50");
                break;
            case OBSOLETE_STATUS_DROP_DOWN:
                statusDropdownEl.selectByValue("70");
                break;
        }
        log.debug("The status of project was selected: {}", status);

        Select viewStatusDropdownEl = new Select(viewStatusDropdown);
        switch (viewStatus) {
            case PUBLIC_STATUS_DROP_DOWN:
                viewStatusDropdownEl.selectByValue("10");
                break;
            case PRIVATE_STATUS_DROP_DOWN:
                viewStatusDropdownEl.selectByValue("50");
                break;
        }
        log.debug("The view status of project was selected: {}", viewStatus);

        descriptionInputField.click();
        descriptionInputField.clear();
        descriptionInputField.sendKeys(description);
        log.debug("The project description was entered: {}", description);

        addProjectButton.click();
        log.info("The 'Add Project' button was submitted");
            return this;
        }


    }


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
public class  ManageProjectsPage extends AbstractPage{
    private WebDriver driver;
    private static Logger log = LoggerFactory.getLogger(ManageProjectsPage.class);


    // The input field to create the category name
    @FindBy(name = "name")
    private WebElement categoryInputField;

    // The 'Add Category' button
    @FindBy(className = "button")
    private WebElement addCategoryButton;

    // The 'Create New Project' button
    @FindBy (className ="button-small")
    private WebElement  createNewProjectButton;





    public ManageProjectsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);


    }

    private ManageProjectsPage addNewCategory (WebDriver driver, String categoryName ) {
        categoryInputField.click();
        categoryInputField.clear();
        categoryInputField.sendKeys(categoryName);
        log.debug("The category name was entered: {}", categoryName);
        addCategoryButton.click();
        log.info("The 'Add category' button was submitted");

        return this;
    }
}

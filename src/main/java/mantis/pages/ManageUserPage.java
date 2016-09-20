package mantis.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Anya on 15.09.2016.
 */
public class ManageUserPage extends AbstractPage {
    private WebDriver driver;
    private static Logger log = LoggerFactory.getLogger(ManagePage.class);


   @FindBy(xpath="//td[@class = 'form-title']//input[@class='button-small']")
    private WebElement createNewUserLink;
    public ManageUserPage(WebDriver driver) {
        super (driver);
        PageFactory.initElements(driver, this);

    }
     public ManageUserPage goToCreateUserCheckingPage(){
     createNewUserLink.click();
     log.info("The button 'Create new user' was clicked");
     return  this;}
    }
package mantis.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by anna on 01.09.16.
 */
public class SuccessfulLoginPage {
    public WebDriver driver;
    private static Logger log = LoggerFactory.getLogger(SuccessfulLoginPage.class);
    //LogOut link
    @FindBy (xpath = "//td/a[@href='/mantis/']")
    private WebElement logOutButton;

    public SuccessfulLoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void clickLogOut() {
        logOutButton.click();
        log.info("The 'LogOut' button was clicked");
    }
}

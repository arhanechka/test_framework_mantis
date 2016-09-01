package mantis.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Loki_ on 24.08.2016.
 */
public class LoginPage {
    public WebDriver driver;
    private static Logger log = LoggerFactory.getLogger(LoginPage.class);

    // Login
    @FindBy (name="username")
    private WebElement userName;

    // Passwort
    @FindBy (name="passwort")
    private WebElement passWort;

    // Submit
    @FindBy(className="button")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void clickLoginDev() {
        userName.clear();
        userName.sendKeys("");
        log.debug("Login as Dev was entered: {}", userName);
        passWort.clear();
        passWort.sendKeys("");
        log.debug("Pass as Dev was entered: {}", passWort);
        loginButton.click();
        log.info("The 'Login' button was submited");
    }

    public void clickLoginManager() {
        userName.clear();
        userName.sendKeys("");
        log.debug("Login as Manager was entered: {}", userName);
        passWort.clear();
        passWort.sendKeys("");
        log.debug("Pass as Manager was entered: {}", passWort);
        loginButton.click();
        log.info("The 'Login' button was submited");
    }


}

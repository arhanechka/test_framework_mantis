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
    private WebDriver driver;
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

    public LoginPage(WebDriver driver, WebElement userName, WebElement passwort, WebElement loginButton) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.userName = userName;
        this.passWort = passwort;
        this.loginButton = loginButton;
    }

    public void clickLoginDev(WebDriver driver, String login, String pass) {
        userName.clear();
        userName.sendKeys(login);
        log.debug("Login as Dev was entered: {}", userName);
        passWort.clear();
        passWort.sendKeys(pass);
        log.debug("Pass as Dev was entered: {}", passWort);
        loginButton.click();
        log.info("The 'Login' button was submited");
    }

    public void clickLoginManager(WebDriver driver, String login, String pass) {
        userName.clear();
        userName.sendKeys(login);
        log.debug("Login as Manager was entered: {}", userName);
        passWort.clear();
        passWort.sendKeys(pass);
        log.debug("Pass as Manager was entered: {}", passWort);
        loginButton.click();
        log.info("The 'Login' button was submited");
    }


}

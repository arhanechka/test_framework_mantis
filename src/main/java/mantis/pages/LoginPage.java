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

    // Password
    @FindBy (name="password")
    private WebElement password;

    // Submit
    @FindBy(className="button")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void clickLoginDev() {
        userName.clear();
        userName.sendKeys("dev_auto");
        log.debug("Login as Dev was entered: {}", userName);
        password.clear();
        password.sendKeys("Developer1");
        log.debug("Pass as Dev was entered: {}", password);
        loginButton.click();
        log.info("The 'Login' button was submited");

    }

    public void clickLoginManager() {
        userName.clear();
        userName.sendKeys("manager_auto");
        log.debug("Login as Manager was entered: {}", userName);
        password.clear();
        password.sendKeys("Manager1");
        log.debug("Pass as Manager was entered: {}", password);
        loginButton.click();
        log.info("The 'Login' button was submited");
    }

    public void clickLoginAdmin() {
        userName.clear();
        userName.sendKeys("admin_auto");
        log.debug("Login as Admin was entered: {}", userName);
        password.clear();
        password.sendKeys("Administr1");
        log.debug("Pass as Admin was entered: {}", password);
        loginButton.click();
        log.info("The 'Login' button was submited");
    }
    //get text on Logout button
    public String clickLogOut() {
        String getResult = loginButton.getText();
        return getResult;
    }
}

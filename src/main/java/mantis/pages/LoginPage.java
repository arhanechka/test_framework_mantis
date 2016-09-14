package mantis.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Loki_ on 24.08.2016.
 */
public class LoginPage extends AbstractPage {
    //private static Logger log = LoggerFactory.getLogger(LoginPage.class);
    private String URL = "http://manzhos.me/mantis/login_page.php";

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
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public LoginPage openUrl() {
        getDriver().get(URL);
        return this;
    }

    public LoginPage clickLoginDev() {
        userName.clear();
        userName.sendKeys("dev_auto");
        //log.debug("Login as Dev was entered: {}", userName);
        password.clear();
        password.sendKeys("Developer1");
        //log.debug("Pass as Dev was entered: {}", password);
        loginButton.click();
        //log.info("The 'Login' button was submited");
        return this;
    }

    public LoginPage clickLoginManager() {
        userName.clear();
        userName.sendKeys("manager_auto");
        //log.debug("Login as Manager was entered: {}", userName);
        password.clear();
        password.sendKeys("Manager1");
        //log.debug("Pass as Manager was entered: {}", password);
        loginButton.click();
        //log.info("The 'Login' button was submited");
        return this;
    }

    public LoginPage clickLoginAdmin() {
        userName.clear();
        userName.sendKeys("admin_auto");
        //log.debug("Login as Admin was entered: {}", userName);
        password.clear();
        password.sendKeys("Administr1");
        //log.debug("Pass as Admin was entered: {}", password);
        loginButton.click();
        //log.info("The 'Login' button was submited");
        return this;
    }

    //get text on Logout button
    public LoginPage textLoginButton() {
        loginButton.getText();
        return this;
    }

}

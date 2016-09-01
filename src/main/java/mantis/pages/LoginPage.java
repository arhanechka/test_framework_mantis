package mantis.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created by Олег on 24.08.2016.
 */
public class LoginPage {
    private WebDriver driver;
    private static Logger log = LoggerFactory.getLogger(LoginPage.class);
    String URL = "http://manzhos.me/mantis/login_page.php";
    // Login
    @FindBy (name="username")
    private WebElement userName;
    log.debug("Login was entered: {}", userName);
    // Passwort
    @FindBy (name="passwort")
    private WebElement pass;
    log.debug("Pass was entered: {}", pass);
    // Submit
    @FindBy(className="button")
    private WebElement loginButton;
    log.info("The 'Login' button was submited");

    public loginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
}

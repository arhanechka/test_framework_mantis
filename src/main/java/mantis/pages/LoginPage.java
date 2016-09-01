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

    // Passwort
    @FindBy (name="passwort")
    private WebElement passwort;

    // Submit
    @FindBy(className="button")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    private void getLogin(WebDriver driver, String login, String pass) {
        userName.clear();
        userName.sendKeys(login);
        log.debug("Login was entered: {}", userName);
        passwort.clear();
        passwort.sendKeys(pass);
        log.debug("Pass was entered: {}", passwort);
        loginButton.click();
        log.info("The 'Login' button was submited");
    }

}

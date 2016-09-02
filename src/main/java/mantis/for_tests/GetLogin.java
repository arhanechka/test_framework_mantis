package mantis.for_tests;

import mantis.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Loki_ on 31-Aug-16.
 */
public class GetLogin {
    private static Logger log = LoggerFactory.getLogger(LoginPage.class);
    public void getEnter(WebDriver driver, String login, String pass) {
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

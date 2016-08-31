package mantis.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Олег on 24.08.2016.
 */
public class LoginPage {
    private WebDriver driver;
    // Login
    @FindBy (name="username")
    private WebElement inputElement;
    // Passwort
    @FindBy (name="passwort")
    private WebElement inputElement;
    // Submit
    @FindBy(className="button")
    private WebElement inputElement;

    public loginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
}

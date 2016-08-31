package mantis.pages;

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
    private WebElement getInputElement;
    // Submit
    @FindBy (className="button")
    private WebElement getInputElement;

    public loginPage(WebDriver driver) {
        Pagefactory.initElements(driver, this);
        this.driver = driver;
    }
}

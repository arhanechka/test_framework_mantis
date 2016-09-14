package mantis.pages;



        import org.openqa.selenium.NoSuchElementException;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.support.FindBy;
        import org.openqa.selenium.support.PageFactory;

        import java.util.concurrent.TimeUnit;
        import org.slf4j.Logger;
        import org.slf4j.LoggerFactory;
/**
 * Created by Anya on 03.09.2016.
 */
public class PasswordConfirm extends AbstractPage {
    private WebDriver driver;
    private static Logger log = LoggerFactory.getLogger(PasswordConfirm.class);

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(name = "password_confirm")
    private WebElement passwordConfirm;

    @FindBy(xpath = "//input[@value='Update User']")
    private WebElement updateUser;

    @FindBy(xpath = "//div[text()[contains(.,'Password successfully updated')]]")
    private WebElement success;

    public PasswordConfirm(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public String passwordEntering(String pass){
        try{
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            password.sendKeys(pass);
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            passwordConfirm.sendKeys(pass);
            log.info("Password "+pass+" was typed");
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            updateUser.click();

            log.info("Password was confirmed");}
        catch (NoSuchElementException e){}
        return success.getText();
    }

}


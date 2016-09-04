package mantis.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class CreateUserChecking {public WebDriver driver;
    private static Logger log = LoggerFactory.getLogger(CreateUserChecking.class);

    // Login
    @FindBy(name="username")
    private WebElement userName;

    // email
    @FindBy (name="email")
    private WebElement email;

    // Submit
    @FindBy(className="button")
    private WebElement createUserButton;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(name = "password_confirm")
    private WebElement passwordConfirm;

    @FindBy(xpath = "//input[@value='Update User']")
    WebElement updateUser;

    @FindBy(xpath = "//div[text()[contains(.,'Password successfully updated')]]")
    WebElement success;

    public CreateUserChecking(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement creationChecking(String newName, String newEmail, By report) {
        userName.clear();
        userName.sendKeys(newName);
        email.clear();
        email.sendKeys(newEmail);
        createUserButton.click();
        return driver.findElement(report);
    }

}

package mantis.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class CreateUserCheckingPage extends AbstractPage {
    public WebDriver driver;
    private static Logger log = LoggerFactory.getLogger(CreateUserCheckingPage.class);

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

    @FindBy (xpath = "//a[text()[contains(.,'Logout')]]")
    WebElement logOut;


    public CreateUserCheckingPage(WebDriver driver) {

        super(driver);
        PageFactory.initElements(driver, this);
    }
    public CreateUserCheckingPage goToCreateUser (){
        new LoginPage(getDriver()).clickLoginAdmin();//enter as admin
        log.info("Enter as admin was successfull");
        new MyViewPage(getDriver()).goToManagePage();
        new ManagePage(getDriver()).goToManageUsersPage();
        new ManageUserPage(getDriver()).goToCreateUserCheckingPage();
        return this;}

    public String creationChecking(String newName, String newEmail) {
        this.goToCreateUser();
        userName.clear();
        userName.sendKeys(newName);
        email.clear();
        email.sendKeys(newEmail);
        createUserButton.click();
        String ddd=new WrongUserCreationPage(getDriver()).getMistakeText();
        logOut.click();
        return ddd;
    }

}

package mantis.for_tests;

import java.io.IOException;

import mantis.pages.*;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;

/**
 * Created by Loki_ on 01-Sep-16.
 */
public class BaseTestCase extends BaseTest{

    public CreateUserChecking createUserChecking;
    public LoginPage loginPage;
    public ManagePage managePage;
    public ManageProjectsPage manageProjectsPage;
    public MyViewPage myViewPage;
    public PasswordConfirm passwordConfirm;
    public SuccessfulLoginPage successfulLoginPage;


    @BeforeMethod
    public void getLogPage() throws InterruptedException, IOException {

        createUserChecking = new CreateUserChecking(getDriver());
        PageFactory.initElements(getDriver(), CreateUserChecking.class);

        loginPage = new LoginPage(getDriver());
        PageFactory.initElements(getDriver(), LoginPage.class);

        managePage = new ManagePage(getDriver());
        PageFactory.initElements(getDriver(), ManagePage.class);

        manageProjectsPage = new ManageProjectsPage(getDriver());
        PageFactory.initElements(getDriver(), ManageProjectsPage.class);

        myViewPage = new MyViewPage(getDriver());
        PageFactory.initElements(getDriver(), MyViewPage.class);

        passwordConfirm = new PasswordConfirm(getDriver());
        PageFactory.initElements(getDriver(), PasswordConfirm.class);

        successfulLoginPage = new SuccessfulLoginPage(getDriver());
        PageFactory.initElements(getDriver(), SuccessfulLoginPage.class);

    }
}

package mantis.for_tests;

import mantis.pages.*;
import mantis.utils.MailRuReader;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;


/**
 * Created by Loki_ on 01-Sep-16.
 */
public class BaseTestCase extends BaseTest{

    public CreateUserCheckingPage createUserChecking;
    public LoginPage loginPage;
    public ManagePage managePage;
    public ManageProjectsPage manageProjectsPage;
    public MyViewPage myViewPage;
    public PasswordConfirm passwordConfirm;
    public SuccessfulLoginPage successfulLoginPage;
    public CreateNewProjectPage createNewProjectPage;
    public ManageUserPage manageUserPage;
    public WrongUserCreationPage wrongUserCreationPage;
    public ValidateFieldsPage validateFieldsPage;
    public MailRuReader mailRuReader;
   // public ViewIssuesPage viewIssuesPage;
    @BeforeMethod
    public void getLogPage() {

        createUserChecking = new CreateUserCheckingPage(getDriver());
        PageFactory.initElements(getDriver(), CreateUserCheckingPage.class);

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

        createNewProjectPage = new CreateNewProjectPage(getDriver());
        PageFactory.initElements(getDriver(), CreateNewProjectPage.class);

        manageUserPage = new ManageUserPage(getDriver());
        PageFactory.initElements(getDriver(), ManageUserPage.class);

        wrongUserCreationPage = new WrongUserCreationPage(getDriver());
        PageFactory.initElements(getDriver(), WrongUserCreationPage.class);

        validateFieldsPage = new ValidateFieldsPage(getDriver());
        PageFactory.initElements(getDriver(), ValidateFieldsPage.class);

        viewIssuesPage = new ViewIssuesPage (getDriver ());
        PageFactory.initElements(getDriver(),ViewIssuesPage.class);

        mailRuReader = new MailRuReader(getDriver());
        PageFactory.initElements(getDriver(), MailRuReader.class);
    }

    @BeforeClass
    public void setUp() throws IOException {
        chooseBrowsers();
    }
}

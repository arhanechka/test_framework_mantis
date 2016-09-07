package mantis.for_tests;

import java.io.IOException;

import mantis.pages.CreateUserChecking;
import mantis.pages.LoginPage;
import mantis.pages.ManagePage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;

/**
 * Created by Loki_ on 01-Sep-16.
 */
public class BaseTestCase extends BaseTest{

    public CreateUserChecking createUserChecking;
    public LoginPage loginPage;
    public ManagePage managePage;


    @BeforeMethod
    public void getLogPage() throws InterruptedException, IOException {

        createUserChecking = new CreateUserChecking(getDriver());
        PageFactory.initElements(getDriver(), CreateUserChecking.class);

        loginPage = new LoginPage(getDriver());
        PageFactory.initElements(getDriver(), LoginPage.class);

        managePage = new ManagePage(getDriver());
        PageFactory.initElements(getDriver(), ManagePage.class);



    }
}

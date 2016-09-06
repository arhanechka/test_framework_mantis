package tests;

import mantis.for_tests.BaseTest;
import mantis.pages.LoginPage;
import mantis.pages.SuccessfulLoginPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

/**
 * Created by Loki_ on 02-Sep-16.
 */
public class LoginAdminTest extends BaseTest {
    private WebDriver driver;
    public static String expectedResult = "Logout";

    @Test
    public void loginTest() {
        LoginPage logPass = new LoginPage(driver);
        logPass.clickLoginAdmin();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        SuccessfulLoginPage sucLogin = new SuccessfulLoginPage(driver);
        sucLogin.clickLogOut();
        String actualResult = logPass.textLoginButton();

        Assert.assertEquals("Login as Admin", expectedResult, actualResult);
    }
}

package tests;

import mantis.for_tests.BaseTestCase;
import mantis.pages.LoginPage;
import mantis.pages.SuccessfulLoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Loki_ on 02-Sep-16.
 */
public class LoginAdminTest extends BaseTestCase {
    public static String expectedResult = "Logout";

    @Test
    public void loginTest() {
        LoginPage logPass = new LoginPage(getDriver());
        logPass.clickLoginAdmin();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        SuccessfulLoginPage sucLogin = new SuccessfulLoginPage(getDriver());
        sucLogin.clickLogOut();
        LoginPage actualResult = logPass.textLoginButton();

        Assert.assertEquals("Login as Admin", actualResult, expectedResult);
    }
}

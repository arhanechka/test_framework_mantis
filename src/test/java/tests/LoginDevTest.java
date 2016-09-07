package tests;

import mantis.for_tests.BaseTest;
import mantis.pages.LoginPage;
import mantis.pages.SuccessfulLoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Loki_ on 24.08.2016.
 */
public class LoginDevTest extends BaseTest {
    private static String expectedResult = "Logout";

    @Test
    public void loginTest() throws InterruptedException {
        LoginPage logPass = new LoginPage(getDriver());
        logPass.clickLoginDev();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        SuccessfulLoginPage sucLogin = new SuccessfulLoginPage(getDriver());
        sucLogin.clickLogOut();
        LoginPage actualResult = logPass.textLoginButton();


        Assert.assertEquals("Login as Dev", actualResult, expectedResult);
    }
}

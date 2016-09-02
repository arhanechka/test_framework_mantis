package tests;

import mantis.for_tests.BaseTest;
import mantis.pages.LoginPage;
import mantis.pages.SuccessfulLoginPage;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Loki_ on 24.08.2016.
 */
public class LoginDevTest extends BaseTest {
    private static String expectedResult = "Logout";

    @Test
    public void loginTest() throws InterruptedException {
        LoginPage logPass = new LoginPage(driver);
        logPass.clickLoginDev();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        SuccessfulLoginPage sucLogin = new SuccessfulLoginPage(driver);
        sucLogin.clickLogOut();
        String actualResult = logPass.chooseResult();


        Assert.assertEquals("Login as Dev", expectedResult, actualResult);
    }
}

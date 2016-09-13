package tests;

import mantis.for_tests.BaseTest;
import mantis.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Loki_ on 24.08.2016.
 */
public class LoginTest extends BaseTest {
    public static String expectedResult = "";

    @Test
    public void loginTest() {
        LoginPage logPass = new LoginPage(getDriver ());
        logPass.clickLoginDev();

        Assert.assertEquals("Login", expectedResult, "");
    }
}

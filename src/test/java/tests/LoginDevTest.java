package tests;

import mantis.for_tests.BaseTest;
import mantis.pages.LoginPage;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Loki_ on 24.08.2016.
 */
public class LoginDevTest extends BaseTest {
    public static String expectedResult = "";

    @Test
    public void loginTest() {
        LoginPage logPass = new LoginPage(driver);
        logPass.clickLoginDev();



        Assert.assertEquals("Login", expectedResult, "");
    }
}

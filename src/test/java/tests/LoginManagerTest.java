package tests;

import mantis.for_tests.BaseTest;
import mantis.pages.LoginPage;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Loki_ on 02-Sep-16.
 */
public class LoginManagerTest extends BaseTest {
    public static String expectedResult = "";

    @Test
    public void loginTest() {
        LoginPage logPass = new LoginPage(driver);
        logPass.clickLoginManager();



        Assert.assertEquals("Login as Manager", expectedResult, "");
    }
}

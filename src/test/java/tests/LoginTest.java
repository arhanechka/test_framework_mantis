package tests;

import mantis.for_tests.BaseTestCase;
import mantis.for_tests.GetLogin;
import mantis.pages.LoginPage;
import org.junit.Test;

/**
 * Created by Loki_ on 24.08.2016.
 */
public class LoginTest extends BaseTestCase {
    public static String expectedResult = "";

    @Test
    public void loginTest() {
        LoginPage logPass = new GetLogin();
        logPass.getEnterDev(driver, " ", " ");


    }
}

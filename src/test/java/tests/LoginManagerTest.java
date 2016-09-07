package tests;

import mantis.for_tests.BaseTest;
import mantis.pages.LoginPage;
import mantis.pages.SuccessfulLoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Loki_ on 02-Sep-16.
 */
public class LoginManagerTest extends BaseTest {
    private WebDriver driver;
    public static String expectedResult = "Logout";

    @Test
    public void loginTest() {
        LoginPage logPass = new LoginPage(driver);
        logPass.clickLoginManager();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        SuccessfulLoginPage sucLogin = new SuccessfulLoginPage(driver);
        sucLogin.clickLogOut();
        LoginPage actualResult = logPass.textLoginButton();

        Assert.assertEquals("Login as Manager", actualResult, expectedResult);
    }
}

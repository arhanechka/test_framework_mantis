package tests;

import mantis.for_tests.BaseTestCase;
import mantis.pages.LoginPage;
import mantis.pages.MyViewPage;
import mantis.pages.SuccessfulLoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Loki_ on 24.08.2016.
 */
public class LoginDevTest extends BaseTestCase {
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
        MyViewPage logout=new MyViewPage(getDriver());
        String actualResult = logout.getLogoutText();
        Assert.assertEquals(expectedResult, actualResult, "Login as Developer");
    }
}

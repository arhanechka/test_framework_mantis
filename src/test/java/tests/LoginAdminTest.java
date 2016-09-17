package tests;

import mantis.for_tests.BaseTest;
import mantis.for_tests.BaseTestCase;
import mantis.pages.LoginPage;
import mantis.pages.MyViewPage;
import mantis.pages.SuccessfulLoginPage;
import org.openqa.selenium.WebDriver;
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
        MyViewPage logout=new MyViewPage(getDriver());
        String actualResult = logout.getLogoutText();


        Assert.assertEquals(expectedResult, actualResult, "Login as Admin");
    }
}

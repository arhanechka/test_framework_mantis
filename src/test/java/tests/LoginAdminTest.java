package tests;

import mantis.for_tests.BaseTest;
import mantis.pages.LoginPage;
import mantis.pages.MyViewPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Loki_ on 02-Sep-16.
 */
public class LoginAdminTest extends BaseTest {
    public static String expectedResult = "Logout";

    @Test
    public void loginTest() {
        LoginPage logPass = new LoginPage(driver);
        logPass.clickLoginAdmin();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        MyViewPage logout=new MyViewPage(getDriver());
        String actualResult = logout.getLogoutText();

        Assert.assertEquals(actualResult, expectedResult, "Login as Admin");
    }
}

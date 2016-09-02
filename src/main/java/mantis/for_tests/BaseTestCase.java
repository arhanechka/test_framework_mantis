package mantis.for_tests;

import java.util.concurrent.TimeUnit;
import mantis.pages.LoginPage;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Loki_ on 01-Sep-16.
 */
public class BaseTestCase {
    public WebDriver driver;
    private String URL = "http://manzhos.me/mantis/login_page.php";


    @Before
    public void getLogPage() throws InterruptedException {

        PageFactory.initElements(driver, LoginPage.class);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(URL);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

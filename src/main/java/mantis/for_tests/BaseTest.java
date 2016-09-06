package mantis.for_tests;

import org.junit.Before;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


/**
 * Created by Loki_ on 23.08.2016.
 */
public class BaseTest {
    private WebDriver driver;

    @Before
    public void getLogPage() throws InterruptedException, IOException {

        ChooseBrowser browser = new ChooseBrowser();
        try {
            browser.chooseBrowsers();
        } catch (IOException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://manzhos.me/mantis/login_page.php");
        //PageFactory.initElements(driver, LoginPage.class);

    }

   // @After
   /* public void browseClose() {
        driver.close();
        driver.quit();
    } */

}

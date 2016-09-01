package mantis.for_tests;

import org.junit.After;
import org.openqa.selenium.WebDriver;



/**
 * Created by Loki_ on 23.08.2016.
 */
public class BaseTest {
    private WebDriver driver;




    @After
    public void browseClose() {
        driver.close();
        driver.quit();
    }

}

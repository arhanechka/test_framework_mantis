package mantis.for_tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;

import java.io.IOException;



/**
 * Created by Loki_ on 23.08.2016.
 */
public class BaseTest {
    private WebDriver driver;
    protected WebDriver getDriver() {
        return driver;
    }

    public void myBrowser() {
        ChooseBrowser browser = new ChooseBrowser();
        try {
            browser.chooseBrowsers();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterSuite
    public void browseClose() {
        driver.close();
        driver.quit();
    }

}

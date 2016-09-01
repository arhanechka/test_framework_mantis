package mantis.for_tests;

import edu.emory.mathcs.backport.java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


/**
 * Created by Олег on 23.08.2016.
 */
public class BaseTest {
    public WebDriver driver;
    public String URL = "";

    @Before
    public void getLogPage() throws InterruptedException {

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(URL);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @After
    public void browseClose() {
        driver.close();
        driver.quit();
    }

}

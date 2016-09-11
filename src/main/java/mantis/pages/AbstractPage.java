package mantis.pages;

import org.openqa.selenium.WebDriver;

/**
 * Created by Loki_ on 06.09.16.
 */
public class AbstractPage {
    private WebDriver driver;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    protected WebDriver getDriver() {
        return driver;
    }
}

package mantis.for_tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


/**
 * Created by Loki_ on 23.08.2016.
 */
public class BaseTest {
    protected WebDriver getDriver() {
        return driver;
    }

    private static final String sFileName = "testBrowser.properties";
    private static String sDirSeparator = System.getProperty("file.separator");
    private static Properties props = new Properties();
    public WebDriver driver;

    public WebDriver chooseBrowsers() throws IOException {
        File currentDir = new File(".");

        String sFilePath = currentDir.getCanonicalPath() + sDirSeparator + sFileName;
        FileInputStream ins = new FileInputStream(sFilePath);
        props.load(ins);
        //System.out.println(props.getProperty("BROWSER"));
        String browser = props.getProperty("BROWSER");

        switch (browser) {
            case "Chrome":
                return createChromeDriver();
            case "IE":
                return createInternetExplorerDriver();
            default:
                return createFirefoxDriver();
        }

    }
    private WebDriver createChromeDriver() {
        driver = new ChromeDriver();
        return driver;
    }
    private WebDriver createInternetExplorerDriver() {
        driver = new InternetExplorerDriver();
        return driver;
    }
    private WebDriver createFirefoxDriver() {
        driver = new FirefoxDriver();
        return driver;
    }

    @AfterSuite
    public void browseClose() {
        driver.close();
        driver.quit();
    }
}

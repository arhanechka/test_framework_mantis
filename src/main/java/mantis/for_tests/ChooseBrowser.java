package mantis.for_tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Loki_ on 31-Aug-16.
 */
public class ChooseBrowser {
    private static final String sFileName = "testBrowser.properties";
    private static String sDirSeparator = System.getProperty("file.separator");
    private static Properties props = new Properties();
    public WebDriver driver;

    public void chooseBrowsers() throws IOException {
        File currentDir = new File(".");

        String sFilePath = currentDir.getCanonicalPath() + sDirSeparator + sFileName;
        FileInputStream ins = new FileInputStream(sFilePath);
        props.load(ins);
        //System.out.println(props.getProperty("BROWSER"));
        String browser = props.getProperty("BROWSER");

        switch (browser) {
            case "Chrome":
                createChromeDriver();
            case "IE":
                createInternetExplorerDriver();
            default:
                createFirefoxDriver();
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
}

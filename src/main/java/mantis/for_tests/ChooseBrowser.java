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
        int browser = props.getProperty("BROWSER");

        /*if (browser.equals("Chrome")) {
            driver = new ChromeDriver();
        }
        if (browser.equals("FF")) {
            driver = new FirefoxDriver();
        }
        if (browser.equals("IE")) {
            driver = new InternetExplorerDriver();
        } */

        switch (browser) {
            case 1:
                driver = new ChromeDriver();
                break;
            case 2:
                driver = new FirefoxDriver();
                break;
            case 3:
                driver = new InternetExplorerDriver();
                break;
        }
    }
}

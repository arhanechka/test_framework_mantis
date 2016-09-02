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

    public void chooseBrowsers(WebDriver driver) throws IOException {
        File currentDir = new File(".");

        String sFilePath = currentDir.getCanonicalPath() + sDirSeparator + sFileName;
        FileInputStream ins = new FileInputStream(sFilePath);
        props.load(ins);
        System.out.println(props.getProperty("BROWSER"));
        String browser = props.getProperty("BROWSER");

        if (browser.equals("Chrome")) {
            driver = new ChromeDriver();
            return;
        }
        if (browser.equals("FF")) {
            driver = new FirefoxDriver();
            return;
        }
        if (browser.equals("IE")) {
            driver = new InternetExplorerDriver();
            return;
        }
    }
}

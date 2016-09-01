package mantis.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Евгения on 9/1/2016.
 */
public class MyViewPage {
    private WebDriver driver;
    private static Logger log = LoggerFactory.getLogger(MyViewPage.class);
   

    //The  "Manage" tab

    @FindBy(linkText = "Manage")
    private WebElement manageTab;



    public MyViewPage (WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    private MyViewPage goToManagePage (WebDriver driver) {
        manageTab.click();
        log.info("The 'Manage' tab was clicked");
        return this;

    }

}

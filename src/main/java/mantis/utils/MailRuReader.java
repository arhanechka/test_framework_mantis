package mantis.utils;



        import mantis.pages.PasswordConfirm;
        import org.openqa.selenium.By;
        import org.openqa.selenium.NoSuchElementException;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.support.FindBy;
        import org.openqa.selenium.support.PageFactory;
        import org.openqa.selenium.support.ui.ExpectedConditions;
        import org.openqa.selenium.support.ui.WebDriverWait;
        import org.slf4j.Logger;
        import org.slf4j.LoggerFactory;

        import java.util.concurrent.TimeUnit;

/**
 * Created by Anya 04.09.2016
 */
public class MailRuReader {
    private WebDriver driver;
    private  final String URL = "https://mail.ru/";
    private  final String login ="new_tests_for_selenium";
    private final String pas ="ABC_TESTERS";
    private  static String windowHadndler;
    private static Logger log = LoggerFactory.getLogger(MailRuReader.class);


    @FindBy(id="mailbox__login")
    private WebElement loginLoc;

    @FindBy(id="mailbox__password")
    private WebElement passwordLoc;

    @FindBy(id="mailbox__auth__button")
    private WebElement submitButton;

    @FindBy(xpath = "//div[text()[contains(.,'[MantisBT] Account registration')]]")
    private WebElement letter;

    @FindBy(partialLinkText = "http://www.manzhos.me/mantis/")
    WebElement activation;
    @FindBy(name = "password")
    private WebElement password;

    @FindBy(name = "password_confirm")
    private WebElement passwordConfirm;

    @FindBy(xpath = "//input[@value='Update User']")
    private WebElement updateUser;

    @FindBy(xpath = "//div[text()[contains(.,'Password successfully updated')]]")
    private WebElement success;

    @FindBy(xpath = "//div[@class='b-toolbar__btn b-toolbar__btn_false b-toolbar__btn_adaptive b-toolbar__btn_adaptive_rdm-mid b-toolbar__btn_false b-toolbar__btn_grouped b-toolbar__btn_grouped_first js-shortcut']")
    private WebElement delete;

    public MailRuReader(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

public void waitingLetter(){
    letter=(new WebDriverWait(driver,15000).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()[contains(.,'[MantisBT] Account registration')]]"))));
}
    public void mailEntering() {
        driver.get(URL);
        loginLoc.sendKeys(login);
        passwordLoc.sendKeys(pas);
        submitButton.click();}

    public void letterSearch()  {
        mailEntering();
        log.info("Enter to mail.ru inbox was successfull");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        waitingLetter();
        try{
            letter.click();
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            log.info("Letter from mantis was found"); }
        catch (NoSuchElementException e){}
    }

    public PasswordConfirm  letterActivation(){
        try{letterSearch();
            activation.click();
            log.info("Link from letter from mantis was found and clicked");
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        }
        catch (NoSuchElementException e){}
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        windowHadndler=driver.getWindowHandle();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        for (String winHandler: driver.getWindowHandles()){
            driver.switchTo().window(winHandler);}
        log.info("Change window to mantis");
        return new PasswordConfirm(driver);
    }

    public void letterDeleting() {
        driver.switchTo().window(windowHadndler);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        delete.click();
        log.info("Actication letter in mail.ru was deleted");
    }
}


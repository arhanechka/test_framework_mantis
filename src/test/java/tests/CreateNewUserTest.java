package tests;



        import mantis.pages.*;
        import mantis.utils.MailRuReader;
        import mantis.utils.RandomNames;
        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.slf4j.Logger;
        import org.slf4j.LoggerFactory;
        import org.testng.Assert;
        import org.testng.annotations.AfterClass;
        import org.testng.annotations.BeforeClass;
        import org.testng.annotations.BeforeMethod;
        import org.testng.annotations.Test;

        import java.util.concurrent.TimeUnit;

/**
 * Created by Anya on 02.09.2016.
 */
public class CreateNewUserTest {
    private static final String URL = "http://www.manzhos.me/mantis";
    private static final String URL1 = "http://www.manzhos.me/mantis/manage_user_create_page.php";
    private static WebDriver driver;
    private static LoginPage a; //first pageObject for enter
    private  static CreateUserChecking trying; //pageObject with fields for new user creation
    private  static RandomNames random=new RandomNames(); //class for creation random names and passwords
    By mistakeLocator=By.className("form-title");
    private  final String email ="selmanium@mail.ru";
    private  String randomLogin=random.getNewRandomName()+"_auto";
    private  static MailRuReader activator; //class for work with mail.ru
    private  static PasswordConfirm passConfirm; //pageObject where password confirms
    private static Logger log = LoggerFactory.getLogger(CreateNewUserTest.class);

    @BeforeClass
    public static void setUp() {
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(URL);
        a=new LoginPage(driver);
        a.clickLoginAdmin();//enter as admin
        log.info("Enter as admin was successfull");
        trying=new CreateUserChecking(driver);
        activator=new MailRuReader(driver);

    }
    @BeforeMethod
    public void openUrl() {

        driver.get(URL1);

    }
// Checking enter with empty dates
    @Test
    public void loginAsEmptyUser(){

        Assert.assertEquals(trying.creationChecking("","",mistakeLocator).getText(),"APPLICATION ERROR #11");
        log.info("Empty login and email were typed");
    }
    //Checking enter only with login
    @Test
    public void loginWithEmptyEmail(){
        String rand=random.getNewRandomName()+"_auto";
        Assert.assertEquals(trying.creationChecking(rand,"", mistakeLocator).getText(),"APPLICATION ERROR #1200");
        log.info("Empty email and login "+ rand+" were typed");
    }
   // Checking enter only with email
     @Test
    public void loginWithEmptyName(){

        Assert.assertEquals(trying.creationChecking("",email, mistakeLocator).getText(),"APPLICATION ERROR #11");
       log.info("Empty  login and email "+ email+" were typed");
    }
    //Checking enter with random login and wrong constructed email
    @Test
    public void loginWithWrongEmail(){
        String randomLog=random.getNewRandomName()+"_auto";
        String randomPassword=random.getNewRandomName();
        Assert.assertEquals(trying.creationChecking(randomLog,randomPassword, mistakeLocator).getText(),"APPLICATION ERROR #1200");
        log.info("login "+randomLog+" and email "+randomPassword+" were typed");
    }
    //Checking enter with random login and email mail.ru
    @Test
    public void withRightDates() {
        Assert.assertEquals(trying.creationChecking(randomLogin,email, By.xpath("//div[@align='center']")).getText(),"Created user "+randomLogin+" with an access level of reporter\n[ Proceed ]");
        log.info("login "+randomLogin+" and email "+email+" were typed");

        passConfirm=activator.letterActivation();
        String randomPassword=random.getNewRandomName();
        Assert.assertEquals(passConfirm.passwordEntering(randomPassword),"Password successfully updated\n" +"Operation successful.\n" + "[ Proceed ]");
        log.info("Password "+randomPassword+ " was successfully typed and user was created correctly");
        activator.letterDeleting();
        driver.get(URL);
        a.clickLoginAdmin();
        driver.get(URL1);
   }


    @AfterClass
    public static void tearDown() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }}}

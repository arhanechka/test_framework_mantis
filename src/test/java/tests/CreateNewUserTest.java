package tests;


        import org.junit.*;
        import mantis.pages.*;
        import mantis.utils.MailRuReader;
        import mantis.utils.RandomNames;
        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.slf4j.Logger;
        import org.slf4j.LoggerFactory;

        import java.util.concurrent.TimeUnit;

/**
 * Created by Anya on 02.09.2016.
 */
public class CreateNewUserTest {
    private static final String URL = "http://www.manzhos.me/mantis";
    private static final String URL1 = "http://www.manzhos.me/mantis/manage_user_create_page.php";
    private static WebDriver driver;
    private static LoginPage a;
    private  static String adminLogin="admin_auto";
    private static String adminPassword="Administr1";
    private  static CreateUserChecking trying;
    private  static RandomNames randomnames;
    By mistakeLocator=By.className("form-title");
    private  final String email ="tests_for_selenium@mail.ru";
    private  String randomLogin=randomnames.getNewRandomName()+"_auto";
    private  static MailRuReader activator;
    private  static PasswordConfirm passConfirm;
  //  private static Logger log = LoggerFactory.getLogger(CreateNewUserTest.class);

    @BeforeClass
    public static void setUp() {
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(URL);
        a=new LoginPage(driver);
        a.clickLoginAdmin(adminLogin,adminPassword);
     //   log.info("Enter as admin was successfull");
        trying=new CreateUserChecking(driver);
        activator=new MailRuReader(driver);
        randomnames=new RandomNames();
//passConfirm=activator.MailActivator();
    }
    @Before
    public void openUrl() {

        driver.get(URL1);

    }

    @Test
    public void loginAsEmptyUser(){

        Assert.assertEquals(trying.creationChecking("","",mistakeLocator).getText(),"APPLICATION ERROR #11");
     //   log.info("Empty login and email were typed");
    }
    @Test
    public void loginWithEmptyEmail(){
        String rand=randomnames.getNewRandomName()+"_auto";
        Assert.assertEquals(trying.creationChecking(rand,"", mistakeLocator).getText(),"APPLICATION ERROR #1200");
   //     log.info("Empty email and login "+ rand+" were typed");
         }
    @Test
    public void loginWithEmptyName(){

        Assert.assertEquals(trying.creationChecking("",email, mistakeLocator).getText(),"APPLICATION ERROR #11");
      //  log.info("Empty  login and email "+ email+" were typed");
             }
    @Test
    public void loginWithWrongEmail(){
        String randomLog=randomnames.getNewRandomName()+"_auto";
        String randomPassword=randomnames.getNewRandomName();
        Assert.assertEquals(trying.creationChecking(randomLog,randomPassword, mistakeLocator).getText(),"APPLICATION ERROR #1200");
    //    log.info("login "+randomLog+" and email "+randomPassword+" were typed");
        }
    @Test
    public void withRightDates() throws InterruptedException {
        Assert.assertEquals(trying.creationChecking(randomLogin,email, By.xpath("//div[@align='center']")).getText(),"Created user "+randomLogin+" with an access level of reporter\n[ Proceed ]");
     //   log.info("login "+randomLogin+" and email "+email+" were typed");
        passConfirm=activator.letterActivation();
        String randomPassword=randomnames.getNewRandomName();
        Assert.assertEquals(passConfirm.passwordEntering(randomPassword),"Password successfully updated\n" +"Operation successful.\n" + "[ Proceed ]");
   //     log.info("Password was successfully typed and user was created correctly");
        activator.letterDeleting();
        driver.get(URL);
        a.clickLoginAdmin(adminLogin,adminPassword);
        driver.get(URL1);
    }


@AfterClass
    public static void tearDown() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }}}

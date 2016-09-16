package tests;



        import mantis.for_tests.BaseTestCase;
        import mantis.pages.*;
        import mantis.utils.MailRuReader;
        import mantis.utils.RandomNames;
        import org.openqa.selenium.By;
        import org.slf4j.Logger;
        import org.slf4j.LoggerFactory;
        import org.testng.Assert;
        import org.testng.annotations.Test;

        import java.util.concurrent.TimeUnit;

/**
 * Created by Anya on 02.09.2016.
 */
public class CreateNewUserTest extends BaseTestCase {
    private  static RandomNames random=new RandomNames(); //class for creation random names and passwords
    By mistakeLocator=By.className("form-title");
    private  final String email ="selmanium@mail.ru";
    private  String randomLogin=random.getNewRandomName()+"_auto";
    private  static MailRuReader activator; //class for work with mail.ru
    private  static PasswordConfirm passConfirm; //pageObject where password confirms
    private static Logger log = LoggerFactory.getLogger(CreateNewUserTest.class);



       // activator=new MailRuReader(getDriver());


// Checking enter with empty dates
    @Test
    public void loginAsEmptyUser(){
        Assert.assertEquals(createUserChecking.creationChecking("",""),"APPLICATION ERROR #11");
        log.info("Empty login and email were typed");
    }
    //Checking enter only with login
    @Test
    public void loginWithEmptyEmail(){
        String rand=random.getNewRandomName()+"_auto";
        Assert.assertEquals(createUserChecking.creationChecking(rand,""),"APPLICATION ERROR #1200");
        log.info("Empty email and login "+ rand+" were typed");
    }
   // Checking enter only with email
     @Test
    public void loginWithEmptyName(){

        Assert.assertEquals(createUserChecking.creationChecking("",email),"APPLICATION ERROR #11");
       log.info("Empty  login and email "+ email+" were typed");
    }
    //Checking enter with random login and wrong constructed email
    @Test
    public void loginWithWrongEmail(){
        String randomLog=random.getNewRandomName()+"_auto";
        String randomPassword=random.getNewRandomName();
        Assert.assertEquals(createUserChecking.creationChecking(randomLog,randomPassword),"APPLICATION ERROR #1200");
        log.info("login "+randomLog+" and email "+randomPassword+" were typed");
    }
    //Checking enter with random login and email mail.ru
  /*  @Test
    public void withRightDates() {
        Assert.assertEquals(createUserChecking.creationChecking(randomLogin,email, By.xpath("//div[@align='center']")),"Created user "+randomLogin+" with an access level of reporter\n[ Proceed ]");
        log.info("login "+randomLogin+" and email "+email+" were typed");

        passConfirm=activator.letterActivation();
        String randomPassword=random.getNewRandomName();
        Assert.assertEquals(passConfirm.passwordEntering(randomPassword),"Password successfully updated\n" +"Operation successful.\n" + "[ Proceed ]");
        log.info("Password "+randomPassword+ " was successfully typed and user was created correctly");
        activator.letterDeleting();

   }


 */}

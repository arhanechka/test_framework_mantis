package tests;

import mantis.for_tests.BaseTestCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by sveta on 19.09.16.
 */
public class ValidateFieldsTest extends BaseTestCase {
    private static Logger log = LoggerFactory.getLogger (ValidateFieldsTest.class);

    @Test
    public void TestPassRequeriedFields() {
        validateFieldsPage.fillOutRequiredFields (
                "test summ",
                "test descr", "test steps",
                "test addInfo");
        driver.manage ().timeouts ().implicitlyWait (1, TimeUnit.SECONDS);
        Assert.assertEquals (driver.getTitle (), "View Issues - MantisBT");
        validateFieldsPage.logOut ();
    }


    //checking - not all of the required fields are mandatory
    @Test
    public void TestReportFailed() {
        validateFieldsPage.fillOutRequiredFields (
                "test summ",
                "test descr",
                "",
                "test addInfo");
        driver.manage ().timeouts ().implicitlyWait (1, TimeUnit.SECONDS);
        Assert.assertEquals (driver.getTitle (), "MantisBT");
        validateFieldsPage.logOut ();

    }



    @Test
    public void TestEmptyFields() {
        Assert.assertEquals (validateFieldsPage.
                        fillOutRequiredFields ("", "", "", ""),
                "APPLICATION ERROR #11");
        validateFieldsPage.logOut ();


    }



}
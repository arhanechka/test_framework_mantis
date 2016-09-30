package tests;

import mantis.for_tests.BaseTestCase;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by sveta on 19.09.16.
 */
public class ValidateFieldsTest extends BaseTestCase {
    private static Logger log = LoggerFactory.getLogger (ValidateFieldsTest.class);

    protected WebDriver getDriver() {
        return driver;
    }

    @Test
    public void TestPassRequeriedFields() throws InterruptedException {
        validateFieldsPage.fillOutRequiredFields (
                "test summ",
                "test descr",
                "test steps",
                "test addInfo");
               Thread.sleep (3000);
        Assert.assertEquals (viewIssuePage.getTitle (), "View Issues - MantisBT");
        viewIssuePage.logOut ();
        log.info ("TestPassRequeriedFields");


    }
//"View Issues - MantisBT");

        @Test
    public void TestReportFailed() {
        validateFieldsPage.fillOutRequiredFields (
                "test summ",
                "test descr",
                "",
                "test addInfo");
        validateFieldsPage.waitFor ();
        Assert.assertEquals (validateFieldsPage.getTitle (), "MantisBT");
        validateFieldsPage.logOut ();
        log.info ("TestPassRequeriedFields");

    }



    @Test
    public void TestEmptyFields() {
         validateFieldsPage.fillOutRequiredFields ("","","","");

         Assert.assertEquals (validateFieldsPage.getTitle (), "MantisBT");
        validateFieldsPage.logOut ();
        log.info ("TestPassRequeriedFields");


    }





}
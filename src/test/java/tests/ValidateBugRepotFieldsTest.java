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
public class ValidateBugRepotFieldsTest extends BaseTestCase {

    private static Logger log = LoggerFactory.getLogger (ValidateBugRepotFieldsTest.class);


    static WebDriver driver;


    @Test

    public void checkFillOutRequariedFields() {
        validateFieldsPage.fillOutRequiredFields (
                "test summ",
                "test descr",
                "test steps",
                "test addInfo");
        Assert.assertEquals (driver.getTitle (), "MantisBT");

        // Assert.assertEquals (driver.getTitle (), "View Issues - MantisBT");

        //"APPLICATION ERROR #11"); // тест проходит , так как не выполняется Select category


    }

    @Test

    public void checkInputEmptyData() {
        Assert.assertEquals (validateFieldsPage.fillOutRequiredFields ("", "", "", ""), "APPLICATION ERROR #11");
    }


}



package mantis.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by sveta on 24.09.16.
 */
public class WrongValidateFieldsPage extends AbstractPage {
    @FindBy (className="form-title")
    WebElement mistakeValidate;

    public WrongValidateFieldsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getMistakeText (){

  return mistakeValidate.getText();
    }
}




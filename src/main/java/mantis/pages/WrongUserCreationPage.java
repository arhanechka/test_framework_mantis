package mantis.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Anya on 16.09.2016.
 */
public class WrongUserCreationPage extends AbstractPage {
    @FindBy (className="form-title")
    WebElement mistakeCreation;

    public WrongUserCreationPage (WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);}

    public String getMistakeText (){
        return mistakeCreation.getText();
    }
}

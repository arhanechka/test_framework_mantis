package mantis.utils;

        import org.openqa.selenium.WebDriver;

        import java.util.Random;
        import org.slf4j.Logger;
        import org.slf4j.LoggerFactory;
/**
 * Created by Anya on 03.09.2016.
 */
public class RandomNames {
    private WebDriver driver;
    private String randomLogin;
    private static final String mCHAR = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
    private static final int STR_LENGTH = 5; // длина генерируемой строки
    Random random = new Random();
    private static Logger log = LoggerFactory.getLogger(RandomNames.class);

    public String getNewRandomName(){
        StringBuilder name = new StringBuilder();
        for (int i = 0; i < STR_LENGTH; i++) {
            int number = random.nextInt(mCHAR.length());
            char ch = mCHAR.charAt(number);
            name.append(ch);
        }
        randomLogin=name.toString();
        return randomLogin;
    }
}

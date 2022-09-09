package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BasicTest {
    public static WebDriver driver;
    public static Properties props;

    public BasicTest(){
        props = new Properties();
        try {
            FileInputStream inputStream = new FileInputStream(System.getProperty("user.dir") +
                    "src/test/config/config.properties");
            props.load(inputStream);
        }catch (FileNotFoundException fnf){
            fnf.printStackTrace();
        }catch(IOException io){
            io.printStackTrace();
        }
    }

    public static void initialize(){
        String browserName = props.getProperty("browser");

        if(browserName.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.driver.chrome", System.getProperty("user.dir")+"/src/test/driver/chromedriver.exe");
            driver = new ChromeDriver();
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get(props.getProperty("url"));
    }
}

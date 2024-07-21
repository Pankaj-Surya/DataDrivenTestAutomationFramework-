package base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
 
    public static WebDriver driver;
    public static Properties prop;
    
    
    public static void loadConfig() throws Exception {
        prop = new Properties();

        // Path to the config.properties file
        File config = new File(System.getProperty("user.dir") + "/src/test/resources/Configuration/config.properties");

        // Load properties from the file
        FileInputStream fis = new FileInputStream(config);
        prop.load(fis);
    }

    public static void launchApp() throws Exception {
    	loadConfig(); // Load configuration from config.properties
    	
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

    }

    public static void closeBrowser() {
        if (driver != null) {
            driver.close();
        }
    }

	
}

package base;

import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.BeforeScenario;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.MalformedURLException;

public class BaseTest {
    protected final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(getClass());

    protected static WebDriver driver;

    public String URL = System.getProperty("URL", "http://www.amazon.com");


    @BeforeScenario
    public void setUp() throws MalformedURLException, Exception {


        DesiredCapabilities capabilities;
        PropertyConfigurator.configure("src/test/resources/log4j.properties");
        Boolean isChromeDriver = true;

        if (isChromeDriver) {
            capabilities = DesiredCapabilities.chrome();
            ChromeOptions options = new ChromeOptions();
            capabilities.setCapability(ChromeOptions.CAPABILITY, options);
            options.addArguments("--start-fullscreen");
            System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
            driver = new ChromeDriver(capabilities);
        } else {

            System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver");
             capabilities=DesiredCapabilities.firefox();
            capabilities.setCapability("marionette", true);
             driver = new FirefoxDriver(capabilities);


        }

        driver.get(URL);
    }

    @AfterScenario
    public void tearDown() throws IOException {

        driver.quit();

    }
}
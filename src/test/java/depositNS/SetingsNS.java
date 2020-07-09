package depositNS;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SetingsNS {
    public ChromeDriver driver;
    public WebDriverWait wait;
    public  String primaryURL = "https://nsbroker.com/";


    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/drivers/chromedriver83.exe");

        driver = new ChromeDriver();
 //       driver.manage().window().setSize(new Dimension(1920,1080));
        driver.manage().window().maximize();

        System.out.println("start test");

    }

    @After
    public void quit(){
        System.out.println("End test");
        driver.quit();
    }
}

package signUp;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
   private WebDriver driver;
   private WebDriverWait wait;
    public MainPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver,10);
    }

  private By regButtonLocator = By.cssSelector("div.green");
  private By regFormLocator = By.name("registration-form");

    public void open(String link){
        driver.get(link);
    }
    public void getStarted(){
        driver.findElement(regButtonLocator).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(regFormLocator));
    }
    public void checkCurrentLink(String actLink){
        String curLink = driver.getCurrentUrl();
        Assert.assertEquals(curLink,actLink);
    }

}

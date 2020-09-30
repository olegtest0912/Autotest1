package depositFinmaxFX;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginFX {
    private WebDriver driver;
    private WebDriverWait wait;


    public LoginFX(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver,10);

    }

    @FindBy (name = "email")
    private WebElement email;

    @FindBy (name = "password")
    private WebElement password;


    private By frameTitle = By.cssSelector("iframe[title=\"bpwidgets_3\"]");
    private  By submitButton = By.cssSelector("[class=\"btn custom-btn btn-success pull-right\"]");

    public void loginToFX(String emailtext,String passwordtext){
        driver.get("https://finmax-fx.com/ru/login");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
        email.sendKeys(emailtext);
        password.sendKeys(passwordtext);
        driver.findElement(submitButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(((frameTitle))));
    }
}

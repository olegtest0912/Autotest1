package depositBO;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginToBO {
    private WebDriver driver;
    private WebDriverWait wait;


    public LoginToBO(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver,10);

    }

    @FindBy (name = "login_name")
    private WebElement email;

    @FindBy (name = "login_password")
    private WebElement password;


   /* private By frameTitle = By.cssSelector("iframe[title=\"bpwidgets_3\"]");
    private  By submitButton = By.cssSelector("[class=\"btn custom-btn btn-success pull-right\"]");*/

    public void loginToBo(String emailtext,String passwordtext) throws InterruptedException {


        driver.get("https://finmax-bo.com/ru");
        wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class=\"medals\"]")));
        WebElement ll = driver.findElement(By.cssSelector("[class=\"active\"]"));
        ll.findElement(By.cssSelector("[class=\"btn-enter\"]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("login_name")));





        try {
            email.sendKeys(emailtext);
            wait.until(ExpectedConditions.attributeToBe(email,"value",emailtext));
        }catch (TimeoutException e){
            System.out.println("catch email");
            email.sendKeys(Keys.CONTROL,"a");
            email.sendKeys(emailtext);
        }



        try {
            password.sendKeys(passwordtext);
            wait.until(ExpectedConditions.attributeToBe(password,"value",passwordtext));
        }catch (TimeoutException e){
            System.out.println("catch password");
            password.sendKeys(Keys.CONTROL,"a");
            password.sendKeys(passwordtext);
        }


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class=\"btn btn-primary\"]")));
        driver.findElement(By.cssSelector("[class=\"btn btn-primary\"]")).click();

        wait.until(ExpectedConditions.urlContains("trades"));

        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class=\"container\"]")));
       // String lonk = driver.getCurrentUrl();
        //  System.out.println(lonk);
        //Assert.assertEquals(lonk, "https://finmaxbo.com/ru/trades");
       /* WebDriver asas = driver.switchTo().frame(driver.findElement(By.cssSelector("[title=\"options_fe_1\"]")));
        Thread.sleep(3000);
        asas.findElement(By.cssSelector("[class=\"col-sm-12\"]"));
        System.out.println(asas);*/
    }
}

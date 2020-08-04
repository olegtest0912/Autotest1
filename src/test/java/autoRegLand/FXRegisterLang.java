package autoRegLand;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

public class FXRegisterLang {
    private WebDriver driver;
    private WebDriverWait wait;

    private By phone_element = By.cssSelector("input[name=\"phone\"]");
    private By email_element = By.cssSelector("input[name=\"email\"]");
    private By currency_element = By.cssSelector("[name=\"currency\"]");

    private By firstname_element = By.xpath("//*[contains(@name,'firstname') or contains(@name,'firstName')]");
    private By lastname_element = By.xpath("//*[contains(@name,'lastname') or contains(@name,'lastName')]");



    public FXRegisterLang(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver,5);
    }
    public String register(String url) throws InterruptedException {

        driver.get(url);


        int formnubmer = 0;
        try
        {
            System.out.println("form - " + formnubmer);
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("form"))).get(formnubmer);
        }
        catch (TimeoutException e) {
            formnubmer ++ ;
            System.out.println("form - " + formnubmer);
            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",driver.findElements(By.cssSelector("form")).get(formnubmer));
        }

        WebElement forms = driver.findElements(By.cssSelector("form")).get(formnubmer);
        forms.findElement(firstname_element).sendKeys("Testauto");
        forms.findElement(lastname_element).sendKeys("Testauto");

        Random random = new Random();
        String number = "545455" + (random.nextInt(999) + 100 );
        String rand_email = "Selenium" + (random.nextInt(99999) + 1000) + "@autotestfx.com";
        System.out.println(formnubmer);

        try
        {
            forms.findElement(email_element).sendKeys(rand_email);
            forms.findElement(phone_element).sendKeys(number);
        }
        catch (ElementNotInteractableException e) {
            driver.findElements(By.cssSelector("form")).get(formnubmer - 1).findElement(email_element).sendKeys(rand_email);
            driver.findElements(By.cssSelector("form")).get(formnubmer - 1).findElement(phone_element).sendKeys(number);
        }

        String currency;

        try {
             currency = forms.findElement(currency_element).getAttribute("value");

        }catch (NoSuchElementException e){

            currency = forms.findElement(By.xpath("//*[contains(@name,'currency') and contains(@type,'hidden')]")).getAttribute("value");
        }

        if (currency.equals("")){
           Thread.sleep(2000);
            wait.until(ExpectedConditions.elementToBeClickable(currency_element));
            forms.findElement(currency_element).click();
            forms.findElement(By.cssSelector("[value=\"usd\"]")).click();
            wait.until(ExpectedConditions.attributeToBe(currency_element,"value","usd"));
        }

        try{
            forms.findElement(By.cssSelector("[type=\"submit\"]"));
        } catch (NoSuchElementException e){
            forms.findElement(By.cssSelector("button"));
        }

        return rand_email;
    }

}

package autoRegLand;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

public class BoRegisterLang {
    private WebDriver driver;
    private WebDriverWait wait;

    public BoRegisterLang(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver,10);
    }
    public String register(String url) throws InterruptedException {

        driver.get(url);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("form")));
        List <WebElement> forms =  driver.findElements(By.cssSelector("form"));
        //forms.get(0).findElement(By.cssSelector("input[name=\"firstname\"]")).sendKeys("Testauto");
        forms.get(0).findElement(By.xpath("//*[contains(@name,'firstname') or contains(@name,'firstName')]")).sendKeys("Testauto");
        //forms.get(0).findElement(By.cssSelector("input[name=\"lastname\"]")).sendKeys("Testauto");
        forms.get(0).findElement(By.xpath("//*[contains(@name,'lastname') or contains(@name,'lastName')]")).sendKeys("Testauto");

        Random random = new Random();
        String number = "545455" + (random.nextInt(999) + 100 );
        String rand_email = "Selenium" + (random.nextInt(9999) + 1000) + "@autotestbo.com";
        forms.get(0).findElement(By.cssSelector("input[name=\"email\"]")).sendKeys(rand_email);

        forms.get(0).findElement(By.cssSelector("input[name=\"phone\"]")).sendKeys(number);

        String currency = forms.get(0).findElement(By.cssSelector("[name=\"currency\"]")).getAttribute("value");
        // System.out.println("currency" + currency);

        if (currency.equals("")){
           Thread.sleep(5000);

            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("select[name=\"currency\"]")));
            forms.get(0).findElement(By.cssSelector("select[name=\"currency\"]")).click();
            //wait.until(ExpectedConditions.elementToBeClickable(cur)).click();


           // wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("option[value=\"usd\"]")));
           forms.get(0).findElement(By.cssSelector("[value=\"usd\"]")).click();
            wait.until(ExpectedConditions.attributeToBe(By.cssSelector("[name=\"currency\"]"),"value","usd"));
        }
             forms.get(0).findElement(By.cssSelector("[type=\"submit\"]"));
        return rand_email;
    }

}

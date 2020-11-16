package depositBO;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class ClickPaymentBO {
    private WebDriver driver;
    private WebDriverWait wait;


    public ClickPaymentBO(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver,25);
    }

    private By button_deposit = By.cssSelector("#depositSubmitButton");


    public void checkDeposit(String paySystem, String amountValue)  {
        driver.get("https://finmax-bo.com/ru/deposit");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#"+paySystem)));
        driver.findElement(By.cssSelector("#"+paySystem)).click();
        driver.findElement(By.cssSelector("#amount")).sendKeys(Keys.CONTROL,"a");
        driver.findElement(By.cssSelector("#amount")).sendKeys(amountValue);
        driver.findElement(button_deposit).click();
    }

    public void checkStatus() throws IOException {
        URL url = new URL(driver.getCurrentUrl());
        HttpURLConnection http = (HttpURLConnection) url.openConnection();
       /* http.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/85.0.4183.102 Safari/537.36");
        http.setRequestProperty("Accept", "text/html");
        http.setRequestProperty("Accept-Language", "en-US");
        http.setRequestProperty("Connection", "close");
        http.setRequestProperty("redirectURL", "https://finmax-bo.com/ru/deposit");*/
        int response = http.getResponseCode();
        System.out.println("ResponseCode:" + response);
       /* Assert.assertFalse((response == 400)||(response == 404)||(response == 403));*/
        Assert.assertFalse((response == 404)||(response == 500));
    }
    public void checkPaysystem(String payLink)  {
      wait.until(ExpectedConditions.urlContains(payLink));
      System.out.println("actual link: " + driver.getCurrentUrl());
    }
}

package depositFinmaxFX;

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
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ClickPayment {
    private WebDriver driver;
    private WebDriverWait wait;

    public ClickPayment(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver,15);
    }

    private By button_deposit = By.cssSelector("button[class=\"btn w-100 custom-btn btn-success\"]");

    public void checkDeposit(String paySystem, String amountValue)  {
        driver.get("https://finmax-fx.com/ru/deposit");
        //wait
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[value=\""+paySystem+"\"]")));
        // select buttton
        WebElement button = driver.findElement(By.cssSelector("input[value=\""+paySystem+"\"]"));
        WebElement buttonParent = button.findElement(By.xpath("../.."));
        buttonParent.findElement(By.cssSelector("label[role=\"button\"]")).click();
        //amount
        driver.findElement(By.name("depositamount")).sendKeys(Keys.CONTROL,"a");
        driver.findElement(By.name("depositamount")).sendKeys(amountValue);
        //button click
        driver.findElement(button_deposit).click();
    }
    public void checkPaysystem(String payLink) throws InterruptedException {
        if(payLink.contains(payLink)){
           // Thread.sleep(5000);
            try {
                String oldTab = driver.getWindowHandle();
                System.out.println("run if");
                ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
               // newTab.remove(oldTab);
                System.out.println(newTab);
                driver.switchTo().window(newTab.get(1));
            }catch (IndexOutOfBoundsException e){
                System.out.println("catch");
                Thread.sleep(5000);
                String oldTab = driver.getWindowHandle();
                ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
                driver.switchTo().window(newTab.get(1));
            }
        }
      wait.until(ExpectedConditions.urlContains(payLink));
      System.out.println("actual link: " + driver.getCurrentUrl());
    }
    public void checkStatus() throws IOException {
        URL url = new URL(driver.getCurrentUrl());
        HttpURLConnection http = (HttpURLConnection) url.openConnection();
        int response = http.getResponseCode();
        System.out.println("ResponseCode:" + response);
        Assert.assertFalse((response == 400)||(response == 404)||(response == 403));
    }
}

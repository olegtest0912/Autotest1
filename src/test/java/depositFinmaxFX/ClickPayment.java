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
        driver.get("https://finmaxfx.com/ru/deposit");
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
    public void checkPaysystem(String payLink)  {
      wait.until(ExpectedConditions.urlContains(payLink));
      System.out.println("actual link: " + driver.getCurrentUrl());


    }
}

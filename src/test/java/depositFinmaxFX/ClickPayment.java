package depositFinmaxFX;

import org.junit.Assert;
import org.openqa.selenium.By;
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

    @FindBy (id = "my-account")
    private WebElement accountButton;

    @FindBy (name = "depositamount")
    private WebElement depositamount;



    private By depositButton = By.cssSelector("[class=\"fa fa-credit-card\"]");
    private By button_deposit = By.cssSelector("button[class=\"btn w-100 custom-btn btn-success\"]");

    public void clicktoDeposit()  {
        accountButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(depositButton));
        driver.findElement(depositButton).click();
    }
    public void checkDeposit(String paySystem, int amountValue)  {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[value=\""+paySystem+"\"]")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(button_deposit));

        WebElement button = driver.findElement(By.cssSelector("input[value=\""+paySystem+"\"]"));
        WebElement buttonParent = button.findElement(By.xpath("../.."));
        buttonParent.findElement(By.cssSelector("label[role=\"button\"]")).click();
        if((amountValue==50)){
            depositamount.clear();
        }else if((amountValue==5000)){
            depositamount.clear();
            depositamount.sendKeys("00");
        }else{
            WebElement buttonAmount = driver.findElement(By.cssSelector("input[value=\""+amountValue+"\"]"));
            WebElement buttonAmountParent = buttonAmount.findElement(By.xpath("../.."));
            buttonAmountParent.findElement(By.cssSelector("label[role=\"button\"]")).click();
        }
        driver.findElement(button_deposit).click();
    }

    public void checkPaysystem(String payLink)  {
      wait.until(ExpectedConditions.urlContains(payLink));
      System.out.println("actual link: " + driver.getCurrentUrl());
    }
}

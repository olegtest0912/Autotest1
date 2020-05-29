package depositBO;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ClickPaymentBO {
    private WebDriver driver;
    private WebDriverWait wait;

    public ClickPaymentBO(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver,15);
    }

    private By button_deposit = By.cssSelector("#depositSubmitButton");


    public void checkDeposit(String paySystem, String amountValue)  {
        driver.get("https://finmaxbo.com/ru/deposit");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#"+paySystem)));
        driver.findElement(By.cssSelector("#"+paySystem)).click();
        driver.findElement(By.cssSelector("#amount")).sendKeys(Keys.CONTROL,"a");
        driver.findElement(By.cssSelector("#amount")).sendKeys(amountValue);
        driver.findElement(button_deposit).click();
    }

    public void checkPaysystem(String payLink)  {
      wait.until(ExpectedConditions.urlContains(payLink));
      System.out.println("actual link: " + driver.getCurrentUrl());
    }
}

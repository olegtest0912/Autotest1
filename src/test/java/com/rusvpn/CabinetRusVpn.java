package com.rusvpn;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CabinetRusVpn {
    private WebDriver driver;
    private WebDriverWait wait;

    public CabinetRusVpn(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver,13);
    }

     @FindBy (css = ".this-submit-button")
    private WebElement submitButton;

    private By buttonToCabinet = By.cssSelector("div.data .button");

     public CabinetRusVpn clickToCabinet(){
         driver.findElement(buttonToCabinet).click();
         return this;
     }
     public void selectDatePlan(String date){
         wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("[class=\"c-order-plan t-"+date+"\"]")));
        driver.findElement(By.cssSelector("[class=\"c-order-plan t-"+date+"\"]")).click();
     }

     public CabinetRusVpn clickPayButtons(String buttonPay){
        if (buttonPay.equals("card")){
            driver.findElement(By.cssSelector(".this-submit-button")).click();
        }
        else {
            driver.findElement(By.cssSelector("[class=\"this-method-button this-"+buttonPay+"\"]")).click();
            submitButton.click();
        }
        return this;
     }
     public void checkPaySystems(String ExpPaySystem){
         wait.until(ExpectedConditions.urlContains(ExpPaySystem));
         System.out.println(driver.getCurrentUrl());
     }
}



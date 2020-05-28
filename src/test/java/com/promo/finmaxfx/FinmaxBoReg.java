package com.promo.finmaxfx;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class FinmaxBoReg extends WebElementSettingsFX {
    @Test
    public void registerBO() {
        String link = "https://finmaxbo.com/en/registration";
        driver.get(link);
        // driver.findElement(By.cssSelector("a[class=\"btn-red btn-main\"]")).click();
         wait = new WebDriverWait(driver,8);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class=\"registration\"]")));
        driver.findElementByName("firstname").sendKeys("TestSelenium");
        driver.findElementByName("lastname").sendKeys("SurnameSelenium");
        Random random = new Random();
        driver.findElementByName("phone").sendKeys("213123123"+(random.nextInt(9999) + 1000));
        String currency = "usd";
        String randomemail = "selenium123" + (random.nextInt(9999) + 1000) + "@qafinmax.com";
        System.out.println(randomemail);
        driver.findElementByName("currency").click();
        driver.findElement(By.cssSelector("[value=\""+ currency +"\"]")).click();
        driver.findElementByName("email").sendKeys(randomemail);
        driver.findElementByName("password1").sendKeys("123456Aa");
        driver.findElementByName("password2").sendKeys("123456Aa");
         driver.findElementByCssSelector("[class=\"fa fa-check\"]").click();
        driver.findElementByName("submit").click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class=\"alert alert-success\"]")));


    }
}

package com.promo.finmaxfx;
import org.openqa.selenium.By;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class RegisterTest extends WebElementSettingsFX {
    @Test
    public void register(){
        driver.get("https://tradeofficer.online/index.php");
        driver.findElementByCssSelector("[title=\"Einloggen\"]").click();
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("form")));
        Random random = new Random();
        String email = "tesgaghgh22agsa"+(random.nextInt(1000) + 1)+"@agmails.com";
        String number = "21312312" + (random.nextInt(10000) + 99999);
        System.out.println(email);
        System.out.println(number);
        driver.findElementByName("email").sendKeys(email);
        driver.findElementByName("firstname").sendKeys("TestTest");
        driver.findElementByName("lastname").sendKeys("SurnameTest");
        driver.findElementById("phone").sendKeys(number);
        driver.findElementByName("password1").sendKeys("123456Aa");
        driver.findElementByName("password2").sendKeys("123456Aa");
        driver.findElement(By.cssSelector("[type=\"submit\"]")).click();


    }

}

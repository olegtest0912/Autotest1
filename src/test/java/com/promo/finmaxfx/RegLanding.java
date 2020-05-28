package com.promo.finmaxfx;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class RegLanding extends WebElementSettingsFX {

    @Test
    public void test(){
        String link = "https://promo.finmaxbo.com/cryptoboom/index.php";
        driver.get(link);
       // driver.findElement(By.cssSelector("a[class=\"btn-red btn-main\"]")).click();

        driver.findElementById("firstname").sendKeys("TestSelenium");
        driver.findElementById("lastname").sendKeys("SurnameSelenium");
        Random random = new Random();
        String randomemail = "selenium123" + (random.nextInt(9999) + 1000) + "@qafinmax.com";
        //System.out.println(randomemail);
        driver.findElementById("email").sendKeys(randomemail);
        driver.findElementById("phone").sendKeys("213123123"+(random.nextInt(9999) + 1000));
        String currency = "mbt";
        driver.findElementById("currency").click();

        driver.findElement(By.cssSelector("[value=\""+ currency +"\"]")).click();
        WebElement checkbox = driver.findElementById("checkrules");
        System.out.println("Checkbox is "+ checkbox.isSelected());
        if (checkbox.isSelected())
            {
                driver.findElementById("submit").click();
            }
       wait = new WebDriverWait(driver,10);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class=\"alert alert-success\"]")));

            }

}

package depositNS;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;

public class LoginNS extends SetingsNS {

    private By btngrp = By.cssSelector(".btn-group");

    @Test
    public void loginNs() throws IOException {
        //login
        driver.get("https://new.nsbroker.com/en/login");
        wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(btngrp));
        driver.findElement(By.cssSelector("[name=\"login\"]")).sendKeys("hitherto@zorgkaartzeeland.com");
        driver.findElement(By.cssSelector("[name=\"password\"]")).sendKeys("123456Aa");
        WebElement area1 = driver.findElement(btngrp);
        area1.findElement(By.cssSelector("[type=\"submit\"]")).click();
       //wait.until(ExpectedConditions.urlToBe("https://new.nsbroker.com/en/deposit"));

        URL url = new URL(driver.getCurrentUrl());
        HttpURLConnection http = (HttpURLConnection) url.openConnection();
        int response = http.getResponseCode();
        Assert.assertTrue(response==200);
        System.out.println(response);

        wait.until(ExpectedConditions.urlToBe("https://new.nsbroker.com/en/dashboard"));

    }


}

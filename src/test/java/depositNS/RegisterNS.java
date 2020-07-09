package depositNS;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class RegisterNS extends SetingsNS {
    private By regButton = By.cssSelector(".btn-bordered");

    @Test
    public void registerNS(){
    driver.get(primaryURL);

        wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(regButton));

        driver.findElement(regButton).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class=\"form-vertical form-common\"]")));

        driver.findElementByName("name").sendKeys("TestSelenium");
        driver.findElementByName("surname").sendKeys("SurnameSelenium");
        Random random = new Random();
        driver.findElementByName("phone").sendKeys("213123123"+(random.nextInt(9999) + 1000));

        String randomemail = "selenium123" + (random.nextInt(9999) + 1000) + "@qansbroker.com";
        driver.findElementByName("email").sendKeys(randomemail);
        System.out.println(randomemail);

        driver.findElementByName("password").sendKeys("123456Aa");
        driver.findElementByName("password_confirmation").sendKeys("123456Aa");

        String currency = "usd";
        driver.findElementByName("currency").click();
        driver.findElement(By.cssSelector("[value=\""+ currency +"\"]")).click();

        driver.findElementByName("submit").click();


        //Personal account page
        wait.until(ExpectedConditions.urlToBe(primaryURL + "personal-details"));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#personal_details")));
        driver.findElementByName("firstname").sendKeys("TestSelenium");
        driver.findElementByName("lastname").sendKeys("TestSurname");
        // date
        driver.findElement(By.cssSelector("#datepicker")).click();
        driver.findElement(By.xpath(".//*[text()='5']/..")).click();

        //country
        driver.findElement(By.cssSelector("[value=\"by\"]")).click();
        //Status
        driver.findElement(By.cssSelector("[value=\"single\"]")).click();
        //children
        driver.findElement(By.cssSelector("[value=\"0\"]")).click();
        //phone
        driver.findElement(By.cssSelector("#phone_personal")).sendKeys("213123123"+(random.nextInt(9999) + 1000));
        //submit
        WebElement submit = driver.findElement(By.cssSelector("[class=\"form-group form-group-btn\"]"));
        submit.findElement(By.cssSelector("[type=\"submit\"]")).click();

        wait.until(ExpectedConditions.urlToBe(primaryURL +"account"));
    }
}

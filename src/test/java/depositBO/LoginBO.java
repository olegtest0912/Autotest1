package depositBO;

import com.promo.finmaxfx.WebElementSettingsFX;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginBO extends WebElementSettingsFX {
    private By button_deposit = By.cssSelector("#depositSubmitButton");
    @Test
    public void loginBo() throws InterruptedException {

        String mainlink = "https://finmaxbo.com/ru";
        driver.get(mainlink);
        wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class=\"medals\"]")));
        WebElement ll = driver.findElement(By.cssSelector("[class=\"active\"]"));
        ll.findElement(By.cssSelector("[class=\"btn-enter\"]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("login_name")));
        driver.findElementByName("login_name").sendKeys("olegtest0912@gmail.com");
        boolean ss = driver.findElementByName("login_name").isDisplayed();

        if (ss){
            driver.findElementByName("login_password").sendKeys("123456Aa");
        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class=\"btn btn-primary\"]")));
        driver.findElementByCssSelector("[class=\"btn btn-primary\"]").click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class=\"container\"]")));
        String lonk = driver.getCurrentUrl();
      //  System.out.println(lonk);
        Assert.assertEquals(lonk,mainlink + "/trades");
        WebDriver asas = driver.switchTo().frame(driver.findElement(By.cssSelector("[title=\"options_fe_1\"]")));
        Thread.sleep(3000);
        asas.findElement(By.cssSelector("[class=\"col-sm-12\"]"));
        System.out.println(asas);
        driver.get(mainlink + "/deposit");
        //driver.findElementByXPath("‘//div[@class=\"col-sm-12\"]/button’").click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#visa")));

        driver.findElement(By.cssSelector("#visa")).click();
        //driver.findElement(By.cssSelector("#amount")).clear();
        driver.findElement(By.cssSelector("#amount")).sendKeys(Keys.CONTROL,"a");
        driver.findElement(By.cssSelector("#amount")).sendKeys("150");
        driver.findElement(button_deposit).click();


    }
}

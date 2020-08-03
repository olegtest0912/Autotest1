package com.promo.finmaxfx;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;


public class FirstTest  extends WebElementSettingsFX {

/*
    @Test
    public void ruslinkTest() {

        //String[] links = new String[] {"https://promo.finmaxfx.com/robot/index-ru.php"};
        driver.get("https://promo.finmaxfx.com/robot/index-ru.php");
       // WebElement link = driver.findElement(By.cssSelector("[class=\"main-link\"]")).click();
       // driver.findElement(By.cssSelector("[class=\"main-link\"]")).click();
        //WebElement element = driver.findElement(By.cssSelector("[class=\"main-link\"]"));
        String element = driver.findElement(By.className("main-link")).getAttribute("href");
        // String text = element.getText();
        //element.click();
        //driver.findElement(By.className("main-link")).click();
       System.out.println(element);
       // String title = driver.getTitle();
       Assert.assertEquals(element,"https://finmaxfx.com/ru");



    }*/
   @Test
public void run ()throws IOException{

    String[] array = {
            "https://promo.finmaxfx.com/robot/index-en.php",
            "https://promo.finmaxfx.com/robot/index-ru.php",
            "https://promo.finmaxfx.com/robot/index-de.php"
    };
    for (String s : array) {
        englinkTest(s);
    }

}


    public void englinkTest(String s) throws IOException {
        //String[] links = new String[] { "http://ifmrrc.com/index.php?page=max_capital_2020","http://crofr.net/index.php?page=max_capital_2020"};
        URL url = new URL(s);
        HttpURLConnection http = (HttpURLConnection) url.openConnection();
        int response = http.getResponseCode();




        if (response == 200) {
            driver.get(s);
            wait = new WebDriverWait(driver, 10);

           // wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("main-link")));
            // String element = driver.findElement(By.cssSelector("a[class=\"crofr js-certificate-link\"]")).getAttribute("href");

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("firstname")));
            driver.findElementByName("lastname");
            driver.findElementByName("email");
            driver.findElementByName("phone");
            Assert.assertNull(driver.findElementByName("password"));

/*

            if (!(element.equals(links[0]) || element.equals(links[1]))) {
                System.out.print(element);
                System.out.println("    Fail link");
            }
*/

            // Assert.assertEquals(element, "https://finmaxfx.com/de");
            // return element.equals("https://finmaxfx.com/" + s);
        } else {
            System.out.println(s + "  WRONG STATUS");
        }
    }

    @Test
    public void forlanding() throws IOException, InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        BufferedReader reader = new BufferedReader(new FileReader("d:\\test.txt"));
        String str;

        ArrayList<String> list = new ArrayList<String>();
        while((str = reader.readLine()) != null ){
            if(!str.isEmpty()){
                list.add(str);
                //System.out.println(str);
            }}
        String[] stringArr = list.toArray(new String[0]);
      /*  String[] array = {
                "https://zyskztradingu.space/handel/index-pl.php",
                "https://stock-index.space/advisorwealth-ppc/",
                "https://stock-index.space/advisorwealth/",
             };*/

        for (String i : stringArr) {
           // System.out.println(i);
            driver.get(i);
            System.out.println(i);
            URL url = new URL(i);
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            int response = http.getResponseCode();
            System.out.println(response);

            Thread.sleep(2000);
            js.executeScript("window.scrollTo({" +
                    "    top: ((document.body.scrollHeight)/2)," +
                    "    behavior: \"smooth\"" +
                    "});");
            Thread.sleep(2000);
            js.executeScript("window.scrollTo({" +
                    "    top: document.body.scrollHeight," +
                    "    behavior: \"smooth\"" +
                    "});");
            Thread.sleep(2000);
            js.executeScript("window.scrollTo({" +
                    "    top: 0," +
                    "    behavior: \"smooth\"" +
                    "});");
            Thread.sleep(2000);

        }
    }



    }
    /*@Test
    public void delingTest(){
        driver.get("https://promo.finmaxfx.com/robot/index-de.php");
        String element = driver.findElement(By.className("main-link")).getAttribute("href");
        System.out.println("href = "+element);
        Assert.assertEquals(element,"https://finmaxfx.com/de");
    }*/




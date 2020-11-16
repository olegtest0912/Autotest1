package com.rusvpn;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class FbTestblog  {
    public ChromeDriver driver;
    public WebDriverWait wait;

@Test
    public void fbtest() throws IOException, InterruptedException {
    System.setProperty("webdriver.chrome.driver","src/main/resources/drivers/chromedriver85.exe");
    driver = new ChromeDriver();
    driver.manage().window().setSize(new Dimension(1920,1080));
    driver.manage().window().maximize();

        BufferedReader reader = new BufferedReader(new FileReader("d:\\fblist.txt"));

        String str;

        ArrayList<String> list = new ArrayList<String>();
        while((str = reader.readLine()) != null ){
            if(!str.isEmpty()){
                list.add(str);
                //System.out.println(str);
            }}
        String[] stringArr = list.toArray(new String[0]);
        for (String i : stringArr) {

                driver.get(i);


            //System.out.println(i);

       // wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class=\"fab fa-facebook\"]"))).click();

            Thread.sleep(1000);

            try {
                driver.findElement(By.cssSelector("[class=\"fab fa-facebook\"]")).click();
            } catch(NoSuchElementException e){
                System.out.println("not found" + i);
            }
            
            ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(newTab.get(1));
            String title = driver.getTitle();
            driver.close();

            driver.switchTo().window(newTab.get(0));
            if(title.contains("Error")){
                System.out.println(i);
            }

    }

    }

}

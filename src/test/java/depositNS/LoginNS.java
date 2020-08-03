package depositNS;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
;

public class LoginNS extends SetingsNS {

    private By btngrp = By.cssSelector(".btn-group");
    private By login_element = By.cssSelector("[name=\"login\"]");
    private By pass_element = By.cssSelector("[name=\"password\"]");



    @Test
    public void loginNs() throws IOException {
        //login
        driver.get(primaryURL+"login");
        wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(btngrp));
        //find elements
        driver.findElement(By.cssSelector("[name=\"login\"]")).sendKeys("olegtest0912@gmail.com");
        driver.findElement(By.cssSelector("[name=\"password\"]")).sendKeys("123456Aa");
        WebElement area1 = driver.findElement(btngrp);
        area1.findElement(By.cssSelector("[type=\"submit\"]")).click();
        // check response code
        URL url = new URL(driver.getCurrentUrl());
        HttpURLConnection http = (HttpURLConnection) url.openConnection();
        int response = http.getResponseCode();
        Assert.assertTrue(response==200);
        System.out.println(response);
        //wait dashboard page
        wait.until(ExpectedConditions.urlToBe(primaryURL + "dashboard"));
    }


    public void validation(String email,String password,String urllang,String explog,String exppass){
        driver.get(primaryURL + urllang);
        wait = new WebDriverWait(driver,50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(btngrp));
        driver.findElement(login_element).sendKeys(email);
        driver.findElement(pass_element).sendKeys(password);
        //find submit
        WebElement area1 = driver.findElement((btngrp));
        area1.findElement(By.cssSelector("[type=\"submit\"]")).click();
        //find and get text in validation fields
        String logvalid = driver.findElement(By.cssSelector("#userSigninLogin-error")).getText();
        String pasvalid = driver.findElement(By.cssSelector("#userSigninPassword-error")).getText();

        System.out.println(urllang + "\n" + logvalid + "\n" + pasvalid);
        //using equals,because other conditions not working
        Assert.assertTrue(logvalid.equals(explog));
        Assert.assertTrue(pasvalid.equals(exppass));
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));

    }

    public void невалидные_данные_юзера(String urllang,String expmessage) {
        driver.get(primaryURL + urllang);
        wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(btngrp));
        driver.findElement(login_element).sendKeys("test872y8172@tes.com");
        driver.findElement(pass_element).sendKeys("123456Aa");

        WebElement area1 = driver.findElement((btngrp));
        area1.findElement(By.cssSelector("[type=\"submit\"]")).click();
        //waiting alert
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String warning = alert.getText();
        //require!! alert need ti accept before Assert procedure
        alert.accept();
        System.out.println(urllang + "\n" + warning);
        Assert.assertTrue(warning.contains(expmessage));

    }

    @Test
    public void пустые_поля ()throws IOException{
        String pass = "";
        String email= "";

        String[][] array = {
                {"login","Please enter a valid email address","Please provide a password"},
                {"de/login","Bitte geben Sie eine gültige E-Mail-Adresse ein","Geben Sie ein Passwort ein"},
                {"es/login","Por favor, introduce una dirección de correo electrónico válida","Por favor ingrese una contraseña"},
                {"pt/login","Por favor, insira um e-mail válido","Por favor, insira uma password"},
                {"fr/login","S'il vous plaît, mettez une adresse email valide","S'il vous plaît fournir un mot de passe"},
                {"it/login","Si prega di inserire un indirizzo email valido","Si prega di fornire una password"},
                {"pl/login","Proszę wpisać aktualny adres e-mail","Podaj hasło"}
        };
        for (String[] s : array) {
            validation(email,pass,s[0],s[1],s[2]);
        }
    }
    @Test
    public void Пароль_меньше8 ()throws IOException{

        String pass = "111111";
        String email= "111111";

        String[][] array = {
                {"login","Please enter a valid email address","The password must be at least 8 characters"},
                {"de/login","Bitte geben Sie eine gültige E-Mail-Adresse ein","Das Passwort muss mindestens 8 Zeichen lang sein"},
                {"es/login","Por favor, introduce una dirección de correo electrónico válida","La contraseña debe tener al menos 8 caracteres"},
                {"pt/login","Por favor, insira um e-mail válido","A senha deve ter pelo menos 8 caracteres"},
                {"fr/login","S'il vous plaît, mettez une adresse email valide","Le mot de passe doit comporter au moins 8 caractères"},
                {"it/login","Si prega di inserire un indirizzo email valido","La password deve contenere almeno 8 caratteri"},
                {"pl/login","Proszę wpisać aktualny adres e-mail","Hasło musi mieć co najmniej 8 znaków"}
        };
        for (String[] s : array) {
            validation(email,pass,s[0],s[1],s[2]);
        }
    }
    @Test
    public void Пароль_между8и10 ()throws IOException{

        String pass = "111111111";
        String email= "11111111";

        String[][] array = {
                {"login","Please enter a valid email address","Password must contain 1 number and capital letter"},
                {"de/login","Bitte geben Sie eine gültige E-Mail-Adresse ein","Das Passwort muss 1 Nummer und Großbuchstaben enthalten"},
                {"es/login","Por favor, introduce una dirección de correo electrónico válida","La contraseña debe contener 1 número y mayúscula"},
                {"pt/login","Por favor, insira um e-mail válido","A senha deve conter 1 número e letra maiúscula"},
                {"fr/login","S'il vous plaît, mettez une adresse email valide","Le mot de passe doit contenir 1 chiffre et une majuscule"},
                {"it/login","Si prega di inserire un indirizzo email valido","La password deve contenere 1 numero e lettera maiuscola"},
                {"pl/login","Proszę wpisać aktualny adres e-mail","Hasło musi zawierać 1 cyfrę i dużą literę"}

        };
        for (String[] s : array) {
            validation(email,pass,s[0],s[1],s[2]);
        }
    }
    @Test
    public void Пароль_больше10 ()throws IOException{

        String pass = "11111111111";
        String email= "11111111";

        String[][] array = {
                {"login","Please enter a valid email address","Password must contain 1 number and capital letter"},
                {"de/login","Bitte geben Sie eine gültige E-Mail-Adresse ein","Das Passwort muss 1 Nummer und Großbuchstaben enthalten"},
                {"es/login","Por favor, introduce una dirección de correo electrónico válida","La contraseña debe contener 1 número y mayúscula"},
                {"pt/login","Por favor, insira um e-mail válido","A senha deve conter 1 número e letra maiúscula"},
                {"fr/login","S'il vous plaît, mettez une adresse email valide","Le mot de passe doit contenir 1 chiffre et une majuscule"},
                {"it/login","Si prega di inserire un indirizzo email valido","La password deve contenere 1 numero e lettera maiuscola"},
                {"pl/login","Proszę wpisać aktualny adres e-mail","Hasło musi zawierać 1 cyfrę i dużą literę"}

        };
        for (String[] s : array) {
            validation(pass,email,s[0],s[1],s[2]);
        }
    }

    @Test
    public void невалидные_данные_юзера ()throws IOException{

        String[][] array = {
                {"login","A user was not found with the given credentials."},
                {"de/login","A user was not found with the given credentials."},
                {"es/login","A user was not found with the given credentials."},
                {"pt/login","The details you entered did not match our records. Please double-check and try again."},
                {"fr/login","L'utilisateur saisie ne correspond à aucun utilisateur enregistré. Merci de vérifier votre saisie et de réessayer."},
                {"it/login","The details you entered did not match our records. Please double-check and try again."},
                {"pl/login","The details you entered did not match our records. Please double-check and try again."}
        };
        for (String[] s : array) {
            невалидные_данные_юзера(s[0],s[1]);
        }
    }
}

package signUp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name = "firstname")
    private WebElement firstname;

    @FindBy(name = "lastname")
    private WebElement lastname;

    @FindBy (name = "phone")
    private WebElement phone;

    @FindBy (name = "email")
    private WebElement email;

    @FindBy (name = "password1")
    private WebElement password1;

    @FindBy (name = "password2")
    private WebElement password2;

    @FindBy (name = "currency")
    private WebElement currency;

    @FindBy (name = "submit")
     private WebElement submit;

    private By checkbox = By.cssSelector("[class=\"fa fa-check\"]");
    private By alert = By.cssSelector("[class=\"alert alert-success\"]");


    public SignUpPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver,10);
    }

    public void fillFirstName(String name){
        firstname.sendKeys(name);
    }

    public void fillLastName(String surname){
        lastname.sendKeys(surname);
    }
    public void fillPhone(String phonenumber){
        phone.sendKeys(phonenumber);
    }

    public void fillEmail(String emailtext){
        email.sendKeys(emailtext);
    }

    public void fillPass1(String pass1){
        password1.sendKeys(pass1);
    }

    public void fillPass2(String pass2){
        password2.sendKeys(pass2);
    }

    public void selectCurrency(String selectcurrent){
        currency.click();
        driver.findElement(By.cssSelector("[value=\""+selectcurrent+"\"]")).click();
    }

    public void setCheckbox(){
        driver.findElement(checkbox).click();
    }

    public void clickSubmit(){
        submit.click();
    }
    public void checkAlert(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(alert));
    }

}

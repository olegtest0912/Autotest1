package depositFinmaxFX;

import com.promo.finmaxfx.WebElementSettingsFX;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

public class DepositFXBatic extends WebElementSettingsFX {

    //paysystems
    String certus = "https://api.certus.finance/";
    String accentpay = "https://zwmxm.playmeagame.com/";
    String paymentCenter = "https://paygatedirect.com/";
    String payboutique = "https://pay.qiwi.com/";
    String xpate = "https://m.xpate.com";

    //user data latvia
    String login = "Selenium1232@autotest.com";
    String password = "123456Aa";


    @Test
    public void depositFXVisa() {
        LoginFX loginFX = PageFactory.initElements(driver,LoginFX.class);
        loginFX.loginToFX(login,password);
        ClickPayment clickPayment = PageFactory.initElements(driver,ClickPayment.class);
        clickPayment.clicktoDeposit();
        clickPayment.checkDeposit("visa",250);
        clickPayment.checkPaysystem(certus);
    }
    @Test
    public void depositFXVisa2() {
        LoginFX loginFX = PageFactory.initElements(driver,LoginFX.class);
        loginFX.loginToFX(login,password);
        ClickPayment clickPayment = PageFactory.initElements(driver,ClickPayment.class);
        clickPayment.clicktoDeposit();
        clickPayment.checkDeposit("visa",1000);
        clickPayment.checkPaysystem(payboutique);
    }
    @Test
    public void depositFXVisa3() {
        LoginFX loginFX = PageFactory.initElements(driver,LoginFX.class);
        loginFX.loginToFX(login,password);
        ClickPayment clickPayment = PageFactory.initElements(driver,ClickPayment.class);
        clickPayment.clicktoDeposit();
      //  clickPayment.checkDeposit50or5000("visa","00");
        clickPayment.checkPaysystem(payboutique);
    }
    @Test
    public void depositFXMasterCard() {
        LoginFX loginFX = PageFactory.initElements(driver,LoginFX.class);
        loginFX.loginToFX(login,password);
        ClickPayment clickPayment = PageFactory.initElements(driver,ClickPayment.class);
        clickPayment.clicktoDeposit();
        clickPayment.checkDeposit("master",250);
        clickPayment.checkPaysystem(accentpay);
    }
    @Test
    public void depositFXMasterCard2() {
        LoginFX loginFX = PageFactory.initElements(driver,LoginFX.class);
        loginFX.loginToFX(login,password);
        ClickPayment clickPayment = PageFactory.initElements(driver,ClickPayment.class);
        clickPayment.clicktoDeposit();
        clickPayment.checkDeposit("master",1000);
        clickPayment.checkPaysystem(payboutique);
    }
    @Test
    public void depositFXMasterCard3() {
        LoginFX loginFX = PageFactory.initElements(driver,LoginFX.class);
        loginFX.loginToFX(login,password);
        ClickPayment clickPayment = PageFactory.initElements(driver,ClickPayment.class);
        clickPayment.clicktoDeposit();
        clickPayment.checkDeposit("master",2000);
        clickPayment.checkPaysystem(payboutique);
    }

}


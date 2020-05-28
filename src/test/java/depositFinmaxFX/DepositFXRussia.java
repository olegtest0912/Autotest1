package depositFinmaxFX;

import com.promo.finmaxfx.WebElementSettingsFX;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

public class DepositFXRussia extends WebElementSettingsFX {
    // user data Russia
    String login = "olegtest0912@gmail.com";
    String password = "1234567Aa";

    // paySystems
    String xpate = "https://m.xpate.com";
    String paymentCenter = "https://paygatedirect.com/";
    String certus = "https://api.certus.finance/";
    String accentpay = "https://zwmxm.playmeagame.com/";
    String payboutique = "https://pay.qiwi.com/";
    @Test
    public void depositFXVisa() {
        LoginFX loginFX = PageFactory.initElements(driver,LoginFX.class);
        loginFX.loginToFX(login,password);

        ClickPayment clickPayment = PageFactory.initElements(driver,ClickPayment.class);
        clickPayment.clicktoDeposit();
        clickPayment.checkDeposit("visa",250);
        clickPayment.checkPaysystem(payboutique);
    }
    @Test
    public void depositFXVisa2() {
        LoginFX loginFX = PageFactory.initElements(driver,LoginFX.class);
        loginFX.loginToFX(login,password);

        ClickPayment clickPayment = PageFactory.initElements(driver,ClickPayment.class);
        clickPayment.clicktoDeposit();
        clickPayment.checkDeposit("visa",1000);
        clickPayment.checkPaysystem(accentpay);
    }

    @Test
    public void depositFXVisa3() {
        LoginFX loginFX = PageFactory.initElements(driver,LoginFX.class);
        loginFX.loginToFX(login,password);

        ClickPayment clickPayment = PageFactory.initElements(driver,ClickPayment.class);
        clickPayment.clicktoDeposit();
        clickPayment.checkDeposit("visa",2000);
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
        clickPayment.checkPaysystem(paymentCenter);
    }
    @Test
    public void depositFXMir() {
        LoginFX loginFX = PageFactory.initElements(driver,LoginFX.class);
        loginFX.loginToFX(login,password);

        ClickPayment clickPayment = PageFactory.initElements(driver,ClickPayment.class);
        clickPayment.clicktoDeposit();

      //  clickPayment.checkDeposit50or5000("mir","");
        clickPayment.checkPaysystem(accentpay);
    }
    @Test
    public void depositFXMir2() {
        LoginFX loginFX = PageFactory.initElements(driver,LoginFX.class);
        loginFX.loginToFX(login,password);

        ClickPayment clickPayment = PageFactory.initElements(driver,ClickPayment.class);
        clickPayment.clicktoDeposit();
        clickPayment.checkDeposit("mir",250);
        clickPayment.checkPaysystem(payboutique);
    }
    @Test
    public void depositFXMir3() {
        LoginFX loginFX = PageFactory.initElements(driver,LoginFX.class);
        loginFX.loginToFX(login,password);

        ClickPayment clickPayment = PageFactory.initElements(driver,ClickPayment.class);
        clickPayment.clicktoDeposit();
        clickPayment.checkDeposit("mir",2000);
        clickPayment.checkPaysystem(payboutique);
    }

}

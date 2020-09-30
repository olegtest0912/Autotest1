package depositFinmaxFX;

import com.promo.finmaxfx.WebElementSettingsFX;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ParamDepoFX extends SettingsFX {
    @Parameterized.Parameters(name = "{0}"+" "+"{2}"+" "+"{3}")
    public static Collection<Object[]> data() {

        // Expected PaySystems
        String certus = "https://api.certus.finance/FE/rest/tx/purchase/w/execute";
        String accentpay = "https://cashier.paywallk.com/payment?payment_id";
        String paymentCenter = "https://paygatedirect.com/v2/webpay?token";
        String payboutique = "https://pay.qiwi.com/?token";
        String xpate = "https://m.xpate.com/p/";
        String payretail = "https://api.gateway.payretailers.com/v2/public/paywalls/landing";
        String paythrone = "https://checkout.paythrone.com/gui/?project";

        // User data by Countries
        String[] sng = {"Selenium4482@autotest.com","123456Aa"};
        String[] russia = {"etsttst213test@tsttest.com","123456Aa"};
        String[] other = {"Selenium8404@autotest.com","123456Aa"};
        String[] germany = {"Selenium1987@autotest.com","123456Aa"};
        String[] europe = {"ihedun44@gmail.com","123456Aa"};
        String[] baltic = {"Selenium1232@autotest.com","123456Aa"};
        String[] Austria_Swz = {"acceptaient@bronhit.info","123456Aa"};
        String[] UK = {"tafijeg913@openavz.com","123456Fx"};

        return Arrays.asList(new Object[][] {



                {"Sng",sng,"master","250",paythrone},


                {"Russia",russia,"visa","250",paythrone},


                }
        );
    }
    private String description;
    private String[] country;
    private String button;
    private String value;
    private String paySystem;

    public ParamDepoFX(String description, String[] country, String button,String value,String paySystem) {
        this.description = description;
        this.country = country;
        this.button = button;
        this.value = value;
        this.paySystem = paySystem;
    }

@Test
    public void depositFX () throws IOException, InterruptedException {
        LoginFX loginFX = PageFactory.initElements(driver,LoginFX.class);
        loginFX.loginToFX(country[0],country[1]);
        ClickPayment clickPayment = PageFactory.initElements(driver,ClickPayment.class);
        clickPayment.checkDeposit(button,value);
        clickPayment.checkPaysystem(paySystem);
        clickPayment.checkStatus();
    }
}



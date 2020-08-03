package depositFinmaxFX;

import com.promo.finmaxfx.WebElementSettingsFX;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.support.PageFactory;

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

                {"Sng",sng,"visa","250",paymentCenter},
                {"Sng",sng,"visa","1000",payboutique},
                {"Sng",sng,"visa","3100",payboutique},
                {"Sng",sng,"master","250",payboutique},
                {"Sng",sng,"master","1000",accentpay},

                {"Russia",russia,"visa","250",accentpay},
                {"Russia",russia,"visa","1000",payboutique},
                {"Russia",russia,"visa","2000",accentpay},
                {"Russia",russia,"master","250",payboutique},
                {"Russia",russia,"master","1000",paymentCenter},
                {"Russia",russia,"mir","50",accentpay},
                {"Russia",russia,"mir","1000",payboutique},
                {"Russia",russia,"mir","2000",payboutique},

                {"Baltic",baltic,"visa","250",certus},
                {"Baltic",baltic,"visa","1000",payboutique},
                {"Baltic",baltic,"visa","5000",payboutique},
                {"Baltic",baltic,"master","250",payboutique},
                {"Baltic",baltic,"master","1000",accentpay},
                {"Baltic",baltic,"master","2000",payboutique},


                {"Austia",Austria_Swz,"visa","250",certus},
                {"Austia",Austria_Swz,"visa","1000",accentpay},
                {"Austia",Austria_Swz,"master","250",accentpay},
                {"Austia",Austria_Swz,"master","1000",certus},

                {"Germany",germany,"visa","250",certus},
                {"Germany",germany,"visa","1000",accentpay},
                {"Germany",germany,"master","250",accentpay},
                {"Germany",germany,"master","1000",certus},

                {"Europe",europe,"visa","250",certus},
                {"Europe",europe,"visa","1000",accentpay},
                {"Europe",europe,"master","250",accentpay},
                {"Europe",europe,"master","1000",certus},

                {"Other",other,"visa","250",certus},
                {"Other",other,"visa","1000",certus},
                {"Other",other,"master","250",certus},
                {"Other",other,"master","1000",certus},

                {"uk",UK,"visa","200",certus},
                {"uk",UK,"visa","1600",certus},
                {"uk",UK,"master","200",certus},
                {"uk",UK,"master","1600",certus},

                {"Payretail",other,"payretailers","1000",payretail},
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
    public void depositFX () {
        LoginFX loginFX = PageFactory.initElements(driver,LoginFX.class);
        loginFX.loginToFX(country[0],country[1]);
        ClickPayment clickPayment = PageFactory.initElements(driver,ClickPayment.class);
        clickPayment.checkDeposit(button,value);
        clickPayment.checkPaysystem(paySystem);
    }
}



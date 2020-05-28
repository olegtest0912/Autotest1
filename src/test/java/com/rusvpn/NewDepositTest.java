package com.rusvpn;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class NewDepositTest extends SettingsRusVpn {
    //element classes
    String years_3 = "active t-3_year";
    String month_1 = "unactive t-1_month";
    String year_1 = "unactive t-1_year";
    //user data
    String login = "imadforit@gmail.com";
    String password = "121980";

    @Parameterized.Parameters(name = "{0}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {

                {"card","https://www2.1stpayments.net/ccdata.php"},
                {"usa","https://pay.fasterpay.com/payment/complete-order"},
                {"paypal","https://www.paypal.com/cgi-bin/webscr"}
        }
        );
    }
    private String paySystem;
    private String expSystem;

    public NewDepositTest( String paySystem, String expSystem) {
        this.paySystem = paySystem;
        this.expSystem = expSystem;
    }
    public void testPaySystem (String time){
        LoginRusVpn loginRusVpn = PageFactory.initElements(driver,LoginRusVpn.class);
        loginRusVpn.loginToRusVpn(login,password).clickButton(login);
        CabinetRusVpn cabinetRusVpn = PageFactory.initElements(driver,CabinetRusVpn.class);
        cabinetRusVpn.clickToCabinet().selectDatePlan(time);
        cabinetRusVpn.clickPayButtons(paySystem).checkPaySystems(expSystem);
    }

    @Test
    public void Check1year(){
        testPaySystem(year_1);
    }
    @Test
    public void Check3year(){
        testPaySystem(years_3);
    }
    @Test
    public void Check1Month(){
        testPaySystem(month_1);
    }
}
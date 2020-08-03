package autoRegLand;

import com.mashape.unirest.http.exceptions.UnirestException;
import depositFinmaxFX.ClickPayment;
import depositFinmaxFX.LoginFX;
import depositFinmaxFX.SettingsFX;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.Collection;


@RunWith(Parameterized.class)
public class BoLandings extends SettingsLand {
    @Parameterized.Parameters(name = "{0}")
    public static Collection<Object[]> data() {

        return Arrays.asList(new Object[][] {

                        {"https://trade-expert.site/kod-uspeha/"},
                        {"https://zyskztradingu.space/handel/index-pl.php"},
                        {"https://digital-trading.space/profit-trading-small/"},
                        {"https://stock-index.space/advisorwealth-ppc/"},
                        {"https://stock-index.space/advisorwealth/"},
                        {"https://top-investion.space/delo/"},
                        {"https://zyskztradingu.space/profit-trading/index-pl.php"},
                        {"https://zyskztradingu.space/time-bonus/index-pl.php"},
                        {"https://zyskztradingu.space/novice-pro/index-pl.php"},

                }
        );
    }
    private String url;

    public BoLandings(String url) {
        this.url = url;
    }

    @Test
    public void runBO  () throws InterruptedException, UnirestException {
        String aid = "?a_aid=957";
        BoRegisterLang boRegisterLang= PageFactory.initElements(driver,BoRegisterLang.class);
        String email = boRegisterLang.register(url + aid);
        System.out.println(email);

        CheckLeadBO checkLeadBO = PageFactory.initElements(driver,CheckLeadBO.class);
        checkLeadBO.checkApi(email);

    }
}


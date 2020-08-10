package autoRegLand.BO;

import autoRegLand.BO.CheckLeadBO;
import autoRegLand.RegisterLang;
import autoRegLand.SettingsLand;
import com.google.gson.reflect.TypeToken;
import com.mashape.unirest.http.exceptions.UnirestException;
import data.IParamsProvider;
import data.JsonParamsProvider;
import data.model.BoLandingData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;


@RunWith(Parameterized.class)
public class BoLandings extends SettingsLand {

    @Parameterized.Parameters()
    public static Collection<Object[]> data() {

        IParamsProvider<List<BoLandingData>> paramsProvider = new JsonParamsProvider<>("src/test/java/autoRegLand/Lists/landing_fx1.json", new TypeToken<List<BoLandingData>>() {
        }.getType());
        List<BoLandingData> savedData = paramsProvider.loadData();
        // check if saved data
        if (savedData == null || savedData.isEmpty()) {
            System.out.println("No param data in json. Make default and save");
            List<Object[]> defaultData = getDefaultData();

            ArrayList<BoLandingData> landingData = new ArrayList<>();
            for (Object[] objects : defaultData) {
                landingData.add(new BoLandingData(objects[0].toString()));
            }
            paramsProvider.saveData(landingData);
            return defaultData;
        } else {
            ArrayList<Object[]> data = new ArrayList<>();
            for (BoLandingData landingData : savedData) {
                data.add(new Object[]{landingData.getUrl()});
            }
            return data;
        }
    }

    private static List<Object[]> getDefaultData() {
        return Arrays.asList(new Object[][]{
                {"https://digital-trading.space/profit-trading-small/"},
                {"https://zyskztradingu.space/handel/index-pl.php"},
                {"https://stock-index.space/advisorwealth-ppc/"},
                {"https://stock-index.space/advisorwealth/"},
                {"http://top-investion.space/delo/"},
                {"https://zyskztradingu.space/profit-trading/index-pl.php"},
                {"https://zyskztradingu.space/time-bonus/index-pl.php"},
                {"https://zyskztradingu.space/novice-pro/index-pl.php"},
                {"https://zyskztradingu.space/free-signals/index-pl.php"},
                {"https://zyskztradingu.space/riskfree/index-pl.php"},
                {"https://polskihandel.space/"},
                {"https://popular-assets.space/profit-trading/index-ru.php"},
                {"https://digital-trading.space/bitcoin/"},
                {"https://digital-trading.space/cryptoboom/"},
                {"https://digital-trading.space/crypto-calculator/"},
                {"https://polskihandel.space/"},
                {"https://bonus-100.space/profit-trading-pl-small/"},
                {"https://miami-fresh.space/profit-trading-de-small/"},
                {"https://miami-fresh.space/profit-trading-en-small/"},
                {"https://zyskztradingu.space/riskfree/index-pl.php"},
                {"https://miami-fresh.space/profit-trading-en-small/"},
                {"https://miami-fresh.space/profit-trading-de-small/"},
                {"http://invest-in-stock.site/grow-capital/index-en.php"},
                {"https://gente-rica.space/capital/index-en.php"},
                {"http://bitcointraderobot.net/"},
                {"https://btc-codex.site/"},
                {"https://toptrade-online.space/platform-ppc/index-ru.php"},
                {"https://cash-boom.site/"},
                {"http://miami-fresh.space/profit-trading-small/"},
                {"https://stock-index.space/stock-index/index-ru.php"},
                {"https://stock-index.space/stock-index/index.php"},
                {"https://stock-index.site/contest/"},
                {"https://cash-boom.site/platform-ppc/"},
                {"https://top-investion.space/profit-trading/"},
                {"https://world-assets.space/finmax/"},
                {"https://stock-index.space/platform/"},
                {"http://invest-in-stock.site/grow-capital/index-en.php"},
                {"https://invest-in-stock.site/vergrobere/index-de.php"},
                {"https://gente-rica.space/capital/index-en.php"},
                {"http://fintrading-space.site/"},
                {"https://cash-boom.site/2020/"},
                {"https://fintrading.space/fin/"},
                {"https://fintrading.space/capital-new/"},
                {"https://profit-investments.site/"},
                {"https://fintrading.space/capital-new/"},
                {"https://stock-index.com/advisorwealth/de/"},
                {"https://stock-index.com/advisorwealth/en/"},
                {"https://stock-index.com/advisorwealth/es/"},
                {"https://stock-index.com/advisorwealth/ru/"},
                {"https://toptrade-online.space/bitcoin/"},
                {"https://toptrade-online.space/capital-new/"},
                {"https://gente-rica.space/era/"},
                {"https://toptrade-online.space/capital-new/"},
                {"https://toptrade-online.space/bitcoin/"},
                {"https://toptrade-online.space/crypto-calculator/"},
                {"https://toptrade-online.space/cryptoboom/index.php"},
                {"https://toptrade-online.space/platform-ppc/index-de.php"},
                {"https://toptrade-online.space/platform-ppc/index-ru.php"},
                {"https://btc-codex.site/"},
                {"https://popular-assets.space/profit-trading/index-ru.php"},
                {"https://fincapgroup.net/signals-telegram-bo/index-en.php"},
                {"https://fincapgroup.net/signals-telegram-bo/index-de.php"},
                {"https://guaranteed-profits.com/way-make-money/"},
                {"https://guaranteed-profits.com/promo-map/map/index.php"},
                {"https://guaranteed-profits.com/robot/index-de.php"},
                {"https://guaranteed-profits.com/promo-map/map/index.php"},
                {"https://guaranteed-profits.com/robot/index-de.php"},
                {"http://fin-group.space/platform-ppc/index-ru.php"},
                {"http://popular-assets.space/index-en.php"},
                {"https://fin-group.space/capital-new/index-de.php"},
                {"https://promo.finmaxbo.com/map/index.html"},
                {"https://promo.finmaxbo.com/map/index-de.html"},
                {"https://promo.finmaxbo.com/map/index-en.html"},
                {"https://promo.finmaxbo.com/platform-ppc/index-de.php"},
                {"https://promo.finmaxbo.com/platform-ppc/index-en.php"},
                {"http://maxtraffic.beget.tech/gente-rica/index.php"},
                {"http://maxtraffic.beget.tech/bo/4deals/de"},
                {"http://maxtraffic.beget.tech/bo/4deals/ru"},
                {"https://gane-1000.com/bo/4deals/de"},
                {"https://gane-1000.com/bo/4deals/ru"},
                {"https://gane-1000.com/bo/4deals/en"},
                {"http://gane-1000.com/bo/4deals/es"},
                {"http://maxtraffic.beget.tech/bo/4deals/es"},
                {"http://maxtraffic.beget.tech/profit-trading-max/index-de.php"},
                {"https://promo.finmaxbo.com/double-bonus/index-es.php"},
                {"https://promo.finmaxbo.com/double-bonus/index-de.php"},
                {"https://promo.finmaxbo.com/double-bonus/index-en.php"},
                {"https://promo.finmaxbo.com/double-bonus/index-ru.php"},
                {"http://maxtraffic.beget.tech/capital-new-max/index-en.php"},
                {"http://profi4trading.com/"},
                {"http://maxtraffic.beget.tech/popular-assets-max/index-en.php"},
                {"http://bitcoinprofitapplcom.com/"},
                {"http://maxtraffic.beget.tech/platform-ppc/index-ru.php"},
                {"https://promo.finmaxbo.com/robot/index-de.php"},
                {"https://promo.finmaxbo.com/robot/index-en.php"},
                {"https://promo.finmaxbo.com/robot/index-ru.php"},
                {"https://promo.finmaxbo.com/cryptoboom/index.php"},
                {"https://promo.finmaxbo.com/cryptoboom/index-hun.php"},
                {"https://promo.finmaxbo.com/cryptoboom/index-en.php"},
                {"https://promo.finmaxbo.com/cryptoboom/index-de.php"},
                {"https://promo.finmaxbo.com/platform-ppc/index-ru.php"},
                {"https://promo.finmaxbo.com/NewYear2020/new-year-de.php"},
                {"https://promo.finmaxbo.com/NewYear2020/new-year-en.php"},
                {"https://promo.finmaxbo.com/NewYear2020/new-year.php"},
                {"https://promo.finmaxbo.com/popular-assets/index-ru.php"},
                {"https://promo.finmaxbo.com/popular-assets/index-en.php"},
                {"https://promo.finmaxbo.com/popular-assets/index-de.php"},
                {"https://promo.finmaxbo.com/popular-assets/index-es.php"},
                {"https://promo.finmaxbo.com/popular-assets/index-pt.php"},
                {"https://promo.finmaxbo.com/popular-assets/index-ar.php"},
                {"https://promo.finmaxbo.com/assets/index-ru.php"},
                {"https://promo.finmaxbo.com/bitcoin/index-pt.php"},
                {"https://finmaxad.com/bo/crypto-calculator/pt"},
                {"https://finmaxad.com/bo/4deals/pt"},
                {"https://finmaxad.com/bo/4deals/es"},
                {"https://promo.finmaxbo.com/capital-new/index-pt.html"},
                {"https://promo.finmaxbo.com/bonus100/index-easy-pt.html"},
                {"https://promo.finmaxbo.com/contest/index-pt.html"},
                {"https://promo.finmaxbo.com/real-money/index-pt.php"},
                {"https://promo.finmaxbo.com/riskfree/index-pt.php"},
                {"https://promo.finmaxbo.com/real-money/index-es.php"},
                {"https://promo.finmaxbo.com/riskfree/index-es.php"},
                {"https://promo.finmaxbo.com/map/index-easy.html"},
                {"https://finmaxad.com/bo/marathon/de"},
                {"https://finmaxad.com/bo/marathon/en"},
                {"https://finmaxad.com/bo/marathon/ru"},
                {"http://finmaxonline.com/hot-signals-ppc/index-de.php"},
                {"http://finmaxonline.com/riskfree-ppc/index-de-new.php"},
                {"http://finmaxonline.com/bonus100-ppc/index-easy-en.php"},
                {"http://finmaxonline.com/riskfree-ppc/index-en.php"},
                {"https://promo.finmaxbo.com/NewYear2019/new-year-de.html"},
                {"https://promo.finmaxbo.com/NewYear2019/new-year-en.html"},
                {"https://promo.finmaxbo.com/NewYear2019/new-year.html"},
                {"https://promo.finmaxbo.com/more/index-ru.html"},
                {"https://promo.finmaxbo.com/more/index-en.html"},
                {"https://promo.finmaxbo.com/more/index-de.html"},
                {"https://promo.finmaxbo.com/maldives/index-de.html"},
                {"https://promo.finmaxbo.com/maldives/index-en.html"},
                {"https://promo.finmaxbo.com/maldives/index-ru.html"},
                {"https://promo.finmaxbo.com/ferrari-world/index-de.html"},
                {"https://promo.finmaxbo.com/ferrari-world/index-en.html"},
                {"https://promo.finmaxbo.com/ferrari-world/index-ru.html"},
                {"https://promo.finmaxbo.com/iphone/index-de.html"},
                {"https://promo.finmaxbo.com/iphone/index-en.html"},
                {"https://promo.finmaxbo.com/iphone/index-ru.html"},
                {"https://promo.finmaxbo.com/contest/index-de.html"},
                {"https://promo.finmaxbo.com/contest/index-en.html"},
                {"https://promo.finmaxbo.com/contest/index-ru.html"},
                {"https://promo.finmaxbo.com/halloween/index-de.html"},
                {"https://promo.finmaxbo.com/halloween/index-ru.html"},
                {"https://promo.finmaxbo.com/halloween/index-en.html"},
                {"https://finmaxad.com/bo/4deals/ru"},
                {"https://finmaxad.com/bo/way-make-money/ru"},
                {"https://promo.finmaxbo.com/bonus100-2/index-de.html"},
                {"https://promo.finmaxbo.com/cryptoboom/index-hun.html"},
                {"https://promo.finmaxbo.com/1000-on-demo/index-easy-en.html"},
                {"https://promo.finmaxbo.com/1000-on-demo2/index-de.html"},
                {"https://promo.finmaxbo.com/1000-on-demo2/index-en.html"},
                {"https://promo.finmaxbo.com/1000-on-demo2/index.html"},
                {"https://promo.finmaxbo.com/bonus100-2/index-en.html"},
                {"https://promo.finmaxbo.com/bonus100-2/index.html"},
                {"https://promo.finmaxbo.com/cryptoboom/index-de.html"},
                {"https://promo.finmaxbo.com/cryptoboom/index-en.html"},
                {"https://promo.finmaxbo.com/cryptoboom/index.html"},
                {"https://promo.finmaxbo.com/1000-on-demo/index-easy-de.html"},
                {"https://promo.finmaxbo.com/1000-on-demo/index-easy.html"},
                {"https://promo.finmaxbo.com/bonus100/index-easy-de.html"},
                {"https://promo.finmaxbo.com/bonus100/index-easy-en.html"},
                {"https://promo.finmaxbo.com/bonus100/index-easy.html"},
                {"https://finmaxad.com/bo/crypto-calculator/de"},
                {"https://promo.finmaxbo.com/bo/crypto-calculator/ru"},
                {"https://finmaxad.com/bo/crypto-calculator/en"},
                {"https://promo.finmaxbo.com/hot-signals/index-de.html"},
                {"https://promo.finmaxbo.com/hot-signals/index-en.html"},
                {"https://promo.finmaxbo.com/hot-signals/index.html"},
                {"https://promo.finmaxbo.com/no-risk2/no-risk2.html"},
                {"https://promo.finmaxbo.com/no-risk1/no-risk1.html"},
                {"https://promo.finmaxbo.com/riskfree-new/free-risk.html"},
                {"https://promo.finmaxbo.com/registration-form/w-250-popup-ar.php"},
                {"https://promo.finmaxbo.com/registration-form/w-250-popup-de.php"},
                {"https://promo.finmaxbo.com/registration-form/w-250-popup-en.php"},
                {"https://promo.finmaxbo.com/registration-form/w-250-popup.php"},
                {"https://promo.finmaxbo.com/bitcoin/index-ar.html"},
                {"https://promo.finmaxbo.com/bitcoin/index-de.html"},
                {"https://promo.finmaxbo.com/bitcoin/index-en.html"},
                {"https://promo.finmaxbo.com/bitcoin/index-it.html"},
                {"https://promo.finmaxbo.com/bitcoin/index-ru.html"},
                {"http://mycryptoplus.net"},
                {"https://promo.finmaxbo.com/socail-radar-new/index-ar.html"},
                {"https://promo.finmaxbo.com/socail-radar-new/index-it.html"},
                {"https://promo.finmaxbo.com/socail-radar-new/index-de.html"},
                {"https://promo.finmaxbo.com/socail-radar-new/index-en.html"},
                {"https://promo.finmaxbo.com/socail-radar-new/index.html"},
                {"https://promo.finmaxbo.com/capital-new/index-ar.html"},
                {"https://promo.finmaxbo.com/capital-new/index-de.html"},
                {"https://promo.finmaxbo.com/capital-new/index-it.html"},
                {"https://promo.finmaxbo.com/capital-new/index-en.html"},
                {"https://promo.finmaxbo.com/capital-new/index.html"},
                {"https://promo.finmaxbo.com/novice-pro/index-pl.html"},
                {"https://promo.finmaxbo.com/free-signals/index-pl.html"},
                {"https://promo.finmaxbo.com/novice-pro/index-it.html"},
                {"https://promo.finmaxbo.com/free-signals/index-it.html"},
                {"https://promo.finmaxbo.com/riskfree/index-it.html"},
                {"https://promo.finmaxbo.com/real-money/index-it.html"},
                {"https://promo.finmaxbo.com/riskfree/index-pl-new.html"},
                {"http://promo.finmaxbo.com/riskfree/index-pl.html"},
                {"https://promo.finmaxbo.com/novice-pro/index-ar.html"},
                {"https://promo.finmaxbo.com/riskfree/index-ar.html"},
                {"https://promo.finmaxbo.com/free-signals/index-ar.html"},
                {"https://promo.finmaxbo.com/free-signals/index-de.html"},
                {"https://promo.finmaxbo.com/riskfree/index-de-new.html"},
                {"https://promo.finmaxbo.com/real-money/index-de.html"},
                {"https://promo.finmaxbo.com/novice-pro/"},
                {"https://promo.finmaxbo.com/start/index.php"},
                {"https://promo.finmaxbo.com/promo-small/real-money/index-en.html"},
                {"https://promo.finmaxbo.com/riskfree/index-de.html"},
                {"https://promo.finmaxbo.com/real-money/index-en.html"},
                {"https://promo.finmaxbo.com/free-signals/index-en.html"},
                {"https://promo.finmaxbo.com/free-signals/"},
                {"https://promo.finmaxbo.com/real-money/"},
                {"https://promo.finmaxbo.com/riskfree/index-en.html"},
                {"https://promo.finmaxbo.com/riskfree/"}
        });
    }

    private String url;

    public BoLandings(String url) {
        this.url = url;
    }

    @Test
    public void runBO() throws InterruptedException, UnirestException {
        String aid = "?a_aid=957";
        System.out.println("\nURL:\n" + url + aid);

        RegisterLang registerLang = PageFactory.initElements(driver, RegisterLang.class);
        String email = registerLang.register(url + aid);
        System.out.println("\nGenerated email:\n" + email + "\n");

       // Thread.sleep();
        CheckLeadBO checkLeadBO = PageFactory.initElements(driver, CheckLeadBO.class);
        checkLeadBO.checkApi(email);
    }
}


package autoRegLand.FX;


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
public class FXLandings extends SettingsLand {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {

        IParamsProvider<List<BoLandingData>> paramsProvider = new JsonParamsProvider<>("src/test/java/autoRegLand/Lists/landing_fx.json", new TypeToken<List<BoLandingData>>() {
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
                    {"http://fxmasar.com"},


            });
        }

    private String url;

    public FXLandings(String url) {
        this.url = url;
    }

    @Test
    public void runFX() throws InterruptedException, UnirestException {
        String aid = "?a_aid=957";
        System.out.println("\nURL:\n" + url + aid);

        RegisterLang registerLang = PageFactory.initElements(driver, RegisterLang.class);
        String email = registerLang.register(url + aid);
        System.out.println("\nGenerated email:\n" + email + "\n");

        CheckLeadFX checkLeadFX = PageFactory.initElements(driver, CheckLeadFX.class);
        checkLeadFX.checkApi(email);
    }
}


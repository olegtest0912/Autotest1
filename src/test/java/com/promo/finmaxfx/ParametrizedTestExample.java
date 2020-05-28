package com.promo.finmaxfx;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ParametrizedTestExample extends WebElementSettingsFX {
    @Parameterized.Parameters(name = "{0}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { "bo","https://finmaxbo.com/ru", "опционы"}, { "fx","https://finmaxfx.com/ru", "брокер"}, { "ns","https://nsbroker.com/en/","broker"}
        });
    }
    private String description;
    private String pageURL;
    private String titleURL;


    public ParametrizedTestExample(String description,String pageURL, String titleURL) {
        this.description = description;
        this.pageURL = pageURL;
        this.titleURL = titleURL;

    }
    @Test
    public void testTitle() {
        driver.get(pageURL);
        String title =driver.getTitle();
        System.out.println(title);
        Assert.assertTrue(title.contains(titleURL));
    }

}
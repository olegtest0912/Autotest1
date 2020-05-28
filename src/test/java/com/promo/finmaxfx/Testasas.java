package com.promo.finmaxfx;

import org.junit.Test;

public class Testasas extends WebElementSettingsFX {
    @Test
    public void testasas(){
        driver.get("https://www.asas-group.org/research/");
        driver.findElementByCssSelector("[class=\"cc-imagewrapper cc-m-image-align-3\"]").click();
    }
}

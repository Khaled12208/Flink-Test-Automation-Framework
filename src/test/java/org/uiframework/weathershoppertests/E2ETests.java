package org.uiframework.weathershoppertests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.uiframework.framework.datahandler.DataFileType;
import org.uiframework.weathershopperpages.CartPage;
import org.uiframework.weathershopperpages.HomePage;
import org.uiframework.weathershopperpages.MoisturizersPage;
import org.uiframework.weathershopperpages.SunscreensPage;

public class E2ETests extends TestBase  {

    private HomePage homePage;
    private SunscreensPage sunscreensTests;
    private MoisturizersPage moisturizersPage;
    private CartPage cartPage;


    @Test
    public void UC01_ShoppingBasedOnTemp(){
        homePage = new HomePage(driver);
        sunscreensTests = new SunscreensPage(driver);
        moisturizersPage = new MoisturizersPage(driver);
        cartPage= new CartPage(driver);

        if (homePage.getCurrentTempValue()<19)
        {
            homePage.clickBuyMoisturizers();
            moisturizersPage.addToCardLeastExpensiveItemContains("Aloe");
            moisturizersPage.addToCardLeastExpensiveItemContains("almond");
            moisturizersPage.clickCart();
            Assert.assertTrue(cartPage.getPageTitle().equalsIgnoreCase("Checkout"));
        }
        else if (homePage.getCurrentTempValue()>34)
        {
            homePage.clickBuySunscreens();
            sunscreensTests.addToCardLeastExpensiveItemContains("SPF-50");
            sunscreensTests.addToCardLeastExpensiveItemContains("SPF-30");
            sunscreensTests.clickCart();
            Assert.assertTrue(cartPage.getPageTitle().equalsIgnoreCase("Checkout"));

        }

    }

}
